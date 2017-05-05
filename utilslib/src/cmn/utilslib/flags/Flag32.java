package cmn.utilslib.flags;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;

import cmn.utilslib.exceptions.FastException;
import cmn.utilslib.interfaces.Streamable;
import cmn.utilslib.validation.Validate;

/**
 * 

 * @author picatrix1899
 *
 */
public class Flag32 implements Streamable.Readable, Streamable.Writeable
{
	
	public static final int DIMENSIONS = 32;
	
	
	
	private int flag = 0;
	
	private int limit = DIMENSIONS;
	
	private HashMap<String, Integer> flags = new HashMap<String, Integer>();
	
	
	
	public Flag32() { reset(); }
	
	public Flag32(int limit) { setLimit(limit); }
	
	public Flag32(int flag, int limit) { setFlag32(flag); setLimit(limit); }
	
	
	
	public Flag32 setLimit(int limit)
	{
		Validate.isInRange(limit, 1, DIMENSIONS);
		
		this.limit = limit;
		
		return this;
	}
	
	public Flag32 setFlag(String name, boolean val)
	{
		if(this.flags.containsKey(name))
		{
			if(val)
			{
				this.flag = this.flag | this.flags.get(name);
			}
			else
			{
				this.flag = ~((~this.flag) | this.flags.get(name));
			}
		}
		else
		{
			if(addFlag(name))
			{
				setFlag(name, val);
			}
			else
			{
				FastException.print("Cannot set flag " + name + "! it doesnt exist and cannot be registered!");
			}
		}
		
		return this;
	}
	
	public Flag32 setFlag32(int flag)
	{
		this.flag = flag;
		
		return this;
	}
	
	public Flag32 reset()
	{
		this.flag = 0;
		
		return this;
	}
	
	
	
	public boolean addFlag(String name)
	{
		return addFlag0(name);
	}	
	
	
	
	public int getLimit()
	{
		return this.limit;
	}
	
	public boolean getFlag(String name)
	{
		if(this.flags.containsKey(name))
		{
			return getFlag0(this.flags.get(name));
		}
		else
		{
			FastException.print("The flag " + name + " doesnt exist!");
			
			return false;
		}
	}
	
	public int getFlag32()
	{
		return this.flag;
	}
	
	
	
	private boolean addFlag0(String name)
	{
		Validate.isBelow(this.flags.size(), getLimit() + 1);
		
		this.flags.put(name, (int)Math.pow(2, flags.size()));
			
		return true;
	}
	


	private boolean getFlag0(int i)
	{
		if((this.flag & i) == i)
		{
			return true;
		}
		
		return false;
	}
	
	
	
	@Override
	public String toString()
	{
		String out = "flag32(";
		String next = "";
	
		Iterator<String> it = this.flags.keySet().iterator();
		
		while(it.hasNext())
		{
			next = it.next();
			
			out += "\"" + next + "\"=" + getFlag(next);
			
			if(it.hasNext())
			{
				out += "; ";
			}
		}
		
		out += ")";
		
		return out;
	}
	
	
	
	public void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		setFlag32(dis.readInt());
	}
	
	
	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeInt(getFlag32());
	}
	
}

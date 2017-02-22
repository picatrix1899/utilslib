package cmn.utilslib.flags;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;

import cmn.utilslib.exceptions.FastException;
import cmn.utilslib.interfaces.IStreamable;
import cmn.utilslib.validation.Validate;

/**
 * 

 * @author picatrix1899
 *
 */
public class Flag64 implements IStreamable
{
	
	public static final int DIMENSIONS = 64;
	
	
	
	private long flag = 0;
	
	private int limit = DIMENSIONS;	
	
	private HashMap<String, Long> flags = new HashMap<String, Long>();
	
	
	
	public Flag64() { reset(); }
	
	public Flag64(long flag) { setFlag64(flag); }
	
	public Flag64(int limit) { setLimit(limit); }
	
	public Flag64(long flag, int limit) { setFlag64(flag); setLimit(limit); }
	
	
	
	public Flag64 setLimit(int limit)
	{
		Validate.isInRange(limit, 1, DIMENSIONS);
		
		this.limit = limit;
		
		return this;
	}
	
	public Flag64 setFlag(String name, boolean val)
	{
		if(this.flags.containsKey(name))
		{
			if(val)
			{
				this.flag = (long)(this.flag | this.flags.get(name));
			}
			else
			{
				this.flag = (long)(~((~this.flag) | this.flags.get(name)));
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
	
	public Flag64 setFlag64(long flag)
	{
		this.flag = flag;
		
		return this;
	}

	public Flag64 reset()
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

	public long getFlag64()
	{
		return this.flag;
	}
	
	
	
	private boolean addFlag0(String name)
	{
		Validate.isBelow(this.flags.size(), getLimit() + 1);
		
		this.flags.put(name, (long)Math.pow(2, flags.size()));
			
		return true;
	}
	
	
	
	private boolean getFlag0(long i)
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
		String out = "flag64(";
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
		setFlag64(dis.readLong());
	}
	
	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeLong(getFlag64());
	}

}

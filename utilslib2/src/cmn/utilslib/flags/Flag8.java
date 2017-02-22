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
public class Flag8 implements IStreamable
{
	
	public static final int DIMENSIONS = 8;
	
	
	
	private byte flag = 0;
	
	private int limit = DIMENSIONS;	
	
	private HashMap<String, Byte> flags = new HashMap<String, Byte>();
	

	
	public Flag8() { reset(); }
	
	public Flag8(byte flag) { setFlag8(flag); }
	
	public Flag8(int limit) { setLimit(limit); };
	
	public Flag8(byte flag, int limit) { setFlag8(flag); setLimit(limit); };
	
	
	
	public Flag8 setLimit(int limit)
	{
		Validate.isInRange(limit, 1, DIMENSIONS);
		
		this.limit = limit;
		
		return this;
	}
	
	public Flag8 setFlag(String name, boolean val)
	{
		if(this.flags.containsKey(name))
		{
			if(val)
			{
				this.flag = (byte)(this.flag | this.flags.get(name));
			}
			else
			{
				this.flag = (byte)(~((~this.flag) | this.flags.get(name)));
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
	
	public Flag8 setFlag8(byte flag)
	{
		this.flag = flag;
		
		return this;
	}	
	
	public Flag8 reset()
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
	
	public byte getFlag8()
	{
		return this.flag;
	}
	
	
	
	private boolean addFlag0(String name)
	{
		Validate.isBelow(this.flags.size(), getLimit() + 1);
		
		this.flags.put(name, (byte)Math.pow(2, flags.size()));
			
		return true;
	}
	
	
	
	private boolean getFlag0(byte i)
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
		String out = "flag8(";
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
		setFlag8(dis.readByte());
	}
	
	
	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeByte(getFlag8());
	}
	
}

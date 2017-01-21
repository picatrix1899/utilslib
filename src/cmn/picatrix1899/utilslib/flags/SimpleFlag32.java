package cmn.picatrix1899.utilslib.flags;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cmn.picatrix1899.utilslib.essentials.Validate;
import cmn.picatrix1899.utilslib.interfaces.DataHolder;

/**
 * 

 * @author picatrix1899
 *
 */
public class SimpleFlag32 implements DataHolder
{
	
	public static final int DIMENSIONS = 32;
	
	
	
	private int flag = 0;
	
	private int limit = DIMENSIONS;	
	

	
	public SimpleFlag32() { reset(); }
	
	public SimpleFlag32(int limit) { setLimit(limit); };
	
	public SimpleFlag32(int flag, int limit) { setFlag32(flag); setLimit(limit); };
	
	
	
	public SimpleFlag32 setLimit(int limit)
	{
		Validate.isInRange(limit, 1, DIMENSIONS);
		
		this.limit = limit;
		
		return this;
	}
	
	public SimpleFlag32 setFlag(int pos, boolean val)
	{
		Validate.isInRange(pos, 0, getLimit() - 1);
		
		if(val)
		{
			this.flag = (int)(this.flag | (byte)Math.pow(2, pos));
		}
		else
		{
			this.flag = (int)(~((~this.flag) | (byte)Math.pow(2, pos)));
		}
	
		return this;
	}
	
	public SimpleFlag32 setFlag32(int flag)
	{
		this.flag = flag;
		
		return this;
	}	
	
	public SimpleFlag32 reset()
	{
		this.flag = 0;
		
		return this;
	}
	
	
	
	public int getLimit()
	{
		return this.limit;
	}
	
	public boolean getFlag(int pos)
	{
		Validate.isInRange(pos, 0, getLimit() - 1);
		
		return getFlag0((int)Math.pow(2, pos));
	}
	
	public int getFlag32()
	{
		return this.flag;
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
		String out = "simpleFlag32(";

		for(int i = 0; i < getLimit(); i++)
		{
			out += "#" + i + "=" + getFlag(i);
				
			if(i != getLimit() - 1)
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

package cmn.utilslib.flags;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cmn.utilslib.interfaces.Streamable;
import cmn.utilslib.validation.Validate;

/**
 * 

 * @author picatrix1899
 *
 */
public class SimpleFlag16 implements Streamable.Readable, Streamable.Writeable
{
	
	public static final int DIMENSIONS = 16;
	
	
	
	private short flag = 0;
	
	private int limit = DIMENSIONS;	
	

	
	public SimpleFlag16() { reset(); }
	
	public SimpleFlag16(short flag) { setFlag16(flag); }
	
	public SimpleFlag16(int limit) { setLimit(limit); };
	
	public SimpleFlag16(short flag, int limit) { setFlag16(flag); setLimit(limit); };
	
	
	
	public SimpleFlag16 setLimit(int limit)
	{
		Validate.isInRange(limit, 1, DIMENSIONS);
		
		this.limit = limit;
		
		return this;
	}
	
	public SimpleFlag16 setFlag(int pos, boolean val)
	{
		Validate.isInRange(pos, 0, getLimit() - 1);
		
		if(val)
		{
			this.flag = (short)(this.flag | (byte)Math.pow(2, pos));
		}
		else
		{
			this.flag = (short)(~((~this.flag) | (byte)Math.pow(2, pos)));
		}

		return this;
	}
	
	public SimpleFlag16 setFlag16(short flag)
	{
		this.flag = flag;
		
		return this;
	}	
	
	public SimpleFlag16 reset()
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
		
		return getFlag0((short)Math.pow(2, pos));
	}
	
	public short getFlag16()
	{
		return this.flag;
	}
	
	
	
	private boolean getFlag0(short i)
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
		String out = "simpleFlag16(";
	
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
		setFlag16(dis.readShort());
	}
	
	
	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeShort(getFlag16());
	}

}

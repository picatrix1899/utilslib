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
public class SimpleFlag8 implements Streamable.Readable, Streamable.Writeable
{
	
	public static final int DIMENSIONS = 8;
	
	
	
	private byte flag = 0;
	
	private int limit = DIMENSIONS;	
	

	
	public SimpleFlag8() { reset(); }
	
	public SimpleFlag8(byte flag) { setFlag8(flag); }
	
	public SimpleFlag8(int limit) { setLimit(limit); };
	
	public SimpleFlag8(byte flag, int limit) { setFlag8(flag); setLimit(limit); };
	
	
	
	public SimpleFlag8 setLimit(int limit)
	{
		Validate.isInRange(limit, 1, DIMENSIONS);
		
		this.limit = limit;
		
		return this;
	}
	
	public SimpleFlag8 setFlag(int pos, boolean val)
	{
		Validate.isInRange(pos, 0, getLimit() - 1);
		
		if(val)
		{
			this.flag = (byte)(this.flag | (byte)Math.pow(2, pos));
		}
		else
		{
			this.flag = (byte)(~((~this.flag) | (byte)Math.pow(2, pos)));
		}

		return this;
	}
	
	public SimpleFlag8 setFlag8(byte flag)
	{
		this.flag = flag;
		
		return this;
	}	
	
	public SimpleFlag8 reset()
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
		
		return getFlag0((byte)Math.pow(2, pos));
	}
	
	public byte getFlag8()
	{
		return this.flag;
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
		String out = "simpleFlag8(";
	
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
		setFlag8(dis.readByte());
	}
	
	
	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeByte(getFlag8());
	}

}

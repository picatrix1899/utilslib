package cmn.utilslib.flags;


import cmn.utilslib.validation.Validate;

/**
 * 

 * @author picatrix1899
 *
 */
public class SimpleFlag64
{
	
	public static final int DIMENSIONS = 64;
	
	
	
	private long flag = 0;
	
	private int limit = DIMENSIONS;	
	

	
	public SimpleFlag64() { reset(); }
	
	public SimpleFlag64(long flag) { setFlag64(flag); }
	
	public SimpleFlag64(int limit) { setLimit(limit); };
	
	public SimpleFlag64(long flag, int limit) { setFlag64(flag); setLimit(limit); };
	
	
	
	public SimpleFlag64 setLimit(int limit)
	{
		Validate.isInRange(limit, 1, DIMENSIONS);
		
		this.limit = limit;
		
		return this;
	}
	
	public SimpleFlag64 setFlag(int pos, boolean val)
	{
		Validate.isInRange(pos, 0, getLimit() - 1);
		
		if(val)
		{
			this.flag = (long)(this.flag | (byte)Math.pow(2, pos));
		}
		else
		{
			this.flag = (long)(~((~this.flag) | (byte)Math.pow(2, pos)));
		}
			
		return this;
	}
	
	public SimpleFlag64 setFlag64(long flag)
	{
		this.flag = flag;
		
		return this;
	}	
	
	public SimpleFlag64 reset()
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
		
		return getFlag0((long)Math.pow(2, pos));
	}
	
	public long getFlag64()
	{
		return this.flag;
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
		String out = "simpleFlag64(";
	
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

}

package cmn.utilslib.flags;

import java.util.HashMap;
import java.util.Iterator;

import cmn.utilslib.exceptions.FastException;
import cmn.utilslib.validation.Validate;

/**
 * 

 * @author picatrix1899
 *
 */
public class Flag16
{

	public static final int DIMENSIONS = 16;
	
	
	
	private short flag = 0;
	
	private int limit = DIMENSIONS;
	
	private HashMap<String, Short> flags = new HashMap<String, Short>();
	
	
	
	public Flag16() { reset(); }
	
	public Flag16(short flag) { setFlag16(flag); }
	
	public Flag16(int limit) { setLimit(limit); }
	
	public Flag16(short flag, int limit) { setFlag16(flag); setLimit(limit); }
	
	
	
	public Flag16 setLimit(int limit)
	{
		
		Validate.isInRange(limit, 1, DIMENSIONS);
		
		this.limit = limit;
		
		return this;
	}
	
	public Flag16 setFlag(String name, boolean val)
	{
		if(this.flags.containsKey(name))
		{
			if(val)
			{
				this.flag = (short)(this.flag | this.flags.get(name));
			}
			else
			{
				this.flag = (short)(~((~this.flag) | this.flags.get(name)));
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
	
	public Flag16 setFlag16(short flag)
	{
		this.flag = flag;
		
		return this;
	}
	
	public Flag16 reset()
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
	
	public short getFlag16()
	{
		return this.flag;
	}
	
	
	
	private boolean addFlag0(String name)
	{
		Validate.isBelow(this.flags.size(), getLimit() + 1);		
		
		this.flags.put(name, (short)Math.pow(2, this.flags.size()));
			
		return true;
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
		String out = "flag16(";
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
	
}

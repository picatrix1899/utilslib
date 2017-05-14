package cmn.utilslib.lnbt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cmn.utilslib.essentials.Auto;

public class LNBTList implements LNBTBase, Serializable
{
	
	private static final long serialVersionUID = 1L;

	protected HashMap<String, LNBTBase> content = Auto.HashMap();	

	public LNBTBase get(String path)
	{
		String[] entries = path.split("\\.");
		
		ArrayList<String> paths = Auto.ArrayList(entries);
		
		return get(paths);
	}
	
	public LNBTBase get(List<String> paths)
	{
		if(paths.size() > 1)
		{
			LNBTList entry0;
			LNBTBase entry1 = this.content.get(paths.get(0));
			
			if(entry1 != null)
			{
				if(entry1 instanceof LNBTList)
				{
					entry0 = (LNBTList) entry1;
					
					paths.remove(0);
					
					return entry0.get(paths);
				}
				else
				{
					return null;
				}				
			}
			else
			{
				return null;
			}

		}
		else
		{
			if(this.content.containsKey(paths.get(0)))
			{
				return this.content.get(paths.get(0));
			}
			else
			{
				return null;
			}
		}
	}
	
	public boolean add(List<String> paths, LNBTBase value)
	{
		if(paths.size() > 1)
		{
			LNBTList entry0;
			LNBTBase entry1 = this.content.get(paths.get(0));
			
			if(entry1 != null)
			{
				if(entry1 instanceof LNBTList)
				{
					entry0 = (LNBTList) entry1;
					
					paths.remove(0);
					
					return entry0.add(paths, value);
				}
				else
				{
					return false;
				}				
			}
			else
			{
				this.content.put(paths.get(0), new LNBTList());
				
				entry0 = (LNBTList)this.content.get(paths.get(0));
				
				paths.remove(0);
				
				return entry0.add(paths, value);
			}

		}
		else
		{
			if(this.content.containsKey(paths.get(0)))
			{
				return false;
			}
			else
			{
				this.content.put(paths.get(0), value);
				return true;
			}
		}
	}
	
	public boolean add(String path, LNBTBase value)
	{
		String[] entries = path.split("\\.");
		
		ArrayList<String> paths = Auto.ArrayList(entries);
		
		return add(paths, value);
	}

	public boolean addByte(String path, Byte value)
	{
		return add(path, new LNBTByte(value));
	}
	
	public boolean addShort(String path, short value)
	{
		return add(path, new LNBTShort(value));
	}
	
	public boolean addInt(String path, int value)
	{
		return add(path, new LNBTInt(value));
	}
	
	public boolean addLong(String path, long value)
	{
		return add(path, new LNBTLong(value));
	}
	
	
	
	public boolean addFloat(String path, float value)
	{
		return add(path, new LNBTFloat(value));
	}
	
	public boolean addDouble(String path, double value)
	{
		return add(path, new LNBTDouble(value));
	}

	
	
	public boolean addChar(String path, char value)
	{
		return add(path, new LNBTChar(value));
	}

	public boolean addString(String path, String value)
	{
		return add(path, new LNBTString(value));
	}
	
	
	
	public boolean addBoolean(String path, boolean value)
	{
		return add(path, new LNBTBoolean(value));
	}


	
	public byte getByte(String path)
	{
		return contains(path) ? ((LNBTByte)get(path)).getValue() : 0;
	}
	
	public short getShort(String path)
	{
		return contains(path) ? ((LNBTShort)get(path)).getValue() : 0;
	}
	
	public int getInt(String path)
	{
		return contains(path) ? ((LNBTInt)get(path)).getValue() : 0;
	}
	
	public long getLong(String path)
	{
		return contains(path) ? ((LNBTLong)get(path)).getValue() : 0l;
	}
	
	public float getFloat(String path)
	{
		return contains(path) ? ((LNBTFloat)get(path)).getValue() : 0.0f;
	}
	
	public double getDouble(String path)
	{
		return contains(path) ? ((LNBTDouble)get(path)).getValue() : 0.0d;
	}
	
	public boolean getBoolean(String path)
	{
		return contains(path) ? ((LNBTBoolean)get(path)).getValue() : false;
	}
	
	public char getChar(String path)
	{
		return contains(path) ? ((LNBTChar)get(path)).getValue() : 0;
	}
	
	public String getString(String path)
	{
		return contains(path) ? ((LNBTString)get(path)).getValue() : "";
	}
	
	public LNBTList getList(String path)
	{
		return contains(path) ? ((LNBTList)get(path)) : null;
	}
	
	public boolean contains(String path)
	{
		LNBTBase base = get(path);
		
		return base != null;
	}
}

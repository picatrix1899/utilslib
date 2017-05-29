package cmn.utilslib.essentials;

import java.util.HashMap;
import java.util.List;

public class KeyedArrayList<T,V> extends HashMap<T,List<V>>
{
	private static final long serialVersionUID = 1L;

	
	public V putElement(T key, V value)
	{
		if(!containsKey(key))
		{
			put(key, Auto.ArrayList());
		}
		
		get(key).add(value);
		
		return value;
	}
	
	public V getElement(T key, int index)
	{
		if(containsKey(key))
		{
			if(Check.isInRange(0, get(key).size(), index))
			{
				return get(key).get(index);
			}
		}
		
		return null;
	}
	
	public V setElement(T key, int index, V value)
	{
		if(containsKey(key))
		{
			if(Check.isInRange(0, get(key).size(), index))
			{
				get(key).set(index, value);
			}
		}
		
		return value;
	}
	
}

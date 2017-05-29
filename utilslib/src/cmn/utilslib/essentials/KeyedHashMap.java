package cmn.utilslib.essentials;

import java.util.HashMap;

public class KeyedHashMap<T> extends HashMap<String, T>
{
	private static final long serialVersionUID = 1L;

	public T put(String key, T value)
	{
		return super.put(key.toLowerCase(), value);
	}
	
	public T get(String key)
	{
		return super.get(key.toLowerCase());
	}
}

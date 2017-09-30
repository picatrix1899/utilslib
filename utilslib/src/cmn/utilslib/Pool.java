package cmn.utilslib;

import java.util.ArrayDeque;
import java.util.Deque;


public class Pool<T>
{
	private final Deque<T> store = new ArrayDeque<T>();
	
	private final Class<T> clazz;
	
	public Pool(Class<T> clazz)
	{
		this.clazz = clazz;
	}
	
	public Pool(Class<T> clazz, int size)
	{
		this.clazz = clazz;
		
		try
		{
			for(int i = 0; i < size; i++)
			{
	
				this.store.add(this.clazz.newInstance());
	
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public T get()
	{
		if(this.store.size() > 0)
		{
			return this.store.pop();
		}
		
		try
		{
			return this.clazz.newInstance();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public void store(T t)
	{
		this.store.push(t);
	}
	
}

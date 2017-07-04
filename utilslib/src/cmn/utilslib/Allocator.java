package cmn.utilslib;

import java.util.ArrayDeque;
import java.util.Deque;


public class Allocator<T>
{
	private final Deque<T> store = new ArrayDeque<T>();
	
	private final Class<T> clazz;
	
	public Allocator(Class<T> clazz)
	{
		this.clazz = clazz;
	}
	
	public T alloc()
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
	
	public void dealloc(T t)
	{
		this.store.push(t);
	}
}

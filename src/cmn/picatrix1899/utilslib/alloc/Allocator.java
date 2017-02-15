package cmn.picatrix1899.utilslib.alloc;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class Allocator<T>
{
	private final ArrayList<T> stack = new ArrayList<T>();
	
	public T alloc(Class<? extends T> clazz)
	{
		try
		{		
			if(stack.size() > 0)
			{
				T out = stack.get(0);
				
				stack.remove(0);
				
				return out;
			}
			
			Constructor<? extends T> c;
			
			
			
			
			c = clazz.getConstructor();
				
			return (T) c.newInstance();	
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void release(T val)
	{
		stack.add(val);
	}
}

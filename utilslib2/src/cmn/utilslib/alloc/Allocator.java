
package cmn.utilslib.alloc;



import java.lang.reflect.Constructor;

import java.util.ArrayList;



/**
 * Provides methods for Type-Allocation
 * @author picatrix1899
 */
public class Allocator<T>
{
	
	private final ArrayList<T> stack = new ArrayList<T>();
	
	
	
	/**
	 * Allocates an instance of the given class
	 * @param clazz
	 * @return the allocated instance
	 */
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
	
	/**
	 * Stores the instance and keeps a strong reference on it to reuse it later
	 * @param val
	 */
	public void release(T val)
	{
		stack.add(val);
	}
	
}

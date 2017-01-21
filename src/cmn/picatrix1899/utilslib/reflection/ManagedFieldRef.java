package cmn.picatrix1899.utilslib.reflection;

import java.lang.reflect.Field;

import cmn.picatrix1899.utilslib.exceptions.SimpleErrorHandler;
import cmn.picatrix1899.utilslib.interfaces.ErrorHandler;

public class ManagedFieldRef<T>
{
	private String field;
	private Field f;
	private Object obj;
	private Class<?> clazz;
	
	private ErrorHandler handler;
	
	public ManagedFieldRef(String field, Class<?> clazz, Object object)
	{
		this.handler = new SimpleErrorHandler();
		
		this.field = field;
		this.clazz = clazz;
		this.obj = object;
		
		try
		{
			this.f = this.clazz.getDeclaredField(this.field);
			this.f.setAccessible(true);
		}
		catch(Exception e)
		{
			this.handler.handle(e);
		}
		
	}
	
	public void setErrorHandler(ErrorHandler handler)
	{
		this.handler = handler;
	}
	
	
	@SuppressWarnings("unchecked")
	public T get()
	{
		try
		{
			return (T) this.f.get(this.obj);	
		}
		catch(Exception e)
		{
			this.handler.handle(e);
			
			return null;
		}
	}
	
	public void set(T val)
	{
		try
		{
			this.f.set(this.obj, val);	
		}
		catch(Exception e)
		{
			this.handler.handle(e);
		}
		
	}
	
	@Override
	public void finalize() throws Throwable
	{
		this.f.setAccessible(false);
		super.finalize();
	}
}

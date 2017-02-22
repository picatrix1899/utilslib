package cmn.utilslib.reflection;

import java.lang.reflect.Field;

import cmn.utilslib.exceptions.IErrorHandler;
import cmn.utilslib.exceptions.SimpleErrorHandler;

public class ManagedFieldRef<T>
{
	private String field;
	private Field f;
	private Object obj;
	private Class<?> clazz;
	
	private IErrorHandler handler;
	
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
	
	public void setErrorHandler(IErrorHandler handler)
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

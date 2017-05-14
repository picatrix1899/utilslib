package cmn.utilslib.reflection;

import java.lang.reflect.Method;

import cmn.utilslib.exceptions.ErrorHandler;
import cmn.utilslib.exceptions.SimpleErrorHandler;

public class ManagedMethodRef<T>
{
	private Method m;
	private Object obj;
	
	private ErrorHandler handler;
	
	public ManagedMethodRef(Method m, Object obj)
	{
		this.handler = new SimpleErrorHandler();
		
		this.m = m;
		this.obj = obj;
	}
	
	public void setErrorHandler(ErrorHandler handler)
	{
		this.handler = handler;
	}
	
	public ManagedMethodRef(Object obj, String method, Class<?>... types) throws Exception
	{
		try
		{
			this.m = obj.getClass().getDeclaredMethod(method, types);
			this.obj = obj;
		}
		catch(Exception e)
		{
			this.handler.handle(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public T invoke(Object... params)
	{
		try
		{
			return (T) this.m.invoke(obj, params);
		}
		catch(Exception e)
		{
			this.handler.handle(e);
		}
		
		return null;
	}
	
}

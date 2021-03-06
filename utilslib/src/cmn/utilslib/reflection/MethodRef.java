package cmn.utilslib.reflection;

import java.lang.reflect.Method;

public class MethodRef<T>
{
	private Method m;
	private Object obj;
	
	public MethodRef(Method m, Object obj)
	{
		this.m = m;
		this.obj = obj;
	}
	
	public MethodRef(Object obj, String method, Class<?>... types) throws Exception
	{
		this.m = obj.getClass().getDeclaredMethod(method, types);
		this.obj = obj;
	}
	
	@SuppressWarnings("unchecked")
	public T invoke(Object... params) throws Exception
	{
		return (T) this.m.invoke(obj, params);
	}
	
}

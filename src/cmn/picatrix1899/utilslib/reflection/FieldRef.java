package cmn.picatrix1899.utilslib.reflection;

import java.lang.reflect.Field;

public class FieldRef<T>
{
	private String field;
	private Field f;
	private Object obj;
	private Class<?> clazz;
	
	public FieldRef(String field, Class<?> clazz, Object object) throws Exception
	{
		this.field = field;
		this.clazz = clazz;
		this.obj = object;
		
		this.f = this.clazz.getDeclaredField(this.field);
		this.f.setAccessible(true);
	}
		
	@SuppressWarnings("unchecked")
	public T get() throws Exception
	{
		return (T) this.f.get(this.obj);
	}
	
	public void set(T val) throws Exception
	{
		this.f.set(this.obj, val);
	}
	
	@Override
	public void finalize() throws Throwable
	{
		this.f.setAccessible(false);
		super.finalize();
	}
}

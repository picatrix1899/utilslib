package cmn.picatrix1899.utilslib.reflection;


public class Reflection
{
	public static <T> FieldRef<T> Field(String field, Class<?> clazz, Object o) throws Exception
	{
		return new FieldRef<T>(field, clazz, o);
	}
	
	public static <T> ManagedFieldRef<T> ManagedField(String field, Class<?> clazz, Object obj)
	{
		return new ManagedFieldRef<T>(field, clazz, obj);
	}
}

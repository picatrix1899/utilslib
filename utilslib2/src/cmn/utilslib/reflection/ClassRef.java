package cmn.utilslib.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import cmn.utilslib.essentials.Auto;

public class ClassRef<T>
{

	private Class<? extends T> c;
	
	public ClassRef(Class<? extends T> c)
	{
		this.c = c;
	}
	
	public List<Method> getMethodsByAnnotation(Class<? extends Annotation> annotation)
	{
		Method[] ms = this.c.getDeclaredMethods();
		
		ArrayList<Method> out = Auto.newArrayList();
		
		for(Method m : ms)
		{
			if(m.isAnnotationPresent(annotation))
			{
				out.add(m);
			}
		}
		
		return out;
	}
	
}

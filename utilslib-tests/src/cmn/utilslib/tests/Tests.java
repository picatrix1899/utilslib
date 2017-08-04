package cmn.utilslib.tests;

import java.io.PrintStream;
import java.lang.reflect.Method;

import cmn.utilslib.reflection.ClassRef;
import cmn.utilslib.reflection.MethodRef;
import cmn.utilslib.testing.IUnitTest;

public class Tests
{

	public static void main(String[] args)
	{
		try
		{

			printTest(TestDMapping2.class, System.out);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void printTest(Class<? extends IUnitTest> test, PrintStream stream)
	{
		try
		{
			IUnitTest t = test.newInstance();
			
			ClassRef<IUnitTest> ref = new ClassRef<IUnitTest>(test);
			
			stream.println(test.getSimpleName());
			stream.println();
			
			for(Method m : ref.getMethodsByAnnotation(IUnitTest.Test.class))
			{
				stream.println("FT>> " + m.getDeclaredAnnotation(IUnitTest.Test.class).value() + " : " + (new MethodRef<Boolean>(m, t).invoke() ? "passed" : "failed"));
			}
			
			stream.println();

			stream.println("================================================================");
			stream.println();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	
}

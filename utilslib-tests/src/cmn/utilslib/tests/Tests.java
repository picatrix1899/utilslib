package cmn.utilslib.tests;

import java.io.File;
import java.io.FileOutputStream;
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
			new File("test.txt").createNewFile();
			FileOutputStream fos = new FileOutputStream(new File("test.txt"));
			PrintStream ps = new PrintStream(fos);
			
			
			printTest(TestValidateIsTrue.class, ps);
			printTest(TestValidateIsFalse.class, ps);
			printTest(TestValidateNotTrue.class, ps);
			printTest(TestValidateNotFalse.class, ps);
			printTest(TestValidateIsTrueMulti.class, ps);
			printTest(TestValidateIsFalseMulti.class, ps);
			printTest(TestValidateIsTrueOOO.class, ps);
			printTest(TestValidateIsFalseOOO.class, ps);
			printTest(TestValidateIsAbove.class, ps);
			
			fos.flush();
			fos.close();
			
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
				stream.println(m.getDeclaredAnnotation(IUnitTest.Test.class).value() + " : " + (new MethodRef<Boolean>(m, t).invoke() ? "passed" : "failed"));
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

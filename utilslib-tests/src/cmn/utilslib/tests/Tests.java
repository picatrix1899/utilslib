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
			
			printTest(TestValidateIsTrue.class, new PrintStream(fos));
			System.out.println("completed");
			printTest(TestValidateIsFalse.class, new PrintStream(fos));
			System.out.println("completed");
			printTest(TestValidateNotTrue.class, new PrintStream(fos));
			System.out.println("completed");
			printTest(TestValidateNotFalse.class, new PrintStream(fos));
			System.out.println("completed");
			printTest(TestValidateIsTrueMulti.class, new PrintStream(fos));
			System.out.println("completed");
			printTest(TestValidateIsFalseMulti.class, new PrintStream(fos));
			System.out.println("completed");
			printTest(TestValidateIsTrueOOO.class, new PrintStream(fos));
			System.out.println("completed");
			printTest(TestValidateIsFalseOOO.class, new PrintStream(fos));
			System.out.println("completed");
			
			
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

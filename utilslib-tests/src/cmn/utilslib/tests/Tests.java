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
			printTest(TestValidateIsTrueMulti.class, ps);
			printTest(TestValidateIsTrueOOO.class, ps);
			
			printTest(TestValidateNotTrue.class, ps);
			printTest(TestValidateNotTrueMulti.class, ps);
			printTest(TestValidateNotTrueOOO.class, ps);
			
			printTest(TestValidateIsFalse.class, ps);
			printTest(TestValidateIsFalseMulti.class, ps);
			printTest(TestValidateIsFalseOOO.class, ps);
			
			printTest(TestValidateNotFalse.class, ps);
			printTest(TestValidateNotFalseMulti.class, ps);
			printTest(TestValidateNotFalseOOO.class, ps);
			
			printTest(TestValidateIsAbove.class, ps);
			printTest(TestValidateIsAboveMulti.class, ps);
			printTest(TestValidateIsAboveOOO.class, ps);
			
			printTest(TestValidateNotAbove.class, ps);
			printTest(TestValidateNotAboveMulti.class, ps);
			printTest(TestValidateNotAboveOOO.class, ps);
			
			printTest(TestValidateIsBelow.class, ps);
			printTest(TestValidateIsBelowMulti.class, ps);
			printTest(TestValidateIsBelowOOO.class, ps);
			
			printTest(TestValidateNotBelow.class, ps);
			printTest(TestValidateNotBelowMulti.class, ps);
			printTest(TestValidateNotBelowOOO.class, ps);

			
			
			System.out.println("finished!");
			
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

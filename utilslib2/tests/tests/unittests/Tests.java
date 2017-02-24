package tests.unittests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import cmn.utilslib.reflection.ClassRef;
import cmn.utilslib.reflection.MethodRef;
import tests.tools.IUnitTest;
import tests.tools.TimingResult;

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
			
			TimingResult r;
			
			for(Method m : ref.getMethodsByAnnotation(IUnitTest.StressTest.class))
			{
				r = new MethodRef<TimingResult>(m, t).invoke();
				stream.println(m.getDeclaredAnnotation(IUnitTest.StressTest.class).value() + " :");
				stream.println(				 "| type | cycles  | microseconds         | milliseconds         |");
				stream.println(				 "+------+---------+----------------------+----------------------+");
				stream.println(String.format("| E    |    1000 | %1$20s | %2$20s |", r.micro_empty_a, r.milli_empty_a));
				stream.println(String.format("| E    |  100000 | %1$20s | %2$20s |", r.micro_empty_b, r.milli_empty_b));
				stream.println(String.format("| E    | 1000000 | %1$20s | %2$20s |", r.micro_empty_c, r.milli_empty_c));
				stream.println(				 "+------+---------+----------------------+----------------------+");
				stream.println(String.format("| L    |    1000 | %1$20s | %2$20s |", r.micro_stress_a, r.milli_stress_a));
				stream.println(String.format("| L    |  100000 | %1$20s | %2$20s |", r.micro_stress_b, r.milli_stress_b));
				stream.println(String.format("| L    | 1000000 | %1$20s | %2$20s |", r.micro_stress_c, r.milli_stress_c));
				stream.println(				 "+------+---------+----------------------+----------------------+");
				stream.println("");
			}
			
			stream.println("================================================================");
			stream.println();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	
}

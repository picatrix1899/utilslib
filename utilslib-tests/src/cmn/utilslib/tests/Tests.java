package cmn.utilslib.tests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import cmn.utilslib.essentials.Profiler;
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
			
			Profiler p;
			
			for(Method m : ref.getMethodsByAnnotation(IUnitTest.StressTest.class))
			{
				p = new MethodRef<Profiler>(m, t).invoke();
				stream.println(m.getDeclaredAnnotation(IUnitTest.StressTest.class).value() + " :");
				stream.println(				 "| type | cycles  | microseconds         | milliseconds         |");
				stream.println(				 "+------+---------+----------------------+----------------------+");
				stream.println(String.format("| E    |    1000 | %1$20s | %2$20s |", p.micro("empty_1k"), p.milli("empty_1k")));
				stream.println(String.format("| E    |  100000 | %1$20s | %2$20s |", p.micro("empty_100k"), p.milli("empty_100k")));
				stream.println(String.format("| E    | 1000000 | %1$20s | %2$20s |", p.micro("empty_1m"), p.milli("empty_1m")));
				stream.println(				 "+------+---------+----------------------+----------------------+");
				stream.println(String.format("| L    |    1000 | %1$20s | %2$20s |", p.micro("stress_1k"), p.milli("stress_1k")));
				stream.println(String.format("| L    |  100000 | %1$20s | %2$20s |", p.micro("stress_100k"), p.milli("stress_100k")));
				stream.println(String.format("| L    | 1000000 | %1$20s | %2$20s |", p.micro("stress_1m"), p.milli("stress_1m")));
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

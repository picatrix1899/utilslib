package tests;

import cmn.utilslib.validation.Validate;
import tests.tools.IUnitTest;
import tests.tools.TimingResult;

public class Main
{

	public static void main(String[] args)
	{

		printTest(TestValidateIsTrue.class);
		
	}

	
	public static void printTest(Class<? extends IUnitTest> test)
	{
		try
		{
			IUnitTest t = test.newInstance();
			
			
			System.out.println("testing: " + t.getClass().getSimpleName());
			System.out.println();
			System.out.println("functionality: " + (t.test() ? "granted" : "failed"));
			System.out.println();
			TimingResult ra = t.stressTestA();
			System.out.println("StressTest Type A(All Pass):");
			System.out.println(				 "| type | cycles  | microseconds         | milliseconds         |");
			System.out.println(				 "+------+---------+----------------------+----------------------+");
			System.out.println(String.format("| E    |    1000 | %1$20s | %2$20s |", ra.micro_empty_a, ra.milli_empty_a));
			System.out.println(String.format("| E    |  100000 | %1$20s | %2$20s |", ra.micro_empty_b, ra.milli_empty_b));
			System.out.println(String.format("| E    | 1000000 | %1$20s | %2$20s |", ra.micro_empty_c, ra.milli_empty_c));
			System.out.println(				 "+------+---------+----------------------+----------------------+");
			System.out.println(String.format("| L    |    1000 | %1$20s | %2$20s |", ra.micro_stress_a, ra.milli_stress_a));
			System.out.println(String.format("| L    |  100000 | %1$20s | %2$20s |", ra.micro_stress_b, ra.milli_stress_b));
			System.out.println(String.format("| L    | 1000000 | %1$20s | %2$20s |", ra.micro_stress_c, ra.milli_stress_c));
			System.out.println(				 "+------+---------+----------------------+----------------------+");
			System.out.println();
			
			TimingResult rb = t.stressTestB();
			System.out.println("StressTest Type B(One Fail):");
			System.out.println(				 "| type | cycles  | microseconds         | milliseconds         |");
			System.out.println(				 "+------+---------+----------------------+----------------------+");
			System.out.println(String.format("| E    |    1000 | %1$20s | %2$20s |", rb.micro_empty_a, rb.milli_empty_a));
			System.out.println(String.format("| E    |  100000 | %1$20s | %2$20s |", rb.micro_empty_b, rb.milli_empty_b));
			System.out.println(String.format("| E    | 1000000 | %1$20s | %2$20s |", rb.micro_empty_c, rb.milli_empty_c));
			System.out.println(				 "+------+---------+----------------------+----------------------+");
			System.out.println(String.format("| L    |    1000 | %1$20s | %2$20s |", rb.micro_stress_a, rb.milli_stress_a));
			System.out.println(String.format("| L    |  100000 | %1$20s | %2$20s |", rb.micro_stress_b, rb.milli_stress_b));
			System.out.println(String.format("| L    | 1000000 | %1$20s | %2$20s |", rb.micro_stress_c, rb.milli_stress_c));
			System.out.println(				 "+------+---------+----------------------+----------------------+");
			System.out.println();
			
			TimingResult rc = t.stressTestC();
			System.out.println("StressTest Type C(All Fail):");
			System.out.println(				 "| type | cycles  | microseconds         | milliseconds         |");
			System.out.println(				 "+------+---------+----------------------+----------------------+");
			System.out.println(String.format("| E    |    1000 | %1$20s | %2$20s |", rc.micro_empty_a, rc.milli_empty_a));
			System.out.println(String.format("| E    |  100000 | %1$20s | %2$20s |", rc.micro_empty_b, rc.milli_empty_b));
			System.out.println(String.format("| E    | 1000000 | %1$20s | %2$20s |", rc.micro_empty_c, rc.milli_empty_c));
			System.out.println(				 "+------+---------+----------------------+----------------------+");
			System.out.println(String.format("| L    |    1000 | %1$20s | %2$20s |", rc.micro_stress_a, rc.milli_stress_a));
			System.out.println(String.format("| L    |  100000 | %1$20s | %2$20s |", rc.micro_stress_b, rc.milli_stress_b));
			System.out.println(String.format("| L    | 1000000 | %1$20s | %2$20s |", rc.micro_stress_c, rc.milli_stress_c));
			System.out.println(				 "+------+---------+----------------------+----------------------+");
			System.out.println();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		
	}
}

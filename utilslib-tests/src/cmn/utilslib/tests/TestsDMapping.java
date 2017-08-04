package cmn.utilslib.tests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class TestsDMapping
{
	public static void test() throws Exception
	{
		new File("testDMapping.txt").createNewFile();
		FileOutputStream fos = new FileOutputStream(new File("testDMapping.txt"));
		PrintStream ps = new PrintStream(fos);
		
		Tests.printTest(TestValidateIsTrue.class, ps);
		Tests.printTest(TestValidateIsTrueMulti.class, ps);
		Tests.printTest(TestValidateIsTrueOOO.class, ps);
		
		Tests.printTest(TestValidateNotTrue.class, ps);
		Tests.printTest(TestValidateNotTrueMulti.class, ps);
		Tests.printTest(TestValidateNotTrueOOO.class, ps);
		
		Tests.printTest(TestValidateIsFalse.class, ps);
		Tests.printTest(TestValidateIsFalseMulti.class, ps);
		Tests.printTest(TestValidateIsFalseOOO.class, ps);
		
		Tests.printTest(TestValidateNotFalse.class, ps);
		Tests.printTest(TestValidateNotFalseMulti.class, ps);
		Tests.printTest(TestValidateNotFalseOOO.class, ps);
		
		Tests.printTest(TestValidateIsAbove.class, ps);
		Tests.printTest(TestValidateIsAboveMulti.class, ps);
		Tests.printTest(TestValidateIsAboveOOO.class, ps);
		
		Tests.printTest(TestValidateNotAbove.class, ps);
		Tests.printTest(TestValidateNotAboveMulti.class, ps);
		Tests.printTest(TestValidateNotAboveOOO.class, ps);
		
		Tests.printTest(TestValidateIsBelow.class, ps);
		Tests.printTest(TestValidateIsBelowMulti.class, ps);
		Tests.printTest(TestValidateIsBelowOOO.class, ps);
		
		Tests.printTest(TestValidateNotBelow.class, ps);
		Tests.printTest(TestValidateNotBelowMulti.class, ps);
		Tests.printTest(TestValidateNotBelowOOO.class, ps);
		
		
		System.out.println("finished!");
		
		fos.flush();
		fos.close();
	}
}

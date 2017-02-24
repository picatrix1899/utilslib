package tests.unittests;

import cmn.utilslib.validation.VE_isTrue;
import cmn.utilslib.validation.Validate;
import cmn.utilslib.validation.ValidationException;
import tests.tools.CaptureErrorHandler;
import tests.tools.EmptyErrorHandler;
import tests.tools.IUnitTest;
import tests.tools.StopWatch;
import tests.tools.TimingResult;

public class TestValidateNotTrue implements IUnitTest
{
	@IUnitTest.Test("FunctionalityTest")
	public boolean test()
	{
		CaptureErrorHandler handler = new CaptureErrorHandler();
		
		ValidationException.setErrorHandler(handler);
		{
			Validate.notTrue(true);
		}
		ValidationException.resetErrorHandler();
		
		if(handler.getCount() == 1)
			if(handler.getType(0).equals(VE_isTrue.class))
				return true;
		
		return false;
	}
	
	@IUnitTest.StressTest("StressTest All Passed")
	public TimingResult stressTestA()
	{
		EmptyErrorHandler handler = new EmptyErrorHandler();
		StopWatch watch = new StopWatch();
		TimingResult result = new TimingResult();
		
		ValidationException.setErrorHandler(handler);
		{
			watch.start();
			{
				for(int i = 0; i < 1000; i++) {  }
			}
			watch.stop();
					
			result.micro_empty_a = watch.micro();
			result.milli_empty_a = watch.milli();
			
			watch.reset();
			
			watch.start();
			{
				for(int i = 0; i < 100000; i++) {  }
			}
			watch.stop();
					
			result.micro_empty_b = watch.micro();
			result.milli_empty_b = watch.milli();
			
			watch.reset();
			
			watch.start();
			{
				for(int i = 0; i < 1000000; i++) {  }
			}
			watch.stop();
					
			result.micro_empty_c = watch.micro();
			result.milli_empty_c = watch.milli();
			
			watch.reset();
			
			/* ============ */
			
			watch.start();
			{
				for(int i = 0; i < 1000; i++)
				{
					Validate.notTrue(false);
				}
			}
			watch.stop();
					
			result.micro_stress_a = watch.micro();
			result.milli_stress_a = watch.milli();
			
			watch.reset();
			
			watch.start();
			{
				for(int i = 0; i < 100000; i++)
				{
					Validate.notTrue(false);
				}
			}
			watch.stop();
					
			result.micro_stress_b = watch.micro();
			result.milli_stress_b = watch.milli();
			
			watch.reset();
			
			watch.start();
			{
				for(int i = 0; i < 1000000; i++)
				{
					Validate.notTrue(false);
				}
			}
			watch.stop();
					
			result.micro_stress_c = watch.micro();
			result.milli_stress_c = watch.milli();
			
			watch.reset();
		}
		ValidationException.resetErrorHandler();
		
		return result;
	}
	
	@IUnitTest.StressTest("StressTest All Fail")
	public TimingResult stressTestC()
	{
		EmptyErrorHandler handler = new EmptyErrorHandler();
		StopWatch watch = new StopWatch();
		TimingResult result = new TimingResult();
		
		ValidationException.setErrorHandler(handler);
		{
			watch.start();
			{
				for(int i = 0; i < 1000; i++) {  }
			}
			watch.stop();
					
			result.micro_empty_a = watch.micro();
			result.milli_empty_a = watch.milli();
			
			watch.reset();
			
			watch.start();
			{
				for(int i = 0; i < 100000; i++) {  }
			}
			watch.stop();
					
			result.micro_empty_b = watch.micro();
			result.milli_empty_b = watch.milli();
			
			watch.reset();
			
			watch.start();
			{
				for(int i = 0; i < 1000000; i++) {  }
			}
			watch.stop();
					
			result.micro_empty_c = watch.micro();
			result.milli_empty_c = watch.milli();
			
			watch.reset();
			
			/* ============ */
			
			watch.start();
			{
				for(int i = 0; i < 1000; i++)
				{
					Validate.notTrue(true);
				}
			}
			watch.stop();
					
			result.micro_stress_a = watch.micro();
			result.milli_stress_a = watch.milli();
			
			watch.reset();
			
			watch.start();
			{
				for(int i = 0; i < 100000; i++)
				{
					Validate.notTrue(true);
				}
			}
			watch.stop();
					
			result.micro_stress_b = watch.micro();
			result.milli_stress_b = watch.milli();
			
			watch.reset();
			
			watch.start();
			{
				for(int i = 0; i < 1000000; i++)
				{
					Validate.notTrue(true);
				}
			}
			watch.stop();
					
			result.micro_stress_c = watch.micro();
			result.milli_stress_c = watch.milli();
			
			watch.reset();
		}
		ValidationException.resetErrorHandler();
		
		return result;
	}


}

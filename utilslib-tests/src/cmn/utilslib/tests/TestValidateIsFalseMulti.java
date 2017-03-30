package cmn.utilslib.tests;

import cmn.utilslib.essentials.Profiler;
import cmn.utilslib.exceptions.ErrorHandlers;
import cmn.utilslib.validation.VE_isFalseMulti;
import cmn.utilslib.validation.Validate;
import cmn.utilslib.validation.ValidationException;
import tests.tools.CaptureErrorHandler;
import tests.tools.IUnitTest;
import tests.tools.StopWatch;
import tests.tools.TimingResult;

public class TestValidateIsFalseMulti implements IUnitTest
{
	@IUnitTest.Test("FunctionalityTest")
	public boolean test()
	{
		CaptureErrorHandler handler = new CaptureErrorHandler();
		
		ValidationException.setErrorHandler(handler);
		{
			Validate.isFalse(false,true, false, false, false, false, false, false, true, false);
		}
		ValidationException.resetErrorHandler();
		
		if(handler.getCount() == 1)
			if(handler.getType(0).equals(VE_isFalseMulti.class))
				return true;
		
		return false;
	}
	
	@IUnitTest.StressTest("StressTest All Passed")
	public TimingResult stressTestA()
	{
		Profiler profiler = new Profiler();
		TimingResult result = new TimingResult();
		
		ValidationException.setErrorHandler(ErrorHandlers.VOID);
		{
			profiler.start("empty_1k");
			{
				for(int i = 0; i < 1000; i++) {  }
			}
			profiler.stop("empty_1k");

			profiler.start("empty_100k");
			{
				for(int i = 0; i < 100000; i++) {  }
			}
			profiler.stop("empty_100k");

			profiler.start("empty_1m");
			{
				for(int i = 0; i < 1000000; i++) {  }
			}
			profiler.stop("empty_1m");

			/* ============ */
			
			profiler.start("stress_1k");
			{
				for(int i = 0; i < 1000; i++)
					Validate.isFalse(false, false, false, false, false, false, false, false, false, false);
			}
			profiler.stop("stress_1k");

			profiler.start("stress_100k");
			{
				for(int i = 0; i < 100000; i++)
					Validate.isFalse(false, false, false, false, false, false, false, false, false, false);
			}
			profiler.stop("stress_100k");

			profiler.start("stress_1m");
			{
				for(int i = 0; i < 1000000; i++)
					Validate.isFalse(false, false, false, false, false, false, false, false, false, false);
			}
			profiler.stop("stress_1m");
		}
		ValidationException.resetErrorHandler();
		
		result.micro_empty_a = profiler.micro("empty_1k");
		result.milli_empty_a = profiler.milli("empty_1k");
		
		result.micro_empty_b = profiler.micro("empty_100k");
		result.milli_empty_b = profiler.milli("empty_100k");
		
		result.micro_empty_c = profiler.micro("empty_1m");
		result.milli_empty_c = profiler.milli("empty_1m");
		
		result.micro_stress_a = profiler.micro("stress_1k");
		result.milli_stress_a = profiler.milli("stress_1k");
		
		result.micro_stress_b = profiler.micro("stress_100k");
		result.milli_stress_b = profiler.milli("stress_100k");
		
		result.micro_stress_c = profiler.micro("stress_1m");
		result.milli_stress_c = profiler.milli("stress_1m");
		
		return result;
	}
	
	@IUnitTest.StressTest("StressTest One Fail")
	public TimingResult stressTestB()
	{
		Profiler profiler = new Profiler();
		StopWatch watch = new StopWatch();
		TimingResult result = new TimingResult();
		
		ValidationException.setErrorHandler(ErrorHandlers.VOID);
		{
			profiler.start("empty_1k");
			{
				for(int i = 0; i < 1000; i++) {  }
			}
			profiler.stop("empty_1k");

			profiler.start("empty_100k");
			{
				for(int i = 0; i < 100000; i++) {  }
			}
			profiler.stop("empty_100k");

			profiler.start("empty_1m");
			{
				for(int i = 0; i < 1000000; i++) {  }
			}
			profiler.stop("empty_1m");

			/* ============ */
			
			profiler.start("stress_1k");
			{
				for(int i = 0; i < 1000; i++)
					Validate.isFalse(false, false, false, false, true, false, false, false, false, false);
			}
			profiler.stop("stress_1k");

			profiler.start("stress_100k");
			{
				for(int i = 0; i < 100000; i++)
					Validate.isFalse(false, false, false, false, true, false, false, false, false, false);
			}
			profiler.stop("stress_100k");
			
			profiler.start("stress_1m");
			{
				for(int i = 0; i < 1000000; i++)
					Validate.isFalse(false, false, false, false, true, false, false, false, false, false);
			}
			profiler.stop("stress_1m");
		}
		ValidationException.resetErrorHandler();
		
		result.micro_empty_a = profiler.micro("empty_1k");
		result.milli_empty_a = profiler.milli("empty_1k");
		
		result.micro_empty_b = profiler.micro("empty_100k");
		result.milli_empty_b = profiler.milli("empty_100k");
		
		result.micro_empty_c = profiler.micro("empty_1m");
		result.milli_empty_c = profiler.milli("empty_1m");
		
		result.micro_stress_a = profiler.micro("stress_1k");
		result.milli_stress_a = profiler.milli("stress_1k");
		
		result.micro_stress_b = profiler.micro("stress_100k");
		result.milli_stress_b = profiler.milli("stress_100k");
		
		result.micro_stress_c = profiler.micro("stress_1m");
		result.milli_stress_c = profiler.milli("stress_1m");
		
		return result;
	}
	
	@IUnitTest.StressTest("StressTest All Fail")
	public TimingResult stressTestC()
	{
		StopWatch watch = new StopWatch();
		TimingResult result = new TimingResult();
		
		ValidationException.setErrorHandler(ErrorHandlers.VOID);
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
					Validate.isFalse(true, true, true, true, true, true, true, true, true, true);
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
					Validate.isFalse(true, true, true, true, true, true, true, true, true, true);
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
					Validate.isFalse(true, true, true, true, true, true, true, true, true, true);
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

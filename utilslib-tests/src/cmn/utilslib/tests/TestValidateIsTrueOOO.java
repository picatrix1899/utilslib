package cmn.utilslib.tests;

import cmn.utilslib.essentials.Profiler;
import cmn.utilslib.exceptions.CaptureErrorHandler;
import cmn.utilslib.exceptions.ErrorHandlers;
import cmn.utilslib.testing.IUnitTest;
import cmn.utilslib.validation.VE_isTrueOOO;
import cmn.utilslib.validation.Validate;
import cmn.utilslib.validation.ValidationException;

public class TestValidateIsTrueOOO implements IUnitTest
{
	@IUnitTest.Test("FunctionalityTest")
	public boolean test()
	{
		CaptureErrorHandler handler = new CaptureErrorHandler();
		
		ValidationException.setErrorHandler(handler);
		{
			Validate.isTrueOOO(false, false, false, false, false, false, false, false, false, false);
		}
		ValidationException.resetErrorHandler();
		
		if(handler.getCount() == 1)
			if(handler.getType(0).equals(VE_isTrueOOO.class))
				return true;
		
		return false;
	}
	
	@IUnitTest.StressTest("StressTest Passed")
	public Profiler stressTestA()
	{
		Profiler profiler = new Profiler();
		
		ValidationException.setErrorHandler(ErrorHandlers.VOID);
		{
			emptyRun(profiler);

			profiler.start("stress_1k");
			{
				for(int i = 0; i < 1000; i++)
					Validate.isTrueOOO(false, false, false, false, true, false, false, false, false, false);
			}
			profiler.stop("stress_1k");
					
			profiler.start("stress_100k");
			{
				for(int i = 0; i < 100000; i++)
					Validate.isTrueOOO(false, false, false, false, true, false, false, false, false, false);
			}
			profiler.stop("stress_100k");
					
			profiler.start("stress_1m");
			{
				for(int i = 0; i < 1000000; i++)
					Validate.isTrueOOO(false, false, false, false, true, false, false, false, false, false);
			}
			profiler.stop("stress_1m");
		}
		ValidationException.resetErrorHandler();

		return profiler;
	}
	
	@IUnitTest.StressTest("StressTest Fail")
	public Profiler stressTestB()
	{
		Profiler profiler = new Profiler();
		
		ValidationException.setErrorHandler(ErrorHandlers.VOID);
		{
			emptyRun(profiler);

			profiler.start("stress_1k");
			{
				for(int i = 0; i < 1000; i++)
					Validate.isTrueOOO(false, false, false, false, false, false, false, false, false, false);
			}
			profiler.stop("stress_1k");
					
			profiler.start("stress_100k");
			{
				for(int i = 0; i < 100000; i++)
					Validate.isTrueOOO(false, false, false, false, false, false, false, false, false, false);
			}
			profiler.stop("stress_100k");
					
			profiler.start("stress_1m");
			{
				for(int i = 0; i < 1000000; i++)
					Validate.isTrueOOO(false, false, false, false, false, false, false, false, false, false);
			}
			profiler.stop("stress_1m");
		}
		ValidationException.resetErrorHandler();

		return profiler;
	}

	private void emptyRun(Profiler profiler)
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
	}

}

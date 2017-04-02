package cmn.utilslib.tests;

import cmn.utilslib.exceptions.CaptureErrorHandler;
import cmn.utilslib.testing.IUnitTest;
import cmn.utilslib.validation.VE_notFalseMulti;
import cmn.utilslib.validation.Validate;
import cmn.utilslib.validation.ValidationException;

public class TestValidateNotFalseMulti implements IUnitTest
{
	@IUnitTest.Test("FunctionalityTest -")
	public boolean testNegative()
	{
		CaptureErrorHandler handler = new CaptureErrorHandler();
		
		ValidationException.setErrorHandler(handler);
		{
			Validate.notFalse(true,false, true, true, true, true, true, true, false, true);
		}
		ValidationException.resetErrorHandler();
		
		if(handler.getCount() == 1)
			if(handler.getType(0).equals(VE_notFalseMulti.class))
				return true;
		
		return false;
	}
	
	@IUnitTest.Test("FunctionalityTest +")
	public boolean testPositive()
	{
		CaptureErrorHandler handler = new CaptureErrorHandler();
		
		ValidationException.setErrorHandler(handler);
		{
			Validate.notFalse(true,true, true, true, true, true, true, true, true, true);
		}
		ValidationException.resetErrorHandler();
		
		if(handler.getCount() == 0)
				return true;
		
		return false;
	}

}

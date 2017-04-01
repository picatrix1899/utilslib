package cmn.utilslib.tests;

import cmn.utilslib.exceptions.CaptureErrorHandler;
import cmn.utilslib.testing.IUnitTest;
import cmn.utilslib.validation.VE_notFalse;
import cmn.utilslib.validation.Validate;
import cmn.utilslib.validation.ValidationException;

public class TestValidateNotFalse implements IUnitTest
{
	@IUnitTest.Test("FunctionalityTest -")
	public boolean testNegative()
	{
		CaptureErrorHandler handler = new CaptureErrorHandler();
		
		ValidationException.setErrorHandler(handler);
		{
			Validate.notFalse(false);
		}
		ValidationException.resetErrorHandler();
		
		if(handler.getCount() == 1)
			if(handler.getType(0).equals(VE_notFalse.class))
				return true;
		
		return false;
	}
	
	@IUnitTest.Test("FunctionalityTest +")
	public boolean testPositive()
	{
		CaptureErrorHandler handler = new CaptureErrorHandler();
		
		ValidationException.setErrorHandler(handler);
		{
			Validate.notFalse(true);
		}
		ValidationException.resetErrorHandler();
		
		if(handler.getCount() == 0)
				return true;
		
		return false;
	}

}

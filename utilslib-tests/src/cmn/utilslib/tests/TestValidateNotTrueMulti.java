package cmn.utilslib.tests;

import cmn.utilslib.exceptions.CaptureErrorHandler;
import cmn.utilslib.testing.IUnitTest;
import cmn.utilslib.validation.VE_notTrueMulti;
import cmn.utilslib.validation.Validate;
import cmn.utilslib.validation.ValidationException;

public class TestValidateNotTrueMulti implements IUnitTest
{
	@IUnitTest.Test("FunctionalityTest -")
	public boolean testNegative()
	{
		CaptureErrorHandler handler = new CaptureErrorHandler();
		
		ValidationException.setErrorHandler(handler);
		{
			Validate.notTrue(false,true, false, false, false, false, false, false, true, false);
		}
		ValidationException.resetErrorHandler();
		
		if(handler.getCount() == 1)
			if(handler.getType(0).equals(VE_notTrueMulti.class))
				return true;
		
		return false;
	}
	
	@IUnitTest.Test("FunctionalityTest +")
	public boolean testPositive()
	{
		CaptureErrorHandler handler = new CaptureErrorHandler();
		
		ValidationException.setErrorHandler(handler);
		{
			Validate.notTrue(false,false, false, false, false, false, false, false, false, false);
		}
		ValidationException.resetErrorHandler();
		
		if(handler.getCount() == 0)
				return true;
		
		return false;
	}

}

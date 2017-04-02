package cmn.utilslib.tests;

import cmn.utilslib.exceptions.CaptureErrorHandler;
import cmn.utilslib.testing.IUnitTest;
import cmn.utilslib.validation.VE_notBelowOOO;
import cmn.utilslib.validation.Validate;
import cmn.utilslib.validation.ValidationException;

public class TestValidateNotBelowOOO implements IUnitTest
{
	@IUnitTest.Test("FunctionalityTest(Float) -")
	public boolean testNegativeFloat()
	{
		CaptureErrorHandler handler = new CaptureErrorHandler();
		
		ValidationException.setErrorHandler(handler);
		{
			Validate.notBelowOOO(1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f);
		}
		ValidationException.resetErrorHandler();
		
		if(handler.getCount() == 1)
			if(handler.getType(0).equals(VE_notBelowOOO.class))
				return true;
		
		return false;
	}
	
	@IUnitTest.Test("FunctionalityTest(Int) -")
	public boolean testNegativeInt()
	{
		CaptureErrorHandler handler = new CaptureErrorHandler();
		
		ValidationException.setErrorHandler(handler);
		{
			Validate.notBelowOOO(1, -1, -1, -1, -1, -1, -1, -1, -1, -1);
		}
		ValidationException.resetErrorHandler();
		
		if(handler.getCount() == 1)
			if(handler.getType(0).equals(VE_notBelowOOO.class))
				return true;
		
		return false;
	}
	
	@IUnitTest.Test("FunctionalityTest(Double) -")
	public boolean testNegativeDouble()
	{
		CaptureErrorHandler handler = new CaptureErrorHandler();
		
		ValidationException.setErrorHandler(handler);
		{
			Validate.notBelowOOO(1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d);
		}
		ValidationException.resetErrorHandler();
		
		if(handler.getCount() == 1)
			if(handler.getType(0).equals(VE_notBelowOOO.class))
				return true;
		
		return false;
	}
	
	@IUnitTest.Test("FunctionalityTest(Float) +")
	public boolean testPositiveFloat()
	{
		CaptureErrorHandler handler = new CaptureErrorHandler();
		
		ValidationException.setErrorHandler(handler);
		{
			Validate.notBelowOOO(1.0f, 2.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f);
		}
		ValidationException.resetErrorHandler();
		
		if(handler.getCount() == 0)
				return true;
		
		return false;
	}
	
	@IUnitTest.Test("FunctionalityTest(Int) +")
	public boolean testPositiveInt()
	{
		CaptureErrorHandler handler = new CaptureErrorHandler();
		
		ValidationException.setErrorHandler(handler);
		{
			Validate.notBelowOOO(1, 2, -1, -1, -1, -1, -1, -1, -1, -1);
		}
		ValidationException.resetErrorHandler();
		
		if(handler.getCount() == 0)
				return true;
		
		return false;
	}
	
	@IUnitTest.Test("FunctionalityTest(Double) +")
	public boolean testPositiveDouble()
	{
		CaptureErrorHandler handler = new CaptureErrorHandler();
		
		ValidationException.setErrorHandler(handler);
		{
			Validate.notBelowOOO(1.0d, 2.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d);
		}
		ValidationException.resetErrorHandler();
		
		if(handler.getCount() == 0)
				return true;
		
		return false;
	}

}

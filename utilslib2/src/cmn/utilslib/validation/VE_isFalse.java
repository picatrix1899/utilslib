package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_isFalse extends ValidationException
{

	private static final long serialVersionUID = 1L;

	
	
	public VE_isFalse(int stackreduction, boolean value)
	{
		this();
		
		if(Check.notFalse(value))
		{
			super.handle(stackreduction);
		}
	}
	
	private VE_isFalse() { super("isFalse", "The value is not false!"); }
	
}

package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_notFalse extends ValidationException
{

	private static final long serialVersionUID = 1L;

	
	
	public VE_notFalse(int stackreduction, boolean value)
	{
		this();
		
		if(Check.isFalse(value))
		{
			super.handle(stackreduction);
		}
	}
	
	private VE_notFalse() { super("notFalse", "The value is false!"); }
	 
}

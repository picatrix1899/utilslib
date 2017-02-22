package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_isTrue extends ValidationException
{

	private static final long serialVersionUID = 1L;
	
	
	
	public VE_isTrue(int stackreduction, boolean value)
	{
		this();
		
		if(Check.notTrue(value))
		{
			super.handle(stackreduction);
		}
	}
	
	private VE_isTrue() { super("isTrue", "The value is not true!"); }
	
}

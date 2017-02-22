package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_notTrue extends ValidationException
{

	private static final long serialVersionUID = 1L;
	
	
	
	public VE_notTrue(int stackreduction, boolean value)
	{
		this();
		
		if(Check.isTrue(value))
		{
			super.handle(stackreduction);
		}
	}
	
	private VE_notTrue() { super("notTrue", "The value is true!"); }
	
}

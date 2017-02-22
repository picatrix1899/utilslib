package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_notFalseOOO extends ValidationException
{

	private static final long serialVersionUID = 1L;
	
	
	
	public VE_notFalseOOO(int stackreduction, boolean... values)
	{
		this();

		if(Check.isFalse(values))
		{
			super.handle(stackreduction);
		}
	}
	
	private VE_notFalseOOO() { super("notFalse(One Out Of)", "All the values are false!"); }
	
}

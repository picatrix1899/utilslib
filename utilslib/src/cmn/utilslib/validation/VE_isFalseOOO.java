package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_isFalseOOO extends ValidationException
{

	private static final long serialVersionUID = 1L;
	
	
	
	public VE_isFalseOOO(int stackreduction, boolean... values)
	{
		this();

		if(Check.notFalse(values))
		{
			super.handle(stackreduction);
		}
	}
	
	private VE_isFalseOOO() { super("isFalse(One Out Of)", "All the values are not false!"); }
	
}

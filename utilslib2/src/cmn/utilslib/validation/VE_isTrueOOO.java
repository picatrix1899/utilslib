package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_isTrueOOO extends ValidationException
{

	private static final long serialVersionUID = 1L;
	
	
	
	public VE_isTrueOOO(int stackreduction, boolean... values)
	{
		this();

		if(Check.notTrue(values))
		{
			super.handle(stackreduction);
		}
	}
	
	private VE_isTrueOOO() { super("isTrue(One Out Of)", "All the values are not true!"); }
	
}

package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_notTrueOOO extends ValidationException
{

	private static final long serialVersionUID = 1L;
	
	
	
	public VE_notTrueOOO(int stackreduction, boolean... values)
	{
		this();

		if(Check.isTrue(values))
		{
			super.handle(stackreduction);
		}
	}
	
	private VE_notTrueOOO() { super("notTrue(One Out Of)", "All the values are true!"); }
	
}

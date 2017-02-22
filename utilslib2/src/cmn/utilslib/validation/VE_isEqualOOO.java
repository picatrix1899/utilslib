package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_isEqualOOO extends ValidationException
{

	private static final long serialVersionUID = 1L;
	
	
	
	public VE_isEqualOOO(int stackreduction, boolean expected, boolean... values)
	{
		this();

		if(Check.notEqual(expected, values))
		{
			this.details.add("expectation: " + expected);
			
			super.handle(stackreduction);
		}
	}
	
	private VE_isEqualOOO() { super("isEqual(One Out Of)", "All the values are not equal to the expectation!"); }
	
}

package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_notEqualOOO extends ValidationException
{

	private static final long serialVersionUID = 1L;
	
	
	
	public VE_notEqualOOO(int stackreduction, boolean expected, boolean... values)
	{
		this();

		if(Check.isEqual(expected, values))
		{
			this.details.add("expectation: " + expected);
			
			super.handle(stackreduction);
		}
	}
	
	private VE_notEqualOOO() { super("notEqual(One Out Of)", "All the values are equal to the expectation!"); }
	
}

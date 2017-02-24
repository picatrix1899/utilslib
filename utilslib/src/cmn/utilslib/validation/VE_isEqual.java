package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_isEqual extends ValidationException
{

	private static final long serialVersionUID = 1L;

	

	public VE_isEqual(int stackreduction, boolean expected, boolean value)
	{
		this();
		
		if(Check.notEqual(value))
		{
			this.details.clear();
			this.details.add("expected: " + expected);
			this.details.add("value: " + value);
			
			super.handle(stackreduction);
		}
	}
	
	private VE_isEqual() { super("isEqual", "The value is not equal to the expectation!"); }
	
}

package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_notEqual extends ValidationException
{

	private static final long serialVersionUID = 1L;

	

	public VE_notEqual(int stackreduction, boolean expected, boolean value)
	{
		this();
		
		if(Check.isEqual(value))
		{
			this.details.clear();
			this.details.add("expected: " + expected);
			this.details.add("value: " + value);
			
			super.handle(stackreduction);
		}
	}
	
	private VE_notEqual() { super("notEqual", "The value is equal to the expectation!"); }
	
}

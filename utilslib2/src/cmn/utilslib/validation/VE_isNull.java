package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_isNull extends ValidationException
{

	private static final long serialVersionUID = 1L;

	
	
	public <A> VE_isNull(int stackreduction, A value)
	{
		this();
		
		if(Check.notNull(value))
		{
			super.handle(stackreduction);
		}
	}
	
	private VE_isNull() { super("isNull", "The value is not null!"); }
	
}

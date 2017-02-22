package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_notNull extends ValidationException
{

	private static final long serialVersionUID = 1L;

	
	
	public <A> VE_notNull(int stackreduction, A value)
	{
		this();
		
		if(Check.isNull(value))
		{
			super.handle(stackreduction);
		}
	}
	
	private VE_notNull() { super("notNull", "The value is null!"); }
	
}

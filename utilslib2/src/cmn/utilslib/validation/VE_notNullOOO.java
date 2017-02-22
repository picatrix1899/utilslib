package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_notNullOOO extends ValidationException
{

	private static final long serialVersionUID = 1L;
	
	
	
	@SafeVarargs
	public <A> VE_notNullOOO(int stackreduction, A... values)
	{
		this();

		if(Check.isNull(values))
		{
			super.handle(stackreduction);
		}
	}
	
	private VE_notNullOOO() { super("notNull(One Out Of)", "All the values are null!"); }
	
}

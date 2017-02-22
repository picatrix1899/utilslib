package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_isNullOOO extends ValidationException
{

	private static final long serialVersionUID = 1L;
	
	
	
	@SafeVarargs
	public <A> VE_isNullOOO(int stackreduction, A... values)
	{
		this();

		if(Check.notNull(values))
		{
			super.handle(stackreduction);
		}
	}
	
	private VE_isNullOOO() { super("isNull(One Out Of)", "All the values are not null!"); }
	
}

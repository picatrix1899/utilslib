package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_isInRangeOOO extends ValidationException
{

	private static final long serialVersionUID = 1L;

	
	
	public VE_isInRangeOOO(int stackreduction, int min, int max, int... values)

	
	private VE_isInRangeOOO() { super("isInBetween(One Out Of)", "All of the values are not in range!"); }
	
}

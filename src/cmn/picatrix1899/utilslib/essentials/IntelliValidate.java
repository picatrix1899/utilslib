package cmn.picatrix1899.utilslib.essentials;

import cmn.picatrix1899.utilslib.essentials.Validate.Check;
import cmn.picatrix1899.utilslib.exceptions.IndexUnderflowException;

/**
 * 
 * @author picatrix1899
 *
 */
public abstract class IntelliValidate
{
	
	public static void notNull(Object o)
	{
		if(Check.notNull(o)) { throw new NullPointerException(); }
	}
	
	public static void isInBetween(int i, int min, int max)
	{
		if(Check.isBelow(i, min))
		{
			throw new IndexUnderflowException(); 
		}
	}
	
}

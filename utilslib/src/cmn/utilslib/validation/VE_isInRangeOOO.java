package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_isInRangeOOO extends ValidationException
{

	private static final long serialVersionUID = 1L;

	
	
	public VE_isInRangeOOO(int stackreduction, int min, int max, int... values)
	{
		this();
		
		if(Check.notInRange(min, max, values))
		{
			this.details.clear();
			this.details.add("inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_isInRangeOOO(int stackreduction, long min, long max, long... values)
	{
		this();
		
		if(Check.notInRange(min, max, values))
		{
			this.details.clear();
			this.details.add("inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_isInRangeOOO(int stackreduction,float min, float max, float... values)
	{
		this();
		
		if(Check.notInRange(min, max, values))
		{
			this.details.clear();
			this.details.add("inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_isInRangeOOO(int stackreduction, double min, double max, double... values)
	{
		this();
		
		if(Check.notInRange(min, max, values))
		{
			this.details.clear();
			this.details.add("inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			super.handle(stackreduction);
		}
	}
	
	private VE_isInRangeOOO() { super("isInBetween(One Out Of)", "All of the values are not in range!"); }
	
}

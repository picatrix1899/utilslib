package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_notInRangeOOO extends ValidationException
{

	private static final long serialVersionUID = 1L;

	
	
	public VE_notInRangeOOO(int stackreduction, int min, int max, int... values)
	{
		this();
		
		if(Check.isInRange(min, max, values))
		{
			this.details.clear();
			this.details.add("inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_notInRangeOOO(int stackreduction, long min, long max, long... values)
	{
		this();
		
		if(Check.isInRange(min, max, values))
		{
			this.details.clear();
			this.details.add("inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_notInRangeOOO(int stackreduction,float min, float max, float... values)
	{
		this();
		
		if(Check.isInRange(min, max, values))
		{
			this.details.clear();
			this.details.add("inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_notInRangeOOO(int stackreduction, double min, double max, double... values)
	{
		this();
		
		if(Check.isInRange(min, max, values))
		{
			this.details.clear();
			this.details.add("inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			super.handle(stackreduction);
		}
	}
	
	private VE_notInRangeOOO() { super("notInBetween(One Out Of)", "All of the values are in range!"); }
	
}

package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_isInRange extends ValidationException
{

	private static final long serialVersionUID = 1L;

	
	
	public VE_isInRange(int stackreduction, int min, int max, int value)
	{
		this();
		
		if(Check.notInRange(min, max, value))
		{
			this.details.clear();
			this.details.add("inclusive limits: [min: " + min + ", max: " + max + "]");
			this.details.add("value: " + value);
			
			super.handle(stackreduction);
		}
	}
	
	public VE_isInRange(int stackreduction, long min, long max, long value)
	{
		this();
		
		if(Check.notInRange(min, max, value))
		{
			this.details.clear();
			this.details.add("inclusive limits: [min: " + min + "L, max: " + max + "L]");
			this.details.add("value: " + value + "L");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_isInRange(int stackreduction, float min, float max, float value)
	{
		this();
		
		if(Check.notInRange(min, max, value))
		{
			this.details.clear();
			this.details.add("inclusive limits: [min: " + min + "F, max: " + max + "F]");
			this.details.add("value: " + value + "F");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_isInRange(int stackreduction, double min, double max, double value)
	{
		this();
		
		if(Check.notInRange(min, max, value))
		{
			this.details.clear();
			this.details.add("inclusive limits: [min: " + min + "D, max: " + max + "D]");
			this.details.add("value: " + value + "D");
			
			super.handle(stackreduction);
		}
	}
	
	private VE_isInRange() { super("isInRange", "The value is not in range!"); }
	
}

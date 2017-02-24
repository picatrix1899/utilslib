package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_notInRange extends ValidationException
{

	private static final long serialVersionUID = 1L;

	
	
	public VE_notInRange(int stackreduction, int min, int max, int value)
	{
		this();
		
		if(Check.isInRange(value, min, max))
		{
			this.details.clear();
			this.details.add("inclusive limits: [min: " + min + ", max: " + max + "]");
			this.details.add("value: " + value);
			
			super.handle(stackreduction);
		}
	}
	
	public VE_notInRange(int stackreduction, long min, long max, long value)
	{
		this();
		
		if(Check.isInRange(value, min, max))
		{
			this.details.clear();
			this.details.add("inclusive limits: [min: " + min + "L, max: " + max + "L]");
			this.details.add("value: " + value + "L");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_notInRange(int stackreduction, float min, float max, float value)
	{
		this();
		
		if(Check.isInRange(value, min, max))
		{
			this.details.clear();
			this.details.add("inclusive limits: [min: " + min + "F, max: " + max + "F]");
			this.details.add("value: " + value + "F");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_notInRange(int stackreduction, double min, double max, double value)
	{
		this();
		
		if(Check.isInRange(value, min, max))
		{
			this.details.clear();
			this.details.add("inclusive limits: [min: " + min + "D, max: " + max + "D]");
			this.details.add("value: " + value + "D");
			
			super.handle(stackreduction);
		}
	}
	
	private VE_notInRange() { super("notInRange", "The value is in range!"); }
	
}

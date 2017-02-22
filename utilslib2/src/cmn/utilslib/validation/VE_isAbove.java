package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_isAbove extends ValidationException
{

	private static final long serialVersionUID = 1L;

	
	
	public VE_isAbove(int stackreduction, int threshold, int value)
	{
		this();
		
		if(Check.notAbove(value, threshold))
		{
			this.details.clear();
			this.details.add("exclusive threshold: " + threshold);
			this.details.add("value: " + value);
			
			super.handle(stackreduction);
		}
	}
	
	public VE_isAbove(int stackreduction, long threshold, long value)
	{
		this();
		
		if(Check.notAbove(value, threshold))
		{
			this.details.clear();
			this.details.add("exclusive threshold: " + threshold + "L");
			this.details.add("value: " + value + "L");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_isAbove(int stackreduction, float threshold, float value)
	{
		this();
		
		if(Check.notAbove(value, threshold))
		{
			this.details.clear();
			this.details.add("exclusive threshold: " + threshold + "F");
			this.details.add("value: " + value + "F");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_isAbove(int stackreduction, double threshold, double value)
	{
		this();
		
		if(Check.notAbove(value, threshold))
		{
			this.details.clear();
			this.details.add("exclusive threshold: " + threshold + "D");
			this.details.add("value: " + value + "D");
			
			super.handle(stackreduction);
		}
	}
	
	private VE_isAbove() { super("isAbove", "The value is not above threshold!"); }
	
}

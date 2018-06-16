package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_notAbove extends ValidationException
{

	private static final long serialVersionUID = 1L;

	
	
	public VE_notAbove(int stackreduction, int min, int value)
	{
		this();
		
		if(Check.isAbove(min, value))
		{
			this.details.clear();
			this.details.add("exclusive minimum threshold: " + min);
			this.details.add("value: " + value);
			
			super.handle(stackreduction);
		}
	}
	
	public VE_notAbove(int stackreduction, long min, long value)
	{
		this();
		
		if(Check.isAbove(min, value))
		{
			this.details.clear();
			this.details.add("exclusive minimum threshold: " + min + "L");
			this.details.add("value: " + value + "L");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_notAbove(int stackreduction, float min, float value)
	{
		this();
		
		if(Check.isAbove(min, value))
		{
			this.details.clear();
			this.details.add("exclusive minimum threshold: " + min + "F");
			this.details.add("value: " + value + "F");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_notAbove(int stackreduction, double min, double value)
	{
		this();
		
		if(Check.isAbove(min, value))
		{
			this.details.clear();
			this.details.add("exclusive minimum threshold: " + min + "D");
			this.details.add("value: " + value + "D");
			
			super.handle(stackreduction);
		}
	}
	
	private VE_notAbove() { super("notAbove", "The value is above threshold!"); }
	
}

package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_notBelow extends ValidationException
{

	private static final long serialVersionUID = 1L;

	

	public VE_notBelow(int stackreduction, int max, int value)
	{
		this();
		
		if(Check.isBelow(max, value))
		{
			this.details.clear();
			this.details.add("exclusive maximum threshold: " + max);
			this.details.add("value: " + value);
			
			super.handle(stackreduction);
		}
	}
	
	public VE_notBelow(int stackreduction, long max, long value)
	{
		this();
		
		if(Check.isBelow(max, value))
		{
			this.details.clear();
			this.details.add("exclusive maximum threshold: " + max + "L");
			this.details.add("value: " + value + "L");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_notBelow(int stackreduction, float max, float value)
	{
		this();
		
		if(Check.isBelow(max, value))
		{
			this.details.clear();
			this.details.add("exclusive maximum threshold: " + max + "F");
			this.details.add("value: " + value + "F");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_notBelow(int stackreduction, double max, double value)
	{
		this();
		
		if(Check.isBelow(max, value))
		{
			this.details.clear();
			this.details.add("exclusive maximum threshold: " + max + "D");
			this.details.add("value: " + value + "D");
			
			super.handle(stackreduction);
		}
	}
	
	private VE_notBelow() { super("notBelow", "The value is below threshold!"); }
	
}

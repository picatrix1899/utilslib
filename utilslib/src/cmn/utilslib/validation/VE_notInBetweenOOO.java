package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_notInBetweenOOO extends ValidationException
{

	private static final long serialVersionUID = 1L;

	
	
	public VE_notInBetweenOOO(int stackreduction, int min, int max, int... values)
	{
		this();
		
		if(Check.isInBetween(min, max, values))
		{
			this.details.clear();
			this.details.add("exclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_notInBetweenOOO(int stackreduction, long min, long max, long... values)
	{
		this();
		
		if(Check.isInBetween(min, max, values))
		{
			this.details.clear();
			this.details.add("exclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_notInBetweenOOO(int stackreduction,float min, float max, float... values)
	{
		this();
		
		if(Check.isInBetween(min, max, values))
		{
			this.details.clear();
			this.details.add("exclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_notInBetweenOOO(int stackreduction, double min, double max, double... values)
	{
		this();
		
		if(Check.isInBetween(min, max, values))
		{
			this.details.clear();
			this.details.add("exclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			super.handle(stackreduction);
		}
	}
	
	private VE_notInBetweenOOO() { super("notInBetween(One Out Of)", "All of the values are between limits!"); }
	
}

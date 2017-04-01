package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_isInBetweenOOO extends ValidationException
{

	private static final long serialVersionUID = 1L;

	
	
	public VE_isInBetweenOOO(int stackreduction, int min, int max, int... values)
	{
		this();
		
		if(Check.notInBetween(min, max, values))
		{
			this.details.clear();
			this.details.add("exclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_isInBetweenOOO(int stackreduction, long min, long max, long... values)
	{
		this();
		
		if(Check.notInBetween(min, max, values))
		{
			this.details.clear();
			this.details.add("exclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_isInBetweenOOO(int stackreduction,float min, float max, float... values)
	{
		this();
		
		if(Check.notInBetween(min, max, values))
		{
			this.details.clear();
			this.details.add("exclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_isInBetweenOOO(int stackreduction, double min, double max, double... values)
	{
		this();
		
		if(Check.notInBetween(min, max, values))
		{
			this.details.clear();
			this.details.add("exclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			super.handle(stackreduction);
		}
	}
	
	private VE_isInBetweenOOO() { super("isInBetween(One Out Of)", "All of the values are not between limits!"); }
	
}

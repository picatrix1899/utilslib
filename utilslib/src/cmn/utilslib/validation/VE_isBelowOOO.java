package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_isBelowOOO extends ValidationException
{

	private static final long serialVersionUID = 1L;

	
	
	public VE_isBelowOOO(int stackreduction, int max, int... values)
	{
		this();
		
		if(Check.notBelow(max, values))
		{
			this.details.clear();
			this.details.add("exclusive maximum threshold: " + max);
			
			super.handle(stackreduction);
		}
	}
	
	public VE_isBelowOOO(int stackreduction, long max, long... values)
	{
		this();
		
		if(Check.notBelow(max, values))
		{
			this.details.clear();
			this.details.add("exclusive maximum threshold: " + max + "L");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_isBelowOOO(int stackreduction, float max, float... values)
	{
		this();
		
		if(Check.notBelow(max, values))
		{
			this.details.clear();
			this.details.add("exclusive maximum threshold: " + max + "F");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_isBelowOOO(int stackreduction, double max, double... values)
	{
		this();
		
		if(Check.notBelow(max, values))
		{
			this.details.clear();
			this.details.add("exclusive maximum threshold: " + max + "D");
			
			super.handle(stackreduction);
		}
	}
	
	private VE_isBelowOOO() { super("isBelow(One Out Of)", "All of the values are not below exclusive maximum threshold!"); }
	
}

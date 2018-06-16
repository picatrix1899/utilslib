package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_notBelowOOO extends ValidationException
{

	private static final long serialVersionUID = 1L;

	
	
	public VE_notBelowOOO(int stackreduction, int max, int... values)
	{
		this();
		
		if(Check.isBelow(max, values))
		{
			this.details.clear();
			this.details.add("exclusive maximum threshold: " + max);
			
			super.handle(stackreduction);
		}
	}
	
	public VE_notBelowOOO(int stackreduction, long max, long... values)
	{
		this();
		
		if(Check.isBelow(max, values))
		{
			this.details.clear();
			this.details.add("exclusive maximum threshold: " + max + "L");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_notBelowOOO(int stackreduction, float max, float... values)
	{
		this();
		
		if(Check.isBelow(max, values))
		{
			this.details.clear();
			this.details.add("exclusive maximum threshold: " + max + "F");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_notBelowOOO(int stackreduction, double max, double... values)
	{
		this();
		
		if(Check.isBelow(max, values))
		{
			this.details.clear();
			this.details.add("exclusive maximum threshold: " + max + "D");
			
			super.handle(stackreduction);
		}
	}
	
	private VE_notBelowOOO() { super("notBelow(One Out Of)", "All of the values are below exclusive maximum threshold!"); }
	
}

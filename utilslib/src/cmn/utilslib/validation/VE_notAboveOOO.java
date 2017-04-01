package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_notAboveOOO extends ValidationException
{

	private static final long serialVersionUID = 1L;

	
	
	public VE_notAboveOOO(int stackreduction, int min, int... values)
	{
		this();
		
		if(Check.isAbove(min, values))
		{
			this.details.clear();
			this.details.add("exclusive minimum threshold: " + min);
			
			super.handle(stackreduction);
		}
	}
	
	public VE_notAboveOOO(int stackreduction, long min, long... values)
	{
		this();
		
		if(Check.isAbove(min, values))
		{
			this.details.clear();
			this.details.add("exclusive minimum threshold: " + min + "L");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_notAboveOOO(int stackreduction, float min, float... values)
	{
		this();
		
		if(Check.isAbove(min, values))
		{
			this.details.clear();
			this.details.add("exclusive minimum threshold: " + min + "F");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_notAboveOOO(int stackreduction, double min, double... values)
	{
		this();
		
		if(Check.isAbove(min, values))
		{
			this.details.clear();
			this.details.add("exclusive minimum threshold: " + min + "D");
			
			super.handle(stackreduction);
		}
	}
	
	private VE_notAboveOOO() { super("notAbove(One Out Of)", "All of the values are above exclusive minimum threshold!"); }
	
}

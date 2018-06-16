package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class VE_isAboveOOO extends ValidationException
{

	private static final long serialVersionUID = 1L;

	
	
	public VE_isAboveOOO(int stackreduction, int min, int... values)
	{
		this();
		
		if(Check.notAbove(min, values))
		{
			this.details.clear();
			this.details.add("exclusive minimum threshold: " + min);
			
			super.handle(stackreduction);
		}
	}
	
	public VE_isAboveOOO(int stackreduction, long min, long... values)
	{
		this();
		
		if(Check.notAbove(min, values))
		{
			this.details.clear();
			this.details.add("exclusive minimum threshold: " + min + "L");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_isAboveOOO(int stackreduction, float min, float... values)
	{
		this();
		
		if(Check.notAbove(min, values))
		{
			this.details.clear();
			this.details.add("exclusive minimum threshold: " + min + "F");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_isAboveOOO(int stackreduction, double min, double... values)
	{
		this();
		
		if(Check.notAbove(min, values))
		{
			this.details.clear();
			this.details.add("exclusive minimum threshold: " + min + "D");
			
			super.handle(stackreduction);
		}
	}
	
	private VE_isAboveOOO() { super("isAbove(One Out Of)", "All of the values are not above exclusive minimum threshold!"); }
	
}

package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

class ValidateFalse
{
	private static final String TYPE__IS_FALSE = "isFalse";
	private static final String TYPE__IS_FALSE_MULTI = "isFalse(Multi)";
	private static final String TYPE__IS_FALSE_OOO = "isFalse(One Out Of)";
	private static final String TYPE__NOT_FALSE = "notFalse";
	private static final String TYPE__NOT_FALSE_MULTI = "notFalse(Multi)";
	private static final String TYPE__NOT_FALSE_OOO = "notFalse(One Out Of)";

	private static final String DESC__IS_FALSE = "The value is true!";
	private static final String DESC__IS_FALSE_MULTI = "At least one of the values is true!";
	private static final String DESC__IS_FALSE_OOO = "None the values is false!";
	private static final String DESC__NOT_FALSE = "The value is false!";
	private static final String DESC__NOT_FALSE_MULTI = "At least one of the values is false!";
	private static final String DESC__NOT_FALSE_OOO = "All the values are false!";
	
	static void isFalse(int stackreduction, boolean value)
	{
		if(Check.notFalse(value))
		{
			ValidationError error = new ValidationError(TYPE__IS_FALSE, DESC__IS_FALSE);

			error.throwError(stackreduction);
		}
	}
	
	static void isFalse(int stackreduction, boolean... values)
	{
		StringBuilder builder = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
		{
			if(Check.notFalse(values[i]))
			{
				builder.append((count > 0 ? ", " : "") + i + 1);
				count++;
			}
		}
			
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__IS_FALSE_MULTI, DESC__IS_FALSE_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builder.toString() + "]");
			error.details.add("total failed: " + count);
			
			error.throwError(stackreduction);
		}
	}
	
	static void isFalseOOO(int stackreduction, boolean... values)
	{
		if(Check.notFalse(values))
		{
			ValidationError error = new ValidationError(TYPE__IS_FALSE_OOO, DESC__IS_FALSE_OOO);
			
			error.throwError(stackreduction);
		}
	}
	
	static void notFalse(int stackreduction, boolean value)
	{
		if(Check.isFalse(value))
		{
			ValidationError error = new ValidationError(TYPE__NOT_FALSE, DESC__NOT_FALSE);
			
			error.throwError(stackreduction);
		}
	}
	
	static void notFalse(int stackreduction, boolean... values)
	{
		StringBuilder builder = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
		{
			if(Check.isFalse(values[i]))
			{
				builder.append((count > 0 ? ", " : "") + i + 1);
				count++;
			}
		}
			
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__NOT_FALSE_MULTI, DESC__NOT_FALSE_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builder.toString() + "]");
			error.details.add("total failed: " + count);
			
			error.throwError(stackreduction);
		}
	}
	
	static void notFalseOOO(int stackreduction, boolean... values)
	{
		if(Check.isFalse(values))
		{
			ValidationError error = new ValidationError(TYPE__NOT_FALSE_OOO, DESC__NOT_FALSE_OOO);
			
			error.throwError(stackreduction);
		}
	}
}

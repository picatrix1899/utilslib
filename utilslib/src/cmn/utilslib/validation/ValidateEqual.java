package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

class ValidateEqual
{
	private static final String TYPE__IS_EQUAL = "isEqual";
	private static final String TYPE__IS_EQUAL_MULTI = "isEqual(Multi)";
	private static final String TYPE__IS_EQUAL_OOO = "isEqual(One Out Of)";
	private static final String TYPE__NOT_EQUAL = "notEqual";
	private static final String TYPE__NOT_EQUAL_MULTI = "notEqual(Multi)";
	private static final String TYPE__NOT_EQUAL_OOO = "notEqual(One Out Of)";
	
	private static final String DESC__IS_EQUAL = "The value is not equal to the expectation!";
	private static final String DESC__IS_EQUAL_MULTI = "At least one of the values is not equal to the expectation!";
	private static final String DESC__IS_EQUAL_OOO = "None of the values is equal to the expectation!";
	private static final String DESC__NOT_EQUAL = "The value is equal to the expectation!";
	private static final String DESC__NOT_EQUAL_MULTI = "At least one of the values is not equal to the expectation!";
	private static final String DESC__NOT_EQUAL_OOO = "All of the values are equal to the expectation!";
	
	static void isEqual(int stackreduction, boolean expected, boolean value)
	{
		if(Check.notEqual(expected, value))
		{
			ValidationError error = new ValidationError(TYPE__IS_EQUAL, DESC__IS_EQUAL);
			
			error.details.add("expected: " + expected);
			error.details.add("value: " + value);
			
			error.throwError(stackreduction);
		}
	}
	
	static void  isEqual(int stackreduction, boolean expected, boolean... values)
	{
		StringBuilder builder = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
		{
			if(Check.notEqual(expected, values[i]))
			{
				builder.append((count > 0 ? ", " : "") + i + 1);
				count++;
			}
		}
			
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__IS_EQUAL_MULTI, DESC__IS_EQUAL_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builder.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("expected value: " + expected);
			
			error.throwError(stackreduction);
		}
	}
	
	static void  isEqualOOO(int stackreduction, boolean expected, boolean... values)
	{
		if(Check.notEqual(expected, values))
		{
			ValidationError error = new ValidationError(TYPE__IS_EQUAL_OOO, DESC__IS_EQUAL_OOO);
			
			error.details.add("expectation: " + expected);
			
			error.throwError(stackreduction);
		}
	}
	
	static void  notEqual(int stackreduction, boolean expected, boolean value)
	{
		if(Check.isEqual(expected, value))
		{
			ValidationError error = new ValidationError(TYPE__NOT_EQUAL, DESC__NOT_EQUAL);
			
			error.details.add("expected: " + expected);
			error.details.add("value: " + value);
			
			error.throwError(stackreduction);
		}
	}
	
	static void  notEqual(int stackreduction, boolean expected, boolean... values)
	{
		StringBuilder builder = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
		{
			if(Check.isEqual(expected, values[i]))
			{
				builder.append((count > 0 ? ", " : "") + i + 1);
				count++;
			}
		}
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__NOT_EQUAL_MULTI, DESC__NOT_EQUAL_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builder.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("expected value: " + expected);
			
			error.throwError(stackreduction);
		}
	}
	
	static void  notEqualOOO(int stackreduction, boolean expected, boolean... values)
	{
		if(Check.isEqual(expected, values))
		{
			ValidationError error = new ValidationError(TYPE__NOT_EQUAL_OOO, DESC__NOT_EQUAL_OOO);
			
			error.details.add("expectation: " + expected);
			
			error.throwError(stackreduction);
		}
	}
}

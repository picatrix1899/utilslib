package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

class ValidateAbove
{
	private static final String TYPE__IS_ABOVE = "isAbove";
	private static final String TYPE__IS_ABOVE_MULTI = "isAbove(Multi)";
	private static final String TYPE__IS_ABOVE_OOO = "isAbove(One Out Of)";
	private static final String TYPE__NOT_ABOVE = "notAbove";
	private static final String TYPE__NOT_ABOVE_MULTI = "notAbove(Multi)";
	private static final String TYPE__NOT_ABOVE_OOO = "notAbove(One Out Of)";
	
	private static final String DESC__IS_ABOVE = "The value is not above exclusive minimum!";
	private static final String DESC__IS_ABOVE_MULTI = "At least one of the values is not above exclusive minimum!";
	private static final String DESC__IS_ABOVE_OOO = "None of the values is above exclusive minimum!";
	private static final String DESC__NOT_ABOVE = "The value is above exclusive minimum!";
	private static final String DESC__NOT_ABOVE_MULTI = "At least one of the values is above exclusive minimum!";
	private static final String DESC__NOT_ABOVE_OOO = "All of the values are above exclusive minimum!";
	
	static void isAbove(int stackreduction, int min, int value)
	{
		if(Check.notAbove(min, value))
		{
			ValidationError error = new ValidationError(TYPE__IS_ABOVE, DESC__IS_ABOVE);
			
			error.details.add("exclusive minimum: " + min);
			error.details.add("value: " + value);
			
			error.throwError(stackreduction);
		}
	}
	
	static void isAbove(int stackreduction, long min, long value)
	{
		if(Check.notAbove(min, value))
		{
			ValidationError error = new ValidationError(TYPE__IS_ABOVE, DESC__IS_ABOVE);
			
			error.details.add("exclusive minimum: " + min + "L");
			error.details.add("value: " + value + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isAbove(int stackreduction, float min, float value)
	{
		if(Check.notAbove(min, value))
		{
			ValidationError error = new ValidationError(TYPE__IS_ABOVE, DESC__IS_ABOVE);
			
			error.details.add("exclusive minimum: " + min + "F");
			error.details.add("value: " + value + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isAbove(int stackreduction, double min, double value)
	{
		if(Check.notAbove(min, value))
		{
			ValidationError error = new ValidationError(TYPE__IS_ABOVE, DESC__IS_ABOVE);
			
			error.details.add("exclusive minimum: " + min + "D");
			error.details.add("value: " + value + "D");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isAbove(int stackreduction, int min, int... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.notAbove(min, values[i]))
			{
				builderIndices.append((count > 1 ? ", " : "") + i + 1);
				builderValues.append((count > 1 ? ", " : "" ) + values[i]);
				count++;
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__IS_ABOVE_MULTI, DESC__IS_ABOVE_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("exclusive minimum: " + min);
			
			error.throwError(stackreduction);
		}
	}
	
	static void isAbove(int stackreduction, long min, long... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.notAbove(min, values[i]))
			{
				builderIndices.append((count > 1 ? ", " : "") + i + 1);
				builderValues.append((count > 1 ? ", " : "" ) + values[i]);
				count++;
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__IS_ABOVE_MULTI, DESC__IS_ABOVE_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("exclusive minimum: " + min + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isAbove(int stackreduction, float min, float... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.notAbove(min, values[i]))
			{
				builderIndices.append((count > 1 ? ", " : "") + i + 1);
				builderValues.append((count > 1 ? ", " : "" ) + values[i]);
				count++;
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__IS_ABOVE_MULTI, DESC__IS_ABOVE_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("exclusive minimum: " + min + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isAbove(int stackreduction, double min, double... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.notAbove(min, values[i]))
			{
				builderIndices.append((count > 1 ? ", " : "") + i + 1);
				builderValues.append((count > 1 ? ", " : "" ) + values[i]);
				count++;
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__IS_ABOVE_MULTI, DESC__IS_ABOVE_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("exclusive minimum: " + min + "D");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isAboveOOO(int stackreduction, int min, int... values)
	{
		if(Check.notAbove(min, values))
		{
			ValidationError error = new ValidationError(TYPE__IS_ABOVE_OOO, DESC__IS_ABOVE_OOO);
			
			error.details.add("exclusive minimum: " + min);
			
			error.throwError(stackreduction);
		}
	}
	
	static void isAboveOOO(int stackreduction, long min, long... values)
	{
		if(Check.notAbove(min, values))
		{
			ValidationError error = new ValidationError(TYPE__IS_ABOVE_OOO, DESC__IS_ABOVE_OOO);
			
			error.details.add("exclusive minimum: " + min + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isAboveOOO(int stackreduction, float min, float... values)
	{
		if(Check.notAbove(min, values))
		{
			ValidationError error = new ValidationError(TYPE__IS_ABOVE_OOO, DESC__IS_ABOVE_OOO);
			
			error.details.add("exclusive minimum: " + min + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isAboveOOO(int stackreduction, double min, double... values)
	{
		if(Check.notAbove(min, values))
		{
			ValidationError error = new ValidationError(TYPE__IS_ABOVE_OOO, DESC__IS_ABOVE_OOO);
			
			error.details.add("exclusive minimum: " + min + "D");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notAbove(int stackreduction, int min, int value)
	{
		if(Check.isAbove(min, value))
		{
			ValidationError error = new ValidationError(TYPE__NOT_ABOVE, DESC__NOT_ABOVE);
			
			error.details.add("exclusive minimum: " + min);
			error.details.add("value: " + value);
			
			error.throwError(stackreduction);
		}
	}
	
	static void notAbove(int stackreduction, long min, long value)
	{
		if(Check.isAbove(min, value))
		{
			ValidationError error = new ValidationError(TYPE__NOT_ABOVE, DESC__NOT_ABOVE);
			
			error.details.add("exclusive minimum: " + min + "L");
			error.details.add("value: " + value + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notAbove(int stackreduction, float min, float value)
	{
		if(Check.isAbove(min, value))
		{
			ValidationError error = new ValidationError(TYPE__NOT_ABOVE, DESC__NOT_ABOVE);
			
			error.details.add("exclusive minimum: " + min + "F");
			error.details.add("value: " + value + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notAbove(int stackreduction, double min, double value)
	{
		if(Check.isAbove(min, value))
		{
			ValidationError error = new ValidationError(TYPE__NOT_ABOVE, DESC__NOT_ABOVE);
			
			error.details.add("exclusive minimum: " + min + "D");
			error.details.add("value: " + value + "D");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notAbove(int stackreduction, int min, int... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.isAbove(min, values[i]))
			{
				builderIndices.append((count > 1 ? ","  : "") + i + 1);
				builderValues.append((count > 1 ? ", " : "" ) + values[i]);
				count++;
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__NOT_ABOVE_MULTI, DESC__NOT_ABOVE_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("exclusive minimum: " + min);
			
			error.throwError(stackreduction);
		}
	}
	
	static void notAbove(int stackreduction, long min, long... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.isAbove(min, values[i]))
			{
				builderIndices.append((count > 1 ? ", " : "") + i + 1);
				builderValues.append((count > 1 ? ", " : "" ) + values[i]);
				count++;
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__NOT_ABOVE_MULTI, DESC__NOT_ABOVE_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("exclusive minimum: " + min + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notAbove(int stackreduction, float min, float... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.isAbove(min, values[i]))
			{
				builderIndices.append((count > 1 ? ", " : "") + i + 1);
				builderValues.append((count > 1 ? ", " : "" ) + values[i]);
				count++;
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__NOT_ABOVE_MULTI, DESC__NOT_ABOVE_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("exclusive minimum: " + min + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notAbove(int stackreduction, double min, double... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.isAbove(min, values[i]))
			{
				builderIndices.append((count > 1 ? ", " : "") + i + 1);
				builderValues.append((count > 1 ? ", " : "" ) + values[i]);
				count++;
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__NOT_ABOVE_MULTI, DESC__NOT_ABOVE_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("exclusive minimum: " + min + "D");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notAboveOOO(int stackreduction, int min, int... values)
	{
		if(Check.isAbove(min, values))
		{
			ValidationError error = new ValidationError(TYPE__NOT_ABOVE_OOO, DESC__NOT_ABOVE_OOO);
			
			error.details.add("exclusive minimum: " + min);
			
			error.throwError(stackreduction);
		}
	}
	
	static void notAboveOOO(int stackreduction, long min, long... values)
	{
		if(Check.isAbove(min, values))
		{
			ValidationError error = new ValidationError(TYPE__NOT_ABOVE_OOO, DESC__NOT_ABOVE_OOO);
			
			error.details.add("exclusive minimum: " + min + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notAboveOOO(int stackreduction, float min, float... values)
	{
		if(Check.isAbove(min, values))
		{
			ValidationError error = new ValidationError(TYPE__NOT_ABOVE_OOO, DESC__NOT_ABOVE_OOO);
			
			error.details.add("exclusive minimum: " + min + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notAboveOOO(int stackreduction, double min, double... values)
	{
		if(Check.isAbove(min, values))
		{
			ValidationError error = new ValidationError(TYPE__NOT_ABOVE_OOO, DESC__NOT_ABOVE_OOO);
			
			error.details.add("exclusive minimum: " + min + "D");
			
			error.throwError(stackreduction);
		}
	}
}

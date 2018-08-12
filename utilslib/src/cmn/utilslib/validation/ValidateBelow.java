package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

class ValidateBelow
{
	
	private static final String TYPE__IS_BELOW = "isBelow";
	private static final String TYPE__IS_BELOW_MULIT = "isBelow(Multi)";
	private static final String TYPE__IS_BELOW_OOO = "notBelow(OneOutOf)";
	private static final String TYPE__NOT_BELOW = "notBelow";
	private static final String TYPE__NOT_BELOW_MULTI = "notBelow(Multi)";
	private static final String TYPE__NOT_BELOW_OOO = "notBelow(One Out Of)";
	
	private static final String DESC__IS_BELOW = "The value is not below exclusive maximum!";
	private static final String DESC__IS_BELOW_MULTI = "At least one of the values is not below exclusive maximum!";
	private static final String DESC__IS_BELOW_OOO = "None of the values is below exclusive maximum!";
	private static final String DESC__NOT_BELOW = "The value is below exclusive maximum!";
	private static final String DESC__NOT_BELOW_MULTI = "At least one of the values is below exclusive maximum!";
	private static final String DESC__NOT_BELOW_OOO = "All of the values are below exclusive maximum!";
	
	static void isBelow(int stackreduction, int max, int value)
	{
		if(Check.notBelow(max, value))
		{
			ValidationError error = new ValidationError(TYPE__IS_BELOW, DESC__IS_BELOW);

			error.details.add("exclusive maximum: " + max);
			error.details.add("value: " + value);
			
			error.throwError(stackreduction);
		}
	}
	
	static void isBelow(int stackreduction, long max, long value)
	{
		if(Check.notBelow(max, value))
		{
			ValidationError error = new ValidationError(TYPE__IS_BELOW, DESC__IS_BELOW);

			error.details.add("exclusive maximum: " + max + "L");
			error.details.add("value: " + value + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isBelow(int stackreduction, float max, float value)
	{
		if(Check.notBelow(max, value))
		{
			ValidationError error = new ValidationError(TYPE__IS_BELOW, DESC__IS_BELOW);

			error.details.add("exclusive maximum: " + max + "F");
			error.details.add("value: " + value + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isBelow(int stackreduction, double max, double value)
	{
		if(Check.notBelow(max, value))
		{
			ValidationError error = new ValidationError(TYPE__IS_BELOW, DESC__IS_BELOW);

			error.details.add("exclusive maximum: " + max + "D");
			error.details.add("value: " + value + "D");
			
			error.throwError(stackreduction);
		}
	}
	
	
	static void isBelow(int stackreduction, int max, int... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.notBelow(max, values[i]))
			{
				builderIndices.append((count > 1 ? ", " : "") + i + 1);
				builderValues.append((count > 1 ? ", " : "") + values[i]);
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__IS_BELOW_MULIT, DESC__IS_BELOW_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("exclusive maximum: " + max);
			
			error.throwError(stackreduction);
		}
	}
	
	static void isBelow(int stackreduction, long max, long... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.notBelow(max, values[i]))
			{
				builderIndices.append((count > 1 ? ", " : "") + i + 1);
				builderValues.append((count > 1 ? ", " : "") + values[i]);
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__IS_BELOW_MULIT, DESC__IS_BELOW_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("exclusive maximum: " + max + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isBelow(int stackreduction, float max, float... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.notBelow(max, values[i]))
			{
				builderIndices.append((count > 1 ? ", " : "") + i + 1);
				builderValues.append((count > 1 ? ", " : "") + values[i]);
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__IS_BELOW_MULIT, DESC__IS_BELOW_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("exclusive maximum: " + max + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isBelow(int stackreduction, double max, double... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.notBelow(max, values[i]))
			{
				builderIndices.append((count > 1 ? ", " : "") + i + 1);
				builderValues.append((count > 1 ? ", " : "") + values[i]);
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__IS_BELOW_MULIT, DESC__IS_BELOW_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("exclusive maximum: " + max + "D");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isBelowOOO(int stackreduction, int max, int... values)
	{
		if(Check.notBelow(max, values))
		{
			ValidationError error = new ValidationError(TYPE__IS_BELOW_OOO, DESC__IS_BELOW_OOO);

			error.details.add("exclusive maximum: " + max);
			
			error.throwError(stackreduction);
		}
	}
	
	static void isBelowOOO(int stackreduction, long max, long... values)
	{
		if(Check.notBelow(max, values))
		{
			ValidationError error = new ValidationError(TYPE__IS_BELOW_OOO, DESC__IS_BELOW_OOO);

			error.details.add("exclusive maximum: " + max + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isBelowOOO(int stackreduction, float max, float... values)
	{
		if(Check.notBelow(max, values))
		{
			ValidationError error = new ValidationError(TYPE__IS_BELOW_OOO, DESC__IS_BELOW_OOO);

			error.details.add("exclusive maximum: " + max + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isBelowOOO(int stackreduction, double max, double... values)
	{
		if(Check.notBelow(max, values))
		{
			ValidationError error = new ValidationError(TYPE__IS_BELOW_OOO, DESC__IS_BELOW_OOO);

			error.details.add("exclusive maximum: " + max + "D");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notBelow(int stackreduction, int max, int value)
	{
		if(Check.isBelow(max, value))
		{
			ValidationError error = new ValidationError(TYPE__NOT_BELOW, DESC__NOT_BELOW);
			
			error.details.add("exclusive maximum: " + max);
			error.details.add("value: " + value);
			
			error.throwError(stackreduction);
		}
	}
	
	static void notBelow(int stackreduction, long max, long value)
	{
		if(Check.isBelow(max, value))
		{
			ValidationError error = new ValidationError(TYPE__NOT_BELOW, DESC__NOT_BELOW);
			
			error.details.add("exclusive maximum: " + max + "L");
			error.details.add("value: " + value + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notBelow(int stackreduction, float max, float value)
	{
		if(Check.isBelow(max, value))
		{
			ValidationError error = new ValidationError(TYPE__NOT_BELOW, DESC__NOT_BELOW);
			
			error.details.add("exclusive maximum: " + max + "F");
			error.details.add("value: " + value + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notBelow(int stackreduction, double max, double value)
	{
		if(Check.isBelow(max, value))
		{
			ValidationError error = new ValidationError(TYPE__NOT_BELOW, DESC__NOT_BELOW);
			
			error.details.add("exclusive maximum: " + max + "D");
			error.details.add("value: " + value + "D");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notBelow(int stackreduction, int max, int... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.isBelow(max, values[i]))
			{
				builderIndices.append((count > 1 ? ", " : "") + i + 1);
				builderValues.append((count > 1 ? ", " : "") + values[i]);
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__NOT_BELOW_MULTI, DESC__NOT_BELOW_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("exclusive maximum: " + max);
			
			error.throwError(stackreduction);
		}
	}
	
	static void notBelow(int stackreduction, long max, long... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.isBelow(max, values[i]))
			{
				builderIndices.append((count > 1 ? ", " : "") + i + 1);
				builderValues.append((count > 1 ? ", " : "") + values[i]);
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__NOT_BELOW_MULTI, DESC__NOT_BELOW_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("exclusive maximum: " + max + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notBelow(int stackreduction, float max, float... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.isBelow(max, values[i]))
			{
				builderIndices.append((count > 1 ? ", " : "") + i + 1);
				builderValues.append((count > 1 ? ", " : "") + values[i]);
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__NOT_BELOW_MULTI, DESC__NOT_BELOW_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("exclusive maximum: " + max + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notBelow(int stackreduction, double max, double... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.isBelow(max, values[i]))
			{
				builderIndices.append((count > 1 ? ", " : "") + i + 1);
				builderValues.append((count > 1 ? ", " : "") + values[i]);
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__NOT_BELOW_MULTI, DESC__NOT_BELOW_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("exclusive maximum: " + max + "D");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notBelowOOO(int stackreduction, int max, int... values)
	{
		if(Check.isBelow(max, values))
		{
			ValidationError error = new ValidationError(TYPE__NOT_BELOW_OOO, DESC__NOT_BELOW_OOO);

			error.details.add("exclusive maximum: " + max);
			
			error.throwError(stackreduction);
		}
	}
	
	static void notBelowOOO(int stackreduction, long max, long... values)
	{
		if(Check.isBelow(max, values))
		{
			ValidationError error = new ValidationError(TYPE__NOT_BELOW_OOO, DESC__NOT_BELOW_OOO);

			error.details.add("exclusive maximum: " + max + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notBelowOOO(int stackreduction, float max, float... values)
	{
		if(Check.isBelow(max, values))
		{
			ValidationError error = new ValidationError(TYPE__NOT_BELOW_OOO, DESC__NOT_BELOW_OOO);
			
			error.details.add("exclusive maximum: " + max + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notBelowOOO(int stackreduction, double max, double... values)
	{
		if(Check.isBelow(max, values))
		{
			ValidationError error = new ValidationError(TYPE__NOT_BELOW_OOO, DESC__NOT_BELOW_OOO);
			
			error.details.add("exclusive maximum: " + max + "D");
			
			error.throwError(stackreduction);
		}
	}
}

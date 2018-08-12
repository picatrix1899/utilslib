package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class ValidateInBetween
{
	private static String TYPE__IS_IN_BETWEEN = "isInBetween";
	private static String TYPE__IS_IN_BETWEEN_MULTI = "isInBetween(Multi)";
	private static String TYPE__IS_IN_BETWEEN_OOO = "isInBetween(One Out Of)";
	private static String TYPE__NOT_IN_BETWEEN = "notInBetween";
	private static String TYPE__NOT_IN_BETWEEN_MULTI = "notInBetween(Multi)";
	private static String TYPE__NOT_IN_BETWEEN_OOO = "notInBetween(One Out Of)";
	
	private static String DESC__IS_IN_BETWEEN = "The value is not between limits!";
	private static String DESC__IS_IN_BETWEEN_MULTI = "At least one of the values is not between limits!";
	private static String DESC__IS_IN_BETWEEN_OOO = "None of the values is between limits!";
	private static String DESC__NOT_IN_BETWEEN = "The value is between limits!";
	private static String DESC__NOT_IN_BETWEEN_MULTI = "At least one of the values is between limits!";
	private static String DESC__NOT_IN_BETWEEN_OOO = "All of the values is between limits!";
	
	static void isInBetween(int stackreduction, int min, int max, int value)
	{
		if(Check.notInBetween(min, max, value))
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_BETWEEN, DESC__IS_IN_BETWEEN);
			
			error.details.add("exclusive limits: [min: " + min + ", max: " + max + "]");
			error.details.add("value: " + value);
			
			error.throwError(stackreduction);
		}
	}
	
	static void isInBetween(int stackreduction, long min, long max, long value)
	{
		if(Check.notInBetween(min, max, value))
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_BETWEEN, DESC__IS_IN_BETWEEN);
			
			error.details.add("exclusive limits: [min: " + min + "L, max: " + max + "L]");
			error.details.add("value: " + value + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isInBetween(int stackreduction, float min, float max, float value)
	{
		if(Check.notInBetween(min, max, value))
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_BETWEEN, DESC__IS_IN_BETWEEN);
			
			error.details.add("exclusive limits: [min: " + min + "F, max: " + max + "F]");
			error.details.add("value: " + value + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isInBetween(int stackreduction, double min, double max, double value)
	{
		if(Check.notInBetween(min, max, value))
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_BETWEEN, DESC__IS_IN_BETWEEN);
			
			error.details.add("exclusive limits: [min: " + min + "D, max: " + max + "D]");
			error.details.add("value: " + value + "D");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isInBetween(int stackreduction, int min, int max, int... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.notInBetween(min, max, values[i]))
			{
				builderIndices.append((count > 0 ? ", " : "") + i + 1);
				builderValues.append((count > 0 ? ", " : "") + values[i]);
				count++;
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_BETWEEN_MULTI, DESC__IS_IN_BETWEEN_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("expected exclusive limits: [min: " + min + ", max: " + max + "]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isInBetween(int stackreduction, long min, long max, long... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.notInBetween(min, max, values[i]))
			{
				builderIndices.append((count > 0 ? ", " : "") + i + 1);
				builderValues.append((count > 0 ? ", " : "") + values[i]);
				count++;
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_BETWEEN_MULTI, DESC__IS_IN_BETWEEN_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("expected exclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isInBetween(int stackreduction, float min, float max, float... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.notInBetween(min, max, values[i]))
			{
				builderIndices.append((count > 0 ? ", " : "") + i + 1);
				builderValues.append((count > 0 ? ", " : "") + values[i]);
				count++;
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_BETWEEN_MULTI, DESC__IS_IN_BETWEEN_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("expected exclusive limits: [min: " + min + "F, max: " + max + "F]");
			
			error.throwError(stackreduction);
		}
	}

	static void isInBetween(int stackreduction, double min, double max, double... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.notInBetween(min, max, values[i]))
			{
				builderIndices.append((count > 0 ? ", " : "") + i + 1);
				builderValues.append((count > 0 ? ", " : "") + values[i]);
				count++;
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_BETWEEN_MULTI, DESC__IS_IN_BETWEEN_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("expected exclusive limits: [min: " + min + "D, max: " + max + "D]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isInBetweenOOO(int stackreduction, int min, int max, int... values)
	{
		if(Check.notInBetween(min, max, values))
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_BETWEEN_OOO, DESC__IS_IN_BETWEEN_OOO);
			
			error.details.add("exclusive limits: [min: " + min + ", max: " + max + "]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isInBetweenOOO(int stackreduction, long min, long max, long... values)
	{
		if(Check.notInBetween(min, max, values))
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_BETWEEN_OOO, DESC__IS_IN_BETWEEN_OOO);
			
			error.details.add("exclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isInBetweenOOO(int stackreduction,float min, float max, float... values)
	{
		if(Check.notInBetween(min, max, values))
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_BETWEEN_OOO, DESC__IS_IN_BETWEEN_OOO);
			
			error.details.add("exclusive limits: [min: " + min + "F, max: " + max + "F]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isInBetweenOOO(int stackreduction, double min, double max, double... values)
	{
		if(Check.notInBetween(min, max, values))
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_BETWEEN_OOO, DESC__IS_IN_BETWEEN_OOO);
			
			error.details.add("exclusive limits: [min: " + min + "D, max: " + max + "D]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notInBetween(int stackreduction, int min, int max, int value)
	{
		if(Check.isInBetween(min, max, value))
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_BETWEEN, DESC__NOT_IN_BETWEEN);
			
			error.details.add("exclusive limits: [min: " + min + ", max: " + max + "]");
			error.details.add("value: " + value);
			
			error.throwError(stackreduction);
		}
	}
	
	static void notInBetween(int stackreduction, long min, long max, long value)
	{
		if(Check.isInBetween(min, max, value))
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_BETWEEN, DESC__NOT_IN_BETWEEN);
			
			error.details.add("exclusive limits: [min: " + min + "L, max: " + max + "L]");
			error.details.add("value: " + value + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notInBetween(int stackreduction, float min, float max, float value)
	{
		if(Check.isInBetween(min, max, value))
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_BETWEEN, DESC__NOT_IN_BETWEEN);
			
			error.details.add("exclusive limits: [min: " + min + "F, max: " + max + "F]");
			error.details.add("value: " + value + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notInBetween(int stackreduction, double min, double max, double value)
	{
		if(Check.isInBetween(min, max, value))
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_BETWEEN, DESC__NOT_IN_BETWEEN);
			
			error.details.add("exclusive limits: [min: " + min + "D, max: " + max + "D]");
			error.details.add("value: " + value + "D");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notInBetween(int stackreduction, int min, int max, int... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.isInBetween(min, max, values[i]))
			{
				builderIndices.append((count > 0 ? ", " : "") + i + 1);
				builderValues.append((count > 0 ? ", " : "") + values[i]);
				count++;
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_BETWEEN_MULTI, DESC__NOT_IN_BETWEEN_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("expected exclusive limits: [min: " + min + ", max: " + max + "]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notInBetween(int stackreduction, long min, long max, long... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.isInBetween(min, max, values[i]))
			{
				builderIndices.append((count > 0 ? ", " : "") + i + 1);
				builderValues.append((count > 0 ? ", " : "") + values[i]);
				count++;
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_BETWEEN_MULTI, DESC__NOT_IN_BETWEEN_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("expected exclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notInBetween(int stackreduction, float min, float max, float... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.isInBetween(min, max, values[i]))
			{
				builderIndices.append((count > 0 ? ", " : "") + i + 1);
				builderValues.append((count > 0 ? ", " : "") + values[i]);
				count++;
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_BETWEEN_MULTI, DESC__NOT_IN_BETWEEN_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("expected exclusive limits: [min: " + min + "F, max: " + max + "F]");
			
			error.throwError(stackreduction);
		}
	}

	static void notInBetween(int stackreduction, double min, double max, double... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.isInBetween(min, max, values[i]))
			{
				builderIndices.append((count > 0 ? ", " : "") + i + 1);
				builderValues.append((count > 0 ? ", " : "") + values[i]);
				count++;
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_BETWEEN_MULTI, DESC__NOT_IN_BETWEEN_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("expected exclusive limits: [min: " + min + "D, max: " + max + "D]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notInBetweenOOO(int stackreduction, int min, int max, int... values)
	{
		if(Check.isInBetween(min, max, values))
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_BETWEEN_OOO, DESC__NOT_IN_BETWEEN_OOO);
			
			error.details.add("exclusive limits: [min: " + min + ", max: " + max + "]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notInBetweenOOO(int stackreduction, long min, long max, long... values)
	{
		if(Check.isInBetween(min, max, values))
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_BETWEEN_OOO, DESC__NOT_IN_BETWEEN_OOO);
			
			error.details.add("exclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notInBetweenOOO(int stackreduction,float min, float max, float... values)
	{
		if(Check.isInBetween(min, max, values))
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_BETWEEN_OOO, DESC__NOT_IN_BETWEEN_OOO);
			
			error.details.add("exclusive limits: [min: " + min + "F, max: " + max + "F]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notInBetweenOOO(int stackreduction, double min, double max, double... values)
	{
		if(Check.isInBetween(min, max, values))
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_BETWEEN_OOO, DESC__NOT_IN_BETWEEN_OOO);
			
			error.details.add("exclusive limits: [min: " + min + "D, max: " + max + "D]");
			
			error.throwError(stackreduction);
		}
	}
	
}

package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class ValidateInRange
{
	private static final String TYPE__IS_IN_RANGE = "isInRange";
	private static final String TYPE__IS_IN_RANGE_MULTI = "isInRange(Multi)";
	private static final String TYPE__IS_IN_RANGE_OOO = "isInRange(One Out Of)";
	private static final String TYPE__NOT_IN_RANGE = "notInRange";
	private static final String TYPE__NOT_IN_RANGE_MULTI = "notInRange(Multi)";
	private static final String TYPE__NOT_IN_RANGE_OOO = "notInRange(One Out Of)";
	
	private static final String DESC__IS_IN_RANGE = "The value is not in range!";
	private static final String DESC__IS_IN_RANGE_MULTI ="At least one of the values is not in range!";
	private static final String DESC__IS_IN_RANGE_OOO = "None of the values is in range!";
	private static final String DESC__NOT_IN_RANGE = "The value is in Range!";
	private static final String DESC__NOT_IN_RANGE_MULTI = "At least one of the values is in range!";
	private static final String DESC__NOT_IN_RANGE_OOO = "All of the values are in range!";
	
	static void isInRange(int stackreduction, int min, int max, int value)
	{
		if(Check.notInRange(min, max, value))
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_RANGE, DESC__IS_IN_RANGE);
			
			error.details.add("inclusive limits: [min: " + min + ", max: " + max + "]");
			error.details.add("value: " + value);
			
			error.throwError(stackreduction);
		}
	}
	
	static void isInRange(int stackreduction, long min, long max, long value)
	{
		if(Check.notInRange(min, max, value))
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_RANGE, DESC__IS_IN_RANGE);
			
			error.details.add("inclusive limits: [min: " + min + "L, max: " + max + "L]");
			error.details.add("value: " + value + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isInRange(int stackreduction, float min, float max, float value)
	{
		if(Check.notInRange(min, max, value))
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_RANGE, DESC__IS_IN_RANGE);
			
			error.details.add("inclusive limits: [min: " + min + "F, max: " + max + "F]");
			error.details.add("value: " + value + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isInRange(int stackreduction, double min, double max, double value)
	{
		if(Check.notInRange(min, max, value))
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_RANGE, DESC__IS_IN_RANGE);
			
			error.details.add("inclusive limits: [min: " + min + "D, max: " + max + "D]");
			error.details.add("value: " + value + "D");
			
			error.throwError(stackreduction);;
		}
	}
	
	static void isInRange(int stackreduction, int min, int max, int... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.notInRange(min, max, values[i]))
			{
				builderIndices.append((count > 0 ? "," : "") + i + 1);
				builderValues.append((count > 0 ? "," : "") + values[i]);
				count++;
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_RANGE_MULTI, DESC__IS_IN_RANGE_MULTI);

			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("expected inclusive limits: [min: " + min + ", max: " + max + "]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isInRange(int stackreduction, long min, long max, long... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.notInRange(min, max, values[i]))
			{
				builderIndices.append((count > 0 ? "," : "") + i + 1);
				builderValues.append((count > 0 ? "," : "") + values[i]);
				count++;
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_RANGE_MULTI, DESC__IS_IN_RANGE_MULTI);

			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("expected inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isInRange(int stackreduction, float min, float max, float... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.notInRange(min, max, values[i]))
			{
				builderIndices.append((count > 0 ? "," : "") + i + 1);
				builderValues.append((count > 0 ? "," : "") + values[i]);
				count++;
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_RANGE_MULTI, DESC__IS_IN_RANGE_MULTI);

			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("expected inclusive limits: [min: " + min + "F, max: " + max + "F]");
			
			error.throwError(stackreduction);
		}
	}

	static void isInRange(int stackreduction, double min, double max, double... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.notInRange(min, max, values[i]))
			{
				builderIndices.append((count > 0 ? "," : "") + i + 1);
				builderValues.append((count > 0 ? "," : "") + values[i]);
				count++;
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_RANGE_MULTI, DESC__IS_IN_RANGE_MULTI);

			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("expected inclusive limits: [min: " + min + "D, max: " + max + "D]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isInRangeOOO(int stackreduction, int min, int max, int... values)
	{
		if(Check.notInRange(min, max, values))
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_RANGE_OOO, DESC__IS_IN_RANGE_OOO);
			
			error.details.add("inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isInRangeOOO(int stackreduction, long min, long max, long... values)
	{
		if(Check.notInRange(min, max, values))
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_RANGE_OOO, DESC__IS_IN_RANGE_OOO);
			
			error.details.add("inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isInRangeOOO(int stackreduction,float min, float max, float... values)
	{
		if(Check.notInRange(min, max, values))
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_RANGE_OOO, DESC__IS_IN_RANGE_OOO);
			
			error.details.add("inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isInRangeOOO(int stackreduction, double min, double max, double... values)
	{
		if(Check.notInRange(min, max, values))
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_RANGE_OOO, DESC__IS_IN_RANGE_OOO);
			
			error.details.add("inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notInRange(int stackreduction, int min, int max, int value)
	{
		if(Check.isInRange(min, max, value))
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_RANGE, DESC__NOT_IN_RANGE);
			
			error.details.add("inclusive limits: [min: " + min + ", max: " + max + "]");
			error.details.add("value: " + value);
			
			error.throwError(stackreduction);
		}
	}
	
	static void notInRange(int stackreduction, long min, long max, long value)
	{
		if(Check.isInRange(min, max, value))
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_RANGE, DESC__NOT_IN_RANGE);
			
			error.details.add("inclusive limits: [min: " + min + "L, max: " + max + "L]");
			error.details.add("value: " + value + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notInRange(int stackreduction, float min, float max, float value)
	{
		if(Check.isInRange(min, max, value))
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_RANGE, DESC__NOT_IN_RANGE);
			
			error.details.add("inclusive limits: [min: " + min + "F, max: " + max + "F]");
			error.details.add("value: " + value + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notInRange(int stackreduction, double min, double max, double value)
	{
		if(Check.isInRange(min, max, value))
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_RANGE, DESC__NOT_IN_RANGE);
			
			error.details.add("inclusive limits: [min: " + min + "D, max: " + max + "D]");
			error.details.add("value: " + value + "D");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notInRange(int stackreduction, int min, int max, int... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.notInRange(min, max, values[i]))
			{
				builderIndices.append((count > 0 ? "," : "") + i + 1);
				builderValues.append((count > 0 ? "," : "") + values[i]);
				count++;
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_RANGE_MULTI, DESC__NOT_IN_RANGE_MULTI);

			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("expected inclusive limits: [min: " + min + ", max: " + max + "]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notInRange(int stackreduction, long min, long max, long... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.notInRange(min, max, values[i]))
			{
				builderIndices.append((count > 0 ? "," : "") + i + 1);
				builderValues.append((count > 0 ? "," : "") + values[i]);
				count++;
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_RANGE_MULTI, DESC__NOT_IN_RANGE_MULTI);

			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("expected inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notInRange(int stackreduction, float min, float max, float... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.notInRange(min, max, values[i]))
			{
				builderIndices.append((count > 0 ? "," : "") + i + 1);
				builderValues.append((count > 0 ? "," : "") + values[i]);
				count++;
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_RANGE_MULTI, DESC__NOT_IN_RANGE_MULTI);

			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("expected inclusive limits: [min: " + min + "F, max: " + max + "F]");
			
			error.throwError(stackreduction);
		}
	}

	static void notInRange(int stackreduction, double min, double max, double... values)
	{
		StringBuilder builderIndices = new StringBuilder();
		StringBuilder builderValues = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
			if(Check.notInRange(min, max, values[i]))
			{
				builderIndices.append((count > 0 ? "," : "") + i + 1);
				builderValues.append((count > 0 ? "," : "") + values[i]);
				count++;
			}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_RANGE_MULTI, DESC__NOT_IN_RANGE_MULTI);

			error.details.add("failed indices(1 based): " + "[" + builderIndices.toString() + "]");
			error.details.add("failed values: [" + builderValues.toString() + "]");
			error.details.add("total failed: " + count);
			error.details.add("expected inclusive limits: [min: " + min + "D, max: " + max + "D]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notInRangeOOO(int stackreduction, int min, int max, int... values)
	{
		if(Check.isInRange(min, max, values))
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_RANGE_OOO, DESC__NOT_IN_RANGE_OOO);
			
			error.details.add("inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notInRangeOOO(int stackreduction, long min, long max, long... values)
	{
		if(Check.isInRange(min, max, values))
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_RANGE_OOO, DESC__NOT_IN_RANGE_OOO);
			
			error.details.add("inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notInRangeOOO(int stackreduction,float min, float max, float... values)
	{
		if(Check.isInRange(min, max, values))
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_RANGE_OOO, DESC__NOT_IN_RANGE_OOO);
			
			error.details.add("inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notInRangeOOO(int stackreduction, double min, double max, double... values)
	{
		if(Check.isInRange(min, max, values))
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_RANGE_OOO, DESC__NOT_IN_RANGE_OOO);
			
			error.details.add("inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			error.throwError(stackreduction);
		}
	}
}

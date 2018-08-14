package cmn.utilslib.validation;

import java.util.ArrayList;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.essentials.Check;

public class ValidateInRange
{
	private static final String TYPE__IS_IN_RANGE = "";
	private static final String TYPE__IS_IN_RANGE_MULTI = "";
	private static final String TYPE__IS_IN_RANGE_OOO = "";
	private static final String TYPE__NOT_IN_RANGE = "";
	private static final String TYPE__NOT_IN_RANGE_MULTI = "";
	private static final String TYPE__NOT_IN_RANGE_OOO = "";
	
	private static final String DESC__IS_IN_RANGE = "";
	private static final String DESC__IS_IN_RANGE_MULTI = "";
	private static final String DESC__IS_IN_RANGE_OOO = "";
	private static final String DESC__NOT_IN_RANGE = "";
	private static final String DESC__NOT_IN_RANGE_MULTI = "";
	private static final String DESC__NOT_IN_RANGE_OOO = "";
	
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
		ArrayList<Integer> indices = Auto.ArrayList(); 
		ArrayList<Integer> vals = Auto.ArrayList();
		
		for(int i = 0; i < values.length; i++)
			if(Check.notInRange(min, max, values[i]))
			{
				indices.add(i);
				vals.add(values[i]);
			}
		
		if(indices.size() > 0)
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_RANGE_MULTI, DESC__IS_IN_RANGE_MULTI);
			
			StringBuilder builder1 = new StringBuilder();
			StringBuilder builder2 = new StringBuilder();
			
			for(int i = 0; i < indices.size(); i++)
				builder1.append(indices.get(i) + 1).append(i == indices.size() - 1 ? "" : ", ");
			
			for(int i = 0; i < vals.size(); i++)
				builder2.append(vals.get(i)).append(i == vals.size() - 1 ? "" : ", ");
				
			error.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			error.details.add("failed values: [" + builder2.toString() + "]");
			error.details.add("total failed: " + indices.size());
			error.details.add("expected inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isInRange(int stackreduction, long min, long max, long... values)
	{
		ArrayList<Integer> indices = Auto.ArrayList(); 
		ArrayList<Long> vals = Auto.ArrayList();
		
		for(int i = 0; i < values.length; i++)
			if(Check.notInRange(min, max, values[i]))
			{
				indices.add(i);
				vals.add(values[i]);
			}
		
		if(indices.size() > 0)
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_RANGE_MULTI, DESC__IS_IN_RANGE_MULTI);
			
			StringBuilder builder1 = new StringBuilder();
			StringBuilder builder2 = new StringBuilder();
			
			for(int i = 0; i < indices.size(); i++)
				builder1.append(indices.get(i) + 1).append(i == indices.size() - 1 ? "" : ", ");
			
			for(int i = 0; i < vals.size(); i++)
				builder2.append(vals.get(i) + "L").append(i == vals.size() - 1 ? "" : ", ");
				
			error.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			error.details.add("failed values: [" + builder2.toString() + "]");
			error.details.add("total failed: " + indices.size());
			error.details.add("expected inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isInRange(int stackreduction, float min, float max, float... values)
	{
		ArrayList<Integer> indices = Auto.ArrayList(); 
		ArrayList<Float> vals = Auto.ArrayList();
		
		for(int i = 0; i < values.length; i++)
			if(Check.notInRange(min, max, values[i]))
			{
				indices.add(i);
				vals.add(values[i]);
			}
		
		if(indices.size() > 0)
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_RANGE_MULTI, DESC__IS_IN_RANGE_MULTI);
			
			StringBuilder builder1 = new StringBuilder();
			StringBuilder builder2 = new StringBuilder();
			
			for(int i = 0; i < indices.size(); i++)
				builder1.append(indices.get(i) + 1).append(i == indices.size() - 1 ? "" : ", ");
			
			for(int i = 0; i < vals.size(); i++)
				builder2.append(vals.get(i) + "F").append(i == vals.size() - 1 ? "" : ", ");
				
			error.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			error.details.add("failed values: [" + builder2.toString() + "]");
			error.details.add("total failed: " + indices.size());
			error.details.add("expected inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			error.throwError(stackreduction);
		}
	}

	static void isInRange(int stackreduction, double min, double max, double... values)
	{
		ArrayList<Integer> indices = Auto.ArrayList(); 
		ArrayList<Double> vals = Auto.ArrayList();
		
		for(int i = 0; i < values.length; i++)
			if(Check.notInRange(min, max, values[i]))
			{
				indices.add(i);
				vals.add(values[i]);
			}
		
		if(indices.size() > 0)
		{
			ValidationError error = new ValidationError(TYPE__IS_IN_RANGE_MULTI, DESC__IS_IN_RANGE_MULTI);
			
			StringBuilder builder1 = new StringBuilder();
			StringBuilder builder2 = new StringBuilder();
			
			for(int i = 0; i < indices.size(); i++)
				builder1.append(indices.get(i) + 1).append(i == indices.size() - 1 ? "" : ", ");
			
			for(int i = 0; i < vals.size(); i++)
				builder2.append(vals.get(i) + "D").append(i == vals.size() - 1 ? "" : ", ");
				
			error.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			error.details.add("failed values: [" + builder2.toString() + "]");
			error.details.add("total failed: " + indices.size());
			error.details.add("expected inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
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
		ArrayList<Integer> indices = Auto.ArrayList(); 
		ArrayList<Integer> vals = Auto.ArrayList();
		
		for(int i = 0; i < values.length; i++)
			if(Check.isInRange(min, max, values[i]))
			{
				indices.add(i);
				vals.add(values[i]);
			}
		
		if(indices.size() > 0)
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_RANGE_MULTI, DESC__NOT_IN_RANGE_MULTI);
			
			StringBuilder builder1 = new StringBuilder();
			StringBuilder builder2 = new StringBuilder();
			
			for(int i = 0; i < indices.size(); i++)
				builder1.append(indices.get(i) + 1).append(i == indices.size() - 1 ? "" : ", ");
			
			for(int i = 0; i < vals.size(); i++)
				builder2.append(vals.get(i)).append(i == vals.size() - 1 ? "" : ", ");
				
			error.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			error.details.add("failed values: [" + builder2.toString() + "]");
			error.details.add("total failed: " + indices.size());
			error.details.add("expected inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notInRange(int stackreduction, long min, long max, long... values)
	{
		ArrayList<Integer> indices = Auto.ArrayList(); 
		ArrayList<Long> vals = Auto.ArrayList();
		
		for(int i = 0; i < values.length; i++)
			if(Check.isInRange(min, max, values[i]))
			{
				indices.add(i);
				vals.add(values[i]);
			}
		
		if(indices.size() > 0)
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_RANGE_MULTI, DESC__NOT_IN_RANGE_MULTI);
			
			StringBuilder builder1 = new StringBuilder();
			StringBuilder builder2 = new StringBuilder();
			
			for(int i = 0; i < indices.size(); i++)
				builder1.append(indices.get(i) + 1).append(i == indices.size() - 1 ? "" : ", ");
			
			for(int i = 0; i < vals.size(); i++)
				builder2.append(vals.get(i) + "L").append(i == vals.size() - 1 ? "" : ", ");
				
			error.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			error.details.add("failed values: [" + builder2.toString() + "]");
			error.details.add("total failed: " + indices.size());
			error.details.add("expected inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notInRange(int stackreduction, float min, float max, float... values)
	{
		ArrayList<Integer> indices = Auto.ArrayList(); 
		ArrayList<Float> vals = Auto.ArrayList();
		
		for(int i = 0; i < values.length; i++)
			if(Check.isInRange(min, max, values[i]))
			{
				indices.add(i);
				vals.add(values[i]);
			}
		
		if(indices.size() > 0)
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_RANGE_MULTI, DESC__NOT_IN_RANGE_MULTI);
			
			StringBuilder builder1 = new StringBuilder();
			StringBuilder builder2 = new StringBuilder();
			
			for(int i = 0; i < indices.size(); i++)
				builder1.append(indices.get(i) + 1).append(i == indices.size() - 1 ? "" : ", ");
			
			for(int i = 0; i < vals.size(); i++)
				builder2.append(vals.get(i) + "F").append(i == vals.size() - 1 ? "" : ", ");
				
			error.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			error.details.add("failed values: [" + builder2.toString() + "]");
			error.details.add("total failed: " + indices.size());
			error.details.add("expected inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			error.throwError(stackreduction);
		}
	}

	static void notInRange(int stackreduction, double min, double max, double... values)
	{
		ArrayList<Integer> indices = Auto.ArrayList(); 
		ArrayList<Double> vals = Auto.ArrayList();
		
		for(int i = 0; i < values.length; i++)
			if(Check.isInRange(min, max, values[i]))
			{
				indices.add(i);
				vals.add(values[i]);
			}
		
		if(indices.size() > 0)
		{
			ValidationError error = new ValidationError(TYPE__NOT_IN_RANGE_MULTI, DESC__NOT_IN_RANGE_MULTI);
			
			StringBuilder builder1 = new StringBuilder();
			StringBuilder builder2 = new StringBuilder();
			
			for(int i = 0; i < indices.size(); i++)
				builder1.append(indices.get(i) + 1).append(i == indices.size() - 1 ? "" : ", ");
			
			for(int i = 0; i < vals.size(); i++)
				builder2.append(vals.get(i) + "D").append(i == vals.size() - 1 ? "" : ", ");
				
			error.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			error.details.add("failed values: [" + builder2.toString() + "]");
			error.details.add("total failed: " + indices.size());
			error.details.add("expected inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
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

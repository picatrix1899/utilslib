package cmn.utilslib.validation;

import java.util.ArrayList;

import cmn.utilslib.essentials.Check;

class ValidateBelow
{
	
	static void isBelow(int stackreduction, int max, int value)
	{
		if(Check.notBelow(max, value))
		{
			ValidationError error = new ValidationError("isBelow", "The value is not below threshold!");

			error.details.add("exclusive maximum threshold: " + max);
			error.details.add("value: " + value);
			
			error.throwError(stackreduction);
		}
	}
	
	static void isBelow(int stackreduction, long max, long value)
	{
		if(Check.notBelow(max, value))
		{
			ValidationError error = new ValidationError("isBelow", "The value is not below threshold!");

			error.details.add("exclusive maximum threshold: " + max + "L");
			error.details.add("value: " + value + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isBelow(int stackreduction, float max, float value)
	{
		if(Check.notBelow(max, value))
		{
			ValidationError error = new ValidationError("isBelow", "The value is not below threshold!");

			error.details.add("exclusive maximum threshold: " + max + "F");
			error.details.add("value: " + value + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isBelow(int stackreduction, double max, double value)
	{
		if(Check.notBelow(max, value))
		{
			ValidationError error = new ValidationError("isBelow", "The value is not below threshold!");

			error.details.add("exclusive maximum threshold: " + max + "D");
			error.details.add("value: " + value + "D");
			
			error.throwError(stackreduction);
		}
	}
	
	
	static void isBelow(int stackreduction, int max, int... values)
	{
		ArrayList<Integer> indices = new ArrayList<Integer>();
		ArrayList<Integer> vals = new ArrayList<Integer>();
		
		for(int i = 0; i < values.length; i++)
			if(Check.notBelow(max, values[i]))
			{
				indices.add(i);
				vals.add(values[i]);
			}
		
		if(indices.size() > 0)
		{
			StringBuilder builder1 = new StringBuilder();
			StringBuilder builder2 = new StringBuilder();
			
			for(int i = 0; i < indices.size(); i++)
				builder1.append(indices.get(i) + 1).append(i == indices.size() - 1 ? "" : ", ");
			
			for(int i = 0; i < vals.size(); i++)
				builder2.append(vals.get(i)).append(i == vals.size() - 1 ? "" : ", ");
				
			ValidationError error = new ValidationError("isBelow(Multi)", "At least one of the values is not below exclusive maximum threshold!");
			
			error.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			error.details.add("failed values: [" + builder2.toString() + "]");
			error.details.add("total failed: " + indices.size());
			error.details.add("exclusive maximum threshold: " + max);
			
			error.throwError(stackreduction);
		}
	}
	
	static void isBelow(int stackreduction, long max, long... values)
	{
		ArrayList<Integer> indices = new ArrayList<Integer>();
		ArrayList<Long> vals = new ArrayList<Long>();
		
		for(int i = 0; i < values.length; i++)
			if(Check.notBelow(max, values[i]))
			{
				indices.add(i);
				vals.add(values[i]);
			}
		
		if(indices.size() > 0)
		{
			StringBuilder builder1 = new StringBuilder();
			StringBuilder builder2 = new StringBuilder();
			
			for(int i = 0; i < indices.size(); i++)
				builder1.append(indices.get(i) + 1).append(i == indices.size() - 1 ? "" : ", ");
			
			for(int i = 0; i < vals.size(); i++)
				builder2.append(vals.get(i)).append(i == vals.size() - 1 ? "" : ", ");
			
			ValidationError error = new ValidationError("isBelow(Multi)", "At least one of the values is not below exclusive maximum threshold!");
			
			error.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			error.details.add("failed values: [" + builder2.toString() + "]");
			error.details.add("total failed: " + indices.size());
			error.details.add("exclusive maximum threshold: " + max + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isBelow(int stackreduction, float max, float... values)
	{
		ArrayList<Integer> indices = new ArrayList<Integer>();
		ArrayList<Float> vals = new ArrayList<Float>();
		
		for(int i = 0; i < values.length; i++)
			if(Check.notBelow(max, values[i]))
			{
				indices.add(i);
				vals.add(values[i]);
			}
		
		if(indices.size() > 0)
		{
			StringBuilder builder1 = new StringBuilder();
			StringBuilder builder2 = new StringBuilder();
			
			for(int i = 0; i < indices.size(); i++)
				builder1.append(indices.get(i) + 1).append(i == indices.size() - 1 ? "" : ", ");
			
			for(int i = 0; i < vals.size(); i++)
				builder2.append(vals.get(i)).append(i == vals.size() - 1 ? "" : ", ");
				
			ValidationError error = new ValidationError("isBelow(Multi)", "At least one of the values is not below exclusive maximum threshold!");
			
			error.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			error.details.add("failed values: [" + builder2.toString() + "]");
			error.details.add("total failed: " + indices.size());
			error.details.add("exclusive maximum threshold: " + max + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isBelow(int stackreduction, double max, double... values)
	{
		ArrayList<Integer> indices = new ArrayList<Integer>();
		ArrayList<Double> vals = new ArrayList<Double>();
		
		for(int i = 0; i < values.length; i++)
			if(Check.notBelow(max, values[i]))
			{
				indices.add(i);
				vals.add(values[i]);
			}
		
		if(indices.size() > 0)
		{
			StringBuilder builder1 = new StringBuilder();
			StringBuilder builder2 = new StringBuilder();
			
			for(int i = 0; i < indices.size(); i++)
				builder1.append(indices.get(i) + 1).append(i == indices.size() - 1 ? "" : ", ");
			
			for(int i = 0; i < vals.size(); i++)
				builder2.append(vals.get(i)).append(i == vals.size() - 1 ? "" : ", ");
			
			ValidationError error = new ValidationError("isBelow(Multi)", "At least one of the values is not below exclusive maximum threshold!");
			
			error.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			error.details.add("failed values: [" + builder2.toString() + "]");
			error.details.add("total failed: " + indices.size());
			error.details.add("exclusive maximum threshold: " + max + "D");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isBelowOOO(int stackreduction, int max, int... values)
	{
		if(Check.notBelow(max, values))
		{
			ValidationError error = new ValidationError("isBelow(One Out Of)", "None of the values is below exclusive maximum threshold!");

			error.details.add("exclusive maximum threshold: " + max);
			
			error.throwError(stackreduction);
		}
	}
	
	static void isBelowOOO(int stackreduction, long max, long... values)
	{
		if(Check.notBelow(max, values))
		{
			ValidationError error = new ValidationError("isBelow(One Out Of)", "None of the values is below exclusive maximum threshold!");

			error.details.add("exclusive maximum threshold: " + max + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isBelowOOO(int stackreduction, float max, float... values)
	{
		if(Check.notBelow(max, values))
		{
			ValidationError error = new ValidationError("isBelow(One Out Of)", "None of the values is below exclusive maximum threshold!");

			error.details.add("exclusive maximum threshold: " + max + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isBelowOOO(int stackreduction, double max, double... values)
	{
		if(Check.notBelow(max, values))
		{
			ValidationError error = new ValidationError("isBelow(One Out Of)", "None of the values is below exclusive maximum threshold!");

			error.details.add("exclusive maximum threshold: " + max + "D");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notBelow(int stackreduction, int max, int value)
	{
		if(Check.isBelow(max, value))
		{
			ValidationError error = new ValidationError("notBelow", "The value is below threshold!");
			
			error.details.add("exclusive maximum threshold: " + max);
			error.details.add("value: " + value);
			
			error.throwError(stackreduction);
		}
	}
	
	static void notBelow(int stackreduction, long max, long value)
	{
		if(Check.isBelow(max, value))
		{
			ValidationError error = new ValidationError("notBelow", "The value is below threshold!");
			
			error.details.add("exclusive maximum threshold: " + max + "L");
			error.details.add("value: " + value + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notBelow(int stackreduction, float max, float value)
	{
		if(Check.isBelow(max, value))
		{
			ValidationError error = new ValidationError("notBelow", "The value is below threshold!");
			
			error.details.add("exclusive maximum threshold: " + max + "F");
			error.details.add("value: " + value + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notBelow(int stackreduction, double max, double value)
	{
		if(Check.isBelow(max, value))
		{
			ValidationError error = new ValidationError("notBelow", "The value is below threshold!");
			
			error.details.add("exclusive maximum threshold: " + max + "D");
			error.details.add("value: " + value + "D");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notBelow(int stackreduction, int max, int... values)
	{
		ArrayList<Integer> indices = new ArrayList<Integer>();
		ArrayList<Integer> vals = new ArrayList<Integer>();
		
		for(int i = 0; i < values.length; i++)
			if(Check.isBelow(max, values[i]))
			{
				indices.add(i);
				vals.add(values[i]);
			}
		
		if(indices.size() > 0)
		{
			StringBuilder builder1 = new StringBuilder();
			StringBuilder builder2 = new StringBuilder();
			
			for(int i = 0; i < indices.size(); i++)
				builder1.append(indices.get(i) + 1).append(i == indices.size() - 1 ? "" : ", ");
			
			for(int i = 0; i < vals.size(); i++)
				builder2.append(vals.get(i)).append(i == vals.size() - 1 ? "" : ", ");
				
			ValidationError error = new ValidationError("notBelow(Multi)", "At least one of the values is below exclusive maximum threshold!");
			
			error.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			error.details.add("failed values: [" + builder2.toString() + "]");
			error.details.add("total failed: " + indices.size());
			error.details.add("exclusive maximum threshold: " + max);
			
			error.throwError(stackreduction);
		}
	}
	
	static void notBelow(int stackreduction, long max, long... values)
	{
		ArrayList<Integer> indices = new ArrayList<Integer>();
		ArrayList<Long> vals = new ArrayList<Long>();
		
		for(int i = 0; i < values.length; i++)
			if(Check.isBelow(max, values[i]))
			{
				indices.add(i);
				vals.add(values[i]);
			}
		
		if(indices.size() > 0)
		{
			StringBuilder builder1 = new StringBuilder();
			StringBuilder builder2 = new StringBuilder();
			
			for(int i = 0; i < indices.size(); i++)
				builder1.append(indices.get(i) + 1).append(i == indices.size() - 1 ? "" : ", ");
			
			for(int i = 0; i < vals.size(); i++)
				builder2.append(vals.get(i)).append(i == vals.size() - 1 ? "" : ", ");
				
			ValidationError error = new ValidationError("notBelow(Multi)", "At least one of the values is below exclusive maximum threshold!");
			
			error.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			error.details.add("failed values: [" + builder2.toString() + "]");
			error.details.add("total failed: " + indices.size());
			error.details.add("exclusive maximum threshold: " + max + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notBelow(int stackreduction, float max, float... values)
	{
		ArrayList<Integer> indices = new ArrayList<Integer>();
		ArrayList<Float> vals = new ArrayList<Float>();
		
		for(int i = 0; i < values.length; i++)
			if(Check.isBelow(max, values[i]))
			{
				indices.add(i);
				vals.add(values[i]);
			}
		
		if(indices.size() > 0)
		{
			StringBuilder builder1 = new StringBuilder();
			StringBuilder builder2 = new StringBuilder();
			
			for(int i = 0; i < indices.size(); i++)
				builder1.append(indices.get(i) + 1).append(i == indices.size() - 1 ? "" : ", ");
			
			for(int i = 0; i < vals.size(); i++)
				builder2.append(vals.get(i)).append(i == vals.size() - 1 ? "" : ", ");
				
			ValidationError error = new ValidationError("notBelow(Multi)", "At least one of the values is below exclusive maximum threshold!");
			
			error.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			error.details.add("failed values: [" + builder2.toString() + "]");
			error.details.add("total failed: " + indices.size());
			error.details.add("exclusive maximum threshold: " + max + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notBelow(int stackreduction, double max, double... values)
	{
		ArrayList<Integer> indices = new ArrayList<Integer>();
		ArrayList<Double> vals = new ArrayList<Double>();
		
		for(int i = 0; i < values.length; i++)
			if(Check.isBelow(max, values[i]))
			{
				indices.add(i);
				vals.add(values[i]);
			}
		
		if(indices.size() > 0)
		{
			StringBuilder builder1 = new StringBuilder();
			StringBuilder builder2 = new StringBuilder();
			
			for(int i = 0; i < indices.size(); i++)
				builder1.append(indices.get(i) + 1).append(i == indices.size() - 1 ? "" : ", ");
			
			for(int i = 0; i < vals.size(); i++)
				builder2.append(vals.get(i)).append(i == vals.size() - 1 ? "" : ", ");
				
			ValidationError error = new ValidationError("notBelow(Multi)", "At least one of the values is below exclusive maximum threshold!");
			
			error.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			error.details.add("failed values: [" + builder2.toString() + "]");
			error.details.add("total failed: " + indices.size());
			error.details.add("exclusive maximum threshold: " + max + "D");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notBelowOOO(int stackreduction, int max, int... values)
	{
		if(Check.isBelow(max, values))
		{
			ValidationError error = new ValidationError("notBelow(One Out Of)", "All of the values are below exclusive maximum threshold!");

			error.details.add("exclusive maximum threshold: " + max);
			
			error.throwError(stackreduction);
		}
	}
	
	static void notBelowOOO(int stackreduction, long max, long... values)
	{
		if(Check.isBelow(max, values))
		{
			ValidationError error = new ValidationError("notBelow(One Out Of)", "All of the values are below exclusive maximum threshold!");

			error.details.add("exclusive maximum threshold: " + max + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notBelowOOO(int stackreduction, float max, float... values)
	{
		if(Check.isBelow(max, values))
		{
			ValidationError error = new ValidationError("notBelow(One Out Of)", "All of the values are below exclusive maximum threshold!");
			
			error.details.add("exclusive maximum threshold: " + max + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notBelowOOO(int stackreduction, double max, double... values)
	{
		if(Check.isBelow(max, values))
		{
			ValidationError error = new ValidationError("notBelow(One Out Of)", "All of the values are below exclusive maximum threshold!");
			
			error.details.add("exclusive maximum threshold: " + max + "D");
			
			error.throwError(stackreduction);
		}
	}
}

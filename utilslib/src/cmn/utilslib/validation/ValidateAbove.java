package cmn.utilslib.validation;

import java.util.ArrayList;

import cmn.utilslib.essentials.Check;

class ValidateAbove
{
	static void isAbove(int stackreduction, int min, int value)
	{
		if(Check.notAbove(min, value))
		{
			ValidationError error = new ValidationError("isAbove", "The value is not above threshold!");
			
			error.details.add("exclusive minimum threshold: " + min);
			error.details.add("value: " + value);
			
			error.throwError(stackreduction);
		}
	}
	
	static void isAbove(int stackreduction, long min, long value)
	{
		if(Check.notAbove(min, value))
		{
			ValidationError error = new ValidationError("isAbove", "The value is not above threshold!");
			
			error.details.add("exclusive minimum threshold: " + min + "L");
			error.details.add("value: " + value + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isAbove(int stackreduction, float min, float value)
	{
		if(Check.notAbove(min, value))
		{
			ValidationError error = new ValidationError("isAbove", "The value is not above threshold!");
			
			error.details.add("exclusive minimum threshold: " + min + "F");
			error.details.add("value: " + value + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isAbove(int stackreduction, double min, double value)
	{
		if(Check.notAbove(min, value))
		{
			ValidationError error = new ValidationError("isAbove", "The value is not above threshold!");
			
			error.details.add("exclusive minimum threshold: " + min + "D");
			error.details.add("value: " + value + "D");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isAbove(int stackreduction, int min, int... values)
	{
		ArrayList<Integer> indices = new ArrayList<Integer>();
		ArrayList<Integer> vals = new ArrayList<Integer>();
		
		for(int i = 0; i < values.length; i++)
			if(Check.notAbove(min, values[i]))
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
			
			ValidationError error = new ValidationError("isAbove(Multi)", "At least one of the values is not above exclusive minimum threshold!");
			
			error.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			error.details.add("failed values: [" + builder2.toString() + "]");
			error.details.add("total failed: " + indices.size());
			error.details.add("exclusive minimum threshold: " + min);
			
			error.throwError(stackreduction);
		}
	}
	
	static void isAbove(int stackreduction, long min, long... values)
	{
		ArrayList<Integer> indices = new ArrayList<Integer>();
		ArrayList<Long> vals = new ArrayList<Long>();
		
		for(int i = 0; i < values.length; i++)
			if(Check.notAbove(min, values[i]))
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
			
			ValidationError error = new ValidationError("isAbove(Multi)", "At least one of the values is not above exclusive minimum threshold!");
			
			error.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			error.details.add("failed values: [" + builder2.toString() + "]");
			error.details.add("total failed: " + indices.size());
			error.details.add("exclusive minimum threshold: " + min + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isAbove(int stackreduction, float min, float... values)
	{
		ArrayList<Integer> indices = new ArrayList<Integer>();
		ArrayList<Float> vals = new ArrayList<Float>();
		
		for(int i = 0; i < values.length; i++)
			if(Check.notAbove(min, values[i]))
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
				
			ValidationError error = new ValidationError("isAbove(Multi)", "At least one of the values is not above exclusive minimum threshold!");
			
			error.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			error.details.add("failed values: [" + builder2.toString() + "]");
			error.details.add("total failed: " + indices.size());
			error.details.add("exclusive minimum threshold: " + min + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isAbove(int stackreduction, double min, double... values)
	{
		ArrayList<Integer> indices = new ArrayList<Integer>();
		ArrayList<Double> vals = new ArrayList<Double>();
		
		for(int i = 0; i < values.length; i++)
			if(Check.notAbove(min, values[i]))
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
				
			ValidationError error = new ValidationError("isAbove(Multi)", "At least one of the values is not above exclusive minimum threshold!");
			
			error.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			error.details.add("failed values: [" + builder2.toString() + "]");
			error.details.add("total failed: " + indices.size());
			error.details.add("exclusive minimum threshold: " + min + "D");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isAboveOOO(int stackreduction, int min, int... values)
	{
		if(Check.notAbove(min, values))
		{
			ValidationError error = new ValidationError("isAbove(One Out Of)", "None of the values is above exclusive minimum threshold!");
			
			error.details.add("exclusive minimum threshold: " + min);
			
			error.throwError(stackreduction);
		}
	}
	
	static void isAboveOOO(int stackreduction, long min, long... values)
	{
		if(Check.notAbove(min, values))
		{
			ValidationError error = new ValidationError("isAbove(One Out Of)", "None of the values is above exclusive minimum threshold!");
			
			error.details.add("exclusive minimum threshold: " + min + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isAboveOOO(int stackreduction, float min, float... values)
	{
		if(Check.notAbove(min, values))
		{
			ValidationError error = new ValidationError("isAbove(One Out Of)", "None of the values is above exclusive minimum threshold!");
			
			error.details.add("exclusive minimum threshold: " + min + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isAboveOOO(int stackreduction, double min, double... values)
	{
		if(Check.notAbove(min, values))
		{
			ValidationError error = new ValidationError("isAbove(One Out Of)", "None of the values is above exclusive minimum threshold!");
			
			error.details.add("exclusive minimum threshold: " + min + "D");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notAbove(int stackreduction, int min, int value)
	{
		if(Check.isAbove(min, value))
		{
			ValidationError error = new ValidationError("notAbove", "The value is above threshold!");
			
			error.details.add("exclusive minimum threshold: " + min);
			error.details.add("value: " + value);
			
			error.throwError(stackreduction);
		}
	}
	
	static void notAbove(int stackreduction, long min, long value)
	{
		if(Check.isAbove(min, value))
		{
			ValidationError error = new ValidationError("notAbove", "The value is above threshold!");
			
			error.details.add("exclusive minimum threshold: " + min + "L");
			error.details.add("value: " + value + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notAbove(int stackreduction, float min, float value)
	{
		if(Check.isAbove(min, value))
		{
			ValidationError error = new ValidationError("notAbove", "The value is above threshold!");
			
			error.details.add("exclusive minimum threshold: " + min + "F");
			error.details.add("value: " + value + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notAbove(int stackreduction, double min, double value)
	{
		if(Check.isAbove(min, value))
		{
			ValidationError error = new ValidationError("notAbove", "The value is above threshold!");
			
			error.details.add("exclusive minimum threshold: " + min + "D");
			error.details.add("value: " + value + "D");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notAbove(int stackreduction, int min, int... values)
	{
		ArrayList<Integer> indices = new ArrayList<Integer>();
		ArrayList<Integer> vals = new ArrayList<Integer>();
		
		for(int i = 0; i < values.length; i++)
			if(Check.isAbove(min, values[i]))
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
				
			ValidationError error = new ValidationError("notAbove(Multi)", "At least one of the values is above exclusive minimum threshold!");
			
			error.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			error.details.add("failed values: [" + builder2.toString() + "]");
			error.details.add("total failed: " + indices.size());
			error.details.add("exclusive minimum threshold: " + min);
			
			error.throwError(stackreduction);
		}
	}
	
	static void notAbove(int stackreduction, long min, long... values)
	{
		ArrayList<Integer> indices = new ArrayList<Integer>();
		ArrayList<Long> vals = new ArrayList<Long>();
		
		for(int i = 0; i < values.length; i++)
			if(Check.isAbove(min, values[i]))
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
				
			ValidationError error = new ValidationError("notAbove(Multi)", "At least one of the values is above exclusive minimum threshold!");
			
			error.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			error.details.add("failed values: [" + builder2.toString() + "]");
			error.details.add("total failed: " + indices.size());
			error.details.add("exclusive minimum threshold: " + min + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notAbove(int stackreduction, float min, float... values)
	{
		ArrayList<Integer> indices = new ArrayList<Integer>();
		ArrayList<Float> vals = new ArrayList<Float>();
		
		for(int i = 0; i < values.length; i++)
			if(Check.isAbove(min, values[i]))
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
				
			ValidationError error = new ValidationError("notAbove(Multi)", "At least one of the values is above exclusive minimum threshold!");
			
			error.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			error.details.add("failed values: [" + builder2.toString() + "]");
			error.details.add("total failed: " + indices.size());
			error.details.add("exclusive minimum threshold: " + min + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notAbove(int stackreduction, double min, double... values)
	{
		ArrayList<Integer> indices =new ArrayList<Integer>();
		ArrayList<Double> vals = new ArrayList<Double>();
		
		for(int i = 0; i < values.length; i++)
			if(Check.isAbove(min, values[i]))
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
				
			ValidationError error = new ValidationError("notAbove(Multi)", "At least one of the values is above exclusive minimum threshold!");
			
			error.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			error.details.add("failed values: [" + builder2.toString() + "]");
			error.details.add("total failed: " + indices.size());
			error.details.add("exclusive minimum threshold: " + min + "D");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notAboveOOO(int stackreduction, int min, int... values)
	{
		if(Check.isAbove(min, values))
		{
			ValidationError error = new ValidationError("notAbove(One Out Of)", "All of the values are above exclusive minimum threshold!");
			
			error.details.add("exclusive minimum threshold: " + min);
			
			error.throwError(stackreduction);
		}
	}
	
	static void notAboveOOO(int stackreduction, long min, long... values)
	{
		if(Check.isAbove(min, values))
		{
			ValidationError error = new ValidationError("notAbove(One Out Of)", "All of the values are above exclusive minimum threshold!");
			
			error.details.add("exclusive minimum threshold: " + min + "L");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notAboveOOO(int stackreduction, float min, float... values)
	{
		if(Check.isAbove(min, values))
		{
			ValidationError error = new ValidationError("notAbove(One Out Of)", "All of the values are above exclusive minimum threshold!");
			
			error.details.add("exclusive minimum threshold: " + min + "F");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notAboveOOO(int stackreduction, double min, double... values)
	{
		if(Check.isAbove(min, values))
		{
			ValidationError error = new ValidationError("notAbove(One Out Of)", "All of the values are above exclusive minimum threshold!");
			
			error.details.add("exclusive minimum threshold: " + min + "D");
			
			error.throwError(stackreduction);
		}
	}
}

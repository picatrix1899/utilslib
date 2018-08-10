package cmn.utilslib.validation;

import java.util.ArrayList;

import cmn.utilslib.essentials.Check;

public class ValidateTrue
{
	private static final String TYPE__IS_TRUE = "isTrue";
	private static final String TYPE__IS_TRUE_MULTI = "isTrue(Multi)";
	private static final String TYPE__IS_TRUE_OOO = "isTrue(One Out Of)";
	private static final String TYPE__NOT_TRUE = "notTrue";
	private static final String TYPE__NOT_TRUE_MULTI = "notTrue(Multi)";
	private static final String TYPE__NOT_TRUE_OOO = "notTrue(One Out Of)";
	
	private static final String DESC__IS_TRUE = "The value is false!";
	private static final String DESC__IS_TRUE_MULTI = "At least one of the values is false!";
	private static final String DESC__IS_TRUE_OOO = "All the values are false!";
	private static final String DESC__NOT_TRUE = "The value is true!";
	private static final String DESC__NOT_TRUE_MULTI = "At least one of the values is true!";
	private static final String DESC__NOT_TRUE_OOO = "All the values are true!";
	
	static void isTrue(int stackreduction, boolean value)
	{
		if(Check.notTrue(value))
		{
			ValidationError error = new ValidationError(TYPE__IS_TRUE, DESC__IS_TRUE);
			
			error.throwError(stackreduction);
		}
	}
	
	static void isTrue(int stackreduction, boolean... values)
	{
		ArrayList<Integer> indices = new ArrayList<Integer>();
		
		for(int i = 0; i < values.length; i++)
			if(Check.notTrue(values[i]))
				indices.add(i);
		
		if(indices.size() > 0)
		{
			StringBuilder builder = new StringBuilder();
		
			builder.append(indices.get(0) + 1);			
			for(int i = 1; i < indices.size(); i++)
				builder.append((", " + indices.get(i) + 1));
			
			ValidationError error = new ValidationError(TYPE__IS_TRUE_MULTI, DESC__IS_TRUE_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builder.toString() + "]");
			error.details.add("total failed: " + indices.size());
			
			error.throwError(stackreduction);
		}
	}
	
	static void isTrueOOO(int stackreduction, boolean... values)
	{
		if(Check.notTrue(values))
		{
			ValidationError error = new ValidationError(TYPE__IS_TRUE_OOO, DESC__IS_TRUE_OOO);
			
			error.throwError(stackreduction);
		}
	}
	
	static void notTrue(int stackreduction, boolean value)
	{
		if(Check.isTrue(value))
		{
			ValidationError error = new ValidationError(TYPE__NOT_TRUE, DESC__NOT_TRUE);
			
			error.throwError(stackreduction);
		}
	}
	
	static void notTrue(int stackreduction, boolean... values)
	{
		ArrayList<Integer> indices = new ArrayList<Integer>();
		
		for(int i = 0; i < values.length; i++)
			if(Check.isTrue(values[i]))
				indices.add(i);
		
		if(indices.size() > 0)
		{
			StringBuilder builder = new StringBuilder();
			
			builder.append(indices.get(0) + 1);
			for(int i = 0; i < indices.size(); i++)
				builder.append(", " + (indices.get(i) + 1));
			
			ValidationError error = new ValidationError(TYPE__NOT_TRUE_MULTI, DESC__NOT_TRUE_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builder.toString() + "]");
			error.details.add("total failed: " + indices.size());
			
			error.throwError(stackreduction);
		}
	}
	
	static void notTrueOOO(int stackreduction, boolean... values)
	{
		if(Check.isTrue(values))
		{
			ValidationError error = new ValidationError(TYPE__NOT_TRUE_OOO, DESC__NOT_TRUE_OOO);
			
			error.throwError(stackreduction);
		}
	}
}

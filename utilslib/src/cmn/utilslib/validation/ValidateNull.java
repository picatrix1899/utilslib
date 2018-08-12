package cmn.utilslib.validation;

import cmn.utilslib.essentials.Check;

public class ValidateNull
{
	private static final String TYPE__IS_NULL = "isNull";
	private static final String TYPE__IS_NULL_MULTI = "isNull(Multi)";
	private static final String TYPE__IS_NULL_OOO = "isNull(One Out Of)";
	private static final String TYPE__NOT_NULL = "notNull";
	private static final String TYPE__NOT_NULL_MULTI = "notNull(Multi)";
	private static final String TYPE__NOT_NULL_OOO = "notNull(One Out Of)";
	
	private static final String DESC__IS_NULL = "The value is not null!";
	private static final String DESC__IS_NULL_MULTI = "At least one of the values is not null!";
	private static final String DESC__IS_NULL_OOO = "None of the values is null!";
	private static final String DESC__NOT_NULL = "The value is null!";
	private static final String DESC__NOT_NULL_MULTI = "At least one of the values is null!";
	private static final String DESC__NOT_NULL_OOO = "All of the values are not null!";
	
	static <A> void isNull(int stackreduction, A value)
	{
		if(Check.notNull(value))
		{
			ValidationError error = new ValidationError(TYPE__IS_NULL, DESC__IS_NULL);
			
			error.throwError(stackreduction);
		}
	}
	
	@SafeVarargs
	static <A> void isNull(int stackreduction, A... values)
	{
		StringBuilder builder = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
		{
			if(Check.notNull(values[i]))
			{
				builder.append((count > 0 ? ", " : "") + i + 1);
			}
		}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__IS_NULL_MULTI, DESC__IS_NULL_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builder.toString() + "]");
			error.details.add("total failed: " + count);
			
			error.throwError(stackreduction);
		}
	}
	
	@SafeVarargs
	static <A> void isNullOOO(int stackreduction, A... values)
	{
		if(Check.notNull(values))
		{
			ValidationError error = new ValidationError(TYPE__IS_NULL_OOO, DESC__IS_NULL_OOO);
			
			error.throwError(stackreduction);
		}
	}
	
	static <A> void notNull(int stackreduction, A value)
	{
		if(Check.isNull(value))
		{
			ValidationError error = new ValidationError(TYPE__NOT_NULL, DESC__NOT_NULL);
			
			error.throwError(stackreduction);
		}
	}
	
	@SafeVarargs
	static <A> void notNull(int stackreduction, A... values)
	{
		StringBuilder builder = new StringBuilder();
		
		int count = 0;
		
		for(int i = 0; i < values.length; i++)
		{
			if(Check.isNull(values[i]))
			{
				builder.append((count > 0 ? ", " : "") + i + 1);
			}
		}
		
		if(count > 0)
		{
			ValidationError error = new ValidationError(TYPE__NOT_NULL_MULTI, DESC__NOT_NULL_MULTI);
			
			error.details.add("failed indices(1 based): " + "[" + builder.toString() + "]");
			error.details.add("total failed: " + count);
			
			error.throwError(stackreduction);
		}
	}
	
	@SafeVarargs
	static <A> void notNullOOO(int stackreduction, A... values)
	{
		if(Check.isNull(values))
		{
			ValidationError error = new ValidationError(TYPE__NOT_NULL_OOO, DESC__NOT_NULL_OOO);
			
			error.throwError(stackreduction);
		}
	}
}

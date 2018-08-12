package cmn.utilslib.validation;

import java.util.List;

import cmn.utilslib.essentials.Check;

class ValidateEmpty
{
	private static final String TYPE__IS_EMPTY_STRING = "isEmpty(String)";
	private static final String TYPE__IS_EMPTY_ARRAY = "isEmpty(Array)";
	private static final String TYPE__IS_EMPTY_LIST = "isEmpty(List)";
	private static final String TYPE__NOT_EMPTY_STRING = "notEmpty(String)";
	private static final String TYPE__NOT_EMPTY_ARRAY = "notEmpty(Array)";
	private static final String TYPE__NOT_EMPTY_LIST = "notEmpty(List)";
	
	private static final String DESC__IS_EMPTY_STRING = "The String is not null or empty!";
	private static final String DESC__IS_EMPTY_ARRAY = "The Array is not null or empty!";
	private static final String DESC__IS_EMPTY_LIST = "The List is not null or empty!";
	private static final String DESC__NOT_EMPTY_STRING = "The String is null or empty!";
	private static final String DESC__NOT_EMPTY_ARRAY = "The Array is null or empty!";
	private static final String DESC__NOT_EMPTY_LIST = "The List is null or empty!";
	
	static void isEmpty(int stackreduction, String str)
	{
		if(Check.notNullOrEmpty(str))
		{
			ValidationError error = new ValidationError(TYPE__IS_EMPTY_STRING,DESC__IS_EMPTY_STRING);
			
			error.throwError(stackreduction);
		}
	}
	
	static <T> void isEmpty(int stackreduction, T[] args)
	{
		if(Check.notNullOrEmpty(args))
		{
			ValidationError error = new ValidationError(TYPE__IS_EMPTY_ARRAY, DESC__IS_EMPTY_ARRAY);
			
			error.throwError(stackreduction);
		}
	}

	static <T> void isEmpty(int stackreduction, List<T> list)
	{
		if(Check.notNullOrEmpty(list))
		{
			ValidationError error = new ValidationError(TYPE__IS_EMPTY_LIST, DESC__IS_EMPTY_LIST);
			
			error.throwError(stackreduction);
		}
	}

	static void notEmpty(int stackreduction, String str)
	{
		if(Check.isNullOrEmpty(str))
		{
			ValidationError error = new ValidationError(TYPE__NOT_EMPTY_STRING,DESC__NOT_EMPTY_STRING);
			
			error.throwError(stackreduction);
		}
	}
	
	static <T> void notEmpty(int stackreduction, T[] args)
	{
		if(Check.isNullOrEmpty(args))
		{
			ValidationError error = new ValidationError(TYPE__NOT_EMPTY_ARRAY, DESC__NOT_EMPTY_ARRAY);
			
			error.throwError(stackreduction);
		}
	}

	static <T> void notEmpty(int stackreduction, List<T> list)
	{
		if(Check.isNullOrEmpty(list))
		{
			ValidationError error = new ValidationError(TYPE__NOT_EMPTY_LIST, DESC__NOT_EMPTY_LIST);
			
			error.throwError(stackreduction);
		}
	}
	
}

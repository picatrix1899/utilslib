package cmn.utilslib.essentials;

import java.util.List;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Check
{
	
	public static boolean isTrue(boolean expression) { return expression; }
	
	
	
	public static boolean isTrue(boolean... expressions)
	{
		for(boolean expression : expressions)
			if(isFalse(expression)) return false;
		
		return true;
	}		
	
	
	
	public static boolean isTrueOOO(boolean... expressions)
	{
		for(boolean expression : expressions)
			if(isTrue(expression)) return true;
		
		return false;
	}		
	
	
	
	public static boolean isFalse(boolean expression) { return !expression; }
	
	

	public static boolean isFalse(boolean... expressions)
	{
		for(boolean expression : expressions)
			if(isTrue(expression)) return false;
		
		return true;
	}
	

	
	public static boolean isFalseOOO(boolean... expressions)
	{
		for(boolean expression : expressions)
			if(isFalse(expression)) return true;
		
		return false;
	}
	
	
	
	public static boolean isEqual(boolean expected, boolean value) { return value == expected; }
	public static boolean isEqual(int expected, int value) { return value == expected; }
	public static boolean isEqual(long expected, long value) { return value == expected; }
	public static boolean isEqual(float expected, float value) { return value == expected; }
	public static boolean isEqual(double expected, double value) { return value == expected; }
	
	public static boolean isEqual(String expected, String value) { return value.equals(expected); }		
	public static <A> boolean isEqual(A expected, A value) { return value.equals(expected) || value == expected; }
	

	
	public static boolean isEqual(boolean expected, boolean... values)
	{
		for(boolean value : values)
			if(Check.notEqual(expected, value)) return false;
		
		return true;
	}
	public static boolean isEqual(int expected, int... values)
	{
		for(int value : values)
			if(Check.notEqual(expected, value)) return false;
		
		return true;
	}
	public static boolean isEqual(long expected, long... values)
	{
		for(long value : values)
			if(Check.notEqual(expected, value)) return false;
		
		return true;
	}
	public static boolean isEqual(float expected, float...values)
	{
		for(float value : values)
			if(Check.notEqual(expected, value)) return false;
		
		return true;
	}
	public static boolean isEqual(double expected, double... values)
	{
		for(double value : values)
			if(Check.notEqual(expected, value)) return false;
		
		return true;
	}
	
	public static boolean isEqual(String expected, String... values)
	{
		for(String value : values)
			if(Check.notEqual(expected, value)) return false;
		
		return true;
	}
	@SafeVarargs
	public static <A> boolean isEqual(A expected, A... values)
	{
		for(A value : values)
			if(Check.notEqual(expected, value)) return false;
		
		return true;
	}
	
	
	
	public static boolean isEqualOOO(boolean expected, boolean... values)
	{
		for(boolean value : values)
			if(Check.isEqual(expected, value)) return true;
		
		return false;
	}
	public static boolean isEqualOOO(int expected, int... values)
	{
		for(int value : values)
			if(Check.isEqual(expected, value)) return true;
		
		return false;
	}
	public static boolean isEqualOOO(long expected, long... values)
	{
		for(long value : values)
			if(Check.isEqual(expected, value)) return true;
		
		return false;
	}
	public static boolean isEqualOOO(float expected, float... values)
	{
		for(float value : values)
			if(Check.isEqual(expected, value)) return true;
		
		return false;
	}
	public static boolean isEqualOOO(double expected, double... values)
	{
		for(double value : values)
			if(Check.isEqual(expected, value)) return true;
		
		return false;
	}
	
	public static boolean isEqualOOO(String expected, String... values)
	{
		for(String value : values)
			if(Check.isEqual(expected, value)) return true;
		
		return false;
	}
	@SafeVarargs
	public static <A> boolean isEqualOOO(A expected, A... values)
	{
		for(A value : values)
			if(Check.isEqual(expected, value)) return true;
		
		return false;
	}
	
	
	
	public static <A> boolean isNull(A object) { return object == null; }
	
	
	
	@SafeVarargs
	public static <A> boolean isNull(A... objects)
	{
		for(A object : objects)
			if(Check.notNull(object)) return false;
		
		return true;
	}
	
	
	
	@SafeVarargs
	public static <A> boolean isNullOOO(A... objects)
	{
		for(A object : objects)
			if(Check.isNull(object)) return true;
		
		return false;
	}


	
	public static boolean isInBetween(int min, int max, int value) { return min < value && value < max; }
	public static boolean isInBetween(long min, long max, long value) { return min < value && value < max; }
	public static boolean isInBetween(float min, float max, float value) { return min < value && value < max; }	
	public static boolean isInBetween(double min, double max, double value) { return min < value && value < max; }
	
	
	
	public static boolean isInBetween(int min, int max, int... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean isInBetween(long min, long max, long... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean isInBetween(float min, float max, float... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean isInBetween(double min, double max, double... values)
	{
		throw new NotImplementedException();
	}
	
	
	
	public static boolean isInBetweenOOO(int min, int max, int... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean isInBetweenOOO(long min, long max, long... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean isInBetweenOOO(float min, float max, float... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean isInBetweenOOO(double min, double max, double... values)
	{
		throw new NotImplementedException();
	}
	
	
	
	public static boolean isInRange(int min, int max, int value) { return min <= value && value <= max; }
	public static boolean isInRange(long min, long max, long value) { return min <= value && value <= max; }
	public static boolean isInRange(float min, float max, float value) { return min <= value && value <= max; }	
	public static boolean isInRange(double min, double max, double value) { return min <= value && value <= max; }
	
	
	
	public static boolean isInRange(int min, int max, int... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean isInRange(long min, long max, long... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean isInRange(float min, float max, float... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean isInRange(double min, double max, double... values)
	{
		throw new NotImplementedException();
	}
	
	
	
	public static boolean isInRangeOOO(int min, int max, int... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean isInRangeOOO(long min, long max, long... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean isInRangeOOO(float min, float max, float... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean isInRangeOOO(double min, double max, double... values)
	{
		throw new NotImplementedException();
	}
	
	
	
	public static boolean isBelow(int max, int value) { return value < max; }
	public static boolean isBelow(long max, long value) { return value < max; }
	public static boolean isBelow(float max, float value) { return value < max;}
	public static boolean isBelow(double max, double value) { return value < max; }
	
	
	
	public static boolean isBelow(int max, int... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean isBelow(long max, long... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean isBelow(float max, float... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean isBelow(double max, double... values)
	{
		throw new NotImplementedException();
	}
	
	
	
	public static boolean isBelowOOO(int max, int... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean isBelowOOO(long max, long... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean isBelowOOO(float max, float... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean isBelowOOO(double max, double... values)
	{
		throw new NotImplementedException();
	}
	
	
	
	public static boolean isAbove(int min, int value) { return value > min; }
	public static boolean isAbove(long min, long value) { return value >  min; }
	public static boolean isAbove(float min, float value) { return value > min; }
	public static boolean isAbove(double min, double value) { return value > min; }
	
	

	public static boolean isAbove(int min, int... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean isAbove(long min, long... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean isAbove(float min, float... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean isAbove(double min, double... values)
	{
		throw new NotImplementedException();
	}
	
	
	
	public static boolean isAboveOOO(int min, int... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean isAboveOOO(long min, long... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean isAboveOOO(float min, float... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean isAboveOOO(double min, double... values)
	{
		throw new NotImplementedException();
	}
	
	

	public static boolean isNullOrEmpty(String str) { return isNull(str) || str == ""; }
	public static <A> boolean isNullOrEmpty(A[] arg) { return isNull(arg) || arg.length == 0; }
	public static <A> boolean isEmpty(List<A> list) { return list.size() == 0; }
	
	
	
	
	
	
	public static boolean notTrue(boolean expression) { return !isTrue(expression); }
	
	
	
	public static boolean notTrue(boolean... expressions)
	{
		for(boolean expression : expressions)
			if(notFalse(expression)) return false;
		
		return true;
	}		
	
	
	
	public static boolean notTrueOOO(boolean... expressions)
	{
		for(boolean expression : expressions)
			if(notTrue(expression)) return true;
		
		return false;
	}	
	
	
	
	public static boolean notFalse(boolean expression) { return !isFalse(expression); }
	
	
	
	public static boolean notFalse(boolean... expressions)
	{
		for(boolean expression : expressions)
			if(notTrue(expression)) return false;
		
		return true;
	}
	

	
	public static boolean notFalseOOO(boolean... expressions)
	{
		for(boolean expression : expressions)
			if(notFalse(expression)) return true;
		
		return false;
	}

	
	
	public static boolean notEqual(boolean expected, boolean value) { return !isEqual(expected, value); }
	public static boolean notEqual(int expected, int value) { return !isEqual(expected, value); }
	public static boolean notEqual(long expected, long value) { return !isEqual(expected, value); }
	public static boolean notEqual(float expected, float value) { return !isEqual(expected, value); }
	public static boolean notEqual(double expected, double value) { return !isEqual(expected, value); }
	
	public static boolean notEqual(String expected, String value) { return !isEqual(expected, value); }	
	public static <A> boolean notEqual(A expected, A value) { return !isEqual(expected, value); }	
	
	
	
	public static boolean notEqual(boolean expected, boolean... values)
	{
		for(boolean value : values)
			if(Check.isEqual(expected, value)) return false;
		
		return true;
	}
	public static boolean notEqual(int expected, int... values)
	{
		for(int value : values)
			if(Check.isEqual(expected, value)) return false;
		
		return true;
	}
	public static boolean notEqual(long expected, long... values)
	{
		for(long value : values)
			if(Check.isEqual(expected, value)) return false;
		
		return true;
	}
	public static boolean notEqual(float expected, float...values)
	{
		for(float value : values)
			if(Check.isEqual(expected, value)) return false;
		
		return true;
	}
	public static boolean notEqual(double expected, double... values)
	{
		for(double value : values)
			if(Check.isEqual(expected, value)) return false;
		
		return true;
	}
	
	public static boolean notEqual(String expected, String... values)
	{
		for(String value : values)
			if(Check.isEqual(expected, value)) return false;
		
		return true;
	}
	@SafeVarargs
	public static <A> boolean notEqual(A expected, A... values)
	{
		for(A value : values)
			if(Check.isEqual(expected, value)) return false;
		
		return true;
	}
	
	
	
	public static boolean notEqualOOO(boolean expected, boolean... values)
	{
		for(boolean value : values)
			if(Check.notEqual(expected, value)) return true;
		
		return false;
	}
	public static boolean notEqualOOO(int expected, int... values)
	{
		for(int value : values)
			if(Check.notEqual(expected, value)) return true;
		
		return false;
	}
	public static boolean notEqualOOO(long expected, long... values)
	{
		for(long value : values)
			if(Check.notEqual(expected, value)) return true;
		
		return false;
	}
	public static boolean notEqualOOO(float expected, float... values)
	{
		for(float value : values)
			if(Check.notEqual(expected, value)) return true;
		
		return false;
	}
	public static boolean notEqualOOO(double expected, double... values)
	{
		for(double value : values)
			if(Check.notEqual(expected, value)) return true;
		
		return false;
	}
	
	public static boolean notEqualOOO(String expected, String... values)
	{
		for(String value : values)
			if(Check.notEqual(expected, value)) return true;
		
		return false;
	}
	@SafeVarargs
	public static <A> boolean notEqualOOO(A expected, A... values)
	{
		for(A value : values)
			if(Check.notEqual(expected, value)) return true;
		
		return false;
	}
	
	
	
	public static <A> boolean notNull(A object) { return !isNull(object); }
	
	
	
	@SafeVarargs
	public static <A> boolean notNull(A... objects)
	{
		for(A object : objects)
			if(Check.isNull(object)) return false;
		
		return true;
	}
	
	
	
	@SafeVarargs
	public static <A> boolean notNullOOO(A... objects)
	{
		for(A object : objects)
			if(Check.notNull(object)) return true;
		
		return false;
	}

	

	public static boolean notInBetween(int min, int max, int value) { return !isInBetween(min, max, value); }
	public static boolean notInBetween(long min, long max, long value) { return !isInBetween(min, max, value); }
	public static boolean notInBetween(float min, float max, float value) { return !isInBetween(min, max, value); }	
	public static boolean notInBetween(double min, double max, double value) { return !isInBetween(min, max, value); }
	
	
	
	public static boolean notInBetween(int min, int max, int... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean notInBetween(long min, long max, long... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean notInBetween(float min, float max, float... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean notInBetween(double min, double max, double... values)
	{
		throw new NotImplementedException();
	}
	
	
	
	public static boolean notInBetweenOOO(int min, int max, int... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean notInBetweenOOO(long min, long max, long... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean notInBetweenOOO(float min, float max, float... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean notInBetweenOOO(double min, double max, double... values)
	{
		throw new NotImplementedException();
	}

	
	
	public static boolean notInRange(int min, int max, int value) { return !isInRange(min, max, value); }
	public static boolean notInRange(long min, long max, long value) { return !isInRange(min, max, value); }
	public static boolean notInRange(float min, float max, float value) { return !isInRange(min, max, value); }	
	public static boolean notInRange(double min, double max, double value) { return !isInRange(min, max, value); }
	

	
	public static boolean notInRange(int min, int max, int... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean notInRange(long min, long max, long... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean notInRange(float min, float max, float... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean notInRange(double min, double max, double... values)
	{
		throw new NotImplementedException();
	}
	
	
	
	public static boolean notInRangeOOO(int min, int max, int... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean notInRangeOOO(long min, long max, long... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean notInRangeOOO(float min, float max, float... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean notInRangeOOO(double min, double max, double... values)
	{
		throw new NotImplementedException();
	}
	
	
	
	public static boolean notBelow(int max, int value) { return !isBelow(max, value); }
	public static boolean notBelow(long max, long value) { return !isBelow(max, value); }
	public static boolean notBelow(float max, float value) { return !isBelow(max, value); }
	public static boolean notBelow(double max, double value) { return !isBelow(max, value); }
	

	
	public static boolean notBelow(int max, int... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean notBelow(long max, long... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean notBelow(float max, float... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean notBelow(double max, double... values)
	{
		throw new NotImplementedException();
	}
	
	
	
	public static boolean notBelowOOO(int max, int... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean notBelowOOO(long max, long... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean notBelowOOO(float max, float... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean notBelowOOO(double max, double... values)
	{
		throw new NotImplementedException();
	}
	
	
	
	public static boolean notAbove(int min, int value) { return !isAbove(min, value); }
	public static boolean notAbove(long min, long value) { return !isAbove(min, value); }
	public static boolean notAbove(float min, float value) { return !isAbove(min, value); }
	public static boolean notAbove(double min, double value) { return !isAbove(min, value); }
	
	
	
	public static boolean notAbove(int min, int... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean notAbove(long min, long... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean notAbove(float min, float... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean notAbove(double min, double... values)
	{
		throw new NotImplementedException();
	}
	
	
	
	public static boolean notAboveOOO(int min, int... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean notAboveOOO(long min, long... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean notAboveOOO(float min, float... values)
	{
		throw new NotImplementedException();
	}
	
	public static boolean notAboveOOO(double min, double... values)
	{
		throw new NotImplementedException();
	}
	
	

	public static boolean notNullOrEmpty(String str) { return !isNullOrEmpty(str); }
	public static <A> boolean notNullOrEmpty(A[] arg) { return !isNullOrEmpty(arg); }
	public static <A> boolean notEmpty(List<A> list) { return !isEmpty(list); }
		
}

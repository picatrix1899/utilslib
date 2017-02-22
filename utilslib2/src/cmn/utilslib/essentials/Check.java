package cmn.utilslib.essentials;

import java.util.List;

public class Check
{
	
	public static boolean isTrue(boolean exp) { return exp; }
	
	
	
	public static boolean isTrue(boolean... values)
	{
		for(boolean val : values)
			if(isFalse(val)) return false;
		
		return true;
	}		
	
	
	
	public static boolean isTrueOOO(boolean... values)
	{
		for(boolean val : values)
			if(isTrue(val)) return true;
		
		return false;
	}		
	
	
	
	public static boolean isFalse(boolean exp) { return !exp; }
	
	

	public static boolean isFalse(boolean... values)
	{
		for(boolean val : values)
			if(isTrue(val)) return false;
		
		return true;
	}
	

	
	public static boolean isFalseOOO(boolean... values)
	{
		for(boolean val : values)
			if(isFalse(val)) return true;
		
		return false;
	}
	
	
	
	public static boolean isEqual(boolean expected, boolean value) { return value == expected; }
	public static boolean isEqual(int expected, int value) { return value == expected; }
	public static boolean isEqual(long expected, long value) { return value == expected; }
	public static boolean isEqual(float expected, float value) { return value == expected; }
	public static boolean isEqual(double expected, double value) { return value == expected; }
	
	public static boolean isEqual(String expected, String value) { return value.equals(expected); }		
	public static <A> boolean isEqual(A expected, A value) { return value.equals(expected); }
	

	
	public static boolean isEqual(boolean expected, boolean... values)
	{
		for(boolean val : values)
			if(Check.notEqual(expected, val)) return false;
		
		return true;
	}
	public static boolean isEqual(int expected, int... values)
	{
		for(int val : values)
			if(Check.notEqual(expected, val)) return false;
		
		return true;
	}
	public static boolean isEqual(long expected, long... values)
	{
		for(long val : values)
			if(Check.notEqual(expected, val)) return false;
		
		return true;
	}
	public static boolean isEqual(float expected, float...values)
	{
		for(float val : values)
			if(Check.notEqual(expected, val)) return false;
		
		return true;
	}
	public static boolean isEqual(double expected, double... values)
	{
		for(double val : values)
			if(Check.notEqual(expected, val)) return false;
		
		return true;
	}
	
	public static boolean isEqual(String expected, String... values)
	{
		for(String val : values)
			if(Check.notEqual(expected, val)) return false;
		
		return true;
	}
	@SafeVarargs
	public static <A> boolean isEqual(A expected, A... values)
	{
		for(A val : values)
			if(Check.notEqual(expected, val)) return false;
		
		return true;
	}
	
	
	
	public static boolean isEqualOOO(boolean expected, boolean... values)
	{
		for(boolean val : values)
			if(Check.isEqual(expected, val)) return true;
		
		return false;
	}
	public static boolean isEqualOOO(int expected, int... values)
	{
		for(int val : values)
			if(Check.isEqual(expected, val)) return true;
		
		return false;
	}
	public static boolean isEqualOOO(long expected, long... values)
	{
		for(long val : values)
			if(Check.isEqual(expected, val)) return true;
		
		return false;
	}
	public static boolean isEqualOOO(float expected, float... values)
	{
		for(float val : values)
			if(Check.isEqual(expected, val)) return true;
		
		return false;
	}
	public static boolean isEqualOOO(double expected, double... values)
	{
		for(double val : values)
			if(Check.isEqual(expected, val)) return true;
		
		return false;
	}
	
	public static boolean isEqualOOO(String expected, String... values)
	{
		for(String val : values)
			if(Check.isEqual(expected, val)) return true;
		
		return false;
	}
	@SafeVarargs
	public static <A> boolean isEqualOOO(A expected, A... values)
	{
		for(A val : values)
			if(Check.isEqual(expected, val)) return true;
		
		return false;
	}
	
	
	
	
	public static <A> boolean isNull(A obj) { return obj == null; }
	
	
	
	@SafeVarargs
	public static <A> boolean isNull(A... values)
	{
		for(A val : values)
			if(Check.notNull(val)) return false;
		
		return true;
	}
	
	
	
	@SafeVarargs
	public static <A> boolean isNullOOO(A... values)
	{
		for(A val : values)
			if(Check.isNull(val)) return true;
		
		return false;
	}


	
	public static boolean isInBetween(int i, int min, int max) { return min < i && i < max; }
	public static boolean isInBetween(long i, long min, long max) { return min < i && i < max; }
	public static boolean isInBetween(float i, float min, float max) { return min < i && i < max; }	
	public static boolean isInBetween(double i, double min, double max) { return min < i && i < max; }
	
	
	
	public static boolean isInRange(int i, int min, int max) { return min <= i && i <= max; }
	public static boolean isInRange(long i, long min, long max) { return min <= i && i <= max; }
	public static boolean isInRange(float i, float min, float max) { return min <= i && i <= max; }	
	public static boolean isInRange(double i, double min, double max) { return min <= i && i <= max; }
	
	
	
	public static boolean isBelow(int i, int min) { return i < min; }
	public static boolean isBelow(long i, long min) { return i < min; }
	public static boolean isBelow(float i, float min) { return i < min;}
	public static boolean isBelow(double i, double min) { return i < min; }
	
	
	
	public static boolean isAbove(int i, int max) { return i > max; }
	public static boolean isAbove(long i, long max) { return i >  max; }
	public static boolean isAbove(float i, float max) { return i > max; }
	public static boolean isAbove(double i, double max) { return i > max; }
	
	

	public static boolean isNullOrEmpty(String str) { return isNull(str) || str == ""; }
	public static <A> boolean isNullOrEmpty(A[] arg) { return isNull(arg) || arg.length == 0; }
	public static <A> boolean isEmpty(List<A> list) { return list.size() == 0; }
	
	
	
	
	
	
	public static boolean notTrue(boolean expression) { return !isTrue(expression); }
	
	
	
	public static boolean notTrue(boolean... values)
	{
		for(boolean val : values)
			if(notFalse(val)) return false;
		
		return true;
	}		
	
	
	
	public static boolean notTrueOOO(boolean... values)
	{
		for(boolean val : values)
			if(notTrue(val)) return true;
		
		return false;
	}	
	
	
	
	public static boolean notFalse(boolean expression) { return !isFalse(expression); }
	
	
	
	public static boolean notFalse(boolean... values)
	{
		for(boolean val : values)
			if(notTrue(val)) return false;
		
		return true;
	}
	

	
	public static boolean notFalseOOO(boolean... values)
	{
		for(boolean val : values)
			if(notFalse(val)) return true;
		
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
		for(boolean val : values)
			if(Check.isEqual(expected, val)) return false;
		
		return true;
	}
	public static boolean notEqual(int expected, int... values)
	{
		for(int val : values)
			if(Check.isEqual(expected, val)) return false;
		
		return true;
	}
	public static boolean notEqual(long expected, long... values)
	{
		for(long val : values)
			if(Check.isEqual(expected, val)) return false;
		
		return true;
	}
	public static boolean notEqual(float expected, float...values)
	{
		for(float val : values)
			if(Check.isEqual(expected, val)) return false;
		
		return true;
	}
	public static boolean notEqual(double expected, double... values)
	{
		for(double val : values)
			if(Check.isEqual(expected, val)) return false;
		
		return true;
	}
	
	public static boolean notEqual(String expected, String... values)
	{
		for(String val : values)
			if(Check.isEqual(expected, val)) return false;
		
		return true;
	}
	@SafeVarargs
	public static <A> boolean notEqual(A expected, A... values)
	{
		for(A val : values)
			if(Check.isEqual(expected, val)) return false;
		
		return true;
	}
	
	
	
	public static boolean notEqualOOO(boolean expected, boolean... values)
	{
		for(boolean val : values)
			if(Check.notEqual(expected, val)) return true;
		
		return false;
	}
	public static boolean notEqualOOO(int expected, int... values)
	{
		for(int val : values)
			if(Check.notEqual(expected, val)) return true;
		
		return false;
	}
	public static boolean notEqualOOO(long expected, long... values)
	{
		for(long val : values)
			if(Check.notEqual(expected, val)) return true;
		
		return false;
	}
	public static boolean notEqualOOO(float expected, float... values)
	{
		for(float val : values)
			if(Check.notEqual(expected, val)) return true;
		
		return false;
	}
	public static boolean notEqualOOO(double expected, double... values)
	{
		for(double val : values)
			if(Check.notEqual(expected, val)) return true;
		
		return false;
	}
	
	public static boolean notEqualOOO(String expected, String... values)
	{
		for(String val : values)
			if(Check.notEqual(expected, val)) return true;
		
		return false;
	}
	@SafeVarargs
	public static <A> boolean notEqualOOO(A expected, A... values)
	{
		for(A val : values)
			if(Check.notEqual(expected, val)) return true;
		
		return false;
	}
	
	
	
	public static <A> boolean notNull(A obj) { return !isNull(obj); }
	
	
	
	@SafeVarargs
	public static <A> boolean notNull(A... values)
	{
		for(A val : values)
			if(Check.isNull(val)) return false;
		
		return true;
	}
	
	
	
	@SafeVarargs
	public static <A> boolean notNullOOO(A... values)
	{
		for(A val : values)
			if(Check.notNull(val)) return true;
		
		return false;
	}

	

	public static boolean notInBetween(int i, int min, int max) { return !isInBetween(i, min, max); }
	public static boolean notInBetween(long l, long min, long max) { return !isInBetween(l, min, max); }
	public static boolean notInBetween(float f, float min, float max) { return !isInBetween(f, min, max); }	
	public static boolean notInBetween(double d, double min, double max) { return !isInBetween(d, min, max); }
	

	
	public static boolean notInRange(int i, int min, int max) { return !isInRange(i, min, max); }
	public static boolean notInRange(long l, long min, long max) { return !isInRange(l, min, max); }
	public static boolean notInRange(float f, float min, float max) { return !isInRange(f, min, max); }	
	public static boolean notInRange(double d, double min, double max) { return !isInRange(d, min, max); }
	

	
	public static boolean notBelow(int i, int min) { return !isBelow(i, min); }
	public static boolean notBelow(long l, long min) { return !isBelow(l, min); }
	public static boolean notBelow(float f, float min) { return !isBelow(f, min); }
	public static boolean notBelow(double d, double min) { return !isBelow(d, min); }
	

	
	public static boolean notAbove(int i, int max) { return !isAbove(i, max); }
	public static boolean notAbove(long l, long max) { return !isAbove(l, max); }
	public static boolean notAbove(float f, float max) { return !isAbove(f, max); }
	public static boolean notAbove(double d, double max) { return !isAbove(d, max); }
	
	

	public static boolean notNullOrEmpty(String str) { return !isNullOrEmpty(str); }
	public static <A> boolean notNullOrEmpty(A[] arg) { return !isNullOrEmpty(arg); }
	public static <A> boolean notEmpty(List<A> list) { return !isEmpty(list); }
		
}

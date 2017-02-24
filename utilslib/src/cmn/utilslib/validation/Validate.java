package cmn.utilslib.validation;

import java.util.List;

import cmn.utilslib.essentials.Check;
import cmn.utilslib.exceptions.Exceptions;

/**
 * 

 * @author picatrix1899
 *
 */
public abstract class Validate
{
	
	public static void isTrue(boolean value) { new VE_isTrue(1, value); }
	
	public static void isTrue(boolean... values) { new VE_isTrueMulti(1, values); }

	public static void isTrueOOO(boolean... values) { new VE_isTrueOOO(1, values); }

	
	
	public static void isFalse(boolean value) { new VE_isFalse(1, value); }
	
	public static void isFalse(boolean... values) { new VE_isFalseMulti(1, values); }

	public static void isFalseOOO(boolean... values) { new VE_isFalseOOO(1, values); }

	
	
	public static void isEqual(boolean expected, boolean value) { new VE_isEqual(1, expected, value); }

	public static void isEqual(boolean expected, boolean... values) { new VE_isEqualMulti(1, expected, values); }

	public static void isEqualOOO(boolean expected, boolean... values) { new VE_isEqualOOO(1, expected, values); }

	
	
	public static <A> void isNull(A value) { new VE_isNull(1, value); }

	@SafeVarargs public static <A> void isNull(A... values) { new VE_isNullMulti(1, values); }

	@SafeVarargs public static <A> void isNullOOO(A... values) { new VE_isNullOOO(1, values); }
	
	
	
	public static void isInBetween(int min, int max, int value) { new VE_isInBetween(1, min, max, value); }
	public static void isInBetween(long min, long max, long value) { new VE_isInBetween(1, min, max, value);  }
	public static void isInBetween(float min, float max, float value) { new VE_isInBetween(1, min, max, value);  }
	public static void isInBetween(double min, double max, double value) { new VE_isInBetween(1, min, max, value);  }

	public static void isInBetween(int min, int max, int... values) { new VE_isInBetweenMulti(1, min, max, values); }
	public static void isInBetween(long min, long max, long... values) { new VE_isInBetweenMulti(1, min, max, values); }
	public static void isInBetween(float min, float max, float... values) { new VE_isInBetweenMulti(1, min, max, values); }
	public static void isInBetween(double min, double max, double... values) { new VE_isInBetweenMulti(1, min, max, values); }
	
	
	
	public static void isInRange(int min, int max, int value) { new VE_isInRange(1, min, max, value);  }
	public static void isInRange(long min, long max, long value) { new VE_isInRange(1, min, max, value); }
	public static void isInRange(float min, float max, float value) { new VE_isInRange(1, min, max, value); }
	public static void isInRange(double min, double max, double value) { new VE_isInRange(1, min, max, value); }

	public static void isInRange(int min, int max, int... values) { new VE_isInRangeMulti(1, min, max, values); }
	public static void isInRange(long min, long max, long... values) { new VE_isInRangeMulti(1, min, max, values); }
	public static void isInRange(float min, float max, float... values) { new VE_isInRangeMulti(1, min, max, values); }
	public static void isInRange(double min, double max, double... values) { new VE_isInRangeMulti(1, min, max, values); }
	
	
	
	public static void isBelow(int threshold, int value) { new VE_isBelow(1, threshold, value);  }
	public static void isBelow(long threshold, long value) { new VE_isBelow(1, threshold, value); }
	public static void isBelow(float threshold, float value) { new VE_isBelow(1, threshold, value); }
	public static void isBelow(double threshold, double value) { new VE_isBelow(1, threshold, value); }


	
	public static void isAbove(int threshold, int value) { new VE_isAbove(1, threshold, value); }
	public static void isAbove(long threshold, long value) { new VE_isAbove(1, threshold, value);  }
	public static void isAbove(float threshold, float value) { new VE_isAbove(1, threshold, value); }
	public static void isAbove(double threshold, double value) { new VE_isAbove(1, threshold, value); }
	
	
	
	public static void isEmpty(String str) { Validate.isEmpty(str, "Validate isEmpty: string is not empty!"); }
	public static void isEmpty(String str, String msg) { Validate.isEmpty(str, msg, Exceptions.Validation); }
	public static void isEmpty(String str, String msg, Class<? extends RuntimeException> e) { if(Check.notNullOrEmpty(str)) Exceptions.handle(e, msg); }
	
	public static <A> void isEmpty(A[] arg) { Validate.isEmpty(arg, "Validate isEmpty: array is not empty!"); }
	public static <A> void isEmpty(A[] arg, String msg) { Validate.isEmpty(arg, msg, Exceptions.Validation); }
	public static <A> void isEmpty(A[] arg, String msg, Class<? extends RuntimeException> e) { if(Check.notNullOrEmpty(arg)) Exceptions.handle(e, msg); }
	
	public static <A> void isEmpty(List<A> list) { Validate.isEmpty(list, "Validate isEmpty: list is not empty!"); }
	public static <A> void isEmpty(List<A> list, String msg) { if(Check.notEmpty(list)) Validate.isEmpty(list, msg, Exceptions.Validation); }
	public static <A> void isEmpty(List<A> list, String msg, Class<? extends RuntimeException> e) { if(Check.notEmpty(list)) Exceptions.handle(e, msg); }
	
	
	
	
	
	
	public static void notTrue(boolean value) { new VE_notTrue(1, value); }
	
	public static void notTrue(boolean... values) { new VE_notTrueMulti(1, values); }

	public static void notTrueOOO(boolean... values) { new VE_notTrueOOO(1, values); }

	
	
	public static void notFalse(boolean value) { new VE_notFalse(1, value); }
	
	public static void notFalse(boolean... values) { new VE_notFalseMulti(1, values); }

	public static void notFalseOOO(boolean... values) { new VE_notFalseOOO(1, values); }

	
	
	public static void notEqual(boolean expected, boolean value) { new VE_notEqual(1, expected, value); }
	
	public static void notEqual(boolean expected, boolean... values) { new VE_notEqualMulti(1, expected, values); }

	public static void notEqualOOO(boolean expected, boolean... values) { new VE_notEqualOOO(1, expected, values); }

	
	
	public static <A> void notNull(A value) { new VE_notNull(1, value); }

	@SafeVarargs public static <A> void notNull(A... values) { new VE_notNullMulti(1, values); }

	@SafeVarargs public static <A> void notNullOOO(A... values) { new VE_notNullOOO(1, values); }

	
	
	public static void notInBetween(int min, int max, int value) { new VE_notInBetween(1, min, max, value); }
	public static void notInBetween(long min, long max, long value) { new VE_notInBetween(1, min, max, value); }
	public static void notInBetween(float min, float max, float value) { new VE_notInBetween(1, min, max, value); }
	public static void notInBetween(double min, double max,double value) { new VE_notInBetween(1, min, max, value); }

	public static void notInBetween(int min, int max, int... values) { new VE_notInBetweenMulti(1, min, max, values); }
	public static void notInBetween(long min, long max, long... values) { new VE_notInBetweenMulti(1, min, max, values); }
	public static void notInBetween(float min, float max, float... values) { new VE_notInBetweenMulti(1, min, max, values); }
	public static void notInBetween(double min, double max, double... values) { new VE_notInBetweenMulti(1, min, max, values); }
	

	
	public static void notInRange(int min, int max, int value) { new VE_notInRange(1, min, max, value); }
	public static void notInRange(long min, long max, long value) { new VE_notInRange(1, min, max, value); }
	public static void notInRange(float min, float max, float value) { new VE_notInRange(1, min, max, value); }
	public static void notInRange(double min, double max, double value) { new VE_notInRange(1, min, max, value); }

	public static void notInRange(int min, int max, int... values) { new VE_notInRangeMulti(1, min, max, values); }
	public static void notInRange(long min, long max, long... values) { new VE_notInRangeMulti(1, min, max, values); }
	public static void notInRange(float min, float max, float... values) { new VE_notInRangeMulti(1, min, max, values); }
	public static void notInRange(double min, double max, double... values) { new VE_notInRangeMulti(1, min, max, values); }

	
	
	public static void notBelow(int threshold, int value) { new VE_notBelow(1, threshold, value); }
	public static void notBelow(long threshold, long value) { new VE_notBelow(1, threshold, value); }
	public static void notBelow(float threshold, float value) { new VE_notBelow(1, threshold, value); }
	public static void notBelow(double threshold, double value) { new VE_notBelow(1, threshold, value); }


	
	public static void notAbove(int threshold, int value) { new VE_notAbove(1, threshold, value); }
	public static void notAbove(long threshold, long value) { new VE_notAbove(1, threshold, value); }
	public static void notAbove(float threshold, float value) { new VE_notAbove(1, threshold, value); }
	public static void notAbove(double threshold, double value) { new VE_notAbove(1, threshold, value); }

	
	
	public static void notEmpty(String str) { Validate.notEmpty(str, "Validate notEmpty: string is empty!"); }
	public static void notEmpty(String str, String msg) { Validate.notEmpty(str, msg, Exceptions.Validation); }
	public static void notEmpty(String str, String msg, Class<? extends RuntimeException> e) { if(Check.isNullOrEmpty(str)) Exceptions.handle(e, msg); }
	
	public static <A> void notEmpty(A[] arg) { Validate.notEmpty(arg, "Validate notEmpty: array is empty!"); }
	public static <A> void notEmpty(A[] arg, String msg) { Validate.notEmpty(arg, msg, Exceptions.Validation); }
	public static <A> void notEmpty(A[] arg, String msg, Class<? extends RuntimeException> e) { if(Check.isNullOrEmpty(arg)) Exceptions.handle(e, msg); }
	
	public static <A> void notEmpty(List<A> list) { Validate.notEmpty(list, "Validate notEmpty: list is empty!"); }
	public static <A> void notEmpty(List<A> list, String msg) { if(Check.isEmpty(list)) Validate.notEmpty(list, msg, Exceptions.Validation); }
	public static <A> void notEmpty(List<A> list, String msg, Class<? extends RuntimeException> e) { if(Check.isEmpty(list)) Exceptions.handle(e, msg); }
	
}

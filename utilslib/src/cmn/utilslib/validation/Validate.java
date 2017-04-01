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
	
	public static void isInBetweenOOO(int min, int max, int... values) { new VE_isInBetweenOOO(1, min, max, values); }
	public static void isInBetweenOOO(long min, long max, long... values) { new VE_isInBetweenOOO(1, min, max, values); }
	public static void isInBetweenOOO(float min, float max, float... values) { new VE_isInBetweenOOO(1, min, max, values); }
	public static void isInBetweenOOO(double min, double max, double... values) { new VE_isInBetweenOOO(1, min, max, values); }
	
	
	
	public static void isInRange(int min, int max, int value) { new VE_isInRange(1, min, max, value);  }
	public static void isInRange(long min, long max, long value) { new VE_isInRange(1, min, max, value); }
	public static void isInRange(float min, float max, float value) { new VE_isInRange(1, min, max, value); }
	public static void isInRange(double min, double max, double value) { new VE_isInRange(1, min, max, value); }

	public static void isInRange(int min, int max, int... values) { new VE_isInRangeMulti(1, min, max, values); }
	public static void isInRange(long min, long max, long... values) { new VE_isInRangeMulti(1, min, max, values); }
	public static void isInRange(float min, float max, float... values) { new VE_isInRangeMulti(1, min, max, values); }
	public static void isInRange(double min, double max, double... values) { new VE_isInRangeMulti(1, min, max, values); }
	
	public static void isInRangeOOO(int min, int max, int... values) { new VE_isInRangeOOO(1, min, max, values); }
	public static void isInRangeOOO(long min, long max, long... values) { new VE_isInRangeOOO(1, min, max, values); }
	public static void isInRangeOOO(float min, float max, float... values) { new VE_isInRangeOOO(1, min, max, values); }
	public static void isInRangeOOO(double min, double max, double... values) { new VE_isInRangeOOO(1, min, max, values); }
	
	
	
	public static void isBelow(int min, int value) { new VE_isBelow(1, min, value);  }
	public static void isBelow(long min, long value) { new VE_isBelow(1, min, value); }
	public static void isBelow(float min, float value) { new VE_isBelow(1, min, value); }
	public static void isBelow(double min, double value) { new VE_isBelow(1, min, value); }
	
	public static void isBelow(int min, int... values) { new VE_isBelowMulti(1, min, values);  }
	public static void isBelow(long min, long... values) { new VE_isBelowMulti(1, min, values); }
	public static void isBelow(float min, float... values) { new VE_isBelowMulti(1, min, values); }
	public static void isBelow(double min, double... values) { new VE_isBelowMulti(1, min, values); }
	
	public static void isBelowOOO(int min, int... values) { new VE_isBelowOOO(1, min, values);  }
	public static void isBelowOOO(long min, long... values) { new VE_isBelowOOO(1, min, values); }
	public static void isBelowOOO(float min, float... values) { new VE_isBelowOOO(1, min, values); }
	public static void isBelowOOO(double min, double... values) { new VE_isBelowOOO(1, min, values); }


	
	public static void isAbove(int max, int value) { new VE_isAbove(1, max, value); }
	public static void isAbove(long max, long value) { new VE_isAbove(1, max, value);  }
	public static void isAbove(float max, float value) { new VE_isAbove(1, max, value); }
	public static void isAbove(double max, double value) { new VE_isAbove(1, max, value); }
	
	public static void isAbove(int max, int... values) { new VE_isAboveMulti(1, max, values); }
	public static void isAbove(long max, long... values) { new VE_isAboveMulti(1, max, values);  }
	public static void isAbove(float max, float... values) { new VE_isAboveMulti(1, max, values); }
	public static void isAbove(double max, double... values) { new VE_isAboveMulti(1, max, values); }
	
	public static void isAboveOOO(int max, int... values) { new VE_isAboveOOO(1, max, values); }
	public static void isAboveOOO(long max, long... values) { new VE_isAboveOOO(1, max, values);  }
	public static void isAboveOOO(float max, float... values) { new VE_isAboveOOO(1, max, values); }
	public static void isAboveOOO(double max, double... values) { new VE_isAboveOOO(1, max, values); }
	
	
	
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
	
	public static void notInBetweenOOO(int min, int max, int... values) { new VE_notInBetweenOOO(1, min, max, values); }
	public static void notInBetweenOOO(long min, long max, long... values) { new VE_notInBetweenOOO(1, min, max, values); }
	public static void notInBetweenOOO(float min, float max, float... values) { new VE_notInBetweenOOO(1, min, max, values); }
	public static void notInBetweenOOO(double min, double max, double... values) { new VE_notInBetweenOOO(1, min, max, values); }
	

	
	public static void notInRange(int min, int max, int value) { new VE_notInRange(1, min, max, value); }
	public static void notInRange(long min, long max, long value) { new VE_notInRange(1, min, max, value); }
	public static void notInRange(float min, float max, float value) { new VE_notInRange(1, min, max, value); }
	public static void notInRange(double min, double max, double value) { new VE_notInRange(1, min, max, value); }

	public static void notInRange(int min, int max, int... values) { new VE_notInRangeMulti(1, min, max, values); }
	public static void notInRange(long min, long max, long... values) { new VE_notInRangeMulti(1, min, max, values); }
	public static void notInRange(float min, float max, float... values) { new VE_notInRangeMulti(1, min, max, values); }
	public static void notInRange(double min, double max, double... values) { new VE_notInRangeMulti(1, min, max, values); }
	
	public static void notInRangeOOO(int min, int max, int... values) { new VE_notInRangeOOO(1, min, max, values); }
	public static void notInRangeOOO(long min, long max, long... values) { new VE_notInRangeOOO(1, min, max, values); }
	public static void notInRangeOOO(float min, float max, float... values) { new VE_notInRangeOOO(1, min, max, values); }
	public static void notInRangeOOO(double min, double max, double... values) { new VE_notInRangeOOO(1, min, max, values); }

	
	
	public static void notBelow(int min, int value) { new VE_notBelow(1, min, value); }
	public static void notBelow(long min, long value) { new VE_notBelow(1, min, value); }
	public static void notBelow(float min, float value) { new VE_notBelow(1, min, value); }
	public static void notBelow(double min, double value) { new VE_notBelow(1, min, value); }
	
	public static void notBelow(int min, int... values) { new VE_notBelowMulti(1, min, values); }
	public static void notBelow(long min, long... values) { new VE_notBelowMulti(1, min, values); }
	public static void notBelow(float min, float... values) { new VE_notBelowMulti(1, min, values); }
	public static void notBelow(double min, double... values) { new VE_notBelowMulti(1, min, values); }
	
	public static void notBelowOOO(int min, int... values) { new VE_notBelowOOO(1, min, values); }
	public static void notBelowOOO(long min, long... values) { new VE_notBelowOOO(1, min, values); }
	public static void notBelowOOO(float min, float... values) { new VE_notBelowOOO(1, min, values); }
	public static void notBelowOOO(double min, double... values) { new VE_notBelowOOO(1, min, values); }


	
	public static void notAbove(int max, int value) { new VE_notAbove(1, max, value); }
	public static void notAbove(long max, long value) { new VE_notAbove(1, max, value); }
	public static void notAbove(float max, float value) { new VE_notAbove(1, max, value); }
	public static void notAbove(double max, double value) { new VE_notAbove(1, max, value); }
	
	public static void notAbove(int max, int... values) { new VE_notAboveMulti(1, max, values); }
	public static void notAbove(long max, long... values) { new VE_notAboveMulti(1, max, values); }
	public static void notAbove(float max, float... values) { new VE_notAboveMulti(1, max, values); }
	public static void notAbove(double max, double... values) { new VE_notAboveMulti(1, max, values); }

	public static void notAboveOOO(int max, int... values) { new VE_notAboveOOO(1, max, values); }
	public static void notAboveOOO(long max, long... values) { new VE_notAboveOOO(1, max, values); }
	public static void notAboveOOO(float max, float... values) { new VE_notAboveOOO(1, max, values); }
	public static void notAboveOOO(double max, double... values) { new VE_notAboveOOO(1, max, values); }
	
	
	
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

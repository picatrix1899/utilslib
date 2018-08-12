package cmn.utilslib.validation;

import java.util.List;

import cmn.utilslib.essentials.Check;

/**
 * 

 * @author picatrix1899
 *
 */
public abstract class Validate
{
	
	public static void isTrue(boolean value) { ValidateTrue.isTrue(1, value); }
	
	public static void isTrue(boolean... values) { ValidateTrue.isTrue(1, values); }

	public static void isTrueOOO(boolean... values) { ValidateTrue.isTrueOOO(1, values); }

	
	
	public static void isTrue(Error exception, boolean value) { if(Check.notTrue(value)) throw exception; }
	public static void isTrue(RuntimeException exception, boolean value) { if(Check.notTrue(value)) throw exception; }
	public static <E extends Exception> void isTrue(E exception, boolean value) throws E { if(Check.notTrue(value)) throw exception; }
	
	public static void isTrue(Error exception, boolean...values) { for(boolean value : values) if(Check.notTrue(value)) { throw exception; } }
	public static void isTrue(RuntimeException exception, boolean...values) { for(boolean value : values) if(Check.notTrue(value)) throw exception; }
	public static <E extends Exception> void isTrue(E exception, boolean...values) throws E { for(boolean value : values) if(Check.notTrue(value)) throw exception; } 
	
	public static void isTrueOOO(Error exception, boolean...values) { if(Check.notTrue(values)) { throw exception; } }
	public static void isTrueOOO(RuntimeException exception, boolean...values) { if(Check.notTrue(values)) throw exception; }
	public static <E extends Exception> void isTrueOOO(E exception, boolean...values) throws E { if(Check.notTrue(values)) throw exception; }
	
	
	
	public static void isFalse(boolean value) { ValidateFalse.isFalse(1, value); }
	
	public static void isFalse(boolean... values) { ValidateFalse.isFalse(1, values); }

	public static void isFalseOOO(boolean... values) { ValidateFalse.isFalseOOO(1, values); }

	
	
	public static void isFalse(Error exception, boolean value) { if(Check.isFalse(value)) throw exception; }
	public static void isFalse(RuntimeException exception, boolean value) { if(Check.isFalse(value)) throw exception; }
	public static <E extends Exception> void isFalse(E exception, boolean value) throws E { if(Check.isFalse(value)) throw exception; }
	
	public static void isFalse(Error exception, boolean...values) { for(boolean value : values) if(Check.isFalse(value)) { throw exception; } }
	public static void isFalse(RuntimeException exception, boolean...values) { for(boolean value : values) if(Check.isFalse(value)) throw exception; }
	public static <E extends Exception> void isFalse(E exception, boolean...values) throws E { for(boolean value : values) if(Check.isFalse(value)) throw exception; } 
	
	public static void isFalseOOO(Error exception, boolean...values) { if(Check.isFalseOOO(values)) { throw exception; } }
	public static void isFalseOOO(RuntimeException exception, boolean...values) { if(Check.isFalseOOO(values)) throw exception; }
	public static <E extends Exception> void isFalseOOO(E exception, boolean...values) throws E { if(Check.isFalseOOO(values)) throw exception; }
	
	
	
	public static void isEqual(boolean expected, boolean value) { ValidateEqual.isEqual(1, expected, value); }

	public static void isEqual(boolean expected, boolean... values) { ValidateEqual.isEqual(1, expected, values); }

	public static void isEqualOOO(boolean expected, boolean... values) { ValidateEqual.isEqualOOO(1, expected, values); }

	
	
	public static void isEqual(Error exception, boolean expected, boolean value) { if(Check.notEqual(expected, value)) throw exception; }
	public static void isEqual(RuntimeException exception, boolean expected, boolean value) { if(Check.notEqual(expected, value)) throw exception; }
	public static <E extends Exception> void isEqual(E exception, boolean expected, boolean value) throws E { if(Check.notEqual(expected, value)) throw exception; }
	
	public static void isEqual(Error exception, boolean expected, boolean... values) { for(boolean value : values) if(Check.notEqual(expected, value)) throw exception; }
	public static void isEqual(RuntimeException exception, boolean expected, boolean... values) { for(boolean value : values) if(Check.notEqual(expected, value)) throw exception; }
	public static <E extends Exception> void isEqual(E exception, boolean expected, boolean... values) throws E { for(boolean value : values) if(Check.notEqual(expected, value)) throw exception; }
	
	public static void isEqualOOO(Error exception, boolean expected, boolean... values) { if(Check.notEqual(expected, values)) throw exception; }
	public static void isEqualOOO(RuntimeException exception, boolean expected, boolean... values) { if(Check.notEqual(expected, values)) throw exception; }
	public static <E extends Exception> void isEqualOOO(E exception, boolean expected, boolean... values) throws E { if(Check.notEqual(expected, values)) throw exception; }
	
	
	
	public static <A> void isNull(A value) { ValidateNull.isNull(1, value); }

	@SafeVarargs public static <A> void isNull(A... values) { ValidateNull.isNull(1, values); }

	@SafeVarargs public static <A> void isNullOOO(A... values) { ValidateNull.isNullOOO(1, values); }
	
	
	
	public static void isInBetween(int min, int max, int value) { ValidateInBetween.isInBetween(1, min, max, value); }
	public static void isInBetween(long min, long max, long value) { ValidateInBetween.isInBetween(1, min, max, value);  }
	public static void isInBetween(float min, float max, float value) { ValidateInBetween.isInBetween(1, min, max, value);  }
	public static void isInBetween(double min, double max, double value) { ValidateInBetween.isInBetween(1, min, max, value);  }

	public static void isInBetween(int min, int max, int... values) { ValidateInBetween.isInBetween(1, min, max, values); }
	public static void isInBetween(long min, long max, long... values) { ValidateInBetween.isInBetween(1, min, max, values); }
	public static void isInBetween(float min, float max, float... values) { ValidateInBetween.isInBetween(1, min, max, values); }
	public static void isInBetween(double min, double max, double... values) { ValidateInBetween.isInBetween(1, min, max, values); }
	
	public static void isInBetweenOOO(int min, int max, int... values) { ValidateInBetween.isInBetweenOOO(1, min, max, values); }
	public static void isInBetweenOOO(long min, long max, long... values) { ValidateInBetween.isInBetweenOOO(1, min, max, values); }
	public static void isInBetweenOOO(float min, float max, float... values) { ValidateInBetween.isInBetweenOOO(1, min, max, values); }
	public static void isInBetweenOOO(double min, double max, double... values) { ValidateInBetween.isInBetweenOOO(1, min, max, values); }
	
	
	
	public static void isInBetween(Error exception, int min, int max, int value) { if(Check.notInBetween(min, max, value)) throw exception; }
	public static void isInBetween(RuntimeException exception, int min, int max, int value) { if(Check.notInBetween(min, max, value)) throw exception; }
	public static <E extends Exception> void isInBetween(E exception, int min, int max, int value) throws E { if(Check.notInBetween(min, max, value)) throw exception; }
	public static void isInBetween(Error exception, long min, long max, long value) { if(Check.notInBetween(min, max, value)) throw exception; }
	public static void isInBetween(RuntimeException exception, long min, long max, long value) { if(Check.notInBetween(min, max, value)) throw exception; }
	public static <E extends Exception> void isInBetween(E exception, long min, long max, long value) throws E { if(Check.notInBetween(min, max, value)) throw exception; }
	public static void isInBetween(Error exception, float min, float max, float value) { if(Check.notInBetween(min, max, value)) throw exception; }
	public static void isInBetween(RuntimeException exception, float min, float max, float value) { if(Check.notInBetween(min, max, value)) throw exception; }
	public static <E extends Exception> void isInBetween(E exception, float min, float max, float value) throws E { if(Check.notInBetween(min, max, value)) throw exception; }
	public static void isInBetween(Error exception, double min, double max, double value) { if(Check.notInBetween(min, max, value)) throw exception; }
	public static void isInBetween(RuntimeException exception, double min, double max, double value) { if(Check.notInBetween(min, max, value)) throw exception; }
	public static <E extends Exception> void isInBetween(E exception, double min, double max, double value) throws E { if(Check.notInBetween(min, max, value)) throw exception; }
	
	public static void isInBetween(Error exception, int min, int max, int...values) { for(int value : values) if(Check.notInBetween(min, max, value)) { throw exception; } }
	public static void isInBetween(RuntimeException exception, int min, int max, int...values) { for(int value : values) if(Check.notInBetween(min, max, value)) throw exception; }
	public static <E extends Exception> void isInBetween(E exception, int min, int max, int...values) throws E { for(int value : values) if(Check.notInBetween(min, max, value)) throw exception; } 
	public static void isInBetween(Error exception, long min, long max, long...values) { for(long value : values) if(Check.notInBetween(min, max, value)) { throw exception; } }
	public static void isInBetween(RuntimeException exception, long min, long max, long...values) { for(long value : values) if(Check.notInBetween(min, max, value)) throw exception; }
	public static <E extends Exception> void isInBetween(E exception, long min, long max, long...values) throws E { for(long value : values) if(Check.notInBetween(min, max, value)) throw exception; } 
	public static void isInBetween(Error exception, float min, float max, float...values) { for(float value : values) if(Check.notInBetween(min, max, value)) { throw exception; } }
	public static void isInBetween(RuntimeException exception, float min, float max, float...values) { for(float value : values) if(Check.notInBetween(min, max, value)) throw exception; }
	public static <E extends Exception> void isInBetween(E exception, float min, float max, float...values) throws E { for(float value : values) if(Check.notInBetween(min, max, value)) throw exception; } 
	public static void isInBetween(Error exception, double min, double max, double...values) { for(double value : values) if(Check.notInBetween(min, max, value)) { throw exception; } }
	public static void isInBetween(RuntimeException exception, double min, double max, double...values) { for(double value : values) if(Check.notInBetween(min, max, value)) throw exception; }
	public static <E extends Exception> void isInBetween(E exception, double min, double max, double...values) throws E { for(double value : values) if(Check.notInBetween(min, max, value)) throw exception; } 
	
	public static void isInBetweenOOO(Error exception, int min, int max, int...values) { if(Check.notInBetween(min, max, values)) { throw exception; } }
	public static void isInBetweenOOO(RuntimeException exception, int min, int max, int...values) { if(Check.notInBetween(min, max, values)) throw exception; }
	public static <E extends Exception> void isInBetweenOOO(E exception, int min, int max, int...values) throws E { if(Check.notInBetween(min, max, values)) throw exception; }
	public static void isInBetweenOOO(Error exception, long min, long max, long...values) { if(Check.notInBetween(min, max, values)) { throw exception; } }
	public static void isInBetweenOOO(RuntimeException exception, long min, long max, long...values) { if(Check.notInBetween(min, max, values)) throw exception; }
	public static <E extends Exception> void isInBetweenOOO(E exception, long min, long max, long...values) throws E { if(Check.notInBetween(min, max, values)) throw exception; }
	public static void isInBetweenOOO(Error exception, float min, float max, float...values) { if(Check.notInBetween(min, max, values)) { throw exception; } }
	public static void isInBetweenOOO(RuntimeException exception, float min, float max, float...values) { if(Check.notInBetween(min, max, values)) throw exception; }
	public static <E extends Exception> void isInBetweenOOO(E exception, float min, float max, float...values) throws E { if(Check.notInBetween(min, max, values)) throw exception; }
	public static void isInBetweenOOO(Error exception, double min, double max, double...values) { if(Check.notInBetween(min, max, values)) { throw exception; } }
	public static void isInBetweenOOO(RuntimeException exception, double min, double max, double...values) { if(Check.notInBetween(min, max, values)) throw exception; }
	public static <E extends Exception> void isInBetweenOOO(E exception, double min, double max, double...values) throws E { if(Check.notInBetween(min, max, values)) throw exception; }
	
	
	
	
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
	
	
	

	
	
	public static void isBelow(int min, int value) { ValidateBelow.isBelow(1, min, value);  }
	public static void isBelow(long min, long value) { ValidateBelow.isBelow(1, min, value); }
	public static void isBelow(float min, float value) { ValidateBelow.isBelow(1, min, value); }
	public static void isBelow(double min, double value) { ValidateBelow.isBelow(1, min, value); }
	
	public static void isBelow(int min, int... values) { ValidateBelow.isBelow(1, min, values);  }
	public static void isBelow(long min, long... values) { ValidateBelow.isBelow(1, min, values); }
	public static void isBelow(float min, float... values) { ValidateBelow.isBelow(1, min, values); }
	public static void isBelow(double min, double... values) { ValidateBelow.isBelow(1, min, values); }
	
	public static void isBelowOOO(int min, int... values) { ValidateBelow.isBelowOOO(1, min, values);  }
	public static void isBelowOOO(long min, long... values) { ValidateBelow.isBelowOOO(1, min, values); }
	public static void isBelowOOO(float min, float... values) { ValidateBelow.isBelowOOO(1, min, values); }
	public static void isBelowOOO(double min, double... values) { ValidateBelow.isBelowOOO(1, min, values); }


	
	public static void isBelow(Error exception, int min, int value) { if(Check.notBelow(min, value)) throw exception; }
	public static void isBelow(RuntimeException exception, int min, int value) { if(Check.notBelow(min, value)) throw exception; }
	public static <E extends Exception> void isBelow(E exception, int min, int value) throws E { if(Check.notBelow(min, value)) throw exception; }
	public static void isBelow(Error exception, long min, long value) { if(Check.notBelow(min, value)) throw exception; }
	public static void isBelow(RuntimeException exception, long min, long value) { if(Check.notBelow(min, value)) throw exception; }
	public static <E extends Exception> void isBelow(E exception, long min, long value) throws E { if(Check.notBelow(min, value)) throw exception; }
	public static void isBelow(Error exception, float min, float value) { if(Check.notBelow(min, value)) throw exception; }
	public static void isBelow(RuntimeException exception, float min, float value) { if(Check.notBelow(min, value)) throw exception; }
	public static <E extends Exception> void isBelow(E exception, float min, float value) throws E { if(Check.notBelow(min, value)) throw exception; }
	public static void isBelow(Error exception, double min, double value) { if(Check.notBelow(min, value)) throw exception; }
	public static void isBelow(RuntimeException exception, double min, double value) { if(Check.notBelow(min, value)) throw exception; }
	public static <E extends Exception> void isBelow(E exception, double min, double value) throws E { if(Check.notBelow(min, value)) throw exception; }
	
	public static void isBelow(Error exception, int min, int...values) { for(int value : values) if(Check.notBelow(min, value)) { throw exception; } }
	public static void isBelow(RuntimeException exception, int min, int...values) { for(int value : values) if(Check.notBelow(min, value)) throw exception; }
	public static <E extends Exception> void isBelow(E exception, int min, int...values) throws E { for(int value : values) if(Check.notBelow(min, value)) throw exception; } 
	public static void isBelow(Error exception, long min, long...values) { for(long value : values) if(Check.notBelow(min, value)) { throw exception; } }
	public static void isBelow(RuntimeException exception, long min, long...values) { for(long value : values) if(Check.notBelow(min, value)) throw exception; }
	public static <E extends Exception> void isBelow(E exception, long min, long...values) throws E { for(long value : values) if(Check.notBelow(min, value)) throw exception; } 
	public static void isBelow(Error exception, float min, float...values) { for(float value : values) if(Check.notBelow(min, value)) { throw exception; } }
	public static void isBelow(RuntimeException exception, float min, float...values) { for(float value : values) if(Check.notBelow(min, value)) throw exception; }
	public static <E extends Exception> void isBelow(E exception, float min, float...values) throws E { for(float value : values) if(Check.notBelow(min, value)) throw exception; } 
	public static void isBelow(Error exception, double min, double...values) { for(double value : values) if(Check.notBelow(min, value)) { throw exception; } }
	public static void isBelow(RuntimeException exception, double min, double...values) { for(double value : values) if(Check.notBelow(min, value)) throw exception; }
	public static <E extends Exception> void isBelow(E exception, double min, double...values) throws E { for(double value : values) if(Check.notBelow(min, value)) throw exception; } 
	
	public static void isBelowOOO(Error exception, int min, int...values) { if(Check.notBelow(min, values)) { throw exception; } }
	public static void isBelowOOO(RuntimeException exception, int min, int...values) { if(Check.notBelow(min, values)) throw exception; }
	public static <E extends Exception> void isBelowOOO(E exception, int min, int...values) throws E { if(Check.notBelow(min, values)) throw exception; }
	public static void isBelowOOO(Error exception, long min, long...values) { if(Check.notBelow(min, values)) { throw exception; } }
	public static void isBelowOOO(RuntimeException exception, long min, long...values) { if(Check.notBelow(min, values)) throw exception; }
	public static <E extends Exception> void isBelowOOO(E exception, long min, long...values) throws E { if(Check.notBelow(min, values)) throw exception; }
	public static void isBelowOOO(Error exception, float min, float...values) { if(Check.notBelow(min, values)) { throw exception; } }
	public static void isBelowOOO(RuntimeException exception, float min, float...values) { if(Check.notBelow(min, values)) throw exception; }
	public static <E extends Exception> void isBelowOOO(E exception, float min, float...values) throws E { if(Check.notBelow(min, values)) throw exception; }
	public static void isBelowOOO(Error exception, double min, double...values) { if(Check.notBelow(min, values)) { throw exception; } }
	public static void isBelowOOO(RuntimeException exception, double min, double...values) { if(Check.notBelow(min, values)) throw exception; }
	public static <E extends Exception> void isBelowOOO(E exception, double min, double...values) throws E { if(Check.notBelow(min, values)) throw exception; }
	
	
	
	public static void isAbove(int max, int value) { ValidateAbove.isAbove(1, max, value); }
	public static void isAbove(long max, long value) { ValidateAbove.isAbove(1, max, value);  }
	public static void isAbove(float max, float value) { ValidateAbove.isAbove(1, max, value); }
	public static void isAbove(double max, double value) { ValidateAbove.isAbove(1, max, value); }
	
	public static void isAbove(int max, int... values) { ValidateAbove.isAbove(1, max, values); }
	public static void isAbove(long max, long... values) { ValidateAbove.isAbove(1, max, values);  }
	public static void isAbove(float max, float... values) { ValidateAbove.isAbove(1, max, values); }
	public static void isAbove(double max, double... values) { ValidateAbove.isAbove(1, max, values); }
	
	public static void isAboveOOO(int max, int... values) { ValidateAbove.isAboveOOO(1, max, values); }
	public static void isAboveOOO(long max, long... values) { ValidateAbove.isAboveOOO(1, max, values);  }
	public static void isAboveOOO(float max, float... values) { ValidateAbove.isAboveOOO(1, max, values); }
	public static void isAboveOOO(double max, double... values) { ValidateAbove.isAboveOOO(1, max, values); }
	
	
	
	public static void isAbove(Error exception, int min, int value) { if(Check.notAbove(min, value)) throw exception; }
	public static void isAbove(RuntimeException exception, int min, int value) { if(Check.notAbove(min, value)) throw exception; }
	public static <E extends Exception> void isAbove(E exception, int min, int value) throws E { if(Check.notAbove(min, value)) throw exception; }
	public static void isAbove(Error exception, long min, long value) { if(Check.notAbove(min, value)) throw exception; }
	public static void isAbove(RuntimeException exception, long min, long value) { if(Check.notAbove(min, value)) throw exception; }
	public static <E extends Exception> void isAbove(E exception, long min, long value) throws E { if(Check.notAbove(min, value)) throw exception; }
	public static void isAbove(Error exception, float min, float value) { if(Check.notAbove(min, value)) throw exception; }
	public static void isAbove(RuntimeException exception, float min, float value) { if(Check.notAbove(min, value)) throw exception; }
	public static <E extends Exception> void isAbove(E exception, float min, float value) throws E { if(Check.notAbove(min, value)) throw exception; }
	public static void isAbove(Error exception, double min, double value) { if(Check.notAbove(min, value)) throw exception; }
	public static void isAbove(RuntimeException exception, double min, double value) { if(Check.notAbove(min, value)) throw exception; }
	public static <E extends Exception> void isAbove(E exception, double min, double value) throws E { if(Check.notAbove(min, value)) throw exception; }
	
	public static void isAbove(Error exception, int min, int...values) { for(int value : values) if(Check.notAbove(min, value)) { throw exception; } }
	public static void isAbove(RuntimeException exception, int min, int...values) { for(int value : values) if(Check.notAbove(min, value)) throw exception; }
	public static <E extends Exception> void isAbove(E exception, int min, int...values) throws E { for(int value : values) if(Check.notAbove(min, value)) throw exception; } 
	public static void isAbove(Error exception, long min, long...values) { for(long value : values) if(Check.notAbove(min, value)) { throw exception; } }
	public static void isAbove(RuntimeException exception, long min, long...values) { for(long value : values) if(Check.notAbove(min, value)) throw exception; }
	public static <E extends Exception> void isAbove(E exception, long min, long...values) throws E { for(long value : values) if(Check.notAbove(min, value)) throw exception; } 
	public static void isAbove(Error exception, float min, float...values) { for(float value : values) if(Check.notAbove(min, value)) { throw exception; } }
	public static void isAbove(RuntimeException exception, float min, float...values) { for(float value : values) if(Check.notAbove(min, value)) throw exception; }
	public static <E extends Exception> void isAbove(E exception, float min, float...values) throws E { for(float value : values) if(Check.notAbove(min, value)) throw exception; } 
	public static void isAbove(Error exception, double min, double...values) { for(double value : values) if(Check.notAbove(min, value)) { throw exception; } }
	public static void isAbove(RuntimeException exception, double min, double...values) { for(double value : values) if(Check.notAbove(min, value)) throw exception; }
	public static <E extends Exception> void isAbove(E exception, double min, double...values) throws E { for(double value : values) if(Check.notAbove(min, value)) throw exception; } 
	
	public static void isAboveOOO(Error exception, int min, int...values) { if(Check.notAbove(min, values)) { throw exception; } }
	public static void isAboveOOO(RuntimeException exception, int min, int...values) { if(Check.notAbove(min, values)) throw exception; }
	public static <E extends Exception> void isAboveOOO(E exception, int min, int...values) throws E { if(Check.notAbove(min, values)) throw exception; }
	public static void isAboveOOO(Error exception, long min, long...values) { if(Check.notAbove(min, values)) { throw exception; } }
	public static void isAboveOOO(RuntimeException exception, long min, long...values) { if(Check.notAbove(min, values)) throw exception; }
	public static <E extends Exception> void isAboveOOO(E exception, long min, long...values) throws E { if(Check.notAbove(min, values)) throw exception; }
	public static void isAboveOOO(Error exception, float min, float...values) { if(Check.notAbove(min, values)) { throw exception; } }
	public static void isAboveOOO(RuntimeException exception, float min, float...values) { if(Check.notAbove(min, values)) throw exception; }
	public static <E extends Exception> void isAboveOOO(E exception, float min, float...values) throws E { if(Check.notAbove(min, values)) throw exception; }
	public static void isAboveOOO(Error exception, double min, double...values) { if(Check.notAbove(min, values)) { throw exception; } }
	public static void isAboveOOO(RuntimeException exception, double min, double...values) { if(Check.notAbove(min, values)) throw exception; }
	public static <E extends Exception> void isAboveOOO(E exception, double min, double...values) throws E { if(Check.notAbove(min, values)) throw exception; }
	
	
	
	public static void isEmpty(String str) { ValidateEmpty.isEmpty(1, str); }
	
	public static <T> void isEmpty(T[] args) { ValidateEmpty.isEmpty(1, args); }
	
	public static <T> void isEmpty(List<T> list) { ValidateEmpty.isEmpty(1, list); }

	
	
	public static void isEmpty(Error exception, String str) { if(Check.notEmpty(str)) throw exception; }
	public static void isEmpty(RuntimeException exception, String str) { if(Check.notEmpty(str)) throw exception; }
	public static <E extends Exception> void isEmpty(E exception, String str) throws E { if(Check.notEmpty(str)) throw exception; }
	
	public static <T> void isEmpty(Error exception, T[] args) { if(Check.notEmpty(args)) throw exception; }
	public static <T> void isEmpty(RuntimeException exception, T[] args) { if(Check.notEmpty(args)) throw exception; }
	public static <T,E extends Exception> void isEmpty(E exception, T[] args) throws E { if(Check.notEmpty(args)) throw exception; }
	
	public static <T> void isEmpty(Error exception, List<T> args) { if(Check.notEmpty(args)) throw exception; }
	public static <T> void isEmpty(RuntimeException exception, List<T> args) { if(Check.notEmpty(args)) throw exception; }
	public static <T,E extends Exception> void isEmpty(E exception, List<T> args) throws E { if(Check.notEmpty(args)) throw exception; }
	
	
	
	public static void notTrue(boolean value) { ValidateTrue.notTrue(1, value); }
	
	public static void notTrue(boolean... values) { ValidateTrue.notTrue(1, values); }

	public static void notTrueOOO(boolean... values) { ValidateTrue.notTrueOOO(1, values); }

	
	
	public static void notTrue(Error exception, boolean value) { if(Check.isTrue(value)) throw exception; }
	public static void notTrue(RuntimeException exception, boolean value) { if(Check.isTrue( value)) throw exception; }
	public static <E extends Exception> void notTrue(E exception, boolean value) throws E { if(Check.isTrue(value)) throw exception; }
	
	public static void notTrue(Error exception, boolean...values) { for(boolean value : values) if(Check.isTrue(value)) { throw exception; } }
	public static void notTrue(RuntimeException exception, boolean...values) { for(boolean value : values) if(Check.isTrue(value)) throw exception; }
	public static <E extends Exception> void notTrue(E exception, boolean...values) throws E { for(boolean value : values) if(Check.isTrue(value)) throw exception; } 
	
	public static void notTrueOOO(Error exception, boolean...values) { if(Check.isTrue(values)) { throw exception; } }
	public static void notTrueOOO(RuntimeException exception, boolean...values) { if(Check.isTrue(values)) throw exception; }
	public static <E extends Exception> void notTrueOOO(E exception, boolean...values) throws E { if(Check.isTrue( values)) throw exception; }
	
	
	
	public static void notFalse(boolean value) { ValidateFalse.notFalse(1, value); }
	
	public static void notFalse(boolean... values) { ValidateFalse.notFalse(1, values); }

	public static void notFalseOOO(boolean... values) { ValidateFalse.notFalseOOO(1, values); }

	
	
	public static void notFalse(Error exception, boolean value) { if(Check.isFalse(value)) throw exception; }
	public static void notFalse(RuntimeException exception, boolean value) { if(Check.isFalse( value)) throw exception; }
	public static <E extends Exception> void notFalse(E exception, boolean value) throws E { if(Check.isFalse(value)) throw exception; }
	
	public static void notFalse(Error exception, boolean...values) { for(boolean value : values) if(Check.isFalse(value)) { throw exception; } }
	public static void notFalse(RuntimeException exception, boolean...values) { for(boolean value : values) if(Check.isFalse(value)) throw exception; }
	public static <E extends Exception> void notFalse(E exception, boolean...values) throws E { for(boolean value : values) if(Check.isFalse(value)) throw exception; } 
	
	public static void notFalseOOO(Error exception, boolean...values) { if(Check.isFalseOOO(values)) { throw exception; } }
	public static void notFalseOOO(RuntimeException exception, boolean...values) { if(Check.isFalseOOO(values)) throw exception; }
	public static <E extends Exception> void notFalseOOO(E exception, boolean...values) throws E { if(Check.isFalseOOO( values)) throw exception; }
	
	
	
	public static void notEqual(boolean expected, boolean value) { ValidateEqual.notEqual(1, expected, value); }
	
	public static void notEqual(boolean expected, boolean... values) { ValidateEqual.notEqual(1, expected, values); }

	public static void notEqualOOO(boolean expected, boolean... values) { ValidateEqual.notEqualOOO(1, expected, values); }

	
	
	public static void notEqual(Error exception, boolean expected, boolean value) { if(Check.isEqual(expected, value)) throw exception; }
	public static void notEqual(RuntimeException exception, boolean expected, boolean value) { if(Check.isEqual(expected, value)) throw exception; }
	public static <E extends Exception> void notEqual(E exception, boolean expected, boolean value) throws E { if(Check.isEqual(expected, value)) throw exception; }
	
	public static void notEqual(Error exception, boolean expected, boolean... values) { for(boolean value : values) if(Check.isEqual(expected, value)) throw exception; }
	public static void notEqual(RuntimeException exception, boolean expected, boolean... values) { for(boolean value : values) if(Check.isEqual(expected, value)) throw exception; }
	public static <E extends Exception> void notEqual(E exception, boolean expected, boolean... values) throws E { for(boolean value : values) if(Check.isEqual(expected, value)) throw exception; }
	
	public static void notEqualOOO(Error exception, boolean expected, boolean... values) { if(Check.isEqual(expected, values)) throw exception; }
	public static void notEqualOOO(RuntimeException exception, boolean expected, boolean... values) { if(Check.isEqual(expected, values)) throw exception; }
	public static <E extends Exception> void notEqualOOO(E exception, boolean expected, boolean... values) throws E { if(Check.isEqual(expected, values)) throw exception; }
	
	
	
	public static <A> void notNull(A value) { ValidateNull.notNull(1, value); }

	@SafeVarargs public static <A> void notNull(A... values) { ValidateNull.notNull(1, values); }

	@SafeVarargs public static <A> void notNullOOO(A... values) { ValidateNull.notNullOOO(1, values); }

	
	
	public static void notInBetween(int min, int max, int value) { ValidateInBetween.notInBetween(1, min, max, value); }
	public static void notInBetween(long min, long max, long value) { ValidateInBetween.notInBetween(1, min, max, value); }
	public static void notInBetween(float min, float max, float value) { ValidateInBetween.notInBetween(1, min, max, value); }
	public static void notInBetween(double min, double max,double value) { ValidateInBetween.notInBetween(1, min, max, value); }

	public static void notInBetween(int min, int max, int... values) { ValidateInBetween.notInBetween(1, min, max, values); }
	public static void notInBetween(long min, long max, long... values) { ValidateInBetween.notInBetween(1, min, max, values); }
	public static void notInBetween(float min, float max, float... values) { ValidateInBetween.notInBetween(1, min, max, values); }
	public static void notInBetween(double min, double max, double... values) { ValidateInBetween.notInBetween(1, min, max, values); }
	
	public static void notInBetweenOOO(int min, int max, int... values) { ValidateInBetween.notInBetweenOOO(1, min, max, values); }
	public static void notInBetweenOOO(long min, long max, long... values) { ValidateInBetween.notInBetweenOOO(1, min, max, values); }
	public static void notInBetweenOOO(float min, float max, float... values) { ValidateInBetween.notInBetweenOOO(1, min, max, values); }
	public static void notInBetweenOOO(double min, double max, double... values) { ValidateInBetween.notInBetweenOOO(1, min, max, values); }

	
	
	public static void notInBetween(Error exception, int min, int max, int value) { if(Check.isInBetween(min, max, value)) throw exception; }
	public static void notInBetween(RuntimeException exception, int min, int max, int value) { if(Check.isInBetween(min, max, value)) throw exception; }
	public static <E extends Exception> void notInBetween(E exception, int min, int max, int value) throws E { if(Check.isInBetween(min, max, value)) throw exception; }
	public static void notInBetween(Error exception, long min, long max, long value) { if(Check.isInBetween(min, max, value)) throw exception; }
	public static void notInBetween(RuntimeException exception, long min, long max, long value) { if(Check.isInBetween(min, max, value)) throw exception; }
	public static <E extends Exception> void notInBetween(E exception, long min, long max, long value) throws E { if(Check.isInBetween(min, max, value)) throw exception; }
	public static void notInBetween(Error exception, float min, float max, float value) { if(Check.isInBetween(min, max, value)) throw exception; }
	public static void notInBetween(RuntimeException exception, float min, float max, float value) { if(Check.isInBetween(min, max, value)) throw exception; }
	public static <E extends Exception> void notInBetween(E exception, float min, float max, float value) throws E { if(Check.isInBetween(min, max, value)) throw exception; }
	public static void notInBetween(Error exception, double min, double max, double value) { if(Check.isInBetween(min, max, value)) throw exception; }
	public static void notInBetween(RuntimeException exception, double min, double max, double value) { if(Check.isInBetween(min, max, value)) throw exception; }
	public static <E extends Exception> void notInBetween(E exception, double min, double max, double value) throws E { if(Check.isInBetween(min, max, value)) throw exception; }
	
	public static void notInBetween(Error exception, int min, int max, int...values) { for(int value : values) if(Check.isInBetween(min, max, value)) { throw exception; } }
	public static void notInBetween(RuntimeException exception, int min, int max, int...values) { for(int value : values) if(Check.isInBetween(min, max, value)) throw exception; }
	public static <E extends Exception> void notInBetween(E exception, int min, int max, int...values) throws E { for(int value : values) if(Check.isInBetween(min, max, value)) throw exception; } 
	public static void notInBetween(Error exception, long min, long max, long...values) { for(long value : values) if(Check.isInBetween(min, max, value)) { throw exception; } }
	public static void notInBetween(RuntimeException exception, long min, long max, long...values) { for(long value : values) if(Check.isInBetween(min, max, value)) throw exception; }
	public static <E extends Exception> void notInBetween(E exception, long min, long max, long...values) throws E { for(long value : values) if(Check.isInBetween(min, max, value)) throw exception; } 
	public static void notInBetween(Error exception, float min, float max, float...values) { for(float value : values) if(Check.isInBetween(min, max, value)) { throw exception; } }
	public static void notInBetween(RuntimeException exception, float min, float max, float...values) { for(float value : values) if(Check.isInBetween(min, max, value)) throw exception; }
	public static <E extends Exception> void notInBetween(E exception, float min, float max, float...values) throws E { for(float value : values) if(Check.isInBetween(min, max, value)) throw exception; } 
	public static void notInBetween(Error exception, double min, double max, double...values) { for(double value : values) if(Check.isInBetween(min, max, value)) { throw exception; } }
	public static void notInBetween(RuntimeException exception, double min, double max, double...values) { for(double value : values) if(Check.isInBetween(min, max, value)) throw exception; }
	public static <E extends Exception> void notInBetween(E exception, double min, double max, double...values) throws E { for(double value : values) if(Check.isInBetween(min, max, value)) throw exception; } 
	
	public static void notInBetweenOOO(Error exception, int min, int max, int...values) { if(Check.isInBetween(min, max, values)) { throw exception; } }
	public static void notInBetweenOOO(RuntimeException exception, int min, int max, int...values) { if(Check.isInBetween(min, max, values)) throw exception; }
	public static <E extends Exception> void notInBetweenOOO(E exception, int min, int max, int...values) throws E { if(Check.isInBetween(min, max, values)) throw exception; }
	public static void notInBetweenOOO(Error exception, long min, long max, long...values) { if(Check.isInBetween(min, max, values)) { throw exception; } }
	public static void notInBetweenOOO(RuntimeException exception, long min, long max, long...values) { if(Check.isInBetween(min, max, values)) throw exception; }
	public static <E extends Exception> void notInBetweenOOO(E exception, long min, long max, long...values) throws E { if(Check.isInBetween(min, max, values)) throw exception; }
	public static void notInBetweenOOO(Error exception, float min, float max, float...values) { if(Check.isInBetween(min, max, values)) { throw exception; } }
	public static void notInBetweenOOO(RuntimeException exception, float min, float max, float...values) { if(Check.isInBetween(min, max, values)) throw exception; }
	public static <E extends Exception> void notInBetweenOOO(E exception, float min, float max, float...values) throws E { if(Check.isInBetween(min, max, values)) throw exception; }
	public static void notInBetweenOOO(Error exception, double min, double max, double...values) { if(Check.isInBetween(min, max, values)) { throw exception; } }
	public static void notInBetweenOOO(RuntimeException exception, double min, double max, double...values) { if(Check.isInBetween(min, max, values)) throw exception; }
	public static <E extends Exception> void notInBetweenOOO(E exception, double min, double max, double...values) throws E { if(Check.isInBetween(min, max, values)) throw exception; }
	
	

	
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

	
	
	public static void notBelow(int min, int value) { ValidateBelow.notBelow(1, min, value); }
	public static void notBelow(long min, long value) { ValidateBelow.notBelow(1, min, value); }
	public static void notBelow(float min, float value) { ValidateBelow.notBelow(1, min, value); }
	public static void notBelow(double min, double value) { ValidateBelow.notBelow(1, min, value); }
	
	public static void notBelow(int min, int... values) { ValidateBelow.notBelow(1, min, values); }
	public static void notBelow(long min, long... values) { ValidateBelow.notBelow(1, min, values); }
	public static void notBelow(float min, float... values) { ValidateBelow.notBelow(1, min, values); }
	public static void notBelow(double min, double... values) { ValidateBelow.notBelow(1, min, values); }
	
	public static void notBelowOOO(int min, int... values) { ValidateBelow.notBelowOOO(1, min, values); }
	public static void notBelowOOO(long min, long... values) { ValidateBelow.notBelowOOO(1, min, values); }
	public static void notBelowOOO(float min, float... values) { ValidateBelow.notBelowOOO(1, min, values); }
	public static void notBelowOOO(double min, double... values) { ValidateBelow.notBelowOOO(1, min, values); }

	
	
	public static void notBelow(Error exception, int min, int value) { if(Check.isBelow(min, value)) throw exception; }
	public static void notBelow(RuntimeException exception, int min, int value) { if(Check.isBelow(min, value)) throw exception; }
	public static <E extends Exception> void notBelow(E exception, int min, int value) throws E { if(Check.isBelow(min, value)) throw exception; }
	public static void notBelow(Error exception, long min, long value) { if(Check.isBelow(min, value)) throw exception; }
	public static void notBelow(RuntimeException exception, long min, long value) { if(Check.isBelow(min, value)) throw exception; }
	public static <E extends Exception> void notBelow(E exception, long min, long value) throws E { if(Check.isBelow(min, value)) throw exception; }
	public static void notBelow(Error exception, float min, float value) { if(Check.isBelow(min, value)) throw exception; }
	public static void notBelow(RuntimeException exception, float min, float value) { if(Check.isBelow(min, value)) throw exception; }
	public static <E extends Exception> void notBelow(E exception, float min, float value) throws E { if(Check.isBelow(min, value)) throw exception; }
	public static void notBelow(Error exception, double min, double value) { if(Check.isBelow(min, value)) throw exception; }
	public static void notBelow(RuntimeException exception, double min, double value) { if(Check.isBelow(min, value)) throw exception; }
	public static <E extends Exception> void notBelow(E exception, double min, double value) throws E { if(Check.isBelow(min, value)) throw exception; }
	
	public static void notBelow(Error exception, int min, int...values) { for(int value : values) if(Check.isBelow(min, value)) { throw exception; } }
	public static void notBelow(RuntimeException exception, int min, int...values) { for(int value : values) if(Check.isBelow(min, value)) throw exception; }
	public static <E extends Exception> void notBelow(E exception, int min, int...values) throws E { for(int value : values) if(Check.isBelow(min, value)) throw exception; } 
	public static void notBelow(Error exception, long min, long...values) { for(long value : values) if(Check.isBelow(min, value)) { throw exception; } }
	public static void notBelow(RuntimeException exception, long min, long...values) { for(long value : values) if(Check.isBelow(min, value)) throw exception; }
	public static <E extends Exception> void notBelow(E exception, long min, long...values) throws E { for(long value : values) if(Check.isBelow(min, value)) throw exception; } 
	public static void notBelow(Error exception, float min, float...values) { for(float value : values) if(Check.isBelow(min, value)) { throw exception; } }
	public static void notBelow(RuntimeException exception, float min, float...values) { for(float value : values) if(Check.isBelow(min, value)) throw exception; }
	public static <E extends Exception> void notBelow(E exception, float min, float...values) throws E { for(float value : values) if(Check.isBelow(min, value)) throw exception; } 
	public static void notBelow(Error exception, double min, double...values) { for(double value : values) if(Check.isBelow(min, value)) { throw exception; } }
	public static void notBelow(RuntimeException exception, double min, double...values) { for(double value : values) if(Check.isBelow(min, value)) throw exception; }
	public static <E extends Exception> void notBelow(E exception, double min, double...values) throws E { for(double value : values) if(Check.isBelow(min, value)) throw exception; } 
	
	public static void notBelowOOO(Error exception, int min, int...values) { if(Check.isBelow(min, values)) { throw exception; } }
	public static void notBelowOOO(RuntimeException exception, int min, int...values) { if(Check.isBelow(min, values)) throw exception; }
	public static <E extends Exception> void notBelowOOO(E exception, int min, int...values) throws E { if(Check.isBelow(min, values)) throw exception; }
	public static void notBelowOOO(Error exception, long min, long...values) { if(Check.isBelow(min, values)) { throw exception; } }
	public static void notBelowOOO(RuntimeException exception, long min, long...values) { if(Check.isBelow(min, values)) throw exception; }
	public static <E extends Exception> void notBelowOOO(E exception, long min, long...values) throws E { if(Check.isBelow(min, values)) throw exception; }
	public static void notBelowOOO(Error exception, float min, float...values) { if(Check.isBelow(min, values)) { throw exception; } }
	public static void notBelowOOO(RuntimeException exception, float min, float...values) { if(Check.isBelow(min, values)) throw exception; }
	public static <E extends Exception> void notBelowOOO(E exception, float min, float...values) throws E { if(Check.isBelow(min, values)) throw exception; }
	public static void notBelowOOO(Error exception, double min, double...values) { if(Check.isBelow(min, values)) { throw exception; } }
	public static void notBelowOOO(RuntimeException exception, double min, double...values) { if(Check.isBelow(min, values)) throw exception; }
	public static <E extends Exception> void notBelowOOO(E exception, double min, double...values) throws E { if(Check.isBelow(min, values)) throw exception; }
	
	

	
	public static void notAbove(int max, int value) { ValidateAbove.notAbove(1, max, value); }
	public static void notAbove(long max, long value) { ValidateAbove.notAbove(1, max, value); }
	public static void notAbove(float max, float value) { ValidateAbove.notAbove(1, max, value); }
	public static void notAbove(double max, double value) { ValidateAbove.notAbove(1, max, value); }
	
	public static void notAbove(int max, int... values) { ValidateAbove.notAbove(1, max, values); }
	public static void notAbove(long max, long... values) { ValidateAbove.notAbove(1, max, values); }
	public static void notAbove(float max, float... values) { ValidateAbove.notAbove(1, max, values); }
	public static void notAbove(double max, double... values) { ValidateAbove.notAbove(1, max, values); }

	public static void notAboveOOO(int max, int... values) { ValidateAbove.notAboveOOO(1, max, values); }
	public static void notAboveOOO(long max, long... values) { ValidateAbove.notAboveOOO(1, max, values); }
	public static void notAboveOOO(float max, float... values) { ValidateAbove.notAboveOOO(1, max, values); }
	public static void notAboveOOO(double max, double... values) { ValidateAbove.notAboveOOO(1, max, values); }
	
	
	
	public static void notAbove(Error exception, int min, int value) { if(Check.isAbove(min, value)) throw exception; }
	public static void notAbove(RuntimeException exception, int min, int value) { if(Check.isAbove(min, value)) throw exception; }
	public static <E extends Exception> void notAbove(E exception, int min, int value) throws E { if(Check.isAbove(min, value)) throw exception; }
	public static void notAbove(Error exception, long min, long value) { if(Check.isAbove(min, value)) throw exception; }
	public static void notAbove(RuntimeException exception, long min, long value) { if(Check.isAbove(min, value)) throw exception; }
	public static <E extends Exception> void notAbove(E exception, long min, long value) throws E { if(Check.isAbove(min, value)) throw exception; }
	public static void notAbove(Error exception, float min, float value) { if(Check.isAbove(min, value)) throw exception; }
	public static void notAbove(RuntimeException exception, float min, float value) { if(Check.isAbove(min, value)) throw exception; }
	public static <E extends Exception> void notAbove(E exception, float min, float value) throws E { if(Check.isAbove(min, value)) throw exception; }
	public static void notAbove(Error exception, double min, double value) { if(Check.isAbove(min, value)) throw exception; }
	public static void notAbove(RuntimeException exception, double min, double value) { if(Check.isAbove(min, value)) throw exception; }
	public static <E extends Exception> void notAbove(E exception, double min, double value) throws E { if(Check.isAbove(min, value)) throw exception; }
	
	public static void notAbove(Error exception, int min, int...values) { for(int value : values) if(Check.isAbove(min, value)) { throw exception; } }
	public static void notAbove(RuntimeException exception, int min, int...values) { for(int value : values) if(Check.isAbove(min, value)) throw exception; }
	public static <E extends Exception> void notAbove(E exception, int min, int...values) throws E { for(int value : values) if(Check.isAbove(min, value)) throw exception; } 
	public static void notAbove(Error exception, long min, long...values) { for(long value : values) if(Check.isAbove(min, value)) { throw exception; } }
	public static void notAbove(RuntimeException exception, long min, long...values) { for(long value : values) if(Check.isAbove(min, value)) throw exception; }
	public static <E extends Exception> void notAbove(E exception, long min, long...values) throws E { for(long value : values) if(Check.isAbove(min, value)) throw exception; } 
	public static void notAbove(Error exception, float min, float...values) { for(float value : values) if(Check.isAbove(min, value)) { throw exception; } }
	public static void notAbove(RuntimeException exception, float min, float...values) { for(float value : values) if(Check.isAbove(min, value)) throw exception; }
	public static <E extends Exception> void notAbove(E exception, float min, float...values) throws E { for(float value : values) if(Check.isAbove(min, value)) throw exception; } 
	public static void notAbove(Error exception, double min, double...values) { for(double value : values) if(Check.isAbove(min, value)) { throw exception; } }
	public static void notAbove(RuntimeException exception, double min, double...values) { for(double value : values) if(Check.isAbove(min, value)) throw exception; }
	public static <E extends Exception> void notAbove(E exception, double min, double...values) throws E { for(double value : values) if(Check.isAbove(min, value)) throw exception; } 
	
	public static void notAboveOOO(Error exception, int min, int...values) { if(Check.isAbove(min, values)) { throw exception; } }
	public static void notAboveOOO(RuntimeException exception, int min, int...values) { if(Check.isAbove(min, values)) throw exception; }
	public static <E extends Exception> void notAboveOOO(E exception, int min, int...values) throws E { if(Check.isAbove(min, values)) throw exception; }
	public static void notAboveOOO(Error exception, long min, long...values) { if(Check.isAbove(min, values)) { throw exception; } }
	public static void notAboveOOO(RuntimeException exception, long min, long...values) { if(Check.isAbove(min, values)) throw exception; }
	public static <E extends Exception> void notAboveOOO(E exception, long min, long...values) throws E { if(Check.isAbove(min, values)) throw exception; }
	public static void notAboveOOO(Error exception, float min, float...values) { if(Check.isAbove(min, values)) { throw exception; } }
	public static void notAboveOOO(RuntimeException exception, float min, float...values) { if(Check.isAbove(min, values)) throw exception; }
	public static <E extends Exception> void notAboveOOO(E exception, float min, float...values) throws E { if(Check.isAbove(min, values)) throw exception; }
	public static void notAboveOOO(Error exception, double min, double...values) { if(Check.isAbove(min, values)) { throw exception; } }
	public static void notAboveOOO(RuntimeException exception, double min, double...values) { if(Check.isAbove(min, values)) throw exception; }
	public static <E extends Exception> void notAboveOOO(E exception, double min, double...values) throws E { if(Check.isAbove(min, values)) throw exception; }
	
	
	
	public static void notEmpty(String str) { ValidateEmpty.notEmpty(1, str); }

	public static <A> void notEmpty(A[] args) { ValidateEmpty.notEmpty(1, args); }

	public static <A> void notEmpty(List<A> list) { ValidateEmpty.notEmpty(1, list); }

	
	
	public static void notEmpty(Error exception, String str) { if(Check.isEmpty(str)) throw exception; }
	public static void notEmpty(RuntimeException exception, String str) { if(Check.isEmpty(str)) throw exception; }
	public static <E extends Exception> void notEmpty(E exception, String str) throws E { if(Check.isEmpty(str)) throw exception; }
	
	public static <T> void notEmpty(Error exception, T[] args) { if(Check.isEmpty(args)) throw exception; }
	public static <T> void notEmpty(RuntimeException exception, T[] args) { if(Check.isEmpty(args)) throw exception; }
	public static <T,E extends Exception> void notEmpty(E exception, T[] args) throws E { if(Check.isEmpty(args)) throw exception; }
	
	public static <T> void notEmpty(Error exception, List<T> args) { if(Check.isEmpty(args)) throw exception; }
	public static <T> void notEmpty(RuntimeException exception, List<T> args) { if(Check.isEmpty(args)) throw exception; }
	public static <T,E extends Exception> void notEmpty(E exception, List<T> args) throws E { if(Check.isEmpty(args)) throw exception; }
}

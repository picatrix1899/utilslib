package cmn.utilslib.essentials;



/**
 * 

 * @author picatrix1899
 *
 */
public class PrimeUtils
{
	
	/**
	 * Parses an {@link Integer} value "i" to an int value and takes null-values in account too.
	 * @param i The value to parse.
	 * @return The parsed value.
	 */
	public static int toInt(int def, Integer i) { return i == null ? def : i.intValue(); }
	
	/**
	 * Parses an {@link Integer} array "i" to an int array and takes null-values in account too.
	 * @param i The array to parse.
	 * @return The parsed array.
	 */
	public static int[] toInt(int def, Integer... i)
	{
		
		if(Check.isNull(i)) { return null; }
		
		int[] out = new int[i.length];
		
		for(int x = 0; x < i.length; x++)
			out[x] = PrimeUtils.toInt(def, i[x]);
		
		return out;
	}
	
	/**
	 * Parses an {@link Double} value "i" to an double value and takes null-values in account too.
	 * @param i The value to parse.
	 * @return The parsed value.
	 */
	public static double toDouble(double def, Double i) { return i == null ? def : i.doubleValue(); }
	
	/**
	 * Parses an {@link Double} array "i" to an double array and takes null-values in account too.
	 * @param i The array to parse.
	 * @return The parsed array.
	 */
	public static double[] toDouble(double def, Double... i)
	{
		double[] out = new double[i.length];
		
		for(int x = 0; x < i.length; x++)
			out[x] = PrimeUtils.toDouble(def, i[x]);
		
		return out;
	}
	
	/**
	 * Parses an {@link Long} value "i" to an long value and takes null-values in account too.
	 * @param i The value to parse.
	 * @return The parsed value.
	 */
	public static long toLong(long def, Long i) { return i == null ? def : i.longValue(); }
	
	/**
	 * Parses an {@link Long} array "i" to an long array and takes null-values in account too.
	 * @param i The array to parse.
	 * @return The parsed array.
	 */
	public static long[] toLong(long def, Long... i)
	{
		long[] out = new long[i.length];
		
		for(int x = 0; x < i.length; x++)
			out[x] = PrimeUtils.toLong(def, i[x]);
		
		return out;
	}
	
	/**
	 * Parses an {@link Float} value "i" to an float value and takes null-values in account too.
	 * @param i The value to parse.
	 * @return The parsed value.
	 */
	public static float toFloat(float def, Float i) { return i == null ? def : i.floatValue(); }
	
	/**
	 * Parses an {@link Float} array "i" to an float array and takes null-values in account too.
	 * @param i The array to parse.
	 * @return The parsed array.
	 */
	public static float[] toFloat(float def, Float... i)
	{
		float[] out = new float[i.length];
		
		for(int x = 0; x < i.length; x++)
			out[x] = PrimeUtils.toFloat(def, i[x]);
		
		return out;
	}
	
	/**
	 * Parses an {@link Short} value "i" to an short value and takes null-values in account too.
	 * @param i The value to parse.
	 * @return The parsed value.
	 */
	public static short toShort(short def, Short i) { return i == null ? def : i.shortValue(); }
	
	/**
	 * Parses an {@link Short} array "i" to an short array and takes null-values in account too.
	 * @param i The array to parse.
	 * @return The parsed array.
	 */
	public static short[] toShort(short def, Short... i)
	{
		short[] out = new short[i.length];
		
		for(int x = 0; x < i.length; x++)
			out[x] = PrimeUtils.toShort(def, i[x]);
		
		return out;
	}
	
	/**
	 * Parses an {@link Boolean} value "i" to an boolean value and takes null-values in account too.
	 * @param i The value to parse.
	 * @return The parsed value.
	 */
	public static boolean toBoolean(boolean def, Boolean i) { return i == null ? def : i.booleanValue(); }
	
	/**
	 * Parses an {@link Boolean} array "i" to an boolean array and takes null-values in account too.
	 * @param i The array to parse.
	 * @return The parsed array.
	 */
	public static boolean[] toBoolean(boolean def, Boolean... i)
	{
		boolean[] out = new boolean[i.length];
		
		for(int x = 0; x < i.length; x++)
			out[x] = PrimeUtils.toBoolean(def, i[x]);
		
		return out;
	}
	
}

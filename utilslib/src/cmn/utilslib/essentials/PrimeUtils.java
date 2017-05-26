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
	public static int toInt(Integer i) { return i == null ? 0 : i.intValue(); }
	
	/**
	 * Parses an {@link Integer} array "i" to an int array and takes null-values in account too.
	 * @param i The array to parse.
	 * @return The parsed array.
	 */
	public static int[] toInt(Integer[] i)
	{
		
		if(Check.isNull(i)) { return null; }
		
		int[] out = new int[i.length];
		
		for(int x = 0; x < i.length; x++)
			out[x] = PrimeUtils.toInt(i[x]);
		
		return out;
	}
	
	/**
	 * Parses an {@link Double} value "i" to an double value and takes null-values in account too.
	 * @param i The value to parse.
	 * @return The parsed value.
	 */
	public static double toDouble(Double i) { return i == null ? 0.0d : i.doubleValue(); }
	
	/**
	 * Parses an {@link Double} array "i" to an double array and takes null-values in account too.
	 * @param i The array to parse.
	 * @return The parsed array.
	 */
	public static double[] toDouble(Double[] i)
	{
		double[] out = new double[i.length];
		
		for(int x = 0; x < i.length; x++)
			out[x] = PrimeUtils.toDouble(i[x]);
		
		return out;
	}
	
	/**
	 * Parses an {@link Long} value "i" to an long value and takes null-values in account too.
	 * @param i The value to parse.
	 * @return The parsed value.
	 */
	public static long toLong(Long i) { return i == null ? 0 : i.longValue(); }
	
	/**
	 * Parses an {@link Long} array "i" to an long array and takes null-values in account too.
	 * @param i The array to parse.
	 * @return The parsed array.
	 */
	public static long[] toLong(Long[] i)
	{
		long[] out = new long[i.length];
		
		for(int x = 0; x < i.length; x++)
			out[x] = PrimeUtils.toLong(i[x]);
		
		return out;
	}
	
	/**
	 * Parses an {@link Float} value "i" to an float value and takes null-values in account too.
	 * @param i The value to parse.
	 * @return The parsed value.
	 */
	public static float toFloat(Float i) { return i == null ? 0.0f : i.floatValue(); }
	
	/**
	 * Parses an {@link Float} array "i" to an float array and takes null-values in account too.
	 * @param i The array to parse.
	 * @return The parsed array.
	 */
	public static float[] toFloat(Float[] i)
	{
		float[] out = new float[i.length];
		
		for(int x = 0; x < i.length; x++)
			out[x] = PrimeUtils.toFloat(i[x]);
		
		return out;
	}
	
	/**
	 * Parses an {@link Short} value "i" to an short value and takes null-values in account too.
	 * @param i The value to parse.
	 * @return The parsed value.
	 */
	public static short toShort(Short i) { return i == null ? 0 : i.shortValue(); }
	
	/**
	 * Parses an {@link Short} array "i" to an short array and takes null-values in account too.
	 * @param i The array to parse.
	 * @return The parsed array.
	 */
	public static short[] toShort(Short[] i)
	{
		short[] out = new short[i.length];
		
		for(int x = 0; x < i.length; x++)
			out[x] = PrimeUtils.toShort(i[x]);
		
		return out;
	}
	
	/**
	 * Parses an {@link Boolean} value "i" to an boolean value and takes null-values in account too.
	 * @param i The value to parse.
	 * @return The parsed value.
	 */
	public static boolean toBoolean(Boolean i) { return i == null ? false : i.booleanValue(); }
	
	/**
	 * Parses an {@link Boolean} array "i" to an boolean array and takes null-values in account too.
	 * @param i The array to parse.
	 * @return The parsed array.
	 */
	public static boolean[] toBoolean(Boolean[] i)
	{
		boolean[] out = new boolean[i.length];
		
		for(int x = 0; x < i.length; x++)
			out[x] = PrimeUtils.toBoolean(i[x]);
		
		return out;
	}
	
}

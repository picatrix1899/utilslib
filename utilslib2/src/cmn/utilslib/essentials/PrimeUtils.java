package cmn.utilslib.essentials;



/**
 * 

 * @author picatrix1899
 *
 */
public class PrimeUtils
{
	
	public static int toInt(Integer i) { return i == null ? 0 : i.intValue(); }
	
	public static int[] toInt(Integer[] i)
	{
		
		if(Check.isNull(i)) { return null; }
		
		int[] out = new int[i.length];
		
		for(int x = 0; x < i.length; x++)
			out[x] = PrimeUtils.toInt(i[x]);
		
		return out;
	}
	
	public static double toDouble(Double i) { return i == null ? 0.0d : i.doubleValue(); }
	
	public static double[] toDouble(Double[] i)
	{
		double[] out = new double[i.length];
		
		for(int x = 0; x < i.length; x++)
			out[x] = PrimeUtils.toDouble(i[x]);
		
		return out;
	}
	
	public static long toLong(Long i) { return i == null ? 0 : i.longValue(); }
	
	public static long[] toLong(Long[] i)
	{
		long[] out = new long[i.length];
		
		for(int x = 0; x < i.length; x++)
			out[x] = PrimeUtils.toLong(i[x]);
		
		return out;
	}
	
	public static float toFloat(Float i) { return i == null ? 0.0f : i.floatValue(); }
	
	public static float[] toFloat(Float[] i)
	{
		float[] out = new float[i.length];
		
		for(int x = 0; x < i.length; x++)
			out[x] = PrimeUtils.toFloat(i[x]);
		
		return out;
	}
	
	public static short toShort(Short i) { return i == null ? 0 : i.shortValue(); }
	
	public static short[] toShort(Short[] i)
	{
		short[] out = new short[i.length];
		
		for(int x = 0; x < i.length; x++)
			out[x] = PrimeUtils.toShort(i[x]);
		
		return out;
	}
	
	public static boolean toBoolean(Boolean i) { return i == null ? false : i.booleanValue(); }
	
	public static boolean[] toBoolean(Boolean[] i)
	{
		boolean[] out = new boolean[i.length];
		
		for(int x = 0; x < i.length; x++)
			out[x] = PrimeUtils.toBoolean(i[x]);
		
		return out;
	}
	
}

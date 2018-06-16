package cmn.utilslib.math;

import cmn.utilslib.math.SigmaSum.SigmaSumAlgorythm;

/**
 * 

 * @author picatrix1899
 *
 */
public class Maths
{
	

	public static final double PI = 3.14159265359d;
	public static final double HALF_PI = 1.570796326795d;
	public static final double DEG_TO_RAD = 0.017453292519944444d;
	public static final double RAD_TO_DEG = 57.29577951307855d;
	public static final double INV_SQRT2 = 0.7071067811865475d; // 1 / sqrt(2); these are used for precalculated normalized vectors like vec3(1.0, 1.0, 0.0)
	public static final double INV_SQRT3 = 0.5773502691896258d; // 1 / sqrt(3); these are used for precalculated normalized vectors like vec3(1.0, 1.0, 1.0)
	
	/**
	 * Clamps the "in" value to a minimum value "min".
	 * @param in The value to clamp.
	 * @param min The minimum value.
	 * @return The clamped value.
	 */
	public static double clampMin(double in, double min)
	{
		return in <= min ? min : in;
	}
	
	/**
	 * Clamps the "in" value to a minimum value "min".
	 * @param in The value to clamp.
	 * @param min The minimum value.
	 * @return The clamped value.
	 */
	public static float clampMin(float in, float min)
	{
		return in <= min ? min : in;
	}
	
	/**
	 * Clamps the "in" value to a minimum value "min".
	 * @param in The value to clamp.
	 * @param min The minimum value.
	 * @return The clamped value.
	 */
	public static int clampMin(int in, int min)
	{
		return in <= min ? min : in;
	}
	
	/**
	 * Clamps the "in" value to a maximum value "max".
	 * @param in The value to clamp.
	 * @param max The maximum value.
	 * @return The clamped value.
	 */
	public static double clampMax(double in, double max)
	{
		return in >= max ? max : in;
	}
	
	/**
	 * Clamps the "in" value to a maximum value "max".
	 * @param in The value to clamp.
	 * @param max The maximum value.
	 * @return The clamped value.
	 */
	public static float clampMax(float in, float max)
	{
		return in >= max ? max : in;
	}
	
	/**
	 * Clamps the "in" value to a maximum value "max".
	 * @param in The value to clamp.
	 * @param max The maximum value.
	 * @return The clamped value.
	 */
	public static int clampMax(int in, int max)
	{
		return in >= max ? max : in;
	}
	
	/**
	 * Clamps the "in" value between "min" and max.
	 * @param in The value to clamp.
	 * @param min The minimum value.
	 * @param max The maximum value.
	 * @return The clamped value.
	 */
	public static double clamp(double in, double min, double max)
	{
		return clampMax(clampMin(in, min), max);
	}
	
	/**
	 * Clamps the "in" value between "min" and max.
	 * @param in The value to clamp.
	 * @param min The minimum value.
	 * @param max The maximum value.
	 * @return The clamped value.
	 */
	public static float clamp(float in, float min, float max)
	{
		return clampMax(clampMin(in, min), max);
	}
	
	/**
	 * Clamps the "in" value between "min" and max.
	 * @param in The value to clamp.
	 * @param min The minimum value.
	 * @param max The maximum value.
	 * @return The clamped value.
	 */
	public static int clamp(int in, int min, int max)
	{
		return clampMax(clampMin(in, min), max);
	}
	
	/**
	 * Special equals method for floating point numbers(FPN) with an epsilon offset. <br>
	 * It checks if "b - epsilon <= a <= b + epsilon" and then if "a - epsilon <= b <= a + epsilon" . <br>
	 * This should avoid FPN precision lost.
	 * @param a The first value
	 * @param b The second value
	 * @param epsilon The offset
	 * @return If a equals b
	 */
	public static boolean equalsFPN(float a, float b, float epsilon)
	{
		return (a >= (b - epsilon) && (epsilon + b) >= a) || (b >= (a - epsilon) && (epsilon + a) >= b);
	}
	
	/**
	 * Special equals method for double precision numbers(DPN) with an epsilon offset. <br>
	 * It checks if "b - epsilon <= a <= b + epsilon" and then if "a - epsilon <= b <= a + epsilon" . <br>
	 * This should avoid DPN precision lost.
	 * @param a The first value
	 * @param b The second value
	 * @param epsilon The offset
	 * @return If a equals b
	 */
	public static boolean equalsDPN(double a, double b, double epsilon)
	{
		return (a >= (b - epsilon) && (epsilon + b) >= a) || (b >= (a - epsilon) && (epsilon + a) >= b);
	}

	/**
	 * Lightweight Implementation of a Sigma Sum. The algorythm is an implementation
	 * of the Functional Interface SigmaSumAlgorythm that gets the current index per call.
	 * @param start : the start Index to begin with.
	 * @param end : the last Index to end with.
	 * @param algorythm : the algorythm the sigma sum uses to calculate its value.
	 * @return the result of the sigma sum.
	 */
	public static double sigmaSum(int start, int end, SigmaSumAlgorythm algorythm)
	{
		double out = 0;
		
		for(int i = start; i <= end; i++)
		{
			out += algorythm.step(i);
		}
		
		return out;
	}
}

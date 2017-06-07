package cmn.utilslib.math;

public class Func
{
	/**
	 * Simple linear interpolation function
	 * @param a min value
	 * @param b max value
	 * @param t position 0 <= t <= 1
	 * @return
	 */
	public static float lerpf(float a, float b, float t)
	{
		// a = origin
		// b = dest
		// b - a = vec1(ab) = total length
		// t = step (0 <= t <= 1)
		return a + (b - a) * t;
	}
	
	/**
	 * Simple linear interpolation function
	 * @param a min value
	 * @param b max value
	 * @param t position 0 <= t <= 1
	 * @return
	 */
	public static float slerpf(float a, float b, float angle, float t)
	{
		// a = origin
		// b = dest
		// b - a = vec1(ab) = total length
		// t = step (0 <= t <= 1)
		
		double sinAngle = Math.sin(Maths.DEG_TO_RAD * angle);
		
		double x_1 = (1 - t)	* sinAngle / sinAngle * a;
		double x_2 = t			* sinAngle / sinAngle * b;
		return (float) (x_1 + x_2);
	}
	
	/**
	 * Simple linear interpolation function
	 * @param a min value
	 * @param b max value
	 * @param t position 0 <= t <= 1
	 * @return
	 */
	public static double lerpd(double a, double b, double t)
	{
		// a = origin
		// b = dest
		// b - a = vec1(ab) = total length
		// t = step (0 <= t <= 1)
		return a + (b - a) * t;
	}
	
	public static float hermite(float a, float b, float am, float bm, float t)
	{
		return (2 * a - 2 * b + am + bm) * (t * t * t) + (-3 * a + 3 * b - 2 * am - bm) * (t * t) + am * t + a;
	}
	
	public static float linearBezier(float a, float b, float t)
	{
		return (1-t) * a  +  t*b;
	}
	
	public static float quadricBezier(float a, float b, float c, float t)
	{
		
		return (1-t) * linearBezier(a, b, t) + t * linearBezier(b, c, t);
	}
	
	public static float cubicBezier(float a, float b, float c, float d, float t)
	{
		return (1-t) * quadricBezier(a, b, c, t) + t * quadricBezier(b, c, d, t);
	}
	
	public static float bicubicBezier(float a, float b, float c, float d, float e, float t)
	{
		return (1-t) * cubicBezier(a, b, c, d, t) + t * cubicBezier(b, c, d, e, t);
	}
	
	
	public static float projectScale(float pos, float minPos, float minVal, float maxPos, float maxVal)
	{
		return (pos - minPos) * (maxVal - minVal) / (maxPos - minPos) + minVal;
	}
}

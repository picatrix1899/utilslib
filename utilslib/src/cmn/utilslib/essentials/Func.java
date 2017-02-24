package cmn.utilslib.essentials;


public class Func
{
	public static float lerpf(float a, float b, float t)
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
	
	
}

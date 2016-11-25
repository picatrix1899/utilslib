package cmn.picatrix1899.utilslib.essentials;

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
	
	public static double clampMin(double in, double min)
	{
		return in <= min ? min : in;
	}
	
	public static float clampMin(float in, float min)
	{
		return in <= min ? min : in;
	}
	
	public static int clampMin(int in, int min)
	{
		return in <= min ? min : in;
	}
	
	public static double clampMax(double in, double max)
	{
		return in >= max ? max : in;
	}
	
	public static float clampMax(float in, float max)
	{
		return in >= max ? max : in;
	}
	
	public static int clampMax(int in, int max)
	{
		return in >= max ? max : in;
	}
	
	public static double clamp(double in, double min, double max)
	{
		return clampMax(clampMin(in, min), max);
	}
	
	public static float clamp(float in, float min, float max)
	{
		return clampMax(clampMin(in, min), max);
	}
	
	public static int clamp(int in, int min, int max)
	{
		return clampMax(clampMin(in, min), max);
	}
	
	public static float img(float pos, float maxPos, float maxVal)
	{
		return pos / (maxPos / maxVal);
	}
	
	public static float rimg(float val, float maxPos, float maxVal)
	{
		return val * (maxPos / maxVal);
	}
}

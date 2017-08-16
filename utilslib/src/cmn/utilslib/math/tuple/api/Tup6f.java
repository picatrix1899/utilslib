package cmn.utilslib.math.tuple.api;

public interface Tup6f extends Tup6fBase
{
	
	Tup6f setZero();
	
	Tup6f set(Tup6fBase t);
	Tup6f set(Tup6dBase t);
	Tup6f set(float scalar);
	Tup6f set(double scalar);
	Tup6f set(float v0, float v1, float v2, float v3, float v4, float v5);
	Tup6f set(double v0, double v1, double v2, double v3, double v4, double v5);
	
	Tup6f set(int index, float value);
	Tup6f set(int index, double value);
	
}

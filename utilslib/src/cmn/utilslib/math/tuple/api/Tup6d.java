package cmn.utilslib.math.tuple.api;

public interface Tup6d extends Tup6dBase
{
	
	Tup6d setZero();
	
	Tup6d set(Tup6fBase t);
	Tup6d set(Tup6dBase t);
	Tup6d set(float scalar);
	Tup6d set(double scalar);
	Tup6d set(float v0, float v1, float v2, float v3, float v4, float v5);
	Tup6d set(double v0, double v1, double v2, double v3, double v4, double v5);
	
	Tup6d set(int index, float value);
	Tup6d set(int index, double value);
	
}

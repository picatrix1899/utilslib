package cmn.utilslib.math.tuple.api;

public interface Tup6f extends Tup6fBase
{
	
	Tup6f setZero();
	
	Tup6f set(Tup3fBase t);
	Tup6f set(Tup3dBase t);
	Tup6f set(float scalar);
	Tup6f set(double scalar);
	Tup6f set(float... values);
	Tup6f set(double... values);
	
	Tup6f set(int index, float value);
	Tup6f set(int index, double value);
	
}

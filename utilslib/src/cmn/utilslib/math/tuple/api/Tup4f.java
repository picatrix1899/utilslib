package cmn.utilslib.math.tuple.api;

public interface Tup4f extends Tup4fBase
{
	
	Tup4f setZero();
	
	Tup4f set(Tup4fBase t);
	Tup4f set(Tup4dBase t);
	Tup4f set(float scalar);
	Tup4f set(double scalar);
	Tup4f set(float... values);
	Tup4f set(double... values);
	
	Tup4f set(int index, float value);
	Tup4f set(int index, double value);
	
}

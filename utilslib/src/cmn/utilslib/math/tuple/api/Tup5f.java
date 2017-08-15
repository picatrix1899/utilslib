package cmn.utilslib.math.tuple.api;

public interface Tup5f extends Tup5fBase
{
	
	Tup5f setZero();
	
	Tup5f set(Tup5fBase t);
	Tup5f set(Tup5dBase t);
	Tup5f set(float scalar);
	Tup5f set(double scalar);
	Tup5f set(float... values);
	Tup5f set(double... values);
	
	Tup5f set(int index, float value);
	Tup5f set(int index, double value);
	
}

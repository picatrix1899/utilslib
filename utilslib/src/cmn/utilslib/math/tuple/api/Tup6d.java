package cmn.utilslib.math.tuple.api;

public interface Tup6d extends Tup6dBase
{
	
	Tup6d setZero();
	
	Tup6d set(Tup6fBase t);
	Tup6d set(Tup6dBase t);
	Tup6d set(float scalar);
	Tup6d set(double scalar);
	Tup6d set(float... values);
	Tup6d set(double... values);
	
	Tup6d set(int index, float value);
	Tup6d set(int index, double value);
	
}

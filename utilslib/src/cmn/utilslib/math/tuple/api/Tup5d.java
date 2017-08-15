package cmn.utilslib.math.tuple.api;

public interface Tup5d extends Tup5dBase
{
	
	Tup5d setZero();
	
	Tup5d set(Tup5fBase t);
	Tup5d set(Tup5dBase t);
	Tup5d set(float scalar);
	Tup5d set(double scalar);
	Tup5d set(float... values);
	Tup5d set(double... values);
	
	Tup5d set(int index, float value);
	Tup5d set(int index, double value);
	
}

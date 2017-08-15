package cmn.utilslib.math.tuple.api;

public interface Tup4d extends Tup4dBase
{
	
	Tup4d setZero();
	
	Tup4d set(Tup4fBase t);
	Tup4d set(Tup4dBase t);
	Tup4d set(float scalar);
	Tup4d set(double scalar);
	Tup4d set(float... values);
	Tup4d set(double... values);
	
	Tup4d set(int index, float value);
	Tup4d set(int index, double value);
	
}

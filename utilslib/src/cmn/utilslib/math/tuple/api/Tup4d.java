package cmn.utilslib.math.tuple.api;

public interface Tup4d extends Tup4dBase
{
	
	Tup4d setZero();
	
	Tup4d set(Tup4fBase t);
	Tup4d set(Tup4dBase t);
	Tup4d set(float scalar);
	Tup4d set(double scalar);
	Tup4d set(float v0, float v1, float v2, float v3);
	Tup4d set(double v0, double v1, double v2, double v3);
	
	Tup4d set(int index, float value);
	Tup4d set(int index, double value);
	
}

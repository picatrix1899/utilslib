package cmn.utilslib.math.tuple.api;

public interface Tup2d extends Tup2dBase
{
	
	Tup2d setZero();
	
	Tup2d set(Tup2fBase t);
	Tup2d set(Tup2dBase t);
	Tup2d set(float scalar);
	Tup2d set(double scalar);
	Tup2d set(float v0, float v1);
	Tup2d set(double v0, double v1);
	
	Tup2d set(int index, float value);
	Tup2d set(int index, double value);
	
}

package cmn.utilslib.math.tuple.api;

public interface Tup5d extends Tup5dBase
{
	
	Tup5d setZero();
	
	Tup5d set(Tup5fBase t);
	Tup5d set(Tup5dBase t);
	Tup5d set(float scalar);
	Tup5d set(double scalar);
	Tup5d set(float v0, float v1, float v2, float v3, float v4);
	Tup5d set(double v0, double v1, double v2, double v3, double v4);
	
	Tup5d set(int index, float value);
	Tup5d set(int index, double value);
	
}

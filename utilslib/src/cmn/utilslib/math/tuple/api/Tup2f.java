package cmn.utilslib.math.tuple.api;

public interface Tup2f extends Tup2fBase
{
	Tup2f setZero();
	
	Tup2f set(Tup2fBase t);
	Tup2f set(Tup2dBase t);
	Tup2f set(float scalar);
	Tup2f set(double scalar);
	Tup2f set(float v0, float v1);
	Tup2f set(double v0, double v1);
	
	Tup2f set(int index, float value);
	Tup2f set(int index, double value);
}

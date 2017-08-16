package cmn.utilslib.math.tuple.api;

public interface Tup3f extends Tup3fBase
{
	
	Tup3f setZero();
	
	Tup3f set(Tup3fBase t);
	Tup3f set(Tup3dBase t);
	Tup3f set(float scalar);
	Tup3f set(double scalar);
	Tup3f set(float v0, float v1, float v2);
	Tup3f set(double v0, double v1, double v2);
	
	Tup3f set(int index, float value);
	Tup3f set(int index, double value);
	
}

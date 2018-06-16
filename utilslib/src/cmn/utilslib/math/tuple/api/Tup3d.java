package cmn.utilslib.math.tuple.api;

public interface Tup3d extends Tup3dBase
{
	
	Tup3d setZero();
	
	Tup3d set(Tup3fBase t);
	Tup3d set(Tup3dBase t);
	Tup3d set(float scalar);
	Tup3d set(double scalar);
	Tup3d set(float v0, float v1, float v2);
	Tup3d set(double v0, double v1, double v2);
	
	Tup3d set(int index, float value);
	Tup3d set(int index, double value);
	
}

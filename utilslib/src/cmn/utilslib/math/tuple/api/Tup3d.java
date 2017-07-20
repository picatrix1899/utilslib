package cmn.utilslib.math.tuple.api;

public interface Tup3d extends Tup3dBase
{
	
	Tup3d setZero();
	
	Tup3d set(Tup3fBase t);
	Tup3d set(Tup3dBase t);
	Tup3d set(float scalar);
	Tup3d set(double scalar);
	Tup3d set(float... values);
	Tup3d set(double... values);
	
	Tup3d set(int index, float value);
	Tup3d set(int index, double value);
	
}

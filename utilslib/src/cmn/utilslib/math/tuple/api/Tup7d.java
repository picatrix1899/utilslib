package cmn.utilslib.math.tuple.api;

public interface Tup7d extends Tup7dBase
{
	
	Tup7d setZero();
	
	Tup7d set(Tup7fBase t);
	Tup7d set(Tup7dBase t);
	Tup7d set(float scalar);
	Tup7d set(double scalar);
	Tup7d set(float v0, float v1, float v2, float v3, float v4, float v5, float v6);
	Tup7d set(double v0, double v1, double v2, double v3, double v4, double v5, double v6);
	
	Tup7d set(int index, float value);
	Tup7d set(int index, double value);
	
}

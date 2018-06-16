package cmn.utilslib.math.tuple.api;

public interface Tup7f extends Tup7fBase
{
	
	Tup7f setZero();
	
	Tup7f set(Tup7fBase t);
	Tup7f set(Tup7dBase t);
	Tup7f set(float scalar);
	Tup7f set(double scalar);
	Tup7f set(float v0, float v1, float v2, float v3, float v4, float v5, float v6);
	Tup7f set(double v0, double v1, double v2, double v3, double v4, double v5, double v6);
	
	Tup7f set(int index, float value);
	Tup7f set(int index, double value);
	
}

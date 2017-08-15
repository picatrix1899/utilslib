package cmn.utilslib.math.tuple.api;

public interface Tup7f extends Tup7fBase
{
	
	Tup7f setZero();
	
	Tup7f set(Tup7fBase t);
	Tup7f set(Tup7dBase t);
	Tup7f set(float scalar);
	Tup7f set(double scalar);
	Tup7f set(float... values);
	Tup7f set(double... values);
	
	Tup7f set(int index, float value);
	Tup7f set(int index, double value);
	
}

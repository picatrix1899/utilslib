package cmn.utilslib.math.tuple.api;

public interface Tup7d extends Tup7dBase
{
	
	Tup7d setZero();
	
	Tup7d set(Tup7fBase t);
	Tup7d set(Tup7dBase t);
	Tup7d set(float scalar);
	Tup7d set(double scalar);
	Tup7d set(float... values);
	Tup7d set(double... values);
	
	Tup7d set(int index, float value);
	Tup7d set(int index, double value);
	
}

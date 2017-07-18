package cmn.utilslib.math.tuple.api;

public interface Tup2f extends Tup2fBase
{
	Tup2f setZero();
	
	Tup2f set(Tup2fBase t);
	Tup2f set(Tup2dBase t);
	Tup2f set(float scalar);
	Tup2f set(double scalar);
	Tup2f set(float a, float b);
	Tup2f set(double a, double b);
	
	Tup2f setA(float a);
	Tup2f setA(double a);
	Tup2f setB(float b);
	Tup2f setB(double b);

	Tup2f add(Tup2fBase t);
	Tup2f add(Tup2dBase t);
	Tup2f add(double scalar);
	Tup2f add(float a, float b);
	Tup2f add(double a, double b);

	Tup2f sub(Tup2fBase t);
	Tup2f sub(Tup2dBase t);
	Tup2f sub(double scalar);
	Tup2f sub(float a, float b);
	Tup2f sub(double a, double b);
	
	Tup2f mul(Tup2fBase t);
	Tup2f mul(Tup2dBase t);
	Tup2f mul(double scalar);
	Tup2f mul(float a, float b);
	Tup2f mul(double a, double b);
	
	Tup2f div(Tup2fBase t);
	Tup2f div(Tup2dBase t);
	Tup2f div(double scalar);
	Tup2f div(float a, float b);
	Tup2f div(double a, double b);
}

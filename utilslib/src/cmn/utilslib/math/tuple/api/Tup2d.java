package cmn.utilslib.math.tuple.api;

public interface Tup2d extends Tup2dBase
{
	Tup2d setZero();
	
	Tup2d set(Tup2fBase t);
	Tup2d set(Tup2dBase t);
	Tup2d set(float scalar);
	Tup2d set(double scalar);
	Tup2d set(float a, float b);
	Tup2d set(double a, double b);
	
	Tup2d setA(float a);
	Tup2d setA(double a);
	Tup2d setB(float b);
	Tup2d setB(double b);

	Tup2d add(Tup2fBase t);
	Tup2d add(Tup2dBase t);
	Tup2d add(double scalar);
	Tup2d add(float a, float b);
	Tup2d add(double a, double b);

	Tup2d sub(Tup2fBase t);
	Tup2d sub(Tup2dBase t);
	Tup2d sub(double scalar);
	Tup2d sub(float a, float b);
	Tup2d sub(double a, double b);
	
	Tup2d mul(Tup2fBase t);
	Tup2d mul(Tup2dBase t);
	Tup2d mul(double scalar);
	Tup2d mul(float a, float b);
	Tup2d mul(double a, double b);
	
	Tup2d div(Tup2fBase t);
	Tup2d div(Tup2dBase t);
	Tup2d div(double scalar);
	Tup2d div(float a, float b);
	Tup2d div(double a, double b);
}

package cmn.utilslib.math.tuple.api;

public interface Tup3f extends Tup3fBase
{
	Tup3f setZero();
	
	Tup3f set(Tup3fBase t);
	Tup3f set(Tup3dBase t);
	Tup3f set(float scalar);
	Tup3f set(double scalar);
	Tup3f set(float a, float b, float c);
	Tup3f set(double a, double b, double c);
	
	Tup3f setA(float a);
	Tup3f setA(double a);
	Tup3f setB(float b);
	Tup3f setB(double b);
	Tup3f setC(float c);
	Tup3f setC(double c);

	Tup3f add(Tup3fBase t);
	Tup3f add(Tup3dBase t);
	Tup3f add(double scalar);
	Tup3f add(float a, float b, float c);
	Tup3f add(double a, double b, double c);

	Tup3f sub(Tup3fBase t);
	Tup3f sub(Tup3dBase t);
	Tup3f sub(double scalar);
	Tup3f sub(float a, float b, float c);
	Tup3f sub(double a, double b, double c);
	
	Tup3f mul(Tup3fBase t);
	Tup3f mul(Tup3dBase t);
	Tup3f mul(double scalar);
	Tup3f mul(float a, float b, float c);
	Tup3f mul(double a, double b, double c);
	
	Tup3f div(Tup3fBase t);
	Tup3f div(Tup3dBase t);
	Tup3f div(double scalar);
	Tup3f div(float a, float b, float c);
	Tup3f div(double a, double b, double c);
}

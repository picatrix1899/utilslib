package cmn.utilslib.math.tuple.api;

public interface Tup3d extends Tup3dBase
{
	Tup3d setZero();
	
	Tup3d set(Tup3fBase t);
	Tup3d set(Tup3dBase t);
	Tup3d set(float scalar);
	Tup3d set(double scalar);
	Tup3d set(float a, float b, float c);
	Tup3d set(double a, double b, double c);
	
	Tup3d setA(float a);
	Tup3d setA(double a);
	Tup3d setB(float b);
	Tup3d setB(double b);
	Tup3d setC(float c);
	Tup3d setC(double c);

	Tup3d add(Tup3fBase t);
	Tup3d add(Tup3dBase t);
	Tup3d add(double scalar);
	Tup3d add(float a, float b, float c);
	Tup3d add(double a, double b, double c);

	Tup3d sub(Tup3fBase t);
	Tup3d sub(Tup3dBase t);
	Tup3d sub(double scalar);
	Tup3d sub(float a, float b, float c);
	Tup3d sub(double a, double b, double c);
	
	Tup3d mul(Tup3fBase t);
	Tup3d mul(Tup3dBase t);
	Tup3d mul(double scalar);
	Tup3d mul(float a, float b, float c);
	Tup3d mul(double a, double b, double c);
	
	Tup3d div(Tup3fBase t);
	Tup3d div(Tup3dBase t);
	Tup3d div(double scalar);
	Tup3d div(float a, float b, float c);
	Tup3d div(double a, double b, double c);
}

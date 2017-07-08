package cmn.utilslib.math.tuple.api;

public interface Tup3fBase
{
	float getA();
	float getB();
	float getC();
	
	Tup3f clone();
	
	Tup3f addN(Tup3fBase t);
	Tup3f addN(Tup3dBase t);
	Tup3f addN(float scalar);
	Tup3f addN(double scalar);
	Tup3f addN(float a, float b, float c);
	Tup3f addN(double a, double b, double c);
	
	Tup3f subN(Tup3fBase t);
	Tup3f subN(Tup3dBase t);
	Tup3f subN(float scalar);
	Tup3f subN(double scalar);
	Tup3f subN(float a, float b, float c);
	Tup3f subN(double a, double b, double c);
	
	Tup3f mulN(Tup3fBase t);
	Tup3f mulN(Tup3dBase t);
	Tup3f mulN(float scalar);
	Tup3f mulN(double scalar);
	Tup3f mulN(float a, float b, float c);
	Tup3f mulN(double a, double b, double c);
	
	Tup3f divN(Tup3fBase v);
	Tup3f divN(Tup3dBase v);
	Tup3f divN(float scalar);
	Tup3f divN(double scalar);
	Tup3f divN(float a, float b, float c);
	Tup3f divN(double a, double b, double c);
}

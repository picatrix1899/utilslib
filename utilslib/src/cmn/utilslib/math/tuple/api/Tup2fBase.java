package cmn.utilslib.math.tuple.api;

public interface Tup2fBase
{
	float getA();
	float getB();
	
	Tup2f clone();
	
	Tup2f addN(Tup2fBase t);
	Tup2f addN(Tup2dBase t);
	Tup2f addN(float scalar);
	Tup2f addN(double scalar);
	Tup2f addN(float a, float b);
	Tup2f addN(double a, double b);
	
	Tup2f subN(Tup2fBase t);
	Tup2f subN(Tup2dBase t);
	Tup2f subN(float scalar);
	Tup2f subN(double scalar);
	Tup2f subN(float a, float b);
	Tup2f subN(double a, double b);
	
	Tup2f mulN(Tup2fBase t);
	Tup2f mulN(Tup2dBase t);
	Tup2f mulN(float scalar);
	Tup2f mulN(double scalar);
	Tup2f mulN(float a, float b);
	Tup2f mulN(double a, double b);
	
	Tup2f divN(Tup2fBase v);
	Tup2f divN(Tup2dBase v);
	Tup2f divN(float scalar);
	Tup2f divN(double scalar);
	Tup2f divN(float a, float b);
	Tup2f divN(double a, double b);
}

package cmn.utilslib.math.tuple.api;

public interface Tup2dBase
{
	double getA();
	double getB();
	
	Tup2d clone();
	
	Tup2d addN(Tup2fBase t);
	Tup2d addN(Tup2dBase t);
	Tup2d addN(float scalar);
	Tup2d addN(double scalar);
	Tup2d addN(float a, float b);
	Tup2d addN(double a, double b);
	
	Tup2d subN(Tup2fBase t);
	Tup2d subN(Tup2dBase t);
	Tup2d subN(float scalar);
	Tup2d subN(double scalar);
	Tup2d subN(float a, float b);
	Tup2d subN(double a, double b);
	
	Tup2d mulN(Tup2fBase t);
	Tup2d mulN(Tup2dBase t);
	Tup2d mulN(float scalar);
	Tup2d mulN(double scalar);
	Tup2d mulN(float a, float b);
	Tup2d mulN(double a, double b);
	
	Tup2d divN(Tup2fBase v);
	Tup2d divN(Tup2dBase v);
	Tup2d divN(float scalar);
	Tup2d divN(double scalar);
	Tup2d divN(float a, float b);
	Tup2d divN(double a, double b);
}

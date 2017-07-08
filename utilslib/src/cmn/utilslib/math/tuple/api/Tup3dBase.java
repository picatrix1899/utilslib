package cmn.utilslib.math.tuple.api;

public interface Tup3dBase
{
	double getA();
	double getB();
	double getC();
	
	Tup3d clone();
	
	Tup3d addN(Tup3fBase t);
	Tup3d addN(Tup3dBase t);
	Tup3d addN(float scalar);
	Tup3d addN(double scalar);
	Tup3d addN(float a, float b, float c);
	Tup3d addN(double a, double b, double c);
	
	Tup3d subN(Tup3fBase t);
	Tup3d subN(Tup3dBase t);
	Tup3d subN(float scalar);
	Tup3d subN(double scalar);
	Tup3d subN(float a, float b, float c);
	Tup3d subN(double a, double b, double c);
	
	Tup3d mulN(Tup3fBase t);
	Tup3d mulN(Tup3dBase t);
	Tup3d mulN(float scalar);
	Tup3d mulN(double scalar);
	Tup3d mulN(float a, float b, float c);
	Tup3d mulN(double a, double b, double c);
	
	Tup3d divN(Tup3fBase v);
	Tup3d divN(Tup3dBase v);
	Tup3d divN(float scalar);
	Tup3d divN(double scalar);
	Tup3d divN(float a, float b, float c);
	Tup3d divN(double a, double b, double c);
}

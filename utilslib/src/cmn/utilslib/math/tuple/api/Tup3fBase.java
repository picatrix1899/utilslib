package cmn.utilslib.math.tuple.api;

public interface Tup3fBase
{
	float getX();
	float getY();
	float getZ();
	
	Tup3f clone();
	
	Tup3f addN(Tup3fBase v);;
	Tup3f addN(float scalar);
	Tup3f addN(double scalar);
	Tup3f addN(float x, float y, float z);
	Tup3f addN(double x, double y, double z);
	
	Tup3f subN(Tup3fBase v);
	Tup3f subN(float scalar);
	Tup3f subN(double scalar);
	Tup3f subN(float x, float y, float z);
	Tup3f subN(double x, double y, double z);
	
	Tup3f mulN(Tup3fBase v);
	Tup3f mulN(float scalar);
	Tup3f mulN(double scalar);
	Tup3f mulN(float x, float y, float z);
	Tup3f mulN(double x, double y, double z);
	
	Tup3f divN(Tup3fBase v);
	Tup3f divN(float scalar);
	Tup3f divN(double scalar);
	Tup3f divN(float x, float y, float z);
	Tup3f divN(double x, double y, double z);
}

package cmn.utilslib.math.vector.api;


public interface Vec4d extends Vec4dBase
{
	
	Vec4d setZero();
	
	Vec4d set(Vec4dBase v);
	
	Vec4d set(float scalar);
	Vec4d set(double scalar);
	Vec4d set(float x, float y, float z, float a);
	Vec4d set(double x, double y, double z, double a);
	
	Vec4d setX(float x);
	Vec4d setX(double x); 
	Vec4d setY(float y);
	Vec4d setY(double y); 
	Vec4d setZ(float z);
	Vec4d setZ(double z);
	Vec4d setA(float a);
	Vec4d setA(double a);

	Vec4d add(Vec4dBase v);
	Vec4d add(double scalar);
	Vec4d add(float x, float y, float z, float a);
	Vec4d add(double x, double y, double z, double a);

	Vec4d sub(Vec4dBase v);
	Vec4d sub(double scalar);
	Vec4d sub(float x, float y, float z, float a);
	Vec4d sub(double x, double y, double z, double a);
	
	Vec4d mul(Vec4dBase v);
	Vec4d mul(double scalar);
	Vec4d mul(float x, float y, float z, float a);
	Vec4d mul(double x, double y, double z, double a);
	
	Vec4d div(Vec4dBase v);
	Vec4d div(double scalar);
	Vec4d div(float x, float y, float z, float a);
	Vec4d div(double x, double y, double z, double a);

	
	Vec4d normalize();

	Vec4d invert();
	
	Vec4d reflect(Vec4dBase normal);
	
	Vec4d lerp(Vec4dBase v, double f);
	
	Vec4d slerp(Vec4dBase v, double f);



}

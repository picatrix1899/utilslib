package cmn.utilslib.math.vector.api;

public interface Vec4f extends Vec4fBase
{
	
	Vec4f setX(float x);
	Vec4f setX(double x); 
	Vec4f setY(float y);
	Vec4f setY(double y); 
	Vec4f setZ(float z);
	Vec4f setZ(double z);
	Vec4f setA(float a);
	Vec4f setA(double a);

	Vec4f setZero();
	
	Vec4f set(Vec4fBase v);
	
	Vec4f set(float scalar);
	Vec4f set(double scalar);
	Vec4f set(float x, float y, float z, float a);
	Vec4f set(double x, double y, double z, double a);

	Vec4f add(Vec4fBase v);
	Vec4f add(double scalar);
	Vec4f add(float x, float y, float z, float a);
	Vec4f add(double x, double y, double z, double a);

	Vec4f sub(Vec4fBase v);
	Vec4f sub(double scalar);
	Vec4f sub(float x, float y, float z, float a);
	Vec4f sub(double x, double y, double z, double a);
	
	Vec4f mul(Vec4fBase v);
	Vec4f mul(double scalar);
	Vec4f mul(float x, float y, float z, float a);
	Vec4f mul(double x, double y, double z, double a);
	
	Vec4f div(Vec4fBase v);
	Vec4f div(double scalar);
	Vec4f div(float x, float y, float z, float a);
	Vec4f div(double x, double y, double z, double a);

	
	Vec4f normalize();

	Vec4f invert();
	
	Vec4f reflect(Vec4fBase normal);
	
	Vec4f lerp(Vec4fBase v, double f);
	
	Vec4f slerp(Vec4fBase v, double f);
	
	
}

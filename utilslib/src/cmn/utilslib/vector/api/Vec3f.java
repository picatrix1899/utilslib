package cmn.utilslib.vector.api;

public interface Vec3f extends Vec3fBase
{
	
	Vec3f setX(float x);
	Vec3f setX(double x); 
	Vec3f setY(float y);
	Vec3f setY(double y); 
	Vec3f setZ(float z);
	Vec3f setZ(double z);

	Vec3f normalize();
	
	Vec3f invert();
	
	Vec3f reflect(Vec3fBase normal);
	
	Vec3f lerp(Vec3fBase v, float f);
	
	Vec3f slerp(Vec3fBase v, double f);
	

	Vec3f setZero();
	
	Vec3f set(Vec3fBase v);

	Vec3f set(float scalar);
	Vec3f set(double scalar);
	Vec3f set(float x, float y, float z);
	Vec3f set(double x, double y, double z);

	Vec3f add(Vec3fBase v);
	Vec3f add(double scalar);
	Vec3f add(float x, float y, float z);
	Vec3f add(double x, double y, double z);

	Vec3f sub(Vec3fBase v);
	Vec3f sub(double scalar);
	Vec3f sub(float x, float y, float z);
	Vec3f sub(double x, double y, double z);
	
	Vec3f mul(Vec3fBase v);
	Vec3f mul(double scalar);
	Vec3f mul(float x, float y, float z);
	Vec3f mul(double x, double y, double z);
	
	Vec3f div(Vec3fBase v);
	Vec3f div(double scalar);
	Vec3f div(float x, float y, float z);
	Vec3f div(double x, double y, double z);
}

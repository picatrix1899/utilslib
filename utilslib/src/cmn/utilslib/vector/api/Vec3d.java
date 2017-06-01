package cmn.utilslib.vector.api;

public interface Vec3d extends Vec3dBase
{
	
	Vec3d setX(float x);
	Vec3d setX(double x); 
	Vec3d setY(float y);
	Vec3d setY(double y); 
	Vec3d setZ(float z);
	Vec3d setZ(double z);

	Vec3d normalize();
	
	Vec3d invert();
	
	Vec3d reflect(Vec3dBase normal);
	
	Vec3d lerp(Vec3dBase v, float f);
	
	Vec3d slerp(Vec3dBase v, double f);
	

	Vec3d setZero();
	
	Vec3d set(Vec3dBase v);
	
	Vec3d set(float scalar);
	Vec3d set(double scalar);
	Vec3d set(float x, float y, float z);
	Vec3d set(double x, double y, double z);

	Vec3d add(Vec3dBase v);
	Vec3d add(double scalar);
	Vec3d add(float x, float y, float z);
	Vec3d add(double x, double y, double z);

	Vec3d sub(Vec3dBase v);
	Vec3d sub(double scalar);
	Vec3d sub(float x, float y, float z);
	Vec3d sub(double x, double y, double z);
	
	Vec3d mul(Vec3dBase v);
	Vec3d mul(double scalar);
	Vec3d mul(float x, float y, float z);
	Vec3d mul(double x, double y, double z);
	
	Vec3d div(Vec3dBase v);
	Vec3d div(double scalar);
	Vec3d div(float x, float y, float z);
	Vec3d div(double x, double y, double z);
}

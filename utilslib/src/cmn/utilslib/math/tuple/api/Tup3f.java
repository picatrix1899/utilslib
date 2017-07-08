package cmn.utilslib.math.tuple.api;

import cmn.utilslib.math.vector.api.Vec3dBase;

public interface Tup3f extends Tup3fBase
{
	Tup3f setZero();
	
	Tup3f set(Tup3fBase t);
	Tup3f set(float scalar);
	Tup3f set(double scalar);
	Tup3f set(float x, float y, float z);
	Tup3f set(double x, double y, double z);
	
	Tup3f setX(float x);
	Tup3f setX(double x);
	Tup3f setY(float y);
	Tup3f setY(double y);
	Tup3f setZ(float z);
	Tup3f setZ(double z);

	Tup3f add(Tup3fBase v);
	Tup3f add(Vec3dBase v);
	Tup3f add(double scalar);
	Tup3f add(float x, float y, float z);
	Tup3f add(double x, double y, double z);

	Tup3f sub(Tup3fBase v);
	Tup3f sub(Vec3dBase v);
	Tup3f sub(double scalar);
	Tup3f sub(float x, float y, float z);
	Tup3f sub(double x, double y, double z);
	
	Tup3f mul(Tup3fBase v);
	Tup3f mul(Vec3dBase v);
	Tup3f mul(double scalar);
	Tup3f mul(float x, float y, float z);
	Tup3f mul(double x, double y, double z);
	
	Tup3f div(Tup3fBase v);
	Tup3f div(Vec3dBase v);
	Tup3f div(double scalar);
	Tup3f div(float x, float y, float z);
	Tup3f div(double x, double y, double z);
}

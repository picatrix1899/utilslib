package cmn.utilslib.vector.api;

import cmn.utilslib.essentials.Check;
import cmn.utilslib.vector.Vector3d;

public interface Vec3d extends Vec3dBase
{
	
	Vec3d setX(float x);
	Vec3d setX(double x); 
	Vec3d setY(float y);
	Vec3d setY(double y); 
	Vec3d setZ(float z);
	Vec3d setZ(double z);

	default Vec3d normalize() { return Check.notNull(this) ? div(length()) : this; }
	
	default Vec3d invert() { return mul(-1.0f); }
	
	default Vec3d reflect(Vec3dBase normal)
	{
		double angle = dot(normal) * 2;
		
		setX(getX() - (angle) * normal.getX());
		setY(getY() - (angle) * normal.getY());
		setZ(getZ() - (angle) * normal.getZ());
		
		return this;
	}
	
	default Vec3d lerp(Vec3dBase v, float f)
	{
		setX(getX() + (v.getX() - getX()) * f);
		setY(getY() + (v.getY() - getY()) * f);
		setZ(getZ() + (v.getZ() - getZ()) * f);
		
		return this;
	}
	
	default Vec3d slerp(Vec3dBase v, double f)
	{
		double angle = angleRad(v);
		
		double sinAngle = Math.sin(angle);

		double x_1 = (1 - f)	* sinAngle / sinAngle * getX();
		double x_2 = f			* sinAngle / sinAngle * v.getX();
		double x = x_1 + x_2;
		
		double y_1 = (1 - f)	* sinAngle / sinAngle * getY();
		double y_2 = f			* sinAngle / sinAngle * v.getY();
		double y = y_1 + y_2;
		
		double z_1 = (1 - f)	* sinAngle / sinAngle * getZ();
		double z_2 = f			* sinAngle / sinAngle * v.getZ();
		double z = z_1 + z_2;
		
		return new Vector3d(x, y, z);
	}
	

	default Vec3d setZero() { return set(0.0f); }
	
	default Vec3d set(Vec3dBase v) { return set(v.getX(), v.getY(), v.getZ()); }
	
	default Vec3d set(float scalar) { return set(scalar, scalar, scalar); }
	default Vec3d set(double scalar) { return set(scalar, scalar, scalar); }
	default Vec3d set(float x, float y, float z) { return setX(x).setY(y).setZ(z); }
	default Vec3d set(double x, double y, double z) { return setX(x).setY(y).setZ(z); }

	default Vec3d add(Vec3dBase v) { return add(v.getX(), v.getY(), v.getZ()); }
	default Vec3d add(double scalar) { return add(scalar, scalar, scalar); }
	default Vec3d add(float x, float y, float z) { return set(getX() + x, getY() + y, getZ() + z); }
	default Vec3d add(double x, double y, double z) { return set(getX() + x, getY() + y, getZ() + z); }

	default Vec3d sub(Vec3dBase v) { return sub(v.getX(), v.getY(), v.getZ()); }
	default Vec3d sub(double scalar) { return sub(scalar, scalar, scalar); }
	default Vec3d sub(float x, float y, float z) { return set(getX() - x, getY() - y, getZ() - z); }
	default Vec3d sub(double x, double y, double z) { return set(getX() - x, getY() - y, getZ() - z); }
	
	default Vec3d mul(Vec3dBase v) { return mul(v.getX(), v.getY(), v.getZ()); }
	default Vec3d mul(double scalar) { return mul(scalar, scalar, scalar); }
	default Vec3d mul(float x, float y, float z) { return set(getX() * x, getY() * y, getZ() * z); }
	default Vec3d mul(double x, double y, double z) { return set(getX() * x, getY() * y, getZ() * z); }
	
	default Vec3d div(Vec3dBase v) { return div(v.getX(), v.getY(), v.getZ()); }
	default Vec3d div(double scalar) { return div(scalar, scalar, scalar); }
	default Vec3d div(float x, float y, float z) { return set(getX() / x, getY() / y, getZ() / z); }
	default Vec3d div(double x, double y, double z) { return set(getX() / x, getY() / y, getZ() / z); }
}

package cmn.utilslib.vector.api;

import cmn.utilslib.essentials.Check;
import cmn.utilslib.vector.Vector4f;

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
	
	default Vec4f floor() { return set(Math.floor(getX()), Math.floor(getY()), Math.floor(getZ()), Math.floor(getA())); }
	default Vec4f ceil() { return set(Math.ceil(getX()), Math.ceil(getY()), Math.ceil(getZ()), Math.ceil(getA())); }
	default Vec4f round() { return set(Math.round(getX()), Math.round(getY()), Math.round(getZ()), Math.round(getA())); }
	
	default Vec4f normalize() { return Check.notNull(this) ? div(length()) : this; }
	
	default Vec4f invert() { return mul(-1.0f); }
	
	default Vec4f reflect(Vec4fBase normal)
	{
		double angle = dot(normal) * 2;
		
		setX(getX() - (angle) * normal.getX());
		setY(getY() - (angle) * normal.getY());
		setZ(getZ() - (angle) * normal.getZ());
		setA(getA() - (angle) * normal.getA());
		
		return this;
	}
	
	default Vec4f lerp(Vec4fBase v, float f)
	{
		setX(getX() + (v.getX() - getX()) * f);
		setY(getY() + (v.getY() - getY()) * f);
		setZ(getZ() + (v.getZ() - getZ()) * f);
		setA(getA() + (v.getA() - getA()) * f);
		
		return this;
	}
	
	default Vec4f slerp(Vec4fBase v, double f)
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
		
		double a_1 = (1 - f)	* sinAngle / sinAngle * getA();
		double a_2 = f			* sinAngle / sinAngle * v.getA();
		double a = a_1 + a_2;
		
		return new Vector4f((float)x, (float)y, (float)z, (float)a);
	}
	
	default Vec4f abs(boolean x, boolean y, boolean z, boolean a) { return set(x ? Math.abs(getX()) : getX(), y ? Math.abs(getY()) : getY(), z ? Math.abs(getZ()) : getZ(), a ? Math.abs(getA()) : getA() ); }
	
	default Vec4f setZero() { return set(0.0f); }
	
	default Vec4f set(Vec4fBase v) { return set(v.getX(), v.getY(), v.getZ(), v.getA()); }
	
	default Vec4f set(float scalar) { return set(scalar, scalar, scalar, scalar); }
	default Vec4f set(double scalar) { return set(scalar, scalar, scalar, scalar); }
	default Vec4f set(float x, float y, float z, float a) { return setX(x).setY(y).setZ(z).setA(a); }
	default Vec4f set(double x, double y, double z, double a) { return setX(x).setY(y).setZ(z).setA(a); }

	default Vec4f add(Vec4fBase v) { return add(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vec4f add(float scalar) { return add(scalar, scalar, scalar, scalar); }
	default Vec4f add(float x, float y, float z, float a) { return set(getX() + x, getY() + y, getZ() + z, getA() + a); }
	default Vec4f add(double x, double y, double z, double a) { return set(getX() + x, getY() + y, getZ() + z, getA() + a); }

	default Vec4f sub(Vec4fBase v) { return sub(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vec4f sub(float scalar) { return sub(scalar, scalar, scalar, scalar); }
	default Vec4f sub(float x, float y, float z, float a) { return set(getX() - x, getY() - y, getZ() - z, getA() - a); }
	default Vec4f sub(double x, double y, double z, double a) { return set(getX() - x, getY() - y, getZ() - z, getA() - a); }
	
	default Vec4f mul(Vec4fBase v) { return mul(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vec4f mul(float scalar) { return mul(scalar, scalar, scalar, scalar); }
	default Vec4f mul(float x, float y, float z, float a) { return set(getX() * x, getY() * y, getZ() * z, getA() * a); }
	default Vec4f mul(double x, double y, double z, double a) { return set(getX() * x, getY() * y, getZ() * z, getA() * a); }
	
	default Vec4f div(Vec4fBase v) { return div(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vec4f div(float scalar) { return div(scalar, scalar, scalar, scalar); }
	default Vec4f div(float x, float y, float z, float a) { return set(getX() / x, getY() / y, getZ() / z, getA() / a); }
	default Vec4f div(double x, double y, double z, double a) { return set(getX() / x, getY() / y, getZ() / z, getA() / a); }
}

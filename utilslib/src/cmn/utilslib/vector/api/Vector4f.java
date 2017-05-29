package cmn.utilslib.vector.api;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import cmn.utilslib.essentials.Check;
import cmn.utilslib.interfaces.Streamable;
import cmn.utilslib.vector.Vec4f;

public interface Vector4f extends Vector4fBase, Streamable.Writeable
{
	
	Vector4f setX(float x);
	Vector4f setX(double x); 
	Vector4f setY(float y);
	Vector4f setY(double y); 
	Vector4f setZ(float z);
	Vector4f setZ(double z);
	Vector4f setA(float a);
	Vector4f setA(double a);
	
	default Vector4f floor() { return set(Math.floor(getX()), Math.floor(getY()), Math.floor(getZ()), Math.floor(getA())); }
	default Vector4f ceil() { return set(Math.ceil(getX()), Math.ceil(getY()), Math.ceil(getZ()), Math.ceil(getA())); }
	default Vector4f round() { return set(Math.round(getX()), Math.round(getY()), Math.round(getZ()), Math.round(getA())); }
	
	default Vector4f normalize() { return Check.notNull(this) ? div(length()) : this; }
	
	default Vector4f invert() { return mul(-1.0f); }
	
	default Vector4f reflect(Vector4fBase normal)
	{
		double angle = dot(normal) * 2;
		
		setX(getX() - (angle) * normal.getX());
		setY(getY() - (angle) * normal.getY());
		setZ(getZ() - (angle) * normal.getZ());
		setA(getA() - (angle) * normal.getA());
		
		return this;
	}
	
	default Vector4f lerp(Vector4fBase v, float f)
	{
		setX(getX() + (v.getX() - getX()) * f);
		setY(getY() + (v.getY() - getY()) * f);
		setZ(getZ() + (v.getZ() - getZ()) * f);
		setA(getA() + (v.getA() - getA()) * f);
		
		return this;
	}
	
	default Vector4f slerp(Vector4fBase v, double f)
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
		
		return new Vec4f((float)x, (float)y, (float)z, (float)a);
	}
	
	default Vector4f abs(boolean x, boolean y, boolean z, boolean a) { return set(x ? Math.abs(getX()) : getX(), y ? Math.abs(getY()) : getY(), z ? Math.abs(getZ()) : getZ(), a ? Math.abs(getA()) : getA() ); }
	
	default Vector4f setZero() { return set(0.0f); }
	
	default Vector4f set(Vector4fBase v) { return set(v.getX(), v.getY(), v.getZ(), v.getA()); }
	
	default Vector4f set(float scalar) { return set(scalar, scalar, scalar, scalar); }
	default Vector4f set(double scalar) { return set(scalar, scalar, scalar, scalar); }
	default Vector4f set(float x, float y, float z, float a) { return setX(x).setY(y).setZ(z).setA(a); }
	default Vector4f set(double x, double y, double z, double a) { return setX(x).setY(y).setZ(z).setA(a); }

	default Vector4f add(Vector4fBase v) { return add(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vector4f add(float scalar) { return add(scalar, scalar, scalar, scalar); }
	default Vector4f add(float x, float y, float z, float a) { return set(getX() + x, getY() + y, getZ() + z, getA() + a); }
	default Vector4f add(double x, double y, double z, double a) { return set(getX() + x, getY() + y, getZ() + z, getA() + a); }

	default Vector4f sub(Vector4fBase v) { return add(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vector4f sub(float scalar) { return add(scalar, scalar, scalar, scalar); }
	default Vector4f sub(float x, float y, float z, float a) { return set(getX() - x, getY() - y, getZ() - z, getA() - a); }
	default Vector4f sub(double x, double y, double z, double a) { return set(getX() - x, getY() - y, getZ() - z, getA() - a); }
	
	default Vector4f mul(Vector4fBase v) { return add(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vector4f mul(float scalar) { return add(scalar, scalar, scalar, scalar); }
	default Vector4f mul(float x, float y, float z, float a) { return set(getX() * x, getY() * y, getZ() * z, getA() * a); }
	default Vector4f mul(double x, double y, double z, double a) { return set(getX() * x, getY() * y, getZ() * z, getA() * a); }
	
	default Vector4f div(Vector4fBase v) { return add(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vector4f div(float scalar) { return add(scalar, scalar, scalar, scalar); }
	default Vector4f div(float x, float y, float z, float a) { return set(getX() / x, getY() / y, getZ() / z, getA() / a); }
	default Vector4f div(double x, double y, double z, double a) { return set(getX() / x, getY() / y, getZ() / z, getA() / a); }
	
	/** {@inheritDoc} */ @Override
	default void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		setX(dis.readFloat());
		setY(dis.readFloat());
		setZ(dis.readFloat());
		setA(dis.readFloat());
	}
	
}

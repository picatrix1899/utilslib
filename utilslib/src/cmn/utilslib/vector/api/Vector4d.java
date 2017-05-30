package cmn.utilslib.vector.api;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import cmn.utilslib.essentials.Check;
import cmn.utilslib.interfaces.Streamable;
import cmn.utilslib.vector.Vec4d;

public interface Vector4d extends Vector4dBase, Streamable.Writeable
{
	Vector4d setX(float x);
	Vector4d setX(double x); 
	Vector4d setY(float y);
	Vector4d setY(double y); 
	Vector4d setZ(float z);
	Vector4d setZ(double z);
	Vector4d setA(float a);
	Vector4d setA(double a);
	
	default Vector4d floor() { return set(Math.floor(getX()), Math.floor(getY()), Math.floor(getZ()), Math.floor(getA())); }
	default Vector4d ceil() { return set(Math.ceil(getX()), Math.ceil(getY()), Math.ceil(getZ()), Math.ceil(getA())); }
	default Vector4d round() { return set(Math.round(getX()), Math.round(getY()), Math.round(getZ()), Math.round(getA())); }
	
	default Vector4d normalize() { return Check.notNull(this) ? div(length()) : this; }

	default Vector4d invert() { return mul(-1.0f); }
	
	default Vector4d reflect(Vector4dBase normal)
	{
		double angle = dot(normal) * 2;
		
		setX(getX() - (angle) * normal.getX());
		setY(getY() - (angle) * normal.getY());
		setZ(getZ() - (angle) * normal.getZ());
		setA(getA() - (angle) * normal.getA());
		
		return this;
	}
	
	default Vector4d lerp(Vector4dBase v, double f)
	{
		setX(getX() + (v.getX() - getX()) * f);
		setY(getY() + (v.getY() - getY()) * f);
		setZ(getZ() + (v.getZ() - getZ()) * f);
		setA(getA() + (v.getA() - getA()) * f);
		
		return this;
	}
	
	default Vector4d slerp(Vector4dBase v, double f)
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
		
		return new Vec4d(x, y, z, a);
	}
	
	default Vector4d abs(boolean x, boolean y, boolean z, boolean a) { return set(x ? Math.abs(getX()) : getX(), y ? Math.abs(getY()) : getY(), z ? Math.abs(getZ()) : getZ(), a ? Math.abs(getA()) : getA() ); }
	
	default Vector4d setZero() { return set(0.0f); }
	
	default Vector4d set(Vector4dBase v) { return set(v.getX(), v.getY(), v.getZ(), v.getA()); }
	
	default Vector4d set(float scalar) { return set(scalar, scalar, scalar, scalar); }
	default Vector4d set(double scalar) { return set(scalar, scalar, scalar, scalar); }
	default Vector4d set(float x, float y, float z, float a) { return setX(x).setY(y).setZ(z).setA(a); }
	default Vector4d set(double x, double y, double z, double a) { return setX(x).setY(y).setZ(z).setA(a); }

	default Vector4d add(Vector4dBase v) { return add(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vector4d add(double scalar) { return add(scalar, scalar, scalar, scalar); }
	default Vector4d add(float x, float y, float z, float a) { return set(getX() + x, getY() + y, getZ() + z, getA() + a); }
	default Vector4d add(double x, double y, double z, double a) { return set(getX() + x, getY() + y, getZ() + z, getA() + a); }

	default Vector4d sub(Vector4dBase v) { return add(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vector4d sub(double scalar) { return add(scalar, scalar, scalar, scalar); }
	default Vector4d sub(float x, float y, float z, float a) { return set(getX() - x, getY() - y, getZ() - z, getA() - a); }
	default Vector4d sub(double x, double y, double z, double a) { return set(getX() - x, getY() - y, getZ() - z, getA() - a); }
	
	default Vector4d mul(Vector4dBase v) { return add(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vector4d mul(double scalar) { return add(scalar, scalar, scalar, scalar); }
	default Vector4d mul(float x, float y, float z, float a) { return set(getX() * x, getY() * y, getZ() * z, getA() * a); }
	default Vector4d mul(double x, double y, double z, double a) { return set(getX() * x, getY() * y, getZ() * z, getA() * a); }
	
	default Vector4d div(Vector4dBase v) { return add(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vector4d div(double scalar) { return add(scalar, scalar, scalar, scalar); }
	default Vector4d div(float x, float y, float z, float a) { return set(getX() / x, getY() / y, getZ() / z, getA() / a); }
	default Vector4d div(double x, double y, double z, double a) { return set(getX() / x, getY() / y, getZ() / z, getA() / a); }
	
	/** {@inheritDoc} */ @Override
	default void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		setX(dis.readDouble());
		setY(dis.readDouble());
		setZ(dis.readDouble());
		setA(dis.readDouble());
	}
}

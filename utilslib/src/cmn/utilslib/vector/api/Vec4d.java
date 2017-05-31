package cmn.utilslib.vector.api;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import cmn.utilslib.essentials.Check;
import cmn.utilslib.interfaces.Streamable;
import cmn.utilslib.vector.Vector4d;

public interface Vec4d extends Vec4dBase, Streamable.Writeable
{
	Vec4d setX(float x);
	Vec4d setX(double x); 
	Vec4d setY(float y);
	Vec4d setY(double y); 
	Vec4d setZ(float z);
	Vec4d setZ(double z);
	Vec4d setA(float a);
	Vec4d setA(double a);
	
	default Vec4d floor() { return set(Math.floor(getX()), Math.floor(getY()), Math.floor(getZ()), Math.floor(getA())); }
	default Vec4d ceil() { return set(Math.ceil(getX()), Math.ceil(getY()), Math.ceil(getZ()), Math.ceil(getA())); }
	default Vec4d round() { return set(Math.round(getX()), Math.round(getY()), Math.round(getZ()), Math.round(getA())); }
	
	default Vec4d normalize() { return Check.notNull(this) ? div(length()) : this; }

	default Vec4d invert() { return mul(-1.0f); }
	
	default Vec4d reflect(Vec4dBase normal)
	{
		double angle = dot(normal) * 2;
		
		setX(getX() - (angle) * normal.getX());
		setY(getY() - (angle) * normal.getY());
		setZ(getZ() - (angle) * normal.getZ());
		setA(getA() - (angle) * normal.getA());
		
		return this;
	}
	
	default Vec4d lerp(Vec4dBase v, double f)
	{
		setX(getX() + (v.getX() - getX()) * f);
		setY(getY() + (v.getY() - getY()) * f);
		setZ(getZ() + (v.getZ() - getZ()) * f);
		setA(getA() + (v.getA() - getA()) * f);
		
		return this;
	}
	
	default Vec4d slerp(Vec4dBase v, double f)
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
		
		return new Vector4d(x, y, z, a);
	}
	
	default Vec4d abs(boolean x, boolean y, boolean z, boolean a) { return set(x ? Math.abs(getX()) : getX(), y ? Math.abs(getY()) : getY(), z ? Math.abs(getZ()) : getZ(), a ? Math.abs(getA()) : getA() ); }
	
	default Vec4d setZero() { return set(0.0f); }
	
	default Vec4d set(Vec4dBase v) { return set(v.getX(), v.getY(), v.getZ(), v.getA()); }
	
	default Vec4d set(float scalar) { return set(scalar, scalar, scalar, scalar); }
	default Vec4d set(double scalar) { return set(scalar, scalar, scalar, scalar); }
	default Vec4d set(float x, float y, float z, float a) { return setX(x).setY(y).setZ(z).setA(a); }
	default Vec4d set(double x, double y, double z, double a) { return setX(x).setY(y).setZ(z).setA(a); }

	default Vec4d add(Vec4dBase v) { return add(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vec4d add(double scalar) { return add(scalar, scalar, scalar, scalar); }
	default Vec4d add(float x, float y, float z, float a) { return set(getX() + x, getY() + y, getZ() + z, getA() + a); }
	default Vec4d add(double x, double y, double z, double a) { return set(getX() + x, getY() + y, getZ() + z, getA() + a); }

	default Vec4d sub(Vec4dBase v) { return sub(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vec4d sub(double scalar) { return sub(scalar, scalar, scalar, scalar); }
	default Vec4d sub(float x, float y, float z, float a) { return set(getX() - x, getY() - y, getZ() - z, getA() - a); }
	default Vec4d sub(double x, double y, double z, double a) { return set(getX() - x, getY() - y, getZ() - z, getA() - a); }
	
	default Vec4d mul(Vec4dBase v) { return mul(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vec4d mul(double scalar) { return mul(scalar, scalar, scalar, scalar); }
	default Vec4d mul(float x, float y, float z, float a) { return set(getX() * x, getY() * y, getZ() * z, getA() * a); }
	default Vec4d mul(double x, double y, double z, double a) { return set(getX() * x, getY() * y, getZ() * z, getA() * a); }
	
	default Vec4d div(Vec4dBase v) { return div(v.getX(), v.getY(), v.getZ(), v.getA()); }
	default Vec4d div(double scalar) { return div(scalar, scalar, scalar, scalar); }
	default Vec4d div(float x, float y, float z, float a) { return set(getX() / x, getY() / y, getZ() / z, getA() / a); }
	default Vec4d div(double x, double y, double z, double a) { return set(getX() / x, getY() / y, getZ() / z, getA() / a); }
	
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

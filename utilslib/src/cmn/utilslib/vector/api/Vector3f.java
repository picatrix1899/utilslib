package cmn.utilslib.vector.api;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import cmn.utilslib.essentials.Check;
import cmn.utilslib.interfaces.Streamable;
import cmn.utilslib.vector.Vec3f;

public interface Vector3f extends Vector3fBase, Streamable.Writeable
{
	
	Vector3f setX(float x);
	Vector3f setX(double x); 
	Vector3f setY(float y);
	Vector3f setY(double y); 
	Vector3f setZ(float z);
	Vector3f setZ(double z);
	
	default Vector3f floor() { return set(Math.floor(getX()), Math.floor(getY()), Math.floor(getZ())); }
	default Vector3f ceil() { return set(Math.ceil(getX()), Math.ceil(getY()), Math.ceil(getZ())); }
	default Vector3f round() { return set(Math.round(getX()), Math.round(getY()), Math.round(getZ())); }
	
	default Vector3f normalize() { return Check.notNull(this) ? div(length()) : this; }
	
	default Vector3f invert() { return mul(-1.0f); }
	
	default Vector3f reflect(Vector3fBase normal)
	{
		double angle = dot(normal) * 2;
		
		setX(getX() - (angle) * normal.getX());
		setY(getY() - (angle) * normal.getY());
		setZ(getZ() - (angle) * normal.getZ());
		
		return this;
	}
	
	default Vector3f lerp(Vector3fBase v, float f)
	{
		setX(getX() + (v.getX() - getX()) * f);
		setY(getY() + (v.getY() - getY()) * f);
		setZ(getZ() + (v.getZ() - getZ()) * f);
		
		return this;
	}
	
	default Vector3f slerp(Vector3fBase v, double f)
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
		
		return new Vec3f((float)x, (float)y, (float)z);
	}
	
	default Vector3f abs(boolean x, boolean y, boolean z) { return set(x ? Math.abs(getX()) : getX(), y ? Math.abs(getY()) : getY(), z ? Math.abs(getZ()) : getZ()); }
	
	default Vector3f setZero() { return set(0.0f); }
	
	default Vector3f set(Vector3fBase v) { return set(v.getX(), v.getY(), v.getZ()); }
	
	default Vector3f set(float scalar) { return set(scalar, scalar, scalar); }
	default Vector3f set(double scalar) { return set(scalar, scalar, scalar); }
	default Vector3f set(float x, float y, float z) { return setX(x).setY(y).setZ(z); }
	default Vector3f set(double x, double y, double z) { return setX(x).setY(y).setZ(z); }

	default Vector3f add(Vector3fBase v) { return add(v.getX(), v.getY(), v.getZ()); }
	default Vector3f add(float scalar) { return add(scalar, scalar, scalar); }
	default Vector3f add(float x, float y, float z) { return set(getX() + x, getY() + y, getZ() + z); }
	default Vector3f add(double x, double y, double z) { return set(getX() + x, getY() + y, getZ() + z); }

	default Vector3f sub(Vector3fBase v) { return add(v.getX(), v.getY(), v.getZ()); }
	default Vector3f sub(float scalar) { return add(scalar, scalar, scalar); }
	default Vector3f sub(float x, float y, float z) { return set(getX() - x, getY() - y, getZ() - z); }
	default Vector3f sub(double x, double y, double z) { return set(getX() - x, getY() - y, getZ() - z); }
	
	default Vector3f mul(Vector3fBase v) { return add(v.getX(), v.getY(), v.getZ()); }
	default Vector3f mul(float scalar) { return add(scalar, scalar, scalar); }
	default Vector3f mul(float x, float y, float z) { return set(getX() * x, getY() * y, getZ() * z); }
	default Vector3f mul(double x, double y, double z) { return set(getX() * x, getY() * y, getZ() * z); }
	
	default Vector3f div(Vector3fBase v) { return add(v.getX(), v.getY(), v.getZ()); }
	default Vector3f div(float scalar) { return add(scalar, scalar, scalar); }
	default Vector3f div(float x, float y, float z) { return set(getX() / x, getY() / y, getZ() / z); }
	default Vector3f div(double x, double y, double z) { return set(getX() / x, getY() / y, getZ() / z); }
	
	/** {@inheritDoc} */ @Override
	default void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		setX(dis.readFloat());
		setY(dis.readFloat());
		setZ(dis.readFloat());

	}
	
}

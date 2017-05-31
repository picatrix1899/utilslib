package cmn.utilslib.vector.api;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import cmn.utilslib.essentials.Check;
import cmn.utilslib.interfaces.Streamable;
import cmn.utilslib.vector.Vector3f;

public interface Vec3f extends Vec3fBase, Streamable.Writeable
{
	
	Vec3f setX(float x);
	Vec3f setX(double x); 
	Vec3f setY(float y);
	Vec3f setY(double y); 
	Vec3f setZ(float z);
	Vec3f setZ(double z);
	
	default Vec3f floor() { return set(Math.floor(getX()), Math.floor(getY()), Math.floor(getZ())); }
	default Vec3f ceil() { return set(Math.ceil(getX()), Math.ceil(getY()), Math.ceil(getZ())); }
	default Vec3f round() { return set(Math.round(getX()), Math.round(getY()), Math.round(getZ())); }
	
	default Vec3f normalize() { return Check.notNull(this) ? div(length()) : this; }
	
	default Vec3f invert() { return mul(-1.0f); }
	
	default Vec3f reflect(Vec3fBase normal)
	{
		double angle = dot(normal) * 2;
		
		setX(getX() - (angle) * normal.getX());
		setY(getY() - (angle) * normal.getY());
		setZ(getZ() - (angle) * normal.getZ());
		
		return this;
	}
	
	default Vec3f lerp(Vec3fBase v, float f)
	{
		setX(getX() + (v.getX() - getX()) * f);
		setY(getY() + (v.getY() - getY()) * f);
		setZ(getZ() + (v.getZ() - getZ()) * f);
		
		return this;
	}
	
	default Vec3f slerp(Vec3fBase v, double f)
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
		
		return new Vector3f((float)x, (float)y, (float)z);
	}
	
	default Vec3f abs(boolean x, boolean y, boolean z) { return set(x ? Math.abs(getX()) : getX(), y ? Math.abs(getY()) : getY(), z ? Math.abs(getZ()) : getZ()); }
	
	default Vec3f setZero() { return set(0.0f); }
	
	default Vec3f set(Vec3fBase v) { return set(v.getX(), v.getY(), v.getZ()); }
	
	default Vec3f set(float scalar) { return set(scalar, scalar, scalar); }
	default Vec3f set(double scalar) { return set(scalar, scalar, scalar); }
	default Vec3f set(float x, float y, float z) { return setX(x).setY(y).setZ(z); }
	default Vec3f set(double x, double y, double z) { return setX(x).setY(y).setZ(z); }

	default Vec3f add(Vec3fBase v) { return add(v.getX(), v.getY(), v.getZ()); }
	default Vec3f add(float scalar) { return add(scalar, scalar, scalar); }
	default Vec3f add(float x, float y, float z) { return set(getX() + x, getY() + y, getZ() + z); }
	default Vec3f add(double x, double y, double z) { return set(getX() + x, getY() + y, getZ() + z); }

	default Vec3f sub(Vec3fBase v) { return sub(v.getX(), v.getY(), v.getZ()); }
	default Vec3f sub(float scalar) { return sub(scalar, scalar, scalar); }
	default Vec3f sub(float x, float y, float z) { return set(getX() - x, getY() - y, getZ() - z); }
	default Vec3f sub(double x, double y, double z) { return set(getX() - x, getY() - y, getZ() - z); }
	
	default Vec3f mul(Vec3fBase v) { return mul(v.getX(), v.getY(), v.getZ()); }
	default Vec3f mul(float scalar) { return mul(scalar, scalar, scalar); }
	default Vec3f mul(float x, float y, float z) { return set(getX() * x, getY() * y, getZ() * z); }
	default Vec3f mul(double x, double y, double z) { return set(getX() * x, getY() * y, getZ() * z); }
	
	default Vec3f div(Vec3fBase v) { return div(v.getX(), v.getY(), v.getZ()); }
	default Vec3f div(float scalar) { return div(scalar, scalar, scalar); }
	default Vec3f div(float x, float y, float z) { return set(getX() / x, getY() / y, getZ() / z); }
	default Vec3f div(double x, double y, double z) { return set(getX() / x, getY() / y, getZ() / z); }
	
	/** {@inheritDoc} */ @Override
	default void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		setX(dis.readFloat());
		setY(dis.readFloat());
		setZ(dis.readFloat());

	}
	
}

package cmn.utilslib.vector.api;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import cmn.utilslib.essentials.Check;
import cmn.utilslib.interfaces.IStreamable;
import cmn.utilslib.vector.Vec3d;

public interface IVec3d extends IVec3dBase, IStreamable.Writeable
{
	
	IVec3d setX(float x);
	IVec3d setX(double x); 
	IVec3d setY(float y);
	IVec3d setY(double y); 
	IVec3d setZ(float z);
	IVec3d setZ(double z);
	
	default IVec3d floor() { return set(Math.floor(getX()), Math.floor(getY()), Math.floor(getZ())); }
	default IVec3d ceil() { return set(Math.ceil(getX()), Math.ceil(getY()), Math.ceil(getZ())); }
	default IVec3d round() { return set(Math.round(getX()), Math.round(getY()), Math.round(getZ())); }
	
	default IVec3d normalize() { return Check.notNull(this) ? div(length()) : this; }
	
	default IVec3d invert() { return mul(-1.0f); }
	
	default IVec3d reflect(IVec3dBase normal)
	{
		double angle = dot(normal) * 2;
		
		setX(getX() - (angle) * normal.getX());
		setY(getY() - (angle) * normal.getY());
		setZ(getZ() - (angle) * normal.getZ());
		
		return this;
	}
	
	default IVec3d lerp(IVec3dBase v, float f)
	{
		setX(getX() + (v.getX() - getX()) * f);
		setY(getY() + (v.getY() - getY()) * f);
		setZ(getZ() + (v.getZ() - getZ()) * f);
		
		return this;
	}
	
	default IVec3d slerp(IVec3dBase v, double f)
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
		
		return new Vec3d(x, y, z);
	}
	
	default IVec3d abs(boolean x, boolean y, boolean z) { return set(x ? Math.abs(getX()) : getX(), y ? Math.abs(getY()) : getY(), z ? Math.abs(getZ()) : getZ()); }
	
	default IVec3d setZero() { return set(0.0f); }
	
	default IVec3d set(IVec3dBase v) { return set(v.getX(), v.getY(), v.getZ()); }
	
	default IVec3d set(float scalar) { return set(scalar, scalar, scalar); }
	default IVec3d set(double scalar) { return set(scalar, scalar, scalar); }
	default IVec3d set(float x, float y, float z) { return setX(x).setY(y).setZ(z); }
	default IVec3d set(double x, double y, double z) { return setX(x).setY(y).setZ(z); }

	default IVec3d add(IVec3dBase v) { return add(v.getX(), v.getY(), v.getZ()); }
	default IVec3d add(double scalar) { return add(scalar, scalar, scalar); }
	default IVec3d add(float x, float y, float z) { return set(getX() + x, getY() + y, getZ() + z); }
	default IVec3d add(double x, double y, double z) { return set(getX() + x, getY() + y, getZ() + z); }

	default IVec3d sub(IVec3dBase v) { return add(v.getX(), v.getY(), v.getZ()); }
	default IVec3d sub(double scalar) { return add(scalar, scalar, scalar); }
	default IVec3d sub(float x, float y, float z) { return set(getX() - x, getY() - y, getZ() - z); }
	default IVec3d sub(double x, double y, double z) { return set(getX() - x, getY() - y, getZ() - z); }
	
	default IVec3d mul(IVec3dBase v) { return add(v.getX(), v.getY(), v.getZ()); }
	default IVec3d mul(double scalar) { return add(scalar, scalar, scalar); }
	default IVec3d mul(float x, float y, float z) { return set(getX() * x, getY() * y, getZ() * z); }
	default IVec3d mul(double x, double y, double z) { return set(getX() * x, getY() * y, getZ() * z); }
	
	default IVec3d div(IVec3dBase v) { return add(v.getX(), v.getY(), v.getZ()); }
	default IVec3d div(double scalar) { return add(scalar, scalar, scalar); }
	default IVec3d div(float x, float y, float z) { return set(getX() / x, getY() / y, getZ() / z); }
	default IVec3d div(double x, double y, double z) { return set(getX() / x, getY() / y, getZ() / z); }
	
	/** {@inheritDoc} */ @Override
	default void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		setX(dis.readDouble());
		setY(dis.readDouble());
		setZ(dis.readDouble());

	}
	
}

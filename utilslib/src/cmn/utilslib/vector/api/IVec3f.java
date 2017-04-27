package cmn.utilslib.vector.api;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import cmn.utilslib.essentials.Check;
import cmn.utilslib.interfaces.IStreamable;

public interface IVec3f extends IVec3fBase, IStreamable.Writeable
{
	
	IVec3f setX(float x);
	IVec3f setX(double x); 
	IVec3f setY(float y);
	IVec3f setY(double y); 
	IVec3f setZ(float z);
	IVec3f setZ(double z);
	
	default IVec3f floor() { return set(Math.floor(getX()), Math.floor(getY()), Math.floor(getZ())); }
	default IVec3f ceil() { return set(Math.ceil(getX()), Math.ceil(getY()), Math.ceil(getZ())); }
	default IVec3f round() { return set(Math.round(getX()), Math.round(getY()), Math.round(getZ())); }
	
	default IVec3f normalize() { return Check.notNull(this) ? div(length()) : this; }
	
	default IVec3f invert() { return mul(-1.0f); }
	
	default IVec3f reflect(IVec3fBase normal)
	{
		float angle = dot(normal) *  2;
		
		setX(getX() - (angle) * normal.getX());
		setY(getY() - (angle) * normal.getY());
		setZ(getZ() - (angle) * normal.getZ());
		
		return this;
	}
	
	default IVec3f lerp(IVec3fBase v, float f)
	{
		setX(getX() + (v.getX() - getX()) * f);
		setY(getY() + (v.getY() - getY()) * f);
		setZ(getZ() + (v.getZ() - getZ()) * f);
		
		return this;
	}
	
	default IVec3f abs(boolean x, boolean y, boolean z) { return set(x ? Math.abs(getX()) : getX(), y ? Math.abs(getY()) : getY(), z ? Math.abs(getZ()) : getZ()); }
	
	default IVec3f setZero() { return set(0.0f); }
	
	default IVec3f set(IVec3fBase v) { return set(v.getX(), v.getY(), v.getZ()); }
	
	default IVec3f set(float scalar) { return set(scalar, scalar, scalar); }
	default IVec3f set(double scalar) { return set(scalar, scalar, scalar); }
	default IVec3f set(float x, float y, float z) { return setX(x).setY(y).setZ(z); }
	default IVec3f set(double x, double y, double z) { return setX(x).setY(y).setZ(z); }

	default IVec3f add(IVec3fBase v) { return add(v.getX(), v.getY(), v.getZ()); }
	default IVec3f add(float scalar) { return add(scalar, scalar, scalar); }
	default IVec3f add(float x, float y, float z) { return set(getX() + x, getY() + y, getZ() + z); }
	default IVec3f add(double x, double y, double z) { return set(getX() + x, getY() + y, getZ() + z); }

	default IVec3f sub(IVec3fBase v) { return add(v.getX(), v.getY(), v.getZ()); }
	default IVec3f sub(float scalar) { return add(scalar, scalar, scalar); }
	default IVec3f sub(float x, float y, float z) { return set(getX() - x, getY() - y, getZ() - z); }
	default IVec3f sub(double x, double y, double z) { return set(getX() - x, getY() - y, getZ() - z); }
	
	default IVec3f mul(IVec3fBase v) { return add(v.getX(), v.getY(), v.getZ()); }
	default IVec3f mul(float scalar) { return add(scalar, scalar, scalar); }
	default IVec3f mul(float x, float y, float z) { return set(getX() * x, getY() * y, getZ() * z); }
	default IVec3f mul(double x, double y, double z) { return set(getX() * x, getY() * y, getZ() * z); }
	
	default IVec3f div(IVec3fBase v) { return add(v.getX(), v.getY(), v.getZ()); }
	default IVec3f div(float scalar) { return add(scalar, scalar, scalar); }
	default IVec3f div(float x, float y, float z) { return set(getX() / x, getY() / y, getZ() / z); }
	default IVec3f div(double x, double y, double z) { return set(getX() / x, getY() / y, getZ() / z); }
	
	/** {@inheritDoc} */ @Override
	default void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		setX(dis.readFloat());
		setY(dis.readFloat());
		setZ(dis.readFloat());

	}
	
}

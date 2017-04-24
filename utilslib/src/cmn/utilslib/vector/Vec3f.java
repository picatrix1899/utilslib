package cmn.utilslib.vector;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cmn.utilslib.alloc.Allocator;

import cmn.utilslib.essentials.Check;
import cmn.utilslib.essentials.Maths;

import cmn.utilslib.interfaces.IObjectable;
import cmn.utilslib.interfaces.IStreamable;
import cmn.utilslib.vector.api.IVec3fBase;


/**
 * A mathematical 3-dimensional vector of type float
 * 
 * @author picatrix1899
 *
 */
public class Vec3f implements IVec3fBase<Vec3f>
{

	public float x = 0.0f;
	public float y = 0.0f;
	public float z = 0.0f;
	
	

	public Vec3f() { setZero(); }
	
	public Vec3f(float scalar) { set(scalar); }
	
	public Vec3f(float x, float y, float z) { set(x, y, z); }
	
	/*
	 * =========
	 * GETTERS
	 * =========
	 */
	public float getX() { return this.x; }
	public float getY() { return this.y; }
	public float getZ() { return this.z; }
	
	/*
	 * ======================
	 * SETTERS
	 * ======================
	 */
	public Vec3f setZero() { return set(0.0f); }
	
	public Vec3f set(IVec3fBase<?> v) { return set(v.getX(), v.getY(), v.getZ()); }
	
	public Vec3f set(float scalar) { return set(scalar, scalar, scalar); }
	public Vec3f set(double scalar) { return set(scalar, scalar, scalar); }
	public Vec3f set(float x, float y, float z) { return setX(x).setY(y).setZ(z); }
	public Vec3f set(double x, double y, double z) { return setX(x).setY(y).setZ(z); }

	public Vec3f setX(float x) { this.x = x; return this; }
	public Vec3f setX(double x) { this.x = (float)x; return this; }
	public Vec3f setY(float y) { this.y = y; return this; }
	public Vec3f setY(double y) { this.y = (float)y; return this; }
	public Vec3f setZ(float z) { this.z = z; return this; }
	public Vec3f setZ(double z) { this.z = (float)z; return this; }
	
	
	/*
	 * ====================
	 * BASIC-OPERATIONS
	 * ====================
	 */

	public Vec3f add(IVec3fBase<?> v) { return add(v.getX(), v.getY(), v.getZ()); }
	public Vec3f add(float scalar) { return add(scalar, scalar, scalar); }
	public Vec3f add(float x, float y, float z) { return set(this.x + x, this.y + y, this.z + z); }
	public Vec3f add(double x, double y, double z) { return set(this.x + x, this.y + y, this.z + z); }

	public Vec3f sub(IVec3fBase<?> v) { return add(v.getX(), v.getY(), v.getZ()); }
	public Vec3f sub(float scalar) { return add(scalar, scalar, scalar); }
	public Vec3f sub(float x, float y, float z) { return set(this.x - x, this.y - y, this.z - z); }
	public Vec3f sub(double x, double y, double z) { return set(this.x - x, this.y - y, this.z - z); }
	
	public Vec3f mul(IVec3fBase<?> v) { return add(v.getX(), v.getY(), v.getZ()); }
	public Vec3f mul(float scalar) { return add(scalar, scalar, scalar); }
	public Vec3f mul(float x, float y, float z) { return set(this.x * x, this.y * y, this.z * z); }
	public Vec3f mul(double x, double y, double z) { return set(this.x * x, this.y * y, this.z * z); }
	
	public Vec3f div(IVec3fBase<?> v) { return add(v.getX(), v.getY(), v.getZ()); }
	public Vec3f div(float scalar) { return add(scalar, scalar, scalar); }
	public Vec3f div(float x, float y, float z) { return set(this.x / x, this.y / y, this.z / z); }
	public Vec3f div(double x, double y, double z) { return set(this.x / x, this.y / y, this.z / z); }
	
	
	public Vec3f addN(float x, float y, float z) { return clone().add(x, y, z); }
	public Vec3f addN(double x, double y, double z) { return clone().add(x, y, z); }
	

	public Vec3f subN(float x, float y, float z) { return clone().sub(x, y, z); }
	public Vec3f subN(double x, double y, double z) { return clone().sub(x, y, z); }
	

	public Vec3f mulN(float x, float y, float z) { return clone().mul(x, y, z); }
	public Vec3f mulN(double x, double y, double z) { return clone().mul(x, y, z); }
	
	
	public Vec3f divN(float x, float y, float z) { return clone().div(x, y, z); }
	public Vec3f divN(double x, double y, double z) { return clone().div(x, y, z); }
	
	/*
	 * =====================
	 * VECTOR-OPERATIONS
	 * =====================
	 */
	public float squaredLength() { return this.x * this.x + this.y * this.y + this.z * this.z; }
	
	public float length() { return (float) Math.sqrt(squaredLength()); }
	
	public Vec3f normalize() { return Check.notNull(this) ? div(length()) : this; }
	
	public Vec3f normalized() { return clone().normalize(); }
	
	public Vec3f invert() { return mul(-1.0f); }
	
	public Vec3f inverted() { return clone().invert(); }
	
	public Vec3f inverse() { return new Vec3f(1.0f).div(this); }
	
	public Vec3f inversed() { return clone().inverse(); }
	
	public float dot(IVec3fBase<?> v) { return this.x * v.getX() + this.y * v.getY() + this.z * v.getZ(); }
	
	public Vec3f cross(IVec3fBase<?> v) 
	{
		return new Vec3f(this.y * v.getZ() - this.z * v.getY(), this.z * v.getX() - this.x * v.getZ(), this.x * v.getY() - this.y * v.getX());
	}

	public Vec3f project(Vec3f v)
	{	
		Vec3f vn = v.normalized();
		 float f = this.dot(vn);
		 
		 return vn.mul(f);
	}
	
	
	public Vec3f rot(Vec3f axis, float angle)
	{
		
		angle *= 0.5f;
		angle *= Maths.DEG_TO_RAD;
		
		double sinHalfAngle = Math.sin(angle);
		double cosHalfAngle = Math.cos(angle);
		
		double rX = axis.x * sinHalfAngle;
		double rY = axis.y * sinHalfAngle;
		double rZ = axis.z * sinHalfAngle;
		double rW = cosHalfAngle;
		
		Quaternion rotation = new Quaternion(rW, rX, rY, rZ);
		
		return rot(rotation);
	}
	
	public Vec3f rot(Quaternion q)
	{
		Quaternion conjugate = q.conjugated();
		Quaternion w = q.mulN(this).mulN(conjugate);

		return new Vec3f((float)w.getX(), (float)w.getY(), (float)w.getZ());
	}
	
	public Vec3f reflect(IVec3fBase<?> normal)
	{
		float angle = dot(normal) *  2;
		
		this.x -= (angle) * normal.getX();
		this.y -= (angle) * normal.getY();
		this.y -= (angle) * normal.getZ();
		
		return this;
	}
	
	public Vec3f reflected(IVec3fBase<?> normal)
	{
		Vec3f out = clone();
		
		out.reflect(normal);
		
		return out;
	}
	
	public Vec3f lerp(IVec3fBase<?> v, float f)
	{
		this.x += (v.getX() - this.x) * f;
		this.y += (v.getY() - this.y) * f;
		this.z += (v.getZ() - this.z) * f;
		
		return this;
	}
	
	public Vec3f lerped(IVec3fBase<?> v, float f)
	{
		Vec3f out = clone();
		out.lerp(v, f);
		return out;
	}
	
	public double angleRad(Vec3f v)
	{
		return Math.acos((dot(v)) / (length() * v.length()));
	}
	
	public double angleDeg(Vec3f v)
	{
		return angleRad(v) * Maths.RAD_TO_DEG;
	}
	
	
	public float max() { return Math.max(this.x, Math.max(this.y, this.z)); }
	public float min() { return Math.min(this.x, Math.min(this.y, this.z)); }
	

	
	public Vec3f abs() { return set(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z)); }
	
	public Vec3f absN() { return clone().abs(); }	
	
	/*
	 * =========================
	 * ROUNDING
	 * =========================
	 */
	public Vec3f floor() { return set(Math.floor(this.x), Math.floor(this.y), Math.floor(this.z)); }
	public Vec3f ceil() { return set(Math.ceil(this.x), Math.ceil(this.y), Math.ceil(this.z));}
	public Vec3f round() { return set(Math.round(this.x), Math.round(this.y), Math.round(this.z)); }
	
	
	public Vec3f floorN() { return clone().floor(); }
	public Vec3f ceilN() { return clone().ceil(); }
	public Vec3f roundN() { return clone().round(); }
	
	/*
	 * ===========================
	 * OBJECT-OVERRIDES
	 * ===========================
	 */
	/** {@inheritDoc} */
	@Override
	public Vec3f clone() { return new Vec3f(this); }
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Vec3f)) return false;
		Vec3f v = (Vec3f)obj;
		
		if(v.x != this.x) return false;
		if(v.y != this.y) return false;
		if(v.z != this.z) return false;
		
		return true;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() { return "Vec3f(" + this.x + "f, " + this.y + "f, " + this.z + "f)"; }
	
	/*
	 * ===========================
	 * Streamable SERIALIZATION
	 * ===========================
	 */
	/** {@inheritDoc} */
	@Override
	public void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		this.x = dis.readFloat();
		this.y = dis.readFloat();
		this.z = dis.readFloat();
	}

}
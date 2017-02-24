package cmn.utilslib.vector;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import cmn.utilslib.alloc.Allocator;

import cmn.utilslib.essentials.Check;
import cmn.utilslib.essentials.Maths;

import cmn.utilslib.interfaces.IObjectable;
import cmn.utilslib.interfaces.IStreamable;
import cmn.utilslib.interfaces.IStringParser;


/**
 * A mathematical 3-dimensional vector of type float
 * 
 * @author picatrix1899
 *
 */
public class Vec3f implements IStreamable, Serializable, IObjectable<Vec3f>
{

	/**
	 * 
	 */
	private static transient final long serialVersionUID = 1L;

	public static transient final short DIMENSIONS = 3;
	
	private static final Allocator<Vec3f> alloc = new Allocator<Vec3f>();
	
	public static final PVec3f ZERO = PVec3f.gen(0.0f, 0.0f, 0.0f);
	public static final PVec3f ONE = PVec3f.gen(1.0f, 1.0f, 1.0f);
	public static final PVec3f aX = PVec3f.gen(1.0f, 0.0f, 0.0f);
	public static final PVec3f aY = PVec3f.gen(0.0f, 1.0f, 0.0f);
	public static final PVec3f aZ = PVec3f.gen(0.0f, 0.0f, 1.0f);
	public static final PVec3f aNX = PVec3f.gen(-1.0f, 0.0f, 0.0f);
	public static final PVec3f aNY = PVec3f.gen(0.0f, -1.0f, 0.0f);
	public static final PVec3f aNZ = PVec3f.gen(0.0f, 0.0f, -1.0f);
	
	public float x = 0.0f;
	public float y = 0.0f;
	public float z = 0.0f;
	
	

	public Vec3f() { setZero(); }
	
	public Vec3f(float scalar) { set(scalar); }
	
	public Vec3f(float x, float y, float z) { set(x, y, z); }
	
	
	/*
	 * ======================
	 * Allocation
	 * ======================
	 */
	public static Vec3f getNew()
	{
		Vec3f v = alloc.alloc(Vec3f.class);
		
		v.setZero();
		
		return v;
	}
	
	private static Vec3f getNew(Vec3f vec)
	{
		Vec3f v = alloc.alloc(Vec3f.class);
		
		v.set(vec);
		
		return v;
	}
	
	public static Vec3f getNew(float scalar)
	{
		Vec3f v = alloc.alloc(Vec3f.class);
		
		v.set(scalar);
		
		return v;
	}
	
	public static Vec3f getNew(float x, float y, float z)
	{
		Vec3f v = alloc.alloc(Vec3f.class);
		
		v.set(x, y, z);
		
		return v;
	}
	
	public void release()
	{
		Vec3f.alloc.release(this);
	}
	
	
	/*
	 * ======================
	 * SETTERS
	 * ======================
	 */
	public Vec3f setZero() { return set(0.0f); }
	
	public Vec3f set(Vec3f v) { return set(v.x, v.y, v.z); }
	
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
	public Vec3f add(Vec3f v) { return add(v.x, v.y, v.z); }
	public Vec3f add(float scalar) { return add(scalar, scalar, scalar); }
	public Vec3f add(double scalar) { return add(scalar, scalar, scalar); }	
	public Vec3f add(float x, float y, float z) { return set(this.x + x, this.y + y, this.z + z); }
	public Vec3f add(double x, double y, double z) { return set(this.x + x, this.y + y, this.z + z); }

	public Vec3f sub(Vec3f v) { return sub(v.x, v.y,v.z); }
	public Vec3f sub(float scalar) { return sub(scalar, scalar, scalar); }
	public Vec3f sub(double scalar) { return sub(scalar, scalar, scalar); }	
	public Vec3f sub(float x, float y, float z) { return set(this.x - x, this.y - y, this.z - z); }
	public Vec3f sub(double x, double y, double z) { return set(this.x - x, this.y - y, this.z - z); }
	
	public Vec3f mul(Vec3f v) { return mul(v.x, v.y,v.z); }
	public Vec3f mul(float scalar) { return mul(scalar, scalar, scalar); }
	public Vec3f mul(double scalar) { return mul(scalar, scalar, scalar); }	
	public Vec3f mul(float x, float y, float z) { return set(this.x * x, this.y * y, this.z * z); }
	public Vec3f mul(double x, double y, double z) { return set(this.x * x, this.y * y, this.z * z); }
	
	public Vec3f div(Vec3f v) { return div(v.x, v.y,v.z); }
	public Vec3f div(float scalar) { return div(scalar, scalar, scalar); }
	public Vec3f div(double scalar) { return div(scalar, scalar, scalar); }	
	public Vec3f div(float x, float y, float z) { return set(this.x / x, this.y / y, this.z / z); }
	public Vec3f div(double x, double y, double z) { return set(this.x / x, this.y / y, this.z / z); }
	
	public Vec3f addN(Vec3f v) { return addN(v.x, v.y, v.z); }
	public Vec3f addN(float scalar) { return addN(scalar, scalar, scalar); }
	public Vec3f addN(double scalar) { return addN(scalar, scalar, scalar); }	
	public Vec3f addN(float x, float y, float z) { return clone().add(x, y, z); }
	public Vec3f addN(double x, double y, double z) { return clone().add(x, y, z); }
	
	public Vec3f subN(Vec3f v) { return subN(v.x, v.y, v.z); }
	public Vec3f subN(float scalar) { return subN(scalar, scalar, scalar); }
	public Vec3f subN(double scalar) { return subN(scalar, scalar, scalar); }	
	public Vec3f subN(float x, float y, float z) { return clone().sub(x, y, z); }
	public Vec3f subN(double x, double y, double z) { return clone().sub(x, y, z); }
	
	public Vec3f mulN(Vec3f v) { return mulN(v.x, v.y, v.z); }
	public Vec3f mulN(float scalar) { return mulN(scalar, scalar, scalar); }
	public Vec3f mulN(double scalar) { return mulN(scalar, scalar, scalar); }	
	public Vec3f mulN(float x, float y, float z) { return clone().mul(x, y, z); }
	public Vec3f mulN(double x, double y, double z) { return clone().mul(x, y, z); }
	
	public Vec3f divN(Vec3f v) { return divN(v.x, v.y, v.z); }
	public Vec3f divN(float scalar) { return divN(scalar, scalar, scalar); }
	public Vec3f divN(double scalar) { return divN(scalar, scalar, scalar); }	
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
	
	public float dot(Vec3f v) { return this.x * v.x + this.y * v.y + this.z * v.z; }
	
	public Vec3f cross(Vec3f v) 
	{
		return new Vec3f(this.y * v.z - this.z * v.y, this.z * v.x - this.x * v.z, this.x * v.y - this.y * v.x);
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
	
	public Vec3f reflect(Vec3f normal)
	{
		float angle = dot(normal) *  2;
		
		this.x -= (angle) * normal.x;
		this.y -= (angle) * normal.y;
		this.y -= (angle) * normal.z;
		
		return this;
	}
	
	public Vec3f reflected(Vec3f normal)
	{
		Vec3f out = clone();
		
		out.reflect(normal);
		
		return out;
	}
	
	public Vec3f lerp(Vec3f v, float f)
	{
		this.x += (v.x - this.x) * f;
		this.y += (v.y - this.y) * f;
		this.z += (v.z - this.z) * f;
		
		return this;
	}
	
	public Vec3f lerped(Vec3f v, float f)
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
	 * ==================
	 * ORDINAL OPERATIONS
	 * ==================
	 */
	public int getDimensions() { return Vec3f.DIMENSIONS; }
	
	
	/*
	 * ===========================
	 * OBJECT-OVERRIDES
	 * ===========================
	 */
	/** {@inheritDoc} */
	@Override
	public Vec3f clone() { return getNew(this); }
	
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
	
	/** {@inheritDoc} */
	@Override
	public String toString(IStringParser<Vec3f> parser) { return parser.parse(this); }
	
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
	
	/** {@inheritDoc} */
	@Override
	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeFloat(this.x);
		dos.writeFloat(this.y);
		dos.writeFloat(this.z);
	}

}
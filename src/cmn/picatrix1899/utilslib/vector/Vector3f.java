package cmn.picatrix1899.utilslib.vector;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import cmn.picatrix1899.utilslib.alloc.Allocator;
import cmn.picatrix1899.utilslib.essentials.Maths;
import cmn.picatrix1899.utilslib.essentials.Validate.Check;
import cmn.picatrix1899.utilslib.interfaces.DataHolder;

/**
 * A mathematical 3-dimensional vector of type float
 * 
 * @author picatrix1899
 *
 */
public class Vector3f implements DataHolder, Serializable
{

	/**
	 * 
	 */
	private static transient final long serialVersionUID = 1L;

	public static transient final short DIMENSIONS = 3;
	
	private static final Allocator<Vector3f> alloc = new Allocator<Vector3f>();
	
	public static final PersistentVector3f aX = PersistentVector3f.gen(1.0f, 0.0f, 0.0f);
	public static final PersistentVector3f aY = PersistentVector3f.gen(0.0f, 1.0f, 0.0f);
	public static final PersistentVector3f aZ = PersistentVector3f.gen(0.0f, 0.0f, 1.0f);
	public static final PersistentVector3f aNX = PersistentVector3f.gen(-1.0f, 0.0f, 0.0f);
	public static final PersistentVector3f aNY = PersistentVector3f.gen(0.0f, -1.0f, 0.0f);
	public static final PersistentVector3f aNZ = PersistentVector3f.gen(0.0f, 0.0f, -1.0f);
	
	public float x = 0.0f;
	public float y = 0.0f;
	public float z = 0.0f;
	
	

	public Vector3f() { setZero(); }
	
	public Vector3f(float scalar) { set(scalar); }
	
	public Vector3f(float x, float y, float z) { set(x, y, z); }
	
	public static Vector3f getNew()
	{
		Vector3f v = alloc.alloc(Vector3f.class);
		
		v.setZero();
		
		return v;
	}
	
	private static Vector3f getNew(Vector3f vec)
	{
		Vector3f v = alloc.alloc(Vector3f.class);
		
		v.set(vec);
		
		return v;
	}
	
	public static Vector3f getNew(float scalar)
	{
		Vector3f v = alloc.alloc(Vector3f.class);
		
		v.set(scalar);
		
		return v;
	}
	
	public static Vector3f getNew(float x, float y, float z)
	{
		Vector3f v = alloc.alloc(Vector3f.class);
		
		v.set(x, y, z);
		
		return v;
	}
	
	public void release()
	{
		Vector3f.alloc.release(this);
	}
	
	public Vector3f setZero() { return set(0.0f); }
	
	public Vector3f set(Vector3f v) { return set(v.x, v.y, v.z); }
	
	public Vector3f set(float scalar) { return set(scalar, scalar, scalar); }
	public Vector3f set(double scalar) { return set(scalar, scalar, scalar); }
	public Vector3f set(float x, float y, float z) { return setX(x).setY(y).setZ(z); }
	public Vector3f set(double x, double y, double z) { return setX(x).setY(y).setZ(z); }

	public Vector3f setX(float x) { this.x = x; return this; }
	public Vector3f setX(double x) { this.x = (float)x; return this; }
	public Vector3f setY(float y) { this.y = y; return this; }
	public Vector3f setY(double y) { this.y = (float)y; return this; }
	public Vector3f setZ(float z) { this.z = z; return this; }
	public Vector3f setZ(double z) { this.z = (float)z; return this; }
	
	
	
	public Vector3f add(Vector3f v) { return add(v.x, v.y, v.z); }
	public Vector3f add(float scalar) { return add(scalar, scalar, scalar); }
	public Vector3f add(double scalar) { return add(scalar, scalar, scalar); }	
	public Vector3f add(float x, float y, float z) { return set(this.x + x, this.y + y, this.z + z); }
	public Vector3f add(double x, double y, double z) { return set(this.x + x, this.y + y, this.z + z); }

	public Vector3f sub(Vector3f v) { return sub(v.x, v.y,v.z); }
	public Vector3f sub(float scalar) { return sub(scalar, scalar, scalar); }
	public Vector3f sub(double scalar) { return sub(scalar, scalar, scalar); }	
	public Vector3f sub(float x, float y, float z) { return set(this.x - x, this.y - y, this.z - z); }
	public Vector3f sub(double x, double y, double z) { return set(this.x - x, this.y - y, this.z - z); }
	
	public Vector3f mul(Vector3f v) { return mul(v.x, v.y,v.z); }
	public Vector3f mul(float scalar) { return mul(scalar, scalar, scalar); }
	public Vector3f mul(double scalar) { return mul(scalar, scalar, scalar); }	
	public Vector3f mul(float x, float y, float z) { return set(this.x * x, this.y * y, this.z * z); }
	public Vector3f mul(double x, double y, double z) { return set(this.x * x, this.y * y, this.z * z); }
	
	public Vector3f div(Vector3f v) { return div(v.x, v.y,v.z); }
	public Vector3f div(float scalar) { return div(scalar, scalar, scalar); }
	public Vector3f div(double scalar) { return div(scalar, scalar, scalar); }	
	public Vector3f div(float x, float y, float z) { return set(this.x / x, this.y / y, this.z / z); }
	public Vector3f div(double x, double y, double z) { return set(this.x / x, this.y / y, this.z / z); }
	
	public Vector3f addN(Vector3f v) { return addN(v.x, v.y, v.z); }
	public Vector3f addN(float scalar) { return addN(scalar, scalar, scalar); }
	public Vector3f addN(double scalar) { return addN(scalar, scalar, scalar); }	
	public Vector3f addN(float x, float y, float z) { return clone().add(x, y, z); }
	public Vector3f addN(double x, double y, double z) { return clone().add(x, y, z); }
	
	public Vector3f subN(Vector3f v) { return subN(v.x, v.y, v.z); }
	public Vector3f subN(float scalar) { return subN(scalar, scalar, scalar); }
	public Vector3f subN(double scalar) { return subN(scalar, scalar, scalar); }	
	public Vector3f subN(float x, float y, float z) { return clone().sub(x, y, z); }
	public Vector3f subN(double x, double y, double z) { return clone().sub(x, y, z); }
	
	public Vector3f mulN(Vector3f v) { return mulN(v.x, v.y, v.z); }
	public Vector3f mulN(float scalar) { return mulN(scalar, scalar, scalar); }
	public Vector3f mulN(double scalar) { return mulN(scalar, scalar, scalar); }	
	public Vector3f mulN(float x, float y, float z) { return clone().mul(x, y, z); }
	public Vector3f mulN(double x, double y, double z) { return clone().mul(x, y, z); }
	
	public Vector3f divN(Vector3f v) { return divN(v.x, v.y, v.z); }
	public Vector3f divN(float scalar) { return divN(scalar, scalar, scalar); }
	public Vector3f divN(double scalar) { return divN(scalar, scalar, scalar); }	
	public Vector3f divN(float x, float y, float z) { return clone().div(x, y, z); }
	public Vector3f divN(double x, double y, double z) { return clone().div(x, y, z); }

	
	
	
	public float squaredLength() { return this.x * this.x + this.y * this.y + this.z * this.z; }
	
	public float length() { return (float) Math.sqrt(squaredLength()); }
	
	public Vector3f normalize() { return Check.notNull(this) ? div(length()) : this; }
	
	public Vector3f normalized() { return clone().normalize(); }
	
	public Vector3f invert() { return mul(-1.0f); }
	
	public Vector3f inverted() { return clone().invert(); }
	
	public Vector3f inverse() { return new Vector3f(1.0f).div(this); }
	
	public Vector3f inversed() { return clone().inverse(); }
	
	public float dot(Vector3f v) { return this.x * v.x + this.y * v.y + this.z * v.z; }
	
	public Vector3f cross(Vector3f v) 
	{
		return new Vector3f(this.y * v.z - this.z * v.y, this.z * v.x - this.x * v.z, this.x * v.y - this.y * v.x);
	}

	public Vector3f project(Vector3f v)
	{	
		Vector3f vn = v.normalized();
		 float f = this.dot(vn);
		 
		 return vn.mul(f);
	}
	
	
	public Vector3f rot(Vector3f axis, float angle)
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
	
	public Vector3f rot(Quaternion q)
	{
		Quaternion conjugate = q.conjugated();
		Quaternion w = q.mulN(this).mulN(conjugate);

		return new Vector3f((float)w.getX(), (float)w.getY(), (float)w.getZ());
	}
	
	public Vector3f reflect(Vector3f normal)
	{
		float angle = dot(normal) *  2;
		
		this.x -= (angle) * normal.x;
		this.y -= (angle) * normal.y;
		this.y -= (angle) * normal.z;
		
		return this;
	}
	
	public Vector3f reflected(Vector3f normal)
	{
		Vector3f out = clone();
		
		out.reflect(normal);
		
		return out;
	}
	
	public Vector3f lerp(Vector3f v, float f)
	{
		this.x += (v.x - this.x) * f;
		this.y += (v.y - this.y) * f;
		this.z += (v.z - this.z) * f;
		
		return this;
	}
	
	public Vector3f lerped(Vector3f v, float f)
	{
		Vector3f out = clone();
		out.lerp(v, f);
		return out;
	}
	
	public float max() { return Math.max(this.x, Math.max(this.y, this.z)); }
	public float min() { return Math.min(this.x, Math.min(this.y, this.z)); }
	

	
	public Vector3f abs() { return set(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z)); }
	
	public Vector3f absN() { return clone().abs(); }	
	
	
	public Vector3f floor() { return set(Math.floor(this.x), Math.floor(this.y), Math.floor(this.z)); }
	public Vector3f ceil() { return set(Math.ceil(this.x), Math.ceil(this.y), Math.ceil(this.z));}
	public Vector3f round() { return set(Math.round(this.x), Math.round(this.y), Math.round(this.z)); }
	
	
	public Vector3f floorN() { return clone().floor(); }
	public Vector3f ceilN() { return clone().ceil(); }
	public Vector3f roundN() { return clone().round(); }
	
	
	
	public double angleRad(Vector3f v)
	{
		return Math.acos((dot(v)) / (length() * v.length()));
	}
	
	public double angleDeg(Vector3f v)
	{
		return angleRad(v) * Maths.RAD_TO_DEG;
	}

	
	
	public int getDimensions() { return Vector3f.DIMENSIONS; }
	
	
	
	public Vector3f clone() { return getNew(this); }
	
	public boolean equals(Vector3f v) { return this.x == v.x && this.y == v.y & this.z == v.z; }
	
	public String toString() { return "vector3f(" + this.x + "f, " + this.y + "f, " + this.z + "f)"; }
	

	
	public void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		this.x = dis.readFloat();
		this.y = dis.readFloat();
		this.z = dis.readFloat();
	}

	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeFloat(this.x);
		dos.writeFloat(this.y);
		dos.writeFloat(this.z);
	}

}
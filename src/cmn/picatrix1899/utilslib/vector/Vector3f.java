package cmn.picatrix1899.utilslib.vector;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cmn.picatrix1899.utilslib.essentials.Maths;
import cmn.picatrix1899.utilslib.essentials.Validate.Check;
import cmn.picatrix1899.utilslib.interfaces.DataHolder;

/**
 * A mathematical 3-dimensional vector of type float
 * 
 * @author picatrix1899
 *
 */
public class Vector3f implements DataHolder
{

	public static final short DIMENSIONS = 3;
	
	public static final Vector3f aX = new Vector3f(1.0f, 0.0f, 0.0f);
	public static final Vector3f aY = new Vector3f(0.0f, 1.0f, 0.0f);
	public static final Vector3f aZ = new Vector3f(0.0f, 0.0f, 1.0f);
	public static final Vector3f aNX = new Vector3f(-1.0f, 0.0f, 0.0f);
	public static final Vector3f aNY = new Vector3f(0.0f, -1.0f, 0.0f);
	public static final Vector3f aNZ = new Vector3f(0.0f, 0.0f, -1.0f);
	
	public static final int X = 0;
	public static final int Y = 1;
	public static final int Z = 2;
	
	public float x = 0.0f;
	public float y = 0.0f;
	public float z = 0.0f;
	
	

	public Vector3f()
	{
		this(0.0f, 0.0f, 0.0f);
	}
	
	private Vector3f(Vector3f v)
	{
		set(v);
	}
	
	public Vector3f(float x, float y, float z)
	{
		set(x, y, z);
	}
	
	
	
	public Vector3f set(Vector3f v) { return set(v.x, v.y, v.z); }
	
	public Vector3f set(float x, float y, float z) { return setX(x).setY(y).setZ(z); }

	public Vector3f setX(float x) { this.x = x; return this; }
	
	public Vector3f setY(float y) { this.y = y; return this; }

	public Vector3f setZ(float z) { this.z = z; return this; }
	
	

	public float getX() { return this.x; }

	public float getY() { return this.y; }

	public float getZ() { return this.z; }
	
	

	public static Vector3f add(Vector3f v1, Vector3f v2) { return Vector3f.add(v1, v2.x, v2.y, v2.z); }

	public static Vector3f add(Vector3f v1, float scalar) { return Vector3f.add(v1, scalar, scalar, scalar); }

	public static Vector3f add(Vector3f v1, float x, float y, float z) { return v1.add(x, y, z); }

	public static Vector3f sub(Vector3f v1, Vector3f v2) { return Vector3f.sub(v1, v2.x, v2.y, v2.z); }

	public static Vector3f sub(Vector3f v1, float scalar) { return Vector3f.sub(v1, scalar, scalar, scalar); }
	
	public static Vector3f sub(Vector3f v1, float x, float y, float z) { return v1.sub(x, y, z); }
	
	public static Vector3f mul(Vector3f v1, Vector3f v2) { return Vector3f.mul(v1, v2.x, v2.y, v2.z); }

	public static Vector3f mul(Vector3f v1, float scalar) { return Vector3f.mul(v1, scalar, scalar, scalar); }
	
	public static Vector3f mul(Vector3f v1, float x, float y, float z) { return v1.mul(x, y, z); }
	
	public static Vector3f div(Vector3f v1, Vector3f v2) { return Vector3f.div(v1, v2.x, v2.y, v2.z); }
	
	public static Vector3f div(Vector3f v1, float scalar) { return Vector3f.div(v1, scalar, scalar, scalar); }
	
	public static Vector3f div(Vector3f v1, float x, float y, float z) { return v1.div(x, y, z); }
	
	public static Vector3f pow(Vector3f v1, Vector3f v2) { return Vector3f.pow(v1, v2.x, v2.y, v2.z); }
	
	public static Vector3f pow(Vector3f v1, float scalar) { return Vector3f.pow(v1, scalar, scalar, scalar); }
	
	public static Vector3f pow(Vector3f v1, float x, float y, float z) { return v1.pow(x, y, z); }
	
	
	
	public static Vector3f addN(Vector3f v1, Vector3f v2) { return Vector3f.addN(v1, v2.x, v2.y, v2.z); }

	public static Vector3f addN(Vector3f v1, float scalar) { return Vector3f.addN(v1, scalar, scalar, scalar); }

	public static Vector3f addN(Vector3f v1, float x, float y, float z) { return v1.addN(x, y, z); }

	public static Vector3f subN(Vector3f v1, Vector3f v2) { return Vector3f.subN(v1, v2.x, v2.y, v2.z); }

	public static Vector3f subN(Vector3f v1, float scalar) { return Vector3f.subN(v1, scalar, scalar, scalar); }
	
	public static Vector3f subN(Vector3f v1, float x, float y, float z) { return v1.subN(x, y, z); }
	
	public static Vector3f mulN(Vector3f v1, Vector3f v2) { return Vector3f.mulN(v1, v2.x, v2.y, v2.z); }

	public static Vector3f mulN(Vector3f v1, float scalar) { return Vector3f.mulN(v1, scalar, scalar, scalar); }
	
	public static Vector3f mulN(Vector3f v1, float x, float y, float z) { return v1.mulN(x, y, z); }
	
	public static Vector3f divN(Vector3f v1, Vector3f v2) { return Vector3f.divN(v1, v2.x, v2.y, v2.z); }
	
	public static Vector3f divN(Vector3f v1, float scalar) { return Vector3f.divN(v1, scalar, scalar, scalar); }
	
	public static Vector3f divN(Vector3f v1, float x, float y, float z) { return v1.divN(x, y, z); }
	
	public static Vector3f powN(Vector3f v1, Vector3f v2) { return Vector3f.powN(v1, v2.x, v2.y, v2.z); }
	
	public static Vector3f powN(Vector3f v1, float scalar) { return Vector3f.powN(v1, scalar, scalar, scalar); }
	
	public static Vector3f powN(Vector3f v1, float x, float y, float z) { return v1.powN(x, y, z); }
	
	
	
	public static Vector3f addR(Vector3f v1, Vector3f v2, Vector3f v3) { return Vector3f.addR(v1, v2.x, v2.y, v2.z, v3); }
	
	public static Vector3f addR(Vector3f v1, float scalar, Vector3f v3) { return Vector3f.addR(v1, scalar, scalar, scalar, v3); }
	
	public static Vector3f addR(Vector3f v1, float x, float y, float z, Vector3f v3) { return v3.set(v1).add(x,y,z); }
	
	public static Vector3f subR(Vector3f v1, Vector3f v2, Vector3f v3) { return Vector3f.subR(v1, v2.x, v2.y, v2.z, v3); }
	
	public static Vector3f subR(Vector3f v1, float scalar, Vector3f v3) { return Vector3f.subR(v1, scalar, scalar, scalar, v3); }
	
	public static Vector3f subR(Vector3f v1, float x, float y, float z, Vector3f v3) { return v3.set(v1).sub(x,y,z); }
	
	public static Vector3f mulR(Vector3f v1, Vector3f v2, Vector3f v3) { return Vector3f.mulR(v1, v2.x, v2.y, v2.z, v3); }
	
	public static Vector3f mulR(Vector3f v1, float scalar, Vector3f v3) { return Vector3f.mulR(v1, scalar, scalar, scalar, v3); }
	
	public static Vector3f mulR(Vector3f v1, float x, float y, float z, Vector3f v3) { return v3.set(v1).mul(x,y,z); }
	
	public static Vector3f divR(Vector3f v1, Vector3f v2, Vector3f v3) { return Vector3f.divR(v1, v2.x, v2.y, v2.z, v3); }
	
	public static Vector3f divR(Vector3f v1, float scalar, Vector3f v3) { return Vector3f.divR(v1, scalar, scalar, scalar, v3); }
	
	public static Vector3f divR(Vector3f v1, float x, float y, float z, Vector3f v3) { return v3.set(v1).div(x,y,z); }
	
	public static Vector3f powR(Vector3f v1, Vector3f v2, Vector3f v3) { return Vector3f.powR(v1, v2.x, v2.y, v2.z, v3); }
	
	public static Vector3f powR(Vector3f v1, float scalar, Vector3f v3) { return Vector3f.powR(v1, scalar, scalar, scalar, v3); }
	
	public static Vector3f powR(Vector3f v1, float x, float y, float z, Vector3f v3) { return v3.set(v1).pow(x,y,z); }
	
	
	public static Vector3f max(Vector3f... v)
	{
		Vector3f out = new Vector3f();
		
		for(int i = 0; i < v.length; i++)
		{
			if(v[i].length() > out.length())
			{
				out = v[i];
			}
		}
			
		return out;
	}
	
	public static Vector3f maxVal(Vector3f...v)
	{
		Vector3f out = v[0].clone();
		
		for(int i = 1; i < v.length - 1; i++)
		{
			if(v[i].x > out.x) out.setX(v[i].x);
			if(v[i].y > out.y) out.setY(v[i].y);
			if(v[i].z > out.z) out.setZ(v[i].z);
		}
			
		return out;
	}
	
	
	public static Vector3f minVal(Vector3f...v)
	{
		Vector3f out = v[0].clone();
		
		for(int i = 1; i < v.length - 1; i++)
		{
			if(v[i].x < out.x) out.setX(v[i].x);
			if(v[i].y < out.y) out.setY(v[i].y);
			if(v[i].z < out.z) out.setZ(v[i].z);
		}
			
		return out;
	}
	
	
	public Vector3f add(Vector3f v) { return add(v.x, v.y,v.z); }
	
	public Vector3f add(float scalar) { return add(scalar, scalar, scalar); }
	
	public Vector3f add(float x, float y, float z) { return setX(this.x + x).setY(this.y + y).setZ(this.z + z); }
	
	public Vector3f add(double scalar) { return add(scalar, scalar, scalar); }
	
	public Vector3f add(double x, double y, double z) { return setX((float)(this.x + x)).setY((float)(this.y + y)).setZ((float)(this.z + z)); }

	public Vector3f sub(Vector3f v) { return sub(v.x, v.y,v.z); }
	
	public Vector3f sub(float scalar) { return sub(scalar, scalar, scalar); }
	
	public Vector3f sub(float x, float y, float z) { return setX(this.x - x).setY(this.y - y).setZ(this.z - z); }
	
	public Vector3f sub(double scalar) { return sub(scalar, scalar, scalar); }
	
	public Vector3f sub(double x, double y, double z) { return setX((float)(this.x - x)).setY((float)(this.y - y)).setZ((float)(this.z - z)); }
	
	public Vector3f mul(Vector3f v) { return mul(v.x, v.y,v.z); }
	
	public Vector3f mul(float scalar) { return mul(scalar, scalar, scalar); }
	
	public Vector3f mul(float x, float y, float z) { return setX(this.x * x).setY(this.y * y).setZ(this.z * z); }
	
	public Vector3f mul(double scalar) { return mul(scalar, scalar, scalar); }
	
	public Vector3f mul(double x, double y, double z) { return setX((float)(this.x * x)).setY((float)(this.y * y)).setZ((float)(this.z * z)); }
	
	public Vector3f div(Vector3f v) { return div(v.x, v.y,v.z); }
		
	public Vector3f div(float scalar) { return div(scalar, scalar, scalar); }
	
	public Vector3f div(float x, float y, float z) { return setX(this.x / x).setY(this.y / y).setZ(this.z / z); }
	
	public Vector3f div(double scalar) { return div(scalar, scalar, scalar); }
	
	public Vector3f div(double x, double y, double z) { return setX((float)(this.x / x)).setY((float)(this.y / y)).setZ((float)(this.z / z)); }
	
	public Vector3f pow(Vector3f v) {return pow(v.x, v.y, v.z); }
	
	public Vector3f pow(float scalar) { return pow(scalar, scalar, scalar); }
	
	public Vector3f pow(float x, float y, float z) { return setX((float) Math.pow(this.x, x)).setY((float) Math.pow(this.y, y)).setZ((float) Math.pow(this.z, z)); }
	
	public Vector3f pow(double scalar) { return pow(scalar, scalar, scalar); }
	
	public Vector3f pow(double x, double y, double z) { return setX((float) Math.pow(this.x, x)).setY((float) Math.pow(this.y, y)).setZ((float) Math.pow(this.z, z)); }
	
	
	public Vector3f addN(Vector3f v) { return addN(v.x, v.y, v.z); }
	
	public Vector3f addN(float scalar) { return addN(scalar, scalar, scalar); }
	
	public Vector3f addN(float x, float y, float z) { return clone().add(x, y, z); }
	
	public Vector3f addN(double scalar) { return addN(scalar, scalar, scalar); }
	
	public Vector3f addN(double x, double y, double z) { return clone().add(x, y, z); }
	
	public Vector3f subN(Vector3f v) { return subN(v.x, v.y, v.z); }
	
	public Vector3f subN(float scalar) { return subN(scalar, scalar, scalar); }
	
	public Vector3f subN(float x, float y, float z) { return clone().sub(x, y, z); }
	
	public Vector3f subN(double scalar) { return subN(scalar, scalar, scalar); }
	
	public Vector3f subN(double x, double y, double z) { return clone().sub(x, y, z); }
	
	public Vector3f mulN(Vector3f v) { return mulN(v.x, v.y, v.z); }
	
	public Vector3f mulN(float scalar) { return mulN(scalar, scalar, scalar); }
	
	public Vector3f mulN(float x, float y, float z) { return clone().mul(x, y, z); }
	
	public Vector3f mulN(double scalar) { return mulN(scalar, scalar, scalar); }
	
	public Vector3f mulN(double x, double y, double z) { return clone().mul(x, y, z); }
	
	public Vector3f divN(Vector3f v) { return divN(v.x, v.y, v.z); }
	
	public Vector3f divN(float scalar) { return divN(scalar, scalar, scalar); }
	
	public Vector3f divN(float x, float y, float z) { return clone().div(x, y, z); }
	
	public Vector3f divN(double scalar) { return divN(scalar, scalar, scalar); }
	
	public Vector3f divN(double x, double y, double z) { return clone().div(x, y, z); }
	
	public Vector3f powN(Vector3f v) { return powN(v.x, v.y, v.z); }
	
	public Vector3f powN(float scalar) { return powN(scalar, scalar, scalar); }
	
	public Vector3f powN(float x, float y, float z) { return clone().pow(x, y, z); }
	
	public Vector3f powN(double scalar) { return powN(scalar, scalar, scalar); }
	
	public Vector3f powN(double x, double y, double z) { return clone().pow(x, y, z); }
	
	
	
	public Vector3f addR(Vector3f v, Vector3f v2) { return addR(v.x, v.y, v.z, v2); }
	
	public Vector3f addR(float scalar, Vector3f v2) { return addR(scalar, scalar, scalar, v2); }
	
	public Vector3f addR(float x, float y, float z, Vector3f v2) { return v2.set(this).add(x, y, z); }
	
	public Vector3f addR(double scalar, Vector3f v2) { return addR(scalar, scalar, scalar, v2); }
	
	public Vector3f addR(double x, double y, double z, Vector3f v2) { return v2.set(this).add(x, y, z); }

	public Vector3f subR(Vector3f v, Vector3f v2) { return subR(v.x, v.y, v.z, v2); }
	
	public Vector3f subR(float scalar, Vector3f v2) { return subR(scalar, scalar, scalar, v2); }
	
	public Vector3f subR(float x, float y, float z, Vector3f v2) { return v2.set(this).sub(x, y, z); }
	
	public Vector3f subR(double scalar, Vector3f v2) { return subR(scalar, scalar, scalar, v2); }
	
	public Vector3f subR(double x, double y, double z, Vector3f v2) { return v2.set(this).sub(x, y, z); }
	
	public Vector3f mulR(Vector3f v, Vector3f v2) { return mulR(v.x, v.y, v.z, v2); }
	
	public Vector3f mulR(float scalar, Vector3f v2) { return mulR(scalar, scalar, scalar, v2); }
	
	public Vector3f mulR(float x, float y, float z, Vector3f v2) { return v2.set(this).mul(x, y, z); }
	
	public Vector3f mulR(double scalar, Vector3f v2) { return mulR(scalar, scalar, scalar, v2); }
	
	public Vector3f mulR(double x, double y, double z, Vector3f v2) { return v2.set(this).mul(x, y, z); }
	
	public Vector3f divR(Vector3f v, Vector3f v2) { return divR(v.x, v.y, v.z, v2); }
	
	public Vector3f divR(float scalar, Vector3f v2) { return divR(scalar, scalar, scalar, v2); }
	
	public Vector3f divR(float x, float y, float z, Vector3f v2) { return v2.set(this).div(x, y, z); }
	
	public Vector3f divR(double scalar, Vector3f v2) { return divR(scalar, scalar, scalar, v2); }
	
	public Vector3f divR(double x, double y, double z, Vector3f v2) { return v2.set(this).div(x, y, z); }
	
	public Vector3f powR(Vector3f v, Vector3f v2) {return powR(v.x, v.y, v.z, v2); }
	
	public Vector3f powR(float scalar, Vector3f v2) { return powR(scalar, scalar, scalar, v2); }
	
	public Vector3f powR(float x, float y, float z, Vector3f v2) { return v2.set(this).pow(x, y, z); }
	
	public Vector3f powR(double scalar, Vector3f v2) { return powR(scalar, scalar, scalar, v2); }
	
	public Vector3f powR(double x, double y, double z, Vector3f v2) { return v2.set(this).pow(x, y, z); }
	
	
	
	public float length() { return (float) Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z); }
	
	public Vector3f normalize() { return Check.notNull(this) ? div(length()) : this; }
	
	public Vector3f normalized() { return clone().normalize(); }
	
	public Vector3f invert() { return mul(-1.0f); }
	
	public Vector3f invert(boolean x, boolean y, boolean z) { return mul(x ? -1.0f : 1.0f, y ? -1.0f : 1.0f, z ? -1.0f : 1.0f); }
	
	public Vector3f invertX() { return invert(true, false, false); }
	
	public Vector3f invertY() { return invert(false, true, false); }
	
	public Vector3f invertZ() { return invert(false, false, true); }
	
	public Vector3f inverted() { return clone().invert(); }
	
	public Vector3f inverted(boolean x, boolean y, boolean z) {return clone().invert(x, y, z); }
	
	public Vector3f invertedX() { return clone().invertX(); }
	
	public Vector3f invertedY() { return clone().invertY(); }
	
	public Vector3f invertedZ() { return clone().invertZ(); }
	
	public float dot(Vector3f v) { return this.x * v.x + this.y * v.y + this.z * v.z; }
	
	public Vector3f cross(Vector3f v) 
	{
		return new Vector3f(this.y * v.z - this.z * v.y, this.z * v.x - this.x * v.z, this.x * v.y - this.y * v.x);
	}
	
	public Vector3f lerp(Vector3f dest, float factor) { return dest.subN(this).mul(factor).add(this); }
	
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
	
	
	public float max()
	{
		return Math.max(this.x, Math.max(this.y, this.z));
	}
	
	public float min() { return Math.min(this.x, Math.min(this.y, this.z)); }
	
	public Vector3f abs() { return abs(true, true, true); }
	
	public Vector3f abs(boolean x, boolean y, boolean z)
	{
		setX(x ? (float) Math.abs(this.x) : this.x);
		setY(y ? (float) Math.abs(this.y) : this.y);
		setZ(z ? (float) Math.abs(this.z) : this.z);
		
		return this;
	}
	
	public Vector3f absX() { return abs(true, false, false); }
	
	public Vector3f absY() { return abs(false, true, false); }
	
	public Vector3f absZ() { return abs(false, false, true); }
	
	public Vector3f floor() { return floor(true, true, true); }
	
	public Vector3f floor(boolean x, boolean y, boolean z)
	{
		setX(x ? (float) Math.floor(this.x) : this.x);
		setY(y ? (float) Math.floor(this.y) : this.y);
		setZ(z ? (float) Math.floor(this.z) : this.z);
		
		return this;
	}
	
	public Vector3f floorX() { return floor(true, false, false); }
	
	public Vector3f floorY() { return floor(false, true, false); }
	
	public Vector3f floorZ() { return floor(false, false, true); }
	
	public Vector3f ceil() { return ceil(true, true, true); }
	
	public Vector3f ceil(boolean x, boolean y, boolean z)
	{
		setX(x ? (float) Math.ceil(this.x) : this.x);
		setY(y ? (float) Math.ceil(this.y) : this.y);
		setZ(z ? (float) Math.ceil(this.z) : this.z);
		
		return this;
	}
	
	public Vector3f ceilX() { return ceil(true, false, false); }
	
	public Vector3f ceilY() { return ceil(false, true, false); }
	
	public Vector3f ceilZ() { return ceil(false, false, true); }
	
	public Vector3f round() { return round(true, true, true); }
	
	public Vector3f round(boolean x, boolean y, boolean z)
	{
		setX(x ? (float) Math.round(this.x) : this.x);
		setY(y ? (float) Math.round(this.y) : this.y);
		setZ(z ? (float) Math.round(this.z) : this.z);
		
		return this;
	}
	
	public Vector3f roundX() { return round(true, false, false); }
	
	public Vector3f roundY() { return round(false, true, false); }
	
	public Vector3f roundZ() { return round(false, false, true); }
	
	

	public Vector3f absN() { return clone().abs(); }
	
	public Vector3f absN(boolean x, boolean y, boolean z) { return clone().round(x, y, z); }
	
	public Vector3f absXN() { return clone().absX(); }
	
	public Vector3f absYN() { return clone().absY(); }
	
	public Vector3f absZN() { return clone().absZ(); }
	
	public Vector3f floorN() { return clone().floor(); }
	
	public Vector3f floorN(boolean x, boolean y, boolean z) { return clone().round(x, y, z); }
	
	public Vector3f floorXN() { return clone().floorX(); }
	
	public Vector3f floorYN() { return clone().floorY(); }
	
	public Vector3f floorZN() { return clone().floorZ(); }
	
	public Vector3f ceilN() { return clone().ceil(); }
	
	public Vector3f ceilN(boolean x, boolean y, boolean z) { return clone().ceil(x, y, z); }
	
	public Vector3f ceilXN() { return clone().ceilX(); }
	
	public Vector3f ceilYN() { return clone().ceilY(); }
	
	public Vector3f ceilZN() { return clone().ceilZ(); }

	public Vector3f roundN() { return clone().round(); }
	
	public Vector3f roundN(boolean x, boolean y, boolean z) { return clone().round(x, y, z); }
	
	public Vector3f roundXN() { return clone().roundX(); }
	
	public Vector3f roundYN() { return clone().roundY(); }
	
	public Vector3f roundZN() { return clone().roundZ(); }
	
	public double angleRad(Vector3f v)
	{
		return Math.acos((dot(v)) / (length() * v.length()));
	}
	
	public double angleDeg(Vector3f v)
	{
		return angleRad(v) * Maths.RAD_TO_DEG;
	}

	
	
	public int getDimensions() { return Vector3f.DIMENSIONS; }
	
	public float getOrdinal(int index)
	{
		if(index < 0 || index >= getDimensions()) throw new IndexOutOfBoundsException();
		
		switch(index)
		{
			case 0: { return this.x; }
			case 1: { return this.y; }
			case 2: { return this.z; }
			
			default: return Float.NaN;
		}
	}
	
	public float[] ordinal() { return new float[] { this.x, this.y, this.z }; }
	
	public Vector3f setOrdinal(int index, float val)
	{
		if(index < 0 || index >= getDimensions()) throw new IndexOutOfBoundsException();
		
		switch(index)
		{
			case 0: { return setX(val); }
			case 1: { return setY(val); }
			case 2: { return setZ(val); }
			
			default: return this;
		}
	}
	
	
	
	public Vector3f clone() { return new Vector3f(this); }
	
	public boolean equals(Vector3f v) { return this.x == v.x && this.y == v.y & this.z == v.z; }
	
	public String toString() { return "vec3f(" + this.x + "f, " + this.y + "f, " + this.z + "f)"; }
	

	
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
package cmn.picatrix1899.utilslib.vector;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cmn.picatrix1899.utilslib.interfaces.DataHolder;

/**
 * A mathematical 4-dimensional vector of type float
 * 
 * @author picatrix1899
 *
 */
public class Vector4f extends Vector3f implements DataHolder
{
	public static final int DIMENSIONS = 4;
	
	private float w = 0;
	
	public Vector4f()
	{
		this(0,0,0,0);
	}
	
	private Vector4f(Vector4f v)
	{
		this(v.getX(), v.getY(), v.getZ(), v.getW());
	}	
	
	public Vector4f(float x, float y, float z, float w)
	{
		super(x, y, z);
		this.w = w;
	}
	
	public Vector4f setX(float x) { super.setX(x); return this; }
	
	public Vector4f setY(float y) { super.setY(y); return this; }
	
	public Vector4f setZ(float z) { super.setZ(z); return this; }
	
	public Vector4f setW(float w) { this.w = w; return this; }
	
	
	
	public float getX() { return super.getX(); }
	
	public float getY() { return super.getY(); }
	
	public float getZ() { return super.getZ(); }
	
	public float getW() {return this.w; }
	
	
	
	public static Vector4f add(Vector4f v1, Vector4f v2) { return Vector4f.add(v1, v2.getX(), v2.getY(), v2.getZ(), v2.getW()); }
	
	public static Vector4f add(Vector4f v1, float scalar) { return Vector4f.add(v1, scalar, scalar, scalar, scalar); }
	
	public static Vector4f add(Vector4f v1, float x, float y, float z, float w) { return v1.addN(x, y, z, w); }
	
	public static Vector4f sub(Vector4f v1, Vector4f v2) { return Vector4f.sub(v1, v2.getX(), v2.getY(), v2.getZ(), v2.getW()); }
	
	public static Vector4f sub(Vector4f v1, float scalar) { return Vector4f.sub(v1, scalar, scalar, scalar, scalar); }
	
	public static Vector4f sub(Vector4f v1, float x, float y, float z, float w) { return v1.subN(x, y, z, w); }
	
	public static Vector4f mul(Vector4f v1, Vector4f v2) { return Vector4f.mul(v1, v2.getX(), v2.getY(), v2.getZ(), v2.getW()); }
	
	public static Vector4f mul(Vector4f v1, float scalar) { return Vector4f.mul(v1, scalar, scalar, scalar, scalar); }
	
	public static Vector4f mul(Vector4f v1, float x, float y, float z, float w) { return v1.mulN(x, y, z, w); }
	
	public static Vector4f div(Vector4f v1, Vector4f v2) { return Vector4f.div(v1, v2.getX(), v2.getY(), v2.getZ(), v2.getW()); }
	
	public static Vector4f div(Vector4f v1, float scalar) { return Vector4f.div(v1, scalar, scalar, scalar, scalar); }
	
	public static Vector4f div(Vector4f v1, float x, float y, float z, float w) { return v1.divN(x, y, z, w); }
	
	public static Vector4f pow(Vector4f v1, Vector4f v2) { return Vector4f.pow(v1, v2.getX(), v2.getY(), v2.getZ(), v2.getW()); }
	
	public static Vector4f pow(Vector4f v1, float scalar) { return Vector4f.pow(v1, scalar, scalar, scalar, scalar); }
	
	public static Vector4f pow(Vector4f v1, float x, float y, float z, float w) { return v1.powN(x, y, z, w); }
	
	
	
	public Vector4f add(Vector4f v) { return add(v.getX(), v.getY(), v.getZ(), v.getW()); }
	
	public Vector4f add(float scalar) { return add(scalar, scalar, scalar, scalar); }
	
	public Vector4f add(float x, float y, float z, float w) { return setX(getX() + x).setY(getY() + y).setZ(getZ() + z).setW(getW() + w); }

	public Vector4f sub(Vector4f v) { return sub(v.getX(), v.getY(), v.getZ(), v.getW()); }
	
	public Vector4f sub(float scalar) { return sub(scalar, scalar, scalar, scalar); }
	
	public Vector4f sub(float x, float y, float z, float w) { return setX(getX() - x).setY(getY() - y).setZ(getZ() - z).setW(getW() - w); }
	
	public Vector4f mul(Vector4f v) { return mul(v.getX(), v.getY(), v.getZ(), v.getW()); }
	
	public Vector4f mul(float scalar) { return mul(scalar, scalar, scalar, scalar); }
	
	public Vector4f mul(float x, float y, float z, float w) { return setX(getX() * x).setY(getY() * y).setZ(getZ() * z).setW(getW() * w); }
	
	public Vector4f div(Vector4f v) { return div(v.getX(), v.getY(), v.getZ(), v.getW()); }
	
	public Vector4f div(float scalar) { return div(scalar, scalar, scalar, scalar); }
	
	public Vector4f div(float x, float y, float z, float w) { return setX(getX() / x).setY(getY() / y).setZ(getZ() / z).setW(getW() / w); }
	
	public Vector4f pow(Vector4f v) {return pow(v.getX(), v.getY(), v.getZ(), v.getW()); }
	
	public Vector4f pow(float scalar) { return pow(scalar, scalar, scalar, scalar); }
	
	public Vector4f pow(float x, float y, float z, float w)
	{
		return setX((float) Math.pow(getX(), x)).setY((float) Math.pow(getY(), y)).setZ((float) Math.pow(getZ(), z)).setW((float) Math.pow(getW(), w));
	}
	
	
	
	
	public Vector4f addN(Vector4f v) { return addN(v.getX(), v.getY(), v.getZ(), v.getW()); }
	
	public Vector4f addN(float scalar) { return addN(scalar, scalar, scalar, scalar); }
	
	public Vector4f addN(float x, float y, float z, float w) { return clone().add(x, y, z, w); }
	
	public Vector4f subN(Vector4f v) { return subN(v.getX(), v.getY(), v.getZ(), v.getW()); }
	
	public Vector4f subN(float scalar) { return subN(scalar, scalar, scalar, scalar); }
	
	public Vector4f subN(float x, float y, float z, float w) { return clone().sub(x, y, z, w); }
	
	public Vector4f mulN(Vector4f v) { return mulN(v.getX(), v.getY(), v.getZ(), v.getW()); }
	
	public Vector4f mulN(float scalar) { return mulN(scalar, scalar, scalar, scalar); }
	
	public Vector4f mulN(float x, float y, float z, float w) { return clone().mul(x, y, z, w); }
	
	public Vector4f divN(Vector4f v) { return divN(v.getX(), v.getY(), v.getZ(), v.getW()); }
	
	public Vector4f divN(float scalar) { return divN(scalar, scalar, scalar, scalar); }
	
	public Vector4f divN(float x, float y, float z, float w) { return clone().div(x, y, z, w); }
	
	public Vector4f powN(Vector4f v) { return powN(v.getX(), v.getY(), v.getZ(), v.getW()); }
	
	public Vector4f powN(float scalar) { return powN(scalar, scalar, scalar ,scalar); }
	
	public Vector4f powN(float x, float y, float z, float w) { return clone().pow(x, y, z, w); }
	
	
	
	public float dot(Vector4f v) { return getX() * v.getX() + getY() * v.getY() + getZ() + v.getZ() + getW() + v.getW(); }
	
	public float length() { return (float) Math.sqrt(getX() * getX() + getY() * getY() + getZ() * getZ() + getW() * getW()); }
	
	public Vector4f normalize() { return div(length()); }
	
	public Vector4f normalized() { return clone().normalize(); }
	
	public Vector4f invert() { return mul(-1); }
	
	public Vector4f invert(boolean x, boolean y, boolean z, boolean w) { return mul(x ? -1 : 1, y ? -1 : 1, z ? -1 : 1, w ? -1 : 1); }
	
	public Vector4f invertX() { return invert(true, false, false, false); }
	
	public Vector4f invertY() { return invert(false, true, false, false); }
	
	public Vector4f invertZ() { return invert(false, false, true, false); }
	
	public Vector4f invertW() { return invert(false, false, false, true); }
	
	public Vector4f inverted() { return clone().invert(); }
	
	public Vector4f inverted(boolean x, boolean y, boolean z, boolean w) {return clone().invert(x, y, z, w); }
	
	public Vector4f invertedX() { return clone().invertX(); }
	
	public Vector4f invertedY() { return clone().invertY(); }
	
	public Vector4f invertedZ() { return clone().invertZ(); }
	
	public Vector4f invertedW() { return clone().invertW(); }
	
	public float max() { return Math.max(getX(), Math.max(getY(), Math.max(getZ(), getW()))); }
	
	public float min() { return Math.min(getX(), Math.min(getY(), Math.min(getZ(), getW()))); }
	
	
	
	public Vector4f abs() { return abs(true, true, true, true); }
	
	public Vector4f abs(boolean x, boolean y, boolean z, boolean w)
	{
		setX(x ? (float) Math.abs(getX()) : getX());
		setY(y ? (float) Math.abs(getY()) : getY());
		setZ(z ? (float) Math.abs(getZ()) : getZ());
		setW(w ? (float) Math.abs(getW()) : getW());
		
		return this;
	}
	
	public Vector4f absX() { return abs(true, false, false, false); }
	
	public Vector4f absY() { return abs(false, true, false, false); }
	
	public Vector4f absZ() { return abs(false, false, true, false); }
	
	public Vector4f absW() { return abs(false, false, false, true); }
	
	public Vector4f floor() { return floor(true, true, true, true); }
	
	public Vector4f floor(boolean x, boolean y, boolean z, boolean w)
	{
		setX(x ? (float) Math.floor(getX()) : getX());
		setY(y ? (float) Math.floor(getY()) : getY());
		setZ(z ? (float) Math.floor(getZ()) : getZ());
		setW(w ? (float) Math.floor(getW()) : getW());
		
		return this;
	}
	
	public Vector4f floorX() { return floor(true, false, false, false); }
	
	public Vector4f floorY() { return floor(false, true, false, false); }
	
	public Vector4f floorZ() { return floor(false, false, true, false); }
	
	public Vector4f floorW() { return floor(false, false, false, true); }
	
	public Vector4f ceil() { return ceil(true, true, true, true); }
	
	public Vector4f ceil(boolean x, boolean y, boolean z, boolean w)
	{
		setX(x ? (float) Math.ceil(getX()) : getX());
		setY(y ? (float) Math.ceil(getY()) : getY());
		setZ(z ? (float) Math.ceil(getZ()) : getZ());
		
		return this;
	}
	
	public Vector4f ceilX() { return ceil(true, false, false, false); }
	
	public Vector4f ceilY() { return ceil(false, true, false, false); }
	
	public Vector4f ceilZ() { return ceil(false, false, true, false); }
	
	public Vector4f ceilW() { return ceil(false, false, false, true); }
	
	public Vector4f round() { return round(true, true, true, true); }
	
	public Vector4f round(boolean x, boolean y, boolean z, boolean w)
	{
		setX(x ? (float) Math.round(getX()) : getX());
		setY(y ? (float) Math.round(getY()) : getY());
		setZ(z ? (float) Math.round(getZ()) : getZ());
		setW(w ? (float) Math.round(getW()) : getW());
		
		return this;
	}
	
	public Vector4f roundX() { return round(true, false, false, false); }
	
	public Vector4f roundY() { return round(false, true, false, false); }
	
	public Vector4f roundZ() { return round(false, false, true, false); }
	
	public Vector4f roundW() { return round(false, false, false, true); }
	
	

	public Vector4f absN() { return clone().abs(); }
	
	public Vector4f absN(boolean x, boolean y, boolean z, boolean w) { return clone().round(x, y, z, w); }
	
	public Vector4f absXN() { return clone().absX(); }
	
	public Vector4f absYN() { return clone().absY(); }
	
	public Vector4f absZN() { return clone().absZ(); }
	
	public Vector4f absWN() { return clone().absW(); }
	
	public Vector4f floorN() { return clone().floor(); }
	
	public Vector4f floorN(boolean x, boolean y, boolean z, boolean w) { return clone().round(x, y, z, w); }
	
	public Vector4f floorXN() { return clone().floorX(); }
	
	public Vector4f floorYN() { return clone().floorY(); }
	
	public Vector4f floorZN() { return clone().floorZ(); }
	
	public Vector4f floorWN() { return clone().floorW(); }
	
	public Vector4f ceilN() { return clone().ceil(); }
	
	public Vector4f ceilN(boolean x, boolean y, boolean z, boolean w) { return clone().ceil(x, y, z, w); }
	
	public Vector4f ceilXN() { return clone().ceilX(); }
	
	public Vector4f ceilYN() { return clone().ceilY(); }
	
	public Vector4f ceilZN() { return clone().ceilZ(); }
	
	public Vector4f ceilWN() { return clone().ceilW(); }

	public Vector4f roundN() { return clone().round(); }
	
	public Vector4f roundN(boolean x, boolean y, boolean z, boolean w) { return clone().round(x, y, z, w); }
	
	public Vector4f roundXN() { return clone().roundX(); }
	
	public Vector4f roundYN() { return clone().roundY(); }
	
	public Vector4f roundZN() { return clone().roundZ(); }
	
	public Vector4f roundWN() { return clone().roundW(); }
	
	
	
	public Vector4f clone() { return new Vector4f(this); }
	
	public boolean equals(Vector4f v) { return getX() == v.getX() && getY() == v.getY() && getZ() == v.getZ() && getW() == v.getW(); }
	
	public String toString() { return "vec4f(" + getX() + "f, " + getY() + "f, " + getZ() + "f, " + getW() + "f)"; }
	
	
	
	public void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		setX(dis.readFloat());
		setY(dis.readFloat());
		setZ(dis.readFloat());
		setW(dis.readFloat());
	}

	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeFloat(getX());
		dos.writeFloat(getY());
		dos.writeFloat(getZ());
		dos.writeFloat(getW());
	}
	
}

package cmn.picatrix1899.utilslib.vector;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cmn.picatrix1899.utilslib.interfaces.DataHolder;

/**
 * A mathematical 4-dimensional vector of type double
 * 
 * @author picatrix1899
 *
 */
public class Vector4d extends Vector3d implements DataHolder
{
	
	public static final int DIMENSIONS = 4;
	
	private double w = 0;
	
	public Vector4d()
	{
		this(0,0,0,0);
	}
	
	private Vector4d(Vector4d v)
	{
		this(v.getX(), v.getY(), v.getZ(), v.getW());
	}	
	
	public Vector4d(double x, double y, double z, double w)
	{
		super(x, y, z);
		this.w = w;
	}
	
	public Vector4d setX(double x) { super.setX(x); return this; }
	
	public Vector4d setY(double y) { super.setY(y); return this; }
	
	public Vector4d setZ(double z) { super.setZ(z); return this; }
	
	public Vector4d setW(double w) { this.w = w; return this; }
	
	
	
	public double getX() { return super.getX(); }
	
	public double getY() { return super.getY(); }
	
	public double getZ() { return super.getZ(); }
	
	public double getW() {return this.w; }
	
	
	
	public static Vector4d add(Vector4d v1, Vector4d v2) { return Vector4d.add(v1, v2.getX(), v2.getY(), v2.getZ(), v2.getW()); }
	
	public static Vector4d add(Vector4d v1, double scalar) { return Vector4d.add(v1, scalar, scalar, scalar, scalar); }
	
	public static Vector4d add(Vector4d v1, double x, double y, double z, double w) { return v1.addN(x, y, z, w); }
	
	public static Vector4d sub(Vector4d v1, Vector4d v2) { return Vector4d.sub(v1, v2.getX(), v2.getY(), v2.getZ(), v2.getW()); }
	
	public static Vector4d sub(Vector4d v1, double scalar) { return Vector4d.sub(v1, scalar, scalar, scalar, scalar); }
	
	public static Vector4d sub(Vector4d v1, double x, double y, double z, double w) { return v1.subN(x, y, z, w); }
	
	public static Vector4d mul(Vector4d v1, Vector4d v2) { return Vector4d.mul(v1, v2.getX(), v2.getY(), v2.getZ(), v2.getW()); }
	
	public static Vector4d mul(Vector4d v1, double scalar) { return Vector4d.mul(v1, scalar, scalar, scalar, scalar); }
	
	public static Vector4d mul(Vector4d v1, double x, double y, double z, double w) { return v1.mulN(x, y, z, w); }
	
	public static Vector4d div(Vector4d v1, Vector4d v2) { return Vector4d.div(v1, v2.getX(), v2.getY(), v2.getZ(), v2.getW()); }
	
	public static Vector4d div(Vector4d v1, double scalar) { return Vector4d.div(v1, scalar, scalar, scalar, scalar); }
	
	public static Vector4d div(Vector4d v1, double x, double y, double z, double w) { return v1.divN(x, y, z, w); }
	
	public static Vector4d pow(Vector4d v1, Vector4d v2) { return Vector4d.pow(v1, v2.getX(), v2.getY(), v2.getZ(), v2.getW()); }
	
	public static Vector4d pow(Vector4d v1, double scalar) { return Vector4d.pow(v1, scalar, scalar, scalar, scalar); }
	
	public static Vector4d pow(Vector4d v1, double x, double y, double z, double w) { return v1.powN(x, y, z, w); }
	
	
	
	public Vector4d add(Vector4d v) { return add(v.getX(), v.getY(), v.getZ(), v.getW()); }
	
	public Vector4d add(double scalar) { return add(scalar, scalar, scalar, scalar); }
	
	public Vector4d add(double x, double y, double z, double w) { return setX(getX() + x).setY(getY() + y).setZ(getZ() + z).setW(getW() + w); }

	public Vector4d sub(Vector4d v) { return sub(v.getX(), v.getY(), v.getZ(), v.getW()); }
	
	public Vector4d sub(double scalar) { return sub(scalar, scalar, scalar, scalar); }
	
	public Vector4d sub(double x, double y, double z, double w) { return setX(getX() - x).setY(getY() - y).setZ(getZ() - z).setW(getW() - w); }
	
	public Vector4d mul(Vector4d v) { return mul(v.getX(), v.getY(), v.getZ(), v.getW()); }
	
	public Vector4d mul(double scalar) { return mul(scalar, scalar, scalar, scalar); }
	
	public Vector4d mul(double x, double y, double z, double w) { return setX(getX() * x).setY(getY() * y).setZ(getZ() * z).setW(getW() * w); }
	
	public Vector4d div(Vector4d v) { return div(v.getX(), v.getY(), v.getZ(), v.getW()); }
	
	public Vector4d div(double scalar) { return div(scalar, scalar, scalar, scalar); }
	
	public Vector4d div(double x, double y, double z, double w) { return setX(getX() / x).setY(getY() / y).setZ(getZ() / z).setW(getW() / w); }
	
	public Vector4d pow(Vector4d v) {return pow(v.getX(), v.getY(), v.getZ(), v.getW()); }
	
	public Vector4d pow(double scalar) { return pow(scalar, scalar, scalar, scalar); }
	
	public Vector4d pow(double x, double y, double z, double w)
	{
		return setX(Math.pow(getX(), x)).setY(Math.pow(getY(), y)).setZ(Math.pow(getZ(), z)).setW(Math.pow(getW(), w));
	}
	
	
	
	
	public Vector4d addN(Vector4d v) { return addN(v.getX(), v.getY(), v.getZ(), v.getW()); }
	
	public Vector4d addN(double scalar) { return addN(scalar, scalar, scalar, scalar); }
	
	public Vector4d addN(double x, double y, double z, double w) { return clone().add(x, y, z, w); }
	
	public Vector4d subN(Vector4d v) { return subN(v.getX(), v.getY(), v.getZ(), v.getW()); }
	
	public Vector4d subN(double scalar) { return subN(scalar, scalar, scalar, scalar); }
	
	public Vector4d subN(double x, double y, double z, double w) { return clone().sub(x, y, z, w); }
	
	public Vector4d mulN(Vector4d v) { return mulN(v.getX(), v.getY(), v.getZ(), v.getW()); }
	
	public Vector4d mulN(double scalar) { return mulN(scalar, scalar, scalar, scalar); }
	
	public Vector4d mulN(double x, double y, double z, double w) { return clone().mul(x, y, z, w); }
	
	public Vector4d divN(Vector4d v) { return divN(v.getX(), v.getY(), v.getZ(), v.getW()); }
	
	public Vector4d divN(double scalar) { return divN(scalar, scalar, scalar, scalar); }
	
	public Vector4d divN(double x, double y, double z, double w) { return clone().div(x, y, z, w); }
	
	public Vector4d powN(Vector4d v) { return powN(v.getX(), v.getY(), v.getZ(), v.getW()); }
	
	public Vector4d powN(double scalar) { return powN(scalar, scalar, scalar ,scalar); }
	
	public Vector4d powN(double x, double y, double z, double w) { return clone().pow(x, y, z, w); }
	
	
	
	
	
	public double length() { return Math.sqrt(getX() * getX() + getY() * getY() + getZ() * getZ() + getW() * getW()); }
	
	public Vector4d normalize() { return div(length()); }
	
	public Vector4d normalized() { return clone().normalize(); }
	
	public Vector4d invert() { return mul(-1); }
	
	public Vector4d invert(boolean x, boolean y, boolean z, boolean w) { return mul(x ? -1 : 1, y ? -1 : 1, z ? -1 : 1, w ? -1 : 1); }
	
	public Vector4d invertX() { return invert(true, false, false, false); }
	
	public Vector4d invertY() { return invert(false, true, false, false); }
	
	public Vector4d invertZ() { return invert(false, false, true, false); }
	
	public Vector4d invertW() { return invert(false, false, false, true); }
	
	public Vector4d inverted() { return clone().invert(); }
	
	public Vector4d inverted(boolean x, boolean y, boolean z, boolean w) {return clone().invert(x, y, z, w); }
	
	public Vector4d invertedX() { return clone().invertX(); }
	
	public Vector4d invertedY() { return clone().invertY(); }
	
	public Vector4d invertedZ() { return clone().invertZ(); }
	
	public Vector4d invertedW() { return clone().invertW(); }
	
	public double max() { return Math.max(getX(), Math.max(getY(), Math.max(getZ(), getW()))); }
	
	public double min() { return Math.min(getX(), Math.min(getY(), Math.min(getZ(), getW()))); }
	
	
	
	public Vector4d abs() { return abs(true, true, true, true); }
	
	public Vector4d abs(boolean x, boolean y, boolean z, boolean w)
	{
		setX(x ? Math.abs(getX()) : getX());
		setY(y ? Math.abs(getY()) : getY());
		setZ(z ? Math.abs(getZ()) : getZ());
		setW(w ? Math.abs(getW()) : getW());
		
		return this;
	}
	
	public Vector4d absX() { return abs(true, false, false, false); }
	
	public Vector4d absY() { return abs(false, true, false, false); }
	
	public Vector4d absZ() { return abs(false, false, true, false); }
	
	public Vector4d absW() { return abs(false, false, false, true); }
	
	public Vector4d floor() { return floor(true, true, true, true); }
	
	public Vector4d floor(boolean x, boolean y, boolean z, boolean w)
	{
		setX(x ? Math.floor(getX()) : getX());
		setY(y ? Math.floor(getY()) : getY());
		setZ(z ? Math.floor(getZ()) : getZ());
		setW(w ? Math.floor(getW()) : getW());
		
		return this;
	}
	
	public Vector4d floorX() { return floor(true, false, false, false); }
	
	public Vector4d floorY() { return floor(false, true, false, false); }
	
	public Vector4d floorZ() { return floor(false, false, true, false); }
	
	public Vector4d floorW() { return floor(false, false, false, true); }
	
	public Vector4d ceil() { return ceil(true, true, true, true); }
	
	public Vector4d ceil(boolean x, boolean y, boolean z, boolean w)
	{
		setX(x ? Math.ceil(getX()) : getX());
		setY(y ? Math.ceil(getY()) : getY());
		setZ(z ? Math.ceil(getZ()) : getZ());
		
		return this;
	}
	
	public Vector4d ceilX() { return ceil(true, false, false, false); }
	
	public Vector4d ceilY() { return ceil(false, true, false, false); }
	
	public Vector4d ceilZ() { return ceil(false, false, true, false); }
	
	public Vector4d ceilW() { return ceil(false, false, false, true); }
	
	public Vector4d round() { return round(true, true, true, true); }
	
	public Vector4d round(boolean x, boolean y, boolean z, boolean w)
	{
		setX(x ? Math.round(getX()) : getX());
		setY(y ? Math.round(getY()) : getY());
		setZ(z ? Math.round(getZ()) : getZ());
		setW(w ? Math.round(getW()) : getW());
		
		return this;
	}
	
	public Vector4d roundX() { return round(true, false, false, false); }
	
	public Vector4d roundY() { return round(false, true, false, false); }
	
	public Vector4d roundZ() { return round(false, false, true, false); }
	
	public Vector4d roundW() { return round(false, false, false, true); }
	
	

	public Vector4d absN() { return clone().abs(); }
	
	public Vector4d absN(boolean x, boolean y, boolean z, boolean w) { return clone().round(x, y, z, w); }
	
	public Vector4d absXN() { return clone().absX(); }
	
	public Vector4d absYN() { return clone().absY(); }
	
	public Vector4d absZN() { return clone().absZ(); }
	
	public Vector4d absWN() { return clone().absW(); }
	
	public Vector4d floorN() { return clone().floor(); }
	
	public Vector4d floorN(boolean x, boolean y, boolean z, boolean w) { return clone().round(x, y, z, w); }
	
	public Vector4d floorXN() { return clone().floorX(); }
	
	public Vector4d floorYN() { return clone().floorY(); }
	
	public Vector4d floorZN() { return clone().floorZ(); }
	
	public Vector4d floorWN() { return clone().floorW(); }
	
	public Vector4d ceilN() { return clone().ceil(); }
	
	public Vector4d ceilN(boolean x, boolean y, boolean z, boolean w) { return clone().ceil(x, y, z, w); }
	
	public Vector4d ceilXN() { return clone().ceilX(); }
	
	public Vector4d ceilYN() { return clone().ceilY(); }
	
	public Vector4d ceilZN() { return clone().ceilZ(); }
	
	public Vector4d ceilWN() { return clone().ceilW(); }

	public Vector4d roundN() { return clone().round(); }
	
	public Vector4d roundN(boolean x, boolean y, boolean z, boolean w) { return clone().round(x, y, z, w); }
	
	public Vector4d roundXN() { return clone().roundX(); }
	
	public Vector4d roundYN() { return clone().roundY(); }
	
	public Vector4d roundZN() { return clone().roundZ(); }
	
	public Vector4d roundWN() { return clone().roundW(); }
	
	
	
	public Vector4d clone() { return new Vector4d(this); }
	
	public boolean equals(Vector4d v) { return getX() == v.getX() && getY() == v.getY() && getZ() == v.getZ() && getW() == v.getW(); }
	
	public String toString() { return "vec4d(" + getX() + "f, " + getY() + "f, " + getZ() + "f, " + getW() + "f)"; }
	
	
	
	public void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		setX(dis.readDouble());
		setY(dis.readDouble());
		setZ(dis.readDouble());
		setW(dis.readDouble());
	}

	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeDouble(getX());
		dos.writeDouble(getY());
		dos.writeDouble(getZ());
		dos.writeDouble(getW());
	}

	
	
}

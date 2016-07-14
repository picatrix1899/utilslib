package cmn.picatrix1899.utilslib.vector;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cmn.picatrix1899.utilslib.essentials.Validate.Check;
import cmn.picatrix1899.utilslib.interfaces.DataHolder;

/**
 * A mathematical 3-dimensional vector of type double
 * 
 * @author picatrix1899
 *
 */
public class Vector3d implements DataHolder
{
	public static final short DIMENSIONS = 3;
	
	
	
	public static final Vector3d aX = new Vector3d(1.0d, 0.0d, 0.0d);
	public static final Vector3d aY = new Vector3d(0.0d, 1.0d, 0.0d);
	public static final Vector3d aZ = new Vector3d(0.0d, 0.0d, 1.0d);
	public static final Vector3d aNX = new Vector3d(-1.0d, 0.0d, 0.0d);
	public static final Vector3d aNY = new Vector3d(0.0d, -1.0d, 0.0d);
	public static final Vector3d aNZ = new Vector3d(0.0d, 0.0d, -1.0d);
	
	public static final int X = 0;
	public static final int Y = 1;
	public static final int Z = 2;
	
	public double x = 0.0d;
	public double y = 0.0d;
	public double z = 0.0d;
	
	
	
	public Vector3d()
	{
		this(0.0d, 0.0d, 0.0d);
	}
	
	private Vector3d(Vector3d v)
	{
		this(v.getX(), v.getY(), v.getZ());
	}
	
	public Vector3d(double x, double y, double z)
	{
		set(x, y, z);
	}
	
	
	
	public Vector3d set(Vector3d v) { return set(v.getX(), v.getY(), v.getZ()); }
	
	public Vector3d set(double x, double y, double z) { return setX(x).setY(y).setZ(z); }
	
	public Vector3d setX(double x) { this.x = x; return this; }
	
	public Vector3d setY(double y) { this.y = y; return this; }
	
	public Vector3d setZ(double z) { this.z = z; return this; }
	
	
	
	public double getX() { return this.x; }
	
	public double getY() { return this.y; }
	
	public double getZ() { return this.z; }
	
	
	
	public static Vector3d add(Vector3d v1, Vector3d v2) { return Vector3d.add(v1, v2.getX(), v2.getY(), v2.getZ()); }
	
	public static Vector3d add(Vector3d v1, double scalar) { return Vector3d.add(v1, scalar, scalar, scalar); }
	
	public static Vector3d add(Vector3d v1, double x, double y, double z) { return v1.add(x, y, z); }
	
	public static Vector3d sub(Vector3d v1, Vector3d v2) { return Vector3d.sub(v1, v2.getX(), v2.getY(), v2.getZ()); }
	
	public static Vector3d sub(Vector3d v1, double scalar) { return Vector3d.sub(v1, scalar, scalar, scalar); }
	
	public static Vector3d sub(Vector3d v1, double x, double y, double z) { return v1.sub(x, y, z); }
	
	public static Vector3d mul(Vector3d v1, Vector3d v2) { return Vector3d.mul(v1, v2.getX(), v2.getY(), v2.getZ()); }
	
	public static Vector3d mul(Vector3d v1, double scalar) { return Vector3d.mul(v1, scalar, scalar, scalar); }
	
	public static Vector3d mul(Vector3d v1, double x, double y, double z) { return v1.mul(x, y, z); }
	
	public static Vector3d div(Vector3d v1, Vector3d v2) { return Vector3d.div(v1, v2.getX(), v2.getY(), v2.getZ()); }
	
	public static Vector3d div(Vector3d v1, double scalar) { return Vector3d.div(v1, scalar, scalar, scalar); }
	
	public static Vector3d div(Vector3d v1, double x, double y, double z) { return v1.div(x, y, z); }
	
	public static Vector3d pow(Vector3d v1, Vector3d v2) { return Vector3d.pow(v1, v2.getX(), v2.getY(), v2.getZ()); }
	
	public static Vector3d pow(Vector3d v1, double scalar) { return Vector3d.pow(v1, scalar, scalar, scalar); }
	
	public static Vector3d pow(Vector3d v1, double x, double y, double z) { return v1.pow(x, y, z); }
	
	
	
	public static Vector3d addN(Vector3d v1, Vector3d v2) { return Vector3d.addN(v1, v2.getX(), v2.getY(), v2.getZ()); }
	
	public static Vector3d addN(Vector3d v1, double scalar) { return Vector3d.addN(v1, scalar, scalar, scalar); }
	
	public static Vector3d addN(Vector3d v1, double x, double y, double z) { return v1.addN(x, y, z); }
	
	public static Vector3d subN(Vector3d v1, Vector3d v2) { return Vector3d.subN(v1, v2.getX(), v2.getY(), v2.getZ()); }
	
	public static Vector3d subN(Vector3d v1, double scalar) { return Vector3d.subN(v1, scalar, scalar, scalar); }
	
	public static Vector3d subN(Vector3d v1, double x, double y, double z) { return v1.subN(x, y, z); }
	
	public static Vector3d mulN(Vector3d v1, Vector3d v2) { return Vector3d.mulN(v1, v2.getX(), v2.getY(), v2.getZ()); }
	
	public static Vector3d mulN(Vector3d v1, double scalar) { return Vector3d.mulN(v1, scalar, scalar, scalar); }
	
	public static Vector3d mulN(Vector3d v1, double x, double y, double z) { return v1.mulN(x, y, z); }
	
	public static Vector3d divN(Vector3d v1, Vector3d v2) { return Vector3d.divN(v1, v2.getX(), v2.getY(), v2.getZ()); }
	
	public static Vector3d divN(Vector3d v1, double scalar) { return Vector3d.divN(v1, scalar, scalar, scalar); }
	
	public static Vector3d divN(Vector3d v1, double x, double y, double z) { return v1.divN(x, y, z); }
	
	public static Vector3d powN(Vector3d v1, Vector3d v2) { return Vector3d.powN(v1, v2.getX(), v2.getY(), v2.getZ()); }
	
	public static Vector3d powN(Vector3d v1, double scalar) { return Vector3d.powN(v1, scalar, scalar, scalar); }
	
	public static Vector3d powN(Vector3d v1, double x, double y, double z) { return v1.powN(x, y, z); }
	
	
	
	public static Vector3d addR(Vector3d v1, Vector3d v2, Vector3d v3) { return Vector3d.addR(v1, v2.getX(), v2.getY(), v2.getZ(), v3); }
	
	public static Vector3d addR(Vector3d v1, double scalar, Vector3d v3) { return Vector3d.addR(v1, scalar, scalar, scalar, v3); }
	
	public static Vector3d addR(Vector3d v1, double x, double y, double z, Vector3d v3) { return v3.set(v1).add(x,y,z); }
	
	public static Vector3d subR(Vector3d v1, Vector3d v2, Vector3d v3) { return Vector3d.subR(v1, v2.getX(), v2.getY(), v2.getZ(), v3); }
	
	public static Vector3d subR(Vector3d v1, double scalar, Vector3d v3) { return Vector3d.subR(v1, scalar, scalar, scalar, v3); }
	
	public static Vector3d subR(Vector3d v1, double x, double y, double z, Vector3d v3) { return v3.set(v1).sub(x,y,z); }
	
	public static Vector3d mulR(Vector3d v1, Vector3d v2, Vector3d v3) { return Vector3d.mulR(v1, v2.getX(), v2.getY(), v2.getZ(), v3); }
	
	public static Vector3d mulR(Vector3d v1, double scalar, Vector3d v3) { return Vector3d.mulR(v1, scalar, scalar, scalar, v3); }
	
	public static Vector3d mulR(Vector3d v1, double x, double y, double z, Vector3d v3) { return v3.set(v1).mul(x,y,z); }
	
	public static Vector3d divR(Vector3d v1, Vector3d v2, Vector3d v3) { return Vector3d.divR(v1, v2.getX(), v2.getY(), v2.getZ(), v3); }
	
	public static Vector3d divR(Vector3d v1, double scalar, Vector3d v3) { return Vector3d.divR(v1, scalar, scalar, scalar, v3); }
	
	public static Vector3d divR(Vector3d v1, double x, double y, double z, Vector3d v3) { return v3.set(v1).div(x,y,z); }
	
	public static Vector3d powR(Vector3d v1, Vector3d v2, Vector3d v3) { return Vector3d.powR(v1, v2.getX(), v2.getY(), v2.getZ(), v3); }
	
	public static Vector3d powR(Vector3d v1, double scalar, Vector3d v3) { return Vector3d.powR(v1, scalar, scalar, scalar, v3); }
	
	public static Vector3d powR(Vector3d v1, double x, double y, double z, Vector3d v3) { return v3.set(v1).pow(x,y,z); }
	
	
	
	public Vector3d add(Vector3d v) { return add(v.getX(), v.getY(),v.getZ()); }
	
	public Vector3d add(double scalar) { return add(scalar, scalar, scalar); }
	
	public Vector3d add(double x, double y, double z) { return setX(getX() + x).setY(getY() + y).setZ(getZ() + z); }

	public Vector3d sub(Vector3d v) { return sub(v.getX(), v.getY(),v.getZ()); }
	
	public Vector3d sub(double scalar) { return sub(scalar, scalar, scalar); }
	
	public Vector3d sub(double x, double y, double z) { return setX(getX() - x).setY(getY() - y).setZ(getZ() - z); }
	
	public Vector3d mul(Vector3d v) { return mul(v.getX(), v.getY(),v.getZ()); }
	
	public Vector3d mul(double scalar) { return mul(scalar, scalar, scalar); }
	
	public Vector3d mul(double x, double y, double z) { return setX(getX() * x).setY(getY() * y).setZ(getZ() * z); }
	
	public Vector3d div(Vector3d v) { return div(v.getX(), v.getY(),v.getZ()); }
	
	public Vector3d div(double scalar) { return div(scalar, scalar, scalar); }
	
	public Vector3d div(double x, double y, double z) { return setX(getX() / x).setY(getY() / y).setZ(getZ() / z); }
	
	public Vector3d pow(Vector3d v) {return pow(v.getX(), v.getY(), v.getZ()); }
	
	public Vector3d pow(double scalar) { return pow(scalar, scalar, scalar); }
	
	public Vector3d pow(double x, double y, double z) { return setX(Math.pow(getX(), x)).setY(Math.pow(getY(), y)).setZ(Math.pow(getZ(), z)); }
	
	
	
	public Vector3d addN(Vector3d v) { return addN(v.getX(), v.getY(), v.getZ()); }
	
	public Vector3d addN(double scalar) { return addN(scalar, scalar, scalar); }
	
	public Vector3d addN(double x, double y, double z) { return clone().add(x, y, z); }
	
	public Vector3d subN(Vector3d v) { return subN(v.getX(), v.getY(), v.getZ()); }
	
	public Vector3d subN(double scalar) { return subN(scalar, scalar, scalar); }
	
	public Vector3d subN(double x, double y, double z) { return clone().sub(x, y, z); }
	
	public Vector3d mulN(Vector3d v) { return mulN(v.getX(), v.getY(), v.getZ()); }
	
	public Vector3d mulN(double scalar) { return mulN(scalar, scalar, scalar); }
	
	public Vector3d mulN(double x, double y, double z) { return clone().mul(x, y, z); }
	
	public Vector3d divN(Vector3d v) { return divN(v.getX(), v.getY(), v.getZ()); }
	
	public Vector3d divN(double scalar) { return divN(scalar, scalar, scalar); }
	
	public Vector3d divN(double x, double y, double z) { return clone().div(x, y, z); }
	
	public Vector3d powN(Vector3d v) { return powN(v.getX(), v.getY(), v.getZ()); }
	
	public Vector3d powN(double scalar) { return powN(scalar, scalar, scalar); }
	
	public Vector3d powN(double x, double y, double z) { return clone().pow(x, y, z); }
	
	
	
	public Vector3d addR(Vector3d v, Vector3d v2) { return addR(v.getX(), v.getY(),v.getZ(), v2); }
	
	public Vector3d addR(double scalar, Vector3d v2) { return addR(scalar, scalar, scalar, v2); }
	
	public Vector3d addR(double x, double y, double z, Vector3d v2) { return v2.set(this).add(x, y, z); }

	public Vector3d subR(Vector3d v, Vector3d v2) { return subR(v.getX(), v.getY(),v.getZ(), v2); }
	
	public Vector3d subR(double scalar, Vector3d v2) { return subR(scalar, scalar, scalar, v2); }
	
	public Vector3d subR(double x, double y, double z, Vector3d v2) { return v2.set(this).sub(x, y, z); }
	
	public Vector3d mulR(Vector3d v, Vector3d v2) { return mulR(v.getX(), v.getY(),v.getZ(), v2); }
	
	public Vector3d mulR(double scalar, Vector3d v2) { return mulR(scalar, scalar, scalar, v2); }
	
	public Vector3d mulR(double x, double y, double z, Vector3d v2) { return v2.set(this).mul(x, y, z); }
	
	public Vector3d divR(Vector3d v, Vector3d v2) { return divR(v.getX(), v.getY(),v.getZ(), v2); }
	
	public Vector3d divR(double scalar, Vector3d v2) { return divR(scalar, scalar, scalar, v2); }
	
	public Vector3d divR(double x, double y, double z, Vector3d v2) { return v2.set(this).div(x, y, z); }
	
	public Vector3d powR(Vector3d v, Vector3d v2) {return powR(v.getX(), v.getY(), v.getZ(), v2); }
	
	public Vector3d powR(double scalar, Vector3d v2) { return powR(scalar, scalar, scalar, v2); }
	
	public Vector3d powR(double x, double y, double z, Vector3d v2) { return v2.set(this).pow(x, y, z); }
	
	
	
	public double length() { return Math.sqrt(getX() * getX() + getY() * getY() + getZ() * getZ()); }
	
	public Vector3d normalize() { return Check.notNull(this) ? div(length()) : this; }
	
	public Vector3d normalized() { return clone().normalize(); }
	
	public Vector3d invert() { return mul(-1.0d); }
	
	public Vector3d invert(boolean x, boolean y, boolean z) { return mul(x ? -1.0d : 1.0d, y ? -1.0d : 1.0d, z ? -1.0d : 1.0d); }
	
	public Vector3d invertX() { return invert(true, false, false); }
	
	public Vector3d invertY() { return invert(false, true, false); }
	
	public Vector3d invertZ() { return invert(false, false, true); }
	
	public Vector3d inverted() { return clone().invert(); }
	
	public Vector3d inverted(boolean x, boolean y, boolean z) {return clone().invert(x, y, z); }
	
	public Vector3d invertedX() { return clone().invertX(); }
	
	public Vector3d invertedY() { return clone().invertY(); }
	
	public Vector3d invertedZ() { return clone().invertZ(); }
	
	public double dot(Vector3d v) { return getX() * v.getX() + getY() * v.getY() + getZ() * v.getZ(); }
	
	public Vector3d cross(Vector3d v) 
	{
		return new Vector3d(getY() * v.getZ() - getZ() * v.getY(), getZ() * v.getX() - getX() * v.getZ(), getX() * v.getY() - getY() * v.getX());
	}
	
	public Vector3d lerp(Vector3d dest, double factor) { return dest.subN(this).mul(factor).add(this); }
	
	public double max() { return Math.max(getX(), Math.max(getY(), getZ())); }
	
	public double min() { return Math.min(getX(), Math.min(getY(), getZ())); }
	
	
	
	public Vector3d abs() { return abs(true, true, true); }
	
	public Vector3d abs(boolean x, boolean y, boolean z)
	{
		setX(x ? Math.abs(getX()) : getX());
		setY(y ? Math.abs(getY()) : getY());
		setZ(z ? Math.abs(getZ()) : getZ());
		
		return this;
	}
	
	public Vector3d absX() { return abs(true, false, false); }
	
	public Vector3d absY() { return abs(false, true, false); }
	
	public Vector3d absZ() { return abs(false, false, true); }
	
	public Vector3d floor() { return floor(true, true, true); }
	
	public Vector3d floor(boolean x, boolean y, boolean z)
	{
		setX(x ? Math.floor(getX()) : getX());
		setY(y ? Math.floor(getY()) : getY());
		setZ(z ? Math.floor(getZ()) : getZ());
		
		return this;
	}
	
	public Vector3d floorX() { return floor(true, false, false); }
	
	public Vector3d floorY() { return floor(false, true, false); }
	
	public Vector3d floorZ() { return floor(false, false, true); }
	
	public Vector3d ceil() { return ceil(true, true, true); }
	
	public Vector3d ceil(boolean x, boolean y, boolean z)
	{
		setX(x ? Math.ceil(getX()) : getX());
		setY(y ? Math.ceil(getY()) : getY());
		setZ(z ? Math.ceil(getZ()) : getZ());
		
		return this;
	}
	
	public Vector3d ceilX() { return ceil(true, false, false); }
	
	public Vector3d ceilY() { return ceil(false, true, false); }
	
	public Vector3d ceilZ() { return ceil(false, false, true); }
	
	public Vector3d round() { return round(true, true, true); }
	
	public Vector3d round(boolean x, boolean y, boolean z)
	{
		setX(x ? Math.round(getX()) : getX());
		setY(y ? Math.round(getY()) : getY());
		setZ(z ? Math.round(getZ()) : getZ());
		
		return this;
	}
	
	public Vector3d roundX() { return round(true, false, false); }
	
	public Vector3d roundY() { return round(false, true, false); }
	
	public Vector3d roundZ() { return round(false, false, true); }
	


	public Vector3d absN() { return clone().abs(); }
	
	public Vector3d absN(boolean x, boolean y, boolean z) { return clone().round(x, y, z); }
	
	public Vector3d absXN() { return clone().absX(); }
	
	public Vector3d absYN() { return clone().absY(); }
	
	public Vector3d absZN() { return clone().absZ(); }
	
	public Vector3d floorN() { return clone().floor(); }
	
	public Vector3d floorN(boolean x, boolean y, boolean z) { return clone().round(x, y, z); }
	
	public Vector3d floorXN() { return clone().floorX(); }
	
	public Vector3d floorYN() { return clone().floorY(); }
	
	public Vector3d floorZN() { return clone().floorZ(); }
	
	public Vector3d ceilN() { return clone().ceil(); }
	
	public Vector3d ceilN(boolean x, boolean y, boolean z) { return clone().ceil(x, y, z); }
	
	public Vector3d ceilXN() { return clone().ceilX(); }
	
	public Vector3d ceilYN() { return clone().ceilY(); }
	
	public Vector3d ceilZN() { return clone().ceilZ(); }

	public Vector3d roundN() { return clone().round(); }
	
	public Vector3d roundN(boolean x, boolean y, boolean z) { return clone().round(x, y, z); }
	
	public Vector3d roundXN() { return clone().roundX(); }
	
	public Vector3d roundYN() { return clone().roundY(); }
	
	public Vector3d roundZN() { return clone().roundZ(); }
	
	
	
	public Vector3d rot(Vector3d axis, double angle)
	{
		double sinHalfAngle = Math.sin(Math.toRadians(angle / 2));
		double cosHalfAngle = Math.cos(Math.toRadians(angle / 2));
		
		double rX = axis.getX() * sinHalfAngle;
		double rY = axis.getY() * sinHalfAngle;
		double rZ = axis.getZ() * sinHalfAngle;
		double rW = cosHalfAngle;
		
		Quaternion rotation = new Quaternion(rW, rX, rY, rZ);
		
		return rot(rotation);
	}
	
	public Vector3d rot(Quaternion q)
	{
		Quaternion conjugate = q.conjugated();
		Quaternion w = q.mul(this).mul(conjugate);

		return new Vector3d(w.getX(), w.getY(), w.getZ());
	}
	
	public double angle(Vector3d v)
	{
		
		double bA = length();
		double bB = v.length();
		
		double sca = dot(v);
		
		double out = Math.toDegrees(Math.acos(sca / (bA * bB)));
		
		return out;
	}
	
	
	
	public int getDimensions() { return Vector3d.DIMENSIONS; }
	
	public double getOrdinal(int index)
	{
		if(index < 0 || index >= getDimensions()) throw new IndexOutOfBoundsException();
		
		switch(index)
		{
			case 0: { return getX(); }
			case 1: { return getY(); }
			case 2: { return getZ(); }
			
			default: return Double.NaN;
		}
	}
	
	public double[] ordinal() { return new double[] { getX(), getY(), getZ() }; }
	
	public Vector3d setOrdinal(int index, double val)
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
	
	
	
	public Vector3d clone() { return new Vector3d(this); }
	
	public boolean equals(Vector3d v) { return getX() == v.getX() && getY() == v.getY() & getZ() == v.getZ(); }
	
	public String toString() { return "vec3d(" + getX() + "f, " + getY() + "f, " + getZ() + "f)"; }
	
	
	
	public void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		setX(dis.readDouble());
		setY(dis.readDouble());
		setZ(dis.readDouble());
	}

	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeDouble(getX());
		dos.writeDouble(getY());
		dos.writeDouble(getZ());
	}

}
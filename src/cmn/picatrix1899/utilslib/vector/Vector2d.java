
package cmn.picatrix1899.utilslib.vector;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cmn.picatrix1899.utilslib.essentials.Validate.Check;
import cmn.picatrix1899.utilslib.interfaces.DataHolder;



/**
 * A mathematical 2-dimensional vector of type double
 * 
 * @author picatrix1899
 *
 */
public class Vector2d implements DataHolder
{
	
	public static final Vector2d aX = new Vector2d(1.0d, 0.0d);
	public static final Vector2d aY = new Vector2d(0.0d, 1.0d);
	public static final Vector2d aNX = new Vector2d(-1.0d, 0.0d);
	public static final Vector2d aNY = new Vector2d(0.0d, -1.0d);
	
	public static final int X = 0;
	public static final int Y = 1;
	
	public static final short DIMENSIONS = 2;
	
	public double x = 0.0d;
	public double y = 0.0d;
	
	
	
	public Vector2d()
	{
		this(0.0d, 0.0d);
	}
	
	public Vector2d(Vector2d v)
	{
		this(v.getX(), v.getY());
	}
	
	public Vector2d(double x, double y)
	{
		set(x, y);
	}
	
	
	
	public Vector2d set(Vector2d v) { return set(v.getX(),v.getY()); }
	
	public Vector2d set(double x, double y) { setX(x).setY(y); return this; }
	
	
	public Vector2d setX(double x) { this.x = x; return this; }
	
	public Vector2d setY(double y) { this.y = y; return this; }

	
	
	public double getX() { return this.x; }
	
	public double getY() { return this.y; }
	
	
	
	public static Vector2d add(Vector2d v1, Vector2d v2) { return Vector2d.add(v1, v2.getX(), v2.getY()); }
	
	public static Vector2d add(Vector2d v1, double scalar) { return Vector2d.add(v1, scalar, scalar); }
	
	public static Vector2d add(Vector2d v1, double x, double y) { return v1.add(x, y); }
	
	
	public static Vector2d sub(Vector2d v1, Vector2d v2) { return Vector2d.sub(v1, v2.getX(), v2.getY()); }
	
	public static Vector2d sub(Vector2d v1, double scalar) { return Vector2d.sub(v1, scalar, scalar); }
	
	public static Vector2d sub(Vector2d v1, double x, double y) { return v1.sub(x, y); }
	
	
	public static Vector2d mul(Vector2d v1, Vector2d v2) { return Vector2d.mul(v1, v2.getX(), v2.getY()); }
	
	public static Vector2d mul(Vector2d v1, double scalar) { return Vector2d.mul(v1, scalar, scalar); }
	
	public static Vector2d mul(Vector2d v1, double x, double y) { return v1.mul(x, y); }
	
	
	public static Vector2d div(Vector2d v1, Vector2d v2) { return Vector2d.div(v1, v2.getX(), v2.getY()); }
	
	public static Vector2d div(Vector2d v1, double scalar) { return Vector2d.div(v1, scalar, scalar); }
	
	public static Vector2d div(Vector2d v1, double x, double y) { return v1.div(x, y); }
	
	
	public static Vector2d pow(Vector2d v1, Vector2d v2) { return Vector2d.pow(v1, v2.getX(), v2.getY()); }
	
	public static Vector2d pow(Vector2d v1, double scalar) { return Vector2d.pow(v1, scalar, scalar); }
	
	public static Vector2d pow(Vector2d v1, double x, double y) { return v1.pow(x, y); }
	
	
	
	public static Vector2d subN(Vector2d v1, Vector2d v2) { return Vector2d.subN(v1, v2.getX(), v2.getY()); }
	
	public static Vector2d subN(Vector2d v1, double scalar) { return Vector2d.subN(v1, scalar, scalar); }
	
	public static Vector2d subN(Vector2d v1, double x, double y) { return v1.subN(x, y); }
	
	
	public static Vector2d mulN(Vector2d v1, Vector2d v2) { return Vector2d.mulN(v1, v2.getX(), v2.getY()); }
	
	public static Vector2d mulN(Vector2d v1, double scalar) { return Vector2d.mulN(v1, scalar, scalar); }
	
	public static Vector2d mulN(Vector2d v1, double x, double y) { return v1.mulN(x, y); }
	
	
	public static Vector2d divN(Vector2d v1, Vector2d v2) { return Vector2d.divN(v1, v2.getX(), v2.getY()); }
	
	public static Vector2d divN(Vector2d v1, double scalar) { return Vector2d.divN(v1, scalar, scalar); }
	
	public static Vector2d divN(Vector2d v1, double x, double y) { return v1.divN(x, y); }
	
	
	public static Vector2d powN(Vector2d v1, Vector2d v2) { return Vector2d.powN(v1, v2.getX(), v2.getY()); }
	
	public static Vector2d powN(Vector2d v1, double scalar) { return Vector2d.powN(v1, scalar, scalar); }
	
	public static Vector2d powN(Vector2d v1, double x, double y) { return v1.powN(x, y); }
	
	
	
	public static Vector2d addR(Vector2d v1, Vector2d v2, Vector2d v3) { return Vector2d.addR(v1, v2.getX(), v2.getY(), v3); }
	
	public static Vector2d addR(Vector2d v1, double scalar, Vector2d v3) { return Vector2d.addR(v1, scalar, scalar, v3); }
	
	public static Vector2d addR(Vector2d v1, double x, double y, Vector2d v3) { return v3.set(v1).add(x,y); }
	
	
	public static Vector2d subR(Vector2d v1, Vector2d v2, Vector2d v3) { return Vector2d.subR(v1, v2.getX(), v2.getY(), v3); }
	
	public static Vector2d subR(Vector2d v1, double scalar, Vector2d v3) { return Vector2d.subR(v1, scalar, scalar, v3); }
	
	public static Vector2d subR(Vector2d v1, double x, double y, Vector2d v3) { return v3.set(v1).sub(x,y); }
	
	
	public static Vector2d mulR(Vector2d v1, Vector2d v2, Vector2d v3) { return Vector2d.mulR(v1, v2.getX(), v2.getY(), v3); }
	
	public static Vector2d mulR(Vector2d v1, double scalar, Vector2d v3) { return Vector2d.mulR(v1, scalar, scalar, v3); }
	
	public static Vector2d mulR(Vector2d v1, double x, double y, Vector2d v3) { return v3.set(v1).mul(x,y); }
	
	
	public static Vector2d divR(Vector2d v1, Vector2d v2, Vector2d v3) { return Vector2d.divR(v1, v2.getX(), v2.getY(), v3); }
	
	public static Vector2d divR(Vector2d v1, double scalar, Vector2d v3) { return Vector2d.divR(v1, scalar, scalar, v3); }
	
	public static Vector2d divR(Vector2d v1, double x, double y, Vector2d v3) { return v3.set(v1).div(x,y); }
	
	
	public static Vector2d powR(Vector2d v1, Vector2d v2, Vector2d v3) { return Vector2d.powR(v1, v2.getX(), v2.getY(), v3); }
	
	public static Vector2d powR(Vector2d v1, double scalar, Vector2d v3) { return Vector2d.powR(v1, scalar, scalar, v3); }
	
	public static Vector2d powR(Vector2d v1, double x, double y, Vector2d v3) { return v3.set(v1).pow(x,y); }
	
	
	
	public Vector2d add(Vector2d v) { return add(v.getX(), v.getY()); }
	
	public Vector2d add(double scalar) { return add(scalar, scalar); }
	
	public Vector2d add(double x, double y) { return setX(getX() + x).setY(getY() + y); }
	
	
	public Vector2d sub(Vector2d v) { return sub(v.getX(), v.getY()); }
	
	public Vector2d sub(double scalar) { return sub(scalar, scalar); }
	
	public Vector2d sub(double x, double y) { return setX(getX() - x).setY(getY() - y); }
	
	
	public Vector2d mul(Vector2d v) { return mul(v.getX(), v.getY()); }
	
	public Vector2d mul(double scalar) { return mul(scalar, scalar); }
	
	public Vector2d mul(double x, double y) { return setX(getX() * x).setY(getY() * y); }
	
	
	public Vector2d div(Vector2d v) { return div(v.getX(), v.getY()); }
	
	public Vector2d div(double scalar) { return div(scalar, scalar); }
	
	public Vector2d div(double x, double y) { return setX(getX() / x).setY(getY() / y); }
	
	
	public Vector2d pow(Vector2d v) {return pow(v.getX(), v.getY()); }
	
	public Vector2d pow(double scalar) { return pow(scalar, scalar); }
	
	public Vector2d pow(double x, double y) { return setX(Math.pow(getX(), x)).setY(Math.pow(getY(), y)); }
	
	
	
	public Vector2d addN(Vector2d v) { return addN(v.getX(), v.getY()); }
	
	public Vector2d addN(double scalar) { return addN(scalar, scalar); }
	
	public Vector2d addN(double x, double y) { return clone().add(x, y); }
	
	
	public Vector2d subN(Vector2d v) { return subN(v.getX(), v.getY()); }
	
	public Vector2d subN(double scalar) { return subN(scalar, scalar); }
	
	public Vector2d subN(double x, double y) { return clone().sub(x, y); }
	
	
	public Vector2d mulN(Vector2d v) { return mulN(v.getX(), v.getY()); }
	
	public Vector2d mulN(double scalar) { return mulN(scalar, scalar); }
	
	public Vector2d mulN(double x, double y) { return clone().mul(x, y); }
	
	
	public Vector2d divN(Vector2d v) { return divN(v.getX(), v.getY()); }
	
	public Vector2d divN(double scalar) { return divN(scalar, scalar); }
	
	public Vector2d divN(double x, double y) { return clone().div(x, y); }
	
	
	public Vector2d powN(Vector2d v) { return powN(v.getX(), v.getY()); }
	
	public Vector2d powN(double scalar) { return powN(scalar, scalar); }
	
	public Vector2d powN(double x, double y) { return clone().pow(x, y); }
	
	
	
	public Vector2d addR(Vector2d v, Vector2d v2) { return addR(v.getX(), v.getY(), v2); }
	
	public Vector2d addR(double scalar, Vector2d v2) { return addR(scalar, scalar, v2); }
	
	public Vector2d addR(double x, double y, Vector2d v2) { return v2.set(this).add(x,y); }
	
	
	public Vector2d subR(Vector2d v, Vector2d v2) { return subR(v.getX(), v.getY(), v2); }
	
	public Vector2d subR(double scalar, Vector2d v2) { return subR(scalar, scalar, v2); }
	
	public Vector2d subR(double x, double y, Vector2d v2) { return v2.set(this).sub(x,y); }
	
	
	public Vector2d mulR(Vector2d v, Vector2d v2) { return mulR(v.getX(), v.getY(), v2); }
	
	public Vector2d mulR(double scalar, Vector2d v2) { return mulR(scalar, scalar, v2); }
	
	public Vector2d mulR(double x, double y, Vector2d v2) { return v2.set(this).mul(x,y); }
	
	
	public Vector2d divR(Vector2d v, Vector2d v2) { return divR(v.getX(), v.getY(), v2); }
	
	public Vector2d divR(double scalar, Vector2d v2) { return divR(scalar, scalar, v2); }
	
	public Vector2d divR(double x, double y, Vector2d v2) { return v2.set(this).div(x,y); }
	
	
	public Vector2d powR(Vector2d v, Vector2d v2) { return powR(v.getX(), v.getY(), v2); }
	
	public Vector2d powR(double scalar, Vector2d v2) { return powR(scalar, scalar, v2); }
	
	public Vector2d powR(double x, double y, Vector2d v2) { return v2.set(this).pow(x,y); }
	
	
	
	public double length() { return Math.sqrt(getX() * getX() + getY() * getY()); }
	
	
	public Vector2d normalize() { return Check.notNull(this) ? div(length()) : this; }
	
	public Vector2d normalized() { return clone().normalize(); }
	
	
	public Vector2d invert() { return mul(-1.0d); }
	
	public Vector2d invert(boolean x, boolean y) { return mul(x ? -1.0d : 1.0d, y ? -1.0d : 1.0d); }
	
	
	public Vector2d invertX() { return invert(true, false); }
	
	public Vector2d invertY() { return invert(false, true); }
	
	
	public Vector2d inverted() { return clone().invert(); }
	
	public Vector2d inverted(boolean x, boolean y) {return clone().invert(x, y); }
	
	
	public Vector2d invertedX() { return clone().invertX(); }
	
	public Vector2d invertedY() { return clone().invertY(); }
	
	
	public double dot(Vector2d v) { return getX() * v.getX() + getY() * v.getY(); }
	
	
	public Vector2d lerp(Vector2d dest, double factor) { return dest.subN(this).mul(factor).add(this); }
	
	
	public double max() { return Math.max(getX(),getY()); }
	
	public double min() { return Math.min(getX(), getY()); }
	
	
	
	public Vector2d abs() { return abs(true, true); }
	
	public Vector2d abs(boolean x, boolean y)
	{
		setX(x ? Math.abs(getX()) : getX());
		setY(y ? Math.abs(getY()) : getY());
		
		return this;
	}
	
	
	public Vector2d absX() { return abs(true, false); }
	
	public Vector2d absY() { return abs(false, true); }
	
	
	public Vector2d floor() { return floor(true, true); }
	
	public Vector2d floor(boolean x, boolean y)
	{
		setX(x ? Math.floor(getX()) : getX());
		setY(y ? Math.floor(getY()) : getY());
		
		return this;
	}
	
	
	public Vector2d floorX() { return floor(true, false); }
	
	public Vector2d floorY() { return floor(false, true); }
	
	
	public Vector2d ceil() { return ceil(true, true); }
	
	public Vector2d ceil(boolean x, boolean y)
	{
		setX(x ? Math.ceil(getX()) : getX());
		setY(y ? Math.ceil(getY()) : getY());
		
		return this;
	}
	
	
	public Vector2d ceilX() { return ceil(true, false); }
	
	public Vector2d ceilY() { return ceil(false, true); }
	
	
	public Vector2d round() { return round(true, true); }
	
	public Vector2d round(boolean x, boolean y)
	{
		setX(x ? Math.round(getX()) : getX());
		setY(y ? Math.round(getY()) : getY());
		
		return this;
	}
	
	
	public Vector2d roundX() { return round(true, false); }
	
	public Vector2d roundY() { return round(false, true); }
	
	

	public Vector2d absN() { return clone().abs(); }
	
	public Vector2d absN(boolean x, boolean y) { return clone().round(x, y); }
	
	
	public Vector2d absXN() { return clone().absX(); }
	
	public Vector2d absYN() { return clone().absY(); }
	
	
	public Vector2d floorN() { return clone().floor(); }
	
	public Vector2d floorN(boolean x, boolean y) { return clone().round(x, y); }
	
	
	public Vector2d floorXN() { return clone().floorX(); }
	
	public Vector2d floorYN() { return clone().floorY(); }
	
	
	public Vector2d ceilN() { return clone().ceil(); }
	
	public Vector2d ceilN(boolean x, boolean y) { return clone().ceil(x, y); }
	
	
	public Vector2d ceilXN() { return clone().ceilX(); }
	
	public Vector2d ceilYN() { return clone().ceilY(); }

	
	public Vector2d roundN() { return clone().round(); }
	
	public Vector2d roundN(boolean x, boolean y) { return clone().round(x, y); }
	
	
	public Vector2d roundXN() { return clone().roundX(); }
	
	public Vector2d roundYN() { return clone().roundY(); }
	
	
	
	public int getDimensions() { return Vector2d.DIMENSIONS; }
	
	public double getOrdinal(int index)
	{
		if(index < 0 || index >= getDimensions()) throw new IndexOutOfBoundsException();
		
		switch(index)
		{
			case 0: { return getX(); }
			case 1: { return getY(); }
			
			default: return Double.NaN;
		}
	}
	
	public double[] ordinal() { return new double[] { getX(), getY() }; }
	
	public Vector2d setOrdinal(int index, double val)
	{
		if(index < 0 || index >= getDimensions()) throw new IndexOutOfBoundsException();
		
		switch(index)
		{
			case 0: { return setX(val); }
			case 1: { return setY(val); }
			
			default: return this;
		}
	}
	
	
	
	public Vector2d clone() { return new Vector2d(this); }
	
	public String toString() { return "vec2d(" + getX() + "d, " + getY() + "d)"; }
	
	
	
	public void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		
		setX(dis.readDouble());
		setY(dis.readDouble());
	}

	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		
		dos.writeDouble(getX());
		dos.writeDouble(getY());
	}
	
}
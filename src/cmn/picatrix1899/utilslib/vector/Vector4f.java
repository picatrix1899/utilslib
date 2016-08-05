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
public class Vector4f implements DataHolder
{
	public static final int DIMENSIONS = 4;
	
	public float x = 0.0f;
	public float y = 0.0f;
	public float z = 0.0f;
	public float a = 0.0f;
	
	public Vector4f()
	{
		setZero();
	}
	
	private Vector4f(Vector4f v)
	{
		set(v);
	}	
	
	public Vector4f(float scalar)
	{
		set(scalar);
	}
	
	public Vector4f(float x, float y, float z, float a)
	{
		set(x, y, z, a);
	}
	
	public Vector4f setZero() { return set(0.0f); }
	
	public Vector4f set(float scalar) { return set(scalar, scalar, scalar, scalar); }
	
	public Vector4f set(Vector4f v) { return set(v.x, v.y, v.z, v.a); }
	
	public Vector4f set(float x, float y, float z, float a) { return setX(x).setY(y).setZ(z).setA(a); }
	
	public Vector4f setX(float x) { this.x = x; return this; }
	
	public Vector4f setY(float y) { this.y = y; return this; }
	
	public Vector4f setZ(float z) { this.z = z; return this; }
	
	public Vector4f setA(float a) { this.a = a; return this; }
	
	
	
	public Vector4f add(Vector4f v) { return add(v.x, v.y, v.z, v.a); }
	
	public Vector4f add(float scalar) { return add(scalar, scalar, scalar, scalar); }
	
	public Vector4f add(float x, float y, float z, float a) { return setX(this.x + x).setY(this.y + y).setZ(this.z + z).setA(this.a + a); }

	public Vector4f sub(Vector4f v) { return sub(v.x, v.y, v.z, v.a); }
	
	public Vector4f sub(float scalar) { return sub(scalar, scalar, scalar, scalar); }
	
	public Vector4f sub(float x, float y, float z, float a) { return setX(this.x - x).setY(this.y - y).setZ(this.z - z).setA(this.a - a); }
	
	public Vector4f mul(Vector4f v) { return mul(v.x, v.y, v.z, v.a); }
	
	public Vector4f mul(float scalar) { return mul(scalar, scalar, scalar, scalar); }
	
	public Vector4f mul(float x, float y, float z, float a) { return setX(this.x * x).setY(this.y * y).setZ(this.z * z).setA(this.a * a); }
	
	public Vector4f div(Vector4f v) { return div(v.x, v.y, v.z, v.a); }
	
	public Vector4f div(float scalar) { return div(scalar, scalar, scalar, scalar); }
	
	public Vector4f div(float x, float y, float z, float a) { return setX(this.x / x).setY(this.y / y).setZ(this.z / z).setA(this.a / a); }
	
	
	
	
	public Vector4f addN(Vector4f v) { return addN(v.x, v.y, v.z, v.a); }
	
	public Vector4f addN(float scalar) { return addN(scalar, scalar, scalar, scalar); }
	
	public Vector4f addN(float x, float y, float z, float w) { return clone().add(x, y, z, w); }
	
	public Vector4f subN(Vector4f v) { return subN(v.x, v.y, v.z, v.a); }
	
	public Vector4f subN(float scalar) { return subN(scalar, scalar, scalar, scalar); }
	
	public Vector4f subN(float x, float y, float z, float w) { return clone().sub(x, y, z, w); }
	
	public Vector4f mulN(Vector4f v) { return mulN(v.x, v.y, v.z, v.a); }
	
	public Vector4f mulN(float scalar) { return mulN(scalar, scalar, scalar, scalar); }
	
	public Vector4f mulN(float x, float y, float z, float w) { return clone().mul(x, y, z, w); }
	
	public Vector4f divN(Vector4f v) { return divN(v.x, v.y, v.z, v.a); }
	
	public Vector4f divN(float scalar) { return divN(scalar, scalar, scalar, scalar); }
	
	public Vector4f divN(float x, float y, float z, float w) { return clone().div(x, y, z, w); }
	
	
	
	public float dot(Vector4f v) { return this.x  * v.x + this.y * v.y + this.z + v.z + this.a + v.a; }
	
	public float squaredLength() { return x * x + y * y + z * z + a * a; }
	
	public float length() { return (float)Math.sqrt(squaredLength()); }
	
	public Vector4f normalize() { return div(length()); }
	
	public Vector4f normalized() { return clone().normalize(); }
	
	public Vector4f invert() { return mul(-1.0f); }
	
	public Vector4f inverted() { return clone().invert(); }
	
	
	public float max() { return Math.max(this.x, Math.max(this.y, Math.max(this.z, this.a))); }
	
	public float min() { return Math.min(this.x, Math.min(this.y, Math.min(this.z, this.a))); }
	
	

	
	public Vector4f abs()
	{
		setX((float) Math.abs(this.x));
		setY((float) Math.abs(this.y));
		setZ((float) Math.abs(this.z));
		setA((float) Math.abs(this.a));
		
		return this;
	}


	
	public Vector4f floor()
	{
		setX((float) Math.floor(this.x));
		setY((float) Math.floor(this.y));
		setZ((float) Math.floor(this.z));
		setA((float) Math.floor(this.a));
		
		return this;
	}
	
	public Vector4f ceil()
	{
		setX((float) Math.ceil(this.x));
		setY((float) Math.ceil(this.y));
		setZ((float) Math.ceil(this.z));
		setA((float) Math.ceil(this.a));
		
		return this;
	}

	
	public Vector4f round()
	{
		setX((float) Math.round(this.x));
		setY((float) Math.round(this.y));
		setZ((float) Math.round(this.z));
		setA((float) Math.round(this.a));
		
		return this;
	}

	
	
	public Vector4f absN() { return clone().round(); }
	
	public Vector4f floorN() { return clone().round(); }
	
	public Vector4f ceilN() { return clone().ceil(); }

	public Vector4f roundN() { return clone().round(); }
	
	
	
	public Vector4f clone() { return new Vector4f(this); }
	
	public boolean equals(Vector4f v) { return this.x == v.x && this.y == v.y && this.z == v.z && this.a == v.a; }
	
	public String toString() { return "vector4f(" + this.x + "f, " + this.y + "f, " + this.z + "f, " + this.a + "f)"; }
	
	
	
	public void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		this.x = dis.readFloat();
		this.y = dis.readFloat();
		this.z = dis.readFloat();
		this.a = dis.readFloat();
	}

	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeFloat(this.x);
		dos.writeFloat(this.y);
		dos.writeFloat(this.z);
		dos.writeFloat(this.a);
	}
	
}

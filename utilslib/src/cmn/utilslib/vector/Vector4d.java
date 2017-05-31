package cmn.utilslib.vector;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import cmn.utilslib.interfaces.Streamable;
import cmn.utilslib.vector.api.Vec4d;
import cmn.utilslib.vector.api.Vec4dBase;

/**
 * A mathematical 4-dimensional vector of type float
 * 
 * @author picatrix1899
 *
 */
public class Vector4d implements Vec4d, Streamable.Readable, Streamable.Writeable, Serializable
{
	private static final long serialVersionUID = 1L;

	public static transient final int DIMENSIONS = 4;
	
	public double x = 0.0d;
	public double y = 0.0d;
	public double z = 0.0d;
	public double a = 0.0d;
	
	public Vector4d() { setZero(); }
	
	public Vector4d(Vec4dBase v) { set(v); }	
	
	public Vector4d(double scalar) { set(scalar); }
	
	public Vector4d(double x, double y, double z, double a) { set(x, y, z, a); }
	

	@Override
	public double getX() { return this.x; }

	@Override
	public double getY() { return this.y; }

	@Override
	public double getZ() { return this.z; }

	@Override
	public double getA() { return this.a; }
	

	@Override
	public Vector4d setX(float x) { this.x = x; return this; }

	@Override
	public Vector4d setX(double x) { this.x = x; return this; }

	@Override
	public Vector4d setY(float y) { this.y = y; return this; }

	@Override
	public Vector4d setY(double y) { this.y = y; return this; }

	@Override
	public Vector4d setZ(float z) { this.z = z; return this; }

	@Override
	public Vector4d setZ(double z) { this.z = z; return this; }

	@Override
	public Vector4d setA(float a) { this.a = a; return this; }

	@Override
	public Vector4d setA(double a) { this.a = a; return this; }
	
	
	
	/*
	 * ===========================
	 * OBJECT-OVERRIDES
	 * ===========================
	 */
	/** {@inheritDoc} */
	@Override
	public Vector4d clone() { return new Vector4d(this); }
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Vector4d)) return false;
		Vector4d v = (Vector4d)obj;
		
		if(v.x != this.x) return false;
		if(v.y != this.y) return false;
		if(v.z != this.z) return false;
		if(v.a != this.a) return false;
		
		return true;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() { return "Vec4d(" + this.x + "f, " + this.y + "f, " + this.z + "f, " + this.a + "f)"; }
	
	
	
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
		this.x = dis.readDouble();
		this.y = dis.readDouble();
		this.z = dis.readDouble();
		this.a = dis.readDouble();
	}

	/** {@inheritDoc} */
	@Override
	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeDouble(this.x);
		dos.writeDouble(this.y);
		dos.writeDouble(this.z);
		dos.writeDouble(this.a);
	}


	
}

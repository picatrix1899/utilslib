package cmn.utilslib.vector;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import cmn.utilslib.interfaces.Streamable;
import cmn.utilslib.vector.api.Vec4f;
import cmn.utilslib.vector.api.Vec4fBase;

/**
 * A mathematical 4-dimensional vector of type float
 * 
 * @author picatrix1899
 *
 */
public class Vector4f implements Vec4f, Streamable.Readable, Streamable.Writeable, Serializable
{
	private static final long serialVersionUID = 1L;

	public static transient final int DIMENSIONS = 4;
	
	public float x = 0.0f;
	public float y = 0.0f;
	public float z = 0.0f;
	public float a = 0.0f;
	
	public Vector4f() { setZero(); }
	
	public Vector4f(Vec4fBase v) { set(v); }	
	
	public Vector4f(float scalar) { set(scalar); }
	
	public Vector4f(float x, float y, float z, float a) { set(x, y, z, a); }
	

	@Override
	public float getX() { return this.x; }

	@Override
	public float getY() { return this.y; }

	@Override
	public float getZ() { return this.z; }

	@Override
	public float getA() { return this.a; }
	

	@Override
	public Vector4f setX(float x) { this.x = x; return this; }

	@Override
	public Vector4f setX(double x) { this.x = (float)x; return this; }

	@Override
	public Vector4f setY(float y) { this.y = y; return this; }

	@Override
	public Vector4f setY(double y) { this.y = (float)y; return this; }

	@Override
	public Vector4f setZ(float z) { this.z = z; return this; }

	@Override
	public Vector4f setZ(double z) { this.z = (float)z; return this; }

	@Override
	public Vector4f setA(float a) { this.a = a; return this; }

	@Override
	public Vector4f setA(double a) { this.a = (float)a; return this; }
	
	
	
	/*
	 * ===========================
	 * OBJECT-OVERRIDES
	 * ===========================
	 */
	/** {@inheritDoc} */
	@Override
	public Vector4f clone() { return new Vector4f(this); }
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Vector4f)) return false;
		Vector4f v = (Vector4f)obj;
		
		if(v.x != this.x) return false;
		if(v.y != this.y) return false;
		if(v.z != this.z) return false;
		if(v.a != this.a) return false;
		
		return true;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() { return "Vec4f(" + this.x + "f, " + this.y + "f, " + this.z + "f, " + this.a + "f)"; }
	
	
	
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
		this.a = dis.readFloat();
	}

	/** {@inheritDoc} */
	@Override
	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeFloat(this.x);
		dos.writeFloat(this.y);
		dos.writeFloat(this.z);
		dos.writeFloat(this.a);
	}


	
}

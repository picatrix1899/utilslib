package cmn.utilslib.matrix;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.FloatBuffer;

import cmn.utilslib.essentials.BufferUtils;
import cmn.utilslib.interfaces.IStreamable;
import cmn.utilslib.vector.Vec2f;

public class Matrix2f implements IStreamable, Serializable
{

	private static final long serialVersionUID = 1L;

	public static final int ROWS = 2;
	public static final int COLS = 2;
	public static final int ENTS = 4;
	
	public final Vec2f m0 = new Vec2f();
	public final Vec2f m1 = new Vec2f();
	
	public Matrix2f() { }
	
	public Matrix2f initZero()
	{
		m0.set(0.0f);
		m1.set(0.0f);
		
		return this;
	}
	
	public Matrix2f initIdentity()
	{
		m0.set(1.0f, 0.0f);
		m1.set(0.0f, 1.0f);
	
		return this;
	}
	
	public static Matrix2f iScaling(float sx, float sy) { return new Matrix2f().initScaling(sx, sy); }
	
	public Matrix2f initScaling(float sx, float sy)
	{
		this.m0.set(sx		, 0.0f	);
		this.m1.set(0.0f	, sy	);
		
		return this;
	}
	
	
	
	public Matrix2f mul(Matrix2f m)
	{
		return Matrix2f.mul(this, m, null);		
	}
	
	public static Matrix2f mul(Matrix2f l, Matrix2f r, Matrix2f dest)
	{
		if (dest == null) dest = new Matrix2f();
		
		float m0x_ = l.m0.x * r.m0.x + l.m0.y * r.m1.x;
		float m0y_ = l.m0.x * r.m0.y + l.m0.y * r.m1.y;
		float m1x_ = l.m1.x * r.m0.x + l.m1.y * r.m1.x;
		float m1y_ = l.m1.y * r.m0.y + l.m1.y * r.m1.y;
		
		dest.m0.set(m0x_, m0y_);
		dest.m1.set(m1x_, m1y_);
		
		return dest;
	}
	
	public static Vec2f transform(Matrix2f l, Vec2f r, Vec2f dest)
	{
		if (dest == null) dest = new Vec2f();

		return dest.set(l.m0.dot(r), l.m1.dot(r));
	}
	
	
	

	
	
	
	public Matrix2f transpose()
	{
		float m0x_ = this.m0.x;
		float m0y_ = this.m1.y;
		
		float m1x_ = this.m0.x;
		float m1y_ = this.m1.y;
		
		this.m0.set(m0x_, m0y_);
		this.m1.set(m1x_, m1y_);
		
		return this;
	}
	
	public Matrix2f transposed()
	{
		return clone().transpose();
	}
	
	public static float det2x2(float m0x, float m0y, float m1x, float m1y)
	{
		return	m0x * +m1y +
				m0y * -m1x;
	}
	
	public float determinant()
	{
		return Matrix2f.det2x2(m0.x, m0.y, m1.x, m1.y);
	}
	
	
	
	public float[] getRowMajor()
	{
		float[] out = new float[Matrix2f.ENTS];
		
		out[ 0] = this.m0.x;	out[ 1] = this.m0.y;
		out[ 2] = this.m1.x;	out[ 3] = this.m1.y;
		
		return out;
	}
	
	public FloatBuffer getRowMajorBuffer()
	{
		return (FloatBuffer) BufferUtils.wrapFloatBuffer(getRowMajor()).flip();
	}
	
	public float[] getColMajor()
	{
		float[] out = new float[Matrix2f.ENTS];
		
		out[ 0] = this.m0.x;	out[ 2] = this.m0.y;
		out[ 1] = this.m1.x;	out[ 3] = this.m1.y;
		
		return out;
	}
	
	public FloatBuffer getColMajorBuffer()
	{
		return (FloatBuffer) BufferUtils.wrapFloatBuffer(getColMajor()).flip();
	}
	
	
	
	public Matrix2f clone()
	{
		Matrix2f m = new Matrix2f();
		
		m.m0.set(this.m0);
		m.m1.set(this.m1);
		
		return m;
	}
	
	public void readData(InputStream stream) throws IOException
	{
		this.m0.readData(stream);
		this.m1.readData(stream);
	}

	public void writeData(OutputStream stream) throws IOException
	{
		this.m0.writeData(stream);
		this.m1.writeData(stream);
	}

}

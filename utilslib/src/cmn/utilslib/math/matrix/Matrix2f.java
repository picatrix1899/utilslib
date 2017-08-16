package cmn.utilslib.math.matrix;

import java.nio.FloatBuffer;

import cmn.utilslib.essentials.BufferUtils;
import cmn.utilslib.math.tuple.Tuple2f;
import cmn.utilslib.math.vector.Vector2f;
import cmn.utilslib.math.vector.api.Vec2f;
import cmn.utilslib.math.vector.api.Vec2fBase;

public class Matrix2f
{
	public static final int ROWS = 2;
	public static final int COLS = 2;
	public static final int ENTS = 4;
	
	public final Tuple2f m0 = new Tuple2f();
	public final Tuple2f m1 = new Tuple2f();
	
	public Matrix2f()
	{
		this.m0.v[0] = 1; this.m0.v[1] = 0;
		this.m0.v[0] = 0; this.m1.v[1] = 1;
	}
	
	public Matrix2f(Matrix2f m)
	{
		this.m0.v[0] = m.m0.v[0]; this.m0.v[1] = m.m0.v[1];
		this.m1.v[0] = m.m1.v[0]; this.m1.v[1] = m.m1.v[1];
	}
	
	public Matrix2f initZero()
	{
		this.m0.v[0] = 0; this.m0.v[1] = 0;
		this.m1.v[0] = 0; this.m1.v[1] = 0;
		
		return this;
	}
	
	public Matrix2f initIdentity()
	{
		this.m0.v[0] = 1; this.m0.v[1] = 0;
		this.m1.v[0] = 0; this.m1.v[1] = 0;
	
		return this;
	}
	
	public static Matrix2f iScaling(float sx, float sy) { return new Matrix2f().initScaling(sx, sy); }
	
	public Matrix2f initScaling(float sx, float sy)
	{
		this.m0.v[0] = sx; this.m0.v[1] = 0 ;
		this.m1.v[0] = 0 ; this.m1.v[1] = sy;
		
		return this;
	}
	
	
	
	public Matrix2f mul(Matrix2f m) { return Matrix2f.mul(this, m, null);		}
	
	public static Matrix2f mul(Matrix2f l, Matrix2f r, Matrix2f dest)
	{
		if (dest == null) dest = new Matrix2f();
		
		float m0x_ = l.m0.v[0] * r.m0.v[0] + l.m0.v[1] * r.m1.v[0];
		float m0y_ = l.m0.v[0] * r.m0.v[1] + l.m0.v[1] * r.m1.v[1];
		float m1x_ = l.m1.v[0] * r.m0.v[0] + l.m1.v[1] * r.m1.v[0];
		float m1y_ = l.m1.v[1] * r.m0.v[1] + l.m1.v[1] * r.m1.v[1];
		
		dest.m0.set(m0x_, m0y_);
		dest.m1.set(m1x_, m1y_);
		
		return dest;
	}
	
	public static Vec2f transform(Matrix2f l, Vec2fBase r, Vec2f dest)
	{
		if (dest == null) dest = new Vector2f();

		dest.setX(l.m0.v[0] * r.getY() + l.m0.v[1] * r.getX());
		dest.setY(l.m1.v[0] * r.getY() + l.m1.v[1] * r.getX());
		
		return dest;
	}
	
	
	

	
	
	
	public Matrix2f transpose()
	{
		float m0x_ = this.m0.v[0];
		float m0y_ = this.m1.v[1];
		
		float m1x_ = this.m0.v[0];
		float m1y_ = this.m1.v[1];
		
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
		return Matrix2f.det2x2(m0.v[0], m0.v[1], m1.v[0], m1.v[1]);
	}
	
	
	
	public float[] getRowMajor()
	{
		float[] out = new float[Matrix2f.ENTS];
		
		out[0] = this.m0.v[0];	out[1] = this.m0.v[1];
		out[2] = this.m1.v[0];	out[3] = this.m1.v[1];
		
		return out;
	}
	
	public FloatBuffer getRowMajorBuffer()
	{
		return BufferUtils.wrapFlippedFloatBuffer(getRowMajor());
	}
	
	public float[] getColMajor()
	{
		float[] out = new float[Matrix2f.ENTS];
		
		out[0] = this.m0.v[0];	out[2] = this.m0.v[1];
		out[1] = this.m1.v[0];	out[3] = this.m1.v[1];
		
		return out;
	}
	
	public FloatBuffer getColMajorBuffer()
	{
		return BufferUtils.wrapFlippedFloatBuffer(getColMajor());
	}
	
	
	
	public Matrix2f clone() { return new Matrix2f(this); }

}

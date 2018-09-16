package cmn.utilslib.math.matrix;

import java.nio.FloatBuffer;

import cmn.utilslib.essentials.BufferUtils;
import cmn.utilslib.math.vector.Vector2f;
import cmn.utilslib.math.vector.api.Vec2f;
import cmn.utilslib.math.vector.api.Vec2fBase;

public class Matrix2f
{
	public static final int ROWS = 2;
	public static final int COLS = 2;
	public static final int ENTS = 4;
	
	public final Vector2f m0 = new Vector2f();
	public final Vector2f m1 = new Vector2f();
	
	public Matrix2f()
	{
		this.m0.x = 1; this.m0.y = 0;
		this.m0.x = 0; this.m1.y = 1;
	}
	
	public Matrix2f(Matrix2f m)
	{
		this.m0.x = m.m0.x; this.m0.y = m.m0.y;
		this.m1.x = m.m1.x; this.m1.y = m.m1.y;
	}
	
	public Matrix2f initZero()
	{
		this.m0.x = 0; this.m0.y = 0;
		this.m1.x = 0; this.m1.y = 0;
		
		return this;
	}
	
	public Matrix2f initIdentity()
	{
		this.m0.x = 1; this.m0.y = 0;
		this.m1.x = 0; this.m1.y = 0;
	
		return this;
	}
	
	public static Matrix2f rotation(Vec2f up, Vec2f right) { return new Matrix2f().initRotation(up, right); }
	
	public Matrix2f initRotation(Vec2f up, Vec2f right)
	{
		this.m0.set(right);
		this.m1.set(up);
		
		return this;
	}
	
	public static Matrix2f iScaling(float sx, float sy) { return new Matrix2f().initScaling(sx, sy); }
	
	public Matrix2f initScaling(float sx, float sy)
	{
		this.m0.x = sx; this.m0.y = 0 ;
		this.m1.x = 0 ; this.m1.y = sy;
		
		return this;
	}
	
	
	
	public Matrix2f mul(Matrix2f m) { return Matrix2f.mul(this, m, null);		}
	
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
	
	public static Vector2f transform(Matrix2f l, Vec2fBase r, Vector2f dest)
	{
		if (dest == null) dest = new Vector2f();

		dest.setX(l.m0.x * r.getY() + l.m0.y * r.getX());
		dest.setY(l.m1.x * r.getY() + l.m1.y * r.getX());
		
		return dest;
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
		
		out[0] = this.m0.x;	out[1] = this.m0.y;
		out[2] = this.m1.x;	out[3] = this.m1.y;
		
		return out;
	}
	
	public FloatBuffer getRowMajorBuffer()
	{
		return BufferUtils.wrapFlippedFloatBuffer(getRowMajor());
	}
	
	public float[] getColMajor()
	{
		float[] out = new float[Matrix2f.ENTS];
		
		out[0] = this.m0.x;	out[2] = this.m0.y;
		out[1] = this.m1.x;	out[3] = this.m1.y;
		
		return out;
	}
	
	public FloatBuffer getColMajorBuffer()
	{
		return BufferUtils.wrapFlippedFloatBuffer(getColMajor());
	}
	
	
	
	public Matrix2f clone() { return new Matrix2f(this); }

}

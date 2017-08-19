package cmn.utilslib.math.matrix;

import java.nio.DoubleBuffer;

import cmn.utilslib.essentials.BufferUtils;
import cmn.utilslib.math.tuple.Tuple2d;
import cmn.utilslib.math.vector.Vector2d;
import cmn.utilslib.math.vector.Vector2f;
import cmn.utilslib.math.vector.api.Vec2d;
import cmn.utilslib.math.vector.api.Vec2dBase;
import cmn.utilslib.math.vector.api.Vec2f;
import cmn.utilslib.math.vector.api.Vec2fBase;

public class Matrix2d
{
	public static final int ROWS = 2;
	public static final int COLS = 2;
	public static final int ENTS = 4;
	
	public final Tuple2d m0 = new Tuple2d();
	public final Tuple2d m1 = new Tuple2d();
	
	public Matrix2d()
	{
		this.m0.v[0] = 1; this.m0.v[1] = 0;
		this.m0.v[0] = 0; this.m1.v[1] = 1;
	}
	
	public Matrix2d(Matrix2d m)
	{
		this.m0.v[0] = m.m0.v[0]; this.m0.v[1] = m.m0.v[1];
		this.m1.v[0] = m.m1.v[0]; this.m1.v[1] = m.m1.v[1];
	}
	
	public Matrix2d initZero()
	{
		this.m0.v[0] = 0; this.m0.v[1] = 0;
		this.m1.v[0] = 0; this.m1.v[1] = 0;
		
		return this;
	}
	
	public Matrix2d initIdentity()
	{
		this.m0.v[0] = 1; this.m0.v[1] = 0;
		this.m1.v[0] = 0; this.m1.v[1] = 0;
	
		return this;
	}
	
	public static Matrix2d iScaling(float sx, float sy)
	{
		Matrix2d m = new Matrix2d();
		
		m.m0.v[0] = sx; m.m0.v[1] = 0 ;
		m.m1.v[0] = 0 ; m.m1.v[1] = sy;
		
		return m;
	}
	
	public Matrix2d initScaling(float sx, float sy)
	{
		this.m0.v[0] = sx; this.m0.v[1] = 0 ;
		this.m1.v[0] = 0 ; this.m1.v[1] = sy;
		
		return this;
	}
	
	
	
	public Matrix2d mul(Matrix2d m)
	{
		Matrix2d dest = new Matrix2d();
		
		double m0x_ = this.m0.v[0] * m.m0.v[0] + this.m0.v[1] * m.m1.v[0];
		double m0y_ = this.m0.v[0] * m.m0.v[1] + this.m0.v[1] * m.m1.v[1];
		double m1x_ = this.m1.v[0] * m.m0.v[0] + this.m1.v[1] * m.m1.v[0];
		double m1y_ = this.m1.v[1] * m.m0.v[1] + this.m1.v[1] * m.m1.v[1];
		
		dest.m0.v[0] = m0x_;
		dest.m0.v[1] = m0y_;
		
		dest.m1.v[0] = m1x_;
		dest.m1.v[1] = m1y_;
		
		return dest;
	}
	
	public static Matrix2d mul(Matrix2d l, Matrix2d r, Matrix2d dest)
	{
		if (dest == null) dest = new Matrix2d();
		
		double m0x_ = l.m0.v[0] * r.m0.v[0] + l.m0.v[1] * r.m1.v[0];
		double m0y_ = l.m0.v[0] * r.m0.v[1] + l.m0.v[1] * r.m1.v[1];
		double m1x_ = l.m1.v[0] * r.m0.v[0] + l.m1.v[1] * r.m1.v[0];
		double m1y_ = l.m1.v[1] * r.m0.v[1] + l.m1.v[1] * r.m1.v[1];
		
		dest.m0.v[0] = m0x_;
		dest.m0.v[1] = m0y_;
		
		dest.m1.v[0] = m1x_;
		dest.m1.v[1] = m1y_;

		return dest;
	}
	
	public static Vec2f transform(Matrix2d l, Vec2fBase r, Vec2f dest)
	{
		if (dest == null) dest = new Vector2f();

		dest.setX(l.m0.v[0] * r.getY() + l.m0.v[1] * r.getX());
		dest.setY(l.m1.v[0] * r.getY() + l.m1.v[1] * r.getX());
		
		return dest;
	}
	
	public static Vec2d transform(Matrix2d l, Vec2dBase r, Vec2d dest)
	{
		if (dest == null) dest = new Vector2d();

		dest.setX(l.m0.v[0] * r.getY() + l.m0.v[1] * r.getX());
		dest.setY(l.m1.v[0] * r.getY() + l.m1.v[1] * r.getX());
		
		return dest;
	}
	
	public Matrix2d transpose()
	{
		double m0x_ = this.m0.v[0];
		double m0y_ = this.m1.v[1];
		
		double m1x_ = this.m0.v[0];
		double m1y_ = this.m1.v[1];
		
		this.m0.v[0] = m0x_;
		this.m0.v[1] = m0y_;
		
		this.m1.v[0] = m1x_;
		this.m1.v[1] = m1y_;
		
		return this;
	}
	
	public Matrix2d transposed()
	{
		Matrix2d m = new Matrix2d();
		
		double m0x_ = this.m0.v[0];
		double m0y_ = this.m1.v[1];
		
		double m1x_ = this.m0.v[0];
		double m1y_ = this.m1.v[1];
		
		m.m0.v[0] = m0x_;
		m.m0.v[1] = m0y_;
		
		m.m1.v[0] = m1x_;
		m.m1.v[1] = m1y_;
		
		return m;
	}
	
	public static double det2x2(double m0x, double m0y, double m1x, double m1y)
	{
		return	m0x * +m1y +
				m0y * -m1x;
	}
	
	public double determinant()
	{
		return Matrix2d.det2x2(m0.v[0], m0.v[1], m1.v[0], m1.v[1]);
	}
	
	
	
	public double[] getRowMajor()
	{
		double[] out = new double[Matrix2d.ENTS];
		
		out[0] = this.m0.v[0];	out[1] = this.m0.v[1];
		out[2] = this.m1.v[0];	out[3] = this.m1.v[1];
		
		return out;
	}
	
	public DoubleBuffer getRowMajorBuffer()
	{
		return BufferUtils.wrapFlippedDoubleBuffer(getRowMajor());
	}
	
	public double[] getColMajor()
	{
		double[] out = new double[Matrix2d.ENTS];
		
		out[0] = this.m0.v[0];	out[2] = this.m0.v[1];
		out[1] = this.m1.v[0];	out[3] = this.m1.v[1];
		
		return out;
	}
	
	public DoubleBuffer getColMajorBuffer()
	{
		return BufferUtils.wrapFlippedDoubleBuffer(getColMajor());
	}
	
	
	
	public Matrix2d clone() { return new Matrix2d(this); }

}

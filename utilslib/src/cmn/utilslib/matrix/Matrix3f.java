package cmn.utilslib.matrix;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.FloatBuffer;

import cmn.utilslib.essentials.BufferUtils;
import cmn.utilslib.geometry.Point3f;
import cmn.utilslib.interfaces.IStreamable;
import cmn.utilslib.vector.Quaternion;
import cmn.utilslib.vector.Vec3f;
import cmn.utilslib.vector.api.IVec3f;
import cmn.utilslib.vector.api.IVec3fBase;

/**
 * A 3 by 3 float Row Major Matrix 
 * 
 * @author picatrix1899
 *
 */
public class Matrix3f implements IStreamable, Serializable
{

	private static final long serialVersionUID = 1L;
	
	public static final int ROWS = 3;
	public static final int COLS = 3;
	public static final int ENTS = 9;
	
	public final Vec3f m0 = new Vec3f();
	public final Vec3f m1 = new Vec3f();
	public final Vec3f m2 = new Vec3f();
	
	public Matrix3f()
	{
		initZero();
	}
	
	private Matrix3f(Matrix3f m)
	{
		new Matrix3f().set(m);
	}
	
	public Matrix3f set(Matrix3f m)
	{
		this.m0.set(m.m0);
		this.m1.set(m.m1);
		this.m2.set(m.m2);
		
		return this;
	}
	
	public static Matrix3f iZero() { return new Matrix3f().initZero(); }
	
	public Matrix3f initZero()
	{
		this.m0.set(0.0f, 0.0f, 0.0f);
		this.m1.set(0.0f, 0.0f, 0.0f);
		this.m2.set(0.0f, 0.0f, 0.0f);
		
		return this;
	}
	
	public Matrix3f clone()
	{
		return new Matrix3f(this);
	}
	
	public static Matrix3f iIdentity() { return new Matrix3f().initIdendity(); }
	
	public Matrix3f initIdendity()
	{
		this.m0.set(1.0f, 0.0f, 0.0f);
		this.m1.set(0.0f, 1.0f, 0.0f);
		this.m2.set(0.0f, 0.0f, 1.0f);
		
		return this;
	}
	
	public static Matrix3f iRotation(Quaternion q) { return new Matrix3f().initRotation(q); }
	
	public Matrix3f initRotation(Quaternion q)
	{
		this.m0.setX(1.0d - 2.0d	*	(q.getY() * q.getY() + q.getZ() * q.getZ()));
		this.m0.setY(2.0d			*	(q.getX() * q.getY() - q.getW() * q.getZ()));
		this.m0.setZ(2.0d			*	(q.getX() * q.getZ() + q.getW() * q.getY()));
		
		this.m1.setX(2.0d			*	(q.getX() * q.getY() + q.getW() * q.getZ()));
		this.m1.setY(1.0d - 2.0d	*	(q.getX() * q.getX() + q.getZ() * q.getZ()));
		this.m1.setZ(2.0d			*	(q.getY() * q.getZ() - q.getW() * q.getX()));
		
		this.m2.setX(2.0d			*	(q.getX() * q.getZ() - q.getW() * q.getY()));
		this.m2.setY(2.0d			*	(q.getY() * q.getZ() + q.getW() * q.getX()));
		this.m2.setZ(1.0d - 2.0d	*	(q.getX() * q.getX() + q.getY() * q.getY()));
		
		return this;
	}
	
	public static Matrix3f iRotation(IVec3fBase axis, float angle) { return new Matrix3f().initRotation(axis, angle); }
	
	public Matrix3f initRotation(IVec3fBase axis, float angle)
	{
		float c = (float)Math.cos(angle);
		float s = (float)Math.sin(angle);
		
		float omc = 1 - c;
		
		float xy = axis.getX() * axis.getY();
		float xz = axis.getX() * axis.getZ();
		float yz = axis.getY() * axis.getZ();
		
		float sx = s * axis.getX();
		float sy = s * axis.getY();
		float sz = s * axis.getZ();
		
		this.m0.set(	axis.getX() * axis.getX() * omc + c	,	xy * omc - sz				,	xz * omc + sy				);
		this.m1.set(	xy * omc + sz				,	axis.getY() * axis.getY() * omc + c	,	yz * omc - sx				);
		this.m2.set(	xz * omc - sy				,	yz * omc + sx				,	axis.getZ() * axis.getZ() * omc + c	);
		
		return this;
	}
	
	public static Matrix3f iScaling(IVec3fBase v) { return new Matrix3f().initScaling(v); }
	
	public Matrix3f initScaling(IVec3fBase v)
	{
		return initScaling(v.getX(), v.getY(), v.getZ());
	}
	
	public static Matrix3f iScaling(float sx, float sy, float sz) { return new Matrix3f().initScaling(sx, sy, sz); }
	
	public Matrix3f initScaling(float sx, float sy, float sz)
	{
		this.m0.set(sx		, 0.0f	, 0.0f	);
		this.m1.set(0.0f	, sy	, 0.0f	);
		this.m2.set(0.0f	, 0.0f	, sz	);
		
		return this;
	}
	
	
	
	public Matrix3f mul(Matrix3f m)
	{
		return Matrix3f.mul(this, m, null);		
	}
	
	public static Matrix3f mul(Matrix3f l, Matrix3f r, Matrix3f dest)
	{
		if (dest == null) dest = new Matrix3f();
		
		float m0x_ = l.m0.x * r.m0.x + l.m0.y * r.m1.x + l.m0.z * r.m2.x;
		float m0y_ = l.m0.x * r.m0.y + l.m0.y * r.m1.y + l.m0.z * r.m2.y;
		float m0z_ = l.m0.x * r.m0.z + l.m0.y * r.m1.z + l.m0.z * r.m2.z;
		
		float m1x_ = l.m1.x * r.m0.x + l.m1.y * r.m1.x + l.m1.z * r.m2.x;
		float m1y_ = l.m1.x * r.m0.y + l.m1.y * r.m1.y + l.m1.z * r.m2.y;
		float m1z_ = l.m1.x * r.m0.z + l.m1.y * r.m1.z + l.m1.z * r.m2.z;
		
		float m2x_ = l.m2.x * r.m0.x + l.m2.y * r.m1.x + l.m2.z * r.m2.x;
		float m2y_ = l.m2.x * r.m0.y + l.m2.y * r.m1.y + l.m2.z * r.m2.y;
		float m2z_ = l.m2.x * r.m0.z + l.m2.y * r.m1.z + l.m2.z * r.m2.z;

		dest.m0.set(m0x_, m0y_, m0z_);
		dest.m1.set(m1x_, m1y_, m1z_);
		dest.m2.set(m2x_, m2y_, m2z_);
		
		return dest;
	}
	
	public IVec3f transformN(IVec3fBase v) { return transform(this, v, null); }
	
	public IVec3f transform(IVec3f v) { return transform(this, v, v); }
	
	public static IVec3f transform(Matrix3f l, IVec3fBase r, IVec3f dest)
	{
		if (dest == null) dest = new Vec3f();

		return dest.set(l.m0.dot(r), l.m1.dot(r), l.m2.dot(r));
	}
	
	public Point3f transformN(Point3f p) { return transform(this, p, null); }
	
	public Point3f transform(Point3f p) { return transform(this, p, p); }
	
	public static Point3f transform(Matrix3f l, Point3f r, Point3f dest)
	{
		if (dest == null) dest = new Point3f();

		float x_ = l.m0.x * r.x + l.m0.y * r.y + l.m0.z * r.z;
		float y_ = l.m1.x * r.x + l.m1.y * r.y + l.m1.z * r.z;
		float z_ = l.m2.x * r.x + l.m2.y * r.y + l.m2.z * r.z;

		dest.set(x_, y_, z_);
		
		return dest;
	}
	
	public float[] getRowMajor()
	{
		float[] out = new float[Matrix3f.ENTS];
		
		out[ 0] = this.m0.x;	out[ 1] = this.m0.y;	out[ 2] = this.m0.z;
		out[ 3] = this.m1.x;	out[ 4] = this.m1.y;	out[ 5] = this.m1.z;
		out[ 6] = this.m2.x;	out[ 7] = this.m2.y;	out[ 8] = this.m2.z;
		
		return out;
	}
	
	public FloatBuffer getRowMajorBuffer()
	{
		return (FloatBuffer) BufferUtils.wrapFloatBuffer(getRowMajor()).flip();
	}
	
	public FloatBuffer getColMajorBuffer() { return (FloatBuffer) BufferUtils.wrapFloatBuffer(getColMajor()).flip(); }	
	
	public float[] getColMajor()
	{
		float[] out = new float[Matrix3f.ENTS];
		
		out[ 0] = this.m0.x;	out[ 3] = this.m0.y;	out[ 6] = this.m0.z;
		out[ 1] = this.m1.x;	out[ 4] = this.m1.y;	out[ 7] = this.m1.z;
		out[ 2] = this.m2.x;	out[ 5] = this.m2.y;	out[ 8] = this.m2.z;
		
		return out;
	}
	

	
	public Matrix3f transpose()
	{
		float m0x_ = this.m0.x;
		float m0y_ = this.m1.y;
		float m0z_ = this.m2.z;
		
		float m1x_ = this.m0.x;
		float m1y_ = this.m1.y;
		float m1z_ = this.m2.z;
		
		float m2x_ = this.m0.x;
		float m2y_ = this.m1.y;
		float m2z_ = this.m2.z;
		
		this.m0.set(m0x_, m0y_, m0z_);
		this.m1.set(m1x_, m1y_, m1z_);
		this.m2.set(m2x_, m2y_, m2z_);
		
		return this;
	}


	
	public static float det3x3(float m0x, float m0y, float m0z, float m1x, float m1y, float m1z, float m2x, float m2y, float m2z)
	{
		return	m0x * +Matrix2f.det2x2(m1y, m1z, m2y, m2z) +
				m0y * -Matrix2f.det2x2(m1x, m1z, m2x, m2z) +
				m0z * +Matrix2f.det2x2(m1x, m1y, m2x, m2y);
	}
	
	public float determinant()
	{
		return Matrix3f.det3x3(m0.x, m0.y, m0.z, m1.x, m1.y, m1.z, m2.x, m2.y, m2.z);
	}
	
	public Matrix3f inversed()
	{
		
		Matrix3f m = new Matrix3f();
		
		m.m0.x = +Matrix2f.det2x2(this.m1.y, this.m1.z, this.m2.y, this.m2.z);
		m.m0.y = -Matrix2f.det2x2(this.m1.x, this.m1.z, this.m2.x, this.m2.z);
		m.m0.z = +Matrix2f.det2x2(this.m1.x, this.m1.y, this.m2.x, this.m2.y);

		m.m1.x = -Matrix2f.det2x2(this.m0.y, this.m0.z, this.m2.y, this.m2.z);
		m.m1.y = +Matrix2f.det2x2(this.m0.x, this.m0.z, this.m2.x, this.m2.z);
		m.m1.z = -Matrix2f.det2x2(this.m0.x, this.m0.y, this.m2.x, this.m2.y);
		
		m.m2.x = +Matrix2f.det2x2(this.m0.y, this.m0.z, this.m1.y, this.m1.z);
		m.m2.y = -Matrix2f.det2x2(this.m0.x, this.m0.z, this.m1.x, this.m1.z);
		m.m2.z = +Matrix2f.det2x2(this.m0.x, this.m0.y, this.m1.x, this.m1.y);

		double D = determinant();
		
		if(D != 0)
		{
			m0.div((float)D);
			m1.div((float)D);
			m2.div((float)D);	
		}
		
		return m;
	}
	
	public Matrix3f invert() { return set(inversed()); }

	public void readData(InputStream stream) throws IOException
	{
		this.m0.readData(stream);
		this.m1.readData(stream);
		this.m2.readData(stream);
	}

	public void writeData(OutputStream stream) throws IOException
	{
		this.m0.writeData(stream);
		this.m1.writeData(stream);
		this.m2.writeData(stream);
	}
}

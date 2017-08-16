package cmn.utilslib.math.matrix;

import java.nio.FloatBuffer;

import cmn.utilslib.essentials.BufferUtils;
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.tuple.Tuple3f;
import cmn.utilslib.math.vector.Vector3f;
import cmn.utilslib.math.vector.api.Vec3f;
import cmn.utilslib.math.vector.api.Vec3fBase;

/**
 * A 3 by 3 float Row Major Matrix 
 * 
 * @author picatrix1899
 *
 */
public class Matrix3f
{

	public static final int ROWS = 3;
	public static final int COLS = 3;
	public static final int ENTS = 9;
	
	public final Tuple3f m0 = new Tuple3f();
	public final Tuple3f m1 = new Tuple3f();
	public final Tuple3f m2 = new Tuple3f();
	
	public Matrix3f()
	{
		this.m0.v[0] = 1; this.m0.v[1] = 0; this.m0.v[2] = 0;
		this.m1.v[0] = 0; this.m1.v[1] = 1; this.m1.v[2] = 0;
		this.m2.v[0] = 0; this.m2.v[1] = 0; this.m2.v[2] = 1;
	}
	
	private Matrix3f(Matrix3f m)
	{
		this.m0.v[0] = m.m0.v[0]; this.m0.v[1] = m.m0.v[1]; this.m0.v[2] = m.m0.v[2];
		this.m1.v[0] = m.m1.v[0]; this.m1.v[1] = m.m1.v[1]; this.m1.v[2] = m.m1.v[2];
		this.m2.v[0] = m.m2.v[0]; this.m2.v[1] = m.m2.v[1]; this.m2.v[2] = m.m2.v[2];
	}
	
	public Matrix3f set(Matrix3f m)
	{
		this.m0.v[0] = m.m0.v[0]; this.m0.v[1] = m.m0.v[1]; this.m0.v[2] = m.m0.v[2];
		this.m1.v[0] = m.m1.v[0]; this.m1.v[1] = m.m1.v[1]; this.m1.v[2] = m.m1.v[2];
		this.m2.v[0] = m.m2.v[0]; this.m2.v[1] = m.m2.v[1]; this.m2.v[2] = m.m2.v[2];
		
		return this;
	}
	
	public static Matrix3f iZero() { return new Matrix3f().initZero(); }
	
	public Matrix3f initZero()
	{
		this.m0.v[0] = 0; this.m0.v[1] = 0; this.m0.v[2] = 0;
		this.m1.v[0] = 0; this.m1.v[1] = 0; this.m1.v[2] = 0;
		this.m2.v[0] = 0; this.m2.v[1] = 0; this.m2.v[2] = 0;
		
		return this;
	}
	
	public Matrix3f clone()
	{
		return new Matrix3f(this);
	}
	
	public static Matrix3f iIdentity() { return new Matrix3f().initIdendity(); }
	
	public Matrix3f initIdendity()
	{
		this.m0.v[0] = 1; this.m0.v[1] = 0; this.m0.v[2] = 0;
		this.m1.v[0] = 0; this.m1.v[1] = 1; this.m1.v[2] = 0;
		this.m2.v[0] = 0; this.m2.v[1] = 0; this.m2.v[2] = 1;
		
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
	
	public static Matrix3f iRotation(Vec3fBase axis, float angle) { return new Matrix3f().initRotation(axis, angle); }
	
	public Matrix3f initRotation(Vec3fBase axis, float angle)
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
	
	public static Matrix3f iScaling(Vec3fBase v) { return new Matrix3f().initScaling(v); }
	
	public Matrix3f initScaling(Vec3fBase v)
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
	
	public Vec3f transformN(Vec3fBase v) { return transform(this, v, null); }
	
	public Vec3f transform(Vector3f v) { return transform(this, v, v); }
	
	public static Vec3f transform(Matrix3f l, Vec3fBase r, Vector3f dest)
	{
		if (dest == null) dest = new Vector3f();

		return dest.set(l.m0.dot(r), l.m1.dot(r), l.m2.dot(r));
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

}

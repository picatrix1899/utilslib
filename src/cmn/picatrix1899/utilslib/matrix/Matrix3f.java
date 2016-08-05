package cmn.picatrix1899.utilslib.matrix;

import java.nio.FloatBuffer;

import cmn.picatrix1899.utilslib.essentials.BufferUtils;
import cmn.picatrix1899.utilslib.vector.Quaternion;
import cmn.picatrix1899.utilslib.vector.Vector3f;

/**
 * A 4 by 4 float matrix 
 * 
 * @author picatrix1899
 *
 */
public class Matrix3f
{
	
	public static final int ROWS = 3;
	public static final int COLS = 3;
	public static final int ENTS = 9;
	
	public final Vector3f m0 = new Vector3f();
	public final Vector3f m1 = new Vector3f();
	public final Vector3f m2 = new Vector3f();
	
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
		this.m0.x = (float)(1.0d - 2.0d	* (q.getY() * q.getY() + q.getZ() * q.getZ()));
		this.m0.y = (float)(2.0d		* (q.getX() * q.getY() - q.getW() * q.getZ()));
		this.m0.z = (float)(2.0d		* (q.getX() * q.getZ() + q.getW() * q.getY()));
		
		this.m1.x = (float)(2.0d		* (q.getX() * q.getY() + q.getW() * q.getZ()));
		this.m1.y = (float)(1.0d - 2.0d	* (q.getX() * q.getX() + q.getZ() * q.getZ()));
		this.m1.z = (float)(2.0d		* (q.getY() * q.getZ() - q.getW() * q.getX()));
		
		this.m2.x = (float)(2.0d		* (q.getX() * q.getZ() - q.getW() * q.getY()));
		this.m2.y = (float)(2.0d		* (q.getY() * q.getZ() + q.getW() * q.getX()));
		this.m2.z = (float)(1.0d - 2.0d	* (q.getX() * q.getX() + q.getY() * q.getY()));
		
		return this;
	}
	
	public static Matrix3f iRotation(Vector3f axis, float angle) { return new Matrix3f().initRotation(axis, angle); }
	
	public Matrix3f initRotation(Vector3f axis, float angle)
	{
		float c = (float)Math.cos(angle);
		float s = (float)Math.sin(angle);
		
		float omc = 1 - c;
		
		float xy = axis.x * axis.y;
		float xz = axis.x * axis.z;
		float yz = axis.y * axis.z;
		
		float sx = s * axis.x;
		float sy = s * axis.y;
		float sz = s * axis.z;
		
		this.m0.x = axis.x	* axis.x	* omc + c;
		this.m0.y = xy					* omc - sz;
		this.m0.z = xz					* omc + sy;
		
		this.m1.x = xy					* omc + sz;
		this.m1.y = axis.y * axis.y		* omc + c;
		this.m1.z = yz					* omc - sx;
		
		this.m2.x = xz					* omc - sy; 
		this.m2.y = yz					* omc + sx;
		this.m2.z = axis.z * axis.z		* omc + c;
		
		return this;
	}
	
	public static Matrix3f iScaling(Vector3f v) { return new Matrix3f().initScaling(v); }
	
	public Matrix3f initScaling(Vector3f v)
	{
		return initScaling(v.x, v.y, v.z);
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
	
	public static Vector3f transform(Matrix3f l, Vector3f r, Vector3f dest)
	{
		if (dest == null) dest = new Vector3f();

		return dest.set(l.m0.dot(r), l.m1.dot(r), l.m2.dot(r));
	}
	
	public float[] getRowMajor()
	{
		float[] out = new float[Matrix3f.ENTS];
		
		out[ 0] = this.m0.x;	out[ 1] = this.m0.y;	out[ 2] = this.m0.z;
		out[ 3] = this.m1.x;	out[ 4] = this.m1.y;	out[ 5] = this.m1.z;
		out[ 6] = this.m2.y;	out[ 7] = this.m2.y;	out[ 8] = this.m2.z;
		
		return out;
	}
	
	public FloatBuffer getRowMajorBuffer()
	{
		return (FloatBuffer) BufferUtils.wrapFloatBuffer(getRowMajor()).flip();
	}
	
	public float[] getColMajor()
	{
		float[] out = new float[Matrix3f.ENTS];
		
		out[ 0] = this.m0.x;	out[ 1] = this.m1.x;	out[ 2] = this.m2.x;
		out[ 3] = this.m0.y;	out[ 4] = this.m1.y;	out[ 5] = this.m2.y;
		out[ 6] = this.m0.z;	out[ 7] = this.m1.z;	out[ 8] = this.m2.z;
		
		return out;
	}
	
	public FloatBuffer getColMajorBuffer()
	{
		return (FloatBuffer) BufferUtils.wrapFloatBuffer(getColMajor()).flip();
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

	public static float det2x2(float m0x, float m0y, float m1x, float m1y)
	{
		return m0x*m1y - m0y*m1x;
	}
	
	public static float det3x3(float m0x, float m0y, float m0z, float m1x, float m1y, float m1z, float m2x, float m2y, float m2z)
	{
		return m0x*+det2x2(m1y, m1z, m2y, m2z) + m0y*-det2x2(m1x, m1z, m2x, m2z) + m0z*+det2x2(m1x, m1y, m2x, m2y);
	}
	
	public float determinant()
	{
		return Matrix3f.det3x3(m0.x, m0.y, m0.z, m1.x, m1.y, m1.z, m2.x, m2.y, m2.z);
	}
	
	public Matrix3f inverted()
	{
		
		Matrix3f m = new Matrix3f();
		
		m.m0.x = +	det2x2(this.m1.y, this.m1.z, this.m2.y, this.m2.z);
		m.m0.y = -	det2x2(this.m1.x, this.m1.z, this.m2.x, this.m2.z);
		m.m0.z = +	det2x2(this.m1.x, this.m1.y, this.m2.x, this.m2.y);

		m.m1.x = -	det2x2(this.m0.y, this.m0.z, this.m2.y, this.m2.z);
		m.m1.y = +	det2x2(this.m0.x, this.m0.z, this.m2.x, this.m2.z);
		m.m1.z = -	det2x2(this.m0.x, this.m0.y, this.m2.x, this.m2.y);
		
		m.m2.x = +	det2x2(this.m0.y, this.m0.z, this.m1.y, this.m1.z);
		m.m2.y = -	det2x2(this.m0.x, this.m0.z, this.m1.x, this.m1.z);
		m.m2.z = +	det2x2(this.m0.x, this.m0.y, this.m1.x, this.m1.y);

		double D = determinant();
		
		if(D != 0)
		{
			m0.div((float)D);
			m1.div((float)D);
			m2.div((float)D);	
		}
		
		return m;
	}
	
	public Matrix3f invert()
	{
		
		Matrix3f m = new Matrix3f();
		
		m.m0.x = +	det2x2(this.m1.y, this.m1.z, this.m2.y, this.m2.z);
		m.m0.y = -	det2x2(this.m1.x, this.m1.z, this.m2.x, this.m2.z);
		m.m0.z = +	det2x2(this.m1.x, this.m1.y, this.m2.x, this.m2.y);

		m.m1.x = -	det2x2(this.m0.y, this.m0.z, this.m2.y, this.m2.z);
		m.m1.y = +	det2x2(this.m0.x, this.m0.z, this.m2.x, this.m2.z);
		m.m1.z = -	det2x2(this.m0.x, this.m0.y, this.m2.x, this.m2.y);
		
		m.m2.x = +	det2x2(this.m0.y, this.m0.z, this.m1.y, this.m1.z);
		m.m2.y = -	det2x2(this.m0.x, this.m0.z, this.m1.x, this.m1.z);
		m.m2.z = +	det2x2(this.m0.x, this.m0.y, this.m1.x, this.m1.y);

		double D = determinant();
		
		if(D != 0)
		{
			m0.div((float)D);
			m1.div((float)D);
			m2.div((float)D);	
		}
		
		return set(m);
	}
	
	public Matrix3f inverse() { return invert(); }
	
	public Matrix3f inversed() { return inverted(); }
}

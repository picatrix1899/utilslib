package cmn.utilslib.math.matrix;

import java.nio.FloatBuffer;

import cmn.utilslib.essentials.BufferUtils;
import cmn.utilslib.math.Maths;
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.vector.Vector3f;
import cmn.utilslib.math.vector.api.Vec3f;

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
	
	public final Vector3f m0 = new Vector3f();
	public final Vector3f m1 = new Vector3f();
	public final Vector3f m2 = new Vector3f();
	
	public Matrix3f()
	{
		this.m0.setZero();
		this.m1.setZero();
		this.m2.setZero();
	}
	
	private Matrix3f(Matrix3f m)
	{
		this.m0.x = m.m0.x; this.m0.y = m.m0.y; this.m0.z = m.m0.z;
		this.m1.x = m.m1.x; this.m1.y = m.m1.y; this.m1.z = m.m1.z;
		this.m2.x = m.m2.x; this.m2.y = m.m2.y; this.m2.z = m.m2.z;
	}
	
	public Matrix3f set(Matrix3f m)
	{
		this.m0.x = m.m0.x; this.m0.y = m.m0.y; this.m0.z = m.m0.z;
		this.m1.x = m.m1.x; this.m1.y = m.m1.y; this.m1.z = m.m1.z;
		this.m2.x = m.m2.x; this.m2.y = m.m2.y; this.m2.z = m.m2.z;
		
		return this;
	}
	
	public static Matrix3f zero() { return new Matrix3f().initZero(); }
	
	public Matrix3f initZero()
	{
		this.m0.setZero();
		this.m1.setZero();
		this.m2.setZero();
		
		return this;
	}
	
	public static Matrix3f identity() { return new Matrix3f().initIdendity(); }
	
	public Matrix3f initIdendity()
	{
		this.m0.set(1, 0, 0);
		this.m1.set(0, 1, 0);
		this.m2.set(0, 0, 1);
		
		return this;
	}
	
	public static Matrix3f rotation(Vec3f forward, Vec3f up, Vec3f right) { return new Matrix3f().initRotation(forward, up, right); }
	
	public Matrix3f initRotation(Vec3f forward, Vec3f up, Vec3f right)
	{
		this.m0.set(right);
		this.m1.set(up);
		this.m2.set(forward);
		
		return this;
	}
	
	public Matrix3f initRotation(Vec3f forward, Vec3f up)
	{
		Vector3f f = (Vector3f)forward.normalizeN();
		Vector3f r = (Vector3f)up.normalizeN();
		r = r.cross(f);
		
		Vector3f u = f.cross(r);
		
		u.normalize();
		
		return initRotation(f, u, r);
	}
	
	
	public static Matrix3f rotation(Quaternion q)
	{
		return new Matrix3f().initRotation(q);
	}
	
	public Matrix3f initRotation(Quaternion q)
	{
		this.m0.x = (float)(1 - 2	*	(q.y * q.y + q.z * q.z));
		this.m0.y = (float)(2		*	(q.x * q.y - q.w * q.z));
		this.m0.z = (float)(2		*	(q.x * q.z + q.w * q.y));
		
		this.m1.x = (float)(2		*	(q.x * q.y + q.w * q.z));
		this.m1.y = (float)(1 - 2	*	(q.x * q.x + q.z * q.z));
		this.m1.z = (float)(2		*	(q.y * q.z - q.w * q.x));
		
		this.m2.x = (float)(2		*	(q.x * q.z - q.w * q.y));
		this.m2.y = (float)(2		*	(q.y * q.z + q.w * q.x));
		this.m2.z = (float)(1 - 2	*	(q.x * q.x + q.y * q.y));
		
		return this;
	}
	
	public static Matrix3f rotation(Vec3f axis, float angle) { return new Matrix3f().initRotation(axis, angle); }
	
	public Matrix3f initRotation(Vec3f axis, float angle)
	{
		double c = Math.cos(angle * Maths.DEG_TO_RAD);
		double s = Math.sin(angle * Maths.DEG_TO_RAD);
		
		double omc = 1 - c;
		
		float xy = axis.getX() * axis.getY();
		float xz = axis.getX() * axis.getZ();
		float yz = axis.getY() * axis.getZ();
		
		float sx = (float)s * axis.getX();
		float sy = (float)s * axis.getY();
		float sz = (float)s * axis.getZ();
		
		this.m0.x = (float)(axis.getX() * axis.getX() * omc + c);
		this.m0.y = (float)(xy * omc - sz);
		this.m0.z = (float)(xz * omc + sy);
		
		this.m1.x = (float)(xy * omc + sz);
		this.m1.y = (float)(axis.getY() * axis.getY() * omc + c);
		this.m1.z = (float)(yz * omc - sx);
		
		this.m2.x = (float)(xz * omc - sy);
		this.m2.y = (float)(yz * omc + sx);
		this.m2.z = (float)(axis.getZ() * axis.getZ() * omc + c);
		
		return this;
	}
	
	public static Matrix3f scaling(Vec3f v) { return new Matrix3f().initScaling(v); }
	
	public Matrix3f initScaling(Vec3f v)
	{
		this.m0.x = v.getX();
		this.m0.y = 0;
		this.m0.z = 0;
		
		this.m1.x = 0;
		this.m1.y = v.getY();
		this.m1.z = 0;
		
		this.m2.x = 0;
		this.m2.y = 0;
		this.m2.z = v.getZ();
		
		return this;
	}
	
	public static Matrix3f scaling(float sx, float sy, float sz) { return new Matrix3f().initScaling(sx, sy, sz); }
	
	public Matrix3f initScaling(float sx, float sy, float sz)
	{
		this.m0.x = sx;
		this.m0.y = 0;
		this.m0.z = 0;
		
		this.m1.x = 0;
		this.m1.y = sy;
		this.m1.z = 0;
		
		this.m2.x = 0;
		this.m2.y = 0;
		this.m2.z = sz;
		
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
	
	public Vector3f transformN(Vec3f v)
	{
		return transform(this, v, null);
	}
	
	public Vector3f transform(Vector3f dest)
	{
		if (dest == null) dest = new Vector3f();

		float x_ = this.m0.x * dest.x + this.m0.y * dest.y + this.m0.z * dest.z;
		float y_ = this.m1.x * dest.x + this.m1.y * dest.y + this.m1.z * dest.z;
		float z_ = this.m2.x * dest.x + this.m2.y * dest.y + this.m2.z * dest.z;

		dest.set(x_, y_, z_);
		
		return dest;
	}
	
	public static Vector3f transform(Matrix3f l, Vec3f r, Vector3f dest)
	{
		if (dest == null) dest = new Vector3f();

		float x_ = l.m0.x * r.getX() + l.m0.y * r.getY() + l.m0.z * r.getZ();
		float y_ = l.m1.x * r.getX() + l.m1.y * r.getY() + l.m1.z * r.getZ();
		float z_ = l.m2.x * r.getX() + l.m2.y * r.getY() + l.m2.z * r.getZ();
		
		dest.set(x_, y_ , z_);
		
		return dest;
	}
	

	public FloatBuffer getRowMajorBuffer() { return BufferUtils.wrapFlippedFloatBuffer(getRowMajor()); }
	
	public FloatBuffer getColMajorBuffer() { return BufferUtils.wrapFlippedFloatBuffer(getColMajor()); }	
	
	
	public float[] getColMajor()
	{
		float[] out = new float[Matrix3f.ENTS];
		
		out[0] = this.m0.x;	out[3] = this.m0.y;	out[6] = this.m0.z;
		out[1] = this.m1.x;	out[4] = this.m1.y;	out[7] = this.m1.z;
		out[2] = this.m2.x;	out[5] = this.m2.y;	out[8] = this.m2.z;
		
		return out;
	}
	
	public float[] getRowMajor()
	{
		float[] out = new float[Matrix3f.ENTS];
		
		out[0] = this.m0.x;	out[1] = this.m0.y;	out[2] = this.m0.z;
		out[3] = this.m1.x;	out[4] = this.m1.y;	out[5] = this.m1.z;
		out[6] = this.m2.x;	out[7] = this.m2.y;	out[8] = this.m2.z;
	
		return out;
	}

	
	public Matrix3f transpose()
	{
		float m0x_ = this.m0.x;
		float m0y_ = this.m1.x;
		float m0z_ = this.m2.x;
		
		float m1x_ = this.m0.y;
		float m1y_ = this.m1.y;
		float m1z_ = this.m2.y;
		
		float m2x_ = this.m0.z;
		float m2y_ = this.m1.z;
		float m2z_ = this.m2.z;
		
		this.m0.x = m0x_;
		this.m0.y = m0y_;
		this.m0.z = m0z_;
		
		this.m1.x = m1x_;
		this.m1.y = m1y_;
		this.m1.z = m1z_;
		
		this.m2.x = m2x_;
		this.m2.y = m2y_;
		this.m2.z = m2z_;

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
			m0.x /= D;
			m0.y /= D;
			m0.z /= D;
			
			m1.x /= D;
			m1.y /= D;
			m1.z /= D;
			
			m2.x /= D;
			m2.y /= D;
			m2.z /= D;	
		}
		
		return m;
	}
	
	public Matrix3f invert()
	{
		float m0x = +Matrix2f.det2x2(this.m1.y, this.m1.z, this.m2.y, this.m2.z);
		float m0y = -Matrix2f.det2x2(this.m1.x, this.m1.z, this.m2.x, this.m2.z);
		float m0z = +Matrix2f.det2x2(this.m1.x, this.m1.y, this.m2.x, this.m2.y);

		float m1x = -Matrix2f.det2x2(this.m0.y, this.m0.z, this.m2.y, this.m2.z);
		float m1y = +Matrix2f.det2x2(this.m0.x, this.m0.z, this.m2.x, this.m2.z);
		float m1z = -Matrix2f.det2x2(this.m0.x, this.m0.y, this.m2.x, this.m2.y);
		
		float m2x = +Matrix2f.det2x2(this.m0.y, this.m0.z, this.m1.y, this.m1.z);
		float m2y = -Matrix2f.det2x2(this.m0.x, this.m0.z, this.m1.x, this.m1.z);
		float m2z = +Matrix2f.det2x2(this.m0.x, this.m0.y, this.m1.x, this.m1.y);

		double D = determinant();
		
		if(D != 0)
		{
			m0x /= D;
			m0y /= D;
			m0z /= D;
			
			m1x /= D;
			m1y /= D;
			m1z /= D;
			
			m2x /= D;
			m2y /= D;
			m2z /= D;	
		}
		
		this.m0.x = m0x;
		this.m0.y = m0y;
		this.m0.z = m0z;
		
		this.m1.x = m1x;
		this.m1.y = m1y;
		this.m1.z = m1z;
		
		this.m2.x = m2x;
		this.m2.y = m2y;
		this.m2.z = m2z;
		
		return this;
	}
	
	public Matrix4f extend()
	{
		Matrix4f m = Matrix4f.identity();
		
		m.m0.set(m0.x, m0.y, m0.z,0);
		m.m1.set(m1.x, m1.y, m1.z,0);
		m.m2.set(m2.x, m2.y, m2.z,0);
		
		return m;
	}

	public Matrix3f clone()
	{
		return new Matrix3f(this);
	}
	
	public String toString()
	{
		return
				"matrix3f(	" + m0.x + "f	" + m0.y + "f	" + m0.z + "f	" + ")\n" + 
				"        (	" + m1.x + "f	" + m1.y + "f	" + m1.z + "f	" + ")\n" +
				"        (	" + m2.x + "f	" + m2.y + "f	" + m2.z + "f	" + ")";
	}
	
}

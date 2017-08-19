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
	
	public static Matrix3f iZero()
	{
		Matrix3f m = new Matrix3f();
		
		m.m0.v[0] = 0; m.m0.v[1] = 0; m.m0.v[2] = 0;
		m.m1.v[0] = 0; m.m1.v[1] = 0; m.m1.v[2] = 0;
		m.m2.v[0] = 0; m.m2.v[1] = 0; m.m2.v[2] = 0;
		
		return m;
	}
	
	public Matrix3f initZero()
	{
		this.m0.v[0] = 0; this.m0.v[1] = 0; this.m0.v[2] = 0;
		this.m1.v[0] = 0; this.m1.v[1] = 0; this.m1.v[2] = 0;
		this.m2.v[0] = 0; this.m2.v[1] = 0; this.m2.v[2] = 0;
		
		return this;
	}
	
	public static Matrix3f iIdentity()
	{
		Matrix3f m = new Matrix3f();
		
		m.m0.v[0] = 1; m.m0.v[1] = 0; m.m0.v[2] = 0;
		m.m1.v[0] = 0; m.m1.v[1] = 1; m.m1.v[2] = 0;
		m.m2.v[0] = 0; m.m2.v[1] = 0; m.m2.v[2] = 1;
		
		return m;
	}
	
	public Matrix3f initIdendity()
	{
		this.m0.v[0] = 1; this.m0.v[1] = 0; this.m0.v[2] = 0;
		this.m1.v[0] = 0; this.m1.v[1] = 1; this.m1.v[2] = 0;
		this.m2.v[0] = 0; this.m2.v[1] = 0; this.m2.v[2] = 1;
		
		return this;
	}
	
	public static Matrix3f iRotation(Quaternion q)
	{
		Matrix3f m = new Matrix3f();
		
		m.m0.v[0] = (float)(1 - 2		*	(q.y * q.y + q.z * q.z));
		m.m0.v[1] = (float)(2			*	(q.x * q.y - q.w * q.z));
		m.m0.v[2] = (float)(2			*	(q.x * q.z + q.w * q.y));
		
		m.m1.v[0] = (float)(2			*	(q.x * q.y + q.w * q.z));
		m.m1.v[1] = (float)(1 - 2		*	(q.x * q.x + q.z * q.z));
		m.m1.v[2] = (float)(2			*	(q.y * q.z - q.w * q.x));
		
		m.m2.v[0] = (float)(2			*	(q.x * q.z - q.w * q.y));
		m.m2.v[1] = (float)(2			*	(q.y * q.z + q.w * q.x));
		m.m2.v[2] = (float)(1 - 2		*	(q.x * q.x + q.y * q.y));
		
		return m;
	}
	
	public Matrix3f initRotation(Quaternion q)
	{
		this.m0.v[0] = (float)(1 - 2	*	(q.y * q.y + q.z * q.z));
		this.m0.v[1] = (float)(2		*	(q.x * q.y - q.w * q.z));
		this.m0.v[2] = (float)(2		*	(q.x * q.z + q.w * q.y));
		
		this.m1.v[0] = (float)(2		*	(q.x * q.y + q.w * q.z));
		this.m1.v[1] = (float)(1 - 2	*	(q.x * q.x + q.z * q.z));
		this.m1.v[2] = (float)(2		*	(q.y * q.z - q.w * q.x));
		
		this.m2.v[0] = (float)(2		*	(q.x * q.z - q.w * q.y));
		this.m2.v[1] = (float)(2		*	(q.y * q.z + q.w * q.x));
		this.m2.v[2] = (float)(1 - 2	*	(q.x * q.x + q.y * q.y));
		
		return this;
	}
	
	public static Matrix3f iRotation(Vec3fBase axis, float angle)
	{
		Matrix3f m = new Matrix3f();
		
		double c = Math.cos(angle);
		double s = Math.sin(angle);
		
		double omc = 1 - c;
		
		float xy = axis.getX() * axis.getY();
		float xz = axis.getX() * axis.getZ();
		float yz = axis.getY() * axis.getZ();
		
		float sx = (float)s * axis.getX();
		float sy = (float)s * axis.getY();
		float sz = (float)s * axis.getZ();
		
		m.m0.v[0] = (float)(axis.getX() * axis.getX() * omc + c);
		m.m0.v[1] = (float)(xy * omc - sz);
		m.m0.v[2] = (float)(xz * omc + sy);
		
		m.m1.v[0] = (float)(xy * omc + sz);
		m.m1.v[1] = (float)(axis.getY() * axis.getY() * omc + c);
		m.m1.v[2] = (float)(yz * omc - sx);
		
		m.m2.v[0] = (float)(xz * omc - sy);
		m.m2.v[1] = (float)(yz * omc + sx);
		m.m2.v[2] = (float)(axis.getZ() * axis.getZ() * omc + c);
		
		return m;
	}
	
	public Matrix3f initRotation(Vec3fBase axis, float angle)
	{
		double c = Math.cos(angle);
		double s = Math.sin(angle);
		
		double omc = 1 - c;
		
		float xy = axis.getX() * axis.getY();
		float xz = axis.getX() * axis.getZ();
		float yz = axis.getY() * axis.getZ();
		
		float sx = (float)s * axis.getX();
		float sy = (float)s * axis.getY();
		float sz = (float)s * axis.getZ();
		
		this.m0.v[0] = (float)(axis.getX() * axis.getX() * omc + c);
		this.m0.v[1] = (float)(xy * omc - sz);
		this.m0.v[2] = (float)(xz * omc + sy);
		
		this.m1.v[0] = (float)(xy * omc + sz);
		this.m1.v[1] = (float)(axis.getY() * axis.getY() * omc + c);
		this.m1.v[2] = (float)(yz * omc - sx);
		
		this.m2.v[0] = (float)(xz * omc - sy);
		this.m2.v[1] = (float)(yz * omc + sx);
		this.m2.v[2] = (float)(axis.getZ() * axis.getZ() * omc + c);
		
		return this;
	}
	
	public static Matrix3f iScaling(Vec3fBase v)
	{
		Matrix3f m = new Matrix3f();
		
		m.m0.v[0] = v.getX();
		m.m0.v[1] = 0;
		m.m0.v[2] = 0;
		
		m.m1.v[0] = 0;
		m.m1.v[1] = v.getY();
		m.m1.v[2] = 0;
		
		m.m2.v[0] = 0;
		m.m2.v[1] = 0;
		m.m2.v[2] = v.getZ();
		
		return m;
	}
	
	public static Matrix3f iScaling(float sx, float sy, float sz)
	{
		Matrix3f m = new Matrix3f();
		
		m.m0.v[0] = sx;
		m.m0.v[1] = 0;
		m.m0.v[2] = 0;
		
		m.m1.v[0] = 0;
		m.m1.v[1] = sy;
		m.m1.v[2] = 0;
		
		m.m2.v[0] = 0;
		m.m2.v[1] = 0;
		m.m2.v[2] = sz;
		
		return m;
	}
	
	public Matrix3f initScaling(Vec3fBase v)
	{
		this.m0.v[0] = v.getX();
		this.m0.v[1] = 0;
		this.m0.v[2] = 0;
		
		this.m1.v[0] = 0;
		this.m1.v[1] = v.getY();
		this.m1.v[2] = 0;
		
		this.m2.v[0] = 0;
		this.m2.v[1] = 0;
		this.m2.v[2] = v.getZ();
		
		return this;
	}
	
	public Matrix3f initScaling(float sx, float sy, float sz)
	{
		this.m0.v[0] = sx;
		this.m0.v[1] = 0;
		this.m0.v[2] = 0;
		
		this.m1.v[0] = 0;
		this.m1.v[1] = sy;
		this.m1.v[2] = 0;
		
		this.m2.v[0] = 0;
		this.m2.v[1] = 0;
		this.m2.v[2] = sz;
		
		return this;
	}
	
	
	
	public Matrix3f mul(Matrix3f m)
	{
		return Matrix3f.mul(this, m, null);		
	}
	
	public static Matrix3f mul(Matrix3f l, Matrix3f r, Matrix3f dest)
	{
		if (dest == null) dest = new Matrix3f();
		
		float m0x_ = l.m0.v[0] * r.m0.v[0] + l.m0.v[1] * r.m1.v[0] + l.m0.v[2] * r.m2.v[0];
		float m0y_ = l.m0.v[0] * r.m0.v[1] + l.m0.v[1] * r.m1.v[1] + l.m0.v[2] * r.m2.v[1];
		float m0z_ = l.m0.v[0] * r.m0.v[2] + l.m0.v[1] * r.m1.v[2] + l.m0.v[2] * r.m2.v[2];
		
		float m1x_ = l.m1.v[0] * r.m0.v[0] + l.m1.v[1] * r.m1.v[0] + l.m1.v[2] * r.m2.v[0];
		float m1y_ = l.m1.v[0] * r.m0.v[1] + l.m1.v[1] * r.m1.v[1] + l.m1.v[2] * r.m2.v[1];
		float m1z_ = l.m1.v[0] * r.m0.v[2] + l.m1.v[1] * r.m1.v[2] + l.m1.v[2] * r.m2.v[2];
		
		float m2x_ = l.m2.v[0] * r.m0.v[0] + l.m2.v[1] * r.m1.v[0] + l.m2.v[2] * r.m2.v[0];
		float m2y_ = l.m2.v[0] * r.m0.v[1] + l.m2.v[1] * r.m1.v[1] + l.m2.v[2] * r.m2.v[1];
		float m2z_ = l.m2.v[0] * r.m0.v[2] + l.m2.v[1] * r.m1.v[2] + l.m2.v[2] * r.m2.v[2];

		dest.m0.set(m0x_, m0y_, m0z_);
		dest.m1.set(m1x_, m1y_, m1z_);
		dest.m2.set(m2x_, m2y_, m2z_);
		
		return dest;
	}
	
	public Vec3f transformN(Vec3fBase v)
	{
		return transform(this, v, null);
	}
	
	public Vec3f transform(Vec3f dest)
	{
		if (dest == null) dest = new Vector3f();

		dest.setX(this.m0.v[0] * dest.getX() + this.m0.v[1] * dest.getY() + this.m0.v[2] * dest.getZ());
		dest.setY(this.m1.v[0] * dest.getX() + this.m1.v[1] * dest.getY() + this.m1.v[2] * dest.getZ());
		dest.setZ(this.m2.v[0] * dest.getX() + this.m2.v[1] * dest.getY() + this.m2.v[2] * dest.getZ());
		
		return dest;
	}
	
	public static Vec3f transform(Matrix3f l, Vec3fBase r, Vec3f dest)
	{
		if (dest == null) dest = new Vector3f();

		dest.setX(l.m0.v[0] * r.getX() + l.m0.v[1] * r.getY() + l.m0.v[2] * r.getZ());
		dest.setY(l.m1.v[0] * r.getX() + l.m1.v[1] * r.getY() + l.m1.v[2] * r.getZ());
		dest.setZ(l.m2.v[0] * r.getX() + l.m2.v[1] * r.getY() + l.m2.v[2] * r.getZ());
		
		return dest;
	}
	

	public FloatBuffer getRowMajorBuffer() { return BufferUtils.wrapFlippedFloatBuffer(getRowMajor()); }
	
	public FloatBuffer getColMajorBuffer() { return BufferUtils.wrapFlippedFloatBuffer(getColMajor()); }	
	
	
	public float[] getColMajor()
	{
		float[] out = new float[Matrix3f.ENTS];
		
		out[0] = this.m0.v[0];	out[3] = this.m0.v[1];	out[6] = this.m0.v[2];
		out[1] = this.m1.v[0];	out[4] = this.m1.v[1];	out[7] = this.m1.v[2];
		out[2] = this.m2.v[0];	out[5] = this.m2.v[1];	out[8] = this.m2.v[2];
		
		return out;
	}
	
	public float[] getRowMajor()
	{
		float[] out = new float[Matrix3f.ENTS];
		
		out[0] = this.m0.v[0];	out[1] = this.m0.v[1];	out[2] = this.m0.v[2];
		out[3] = this.m1.v[0];	out[4] = this.m1.v[1];	out[5] = this.m1.v[2];
		out[6] = this.m2.v[0];	out[7] = this.m2.v[1];	out[8] = this.m2.v[2];
	
		return out;
	}

	
	public Matrix3f transpose()
	{
		float m0x_ = this.m0.v[0];
		float m0y_ = this.m1.v[0];
		float m0z_ = this.m2.v[0];
		
		float m1x_ = this.m0.v[1];
		float m1y_ = this.m1.v[1];
		float m1z_ = this.m2.v[1];
		
		float m2x_ = this.m0.v[2];
		float m2y_ = this.m1.v[2];
		float m2z_ = this.m2.v[2];
		
		this.m0.v[0] = m0x_;
		this.m0.v[1] = m0y_;
		this.m0.v[2] = m0z_;
		
		this.m1.v[0] = m1x_;
		this.m1.v[1] = m1y_;
		this.m1.v[2] = m1z_;
		
		this.m2.v[0] = m2x_;
		this.m2.v[1] = m2y_;
		this.m2.v[2] = m2z_;

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
		return Matrix3f.det3x3(m0.v[0], m0.v[1], m0.v[2], m1.v[0], m1.v[1], m1.v[2], m2.v[0], m2.v[1], m2.v[2]);
	}
	
	public Matrix3f inversed()
	{
		
		Matrix3f m = new Matrix3f();
		
		m.m0.v[0] = +Matrix2f.det2x2(this.m1.v[1], this.m1.v[2], this.m2.v[1], this.m2.v[2]);
		m.m0.v[1] = -Matrix2f.det2x2(this.m1.v[0], this.m1.v[2], this.m2.v[0], this.m2.v[2]);
		m.m0.v[2] = +Matrix2f.det2x2(this.m1.v[0], this.m1.v[1], this.m2.v[0], this.m2.v[1]);

		m.m1.v[0] = -Matrix2f.det2x2(this.m0.v[1], this.m0.v[2], this.m2.v[1], this.m2.v[2]);
		m.m1.v[1] = +Matrix2f.det2x2(this.m0.v[0], this.m0.v[2], this.m2.v[0], this.m2.v[2]);
		m.m1.v[2] = -Matrix2f.det2x2(this.m0.v[0], this.m0.v[1], this.m2.v[0], this.m2.v[1]);
		
		m.m2.v[0] = +Matrix2f.det2x2(this.m0.v[1], this.m0.v[2], this.m1.v[1], this.m1.v[2]);
		m.m2.v[1] = -Matrix2f.det2x2(this.m0.v[0], this.m0.v[2], this.m1.v[0], this.m1.v[2]);
		m.m2.v[2] = +Matrix2f.det2x2(this.m0.v[0], this.m0.v[1], this.m1.v[0], this.m1.v[1]);

		double D = determinant();
		
		if(D != 0)
		{
			m0.v[0] /= (float)D;
			m0.v[1] /= (float)D;
			m0.v[2] /= (float)D;
			
			m1.v[0] /= (float)D;
			m1.v[1] /= (float)D;
			m1.v[2] /= (float)D;
			
			m2.v[0] /= (float)D;
			m2.v[1] /= (float)D;
			m2.v[2] /= (float)D;	
		}
		
		return m;
	}
	
	public Matrix3f invert()
	{
		float m0x = +Matrix2f.det2x2(this.m1.v[1], this.m1.v[2], this.m2.v[1], this.m2.v[2]);
		float m0y = -Matrix2f.det2x2(this.m1.v[0], this.m1.v[2], this.m2.v[0], this.m2.v[2]);
		float m0z = +Matrix2f.det2x2(this.m1.v[0], this.m1.v[1], this.m2.v[0], this.m2.v[1]);

		float m1x = -Matrix2f.det2x2(this.m0.v[1], this.m0.v[2], this.m2.v[1], this.m2.v[2]);
		float m1y = +Matrix2f.det2x2(this.m0.v[0], this.m0.v[2], this.m2.v[0], this.m2.v[2]);
		float m1z = -Matrix2f.det2x2(this.m0.v[0], this.m0.v[1], this.m2.v[0], this.m2.v[1]);
		
		float m2x = +Matrix2f.det2x2(this.m0.v[1], this.m0.v[2], this.m1.v[1], this.m1.v[2]);
		float m2y = -Matrix2f.det2x2(this.m0.v[0], this.m0.v[2], this.m1.v[0], this.m1.v[2]);
		float m2z = +Matrix2f.det2x2(this.m0.v[0], this.m0.v[1], this.m1.v[0], this.m1.v[1]);

		double D = determinant();
		
		if(D != 0)
		{
			m0x /= (float)D;
			m0y /= (float)D;
			m0z /= (float)D;
			
			m1x /= (float)D;
			m1y /= (float)D;
			m1z /= (float)D;
			
			m2x /= (float)D;
			m2y /= (float)D;
			m2z /= (float)D;	
		}
		
		this.m0.v[0] = m0x;
		this.m0.v[1] = m0y;
		this.m0.v[2] = m0z;
		
		this.m1.v[0] = m1x;
		this.m1.v[1] = m1y;
		this.m1.v[2] = m1z;
		
		this.m2.v[0] = m2x;
		this.m2.v[1] = m2y;
		this.m2.v[2] = m2z;
		
		return this;
	}

	public Matrix3f clone()
	{
		return new Matrix3f(this);
	}
	
}

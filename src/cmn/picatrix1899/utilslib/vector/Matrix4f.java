package cmn.picatrix1899.utilslib.vector;

import java.nio.FloatBuffer;

import cmn.picatrix1899.utilslib.essentials.BufferUtils;

/**
 * A 4 by 4 float matrix 
 * 
 * @author picatrix1899
 *
 */
public class Matrix4f
{
	
	public static final int ROWS = 4;
	public static final int COLS = 4;
	public static final int ENTS = 16;
	
	public float m00, m01, m02, m03;
	public float m10, m11, m12, m13;
	public float m20, m21, m22, m23;
	public float m30, m31, m32, m33;
	
	public Matrix4f()
	{
		initZero();
	}
	
	private Matrix4f(Matrix4f m)
	{
		new Matrix4f().set(m);
	}
	
	public Matrix4f set(Matrix4f m)
	{
		this.m00 = m.m00;
		this.m01 = m.m01;
		this.m02 = m.m02;
		this.m03 = m.m03;
		
		this.m10 = m.m10;
		this.m11 = m.m11;
		this.m12 = m.m12;
		this.m13 = m.m13;
		
		this.m20 = m.m20;
		this.m21 = m.m21;
		this.m22 = m.m22;
		this.m23 = m.m23;
		
		this.m30 = m.m30;
		this.m31 = m.m31;
		this.m32 = m.m32;
		this.m33 = m.m33;
		
		return this;
	}
	
	public static Matrix4f iZero() { return new Matrix4f().initZero(); }
	
	public Matrix4f initZero()
	{
		this.m00 = 0.0f;
		this.m01 = 0.0f;
		this.m02 = 0.0f;
		this.m03 = 0.0f;
		
		this.m10 = 0.0f;
		this.m11 = 0.0f;
		this.m12 = 0.0f;
		this.m13 = 0.0f;
		
		this.m20 = 0.0f;
		this.m21 = 0.0f;
		this.m22 = 0.0f;
		this.m23 = 0.0f;
		
		this.m30 = 0.0f;
		this.m31 = 0.0f;
		this.m32 = 0.0f;
		this.m33 = 0.0f;
		
		return this;
	}
	
	public Matrix4f clone()
	{
		return new Matrix4f(this);
	}
	
	public static Matrix4f iIdentity() { return new Matrix4f().initIdendity(); }
	
	public Matrix4f initIdendity()
	{
		this.m00 = 1.0f;
		this.m01 = 0.0f;
		this.m02 = 0.0f;
		this.m03 = 0.0f;
		
		this.m10 = 0.0f;
		this.m11 = 1.0f;
		this.m12 = 0.0f;
		this.m13 = 0.0f;
		
		this.m20 = 0.0f; 
		this.m21 = 0.0f;
		this.m22 = 1.0f;
		this.m23 = 0.0f;
		
		this.m30 = 0.0f;
		this.m31 = 0.0f;
		this.m32 = 0.0f;
		this.m33 = 1.0f;
		
		return this;
	}
	
	public static Matrix4f iRotation(Quaternion q) { return new Matrix4f().initRotation(q); }
	
	public Matrix4f initRotation(Quaternion q)
	{
		
		this.m00 = (float)(1.0d - 2.0d * (q.getY() * q.getY() + q.getZ() * q.getZ()));
		this.m01 = (float)(2.0d * (q.getX() * q.getY() - q.getW() * q.getZ()));
		this.m02 = (float)(2.0d * (q.getX() * q.getZ() + q.getW() * q.getY()));
		this.m03 = (float)(0.0d);
		
		this.m10 = (float)(2.0d * (q.getX() * q.getY() + q.getW() * q.getZ()));
		this.m11 = (float)(1.0d - 2.0d * (q.getX() * q.getX() + q.getZ() * q.getZ()));
		this.m12 = (float)(2.0d * (q.getY() * q.getZ() - q.getW() * q.getX()));
		this.m13 = (float)(0.0d);
		
		this.m20 = (float)(2.0d * (q.getX() * q.getZ() - q.getW() * q.getY()));
		this.m21 = (float)(2.0d * (q.getY() * q.getZ() + q.getW() * q.getX()));
		this.m22 = (float)(1.0d - 2.0d * (q.getX() * q.getX() + q.getY() * q.getY()));
		this.m23 = (float)(0.0d);
		
		this.m30 = (float)(0.0d);
		this.m31 = (float)(0.0d);
		this.m32 = (float)(0.0d);
		this.m33 = (float)(1.0d);
		
		return this;
	}
	
	public static Matrix4f iRotation(Vector3f axis, float angle) { return new Matrix4f().initRotation(axis, angle); }
	
	public Matrix4f initRotation(Vector3f axis, float angle)
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
		
		this.m00 = axis.x * axis.x * omc + c;
		this.m01 = xy * omc - sz;
		this.m02 = xz * omc + sy;
		this.m03 = 0.0f;
		
		this.m10 = xy * omc + sz;
		this.m11 = axis.y * axis.y * omc + c;
		this.m12 = yz * omc - sx;
		this.m13 = 0.0f;
		
		this.m20 = xz * omc - sy; 
		this.m21 = yz * omc + sx;
		this.m22 = axis.z * axis.z * omc + c;
		this.m23 = 0.0f;
		
		this.m30 = 0.0f;
		this.m31 = 0.0f;
		this.m32 = 0.0f;
		this.m33 = 1.0f;
		
		return this;
	}
	
	public static Matrix4f iTranslation(Vector3f v) { return new Matrix4f().initTranslation(v); }
	
	public Matrix4f initTranslation(Vector3f v) { return initTranslation(v.x, v.y, v.z); }
	
	public static Matrix4f iTranslation(float tx, float ty, float tz) { return new Matrix4f().initTranslation(tx, ty, tz); }
	
	public Matrix4f initTranslation(float tx, float ty, float tz)
	{
		
		this.m00 = 1.0f;
		this.m01 = 0.0f;
		this.m02 = 0.0f;
		this.m03 = tx;
		
		this.m10 = 0.0f;
		this.m11 = 1.0f;
		this.m12 = 0.0f;
		this.m13 = ty;
		
		this.m20 = 0.0f; 
		this.m21 = 0.0f;
		this.m22 = 1.0f;
		this.m23 = tz;
		
		this.m30 = 0.0f;
		this.m31 = 0.0f;
		this.m32 = 0.0f;
		this.m33 = 1.0f;
		
		return this;
	}
	
	public static Matrix4f iScaling(Vector3f v) { return new Matrix4f().initScaling(v); }
	
	public Matrix4f initScaling(Vector3f v)
	{
		return initScaling(v.x, v.y, v.z);
	}
	
	public static Matrix4f iScaling(float sx, float sy, float sz) { return new Matrix4f().initScaling(sx, sy, sz); }
	
	public Matrix4f initScaling(float sx, float sy, float sz)
	{
		
		this.m00 = sx;
		this.m01 = 0.0f;
		this.m02 = 0.0f;
		this.m03 = 0.0f;
		
		this.m10 = 0.0f;
		this.m11 = sy;
		this.m12 = 0.0f;
		this.m13 = 0.0f;
		
		this.m20 = 0.0f; 
		this.m21 = 0.0f;
		this.m22 = sz;
		this.m23 = 0.0f;
		
		this.m30 = 0.0f;
		this.m31 = 0.0f;
		this.m32 = 0.0f;
		this.m33 = 1.0f;
		
		return this;
	}
	
	public static Matrix4f iModelMatrix(Vector3f pos, Quaternion rot, Vector3f scale) { return new Matrix4f().initModelMatrix(pos, rot, scale); }
	
	public Matrix4f initModelMatrix(Vector3f pos, Quaternion rot, Vector3f scale)
	{
		if(scale == null) scale = new Vector3f(1.0f, 1.0f, 1.0f);
		
		initIdendity();
		translate(pos);
		rotate(rot);
		scale(scale);
		
		return this;
	}
	
	public static Matrix4f iViewMatrix(Vector3f pos, Quaternion rot) { return new Matrix4f().initViewMatrix(pos, rot); }
	
	public Matrix4f initViewMatrix(Vector3f pos, Quaternion rot)
	{
		initIdendity();
		
		translate(pos.inverted());
		rotate(rot.conjugated());
		
		return this;
	}
	
	
	public Matrix4f translate(Vector3f v){ return translate(v, this); }
	
	public Matrix4f translate(float tx, float ty, float tz) { return translate(tx, ty, tz, this); }
	
	public Matrix4f translate(Vector3f v, Matrix4f dest) { return translate(v, this, dest); }
	
	public Matrix4f translate(float tx, float ty, float tz, Matrix4f dest) { return translate(tx, ty, tz, this, dest); }
	
	public Matrix4f translate(Vector3f v, Matrix4f src, Matrix4f dest) { return translate(v.x, v.y, v.z, src, dest); }
	
	public Matrix4f translate(float tx, float ty, float tz, Matrix4f src, Matrix4f dest) { return Matrix4f.mul(new Matrix4f().initTranslation(tx, ty, tz), src, dest); }
	
	
	
	public Matrix4f rotate(Quaternion q) { return rotate(q, this); }
	
	public Matrix4f rotate(Quaternion q, Matrix4f dest) { return rotate(q, this, dest); }
	
	public Matrix4f rotate(Quaternion q, Matrix4f src, Matrix4f dest) { return Matrix4f.mul(new Matrix4f().initRotation(q), src, dest); }
	
	
	
	public Matrix4f rotate(Vector3f axis, float angle) { return rotate(axis, angle, this); }
	
	public Matrix4f rotate(Vector3f axis, float angle, Matrix4f dest) { return rotate(axis, angle, this, dest); }
	
	public Matrix4f rotate(Vector3f axis, float angle, Matrix4f src, Matrix4f dest) { return Matrix4f.mul(new Matrix4f().initRotation(axis, angle), src, dest); }
	
	
	
	public Matrix4f scale(Vector3f v) { return scale(v.x, v.y, v.z); }
	
	public Matrix4f scale(float sx,float sy,float sz) { return scale(sx, sy, sz, this); }
	
	public Matrix4f scale(Vector3f v, Matrix4f dest) { return scale(v.x, v.y, v.z, this, dest); }
	
	public Matrix4f scale(float sx, float sy, float sz, Matrix4f dest) { return scale(sx, sy, sz, this, dest); }
	
	public Matrix4f scale(Vector3f v, Matrix4f src, Matrix4f dest) { return scale(v.x, v.y, v.z, src, dest); }
	
	public Matrix4f scale(float sx, float sy, float sz, Matrix4f src, Matrix4f dest) { return Matrix4f.mul(new Matrix4f().initScaling(sx,  sy,  sz), src, dest); }
	
	
	
	public Matrix4f mul(Matrix4f m)
	{
		return Matrix4f.mul(this, m, null);		
	}
	
	public static Matrix4f mul(Matrix4f l, Matrix4f r, Matrix4f dest)
	{
		if (dest == null)
		{
			dest = new Matrix4f();
		}
		
		float m00_ = l.m00 * r.m00 + l.m01 * r.m10 + l.m02 * r.m20 + l.m03 * r.m30;
		float m01_ = l.m00 * r.m01 + l.m01 * r.m11 + l.m02 * r.m21 + l.m03 * r.m31;
		float m02_ = l.m00 * r.m02 + l.m01 * r.m12 + l.m02 * r.m22 + l.m03 * r.m32;
		float m03_ = l.m00 * r.m03 + l.m01 * r.m13 + l.m02 * r.m23 + l.m03 * r.m33;
		
		float m10_ = l.m10 * r.m00 + l.m11 * r.m10 + l.m12 * r.m20 + l.m13 * r.m30;
		float m11_ = l.m10 * r.m01 + l.m11 * r.m11 + l.m12 * r.m21 + l.m13 * r.m31;
		float m12_ = l.m10 * r.m02 + l.m11 * r.m12 + l.m12 * r.m22 + l.m13 * r.m32;
		float m13_ = l.m10 * r.m03 + l.m11 * r.m13 + l.m12 * r.m23 + l.m13 * r.m33;
		
		float m20_ = l.m20 * r.m00 + l.m21 * r.m10 + l.m22 * r.m20 + l.m23 * r.m30;
		float m21_ = l.m20 * r.m01 + l.m21 * r.m11 + l.m22 * r.m21 + l.m23 * r.m31;
		float m22_ = l.m20 * r.m02 + l.m21 * r.m12 + l.m22 * r.m22 + l.m23 * r.m32;
		float m23_ = l.m20 * r.m03 + l.m21 * r.m13 + l.m22 * r.m23 + l.m23 * r.m33;
		
		float m30_ = l.m30 * r.m00 + l.m31 * r.m10 + l.m32 * r.m20 + l.m33 * r.m30;
		float m31_ = l.m30 * r.m01 + l.m31 * r.m11 + l.m32 * r.m21 + l.m33 * r.m31;
		float m32_ = l.m30 * r.m02 + l.m31 * r.m12 + l.m32 * r.m22 + l.m33 * r.m32;
		float m33_ = l.m30 * r.m03 + l.m31 * r.m13 + l.m32 * r.m23 + l.m33 * r.m33;

		dest.m00 = m00_;
		dest.m01 = m01_;
		dest.m02 = m02_;
		dest.m03 = m03_;
		
		dest.m10 = m10_;
		dest.m11 = m11_;
		dest.m12 = m12_;
		dest.m13 = m13_;
		
		dest.m20 = m20_;
		dest.m21 = m21_;
		dest.m22 = m22_;
		dest.m23 = m23_;
		
		dest.m30 = m30_;
		dest.m31 = m31_;
		dest.m32 = m32_;
		dest.m33 = m33_;
		
		
		return dest;
	}
	
	public static Vector3f transform(Matrix4f l, Vector3f r, Vector3f dest)
	{
		if (dest == null)
		{
			dest = new Vector3f();
		}
		
		float x = l.m00 * r.x + l.m01 * r.y + l.m02 * r.z + l.m03 * 1.0f;
		float y = l.m10 * r.x + l.m11 * r.y + l.m12 * r.z + l.m13 * 1.0f;
		float z = l.m20 * r.x + l.m21 * r.y + l.m22 * r.z + l.m23 * 1.0f;

		dest.setX(x).setY(y).setZ(z);
		
		return dest;
	}
	
	public static Vector4f transform(Matrix4f l, Vector4f r, Vector4f dest)
	{
		if (dest == null)
		{
			dest = new Vector4f();
		}
		
		float x = l.m00 * r.x + l.m01 * r.y + l.m02 * r.z + l.m03 * r.a;
		float y = l.m10 * r.x + l.m11 * r.y + l.m12 * r.z + l.m13 * r.a;
		float z = l.m20 * r.x + l.m21 * r.y + l.m22 * r.z + l.m23 * r.a;
		float a = l.m30 * r.x + l.m31 * r.y + l.m32 * r.z + l.m33 * r.a;

		dest.setX(x).setY(y).setZ(z).setA(a);
		
		return dest;
	}
	
	public float[] getRowMajor()
	{
		float[] out = new float[Matrix4f.ENTS];
		
		out[ 0] = this.m00;	out[ 1] = this.m01;	out[ 2] = this.m02;	out[ 3] = this.m03;
		out[ 4] = this.m10;	out[ 5] = this.m11;	out[ 6] = this.m12;	out[ 7] = this.m13;
		out[ 8] = this.m20;	out[ 9] = this.m21;	out[10] = this.m22;	out[11] = this.m23;
		out[12] = this.m30;	out[13] = this.m31;	out[14] = this.m32;	out[15] = this.m33;
		
		return out;
	}
	
	public FloatBuffer getRowMajorBuffer()
	{
		return (FloatBuffer) BufferUtils.wrapFloatBuffer(getRowMajor()).flip();
	}
	
	public float[] getColMajor()
	{
		float[] out = new float[Matrix4f.ENTS];
		
		out[ 0] = this.m00;	out[ 1] = this.m10;	out[ 2] = this.m20;	out[ 3] = this.m30;
		out[ 4] = this.m01;	out[ 5] = this.m11;	out[ 6] = this.m21;	out[ 7] = this.m31;
		out[ 8] = this.m02;	out[ 9] = this.m12;	out[10] = this.m22;	out[11] = this.m32;
		out[12] = this.m03;	out[13] = this.m13;	out[14] = this.m23;	out[15] = this.m33;
		
		return out;
	}
	
	public FloatBuffer getColMajorBuffer()
	{
		return (FloatBuffer) BufferUtils.wrapFloatBuffer(getColMajor()).flip();
	}
	
	public Matrix4f transpose()
	{
		float m00_ = this.m00;
		float m01_ = this.m10;
		float m02_ = this.m20;
		float m03_ = this.m30;
		
		float m10_ = this.m01;
		float m11_ = this.m11;
		float m12_ = this.m21;
		float m13_ = this.m31;
		
		float m20_ = this.m02;
		float m21_ = this.m12;
		float m22_ = this.m22;
		float m23_ = this.m32;
		
		float m30_ = this.m03;
		float m31_ = this.m13;
		float m32_ = this.m23;
		float m33_ = this.m33;
		
		this.m00 = m00_;
		this.m01 = m01_;
		this.m02 = m02_;
		this.m03 = m03_;
		
		this.m10 = m10_;
		this.m11 = m11_;
		this.m12 = m12_;
		this.m13 = m13_;
		
		this.m20 = m20_;
		this.m21 = m21_;
		this.m22 = m22_;
		this.m23 = m23_;
		
		this.m30 = m30_;
		this.m31 = m31_;
		this.m32 = m32_;
		this.m33 = m33_;
		
		return this;
	}

	public static float det4x4(float m0x, float m0y, float m0z, float m0w,
								float m1x, float m1y, float m1z, float m1w,
								float m2x, float m2y, float m2z, float m2w,
								float m3x, float m3y, float m3z, float m3w)
	{
		float out = 0;
		
		out += m0x*+Matrix3f.det3x3(m1y, m1z, m1w, m2y, m2z, m2w, m3y, m3z, m3w);
		out += m0y*+Matrix3f.det3x3(m1x, m1z, m1w, m2x, m2z, m2w, m3x, m3z, m3w);
		out += m0z*+Matrix3f.det3x3(m1x, m1y, m1w, m2x, m2y, m2w, m3x, m3y, m3w);
		out += m0w*+Matrix3f.det3x3(m1x, m1y, m1z, m2x, m2y, m2z, m3x, m3y, m3z);
		
		return out;
	}
	
	public Matrix4f inverted()
	{
		
		Matrix4f m = new Matrix4f();
		
		m.m00 =      m11*m22*m33 - m11*m23*m32 - m21*m12*m33 + m21*m13*m32 + m31*m12*m23 - m31*m13*m22;
		m.m01 =    - m01*m22*m33 + m01*m23*m32 + m21*m02*m33 - m21*m03*m32 - m31*m02*m23 + m31*m03*m22;
		m.m02 =      m01*m12*m33 - m01*m13*m32 - m11*m02*m33 + m11*m03*m32 + m31*m02*m13 - m31*m03*m12;
		m.m03 =    - m01*m12*m23 + m01*m13*m22 + m11*m02*m23 - m11*m03*m22 - m21*m02*m13 + m21*m03*m12;
		
		m.m10 =    - m10*m22*m33 + m10*m23*m32 + m20*m12*m33 - m20*m13*m32 - m30*m12*m23 + m30*m13*m22;
		m.m11 =      m00*m22*m33 - m00*m23*m32 - m20*m02*m33 + m20*m03*m32 + m30*m02*m23 - m30*m03*m22;
		m.m12 =    - m00*m12*m33 + m00*m13*m32 + m10*m02*m33 - m10*m03*m32 - m30*m02*m13 + m30*m03*m12;
		m.m13 =      m00*m12*m23 - m00*m13*m22 - m10*m02*m23 + m10*m03*m22 + m20*m02*m13 - m20*m03*m12;
		
		m.m20 =      m10*m21*m33 - m10*m23*m31 - m20*m11*m33 + m20*m13*m31 + m30*m11*m23 - m30*m13*m21;
		m.m21 =    - m00*m21*m33 + m00*m23*m31 + m20*m01*m33 - m20*m03*m31 - m30*m01*m23 + m30*m03*m21;
		m.m22 =      m00*m11*m33 - m00*m13*m31 - m10*m01*m33 + m10*m03*m31 + m30*m01*m13 - m30*m03*m11;
		m.m23 =    - m00*m11*m23 + m00*m13*m21 + m10*m01*m23 - m10*m03*m21 - m20*m01*m13 + m20*m03*m11;
		
		m.m30 =    - m10*m21*m32 + m10*m22*m31 + m20*m11*m32 - m20*m12*m31 - m30*m11*m22 + m30*m12*m21;
		m.m31 =      m00*m21*m32 - m00*m22*m31 - m20*m01*m32 + m20*m02*m31 + m30*m01*m22 - m30*m02*m21;
		m.m32 =    - m00*m11*m32 + m00*m12*m31 + m10*m01*m32 - m10*m02*m31 - m30*m01*m12 + m30*m02*m11;
		m.m33 =      m00*m11*m22 - m00*m12*m21 - m10*m01*m22 + m10*m02*m21 + m20*m01*m12 - m20*m02*m11;
		
		double D = m00*m.m00 + m10*m.m01 +  m20*m.m02 + m30*m.m03;
		
		if(D != 0)
		{
			m.m00 /=D; m.m01 /=D; m.m02 /=D; m.m03 /=D;
			m.m10 /=D; m.m11 /=D; m.m12 /=D; m.m13 /=D;
			m.m20 /=D; m.m21 /=D; m.m22 /=D; m.m23 /=D;
			m.m30 /=D; m.m31 /=D; m.m32 /=D; m.m33 /=D;
		}
		
		return m;
	}
	
	public Matrix4f invert()
	{
		
		Matrix4f m = new Matrix4f();
		
		m.m00 =      m11*m22*m33 - m11*m32*m23 - m12*m21*m33 + m12*m31*m23 + m13*m21*m32 - m13*m31*m22;
		m.m10 =    - m10*m22*m33 + m10*m32*m23 + m12*m20*m33 - m12*m30*m23 - m13*m20*m32 + m13*m30*m22;
		m.m20 =      m10*m21*m33 - m10*m31*m23 - m11*m20*m33 + m11*m30*m23 + m13*m20*m31 - m13*m30*m21;
		m.m30 =    - m10*m21*m32 + m10*m31*m22 + m11*m20*m32 - m11*m30*m22 - m12*m20*m31 + m12*m30*m21;
		
		m.m01 =    - m01*m22*m33 + m01*m32*m23 + m02*m21*m33 - m02*m31*m23 - m03*m21*m32 + m03*m31*m22;
		m.m11 =      m00*m22*m33 - m00*m32*m23 - m02*m20*m33 + m02*m30*m23 + m03*m20*m32 - m03*m30*m22;
		m.m21 =    - m00*m21*m33 + m00*m31*m23 + m01*m20*m33 - m01*m30*m23 - m03*m20*m31 + m03*m30*m21;
		m.m31 =      m00*m21*m32 - m00*m31*m22 - m01*m20*m32 + m01*m30*m22 + m02*m20*m31 - m02*m30*m21;
		
		m.m02 =      m01*m12*m33 - m01*m32*m13 - m02*m11*m33 + m02*m31*m13 + m03*m11*m32 - m03*m31*m12;
		m.m12 =    - m00*m12*m33 + m00*m32*m13 + m02*m10*m33 - m02*m30*m13 - m03*m10*m32 + m03*m30*m12;
		m.m22 =      m00*m11*m33 - m00*m31*m13 - m01*m10*m33 + m01*m30*m13 + m03*m10*m31 - m03*m30*m11;
		m.m32 =    - m00*m11*m32 + m00*m31*m12 + m01*m10*m32 - m01*m30*m12 - m02*m10*m31 + m02*m30*m11;
		
		m.m03 =    - m01*m12*m23 + m01*m22*m13 + m02*m11*m23 - m02*m21*m13 - m03*m11*m22 + m03*m21*m12;
		m.m13 =      m00*m12*m23 - m00*m22*m13 - m02*m10*m23 + m02*m20*m13 + m03*m10*m22 - m03*m20*m12;
		m.m23 =    - m00*m11*m23 + m00*m21*m13 + m01*m10*m23 - m01*m20*m13 - m03*m10*m21 + m03*m20*m11;
		m.m33 =      m00*m11*m22 - m00*m21*m12 - m01*m10*m22 + m01*m20*m12 + m02*m10*m21 - m02*m20*m11;
		
		double D = m00*m.m00 + m01*m.m10 +  m02*m.m20 + m03*m.m30;
		
		if(D != 0)
		{
			m.m00 /=D; m.m10 /=D; m.m20 /=D; m.m30 /=D;
			m.m01 /=D; m.m11 /=D; m.m21 /=D; m.m31 /=D;
			m.m02 /=D; m.m12 /=D; m.m22 /=D; m.m32 /=D;
			m.m03 /=D; m.m13 /=D; m.m23 /=D; m.m33 /=D;
		}
		
		return set(m);
	}
	
}

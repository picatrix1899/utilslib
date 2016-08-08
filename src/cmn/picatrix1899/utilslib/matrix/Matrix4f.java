package cmn.picatrix1899.utilslib.matrix;

import java.nio.FloatBuffer;

import cmn.picatrix1899.utilslib.essentials.BufferUtils;
import cmn.picatrix1899.utilslib.vector.Quaternion;
import cmn.picatrix1899.utilslib.vector.Vector3f;
import cmn.picatrix1899.utilslib.vector.Vector4f;

/**
 * A 4 by 4 float Row Major Matrix 
 * 
 * @author picatrix1899
 *
 */
public class Matrix4f
{
	
	public static final int ROWS = 4;
	public static final int COLS = 4;
	public static final int ENTS = 16;
	
//	public float m00, m01, m02, m03;
//	public float m10, m11, m12, m13;
//	public float m20, m21, m22, m23;
//	public float m30, m31, m32, m33;
	
	public Vector4f m0;
	public Vector4f m1;
	public Vector4f m2;
	public Vector4f m3;
	
	public Matrix4f()
	{
		initZero();
	}
	
	private Matrix4f(Matrix4f m)
	{
		set(m);
	}
	
	public Matrix4f set(Matrix4f m)
	{
		
		this.m0 = m.m0;
		this.m1 = m.m1;
		this.m2 = m.m2;
		this.m3 = m.m3;
		
		return this;
	}
	
	public static Matrix4f iZero() { return new Matrix4f().initZero(); }
	
	public Matrix4f initZero()
	{
		this.m0.setZero();
		this.m1.setZero();
		this.m2.setZero();
		this.m3.setZero();
		
		return this;
	}
	
	public Matrix4f clone()
	{
		return new Matrix4f(this);
	}
	
	public static Matrix4f iIdentity() { return new Matrix4f().initIdendity(); }
	
	public Matrix4f initIdendity()
	{
		this.m0.set(1.0f, 0.0f, 0.0f, 0.0f);
		this.m1.set(0.0f, 1.0f, 0.0f, 0.0f);
		this.m2.set(0.0f, 0.0f, 1.0f, 0.0f);
		this.m3.set(0.0f, 0.0f, 0.0f, 1.0f);
		
		return this;
	}
	
	public static Matrix4f iRotation(Quaternion q) { return new Matrix4f().initRotation(q); }
	
	public Matrix4f initRotation(Quaternion q)
	{
		
		this.m0.setX(1.0d - 2.0d * (q.getY() * q.getY() + q.getZ() * q.getZ()));
		this.m0.setY(2.0d * (q.getX() * q.getY() - q.getW() * q.getZ()));
		this.m0.setZ(2.0d * (q.getX() * q.getZ() + q.getW() * q.getY()));
		this.m0.setA(0.0d);
		
		this.m1.setX(2.0d * (q.getX() * q.getY() + q.getW() * q.getZ()));
		this.m1.setY(1.0d - 2.0d * (q.getX() * q.getX() + q.getZ() * q.getZ()));
		this.m1.setZ(2.0d * (q.getY() * q.getZ() - q.getW() * q.getX()));
		this.m1.setA(0.0d);
		
		this.m2.setX(2.0d * (q.getX() * q.getZ() - q.getW() * q.getY()));
		this.m2.setY(2.0d * (q.getY() * q.getZ() + q.getW() * q.getX()));
		this.m2.setZ(1.0d - 2.0d * (q.getX() * q.getX() + q.getY() * q.getY()));
		this.m2.setA(0.0d);
		
		this.m3.set(0.0d, 0.0d, 0.0d, 1.0d);
		
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
		
		this.m0.x = axis.x * axis.x * omc + c;
		this.m0.y = xy * omc - sz;
		this.m0.z = xz * omc + sy;
		this.m0.a = 0.0f;
		
		this.m1.x = xy * omc + sz;
		this.m1.y = axis.y * axis.y * omc + c;
		this.m1.z = yz * omc - sx;
		this.m1.a = 0.0f;
		
		this.m2.x = xz * omc - sy; 
		this.m2.y = yz * omc + sx;
		this.m2.z = axis.z * axis.z * omc + c;
		this.m2.a = 0.0f;
		
		this.m3.x = 0.0f;
		this.m3.y = 0.0f;
		this.m3.z = 0.0f;
		this.m3.a = 1.0f;
		
		return this;
	}
	
	public static Matrix4f iTranslation(Vector3f v) { return new Matrix4f().initTranslation(v); }
	
	public Matrix4f initTranslation(Vector3f v) { return initTranslation(v.x, v.y, v.z); }
	
	public static Matrix4f iTranslation(float tx, float ty, float tz) { return new Matrix4f().initTranslation(tx, ty, tz); }
	
	public Matrix4f initTranslation(float tx, float ty, float tz)
	{
		
		this.m0.x = 1.0f;
		this.m0.y = 0.0f;
		this.m0.z = 0.0f;
		this.m0.a = tx;
		
		this.m1.x = 0.0f;
		this.m1.y = 1.0f;
		this.m1.z = 0.0f;
		this.m1.a = ty;
		
		this.m2.x = 0.0f; 
		this.m2.y = 0.0f;
		this.m2.z = 1.0f;
		this.m2.a = tz;
		
		this.m3.x = 0.0f;
		this.m3.y = 0.0f;
		this.m3.z = 0.0f;
		this.m3.a = 1.0f;
		
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
		
		this.m0.x = sx;
		this.m0.y = 0.0f;
		this.m0.z = 0.0f;
		this.m0.a = 0.0f;
		
		this.m1.x = 0.0f;
		this.m1.y = sy;
		this.m1.z = 0.0f;
		this.m1.a = 0.0f;
		
		this.m2.x = 0.0f; 
		this.m2.y = 0.0f;
		this.m2.z = sz;
		this.m2.a = 0.0f;
		
		this.m3.x = 0.0f;
		this.m3.y = 0.0f;
		this.m3.z = 0.0f;
		this.m3.a = 1.0f;
		
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
		
		float m00_ = l.m0.x * r.m0.x + l.m0.y * r.m1.x + l.m0.z * r.m2.x + l.m0.a * r.m3.x;
		float m01_ = l.m0.x * r.m0.y + l.m0.y * r.m1.y + l.m0.z * r.m2.y + l.m0.a * r.m3.y;
		float m02_ = l.m0.x * r.m0.z + l.m0.y * r.m1.z + l.m0.z * r.m2.z + l.m0.a * r.m3.z;
		float m03_ = l.m0.x * r.m0.a + l.m0.y * r.m1.a + l.m0.z * r.m2.a + l.m0.a * r.m3.a;
		
		float m10_ = l.m1.x * r.m0.x + l.m1.y * r.m1.x + l.m1.z * r.m2.x + l.m1.a * r.m3.x;
		float m11_ = l.m1.x * r.m0.y + l.m1.y * r.m1.y + l.m1.z * r.m2.y + l.m1.a * r.m3.y;
		float m12_ = l.m1.x * r.m0.z + l.m1.y * r.m1.z + l.m1.z * r.m2.z + l.m1.a * r.m3.z;
		float m13_ = l.m1.x * r.m0.a + l.m1.y * r.m1.a + l.m1.z * r.m2.a + l.m1.a * r.m3.a;
		
		float m20_ = l.m2.x * r.m0.x + l.m2.y * r.m1.x + l.m2.z * r.m2.x + l.m2.a * r.m3.x;
		float m21_ = l.m2.x * r.m0.y + l.m2.y * r.m1.y + l.m2.z * r.m2.y + l.m2.a * r.m3.y;
		float m22_ = l.m2.x * r.m0.z + l.m2.y * r.m1.z + l.m2.z * r.m2.z + l.m2.a * r.m3.z;
		float m23_ = l.m2.x * r.m0.a + l.m2.y * r.m1.a + l.m2.z * r.m2.a + l.m2.a * r.m3.a;
		
		float m30_ = l.m3.x * r.m0.x + l.m3.y * r.m1.x + l.m3.z * r.m2.x + l.m3.a * r.m3.x;
		float m31_ = l.m3.x * r.m0.y + l.m3.y * r.m1.y + l.m3.z * r.m2.y + l.m3.a * r.m3.y;
		float m32_ = l.m3.x * r.m0.z + l.m3.y * r.m1.z + l.m3.z * r.m2.z + l.m3.a * r.m3.z;
		float m33_ = l.m3.x * r.m0.a + l.m3.y * r.m1.a + l.m3.z * r.m2.a + l.m3.a * r.m3.a;

		dest.m0.x = m00_;
		dest.m0.y = m01_;
		dest.m0.z = m02_;
		dest.m0.a = m03_;
		
		dest.m1.x = m10_;
		dest.m1.y = m11_;
		dest.m1.z = m12_;
		dest.m1.a = m13_;
		
		dest.m2.x = m20_;
		dest.m2.y = m21_;
		dest.m2.z = m22_;
		dest.m2.a = m23_;
		
		dest.m3.x = m30_;
		dest.m3.y = m31_;
		dest.m3.z = m32_;
		dest.m3.a = m33_;
		
		
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
		out += m0y*-Matrix3f.det3x3(m1x, m1z, m1w, m2x, m2z, m2w, m3x, m3z, m3w);
		out += m0z*+Matrix3f.det3x3(m1x, m1y, m1w, m2x, m2y, m2w, m3x, m3y, m3w);
		out += m0w*-Matrix3f.det3x3(m1x, m1y, m1z, m2x, m2y, m2z, m3x, m3y, m3z);
		
		return out;
	}
	
	public float determinant()
	{
		return det4x4(m0.x, m0.y, m0.z, m0.a, m1.x, m1.y, m1.z, m1.a, m2.x, m2.y, m2.z, m2.a, m3.x, m3.y, m3.z, m3.a);
	}
	
	public Matrix4f inverted()
	{
		
		Matrix4f m = new Matrix4f();
		
		m.m0.x = Matrix3f.det3x3(this.m1.y, this.m1.z, this.m1.a, this.m2.y, this.m2.z, this.m2.a, this.m3.y, this.m3.z, this.m3.a);
		m.m0.x = Matrix3f.det3x3(this.m1.x, this.m1.z, this.m1.a, this.m2.x, this.m2.z, this.m2.a, this.m3.x, this.m3.z, this.m3.a);
		m.m0.x = Matrix3f.det3x3(this.m1.x, this.m1.y, this.m1.a, this.m2.x, this.m2.y, this.m2.a, this.m3.x, this.m3.y, this.m3.a);
		m.m0.x = Matrix3f.det3x3(this.m1.x, this.m1.y, this.m1.z, this.m2.x, this.m2.y, this.m2.z, this.m3.x, this.m3.y, this.m3.z);
		
		m.m0.x = Matrix3f.det3x3(this.m0.y, this.m0.z, this.m0.a, this.m2.y, this.m2.z, this.m2.a, this.m3.y, this.m3.z, this.m3.a);
		m.m0.x = Matrix3f.det3x3(this.m0.x, this.m0.z, this.m0.a, this.m2.x, this.m2.z, this.m2.a, this.m3.x, this.m3.z, this.m3.a);
		m.m0.x = Matrix3f.det3x3(this.m0.x, this.m0.y, this.m0.a, this.m2.x, this.m2.y, this.m2.a, this.m3.x, this.m3.y, this.m3.a);
		m.m0.x = Matrix3f.det3x3(this.m0.x, this.m0.y, this.m0.z, this.m2.x, this.m2.y, this.m2.z, this.m3.x, this.m3.y, this.m3.z);
		
		m.m0.x = Matrix3f.det3x3(this.m0.y, this.m0.z, this.m0.a, this.m1.y, this.m1.z, this.m1.a, this.m3.y, this.m3.z, this.m3.a);
		m.m0.x = Matrix3f.det3x3(this.m0.x, this.m0.z, this.m0.a, this.m1.x, this.m1.z, this.m1.a, this.m3.x, this.m3.z, this.m3.a);
		m.m0.x = Matrix3f.det3x3(this.m0.x, this.m0.y, this.m0.a, this.m1.x, this.m1.y, this.m1.a, this.m3.x, this.m3.y, this.m3.a);
		m.m0.x = Matrix3f.det3x3(this.m0.x, this.m0.y, this.m0.z, this.m1.x, this.m1.y, this.m1.z, this.m3.x, this.m3.y, this.m3.z);
		
		m.m0.x = Matrix3f.det3x3(this.m0.y, this.m0.z, this.m0.a, this.m1.y, this.m1.z, this.m1.a, this.m2.y, this.m2.z, this.m2.a);
		m.m0.x = Matrix3f.det3x3(this.m0.x, this.m0.z, this.m0.a, this.m1.x, this.m1.z, this.m1.a, this.m2.x, this.m2.z, this.m2.a);
		m.m0.x = Matrix3f.det3x3(this.m0.x, this.m0.y, this.m0.a, this.m1.x, this.m1.y, this.m1.a, this.m2.x, this.m2.y, this.m2.a);
		m.m0.x = Matrix3f.det3x3(this.m0.x, this.m0.y, this.m0.z, this.m1.x, this.m1.y, this.m1.z, this.m2.x, this.m2.y, this.m2.z);
		
		double D = determinant();
		
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

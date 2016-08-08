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
		
		float x = l.m0.x * r.x + l.m0.y * r.y + l.m0.z * r.z + l.m0.a * 1.0f;
		float y = l.m1.x * r.x + l.m1.y * r.y + l.m1.z * r.z + l.m1.a * 1.0f;
		float z = l.m2.x * r.x + l.m2.y * r.y + l.m2.z * r.z + l.m2.a * 1.0f;

		dest.setX(x).setY(y).setZ(z);
		
		return dest;
	}
	
	public static Vector4f transform(Matrix4f l, Vector4f r, Vector4f dest)
	{
		if (dest == null)
		{
			dest = new Vector4f();
		}
		
		float x = l.m0.x * r.x + l.m0.y * r.y + l.m0.z * r.z + l.m0.a * r.a;
		float y = l.m1.x * r.x + l.m1.y * r.y + l.m1.z * r.z + l.m1.a * r.a;
		float z = l.m2.x * r.x + l.m2.y * r.y + l.m2.z * r.z + l.m2.a * r.a;
		float a = l.m3.x * r.x + l.m3.y * r.y + l.m3.z * r.z + l.m3.a * r.a;

		dest.setX(x).setY(y).setZ(z).setA(a);
		
		return dest;
	}
	
	public float[] getRowMajor()
	{
		float[] out = new float[Matrix4f.ENTS];
		
		out[ 0] = this.m0.x;	out[ 1] = this.m0.y;	out[ 2] = this.m0.z;	out[ 3] = this.m0.a;
		out[ 4] = this.m1.x;	out[ 5] = this.m1.y;	out[ 6] = this.m1.z;	out[ 7] = this.m1.a;
		out[ 8] = this.m2.x;	out[ 9] = this.m2.y;	out[10] = this.m2.z;	out[11] = this.m2.a;
		out[12] = this.m3.x;	out[13] = this.m3.y;	out[14] = this.m3.z;	out[15] = this.m3.a;
		
		return out;
	}
	
	public FloatBuffer getRowMajorBuffer()
	{
		return (FloatBuffer) BufferUtils.wrapFloatBuffer(getRowMajor()).flip();
	}
	
	public float[] getColMajor()
	{
		float[] out = new float[Matrix4f.ENTS];
		
		out[ 0] = this.m0.x;	out[ 1] = this.m1.x;	out[ 2] = this.m2.x;	out[ 3] = this.m3.x;
		out[ 4] = this.m0.y;	out[ 5] = this.m1.y;	out[ 6] = this.m2.y;	out[ 7] = this.m3.y;
		out[ 8] = this.m0.z;	out[ 9] = this.m1.z;	out[10] = this.m2.z;	out[11] = this.m3.z;
		out[12] = this.m0.a;	out[13] = this.m1.a;	out[14] = this.m2.a;	out[15] = this.m3.a;
		
		return out;
	}
	
	public FloatBuffer getColMajorBuffer()
	{
		return (FloatBuffer) BufferUtils.wrapFloatBuffer(getColMajor()).flip();
	}
	
	public Matrix4f transpose()
	{
		float m00_ = this.m0.x;
		float m01_ = this.m1.x;
		float m02_ = this.m2.x;
		float m03_ = this.m3.x;
		
		float m10_ = this.m0.y;
		float m11_ = this.m1.y;
		float m12_ = this.m2.y;
		float m13_ = this.m3.y;
		
		float m20_ = this.m0.z;
		float m21_ = this.m1.z;
		float m22_ = this.m2.z;
		float m23_ = this.m3.z;
		
		float m30_ = this.m0.a;
		float m31_ = this.m1.a;
		float m32_ = this.m2.a;
		float m33_ = this.m3.a;
		
		this.m0.x = m00_;
		this.m0.y = m01_;
		this.m0.z = m02_;
		this.m0.a = m03_;
		
		this.m1.x = m10_;
		this.m1.y = m11_;
		this.m1.z = m12_;
		this.m1.a = m13_;
		
		this.m2.x = m20_;
		this.m2.y = m21_;
		this.m2.z = m22_;
		this.m2.a = m23_;
		
		this.m3.x = m30_;
		this.m3.y = m31_;
		this.m3.z = m32_;
		this.m3.a = m33_;
		
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
			m.m0.x /=D; m.m0.y /=D; m.m0.z /=D; m.m0.a /=D;
			m.m1.x /=D; m.m1.y /=D; m.m1.z /=D; m.m1.a /=D;
			m.m2.x /=D; m.m2.y /=D; m.m2.z /=D; m.m2.a /=D;
			m.m3.x /=D; m.m3.y /=D; m.m3.z /=D; m.m3.a /=D;
		}
		
		return m;
	}
	
	public Matrix4f invert()
	{
		return set(inverted());
	}
	
}

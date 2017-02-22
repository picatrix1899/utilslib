package cmn.utilslib.matrix;

import java.nio.FloatBuffer;

import cmn.utilslib.essentials.BufferUtils;
import cmn.utilslib.geometry.Point3f;
import cmn.utilslib.vector.Quaternion;
import cmn.utilslib.vector.Vec3f;
import cmn.utilslib.vector.Vec4f;

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
	
	public Vec4f m0 = new Vec4f();
	public Vec4f m1 = new Vec4f();
	public Vec4f m2 = new Vec4f();
	public Vec4f m3 = new Vec4f();
	
	public Matrix4f() { initZero(); }
	
	private Matrix4f(Matrix4f m) { set(m); }
	
	public Matrix4f set(Matrix4f m)
	{
		
		this.m0.set(m.m0);
		this.m1.set(m.m1);
		this.m2.set(m.m2);
		this.m3.set(m.m3);
		
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
		
		this.m0.setX(1.0d - 2.0d	*	(q.getY() * q.getY() + q.getZ() * q.getZ()));
		this.m0.setY(2.0d			*	(q.getX() * q.getY() - q.getW() * q.getZ()));
		this.m0.setZ(2.0d			*	(q.getX() * q.getZ() + q.getW() * q.getY()));
		this.m0.setA(0.0d);
		
		this.m1.setX(2.0d			*	(q.getX() * q.getY() + q.getW() * q.getZ()));
		this.m1.setY(1.0d - 2.0d	*	(q.getX() * q.getX() + q.getZ() * q.getZ()));
		this.m1.setZ(2.0d			*	(q.getY() * q.getZ() - q.getW() * q.getX()));
		this.m1.setA(0.0d);
		
		this.m2.setX(2.0d			*	(q.getX() * q.getZ() - q.getW() * q.getY()));
		this.m2.setY(2.0d			*	(q.getY() * q.getZ() + q.getW() * q.getX()));
		this.m2.setZ(1.0d - 2.0d	*	(q.getX() * q.getX() + q.getY() * q.getY()));
		this.m2.setA(0.0d);
		
		this.m3.set(0.0d, 0.0d, 0.0d, 1.0d);
		
		return this;
	}
	
	public Matrix4f initRotation(Vec3f forward, Vec3f up, Vec3f right)
	{
		this.m0.setX(right.x);
		this.m0.setY(right.y);
		this.m0.setZ(right.z);
		this.m0.setA(0.0d);
		
		this.m1.setX(up.x);
		this.m1.setY(up.y);
		this.m1.setZ(up.z);
		this.m1.setA(0.0d);
		
		this.m2.setX(forward.x);
		this.m2.setY(forward.y);
		this.m2.setZ(forward.z);
		this.m2.setA(0.0d);
		
		this.m3.set(0.0d, 0.0d, 0.0d, 1.0d);
		
		return this;
	}
	
	public Matrix4f initOrtho(float left, float right, float bottom, float top, float near, float far)
	{
		float width = right - left;
		
		float height = top - bottom;
		///float depth = far - near;
		
		this.m0.setX(2.0f / width);
		this.m0.setY(0.0f);
		this.m0.setZ(0.0f);
		this.m0.setA(-((right + left) / width));
		
		this.m1.setX(0.0f);
		this.m1.setY(2.0f / height);
		this.m1.setZ(0.0f);
		this.m1.setA(-((top + bottom) / height));
		
		//this.m2.setX(0.0f);
		//this.m2.setY(0.0f);
		//this.m2.setZ(-2.0f / depth);
		//this.m2.setA(-((far + near) / depth));
		
		this.m3.setX(0.0f);
		this.m3.setY(0.0f);
		this.m3.setZ(0.0f);
		this.m3.setA(1.0f);
		
		return this;
	}
	
	public Matrix4f initRotation(Vec3f forward, Vec3f up)
	{
		Vec3f f = forward.normalized();
		Vec3f r = up.normalized();
		r = r.cross(f);
		
		Vec3f u = f.cross(r);
		
		u.normalize();
		
		return initRotation(forward.normalized(), u, r);
	}
	
	public static Matrix4f iRotation(Vec3f axis, float angle) { return new Matrix4f().initRotation(axis, angle); }
	
	public Matrix4f initRotation(Vec3f axis, float angle)
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
		
		this.m0.set(	axis.x * axis.x * omc + c	,	xy * omc - sz				,	xz * omc + sy				,	0.0f	);
		this.m1.set(	xy * omc + sz				,	axis.y * axis.y * omc + c	,	yz * omc - sx				,	0.0f	);
		this.m2.set(	xz * omc - sy				,	yz * omc + sx				,	axis.z * axis.z * omc + c	,	0.0f	);
		this.m3.set(	0.0							,	0.0f						,	0.0f						,	1.0f	);

		return this;
	}
	
	public static Matrix4f iTranslation(Vec3f v) { return new Matrix4f().initTranslation(v); }
	
	public static Matrix4f iTranslation(float tx, float ty, float tz) { return new Matrix4f().initTranslation(tx, ty, tz); }
	
	public Matrix4f initTranslation(Vec3f v) { return initTranslation(v.x, v.y, v.z); }	
	
	public Matrix4f initTranslation(float tx, float ty, float tz)
	{
		this.m0.set(	1.0f	,	0.0f	,	0.0f	,	tx		);
		this.m1.set(	0.0f	,	1.0f	,	0.0f	,	ty		);
		this.m2.set(	0.0f	,	0.0f	,	1.0f	,	tz		);
		this.m3.set(	0.0f	,	0.0f	,	0.0f	,	1.0f	);
		
		return this;
	}
	
	public static Matrix4f iScaling(Vec3f v) { return new Matrix4f().initScaling(v); }
	
	public static Matrix4f iScaling(float sx, float sy, float sz) { return new Matrix4f().initScaling(sx, sy, sz); }
	
	public Matrix4f initScaling(Vec3f v) { return initScaling(v.x, v.y, v.z); }
	
	public Matrix4f initScaling(float sx, float sy, float sz)
	{
		
		this.m0.set(	sx		,	0.0		,	0.0f	,	0.0f	);
		this.m1.set(	0.0f	,	sy		,	0.0f	,	0.0f	);
		this.m2.set(	0.0f	,	0.0f	,	sz		,	0.0f	);
		this.m3.set(	0.0f	,	0.0f	,	0.0f	,	1.0f	);
		
		return this;
	}
	
	public static Matrix4f iModelMatrix(Vec3f pos, Quaternion rot, Vec3f scale) { return new Matrix4f().initModelMatrix(pos, rot, scale); }
	
	public Matrix4f initModelMatrix(Vec3f pos, Quaternion rot, Vec3f scale)
	{
		if(scale == null) scale = new Vec3f(1.0f, 1.0f, 1.0f);
		
		initIdendity();
		rotate(rot);
		translate(pos);
		scale(scale);
		
		return this;
	}
	
	public static Matrix4f iViewMatrix(Vec3f pos, Quaternion rot) { return new Matrix4f().initViewMatrix(pos, rot); }
	
	public Matrix4f initViewMatrix(Vec3f pos, Quaternion rot)
	{
		initIdendity();
		
		translate(pos.inverted());
		rotate(rot.conjugated());
		
		return this;
	}
	
	public Matrix4f translate(Vec3f v){ return translate(v, this); }
	
	public Matrix4f translate(float tx, float ty, float tz) { return translate(tx, ty, tz, this); }
	
	public Matrix4f translate(Vec3f v, Matrix4f dest) { return translate(v, this, dest); }
	
	public Matrix4f translate(float tx, float ty, float tz, Matrix4f dest) { return translate(tx, ty, tz, this, dest); }
	
	public Matrix4f translate(Vec3f v, Matrix4f src, Matrix4f dest) { return translate(v.x, v.y, v.z, src, dest); }
	
	public Matrix4f translate(float tx, float ty, float tz, Matrix4f src, Matrix4f dest) { return Matrix4f.mul(new Matrix4f().initTranslation(tx, ty, tz), src, dest); }
	
	
	
	public Matrix4f rotate(Quaternion q) { return rotate(q, this); }
	
	public Matrix4f rotate(Quaternion q, Matrix4f dest) { return rotate(q, this, dest); }
	
	public Matrix4f rotate(Quaternion q, Matrix4f src, Matrix4f dest) { return Matrix4f.mul(new Matrix4f().initRotation(q), src, dest); }
	
	
	
	public Matrix4f rotate(Vec3f axis, float angle) { return rotate(axis, angle, this); }
	
	public Matrix4f rotate(Vec3f axis, float angle, Matrix4f dest) { return rotate(axis, angle, this, dest); }
	
	public Matrix4f rotate(Vec3f axis, float angle, Matrix4f src, Matrix4f dest) { return Matrix4f.mul(new Matrix4f().initRotation(axis, angle), src, dest); }
	
	
	
	public Matrix4f scale(Vec3f v) { return scale(v.x, v.y, v.z); }
	
	public Matrix4f scale(float sx,float sy,float sz) { return scale(sx, sy, sz, this); }
	
	public Matrix4f scale(Vec3f v, Matrix4f dest) { return scale(v.x, v.y, v.z, this, dest); }
	
	public Matrix4f scale(float sx, float sy, float sz, Matrix4f dest) { return scale(sx, sy, sz, this, dest); }
	
	public Matrix4f scale(Vec3f v, Matrix4f src, Matrix4f dest) { return scale(v.x, v.y, v.z, src, dest); }
	
	public Matrix4f scale(float sx, float sy, float sz, Matrix4f src, Matrix4f dest) { return Matrix4f.mul(new Matrix4f().initScaling(sx,  sy,  sz), src, dest); }
	
	
	
	public Matrix4f mul(Matrix4f m) { return Matrix4f.mul(this, m, null); }
	
	public static Matrix4f mul(Matrix4f l, Matrix4f r, Matrix4f dest)
	{
		if (dest == null) dest = new Matrix4f();
		
		float m0x_ = l.m0.x * r.m0.x + l.m0.y * r.m1.x + l.m0.z * r.m2.x + l.m0.a * r.m3.x;
		float m0y_ = l.m0.x * r.m0.y + l.m0.y * r.m1.y + l.m0.z * r.m2.y + l.m0.a * r.m3.y;
		float m0z_ = l.m0.x * r.m0.z + l.m0.y * r.m1.z + l.m0.z * r.m2.z + l.m0.a * r.m3.z;
		float m0a_ = l.m0.x * r.m0.a + l.m0.y * r.m1.a + l.m0.z * r.m2.a + l.m0.a * r.m3.a;
		
		float m1x_ = l.m1.x * r.m0.x + l.m1.y * r.m1.x + l.m1.z * r.m2.x + l.m1.a * r.m3.x;
		float m1y_ = l.m1.x * r.m0.y + l.m1.y * r.m1.y + l.m1.z * r.m2.y + l.m1.a * r.m3.y;
		float m1z_ = l.m1.x * r.m0.z + l.m1.y * r.m1.z + l.m1.z * r.m2.z + l.m1.a * r.m3.z;
		float m1a_ = l.m1.x * r.m0.a + l.m1.y * r.m1.a + l.m1.z * r.m2.a + l.m1.a * r.m3.a;
		
		float m2x_ = l.m2.x * r.m0.x + l.m2.y * r.m1.x + l.m2.z * r.m2.x + l.m2.a * r.m3.x;
		float m2y_ = l.m2.x * r.m0.y + l.m2.y * r.m1.y + l.m2.z * r.m2.y + l.m2.a * r.m3.y;
		float m2z_ = l.m2.x * r.m0.z + l.m2.y * r.m1.z + l.m2.z * r.m2.z + l.m2.a * r.m3.z;
		float m2a_ = l.m2.x * r.m0.a + l.m2.y * r.m1.a + l.m2.z * r.m2.a + l.m2.a * r.m3.a;
		
		float m3x_ = l.m3.x * r.m0.x + l.m3.y * r.m1.x + l.m3.z * r.m2.x + l.m3.a * r.m3.x;
		float m3y_ = l.m3.x * r.m0.y + l.m3.y * r.m1.y + l.m3.z * r.m2.y + l.m3.a * r.m3.y;
		float m3z_ = l.m3.x * r.m0.z + l.m3.y * r.m1.z + l.m3.z * r.m2.z + l.m3.a * r.m3.z;
		float m3a_ = l.m3.x * r.m0.a + l.m3.y * r.m1.a + l.m3.z * r.m2.a + l.m3.a * r.m3.a;
		
		dest.m0.set(m0x_, m0y_, m0z_, m0a_);
		dest.m1.set(m1x_, m1y_, m1z_, m1a_);
		dest.m2.set(m2x_, m2y_, m2z_, m2a_);
		dest.m3.set(m3x_, m3y_, m3z_, m3a_);
		
		return dest;
	}
	
	public Vec3f transformN(Vec3f r) { return Matrix4f.transform(this, r, null); }
	
	public Vec3f transform(Vec3f r) { return Matrix4f.transform(this, r, r); }
	
	public static Vec3f transform(Matrix4f l, Vec3f r, Vec3f dest)
	{
		if (dest == null) dest = new Vec3f();

		float x_ = l.m0.x * r.x + l.m0.y * r.y + l.m0.z * r.z + l.m0.a * 1.0f;
		float y_ = l.m1.x * r.x + l.m1.y * r.y + l.m1.z * r.z + l.m1.a * 1.0f;
		float z_ = l.m2.x * r.x + l.m2.y * r.y + l.m2.z * r.z + l.m2.a * 1.0f;

		dest.set(x_, y_, z_);
		
		return dest;
	}
	
	public Point3f transformN(Point3f r) { return Matrix4f.transform(this, r, null); }
	
	public Point3f transform(Point3f r) { return Matrix4f.transform(this, r, r); }
	
	public static Point3f transform(Matrix4f l, Point3f r, Point3f dest)
	{
		if (dest == null) dest = new Point3f();

		float x_ = l.m0.x * r.x + l.m0.y * r.y + l.m0.z * r.z + l.m0.a * 1.0f;
		float y_ = l.m1.x * r.x + l.m1.y * r.y + l.m1.z * r.z + l.m1.a * 1.0f;
		float z_ = l.m2.x * r.x + l.m2.y * r.y + l.m2.z * r.z + l.m2.a * 1.0f;

		dest.set(x_, y_, z_);
		
		return dest;
	}
	
	public Vec4f transformN(Vec4f r) { return Matrix4f.transform(this, r, null); }
	
	public Vec4f transform(Vec4f r) { return Matrix4f.transform(this, r, r); }
	
	public static Vec4f transform(Matrix4f l, Vec4f r, Vec4f dest)
	{
		if (dest == null) dest = new Vec4f();
		
		float x_ = l.m0.dot(r);
		float y_ = l.m1.dot(r);
		float z_ = l.m2.dot(r);
		float a_ = l.m3.dot(r);

		dest.set(x_, y_, z_, a_);
		
		return dest;
	}
	
	public FloatBuffer getRowMajorBuffer() { return (FloatBuffer) BufferUtils.wrapFloatBuffer(getRowMajor()).flip(); }	
	
	public float[] getRowMajor()
	{
		float[] out = new float[Matrix4f.ENTS];
		
		out[ 0] = this.m0.x;	out[ 1] = this.m0.y;	out[ 2] = this.m0.z;	out[ 3] = this.m0.a;
		out[ 4] = this.m1.x;	out[ 5] = this.m1.y;	out[ 6] = this.m1.z;	out[ 7] = this.m1.a;
		out[ 8] = this.m2.x;	out[ 9] = this.m2.y;	out[10] = this.m2.z;	out[11] = this.m2.a;
		out[12] = this.m3.x;	out[13] = this.m3.y;	out[14] = this.m3.z;	out[15] = this.m3.a;
		
		return out;
	}
	
	public FloatBuffer getColMajorBuffer() { return (FloatBuffer) BufferUtils.wrapFloatBuffer(getColMajor()).flip(); }

	public float[] getColMajor()
	{
		float[] out = new float[Matrix4f.ENTS];
		
		out[ 0] = this.m0.x;	out[ 4] = this.m0.y;	out[ 8] = this.m0.z;	out[12] = this.m0.a;
		out[ 1] = this.m1.x;	out[ 5] = this.m1.y;	out[ 9] = this.m1.z;	out[13] = this.m1.a;
		out[ 2] = this.m2.x;	out[ 6] = this.m2.y;	out[10] = this.m2.z;	out[14] = this.m2.a;
		out[ 3] = this.m3.x;	out[ 7] = this.m3.y;	out[11] = this.m3.z;	out[15] = this.m3.a;
		
		return out;
	}
	
	public Matrix4f transposed() { return clone().transpose(); }
	
	public Matrix4f transpose()
	{
		float m0x_ = this.m0.x;
		float m0y_ = this.m1.x;
		float m0z_ = this.m2.x;
		float m0a_ = this.m3.x;
		
		float m1x_ = this.m0.y;
		float m1y_ = this.m1.y;
		float m1z_ = this.m2.y;
		float m1a_ = this.m3.y;
		
		float m2x_ = this.m0.z;
		float m2y_ = this.m1.z;
		float m2z_ = this.m2.z;
		float m2a_ = this.m3.z;
		
		float m3x_ = this.m0.a;
		float m3y_ = this.m1.a;
		float m3z_ = this.m2.a;
		float m3a_ = this.m3.a;
		
		this.m0.x = m0x_;
		this.m0.y = m0y_;
		this.m0.z = m0z_;
		this.m0.a = m0a_;
		
		this.m1.x = m1x_;
		this.m1.y = m1y_;
		this.m1.z = m1z_;
		this.m1.a = m1a_;
		
		this.m2.x = m2x_;
		this.m2.y = m2y_;
		this.m2.z = m2z_;
		this.m2.a = m2a_;
		
		this.m3.x = m3x_;
		this.m3.y = m3y_;
		this.m3.z = m3z_;
		this.m3.a = m3a_;
		
		return this;
	}
	
	public float determinant()
	{
		return det4x4(m0.x, m0.y, m0.z, m0.a, m1.x, m1.y, m1.z, m1.a, m2.x, m2.y, m2.z, m2.a, m3.x, m3.y, m3.z, m3.a);
	}
	
	public Matrix4f inversed() { return clone().inverse(); }
	
	public Matrix4f inverse()
	{
		float m0x_ = +Matrix3f.det3x3(this.m1.y, this.m1.z, this.m1.a, this.m2.y, this.m2.z, this.m2.a, this.m3.y, this.m3.z, this.m3.a);
		float m0y_ = -Matrix3f.det3x3(this.m1.x, this.m1.z, this.m1.a, this.m2.x, this.m2.z, this.m2.a, this.m3.x, this.m3.z, this.m3.a);
		float m0z_ = +Matrix3f.det3x3(this.m1.x, this.m1.y, this.m1.a, this.m2.x, this.m2.y, this.m2.a, this.m3.x, this.m3.y, this.m3.a);
		float m0a_ = -Matrix3f.det3x3(this.m1.x, this.m1.y, this.m1.z, this.m2.x, this.m2.y, this.m2.z, this.m3.x, this.m3.y, this.m3.z);
		
		float m1x_ = -Matrix3f.det3x3(this.m0.y, this.m0.z, this.m0.a, this.m2.y, this.m2.z, this.m2.a, this.m3.y, this.m3.z, this.m3.a);
		float m1y_ = +Matrix3f.det3x3(this.m0.x, this.m0.z, this.m0.a, this.m2.x, this.m2.z, this.m2.a, this.m3.x, this.m3.z, this.m3.a);
		float m1z_ = -Matrix3f.det3x3(this.m0.x, this.m0.y, this.m0.a, this.m2.x, this.m2.y, this.m2.a, this.m3.x, this.m3.y, this.m3.a);
		float m1a_ = +Matrix3f.det3x3(this.m0.x, this.m0.y, this.m0.z, this.m2.x, this.m2.y, this.m2.z, this.m3.x, this.m3.y, this.m3.z);
		
		float m2x_ = +Matrix3f.det3x3(this.m0.y, this.m0.z, this.m0.a, this.m1.y, this.m1.z, this.m1.a, this.m3.y, this.m3.z, this.m3.a);
		float m2y_ = -Matrix3f.det3x3(this.m0.x, this.m0.z, this.m0.a, this.m1.x, this.m1.z, this.m1.a, this.m3.x, this.m3.z, this.m3.a);
		float m2z_ = +Matrix3f.det3x3(this.m0.x, this.m0.y, this.m0.a, this.m1.x, this.m1.y, this.m1.a, this.m3.x, this.m3.y, this.m3.a);
		float m2a_ = -Matrix3f.det3x3(this.m0.x, this.m0.y, this.m0.z, this.m1.x, this.m1.y, this.m1.z, this.m3.x, this.m3.y, this.m3.z);
		
		float m3x_ = -Matrix3f.det3x3(this.m0.y, this.m0.z, this.m0.a, this.m1.y, this.m1.z, this.m1.a, this.m2.y, this.m2.z, this.m2.a);
		float m3y_ = +Matrix3f.det3x3(this.m0.x, this.m0.z, this.m0.a, this.m1.x, this.m1.z, this.m1.a, this.m2.x, this.m2.z, this.m2.a);
		float m3z_ = -Matrix3f.det3x3(this.m0.x, this.m0.y, this.m0.a, this.m1.x, this.m1.y, this.m1.a, this.m2.x, this.m2.y, this.m2.a);
		float m3a_ = +Matrix3f.det3x3(this.m0.x, this.m0.y, this.m0.z, this.m1.x, this.m1.y, this.m1.z, this.m2.x, this.m2.y, this.m2.z);
		
		double D = determinant();
		
		if(D != 0)
		{
			m0x_ /= D; m0y_ /= D; m0z_ /= D; m0a_ /= D;
			m1x_ /= D; m1y_ /= D; m1z_ /= D; m1a_ /= D;
			m2x_ /= D; m2y_ /= D; m2z_ /= D; m2a_ /= D;
			m3x_ /= D; m3y_ /= D; m3z_ /= D; m3a_ /= D;
		}
		
		this.m0.set(m0x_, m0y_, m0z_, m0a_);
		this.m1.set(m1x_, m1y_, m1z_, m1a_);
		this.m2.set(m2x_, m2y_, m2z_, m2a_);
		this.m3.set(m3x_, m3y_, m3z_, m3a_);
		
		return this;
	}
	
	public static float det4x4(	float m0x, float m0y, float m0z, float m0w,
								float m1x, float m1y, float m1z, float m1w,
								float m2x, float m2y, float m2z, float m2w,
								float m3x, float m3y, float m3z, float m3w)
	{
		return	m0x * +Matrix3f.det3x3(m1y, m1z, m1w, m2y, m2z, m2w, m3y, m3z, m3w) +
				m0y * -Matrix3f.det3x3(m1x, m1z, m1w, m2x, m2z, m2w, m3x, m3z, m3w) +
				m0z * +Matrix3f.det3x3(m1x, m1y, m1w, m2x, m2y, m2w, m3x, m3y, m3w) +
				m0w * -Matrix3f.det3x3(m1x, m1y, m1z, m2x, m2y, m2z, m3x, m3y, m3z);
	}
	
	public Matrix4f clone() { return new Matrix4f(this); }
	
	public String toString()
	{
		return
				"matrix4f(	" + m0.x + "f	" + m0.y + "f	" + m0.z + "f	" + m0.a + "f	" + ")\n" + 
				"        (	" + m1.x + "f	" + m1.y + "f	" + m1.z + "f	" + m1.a + "f	" + ")\n" +
				"        (	" + m2.x + "f	" + m2.y + "f	" + m2.z + "f	" + m2.a + "f	" + ")\n" +
				"        (	" + m3.x + "f	" + m3.y + "f	" + m3.z + "f	" + m3.a + "f	" + ")";
	}
	
}

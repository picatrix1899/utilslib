package cmn.utilslib.math.matrix;

import java.nio.FloatBuffer;

import cmn.utilslib.essentials.BufferUtils;
import cmn.utilslib.math.Maths;
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.geometry.Point3f;
import cmn.utilslib.math.tuple.Tuple3d;
import cmn.utilslib.math.tuple.Tuple3f;
import cmn.utilslib.math.tuple.api.Tup3d;
import cmn.utilslib.math.tuple.api.Tup3dBase;
import cmn.utilslib.math.tuple.api.Tup3f;
import cmn.utilslib.math.tuple.api.Tup3fBase;
import cmn.utilslib.math.vector.Vector3f;
import cmn.utilslib.math.vector.Vector4f;
import cmn.utilslib.math.vector.api.Vec3f;
import cmn.utilslib.math.vector.api.Vec3fBase;

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
	
	public Vector4f m0 = new Vector4f();
	public Vector4f m1 = new Vector4f();
	public Vector4f m2 = new Vector4f();
	public Vector4f m3 = new Vector4f();
	
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
	
	public static Matrix4f zero() { return new Matrix4f().initZero(); }
	
	public Matrix4f initZero()
	{
		this.m0.setZero();
		this.m1.setZero();
		this.m2.setZero();
		this.m3.setZero();
		
		return this;
	}
	
	public static Matrix4f identity() { return new Matrix4f().initIdendity(); }
	
	public Matrix4f initIdendity()
	{
		this.m0.set(1.0f, 0.0f, 0.0f, 0.0f);
		this.m1.set(0.0f, 1.0f, 0.0f, 0.0f);
		this.m2.set(0.0f, 0.0f, 1.0f, 0.0f);
		this.m3.set(0.0f, 0.0f, 0.0f, 1.0f);
		
		return this;
	}
	
	public static Matrix4f rotation(Quaternion q) { return new Matrix4f().initRotation(q); }
	
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
	
	public static Matrix4f rotation(Vec3f forward, Vec3f up, Vec3f right) { return new Matrix4f().initRotation(forward, up, right); }
	
	public Matrix4f initRotation(Vec3f forward, Vec3f up, Vec3f right)
	{
		this.m0.setX(right.getX());
		this.m0.setY(right.getY());
		this.m0.setZ(right.getZ());
		this.m0.setA(0.0d);
		
		this.m1.setX(up.getX());
		this.m1.setY(up.getY());
		this.m1.setZ(up.getZ());
		this.m1.setA(0.0d);
		
		this.m2.setX(forward.getX());
		this.m2.setY(forward.getY());
		this.m2.setZ(forward.getZ());
		this.m2.setA(0.0d);
		
		this.m3.set(0.0d, 0.0d, 0.0d, 1.0d);
		
		return this;
	}
	
	public static Matrix4f ortho(float left, float right, float bottom, float top, float near, float far) { return new Matrix4f().initOrtho(left, right, bottom, top, near, far); }
	
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
	
	public static Matrix4f simpleOrtho(float width, float height, float length) { return new Matrix4f().initSimpleOrtho(width, height, length); }
	
	
	public Matrix4f initSimpleOrtho(float width, float height, float length)
	{
		this.m0.setX(2.0f / width);
		this.m0.setY(0.0f);
		this.m0.setZ(0.0f);
		this.m0.setA(0.0f);
		
		this.m1.setX(0.0f);
		this.m1.setY(2.0f / width);
		this.m1.setZ(0.0f);
		this.m1.setA(0.0f);
		
		this.m2.setX(0.0f);
		this.m2.setY(0.0f);
		this.m2.setZ(-2.0f / width);
		this.m2.setA(0.0f);
		
		this.m3.setX(0.0f);
		this.m3.setY(0.0f);
		this.m3.setZ(0.0f);
		this.m3.setA(1.0f);
		
		return this;
	}
	
	public Matrix4f initRotation(Vec3f forward, Vec3f up)
	{
		Vector3f f = (Vector3f)forward.normalizeN();
		Vector3f r = (Vector3f)up.normalizeN();
		r = r.cross(f);
		
		Vector3f u = f.cross(r);
		
		u.normalize();
		
		return initRotation(forward.normalizeN(), u, r);
	}
	
	public static Matrix4f rotation(Vec3f axis, float angle) { return new Matrix4f().initRotation(axis, angle); }
	
	public Matrix4f initRotation(Vec3f axis, float angle)
	{
		
		float c = (float)Math.cos(angle * Maths.DEG_TO_RAD);
		float s = (float)Math.sin(angle * Maths.DEG_TO_RAD);
		
		float omc = 1 - c;
		
		float xy = axis.getX() * axis.getY();
		float xz = axis.getX() * axis.getZ();
		float yz = axis.getY() * axis.getZ();
		
		float sx = s * axis.getX();
		float sy = s * axis.getY();
		float sz = s * axis.getZ();
		
		this.m0.x = (float)(axis.getX() * axis.getX() * omc + c);
		this.m0.y = (float)(xy * omc - sz);
		this.m0.z = (float)(xz * omc + sy);
		this.m0.a = 0;
		
		this.m1.x = (float)(xy * omc + sz);
		this.m1.y = (float)(axis.getY() * axis.getY() * omc + c);
		this.m1.z = (float)(yz * omc - sx);
		this.m1.a = 0;
		
		this.m2.x = (float)(xz * omc - sy);
		this.m2.y = (float)(yz * omc + sx);
		this.m2.z = (float)(axis.getZ() * axis.getZ() * omc + c);
		this.m2.a = 0;
				
		this.m3.x = 0;
		this.m3.y = 0;
		this.m3.z = 0;
		this.m3.a = 1;
		return this;
	}
	
	public static Matrix4f translation(Vec3f v) { return new Matrix4f().initTranslation(v); }
	public static Matrix4f translation(float tx, float ty, float tz) { return new Matrix4f().initTranslation(tx, ty, tz); }
	
	public Matrix4f initTranslation(Vec3f v) { return initTranslation(v.getX(), v.getY(), v.getZ()); }	
	public Matrix4f initTranslation(float tx, float ty, float tz)
	{
		this.m0.set(	1.0f	,	0.0f	,	0.0f	,	tx		);
		this.m1.set(	0.0f	,	1.0f	,	0.0f	,	ty		);
		this.m2.set(	0.0f	,	0.0f	,	1.0f	,	tz		);
		this.m3.set(	0.0f	,	0.0f	,	0.0f	,	1.0f	);
		
		return this;
	}
	
	public static Matrix4f scaling(Vec3f v) { return new Matrix4f().initScaling(v); }
	public static Matrix4f scaling(float sx, float sy, float sz) { return new Matrix4f().initScaling(sx, sy, sz); }
	
	public Matrix4f initScaling(Vec3f v) { return initScaling(v.getX(), v.getY(), v.getZ()); }
	public Matrix4f initScaling(float sx, float sy, float sz)
	{
		
		this.m0.set(	sx		,	0.0		,	0.0f	,	0.0f	);
		this.m1.set(	0.0f	,	sy		,	0.0f	,	0.0f	);
		this.m2.set(	0.0f	,	0.0f	,	sz		,	0.0f	);
		this.m3.set(	0.0f	,	0.0f	,	0.0f	,	1.0f	);
		
		return this;
	}
	
	public static Matrix4f modelMatrix(Vec3f pos, Quaternion rot, Vec3f scale) { return new Matrix4f().initModelMatrix(pos, rot, scale); }
	
	public Matrix4f initModelMatrix(Vec3f pos, Quaternion rot, Vec3f scale)
	{
		if(scale == null) scale = new Vector3f(1.0f, 1.0f, 1.0f);
		
		initIdendity();
		rotate(rot);
		translate(pos);
		scale(scale);
		
		return this;
	}
	
	public static Matrix4f viewMatrix(Vec3f pos, Quaternion rot) { return new Matrix4f().initViewMatrix(pos, rot); }
	
	public Matrix4f initViewMatrix(Vec3f pos, Quaternion rot)
	{
		initIdendity();
		
		translate(pos.negateN());
		rotate(rot.conjugated());
		
		return this;
	}
	
	public Matrix4f translate(Vec3f v){ return translate(v, this); }
	public Matrix4f translate(float tx, float ty, float tz) { return translate(tx, ty, tz, this); }
	public Matrix4f translate(Vec3f v, Matrix4f dest) { return translate(v, this, dest); }
	public Matrix4f translate(float tx, float ty, float tz, Matrix4f dest) { return translate(tx, ty, tz, this, dest); }
	public Matrix4f translate(Vec3f v, Matrix4f src, Matrix4f dest) { return translate(v.getX(), v.getY(), v.getZ(), src, dest); }
	public Matrix4f translate(float tx, float ty, float tz, Matrix4f src, Matrix4f dest) { return Matrix4f.mul(Matrix4f.translation(tx, ty, tz), src, dest); }
	
	
	
	public Matrix4f rotate(Quaternion q) { return rotate(q, this); }
	public Matrix4f rotate(Quaternion q, Matrix4f dest) { return rotate(q, this, dest); }
	public Matrix4f rotate(Quaternion q, Matrix4f src, Matrix4f dest) { return Matrix4f.mul(new Matrix4f().initRotation(q), src, dest); }
	
	
	
	public Matrix4f rotate(Vec3f axis, float angle) { return rotate(axis, angle, this); }
	public Matrix4f rotate(Vec3f axis, float angle, Matrix4f dest) { return rotate(axis, angle, this, dest); }
	public Matrix4f rotate(Vec3f axis, float angle, Matrix4f src, Matrix4f dest) { return Matrix4f.mul(new Matrix4f().initRotation(axis, angle), src, dest); }
	
	
	
	public Matrix4f scale(Vec3f v) { return scale(v.getX(), v.getY(), v.getZ()); }
	public Matrix4f scale(float sx,float sy,float sz) { return scale(sx, sy, sz, this); }
	public Matrix4f scale(Vec3f v, Matrix4f dest) { return scale(v.getX(), v.getY(), v.getZ(), this, dest); }
	public Matrix4f scale(float sx, float sy, float sz, Matrix4f dest) { return scale(sx, sy, sz, this, dest); }
	public Matrix4f scale(Vec3f v, Matrix4f src, Matrix4f dest) { return scale(v.getX(), v.getY(), v.getZ(), src, dest); }
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
	
	public Matrix4f add(Matrix4f m) { return Matrix4f.add(this, m, null); }
	
	public static Matrix4f add(Matrix4f l, Matrix4f r, Matrix4f dest)
	{
		if (dest == null) dest = new Matrix4f();
		
		float m0x_ = l.m0.x + r.m0.x;
		float m0y_ = l.m0.y + r.m0.y;
		float m0z_ = l.m0.z + r.m0.z;
		float m0a_ = l.m0.a + r.m0.a;
		
		float m1x_ = l.m1.x + r.m1.x;
		float m1y_ = l.m1.y + r.m1.y;
		float m1z_ = l.m1.z + r.m1.z;
		float m1a_ = l.m1.a + r.m1.a;
		
		float m2x_ = l.m2.x + r.m2.x;
		float m2y_ = l.m2.y + r.m2.y;
		float m2z_ = l.m2.z + r.m2.z;
		float m2a_ = l.m2.a + r.m2.a;
		
		float m3x_ = l.m3.x + r.m3.x;
		float m3y_ = l.m3.y + r.m3.y;
		float m3z_ = l.m3.z + r.m3.z;
		float m3a_ = l.m3.a + r.m3.a;
		
		dest.m0.set(m0x_, m0y_, m0z_, m0a_);
		dest.m1.set(m1x_, m1y_, m1z_, m1a_);
		dest.m2.set(m2x_, m2y_, m2z_, m2a_);
		dest.m3.set(m3x_, m3y_, m3z_, m3a_);
		
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
	
	public Vector3f transform(Vector3f r)
	{
		float x_ = this.m0.x * r.getX() + this.m0.y * r.getY() + this.m0.z * r.getZ() + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.getX() + this.m1.y * r.getY() + this.m1.z * r.getZ() + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.getX() + this.m2.y * r.getY() + this.m2.z * r.getZ() + this.m2.a * 1.0f;

		r.set(x_, y_, z_);
		
		return r;
	}
	
	public Tuple3f transform(Tuple3f r)
	{
		float x_ = this.m0.x * r.v[0] + this.m0.y * r.v[1] + this.m0.z * r.v[2] + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.v[0] + this.m1.y * r.v[1] + this.m1.z * r.v[2] + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.v[0] + this.m2.y * r.v[1] + this.m2.z * r.v[2] + this.m2.a * 1.0f;

		r.v[0] = x_;
		r.v[1] = y_;
		r.v[2] = z_;
		
		return r;
	}
	
	public Tuple3d transform(Tuple3d r)
	{
		double x_ = this.m0.x * r.v[0] + this.m0.y * r.v[1] + this.m0.z * r.v[2] + this.m0.a * 1.0f;
		double y_ = this.m1.x * r.v[0] + this.m1.y * r.v[1] + this.m1.z * r.v[2] + this.m1.a * 1.0f;
		double z_ = this.m2.x * r.v[0] + this.m2.y * r.v[1] + this.m2.z * r.v[2] + this.m2.a * 1.0f;

		r.v[0] = x_;
		r.v[1] = y_;
		r.v[2] = z_;
		
		return r;
	}
	
	public Tup3f transform(Tup3f r)
	{
		float x_ = this.m0.x * r.get(0) + this.m0.y * r.get(1) + this.m0.z * r.get(2) + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.get(0) + this.m1.y * r.get(1) + this.m1.z * r.get(2) + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.get(0) + this.m2.y * r.get(1) + this.m2.z * r.get(2) + this.m2.a * 1.0f;

		r.set(x_, y_, z_);
		
		return r;
	}
	
	public Tup3d transform(Tup3d r)
	{
		double x_ = this.m0.x * r.get(0) + this.m0.y * r.get(1) + this.m0.z * r.get(2) + this.m0.a * 1.0f;
		double y_ = this.m1.x * r.get(0) + this.m1.y * r.get(1) + this.m1.z * r.get(2) + this.m1.a * 1.0f;
		double z_ = this.m2.x * r.get(0) + this.m2.y * r.get(1) + this.m2.z * r.get(2) + this.m2.a * 1.0f;

		r.set(x_, y_, z_);
		
		return r;
	}
	
	public Point3f transform(Point3f r)
	{
		float x_ = this.m0.x * r.x + this.m0.y * r.y + this.m0.z * r.z + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.x + this.m1.y * r.y + this.m1.z * r.z + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.x + this.m2.y * r.y + this.m2.z * r.z + this.m2.a * 1.0f;
		
		r.x = x_;
		r.y = y_;
		r.z = z_;
		
		return r;
	}
	
	public Vector3f transformN(Vector3f r)
	{		
		float x_ = this.m0.x * r.x + this.m0.y * r.y + this.m0.z * r.z + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.x + this.m1.y * r.y + this.m1.z * r.z + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.x + this.m2.y * r.y + this.m2.z * r.z + this.m2.a * 1.0f;
		
		return new Vector3f(x_, y_, z_);
	}
	
	public Vector4f transformN(Vector4f r)
	{		
		float x_ = this.m0.x * r.getX() + this.m0.y * r.getY() + this.m0.z * r.getZ() + this.m0.a * r.getZ();
		float y_ = this.m1.x * r.getX() + this.m1.y * r.getY() + this.m1.z * r.getZ() + this.m1.a * r.getZ();
		float z_ = this.m2.x * r.getX() + this.m2.y * r.getY() + this.m2.z * r.getZ() + this.m2.a * r.getZ();
		float a_ = this.m3.x * r.getX() + this.m3.y * r.getY() + this.m3.z * r.getZ() + this.m3.a * r.getZ();
		
		return new Vector4f(x_, y_, z_, a_);
	}
	
	public Vector4f transform(Vector4f r)
	{		
		float x_ = this.m0.x * r.getX() + this.m0.y * r.getY() + this.m0.z * r.getZ() + this.m0.a * r.getZ();
		float y_ = this.m1.x * r.getX() + this.m1.y * r.getY() + this.m1.z * r.getZ() + this.m1.a * r.getZ();
		float z_ = this.m2.x * r.getX() + this.m2.y * r.getY() + this.m2.z * r.getZ() + this.m2.a * r.getZ();
		float a_ = this.m3.x * r.getX() + this.m3.y * r.getY() + this.m3.z * r.getZ() + this.m3.a * r.getZ();
		
		return r.set(x_, y_, z_, a_);
	}
	
	public Vector3f transformN(Vec3f r)
	{		
		float x_ = this.m0.x * r.getX() + this.m0.y * r.getY() + this.m0.z * r.getZ() + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.getX() + this.m1.y * r.getY() + this.m1.z * r.getZ() + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.getX() + this.m2.y * r.getY() + this.m2.z * r.getZ() + this.m2.a * 1.0f;
		
		return new Vector3f(x_, y_, z_);
	}

	
	public Tuple3f transformN(Tuple3f r)
	{		
		float x_ = this.m0.x * r.v[0] + this.m0.y * r.v[1] + this.m0.z * r.v[2] + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.v[0] + this.m1.y * r.v[1] + this.m1.z * r.v[2] + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.v[0] + this.m2.y * r.v[1] + this.m2.z * r.v[2] + this.m2.a * 1.0f;
		
		return new Tuple3f(x_, y_, z_);
	}
	
	public Tuple3d transformN(Tuple3d r)
	{		
		double x_ = this.m0.x * r.v[0] + this.m0.y * r.v[1] + this.m0.z * r.v[2] + this.m0.a * 1.0f;
		double y_ = this.m1.x * r.v[0] + this.m1.y * r.v[1] + this.m1.z * r.v[2] + this.m1.a * 1.0f;
		double z_ = this.m2.x * r.v[0] + this.m2.y * r.v[1] + this.m2.z * r.v[2] + this.m2.a * 1.0f;
		
		return new Tuple3d(x_, y_, z_);
	}
	
	public Tuple3f transformN(Tup3fBase r)
	{		
		float x_ = this.m0.x * r.get(0) + this.m0.y * r.get(1) + this.m0.z * r.get(2) + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.get(0) + this.m1.y * r.get(1) + this.m1.z * r.get(2) + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.get(0) + this.m2.y * r.get(1) + this.m2.z * r.get(2) + this.m2.a * 1.0f;
		
		return new Tuple3f(x_, y_, z_);
	}
	
	public Tuple3d transformN(Tup3dBase r)
	{		
		double x_ = this.m0.x * r.get(0) + this.m0.y * r.get(1) + this.m0.z * r.get(2) + this.m0.a * 1.0f;
		double y_ = this.m1.x * r.get(0) + this.m1.y * r.get(1) + this.m1.z * r.get(2) + this.m1.a * 1.0f;
		double z_ = this.m2.x * r.get(0) + this.m2.y * r.get(1) + this.m2.z * r.get(2) + this.m2.a * 1.0f;
		
		return new Tuple3d(x_, y_, z_);
	}
	
	public Point3f transformN(Point3f r)
	{		
		float x_ = this.m0.x * r.x + this.m0.y * r.y + this.m0.z * r.z + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.x + this.m1.y * r.y + this.m1.z * r.z + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.x + this.m2.y * r.y + this.m2.z * r.z + this.m2.a * 1.0f;
		
		return new Point3f(x_, y_, z_);
	}
	
	public Vector3f transform(Vector3f r, Vector3f dest)
	{
		float x_ = this.m0.x * r.x + this.m0.y * r.y + this.m0.z * r.z + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.x + this.m1.y * r.y + this.m1.z * r.z + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.x + this.m2.y * r.y + this.m2.z * r.z + this.m2.a * 1.0f;
		
		dest.x = x_;
		dest.y = y_;
		dest.z = z_;
		
		return dest;
	}

	
	public Vector3f transform(Vec3f r, Vector3f dest)
	{
		float x_ = this.m0.x * r.getX() + this.m0.y * r.getY() + this.m0.z * r.getZ() + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.getX() + this.m1.y * r.getY() + this.m1.z * r.getZ() + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.getX() + this.m2.y * r.getY() + this.m2.z * r.getZ() + this.m2.a * 1.0f;

		dest.x = x_;
		dest.y = y_;
		dest.z = z_;
		
		return dest;
	}
	
	public Vector3f transform(Tuple3f r, Vector3f dest)
	{
		float x_ = this.m0.x * r.v[0] + this.m0.y * r.v[1] + this.m0.z * r.v[2] + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.v[0] + this.m1.y * r.v[1] + this.m1.z * r.v[2] + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.v[0] + this.m2.y * r.v[1] + this.m2.z * r.v[2] + this.m2.a * 1.0f;

		dest.x = x_;
		dest.y = y_;
		dest.z = z_;
		
		return dest;
	}
	
	public Vector3f transform(Tuple3d r, Vector3f dest)
	{
		double x_ = this.m0.x * r.v[0] + this.m0.y * r.v[1] + this.m0.z * r.v[2] + this.m0.a * 1.0f;
		double y_ = this.m1.x * r.v[0] + this.m1.y * r.v[1] + this.m1.z * r.v[2] + this.m1.a * 1.0f;
		double z_ = this.m2.x * r.v[0] + this.m2.y * r.v[1] + this.m2.z * r.v[2] + this.m2.a * 1.0f;

		dest.x = (float)x_;
		dest.y = (float)y_;
		dest.z = (float)z_;
		
		return dest;
	}

	public Vector3f transform(Tup3fBase r, Vector3f dest)
	{
		float x_ = this.m0.x * r.get(0) + this.m0.y * r.get(1) + this.m0.z * r.get(2) + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.get(0) + this.m1.y * r.get(1) + this.m1.z * r.get(2) + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.get(0) + this.m2.y * r.get(1) + this.m2.z * r.get(2) + this.m2.a * 1.0f;

		dest.x = x_;
		dest.y = y_;
		dest.z = z_;
		
		return dest;
	}
	
	public Vector3f transform(Tup3dBase r, Vector3f dest)
	{
		double x_ = this.m0.x * r.get(0) + this.m0.y * r.get(1) + this.m0.z * r.get(2) + this.m0.a * 1.0f;
		double y_ = this.m1.x * r.get(0) + this.m1.y * r.get(1) + this.m1.z * r.get(2) + this.m1.a * 1.0f;
		double z_ = this.m2.x * r.get(0) + this.m2.y * r.get(1) + this.m2.z * r.get(2) + this.m2.a * 1.0f;

		dest.x = (float)x_;
		dest.y = (float)y_;
		dest.z = (float)z_;
		
		return dest;
	}

	public Vector3f transform(Point3f r, Vector3f dest)
	{
		float x_ = this.m0.x * r.x + this.m0.y * r.x + this.m0.z * r.x + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.x + this.m1.y * r.x + this.m1.z * r.x + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.x + this.m2.y * r.x + this.m2.z * r.x + this.m2.a * 1.0f;

		dest.x = x_;
		dest.y = y_;
		dest.z = z_;
		
		return dest;
	}

	public Tuple3f transform(Vector3f r, Tuple3f dest)
	{
		float x_ = this.m0.x * r.x + this.m0.y * r.y + this.m0.z * r.z + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.x + this.m1.y * r.y + this.m1.z * r.z + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.x + this.m2.y * r.y + this.m2.z * r.z + this.m2.a * 1.0f;

		dest.v[0] = x_;
		dest.v[1] = y_;
		dest.v[2] = z_;
		
		return dest;
	}

	public Tuple3d transform(Vector3f r, Tuple3d dest)
	{
		float x_ = this.m0.x * r.x + this.m0.y * r.y + this.m0.z * r.z + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.x + this.m1.y * r.y + this.m1.z * r.z + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.x + this.m2.y * r.y + this.m2.z * r.z + this.m2.a * 1.0f;

		dest.v[0] = x_;
		dest.v[1] = y_;
		dest.v[2] = z_;
		
		return dest;
	}
	
	public Tuple3f transform(Vec3fBase r, Tuple3f dest)
	{
		float x_ = this.m0.x * r.getX() + this.m0.y * r.getY() + this.m0.z * r.getZ() + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.getX() + this.m1.y * r.getY() + this.m1.z * r.getZ() + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.getX() + this.m2.y * r.getY() + this.m2.z * r.getZ() + this.m2.a * 1.0f;

		dest.v[0] = x_;
		dest.v[1] = y_;
		dest.v[2] = z_;
		
		return dest;
	}
	
	public Tuple3d transform(Vec3f r, Tuple3d dest)
	{
		float x_ = this.m0.x * r.getX() + this.m0.y * r.getY() + this.m0.z * r.getZ() + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.getX() + this.m1.y * r.getY() + this.m1.z * r.getZ() + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.getX() + this.m2.y * r.getY() + this.m2.z * r.getZ() + this.m2.a * 1.0f;

		dest.v[0] = x_;
		dest.v[1] = y_;
		dest.v[2] = z_;
		
		return dest;
	}

	public Tuple3f transform(Tuple3f r, Tuple3f dest)
	{
		float x_ = this.m0.x * r.v[0] + this.m0.y * r.v[1] + this.m0.z * r.v[2] + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.v[0] + this.m1.y * r.v[1] + this.m1.z * r.v[2] + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.v[0] + this.m2.y * r.v[1] + this.m2.z * r.v[2] + this.m2.a * 1.0f;

		dest.v[0] = x_;
		dest.v[1] = y_;
		dest.v[2] = z_;
		
		return dest;
	}
	
	public Tuple3f transform(Tuple3d r, Tuple3f dest)
	{
		double x_ = this.m0.x * r.v[0] + this.m0.y * r.v[1] + this.m0.z * r.v[2] + this.m0.a * 1.0f;
		double y_ = this.m1.x * r.v[0] + this.m1.y * r.v[1] + this.m1.z * r.v[2] + this.m1.a * 1.0f;
		double z_ = this.m2.x * r.v[0] + this.m2.y * r.v[1] + this.m2.z * r.v[2] + this.m2.a * 1.0f;

		dest.v[0] = (float)x_;
		dest.v[1] = (float)y_;
		dest.v[2] = (float)z_;
		
		return dest;
	}
	
	public Tuple3d transform(Tuple3f r, Tuple3d dest)
	{
		float x_ = this.m0.x * r.v[0] + this.m0.y * r.v[1] + this.m0.z * r.v[2] + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.v[0] + this.m1.y * r.v[1] + this.m1.z * r.v[2] + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.v[0] + this.m2.y * r.v[1] + this.m2.z * r.v[2] + this.m2.a * 1.0f;

		dest.v[0] = x_;
		dest.v[1] = y_;
		dest.v[2] = z_;
		
		return dest;
	}
	
	public Tuple3d transform(Tuple3d r, Tuple3d dest)
	{
		double x_ = this.m0.x * r.v[0] + this.m0.y * r.v[1] + this.m0.z * r.v[2] + this.m0.a * 1.0f;
		double y_ = this.m1.x * r.v[0] + this.m1.y * r.v[1] + this.m1.z * r.v[2] + this.m1.a * 1.0f;
		double z_ = this.m2.x * r.v[0] + this.m2.y * r.v[1] + this.m2.z * r.v[2] + this.m2.a * 1.0f;

		dest.v[0] = x_;
		dest.v[1] = y_;
		dest.v[2] = z_;
		
		return dest;
	}
	
	public Tuple3f transform(Tup3fBase r, Tuple3f dest)
	{
		float x_ = this.m0.x * r.get(0) + this.m0.y * r.get(1) + this.m0.z * r.get(2) + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.get(0) + this.m1.y * r.get(1) + this.m1.z * r.get(2) + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.get(0) + this.m2.y * r.get(1) + this.m2.z * r.get(2) + this.m2.a * 1.0f;

		dest.v[0] = x_;
		dest.v[1] = y_;
		dest.v[2] = z_;
		
		return dest;
	}
	
	public Tuple3f transform(Tup3dBase r, Tuple3f dest)
	{
		double x_ = this.m0.x * r.get(0) + this.m0.y * r.get(1) + this.m0.z * r.get(2) + this.m0.a * 1.0f;
		double y_ = this.m1.x * r.get(0) + this.m1.y * r.get(1) + this.m1.z * r.get(2) + this.m1.a * 1.0f;
		double z_ = this.m2.x * r.get(0) + this.m2.y * r.get(1) + this.m2.z * r.get(2) + this.m2.a * 1.0f;

		dest.v[0] = (float)x_;
		dest.v[1] = (float)y_;
		dest.v[2] = (float)z_;
		
		return dest;
	}
	
	public Tuple3d transform(Tup3fBase r, Tuple3d dest)
	{
		float x_ = this.m0.x * r.get(0) + this.m0.y * r.get(1) + this.m0.z * r.get(2) + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.get(0) + this.m1.y * r.get(1) + this.m1.z * r.get(2) + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.get(0) + this.m2.y * r.get(1) + this.m2.z * r.get(2) + this.m2.a * 1.0f;

		dest.v[0] = x_;
		dest.v[1] = y_;
		dest.v[2] = z_;
		
		return dest;
	}
	
	public Tuple3d transform(Tup3dBase r, Tuple3d dest)
	{
		double x_ = this.m0.x * r.get(0) + this.m0.y * r.get(1) + this.m0.z * r.get(2) + this.m0.a * 1.0f;
		double y_ = this.m1.x * r.get(0) + this.m1.y * r.get(1) + this.m1.z * r.get(2) + this.m1.a * 1.0f;
		double z_ = this.m2.x * r.get(0) + this.m2.y * r.get(1) + this.m2.z * r.get(2) + this.m2.a * 1.0f;

		dest.v[0] = x_;
		dest.v[1] = y_;
		dest.v[2] = z_;
		
		return dest;
	}
	
	public Tuple3f transform(Point3f r, Tuple3f dest)
	{
		float x_ = this.m0.x * r.x + this.m0.y * r.x + this.m0.z * r.x + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.x + this.m1.y * r.x + this.m1.z * r.x + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.x + this.m2.y * r.x + this.m2.z * r.x + this.m2.a * 1.0f;

		dest.v[0] = x_;
		dest.v[1] = y_;
		dest.v[2] = z_;
		
		return dest;
	}
	
	public Tuple3d transform(Point3f r, Tuple3d dest)
	{
		float x_ = this.m0.x * r.x + this.m0.y * r.y + this.m0.z * r.z + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.x + this.m1.y * r.y + this.m1.z * r.z + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.x + this.m2.y * r.y + this.m2.z * r.z + this.m2.a * 1.0f;

		dest.v[0] = x_;
		dest.v[1] = y_;
		dest.v[2] = z_;
		
		return dest;
	}
	
	public Point3f transform(Vector3f r, Point3f dest)
	{
		float x_ = this.m0.x * r.x + this.m0.y * r.y + this.m0.z * r.z + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.x + this.m1.y * r.y + this.m1.z * r.z + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.x + this.m2.y * r.y + this.m2.z * r.z + this.m2.a * 1.0f;

		dest.x = x_;
		dest.y = y_;
		dest.z = z_;
		
		return dest;
	}

	public Point3f transform(Vec3f r, Point3f dest)
	{
		float x_ = this.m0.x * r.getX() + this.m0.y * r.getY() + this.m0.z * r.getZ() + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.getX() + this.m1.y * r.getY() + this.m1.z * r.getZ() + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.getX() + this.m2.y * r.getY() + this.m2.z * r.getZ() + this.m2.a * 1.0f;

		dest.x = x_;
		dest.y = y_;
		dest.z = z_;
		
		return dest;
	}

	public Point3f transform(Tuple3f r, Point3f dest)
	{
		float x_ = this.m0.x * r.v[0] + this.m0.y * r.v[1] + this.m0.z * r.v[2] + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.v[0] + this.m1.y * r.v[1] + this.m1.z * r.v[2] + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.v[0] + this.m2.y * r.v[1] + this.m2.z * r.v[2] + this.m2.a * 1.0f;

		dest.x = x_;
		dest.y = y_;
		dest.z = z_;
		
		return dest;
	}
	
	public Point3f transform(Tuple3d r, Point3f dest)
	{
		double x_ = this.m0.x * r.v[0] + this.m0.y * r.v[1] + this.m0.z * r.v[2] + this.m0.a * 1.0f;
		double y_ = this.m1.x * r.v[0] + this.m1.y * r.v[1] + this.m1.z * r.v[2] + this.m1.a * 1.0f;
		double z_ = this.m2.x * r.v[0] + this.m2.y * r.v[1] + this.m2.z * r.v[2] + this.m2.a * 1.0f;

		dest.x = (float)x_;
		dest.y = (float)y_;
		dest.z = (float)z_;
		
		return dest;
	}
	
	public Point3f transform(Tup3fBase r, Point3f dest)
	{
		float x_ = this.m0.x * r.get(0) + this.m0.y * r.get(1) + this.m0.z * r.get(2) + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.get(0) + this.m1.y * r.get(1) + this.m1.z * r.get(2) + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.get(0) + this.m2.y * r.get(1) + this.m2.z * r.get(2) + this.m2.a * 1.0f;

		dest.x = x_;
		dest.y = y_;
		dest.z = z_;
		
		return dest;
	}
	
	public Point3f transform(Tup3dBase r, Point3f dest)
	{
		double x_ = this.m0.x * r.get(0) + this.m0.y * r.get(1) + this.m0.z * r.get(2) + this.m0.a * 1.0f;
		double y_ = this.m1.x * r.get(0) + this.m1.y * r.get(1) + this.m1.z * r.get(2) + this.m1.a * 1.0f;
		double z_ = this.m2.x * r.get(0) + this.m2.y * r.get(1) + this.m2.z * r.get(2) + this.m2.a * 1.0f;

		dest.x = (float)x_;
		dest.y = (float)y_;
		dest.z = (float)z_;
		
		return dest;
	}
	
	public Point3f transform(Point3f r, Point3f dest)
	{
		float x_ = this.m0.x * r.x + this.m0.y * r.x + this.m0.z * r.x + this.m0.a * 1.0f;
		float y_ = this.m1.x * r.x + this.m1.y * r.x + this.m1.z * r.x + this.m1.a * 1.0f;
		float z_ = this.m2.x * r.x + this.m2.y * r.x + this.m2.z * r.x + this.m2.a * 1.0f;

		dest.x = x_;
		dest.y = y_;
		dest.z = z_;
		
		return dest;
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

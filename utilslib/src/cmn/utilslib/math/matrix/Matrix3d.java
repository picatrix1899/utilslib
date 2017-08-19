package cmn.utilslib.math.matrix;

import java.nio.DoubleBuffer;

import cmn.utilslib.essentials.BufferUtils;
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.tuple.Tuple3d;
import cmn.utilslib.math.vector.Vector3f;
import cmn.utilslib.math.vector.api.Vec3dBase;
import cmn.utilslib.math.vector.api.Vec3f;
import cmn.utilslib.math.vector.api.Vec3fBase;

/**
 * A 3 by 3 float Row Major Matrix 
 * 
 * @author picatrix1899
 *
 */
public class Matrix3d
{

	public static final int ROWS = 3;
	public static final int COLS = 3;
	public static final int ENTS = 9;
	
	public final Tuple3d m0 = new Tuple3d();
	public final Tuple3d m1 = new Tuple3d();
	public final Tuple3d m2 = new Tuple3d();
	
	public Matrix3d()
	{
		this.m0.v[0] = 1; this.m0.v[1] = 0; this.m0.v[2] = 0;
		this.m1.v[0] = 0; this.m1.v[1] = 1; this.m1.v[2] = 0;
		this.m2.v[0] = 0; this.m2.v[1] = 0; this.m2.v[2] = 1;
	}
	
	private Matrix3d(Matrix3d m)
	{
		this.m0.v[0] = m.m0.v[0]; this.m0.v[1] = m.m0.v[1]; this.m0.v[2] = m.m0.v[2];
		this.m1.v[0] = m.m1.v[0]; this.m1.v[1] = m.m1.v[1]; this.m1.v[2] = m.m1.v[2];
		this.m2.v[0] = m.m2.v[0]; this.m2.v[1] = m.m2.v[1]; this.m2.v[2] = m.m2.v[2];
	}
	
	public Matrix3d set(Matrix3d m)
	{
		this.m0.v[0] = m.m0.v[0]; this.m0.v[1] = m.m0.v[1]; this.m0.v[2] = m.m0.v[2];
		this.m1.v[0] = m.m1.v[0]; this.m1.v[1] = m.m1.v[1]; this.m1.v[2] = m.m1.v[2];
		this.m2.v[0] = m.m2.v[0]; this.m2.v[1] = m.m2.v[1]; this.m2.v[2] = m.m2.v[2];
		
		return this;
	}
	
	public static Matrix3d iZero()
	{
		Matrix3d m = new Matrix3d();
		
		m.m0.v[0] = 0; m.m0.v[1] = 0; m.m0.v[2] = 0;
		m.m1.v[0] = 0; m.m1.v[1] = 0; m.m1.v[2] = 0;
		m.m2.v[0] = 0; m.m2.v[1] = 0; m.m2.v[2] = 0;
		
		return m;
	}
	
	public Matrix3d initZero()
	{
		this.m0.v[0] = 0; this.m0.v[1] = 0; this.m0.v[2] = 0;
		this.m1.v[0] = 0; this.m1.v[1] = 0; this.m1.v[2] = 0;
		this.m2.v[0] = 0; this.m2.v[1] = 0; this.m2.v[2] = 0;
		
		return this;
	}
	
	public static Matrix3d iIdentity()
	{
		Matrix3d m = new Matrix3d();
		
		m.m0.v[0] = 1; m.m0.v[1] = 0; m.m0.v[2] = 0;
		m.m1.v[0] = 0; m.m1.v[1] = 1; m.m1.v[2] = 0;
		m.m2.v[0] = 0; m.m2.v[1] = 0; m.m2.v[2] = 1;
		
		return m;
	}
	
	public Matrix3d initIdendity()
	{
		this.m0.v[0] = 1; this.m0.v[1] = 0; this.m0.v[2] = 0;
		this.m1.v[0] = 0; this.m1.v[1] = 1; this.m1.v[2] = 0;
		this.m2.v[0] = 0; this.m2.v[1] = 0; this.m2.v[2] = 1;
		
		return this;
	}
	
	public static Matrix3d iRotation(Quaternion q)
	{
		Matrix3d m = new Matrix3d();
		
		m.m0.v[0] = 1 - 2		*	(q.y * q.y + q.z * q.z);
		m.m0.v[1] = 2			*	(q.x * q.y - q.w * q.z);
		m.m0.v[2] = 2			*	(q.x * q.z + q.w * q.y);
		
		m.m1.v[0] = 2			*	(q.x * q.y + q.w * q.z);
		m.m1.v[1] = 1 - 2		*	(q.x * q.x + q.z * q.z);
		m.m1.v[2] = 2			*	(q.y * q.z - q.w * q.x);
		
		m.m2.v[0] = 2			*	(q.x * q.z - q.w * q.y);
		m.m2.v[1] = 2			*	(q.y * q.z + q.w * q.x);
		m.m2.v[2] = 1 - 2		*	(q.x * q.x + q.y * q.y);
		
		return m;
	}
	
	public Matrix3d initRotation(Quaternion q)
	{
		this.m0.v[0] = 1 - 2	*	(q.y * q.y + q.z * q.z);
		this.m0.v[1] = 2		*	(q.x * q.y - q.w * q.z);
		this.m0.v[2] = 2		*	(q.x * q.z + q.w * q.y);
		
		this.m1.v[0] = 2		*	(q.x * q.y + q.w * q.z);
		this.m1.v[1] = 1 - 2	*	(q.x * q.x + q.z * q.z);
		this.m1.v[2] = 2		*	(q.y * q.z - q.w * q.x);
		
		this.m2.v[0] = 2		*	(q.x * q.z - q.w * q.y);
		this.m2.v[1] = 2		*	(q.y * q.z + q.w * q.x);
		this.m2.v[2] = 1 - 2	*	(q.x * q.x + q.y * q.y);
		
		return this;
	}
	
	public static Matrix3d iRotation(Vec3fBase axis, float angle)
	{
		Matrix3d m = new Matrix3d();
		
		double c = Math.cos(angle);
		double s = Math.sin(angle);
		
		double omc = 1 - c;
		
		double xy = axis.getX() * axis.getY();
		double xz = axis.getX() * axis.getZ();
		double yz = axis.getY() * axis.getZ();
		
		double sx = s * axis.getX();
		double sy = s * axis.getY();
		double sz = s * axis.getZ();
		
		m.m0.v[0] = axis.getX() * axis.getX() * omc + c;
		m.m0.v[1] = xy * omc - sz;
		m.m0.v[2] = xz * omc + sy;
		
		m.m1.v[0] = xy * omc + sz;
		m.m1.v[1] = axis.getY() * axis.getY() * omc + c;
		m.m1.v[2] = yz * omc - sx;
		
		m.m2.v[0] = xz * omc - sy;
		m.m2.v[1] = yz * omc + sx;
		m.m2.v[2] = axis.getZ() * axis.getZ() * omc + c;
		
		return m;
	}
	
	public static Matrix3d iRotation(Vec3dBase axis, float angle)
	{
		Matrix3d m = new Matrix3d();
		
		double c = Math.cos(angle);
		double s = Math.sin(angle);
		
		double omc = 1 - c;
		
		double xy = axis.getX() * axis.getY();
		double xz = axis.getX() * axis.getZ();
		double yz = axis.getY() * axis.getZ();
		
		double sx = s * axis.getX();
		double sy = s * axis.getY();
		double sz = s * axis.getZ();
		
		m.m0.v[0] = axis.getX() * axis.getX() * omc + c;
		m.m0.v[1] = xy * omc - sz;
		m.m0.v[2] = xz * omc + sy;
		
		m.m1.v[0] = xy * omc + sz;
		m.m1.v[1] = axis.getY() * axis.getY() * omc + c;
		m.m1.v[2] = yz * omc - sx;
		
		m.m2.v[0] = xz * omc - sy;
		m.m2.v[1] = yz * omc + sx;
		m.m2.v[2] = axis.getZ() * axis.getZ() * omc + c;
		
		return m;
	}
	
	public Matrix3d initRotation(Vec3fBase axis, float angle)
	{
		double c = Math.cos(angle);
		double s = Math.sin(angle);
		
		double omc = 1 - c;
		
		double xy = axis.getX() * axis.getY();
		double xz = axis.getX() * axis.getZ();
		double yz = axis.getY() * axis.getZ();
		
		double sx = s * axis.getX();
		double sy = s * axis.getY();
		double sz = s * axis.getZ();
		
		this.m0.v[0] = axis.getX() * axis.getX() * omc + c;
		this.m0.v[1] = xy * omc - sz;
		this.m0.v[2] = xz * omc + sy;
		
		this.m1.v[0] = xy * omc + sz;
		this.m1.v[1] = axis.getY() * axis.getY() * omc + c;
		this.m1.v[2] = yz * omc - sx;
		
		this.m2.v[0] = xz * omc - sy;
		this.m2.v[1] = yz * omc + sx;
		this.m2.v[2] = axis.getZ() * axis.getZ() * omc + c;
		
		return this;
	}
	
	public Matrix3d initRotation(Vec3dBase axis, float angle)
	{
		double c = Math.cos(angle);
		double s = Math.sin(angle);
		
		double omc = 1 - c;
		
		double xy = axis.getX() * axis.getY();
		double xz = axis.getX() * axis.getZ();
		double yz = axis.getY() * axis.getZ();
		
		double sx = s * axis.getX();
		double sy = s * axis.getY();
		double sz = s * axis.getZ();
		
		this.m0.v[0] = axis.getX() * axis.getX() * omc + c;
		this.m0.v[1] = xy * omc - sz;
		this.m0.v[2] = xz * omc + sy;
		
		this.m1.v[0] = xy * omc + sz;
		this.m1.v[1] = axis.getY() * axis.getY() * omc + c;
		this.m1.v[2] = yz * omc - sx;
		
		this.m2.v[0] = xz * omc - sy;
		this.m2.v[1] = yz * omc + sx;
		this.m2.v[2] = axis.getZ() * axis.getZ() * omc + c;
		
		return this;
	}
	
	public static Matrix3d iScaling(Vec3fBase v)
	{
		Matrix3d m = new Matrix3d();
		
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
	
	public static Matrix3d iScaling(Vec3dBase v)
	{
		Matrix3d m = new Matrix3d();
		
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
	
	public static Matrix3d iScaling(float sx, float sy, float sz)
	{
		Matrix3d m = new Matrix3d();
		
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
	
	public static Matrix3d iScaling(double sx, double sy, double sz)
	{
		Matrix3d m = new Matrix3d();
		
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
	
	public Matrix3d initScaling(Vec3fBase v)
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
	
	public Matrix3d initScaling(Vec3dBase v)
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
	
	public Matrix3d initScaling(float sx, float sy, float sz)
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
	
	public Matrix3d initScaling(double sx, double sy, double sz)
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
	
	
	public Matrix3d mul(Matrix3d m)
	{
		return Matrix3d.mul(this, m, null);		
	}
	
	public static Matrix3d mul(Matrix3d l, Matrix3d r, Matrix3d dest)
	{
		if (dest == null) dest = new Matrix3d();
		
		double m0x_ = l.m0.v[0] * r.m0.v[0] + l.m0.v[1] * r.m1.v[0] + l.m0.v[2] * r.m2.v[0];
		double m0y_ = l.m0.v[0] * r.m0.v[1] + l.m0.v[1] * r.m1.v[1] + l.m0.v[2] * r.m2.v[1];
		double m0z_ = l.m0.v[0] * r.m0.v[2] + l.m0.v[1] * r.m1.v[2] + l.m0.v[2] * r.m2.v[2];
		
		double m1x_ = l.m1.v[0] * r.m0.v[0] + l.m1.v[1] * r.m1.v[0] + l.m1.v[2] * r.m2.v[0];
		double m1y_ = l.m1.v[0] * r.m0.v[1] + l.m1.v[1] * r.m1.v[1] + l.m1.v[2] * r.m2.v[1];
		double m1z_ = l.m1.v[0] * r.m0.v[2] + l.m1.v[1] * r.m1.v[2] + l.m1.v[2] * r.m2.v[2];
		
		double m2x_ = l.m2.v[0] * r.m0.v[0] + l.m2.v[1] * r.m1.v[0] + l.m2.v[2] * r.m2.v[0];
		double m2y_ = l.m2.v[0] * r.m0.v[1] + l.m2.v[1] * r.m1.v[1] + l.m2.v[2] * r.m2.v[1];
		double m2z_ = l.m2.v[0] * r.m0.v[2] + l.m2.v[1] * r.m1.v[2] + l.m2.v[2] * r.m2.v[2];

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
	
	public static Vec3f transform(Matrix3d l, Vec3fBase r, Vec3f dest)
	{
		if (dest == null) dest = new Vector3f();

		dest.setX(l.m0.v[0] * r.getX() + l.m0.v[1] * r.getY() + l.m0.v[2] * r.getZ());
		dest.setY(l.m1.v[0] * r.getX() + l.m1.v[1] * r.getY() + l.m1.v[2] * r.getZ());
		dest.setZ(l.m2.v[0] * r.getX() + l.m2.v[1] * r.getY() + l.m2.v[2] * r.getZ());
		
		return dest;
	}
	

	public DoubleBuffer getRowMajorBuffer() { return BufferUtils.wrapFlippedDoubleBuffer(getRowMajor()); }
	
	public DoubleBuffer getColMajorBuffer() { return BufferUtils.wrapFlippedDoubleBuffer(getColMajor()); }	
	
	
	public double[] getColMajor()
	{
		double[] out = new double[Matrix3d.ENTS];
		
		out[0] = this.m0.v[0];	out[3] = this.m0.v[1];	out[6] = this.m0.v[2];
		out[1] = this.m1.v[0];	out[4] = this.m1.v[1];	out[7] = this.m1.v[2];
		out[2] = this.m2.v[0];	out[5] = this.m2.v[1];	out[8] = this.m2.v[2];
		
		return out;
	}
	
	public double[] getRowMajor()
	{
		double[] out = new double[Matrix3d.ENTS];
		
		out[0] = this.m0.v[0];	out[1] = this.m0.v[1];	out[2] = this.m0.v[2];
		out[3] = this.m1.v[0];	out[4] = this.m1.v[1];	out[5] = this.m1.v[2];
		out[6] = this.m2.v[0];	out[7] = this.m2.v[1];	out[8] = this.m2.v[2];
	
		return out;
	}

	
	public Matrix3d transpose()
	{
		double m0x_ = this.m0.v[0];
		double m0y_ = this.m1.v[0];
		double m0z_ = this.m2.v[0];
		
		double m1x_ = this.m0.v[1];
		double m1y_ = this.m1.v[1];
		double m1z_ = this.m2.v[1];
		
		double m2x_ = this.m0.v[2];
		double m2y_ = this.m1.v[2];
		double m2z_ = this.m2.v[2];
		
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


	
	public static double det3x3(double m0x, double m0y, double m0z, double m1x, double m1y, double m1z, double m2x, double m2y, double m2z)
	{
		return	m0x * +Matrix2d.det2x2(m1y, m1z, m2y, m2z) +
				m0y * -Matrix2d.det2x2(m1x, m1z, m2x, m2z) +
				m0z * +Matrix2d.det2x2(m1x, m1y, m2x, m2y);
	}
	
	public double determinant()
	{
		return Matrix3d.det3x3(m0.v[0], m0.v[1], m0.v[2], m1.v[0], m1.v[1], m1.v[2], m2.v[0], m2.v[1], m2.v[2]);
	}
	
	public Matrix3d inversed()
	{
		
		Matrix3d m = new Matrix3d();
		
		m.m0.v[0] = +Matrix2d.det2x2(this.m1.v[1], this.m1.v[2], this.m2.v[1], this.m2.v[2]);
		m.m0.v[1] = -Matrix2d.det2x2(this.m1.v[0], this.m1.v[2], this.m2.v[0], this.m2.v[2]);
		m.m0.v[2] = +Matrix2d.det2x2(this.m1.v[0], this.m1.v[1], this.m2.v[0], this.m2.v[1]);

		m.m1.v[0] = -Matrix2d.det2x2(this.m0.v[1], this.m0.v[2], this.m2.v[1], this.m2.v[2]);
		m.m1.v[1] = +Matrix2d.det2x2(this.m0.v[0], this.m0.v[2], this.m2.v[0], this.m2.v[2]);
		m.m1.v[2] = -Matrix2d.det2x2(this.m0.v[0], this.m0.v[1], this.m2.v[0], this.m2.v[1]);
		
		m.m2.v[0] = +Matrix2d.det2x2(this.m0.v[1], this.m0.v[2], this.m1.v[1], this.m1.v[2]);
		m.m2.v[1] = -Matrix2d.det2x2(this.m0.v[0], this.m0.v[2], this.m1.v[0], this.m1.v[2]);
		m.m2.v[2] = +Matrix2d.det2x2(this.m0.v[0], this.m0.v[1], this.m1.v[0], this.m1.v[1]);

		double D = determinant();
		
		if(D != 0)
		{
			m0.v[0] /= D;
			m0.v[1] /= D;
			m0.v[2] /= D;
			
			m1.v[0] /= D;
			m1.v[1] /= D;
			m1.v[2] /= D;
			
			m2.v[0] /= D;
			m2.v[1] /= D;
			m2.v[2] /= D;	
		}
		
		return m;
	}
	
	public Matrix3d invert()
	{
		double m0x = +Matrix2d.det2x2(this.m1.v[1], this.m1.v[2], this.m2.v[1], this.m2.v[2]);
		double m0y = -Matrix2d.det2x2(this.m1.v[0], this.m1.v[2], this.m2.v[0], this.m2.v[2]);
		double m0z = +Matrix2d.det2x2(this.m1.v[0], this.m1.v[1], this.m2.v[0], this.m2.v[1]);

		double m1x = -Matrix2d.det2x2(this.m0.v[1], this.m0.v[2], this.m2.v[1], this.m2.v[2]);
		double m1y = +Matrix2d.det2x2(this.m0.v[0], this.m0.v[2], this.m2.v[0], this.m2.v[2]);
		double m1z = -Matrix2d.det2x2(this.m0.v[0], this.m0.v[1], this.m2.v[0], this.m2.v[1]);
		
		double m2x = +Matrix2d.det2x2(this.m0.v[1], this.m0.v[2], this.m1.v[1], this.m1.v[2]);
		double m2y = -Matrix2d.det2x2(this.m0.v[0], this.m0.v[2], this.m1.v[0], this.m1.v[2]);
		double m2z = +Matrix2d.det2x2(this.m0.v[0], this.m0.v[1], this.m1.v[0], this.m1.v[1]);

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

	public Matrix3d clone()
	{
		return new Matrix3d(this);
	}
	
}

package cmn.utilslib.vector;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cmn.utilslib.essentials.Func;
import cmn.utilslib.essentials.Maths;
import cmn.utilslib.interfaces.Streamable;
import cmn.utilslib.matrix.Matrix4f;
import cmn.utilslib.vector.api.Vec3dBase;
import cmn.utilslib.vector.api.Vec3f;
import cmn.utilslib.vector.api.Vec3fBase;
import cmn.utilslib.vector.api.Vec4dBase;
import cmn.utilslib.vector.api.Vec4fBase;

/**
 * A Quaternion
 * 
 * @author picatrix1899
 *
 */
public class Quaternion implements Streamable
{
	private double x;
	private double y;
	private double z;
	private double w;
	
	public Quaternion(double w, double x, double y, double z)
	{
		set(w, x, y, z);
	}
	
	public Quaternion()
	{
		this(1.0d, 0.0d, 0.0d, 0.0d);
	}
	
	private Quaternion(Quaternion q)
	{
		this(q.w, q.x, q.y, q.z);
	}
	
	//From Ken Shoemake's "Quaternion Calculus and Fast Animation" article
	public Quaternion(Matrix4f rot)
	{
		float trace = rot.m0.x + rot.m1.y + rot.m2.z;

		if(trace > 0)
		{
			float s = 0.5f / (float)Math.sqrt(trace+ 1.0f);
			w = 0.25f / s;
			x = (rot.m1.z - rot.m2.y) * s;
			y = (rot.m2.x - rot.m0.z) * s;
			z = (rot.m0.y - rot.m1.x) * s;
		}
		else
		{
			if(rot.m0.x > rot.m1.y && rot.m0.x > rot.m2.z)
			{
				float s = 2.0f * (float)Math.sqrt(1.0f + rot.m0.x - rot.m1.y - rot.m2.z);
				w = (rot.m1.z - rot.m2.y) / s;
				x = 0.25f * s;
				y = (rot.m1.x + rot.m0.y) / s;
				z = (rot.m2.x + rot.m0.z) / s;
			}
			else if(rot.m1.y > rot.m2.z)
			{
				float s = 2.0f * (float)Math.sqrt(1.0f + rot.m1.y - rot.m0.x - rot.m2.z);
				w = (rot.m2.x - rot.m0.z) / s;
				x = (rot.m1.x + rot.m0.y) / s;
				y = 0.25f * s;
				z = (rot.m2.y + rot.m1.z) / s;
			}
			else
			{
				float s = 2.0f * (float)Math.sqrt(1.0f + rot.m2.z - rot.m0.x - rot.m1.y);
				w = (rot.m0.y - rot.m1.x ) / s;
				x = (rot.m2.x + rot.m0.z ) / s;
				y = (rot.m1.z + rot.m2.y ) / s;
				z = 0.25f * s;
			}
		}

		float length = (float)Math.sqrt(x * x + y * y + z * z + w * w);
		x /= length;
		y /= length;
		z /= length;
		w /= length;
	}
	
	
	public static Quaternion getFromAxis(Vec3fBase axis, float angle) { return getFromAxis(axis.getX(), axis.getY(), axis.getZ(), angle); }
	
	public static Quaternion getFromAxis(float ax, float ay, float az, float angle)
	{
		double halfAngle = angle * 0.5d * Maths.DEG_TO_RAD;
		double sinHalfAngle = Math.sin(halfAngle);
		double cosHalfAngle = Math.cos(halfAngle);
		
		double rX = ax * sinHalfAngle;
		double rY = ay * sinHalfAngle;
		double rZ = az * sinHalfAngle;
		double rW = cosHalfAngle;
		
		return new Quaternion(rW, rX, rY, rZ).normalize();
	}
	
	public static Quaternion getFromAxis(Vec3fBase axis, double angle) { return getFromAxis(axis.getX(), axis.getY(), axis.getZ(), angle); }
	
	public static Quaternion getFromAxis(float ax, float ay, float az, double angle)
	{
		double halfAngle = angle * 0.5d * Maths.DEG_TO_RAD;
		double sinHalfAngle = Math.sin(halfAngle);
		double cosHalfAngle = Math.cos(halfAngle);
		
		double rX = ax * sinHalfAngle;
		double rY = ay * sinHalfAngle;
		double rZ = az * sinHalfAngle;
		double rW = cosHalfAngle;
		
		return new Quaternion(rW, rX, rY, rZ).normalize();
	}
	
	public static Quaternion getFromAxis(double ax, double ay, double az, float angle)
	{
		double halfAngle = angle * 0.5d * Maths.DEG_TO_RAD;
		double sinHalfAngle = Math.sin(halfAngle);
		double cosHalfAngle = Math.cos(halfAngle);
		
		double rX = ax * sinHalfAngle;
		double rY = ay * sinHalfAngle;
		double rZ = az * sinHalfAngle;
		double rW = cosHalfAngle;
		
		return new Quaternion(rW, rX, rY, rZ).normalize();
	}
	
	public static Quaternion getFromAxis(double ax, double ay, double az, double angle)
	{
		double halfAngle = angle * 0.5d * Maths.DEG_TO_RAD;
		double sinHalfAngle = Math.sin(halfAngle);
		double cosHalfAngle = Math.cos(halfAngle);
		
		double rX = ax * sinHalfAngle;
		double rY = ay * sinHalfAngle;
		double rZ = az * sinHalfAngle;
		double rW = cosHalfAngle;
		
		return new Quaternion(rW, rX, rY, rZ).normalize();
	}
	
	public static Quaternion getFromVector(Vec3fBase v1)
	{
		Vec3f a = Vec3f.aZ.clone();
		Vec3f b = v1.clone().normalize();
		Vec3f axis = a.cross(b);
		double angle = 1 + a.dot(b);
		
		axis.normalize();
		
		return new Quaternion(angle, axis.getX(), axis.getY(), axis.getZ()).normalize();
	}
	
	public static Quaternion getFromVectors(Vec3fBase v1, Vec3fBase v2)
	{
		Vec3f a = v1.clone().normalize();
		Vec3f b = v2.clone().normalize();
		Vec3f axis = a.cross(b);
		double angle = 1 + a.dot(b);
		
		axis.normalize();
		return new Quaternion(angle, axis.getX(), axis.getY(), axis.getZ()).normalize();
	}
	
	public double getW() { return this.w; }
	
	public double getX() { return this.x; }
	
	public double getY() { return this.y; }
	
	public double getZ() { return this.z; }

	public Quaternion rotate(Vec3fBase axis, float angle) { return rotate(axis.getX(), axis.getY(), axis.getZ(), angle); }
	
	public Quaternion rotate(float ax, float ay, float az, float angle)
	{
		return set(getFromAxis(ax, ay, az, angle).mul(this));
	}
	
	public Quaternion rotate(Vec3fBase axis, double angle) { return rotate(axis.getX(), axis.getY(), axis.getZ(), angle); }
	
	public Quaternion rotate(float ax, float ay, float az, double angle)
	{
		return set(getFromAxis(ax, ay, az, angle).mul(this));
	}
	
	public Quaternion rotate(double ax, double ay, double az, float angle)
	{
		return set(getFromAxis(ax, ay, az, angle).mul(this));
	}
	
	public Quaternion rotate(double ax, double ay, double az, double angle)
	{
		return set(getFromAxis(ax, ay, az, angle).mul(this));
	}
	
	public Quaternion rotate(Quaternion q)
	{
		return set(q.mul(this));
	}
	
	public Quaternion rotateTo(Vec3fBase v)
	{
		Vec3f a = getForwardf().clone().normalize();
		Vec3f b = v.clone().normalize();
		
		
		Vec3f axis = a.cross(b);
		double rot = a.dot(b);
		
		axis.normalize();
		
		setX(axis.getX());
		setY(axis.getY());
		setZ(axis.getZ());
		setW(1.0 + rot);
		
		normalize();
		
		return this;
		
	}
	
	public double getEulerPitch()
	{

		Vec3f a = getForwardf();
		Vec3f b = a.clone().setY(0);
			
		int i = a.getY() > 0 ? -1 : 1;
		
		return i * b.angleDeg(a);
	}
	
	public double getEulerYaw()
	{
		return Maths.RAD_TO_DEG * Math.asin((2 * this.w * this.y + this.z * this.x));
	}	
	
	public double getEulerRoll()
	{
		return Maths.RAD_TO_DEG * Math.asin((2 * this.w * this.y + this.z * this.x));
	}
	
	public Quaternion set(Quaternion q)
	{
		return set(q.getW(), q.getX(), q.getY(), q.getZ());
	}
	
	public Quaternion set(double w, double x, double y, double z)
	{
		return setW(w).setX(x).setY(y).setZ(z);
	}
	
	public Quaternion setW(double w)
	{
		this.w = w;
		
		return this;
	}
	
	public Quaternion setX(double x)
	{
		this.x = x;
		
		return this;
	}
	
	public Quaternion setY(double y)
	{
		this.y = y;
		
		return this;
	}
	
	public Quaternion setZ(double z)
	{
		this.z = z;
		
		return this;
	}
	
	public Quaternion conjugate()
	{
		set(this.w, -this.x, -this.y, -this.z);
		
		return this;
	}
	
	public Quaternion conjugated() { return clone().conjugate(); }
	
	public Quaternion add(Quaternion q) { return set(this.w + q.w, this.x + q.x, this.y + q.y, this.z + q.z); }
	
	public Quaternion mul(Quaternion q)
	{
		double w_ = this.w * q.w - this.x * q.x - this.y * q.y - this.z * q.z; // w * w' - v * v'
		double x_ = this.w * q.x + q.w * this.x + this.y * q.z - this.z * q.y; // s * v'.x + s' * v.x + (V x V').x
		double y_ = this.w * q.y + q.w * this.y + this.z * q.x - this.x * q.z; // s * v'.y + s' * v.y + (V x V').y
		double z_ = this.w * q.z + q.w * this.z + this.x * q.y - this.y * q.x; // s * v'.z + s' * v.z + (V x V').z
		
		set(w_, x_, y_, z_);
		
		return this;
	}
	
	public Quaternion mul(Vec3fBase v)
	{
		double w_ = -this.x * v.getX() - this.y * v.getY() - this.z * v.getZ(); // - v * v'
		double x_ =  this.w * v.getX() + this.y * v.getZ() - this.z * v.getY(); // s * v'.x ...
		double y_ =  this.w * v.getY() + this.z * v.getX() - this.x * v.getZ(); // s * v'.y ...
		double z_ =  this.w * v.getZ() + this.x * v.getY() - this.y * v.getX(); // s * v*.z ...
		
		set(w_, x_, y_, z_);
		
		return this;
		
	}
	
	public Quaternion mul(Vec3dBase v)
	{
		double w_ = -this.x * v.getX() - this.y * v.getY() - this.z * v.getZ(); // - v * v'
		double x_ =  this.w * v.getX() + this.y * v.getZ() - this.z * v.getY(); // s * v'.x ...
		double y_ =  this.w * v.getY() + this.z * v.getX() - this.x * v.getZ(); // s * v'.y ...
		double z_ =  this.w * v.getZ() + this.x * v.getY() - this.y * v.getX(); // s * v*.z ...
		
		set(w_, x_, y_, z_);
		
		return this;
		
	}

	public Quaternion mul(Vec4fBase v)
	{
		double w_ = -this.x * v.getX() - this.y * v.getY() - this.z * v.getZ(); // - v * v'
		double x_ =  this.w * v.getX() + this.y * v.getZ() - this.z * v.getY(); // s * v'.x ...
		double y_ =  this.w * v.getY() + this.z * v.getX() - this.x * v.getZ(); // s * v'.y ...
		double z_ =  this.w * v.getZ() + this.x * v.getY() - this.y * v.getX(); // s * v*.z ...
		
		set(w_, x_, y_, z_);
		
		return this;
		
	}
	
	public Quaternion mul(Vec4dBase v)
	{
		double w_ = -this.x * v.getX() - this.y * v.getY() - this.z * v.getZ(); // - v * v'
		double x_ =  this.w * v.getX() + this.y * v.getZ() - this.z * v.getY(); // s * v'.x ...
		double y_ =  this.w * v.getY() + this.z * v.getX() - this.x * v.getZ(); // s * v'.y ...
		double z_ =  this.w * v.getZ() + this.x * v.getY() - this.y * v.getX(); // s * v*.z ...
		
		set(w_, x_, y_, z_);
		
		return this;
		
	}
	
	public Quaternion addN(Quaternion q) { return this.clone().add(q); }
	
	public Quaternion mulN(Quaternion q) { return this.clone().mul(q); }
	
	public Quaternion mulN(Vec3fBase v) { return this.clone().mul(v); }
	
	public Quaternion mulN(Vec3dBase v) { return this.clone().mul(v); }
	
	public Quaternion mulN(Vec4fBase v) { return this.clone().mul(v); }
	
	public Quaternion mulN(Vec4dBase v) { return this.clone().mul(v); }
	
	
	public Vec3f getForwardf() { return Vec3f.aZ.clone().rot(this).normalize(); }
	
	public Vec3f getBackf() { return Vec3f.aNZ.clone().rot(this).normalize(); }
	
	public Vec3f getUpf() { return Vec3f.aY.clone().rot(this).normalize(); }
	
	public Vec3f getDownf() { return Vec3f.aNY.clone().rot(this).normalize(); }
	
	public Vec3f getRightf() { return Vec3f.aNX.clone().rot(this).normalize(); }
	
	public Vec3f getLeftf() { return Vec3f.aX.clone().rot(this).normalize(); }
	
	
	public double length() { return Math.sqrt(this.w * this.w + this.x * this.x + this.y * this.y + this.z * this.z); }
	
	public Quaternion normalize()
	{
		double l = length();
		
		setW(this.w / l);
		setX(this.x / l);
		setY(this.y / l);
		setZ(this.z / l);
		
		return this;
	}
	
	public Quaternion normalized() { return clone().normalize(); }
	
	public Quaternion clone() { return new Quaternion(this); }
	
	public String toString()
	{
		return "quaternion(" + this.w + "d " + this.x + "d " + this.y + "d " + this.z + "d)";
	}
	
	public void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		this.w = dis.readDouble();
		this.x = dis.readDouble();
		this.y = dis.readDouble();
		this.z = dis.readDouble();
	}


	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeDouble(this.w);
		dos.writeDouble(this.x);
		dos.writeDouble(this.y);
		dos.writeDouble(this.z);
	}

}

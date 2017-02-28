package cmn.utilslib.vector;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cmn.utilslib.essentials.Maths;
import cmn.utilslib.interfaces.IStreamable;
import cmn.utilslib.matrix.Matrix4f;

/**
 * A Quaternion
 * 
 * @author picatrix1899
 *
 */
public class Quaternion implements IStreamable
{
	private double x;
	private double y;
	private double z;
	private double w;
	
	private double ePitch;
	private double eYaw;
	private double eRoll;
	
	private boolean uPitch;
	private boolean uYaw;
	private boolean uRoll;
	
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
	
	
	public static Quaternion getFromAxis(Vec3f axis, float angle) { return getFromAxis(axis.x, axis.y, axis.z, angle); }
	
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
	
	public static Quaternion getFromAxis(Vec3f axis, double angle) { return getFromAxis(axis.x, axis.y, axis.z, angle); }
	
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
	
	public static Quaternion getFromVector(Vec3f v1)
	{
		Vec3f a = Vec3f.aZ.getNewVector();
		Vec3f b = v1.clone().normalize();
		Vec3f axis = a.cross(b);
		float angle = 1 + a.dot(b);
		
		axis.normalize();
		
		return new Quaternion(angle, axis.x, axis.y, axis.z).normalize();
	}
	
	public static Quaternion getFromVectors(Vec3f v1, Vec3f v2)
	{
		Vec3f a = v1.clone().normalize();
		Vec3f b = v2.clone().normalize();
		Vec3f axis = a.cross(b);
		float angle = 1 + a.dot(b);
		
		axis.normalize();
		return new Quaternion(angle, axis.x, axis.y, axis.z).normalize();
	}
	
	public double getW() { return this.w; }
	
	public double getX() { return this.x; }
	
	public double getY() { return this.y; }
	
	public double getZ() { return this.z; }

	public Quaternion rotate(Vec3f axis, float angle) { return rotate(axis.x, axis.y, axis.z, angle); }
	
	public Quaternion rotate(float ax, float ay, float az, float angle)
	{
		return set(getFromAxis(ax, ay, az, angle).mul(this));
	}
	
	public Quaternion rotate(Vec3f axis, double angle) { return rotate(axis.x, axis.y, axis.z, angle); }
	
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
	
	public Quaternion rotateTo(Vec3f v)
	{
		Vec3f a = getForward().clone().normalize();
		Vec3f b = v.clone().normalize();
		
		
		Vec3f axis = a.cross(b);
		float rot = a.dot(b);
		
		axis.normalize();
		
		setX(axis.x);
		setY(axis.y);
		setZ(axis.z);
		setW(1.0 + rot);
		
		normalize();
		
		return this;
		
	}
	
	public double getEulerPitch()
	{
		if(!this.uPitch)
		{

			Vec3f a = getForward();
			Vec3f b = a.clone().setY(0);
			
			int i = a.y > 0 ? -1 : 1;
			
			this.ePitch = i * b.angleDeg(a);
			
			this.uPitch = true;
		}

		return this.ePitch;
	}
	
	public double getEulerYaw()
	{
		if(!this.uYaw)
		{
			this.eYaw = Maths.RAD_TO_DEG * Math.asin((2 * this.w * this.y + this.z * this.x));
			
			this.uYaw = true;
		}

		return this.eYaw;
	}	
	
	public double getEulerRoll()
	{
		if(!this.uRoll)
		{

			this.eRoll = Maths.RAD_TO_DEG * Math.asin((2 * this.w * this.y + this.z * this.x));
			
			this.uRoll = true;
		}

		return this.eRoll;
	}
	
	public Quaternion set(Quaternion q)
	{
		return set(q.getW(), q.getX(), q.getY(), q.getZ());
	}
	
	public Quaternion set(double w, double x, double y, double z)
	{
		setW(w).setX(x).setY(y).setZ(z); return this;
	}
	
	public Quaternion setW(double w)
	{
		this.w = w;
		
		this.uPitch = false;
		this.uYaw = false;
		this.uRoll = false;
		
		return this;
	}
	
	public Quaternion setX(double x)
	{
		this.x = x;
		
		this.uPitch = false;
		
		return this;
	}
	
	public Quaternion setY(double y)
	{
		this.y = y;

		this.uYaw = false;
		
		return this;
	}
	
	public Quaternion setZ(double z)
	{
		this.z = z;
		
		this.uRoll = false;
		
		return this;
	}
	
	public Quaternion conjugate()
	{
		set(this.w, -this.x, -this.y, -this.z);
		
		return this;
	}
	
	public Quaternion conjugated() { return clone().conjugate(); }
	
	public Quaternion add(Quaternion q) { set(this.w + q.w, this.x + q.x, this.y + q.y, this.z + q.z); return this; }
	
	public Quaternion mul(Quaternion q)
	{
		double w_ = this.w * q.w - this.x * q.x - this.y * q.y - this.z * q.z; // w * w' - v * v'
		double x_ = this.w * q.x + q.w * this.x + this.y * q.z - this.z * q.y; // s * v'.x + s' * v.x + (V x V').x
		double y_ = this.w * q.y + q.w * this.y + this.z * q.x - this.x * q.z; // s * v'.y + s' * v.y + (V x V').y
		double z_ = this.w * q.z + q.w * this.z + this.x * q.y - this.y * q.x; // s * v'.z + s' * v.z + (V x V').z
		
		set(w_, x_, y_, z_);
		
		return this;
	}
	
	public Quaternion mul(Vec3f v)
	{
		double w_ = -this.x * v.x - this.y * v.y - this.z * v.z; // - v * v'
		double x_ =  this.w * v.x + this.y * v.z - this.z * v.y; // s * v'.x ...
		double y_ =  this.w * v.y + this.z * v.x - this.x * v.z; // s * v'.y ...
		double z_ =  this.w * v.z + this.x * v.y - this.y * v.x; // s * v*.z ...
		
		set(w_, x_, y_, z_);
		
		return this;
		
	}
	
	public Quaternion addN(Quaternion q) { return this.clone().add(q); }
	
	public Quaternion mulN(Quaternion q) { return this.clone().mul(q); }
	
	public Quaternion mulN(Vec3f v) { return this.clone().mul(v); }
	
	
	
	public Vec3f getForward() { return Vec3f.aZ.getVector().rot(this).normalize(); }
	
	public Vec3f getBack() { return Vec3f.aNZ.getVector().rot(this).normalize(); }
	
	public Vec3f getUp() { return Vec3f.aY.getVector().rot(this).normalize(); }
	
	public Vec3f getDown() { return Vec3f.aNY.getVector().rot(this).normalize(); }
	
	public Vec3f getRight() { return Vec3f.aNX.getVector().rot(this).normalize(); }
	
	public Vec3f getLeft() { return Vec3f.aX.getVector().rot(this).normalize(); }
	

	
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
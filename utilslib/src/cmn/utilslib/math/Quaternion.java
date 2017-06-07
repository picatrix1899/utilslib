package cmn.utilslib.math;


import cmn.utilslib.math.vector.Vector3f;
import cmn.utilslib.math.matrix.Matrix4f;
import cmn.utilslib.math.vector.api.Vec3dBase;
import cmn.utilslib.math.vector.api.Vec3f;
import cmn.utilslib.math.vector.api.Vec3fBase;
import cmn.utilslib.math.vector.api.Vec4dBase;
import cmn.utilslib.math.vector.api.Vec4fBase;

/**
 * A Quaternion
 * 
 * @author picatrix1899
 *
 */
public class Quaternion
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
		double trace = rot.m0.x + rot.m1.y + rot.m2.z;

		if(trace > 0)
		{
			double s = 0.5d / Math.sqrt(trace + 1.0d);
			w = 0.25d / s;
			x = (rot.m1.z - rot.m2.y) * s;
			y = (rot.m2.x - rot.m0.z) * s;
			z = (rot.m0.y - rot.m1.x) * s;
		}
		else
		{
			if(rot.m0.x > rot.m1.y && rot.m0.x > rot.m2.z)
			{
				double s = 2.0d * Math.sqrt(1.0d + rot.m0.x - rot.m1.y - rot.m2.z);
				w = (rot.m1.z - rot.m2.y) / s;
				x = 0.25d * s;
				y = (rot.m1.x + rot.m0.y) / s;
				z = (rot.m2.x + rot.m0.z) / s;
			}
			else if(rot.m1.y > rot.m2.z)
			{
				double s = 2.0d * Math.sqrt(1.0d + rot.m1.y - rot.m0.x - rot.m2.z);
				w = (rot.m2.x - rot.m0.z) / s;
				x = (rot.m1.x + rot.m0.y) / s;
				y = 0.25d * s;
				z = (rot.m2.y + rot.m1.z) / s;
			}
			else
			{
				double s = 2.0d * Math.sqrt(1.0d + rot.m2.z - rot.m0.x - rot.m1.y);
				w = (rot.m0.y - rot.m1.x ) / s;
				x = (rot.m2.x + rot.m0.z ) / s;
				y = (rot.m1.z + rot.m2.y ) / s;
				z = 0.25d * s;
			}
		}

		double length = Math.sqrt(x * x + y * y + z * z + w * w);
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
		Vector3f a = Vec3f.aZ.clone();
		Vector3f b = (Vector3f) v1.clone().normalize();
		Vector3f axis = a.cross(b);
		double angle = 1.0d + a.dot(b);
		
		axis.normalize();
		
		return new Quaternion(angle, axis.getX(), axis.getY(), axis.getZ()).normalize();
	}
	
	public static Quaternion getFromVectors(Vec3fBase v1, Vec3fBase v2)
	{
		Vector3f a = (Vector3f) v1.clone().normalize();
		Vector3f b = (Vector3f) v2.clone().normalize();
		Vector3f axis = a.cross(b);
		double angle = 1.0d + a.dot(b);
		
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
		Vector3f a = getForwardf().clone().normalize();
		Vector3f b = (Vector3f) v.clone().normalize();
		
		
		Vector3f axis = a.cross(b);
		double rot = a.dot(b);
		
		axis.normalize();
		
		setX(axis.getX());
		setY(axis.getY());
		setZ(axis.getZ());
		setW(1.0d + rot);
		
		normalize();
		
		return this;
		
	}
	
	public double getEulerPitch()
	{

		Vector3f a = getForwardf();
		Vector3f b = (Vector3f) a.clone().setY(0);
			
		int i = a.getY() > 0 ? -1 : 1;
		
		return i * b.angleDeg(a);
	}
	
	public double getEulerYaw()
	{
		return Maths.RAD_TO_DEG * Math.asin((2.0d * this.w * this.y + this.z * this.x));
	}	
	
	public double getEulerRoll()
	{
		return Maths.RAD_TO_DEG * Math.asin((2.0d * this.w * this.y + this.z * this.x));
	}
	
	public Quaternion set(Quaternion q)
	{
		return set(q.getW(), q.getX(), q.getY(), q.getZ());
	}
	
	public Quaternion set(double w, double x, double y, double z)
	{
		return setW(w).setX(x).setY(y).setZ(z);
	}
	
	public Quaternion setW(double w) { this.w = w; return this; }
	
	public Quaternion setX(double x) { this.x = x; return this; }
	
	public Quaternion setY(double y) { this.y = y; return this; }
	
	public Quaternion setZ(double z) { this.z = z; return this; }
	
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
	
	
	public Vector3f getForwardf() { return Vec3f.aZ.clone().rot(this).normalize(); }
	
	public Vector3f getBackf() { return Vec3f.aNZ.clone().rot(this).normalize(); }
	
	public Vector3f getUpf() { return Vec3f.aY.clone().rot(this).normalize(); }
	
	public Vector3f getDownf() { return Vec3f.aNY.clone().rot(this).normalize(); }
	
	public Vector3f getRightf() { return Vec3f.aNX.clone().rot(this).normalize(); }
	
	public Vector3f getLeftf() { return Vec3f.aX.clone().rot(this).normalize(); }
	
	
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

}

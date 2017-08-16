
package cmn.utilslib.math.vector;


import cmn.utilslib.Allocator;
import cmn.utilslib.math.Maths;
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.tuple.api.Tup2dBase;
import cmn.utilslib.math.tuple.api.Tup2fBase;
import cmn.utilslib.math.vector.api.Vec2d;
import cmn.utilslib.math.vector.api.Vec2dBase;
import cmn.utilslib.math.vector.api.Vec2fBase;

/**
 * A mathematical 2-dimensional vector of type float
 * 
 * @author picatrix1899
 *
 */
public class Vector2d implements Vec2d
{

	/*
	##################
	##              ##
	##  DIMENSIONS  ##
	##              ##
	##################
	 */
	
	public float x = 0.0f;
	public float y = 0.0f;
	
	/*
	#########################
	##                     ##
	##  TEMPORARY VECTORS  ##
	##                     ##
	#########################
	 */
	
	public static final Vector2d TEMP = new Vector2d();
	public static final Vector2d TEMP0 = new Vector2d();
	public static final Vector2d TEMP1 = new Vector2d();
	public static final Vector2d TEMP2 = new Vector2d();
	public static final Vector2d TEMP3 = new Vector2d();
	public static final Vector2d TEMP4 = new Vector2d();
	public static final Vector2d TEMP5 = new Vector2d();
	public static final Vector2d TEMP6 = new Vector2d();
	public static final Vector2d TEMP7 = new Vector2d();
	public static final Vector2d TEMP8 = new Vector2d();
	public static final Vector2d TEMP9 = new Vector2d();
	
	/*
	##################
	##              ##
	##  ALLOCATION  ##
	##              ##
	##################
	 */
	
	private static Allocator<Vector2d> allocator = new Allocator<Vector2d>(Vector2d.class);
	
	public static Vector2d alloc() { return allocator.alloc().setZero(); }
	public static Vector2d alloc(Vec2fBase v) { return allocator.alloc().set(v); }
	public static Vector2d alloc(Vec2dBase v) { return allocator.alloc().set(v); }
	public static Vector2d alloc(Tup2fBase t) { return allocator.alloc().set(t); }
	public static Vector2d alloc(Tup2dBase t) { return allocator.alloc().set(t); }
	public static Vector2d alloc(float scalar) { return allocator.alloc().set(scalar); }
	public static Vector2d alloc(double scalar) { return allocator.alloc().set(scalar); }
	public static Vector2d alloc(float x, float y) { return allocator.alloc().set(x, y); }
	public static Vector2d alloc(double x, double y) { return allocator.alloc().set(x, y); }
	
	public static void dealloc(Vector2d v) { allocator.dealloc(v); }

	/*
	####################
	##                ##
	##  CONSTRUCTORS  ##
	##                ##
	####################
	 */
	
	public Vector2d() { this.x = 0; this.y = 0; }
	
	public Vector2d(float scalar) { this.x = scalar; this.y = scalar; }
	public Vector2d(double scalar) { this.x = (float)scalar; this.y = (float)scalar; }
	
	public Vector2d(float x, float y) { this.x = x; this.y = y; }
	public Vector2d(double x, double y) { this.x = (float)x; this.y = (float)y; }

	public Vector2d(Vec2fBase v) { this.x = v.getX(); this.y = v.getY(); }
	public Vector2d(Vec2dBase v) { this.x = (float)v.getX(); this.y = (float)v.getY(); }
	public Vector2d(Tup2fBase t) { this.x = t.get(0); this.y = t.get(1); }
	public Vector2d(Tup2dBase t) { this.x = (float)t.get(0); this.y = (float)t.get(1); }
	
	/*
	###############
	##           ##
	##  GETTERS  ##
	##           ##
	###############
	 */
	
	/** {@inheritDoc} */
	public double getX() { return this.x; }
	
	/** {@inheritDoc} */
	public double getY() { return this.y; }
	
	
	
	/** {@inheritDoc} */
	public double get(int index)
	{
		switch(index)
		{
			case 0: return this.x;
			case 1: return this.y;
		}
		return Float.NaN;
	}

	/*
	###############
	##           ##
	##  SETTERS  ##
	##           ##
	###############
	 */

	/** {@inheritDoc} */
	public Vector2d setZero() { this.x = 0; this.y = 0; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector2d set(Vec2fBase v) { this.x = v.getX(); this.y = v.getY(); return this; }
	
	/** {@inheritDoc} */
	public Vector2d set(Vec2dBase v) { this.x = (float)v.getX(); this.y = (float)v.getY(); return this; }
	
	/** {@inheritDoc} */
	public Vector2d set(Tup2fBase t) { this.x = t.get(0); this.y = t.get(1); return this; }
	
	/** {@inheritDoc} */
	public Vector2d set(Tup2dBase t) { this.x = (float)t.get(0); this.y = (float)t.get(1); return this; }
	
	
	/** {@inheritDoc} */
	public Vector2d set(float scalar) { this.x = scalar; this.y = scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector2d set(double scalar) { this.x = (float)scalar; this.y = (float)scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector2d set(float x, float y) { this.x = x; this.y = y; return this; }
	
	/** {@inheritDoc} */
	public Vector2d set(double x, double y) { this.x = (float)x; this.y = (float)y; return this;  }
	
	
	
	/** {@inheritDoc} */
	public Vector2d setX(float x) { this.x = x; return this; }
	
	/** {@inheritDoc} */
	public Vector2d setX(double x) { this.x = (float)x; return this; }
	
	/** {@inheritDoc} */
	public Vector2d setY(float y) { this.y = y; return this; }
	
	/** {@inheritDoc} */
	public Vector2d setY(double y) { this.y = (float)y; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector2d set(int index, float value)
	{
		switch(index)
		{
			case 0: this.x = value; break;
			case 1: this.y = value; break;
		}
		return this;
	}
	
	/** {@inheritDoc} */
	public Vector2d set(int index, double value)
	{
		switch(index)
		{
			case 0: this.x = (float)value; break;
			case 1: this.y = (float)value; break;
		}
		return this;
	}
	
	/*
	#########################
	##                     ##
	##  BASIC ARITHMETICS  ##
	##                     ##
	#########################
	 */
	
	/** {@inheritDoc} */
	public Vector2d add(Vec2fBase v) { this.x += v.getX(); this.y += v.getY(); return this; }
	
	/** {@inheritDoc} */
	public Vector2d add(Vec2dBase v) { this.x += v.getX(); this.y += v.getY(); return this; }
	
	/** {@inheritDoc} */
	public Vector2d add(float scalar) { this.x += scalar; this.y += scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector2d add(double scalar) { this.x += scalar; this.y += scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector2d add(float x, float y) { this.x += x; this.y += y; return this; }
	
	/** {@inheritDoc} */
	public Vector2d add(double x, double y) { this.x += x; this.y += y; return this; }

	
	
	/** {@inheritDoc} */
	public Vector2d sub(Vec2fBase v) { this.x -= v.getX(); this.y -= v.getY(); return this; }
	
	/** {@inheritDoc} */
	public Vector2d sub(Vec2dBase v) { this.x -= v.getX(); this.y -= v.getY(); return this; }
	
	/** {@inheritDoc} */
	public Vector2d sub(float scalar) { this.x -= scalar; this.y -= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector2d sub(double scalar) { this.x -= scalar; this.y -= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector2d sub(float x, float y) { this.x -= x; this.y -= y; return this; }
	
	/** {@inheritDoc} */
	public Vector2d sub(double x, double y) { this.x -= x; this.y -= y; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector2d mul(Vec2fBase v) { this.x *= v.getX(); this.y *= v.getY(); return this; }
	
	/** {@inheritDoc} */
	public Vector2d mul(Vec2dBase v) { this.x *= v.getX(); this.y *= v.getY(); return this; }
	
	/** {@inheritDoc} */
	public Vector2d mul(float scalar) { this.x *= scalar; this.y *= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector2d mul(double scalar) { this.x *= scalar; this.y *= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector2d mul(float x, float y) { this.x *= x; this.y *= y; return this; }
	
	/** {@inheritDoc} */
	public Vector2d mul(double x, double y) { this.x *= x; this.y *= y; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector2d div(Vec2fBase v) { this.x /= v.getX(); this.y /= v.getY(); return this; }
	
	/** {@inheritDoc} */
	public Vector2d div(Vec2dBase v) { this.x /= v.getX(); this.y /= v.getY(); return this; }
	
	/** {@inheritDoc} */
	public Vector2d div(float scalar) { this.x /= scalar; this.y /= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector2d div(double scalar) { this.x /= scalar; this.y /= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector2d div(float x, float y) { this.x /= x; this.y /= y; return this; }
	
	/** {@inheritDoc} */
	public Vector2d div(double x, double y) { this.x /= x; this.y /= y; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector2d invertFrom(Vec2fBase v) { this.x = v.getX() - this.x; this.y = v.getY() - this.y; return this; }
	
	/** {@inheritDoc} */
	public Vector2d invertFrom(Vec2dBase v) { this.x = (float)v.getX() - this.x; this.y = (float)v.getY() - this.y; return this; }
	
	/** {@inheritDoc} */
	public Vector2d invertFrom(float max) { this.x = max - this.x; this.y = max - this.y; return this; }
	
	/** {@inheritDoc} */
	public Vector2d invertFrom(double max) { this.x = (float)max - this.x; this.y = (float)max - this.y; return this; }
	
	/** {@inheritDoc} */
	public Vector2d invertFrom(float x, float y) { this.x = x - this.x; this.y = y - this.y; return this; }
	
	/** {@inheritDoc} */
	public Vector2d invertFrom(double x, double y) { this.x = (float)x - this.x; this.y = (float)y - this.y; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector2d negate() {  this.x = -this.x; this.y = -this.y; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector2d inverse() { this.x = 1 / this.x; this.y = 1 / this.y; return this; }
	
	
	
	
	
	/** {@inheritDoc} */
 	public Vector2d addN(Vec2fBase v) { return clone().add(v); }
 	
 	/** {@inheritDoc} */
 	public Vector2d addN(Vec2dBase v) { return clone().add(v); }

 	/** {@inheritDoc} */
 	public Vector2d addN(float scalar) { return clone().add(scalar); }
 	
 	/** {@inheritDoc} */
 	public Vector2d addN(double scalar) { return clone().add(scalar); }
 	
 	/** {@inheritDoc} */
 	public Vector2d addN(float x, float y) { return clone().add(x, y); }
 	
 	/** {@inheritDoc} */
 	public Vector2d addN(double x, double y) { return clone().add(x, y); }
	
 	
 	
 	/** {@inheritDoc} */
 	public Vector2d subN(Vec2fBase v) { return clone().sub(v); }
 	
 	/** {@inheritDoc} */
 	public Vector2d subN(Vec2dBase v) { return clone().sub(v); }
 	
 	/** {@inheritDoc} */
 	public Vector2d subN(float scalar) { return clone().sub(scalar); }
 	
 	/** {@inheritDoc} */
 	public Vector2d subN(double scalar) { return clone().sub(scalar); }	
 	
 	/** {@inheritDoc} */
 	public Vector2d subN(float x, float y) { return clone().sub(x, y); }
 	
 	/** {@inheritDoc} */
 	public Vector2d subN(double x, double y) { return clone().sub(x, y); }
	
 	
 	
 	/** {@inheritDoc} */
 	public Vector2d mulN(Vec2fBase v) { return clone().mul(v); }
 	
 	/** {@inheritDoc} */
 	public Vector2d mulN(Vec2dBase v) { return clone().mul(v); }
 	
 	/** {@inheritDoc} */
 	public Vector2d mulN(float scalar) { return clone().mul(scalar); }
 	
 	/** {@inheritDoc} */
 	public Vector2d mulN(double scalar) { return clone().mul(scalar); }	
 	
 	/** {@inheritDoc} */
 	public Vector2d mulN(float x, float y) { return clone().mul(x, y); }
 	
 	/** {@inheritDoc} */
 	public Vector2d mulN(double x, double y) { return clone().mul(x, y); }
	
 	
 	
 	/** {@inheritDoc} */
 	public Vector2d divN(Vec2fBase v) { return clone().div(v); }
 	
 	/** {@inheritDoc} */
 	public Vector2d divN(Vec2dBase v) { return clone().div(v); }
 	
 	/** {@inheritDoc} */
 	public Vector2d divN(float scalar) { return clone().div(scalar); }
 	
 	/** {@inheritDoc} */
 	public Vector2d divN(double scalar) { return clone().div(scalar); }
 	
 	/** {@inheritDoc} */
 	public Vector2d divN(float x, float y) { return clone().div(x, y); }
 	
 	/** {@inheritDoc} */
 	public Vector2d divN(double x, double y) { return clone().div(x, y); }
 	
 	
 	
 	/** {@inheritDoc} */
	public Vector2d invertFromN(Vec2fBase v) { return clone().invertFrom(v); }
	
	/** {@inheritDoc} */
	public Vector2d invertFromN(Vec2dBase v) { return clone().invertFrom(v); }
	
	/** {@inheritDoc} */
	public Vector2d invertFromN(float max) { return clone().invertFrom(max); }
	
	/** {@inheritDoc} */
	public Vector2d invertFromN(double max) { return clone().invertFrom(max); }
	
	/** {@inheritDoc} */
	public Vector2d invertFromN(float x, float y) { return clone().invertFrom(x, y); }
	
	/** {@inheritDoc} */
	public Vector2d invertFromN(double x, double y) { return clone().invertFrom(x, y); }

	
	
	/** {@inheritDoc} */
	public Vector2d negateN() { return clone().negate(); }
	
	
	
	/** {@inheritDoc} */
	public Vector2d inverseN() { return clone().inverse(); }
	
	/*
	##########################
	##                      ##
	##  VECTOR ARITHMETICS  ##
	##                      ##
	##########################
	 */

	/** {@inheritDoc} */
	public Vector2d normalize() { return this.x != 0  && this.y != 0 ? div(length()) : this; }
	
	/** {@inheritDoc} */
 	public Vector2d reflect(Vec2fBase normal)
	{
		double angle = dot(normal) * 2;
		
		this.x += -angle * normal.getX();
		this.y += -angle * normal.getY();
		
		return this;
	}
 	
 	/** {@inheritDoc} */
 	public Vector2d reflect(Vec2dBase normal)
 	{
		double angle = dot(normal) * 2;
		
		this.x += -angle * normal.getX();
		this.y += -angle * normal.getY();
		
		return this;
 	}
 	
 	
 	
 	/** {@inheritDoc} */
	public double length() { return Math.sqrt(squaredLength()); }
	
	/** {@inheritDoc} */
	public double squaredLength() { return this.x * this.x + this.y * this.y; }

	
	
	/** {@inheritDoc} */
	public Vector2d rotate(Vec2dBase axis, float angle)
	{
		return this;
	}

	/** {@inheritDoc} */
	public Vector2d rotate(Vec2fBase axis, double angle)
	{
		return this;
	}

	/** {@inheritDoc} */
	public Vector2d rotate(Vec2dBase axis, double angle)
	{
		return this;
	}
 	
	/** {@inheritDoc} */
 	public Vector2d rotate(Vec2fBase axis, float angle)
	{
		return this;
	}
 	
 	/** {@inheritDoc} */
 	public Vector2d rotate(Quaternion q)
	{
		return this;
	}
 	
 	
 	
 	/** {@inheritDoc} */
	public double dot(Vec2fBase v) { return (double) this.x * v.getX() + this.y * v.getY(); }
	
	/** {@inheritDoc} */
	public double dot(Vec2dBase v) { return (double) this.x * v.getX() + this.y * v.getY(); }

	
	
	/** {@inheritDoc} */
	public double angleRad(Vec2fBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
	
	/** {@inheritDoc} */
	public double angleRad(Vec2dBase v) { return Math.acos((dot(v)) / (length() * v.length())); }
	
	
	
	/** {@inheritDoc} */
	public double angleDeg(Vec2fBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }
	
	/** {@inheritDoc} */
	public double angleDeg(Vec2dBase v) { return angleRad(v) * Maths.RAD_TO_DEG; }
	
 	
	
	/** {@inheritDoc} */
	public Vector2d normalizeN() { return clone().normalize(); }
	
	
	
	/** {@inheritDoc} */
	public Vector2d reflectN(Vec2fBase normal) { return clone().reflect(normal); }
	
	/** {@inheritDoc} */
	public Vector2d reflectN(Vec2dBase normal) { return clone().reflect(normal); }

	
	
	/** {@inheritDoc} */
	public Vector2d rotateN(Vec2fBase axis, float angle) { return clone().rotate(axis, angle); }
	
	/** {@inheritDoc} */
	public Vector2d rotateN(Vec2dBase axis, float angle) { return clone().rotate(axis, angle); }
	
	/** {@inheritDoc} */
	public Vector2d rotateN(Vec2fBase axis, double angle) { return clone().rotate(axis, angle); }
	
	/** {@inheritDoc} */
	public Vector2d rotateN(Vec2dBase axis, double angle) { return clone().rotate(axis, angle); }
	
	/** {@inheritDoc} */
	public Vector2d rotateN(Quaternion q) { return clone().rotate(q); }
 	
	/*
	############################
	##                        ##
	##  VECTOR INTERPOLATION  ##
	##                        ##
	############################
	 */

	/** {@inheritDoc} */
 	public Vector2d lerp(Vec2fBase v, float f)
	{
		this.x = this.x + (v.getX() - this.x) * f;
		this.y = this.y + (v.getY() - this.y) * f;

		return this;
	}
 	
 	/** {@inheritDoc} */
	public Vector2d lerp(Vec2dBase v, float f)
	{
		this.x = this.x + ((float)v.getX() - this.x) * f;
		this.y = this.y + ((float)v.getY() - this.y) * f;

		return this;
	}
 	
	/** {@inheritDoc} */
	public Vector2d lerp(Vec2fBase v, double f)
	{
		this.x = this.x + (v.getX() - this.x) * (float)f;
		this.y = this.y + (v.getY() - this.y) * (float)f;

		return this;
	}

	/** {@inheritDoc} */
	public Vector2d lerp(Vec2dBase v, double f)
	{
		this.x = this.x + ((float)v.getX() - this.x) * (float)f;
		this.y = this.y + ((float)v.getY() - this.y) * (float)f;

		return this;
	}
	
	
	
	/** {@inheritDoc} */
 	public Vector2d slerp(Vec2fBase v, double f)
	{
		double angle = angleRad(v);
		
		double sinAngle = Math.sin(angle);

		double x_1 = ((1 - f)	* sinAngle) / (sinAngle * this.x);
		double x_2 = (f			* sinAngle) / (sinAngle * v.getX());
		float x = (float) (x_1 + x_2);
		
		double y_1 = ((1 - f)	* sinAngle) / (sinAngle * this.y);
		double y_2 = (f			* sinAngle) / (sinAngle * v.getY());
		float y = (float) (y_1 + y_2);
		
		this.x = x;
		this.y = y; 
		
		return this;
	}
	
 	/** {@inheritDoc} */
	public Vector2d slerp(Vec2dBase v, double f)
	{
		double angle = angleRad(v);
		
		double sinAngle = Math.sin(angle);

		double x_1 = ((1 - f)	* sinAngle) / (sinAngle * this.x);
		double x_2 = (f			* sinAngle) / (sinAngle * v.getX());
		float x = (float) (x_1 + x_2);
		
		double y_1 = ((1 - f)	* sinAngle) / (sinAngle * this.y);
		double y_2 = (f			* sinAngle) / (sinAngle * v.getY());
		float y = (float) (y_1 + y_2);
		
		this.x = x;
		this.y = y; 	
		return this;
	}
	
	/** {@inheritDoc} */
	public Vector2d slerp(Vec2fBase v, float f)
	{
		double angle = angleRad(v);
		
		double sinAngle = Math.sin(angle);

		double x_1 = ((1 - f)	* sinAngle) / (sinAngle * this.x);
		double x_2 = (f			* sinAngle) / (sinAngle * v.getX());
		float x = (float) (x_1 + x_2);
		
		double y_1 = ((1 - f)	* sinAngle) / (sinAngle * this.y);
		double y_2 = (f			* sinAngle) / (sinAngle * v.getY());
		float y = (float) (y_1 + y_2);
		
		this.x = x;
		this.y = y; 
		
		return this;
	}

	/** {@inheritDoc} */
	public Vector2d slerp(Vec2dBase v, float f)
	{
		double angle = angleRad(v);
		
		double sinAngle = Math.sin(angle);

		double x_1 = ((1 - f)	* sinAngle) / (sinAngle * this.x);
		double x_2 = (f			* sinAngle) / (sinAngle * v.getX());
		float x = (float) (x_1 + x_2);
		
		double y_1 = ((1 - f)	* sinAngle) / (sinAngle * this.y);
		double y_2 = (f			* sinAngle) / (sinAngle * v.getY());
		float y = (float) (y_1 + y_2);
		
		this.x = x;
		this.y = y; 
		
		return this;
	}
	
	
	
	/** {@inheritDoc} */
	public Vector2d lerpN(Vec2fBase v, float f) { return clone().lerp(v, f); }
	
	/** {@inheritDoc} */
	public Vector2d lerpN(Vec2dBase v, float f) { return clone().lerp(v, f); }
	
	/** {@inheritDoc} */
	public Vector2d lerpN(Vec2fBase v, double f) { return clone().lerp(v, f); }
	
	/** {@inheritDoc} */
	public Vector2d lerpN(Vec2dBase v, double f) { return clone().lerp(v, f); }

	
	
	/** {@inheritDoc} */
	public Vector2d slerpN(Vec2fBase v, float f) { return clone().slerp(v, f); }
	
	/** {@inheritDoc} */
	public Vector2d slerpN(Vec2dBase v, float f) { return clone().slerp(v, f); }
	
	/** {@inheritDoc} */
	public Vector2d slerpN(Vec2fBase v, double f) { return clone().slerp(v, f); }
	
	/** {@inheritDoc} */
	public Vector2d slerpN(Vec2dBase v, double f) { return clone().slerp(v, f); }
	
	/*
	#######################
	##                   ##
	##  OBJECT OVERRIDE  ##
	##                   ##
	#######################
	 */
	
	/** {@inheritDoc} */
	@Override
	public Vector2d clone() { return new Vector2d(this); }
	
	
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Vector2d)) return false;
		Vector2d v = (Vector2d)obj;
		
		if(v.x != this.x) return false;
		if(v.y != this.y) return false;
		
		return true;
	}
	
	
	
	/** {@inheritDoc} */
	@Override
	public String toString() { return "Vec2f(" + this.x + "f, " + this.y + "f, "; }

}

package cmn.utilslib.math.vector;


import cmn.utilslib.Pool;
import cmn.utilslib.math.Maths;
import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.tuple.api.Tup2dBase;
import cmn.utilslib.math.tuple.api.Tup2fBase;
import cmn.utilslib.math.vector.api.Vec2dBase;
import cmn.utilslib.math.vector.api.Vec2f;
import cmn.utilslib.math.vector.api.Vec2fBase;

/**
 * A mathematical 2-dimensional vector of type float
 * 
 * @author picatrix1899
 *
 */
public class Vector2f implements Vec2f
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
	
	public static final Vector2f TEMP = new Vector2f();
	public static final Vector2f TEMP0 = new Vector2f();
	public static final Vector2f TEMP1 = new Vector2f();
	public static final Vector2f TEMP2 = new Vector2f();
	public static final Vector2f TEMP3 = new Vector2f();
	public static final Vector2f TEMP4 = new Vector2f();
	public static final Vector2f TEMP5 = new Vector2f();
	public static final Vector2f TEMP6 = new Vector2f();
	public static final Vector2f TEMP7 = new Vector2f();
	public static final Vector2f TEMP8 = new Vector2f();
	public static final Vector2f TEMP9 = new Vector2f();
	
	/*
	##################
	##              ##
	##  ALLOCATION  ##
	##              ##
	##################
	 */
	
	private static Pool<Vector2f> pool = new Pool<Vector2f>(Vector2f.class);
	
	public static Vector2f getInstance() { return pool.get().setZero(); }
	public static Vector2f getInstance(Vec2fBase v) { return pool.get().set(v); }
	public static Vector2f getInstance(Vec2dBase v) { return pool.get().set(v); }
	public static Vector2f getInstance(Tup2fBase t) { return pool.get().set(t); }
	public static Vector2f getInstance(Tup2dBase t) { return pool.get().set(t); }
	public static Vector2f getInstance(float scalar) { return pool.get().set(scalar); }
	public static Vector2f getInstance(double scalar) { return pool.get().set(scalar); }
	public static Vector2f getInstance(float x, float y) { return pool.get().set(x, y); }
	public static Vector2f getInstance(double x, double y) { return pool.get().set(x, y); }
	
	public static void storeInstance(Vector2f v) { pool.store(v); }

	/*
	####################
	##                ##
	##  CONSTRUCTORS  ##
	##                ##
	####################
	 */
	
	public Vector2f() { this.x = 0; this.y = 0; }
	
	public Vector2f(float scalar) { this.x = scalar; this.y = scalar; }
	public Vector2f(double scalar) { this.x = (float)scalar; this.y = (float)scalar; }
	
	public Vector2f(float x, float y) { this.x = x; this.y = y; }
	public Vector2f(double x, double y) { this.x = (float)x; this.y = (float)y; }

	public Vector2f(Vec2fBase v) { this.x = v.getX(); this.y = v.getY(); }
	public Vector2f(Vec2dBase v) { this.x = (float)v.getX(); this.y = (float)v.getY(); }
	public Vector2f(Tup2fBase t) { this.x = t.get(0); this.y = t.get(1); }
	public Vector2f(Tup2dBase t) { this.x = (float)t.get(0); this.y = (float)t.get(1); }
	
	/*
	###############
	##           ##
	##  GETTERS  ##
	##           ##
	###############
	 */
	
	/** {@inheritDoc} */
	public float getX() { return this.x; }
	
	/** {@inheritDoc} */
	public float getY() { return this.y; }
	
	
	
	/** {@inheritDoc} */
	public float get(int index)
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
	public Vector2f setZero() { this.x = 0; this.y = 0; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector2f set(Vec2fBase v) { this.x = v.getX(); this.y = v.getY(); return this; }
	
	/** {@inheritDoc} */
	public Vector2f set(Vec2dBase v) { this.x = (float)v.getX(); this.y = (float)v.getY(); return this; }
	
	/** {@inheritDoc} */
	public Vector2f set(Tup2fBase t) { this.x = t.get(0); this.y = t.get(1); return this; }
	
	/** {@inheritDoc} */
	public Vector2f set(Tup2dBase t) { this.x = (float)t.get(0); this.y = (float)t.get(1); return this; }
	
	
	/** {@inheritDoc} */
	public Vector2f set(float scalar) { this.x = scalar; this.y = scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector2f set(double scalar) { this.x = (float)scalar; this.y = (float)scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector2f set(float x, float y) { this.x = x; this.y = y; return this; }
	
	/** {@inheritDoc} */
	public Vector2f set(double x, double y) { this.x = (float)x; this.y = (float)y; return this;  }
	
	
	
	/** {@inheritDoc} */
	public Vector2f setX(float x) { this.x = x; return this; }
	
	/** {@inheritDoc} */
	public Vector2f setX(double x) { this.x = (float)x; return this; }
	
	/** {@inheritDoc} */
	public Vector2f setY(float y) { this.y = y; return this; }
	
	/** {@inheritDoc} */
	public Vector2f setY(double y) { this.y = (float)y; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector2f set(int index, float value)
	{
		switch(index)
		{
			case 0: this.x = value; break;
			case 1: this.y = value; break;
		}
		return this;
	}
	
	/** {@inheritDoc} */
	public Vector2f set(int index, double value)
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
	public Vector2f add(Vec2fBase v) { this.x += v.getX(); this.y += v.getY(); return this; }
	
	/** {@inheritDoc} */
	public Vector2f add(Vec2dBase v) { this.x += v.getX(); this.y += v.getY(); return this; }
	
	/** {@inheritDoc} */
	public Vector2f add(float scalar) { this.x += scalar; this.y += scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector2f add(double scalar) { this.x += scalar; this.y += scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector2f add(float x, float y) { this.x += x; this.y += y; return this; }
	
	/** {@inheritDoc} */
	public Vector2f add(double x, double y) { this.x += x; this.y += y; return this; }

	
	
	/** {@inheritDoc} */
	public Vector2f sub(Vec2fBase v) { this.x -= v.getX(); this.y -= v.getY(); return this; }
	
	/** {@inheritDoc} */
	public Vector2f sub(Vec2dBase v) { this.x -= v.getX(); this.y -= v.getY(); return this; }
	
	/** {@inheritDoc} */
	public Vector2f sub(float scalar) { this.x -= scalar; this.y -= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector2f sub(double scalar) { this.x -= scalar; this.y -= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector2f sub(float x, float y) { this.x -= x; this.y -= y; return this; }
	
	/** {@inheritDoc} */
	public Vector2f sub(double x, double y) { this.x -= x; this.y -= y; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector2f mul(Vec2fBase v) { this.x *= v.getX(); this.y *= v.getY(); return this; }
	
	/** {@inheritDoc} */
	public Vector2f mul(Vec2dBase v) { this.x *= v.getX(); this.y *= v.getY(); return this; }
	
	/** {@inheritDoc} */
	public Vector2f mul(float scalar) { this.x *= scalar; this.y *= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector2f mul(double scalar) { this.x *= scalar; this.y *= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector2f mul(float x, float y) { this.x *= x; this.y *= y; return this; }
	
	/** {@inheritDoc} */
	public Vector2f mul(double x, double y) { this.x *= x; this.y *= y; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector2f div(Vec2fBase v) { this.x /= v.getX(); this.y /= v.getY(); return this; }
	
	/** {@inheritDoc} */
	public Vector2f div(Vec2dBase v) { this.x /= v.getX(); this.y /= v.getY(); return this; }
	
	/** {@inheritDoc} */
	public Vector2f div(float scalar) { this.x /= scalar; this.y /= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector2f div(double scalar) { this.x /= scalar; this.y /= scalar; return this; }
	
	/** {@inheritDoc} */
	public Vector2f div(float x, float y) { this.x /= x; this.y /= y; return this; }
	
	/** {@inheritDoc} */
	public Vector2f div(double x, double y) { this.x /= x; this.y /= y; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector2f invertFrom(Vec2fBase v) { this.x = v.getX() - this.x; this.y = v.getY() - this.y; return this; }
	
	/** {@inheritDoc} */
	public Vector2f invertFrom(Vec2dBase v) { this.x = (float)v.getX() - this.x; this.y = (float)v.getY() - this.y; return this; }
	
	/** {@inheritDoc} */
	public Vector2f invertFrom(float max) { this.x = max - this.x; this.y = max - this.y; return this; }
	
	/** {@inheritDoc} */
	public Vector2f invertFrom(double max) { this.x = (float)max - this.x; this.y = (float)max - this.y; return this; }
	
	/** {@inheritDoc} */
	public Vector2f invertFrom(float x, float y) { this.x = x - this.x; this.y = y - this.y; return this; }
	
	/** {@inheritDoc} */
	public Vector2f invertFrom(double x, double y) { this.x = (float)x - this.x; this.y = (float)y - this.y; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector2f negate() {  this.x = -this.x; this.y = -this.y; return this; }
	
	
	
	/** {@inheritDoc} */
	public Vector2f inverse() { this.x = 1 / this.x; this.y = 1 / this.y; return this; }
	
	
	
	
	
	/** {@inheritDoc} */
 	public Vector2f addN(Vec2fBase v) { return clone().add(v); }
 	
 	/** {@inheritDoc} */
 	public Vector2f addN(Vec2dBase v) { return clone().add(v); }

 	/** {@inheritDoc} */
 	public Vector2f addN(float scalar) { return clone().add(scalar); }
 	
 	/** {@inheritDoc} */
 	public Vector2f addN(double scalar) { return clone().add(scalar); }
 	
 	/** {@inheritDoc} */
 	public Vector2f addN(float x, float y) { return clone().add(x, y); }
 	
 	/** {@inheritDoc} */
 	public Vector2f addN(double x, double y) { return clone().add(x, y); }
	
 	
 	
 	/** {@inheritDoc} */
 	public Vector2f subN(Vec2fBase v) { return clone().sub(v); }
 	
 	/** {@inheritDoc} */
 	public Vector2f subN(Vec2dBase v) { return clone().sub(v); }
 	
 	/** {@inheritDoc} */
 	public Vector2f subN(float scalar) { return clone().sub(scalar); }
 	
 	/** {@inheritDoc} */
 	public Vector2f subN(double scalar) { return clone().sub(scalar); }	
 	
 	/** {@inheritDoc} */
 	public Vector2f subN(float x, float y) { return clone().sub(x, y); }
 	
 	/** {@inheritDoc} */
 	public Vector2f subN(double x, double y) { return clone().sub(x, y); }
	
 	
 	
 	/** {@inheritDoc} */
 	public Vector2f mulN(Vec2fBase v) { return clone().mul(v); }
 	
 	/** {@inheritDoc} */
 	public Vector2f mulN(Vec2dBase v) { return clone().mul(v); }
 	
 	/** {@inheritDoc} */
 	public Vector2f mulN(float scalar) { return clone().mul(scalar); }
 	
 	/** {@inheritDoc} */
 	public Vector2f mulN(double scalar) { return clone().mul(scalar); }	
 	
 	/** {@inheritDoc} */
 	public Vector2f mulN(float x, float y) { return clone().mul(x, y); }
 	
 	/** {@inheritDoc} */
 	public Vector2f mulN(double x, double y) { return clone().mul(x, y); }
	
 	
 	
 	/** {@inheritDoc} */
 	public Vector2f divN(Vec2fBase v) { return clone().div(v); }
 	
 	/** {@inheritDoc} */
 	public Vector2f divN(Vec2dBase v) { return clone().div(v); }
 	
 	/** {@inheritDoc} */
 	public Vector2f divN(float scalar) { return clone().div(scalar); }
 	
 	/** {@inheritDoc} */
 	public Vector2f divN(double scalar) { return clone().div(scalar); }
 	
 	/** {@inheritDoc} */
 	public Vector2f divN(float x, float y) { return clone().div(x, y); }
 	
 	/** {@inheritDoc} */
 	public Vector2f divN(double x, double y) { return clone().div(x, y); }
 	
 	
 	
 	/** {@inheritDoc} */
	public Vector2f invertFromN(Vec2fBase v) { return clone().invertFrom(v); }
	
	/** {@inheritDoc} */
	public Vector2f invertFromN(Vec2dBase v) { return clone().invertFrom(v); }
	
	/** {@inheritDoc} */
	public Vector2f invertFromN(float max) { return clone().invertFrom(max); }
	
	/** {@inheritDoc} */
	public Vector2f invertFromN(double max) { return clone().invertFrom(max); }
	
	/** {@inheritDoc} */
	public Vector2f invertFromN(float x, float y) { return clone().invertFrom(x, y); }
	
	/** {@inheritDoc} */
	public Vector2f invertFromN(double x, double y) { return clone().invertFrom(x, y); }

	
	
	/** {@inheritDoc} */
	public Vector2f negateN() { return clone().negate(); }
	
	
	
	/** {@inheritDoc} */
	public Vector2f inverseN() { return clone().inverse(); }
	
	/*
	##########################
	##                      ##
	##  VECTOR ARITHMETICS  ##
	##                      ##
	##########################
	 */

	/** {@inheritDoc} */
	public Vector2f normalize() { return this.x != 0  && this.y != 0 ? div(length()) : this; }
	
	/** {@inheritDoc} */
 	public Vector2f reflect(Vec2fBase normal)
	{
		double angle = dot(normal) * 2;
		
		this.x += -angle * normal.getX();
		this.y += -angle * normal.getY();
		
		return this;
	}
 	
 	/** {@inheritDoc} */
 	public Vector2f reflect(Vec2dBase normal)
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
	public Vector2f rotate(Vec2dBase axis, float angle)
	{
		return this;
	}

	/** {@inheritDoc} */
	public Vector2f rotate(Vec2fBase axis, double angle)
	{
		return this;
	}

	/** {@inheritDoc} */
	public Vector2f rotate(Vec2dBase axis, double angle)
	{
		return this;
	}
 	
	/** {@inheritDoc} */
 	public Vector2f rotate(Vec2fBase axis, float angle)
	{
		return this;
	}
 	
 	/** {@inheritDoc} */
 	public Vector2f rotate(Quaternion q)
	{
		return this;
	}
 	
 	
	public Vector2f rotate90CCW()
	{
		Vector2f t = Vector2f.TEMP.set(this);
		
		this.x = -t.y;
		this.y = t.x;
		
		return this;
	}
 	
	public Vector2f rotate90CW()
	{
		Vector2f t = Vector2f.TEMP.set(this);
		
		this.x = t.y;
		this.y = -t.x;
		
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
	public Vector2f normalizeN() { return clone().normalize(); }
	
	
	
	/** {@inheritDoc} */
	public Vector2f reflectN(Vec2fBase normal) { return clone().reflect(normal); }
	
	/** {@inheritDoc} */
	public Vector2f reflectN(Vec2dBase normal) { return clone().reflect(normal); }

	
	
	/** {@inheritDoc} */
	public Vector2f rotateN(Vec2fBase axis, float angle) { return clone().rotate(axis, angle); }
	
	/** {@inheritDoc} */
	public Vector2f rotateN(Vec2dBase axis, float angle) { return clone().rotate(axis, angle); }
	
	/** {@inheritDoc} */
	public Vector2f rotateN(Vec2fBase axis, double angle) { return clone().rotate(axis, angle); }
	
	/** {@inheritDoc} */
	public Vector2f rotateN(Vec2dBase axis, double angle) { return clone().rotate(axis, angle); }
	
	/** {@inheritDoc} */
	public Vector2f rotateN(Quaternion q) { return clone().rotate(q); }
 	
	/*
	############################
	##                        ##
	##  VECTOR INTERPOLATION  ##
	##                        ##
	############################
	 */

	/** {@inheritDoc} */
 	public Vector2f lerp(Vec2fBase v, float f)
	{
		this.x = this.x + (v.getX() - this.x) * f;
		this.y = this.y + (v.getY() - this.y) * f;

		return this;
	}
 	
 	/** {@inheritDoc} */
	public Vector2f lerp(Vec2dBase v, float f)
	{
		this.x = this.x + ((float)v.getX() - this.x) * f;
		this.y = this.y + ((float)v.getY() - this.y) * f;

		return this;
	}
 	
	/** {@inheritDoc} */
	public Vector2f lerp(Vec2fBase v, double f)
	{
		this.x = this.x + (v.getX() - this.x) * (float)f;
		this.y = this.y + (v.getY() - this.y) * (float)f;

		return this;
	}

	/** {@inheritDoc} */
	public Vector2f lerp(Vec2dBase v, double f)
	{
		this.x = this.x + ((float)v.getX() - this.x) * (float)f;
		this.y = this.y + ((float)v.getY() - this.y) * (float)f;

		return this;
	}
	
	
	
	/** {@inheritDoc} */
 	public Vector2f slerp(Vec2fBase v, double f)
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
	public Vector2f slerp(Vec2dBase v, double f)
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
	public Vector2f slerp(Vec2fBase v, float f)
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
	public Vector2f slerp(Vec2dBase v, float f)
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
	public Vector2f lerpN(Vec2fBase v, float f) { return clone().lerp(v, f); }
	
	/** {@inheritDoc} */
	public Vector2f lerpN(Vec2dBase v, float f) { return clone().lerp(v, f); }
	
	/** {@inheritDoc} */
	public Vector2f lerpN(Vec2fBase v, double f) { return clone().lerp(v, f); }
	
	/** {@inheritDoc} */
	public Vector2f lerpN(Vec2dBase v, double f) { return clone().lerp(v, f); }

	
	
	/** {@inheritDoc} */
	public Vector2f slerpN(Vec2fBase v, float f) { return clone().slerp(v, f); }
	
	/** {@inheritDoc} */
	public Vector2f slerpN(Vec2dBase v, float f) { return clone().slerp(v, f); }
	
	/** {@inheritDoc} */
	public Vector2f slerpN(Vec2fBase v, double f) { return clone().slerp(v, f); }
	
	/** {@inheritDoc} */
	public Vector2f slerpN(Vec2dBase v, double f) { return clone().slerp(v, f); }
	
	/*
	#######################
	##                   ##
	##  OBJECT OVERRIDE  ##
	##                   ##
	#######################
	 */
	
	/** {@inheritDoc} */
	@Override
	public Vector2f clone() { return new Vector2f(this); }
	
	
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Vector2f)) return false;
		Vector2f v = (Vector2f)obj;
		
		if(v.x != this.x) return false;
		if(v.y != this.y) return false;
		
		return true;
	}
	
	
	
	/** {@inheritDoc} */
	@Override
	public String toString() { return "Vec2f(" + this.x + "f, " + this.y + "f, "; }

}

package cmn.utilslib.vector;


import cmn.utilslib.vector.api.Vec2d;
import cmn.utilslib.vector.api.Vec2dBase;



/**
 * A mathematical 2 dimensional float vector
 * @author picatrix1899
 * @category Vector
 */
public class Vector2d implements Vec2d
{
	
	/*
	 * ============
	 * COMPONENTS
	 * ============
	 */
	/** The x component */
	public double x = 0.0d;
	/** The y component */
	public double y = 0.0d;
	
	
	
	/*
	 * ==============
	 * CONSTRUCTORS
	 * ==============
	 */
	/**
	 * Default constructor - Instance a new 2 dimensional float vector with both components set to zero 
	 */
	public Vector2d() { setZero(); }
	
	/**
	 * Clone constructor - Instance a new 2 dimensional float vector based on another 2 dimensional float vector {@literal <v>}}
	 * @param v : The 2 dimensional float vector to clone
	 */
	public Vector2d(Vec2dBase v) { set(v); }
	
	/**
	 * Constructor - Instance a new 2 dimensional float vector with both components set to {@literal <scalar>} 
	 * @param scalar : The initial value for both components
	 */
	public Vector2d(float scalar) { set(scalar); }
	/**
	 * Constructor - Instance a new 2 dimensional float vector with both components set to {@literal <scalar>}
	 * @param scalar : The initial value for both components
	 */
	public Vector2d(double scalar) { set(scalar); }

	/**
	 * Constructor - Instance a new 2 dimensional float vector with component x set to {@literal <x>} and component y set to {@literal <y>}
	 * @param x : The initial value for the x component
	 * @param y : The initial value for the y component
	 */
	public Vector2d(float x, float y) { set(x, y); }
	/**
	 * Constructor - Instance a new 2 dimensional float vector with component x set to {@literal <x>} and component y set to {@literal <y>}
	 * @param x : The initial value for the x component
	 * @param y : The initial value for the y component
	 */
	public Vector2d(double x, double y) { set(x, y); }

	
	
	
	/*
	 * =========
	 * GETTERS
	 * =========
	 */
	/** {@inheritDoc} */ @Override
	public double getX() { return this.x; }
	
	/** {@inheritDoc} */ @Override
	public double getY() { return this.y; }
	
	
	/*
	 * =========
	 * SETTERS
	 * =========
	 */
	/** {@inheritDoc} */ @Override
	public Vec2d setX(float x) { this.x = x; return this; }
	/** {@inheritDoc} */ @Override
	public Vec2d setX(double x) { this.x = (float)x; return this; }

	
	/** {@inheritDoc} */ @Override
	public Vec2d setY(float y) { this.y = y; return this; }
	/** {@inheritDoc} */ @Override
	public Vec2d setY(double y) { this.y = (float)y; return this; }	

	
	/*
	 * ==================
	 * OBJECT-OVERRIDES
	 * ==================
	 */
	/** {@inheritDoc} */ @Override
	public Vector2d clone() { return new Vector2d(this); }
	
	/** {@inheritDoc} */ @Override
	public String toString() { return "Vec2f(" + this.x + "f, " + this.y + "f)"; }
	
	/** {@inheritDoc} */ @Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Vector2d)) return false;
		Vector2d v = (Vector2d) obj;

		if(v.x != this.x) return false;
		if(v.y != this.y) return false;
		
		return true;
	}
	
	
	

}
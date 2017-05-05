
package cmn.utilslib.vector;


import cmn.utilslib.vector.api.Vector2d;
import cmn.utilslib.vector.api.Vector2dBase;



/**
 * A mathematical 2 dimensional float vector
 * @author picatrix1899
 * @category Vector
 */
public class Vec2d implements Vector2d
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
	public Vec2d() { setZero(); }
	
	/**
	 * Clone constructor - Instance a new 2 dimensional float vector based on another 2 dimensional float vector {@literal <v>}}
	 * @param v : The 2 dimensional float vector to clone
	 */
	public Vec2d(Vector2dBase v) { set(v); }
	
	/**
	 * Constructor - Instance a new 2 dimensional float vector with both components set to {@literal <scalar>} 
	 * @param scalar : The initial value for both components
	 */
	public Vec2d(float scalar) { set(scalar); }
	/**
	 * Constructor - Instance a new 2 dimensional float vector with both components set to {@literal <scalar>}
	 * @param scalar : The initial value for both components
	 */
	public Vec2d(double scalar) { set(scalar); }

	/**
	 * Constructor - Instance a new 2 dimensional float vector with component x set to {@literal <x>} and component y set to {@literal <y>}
	 * @param x : The initial value for the x component
	 * @param y : The initial value for the y component
	 */
	public Vec2d(float x, float y) { set(x, y); }
	/**
	 * Constructor - Instance a new 2 dimensional float vector with component x set to {@literal <x>} and component y set to {@literal <y>}
	 * @param x : The initial value for the x component
	 * @param y : The initial value for the y component
	 */
	public Vec2d(double x, double y) { set(x, y); }

	
	
	
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
	public Vec2d clone() { return new Vec2d(this); }
	
	/** {@inheritDoc} */ @Override
	public String toString() { return "Vec2f(" + this.x + "f, " + this.y + "f)"; }
	
	/** {@inheritDoc} */ @Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Vec2d)) return false;
		Vec2d v = (Vec2d) obj;

		if(v.x != this.x) return false;
		if(v.y != this.y) return false;
		
		return true;
	}
	
	
	

}
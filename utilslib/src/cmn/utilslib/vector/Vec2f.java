
package cmn.utilslib.vector;


import cmn.utilslib.interfaces.IStreamable;
import cmn.utilslib.vector.api.IVec2f;
import cmn.utilslib.vector.api.IVec2fBase;



/**
 * A mathematical 2 dimensional float vector
 * @author picatrix1899
 * @category Vector
 */
public class Vec2f implements IVec2f, IStreamable
{
	
	/*
	 * ============
	 * COMPONENTS
	 * ============
	 */
	/** The x component */
	public float x = 0.0f;
	/** The y component */
	public float y = 0.0f;
	
	
	
	/*
	 * ==============
	 * CONSTRUCTORS
	 * ==============
	 */
	/**
	 * Default constructor - Instance a new 2 dimensional float vector with both components set to zero 
	 */
	public Vec2f() { setZero(); }
	
	/**
	 * Clone constructor - Instance a new 2 dimensional float vector based on another 2 dimensional float vector {@literal <v>}}
	 * @param v : The 2 dimensional float vector to clone
	 */
	public Vec2f(IVec2fBase v) { set(v); }
	
	/**
	 * Constructor - Instance a new 2 dimensional float vector with both components set to {@literal <scalar>} 
	 * @param scalar : The initial value for both components
	 */
	public Vec2f(float scalar) { set(scalar); }
	/**
	 * Constructor - Instance a new 2 dimensional float vector with both components set to {@literal <scalar>}
	 * @param scalar : The initial value for both components
	 */
	public Vec2f(double scalar) { set(scalar); }

	/**
	 * Constructor - Instance a new 2 dimensional float vector with component x set to {@literal <x>} and component y set to {@literal <y>}
	 * @param x : The initial value for the x component
	 * @param y : The initial value for the y component
	 */
	public Vec2f(float x, float y) { set(x, y); }
	/**
	 * Constructor - Instance a new 2 dimensional float vector with component x set to {@literal <x>} and component y set to {@literal <y>}
	 * @param x : The initial value for the x component
	 * @param y : The initial value for the y component
	 */
	public Vec2f(double x, double y) { set(x, y); }

	
	
	
	/*
	 * =========
	 * GETTERS
	 * =========
	 */
	/** {@inheritDoc} */ @Override
	public float getX() { return this.x; }
	
	/** {@inheritDoc} */ @Override
	public float getY() { return this.y; }
	
	
	/*
	 * =========
	 * SETTERS
	 * =========
	 */
	/** {@inheritDoc} */ @Override
	public Vec2f setX(float x) { this.x = x; return this; }
	/** {@inheritDoc} */ @Override
	public Vec2f setX(double x) { this.x = (float)x; return this; }

	
	/** {@inheritDoc} */ @Override
	public Vec2f setY(float y) { this.y = y; return this; }
	/** {@inheritDoc} */ @Override
	public Vec2f setY(double y) { this.y = (float)y; return this; }	

	
	/*
	 * ==================
	 * OBJECT-OVERRIDES
	 * ==================
	 */
	/** {@inheritDoc} */ @Override
	public Vec2f clone() { return new Vec2f(this); }
	
	/** {@inheritDoc} */ @Override
	public String toString() { return "Vec2f(" + this.x + "f, " + this.y + "f)"; }
	
	/** {@inheritDoc} */ @Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Vec2f)) return false;
		Vec2f v = (Vec2f) obj;

		if(v.x != this.x) return false;
		if(v.y != this.y) return false;
		
		return true;
	}
	
	
	

}
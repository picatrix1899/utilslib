
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
	
	/**
	 * Sets all the components based on another 2 dimensional float vector {@literal <v>}
	 * @return
	 */
	public Vector2d set(Vec2dBase v) { return set(v.getX(), v.getY()); }
	/**
	 * Sets all components to zero
	 */
	public Vector2d setZero() { return set(0.0f); }
	/**
	 * Sets all the components to {@literal <scalar>}
	 */
	public Vector2d set(float scalar) { return set(scalar, scalar); }
	/**
	 * Sets all the components to {@literal <scalar>}
	 */
	public Vector2d set(double scalar) { return set(scalar, scalar); }
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 */
	public Vector2d set(float x, float y) { return setX(x).setY(y); }
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 */
	public Vector2d set(double x, double y) { return setX(x).setY(y); }
	
	/** {@inheritDoc} */ @Override
	public Vector2d setX(float x) { this.x = x; return this; }
	/** {@inheritDoc} */ @Override
	public Vector2d setX(double x) { this.x = (float)x; return this; }

	
	/** {@inheritDoc} */ @Override
	public Vector2d setY(float y) { this.y = y; return this; }
	/** {@inheritDoc} */ @Override
	public Vector2d setY(double y) { this.y = (float)y; return this; }	

	
	
	
	/** */
	public Vector2d add(Vec2dBase v) { return add(v.getX(), v.getY()); }
	/** */
	public Vector2d add(float scalar) { return add(scalar, scalar); }
	public Vector2d add(double scalar) { return add(scalar, scalar); }
	public Vector2d add(float x, float y) { return set(getX() + x, getY() + y); }
	public Vector2d add(double x, double y) { return set(getX() + x, getY() + y); }
	
	public Vector2d sub(Vec2dBase v) { return sub(v.getX(), v.getY()); }
	public Vector2d sub(float scalar) { return sub(scalar, scalar); }
	public Vector2d sub(double scalar) { return sub(scalar, scalar); }
	public Vector2d sub(float x, float y) { return set(getX() - x, getY() - y); }
	public Vector2d sub(double x, double y) { return set(getX() - x, getY() - y); }

	public Vector2d mul(Vec2dBase v) { return mul(v.getX(), v.getY()); }
	public Vector2d mul(float scalar) { return mul(scalar, scalar); }
	public Vector2d mul(double scalar) { return mul(scalar, scalar); }
	public Vector2d mul(float x, float y) { return set(getX() * x, getY() * y); }
	public Vector2d mul(double x, double y) { return set(getX() * x, getY() * y); }

	public Vector2d div(Vec2dBase v) { return div(v.getX(), v.getY()); }
	public Vector2d div(float scalar) { return div(scalar, scalar); }
	public Vector2d div(double scalar) { return div(scalar, scalar); }
	public Vector2d div(float x, float y) { return set(getX() / x, getY() / y); }
	public Vector2d div(double x, double y) { return set(getX() / x, getY() / y); }
	
	
	public Vector2d normalize() { return div(length()); }
	
	public Vector2d invert() { return mul(-1.0f); }
	
	public Vector2d addN(Vec2dBase v) { return addN(v.getX(), v.getY()); }
	public Vector2d addN(float scalar) { return addN(scalar, scalar); }
	public Vector2d addN(double scalar) { return addN(scalar, scalar); }
	public Vector2d addN(float x, float y) { return clone().add(x, y); }
	public Vector2d addN(double x, double y) { return clone().add(x, y); }
	
	public Vector2d subN(Vec2dBase v) { return subN(v.getX(), v.getY()); }
	public Vector2d subN(float scalar) { return subN(scalar, scalar); }
	public Vector2d subN(double scalar) { return subN(scalar, scalar); }
	public Vector2d subN(float x, float y) { return clone().sub(x, y); }
	public Vector2d subN(double x, double y) { return clone().sub(x, y); }
	
	public Vector2d mulN(Vec2dBase v) { return mulN(v.getX(), v.getY()); }
	public Vector2d mulN(float scalar) { return mulN(scalar, scalar); }
	public Vector2d mulN(double scalar) { return mulN(scalar, scalar); }
	public Vector2d mulN(float x, float y) { return clone().mul(x, y); }
	public Vector2d mulN(double x, double y) { return clone().mul(x, y); }
	
	public Vector2d divN(Vec2dBase v) { return divN(v.getX(), v.getY()); }
	public Vector2d divN(float scalar) { return divN(scalar, scalar); }
	public Vector2d divN(double scalar) { return divN(scalar, scalar); }
	public Vector2d divN(float x, float y) { return clone().div(x, y); }
	public Vector2d divN(double x, double y) { return clone().div(x, y); }
	
	public Vector2d inverted() { return clone().invert(); }
	
	public Vector2d normalized() { return clone().normalize(); }
	
	
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
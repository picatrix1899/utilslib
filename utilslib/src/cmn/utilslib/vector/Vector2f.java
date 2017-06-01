
package cmn.utilslib.vector;


import cmn.utilslib.vector.api.Vec2f;
import cmn.utilslib.vector.api.Vec2fBase;



/**
 * A mathematical 2 dimensional float vector
 * @author picatrix1899
 * @category Vector
 */
public class Vector2f implements Vec2f
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
	public Vector2f() { setZero(); }
	
	/**
	 * Clone constructor - Instance a new 2 dimensional float vector based on another 2 dimensional float vector {@literal <v>}}
	 * @param v : The 2 dimensional float vector to clone
	 */
	public Vector2f(Vec2fBase v) { set(v); }
	
	/**
	 * Constructor - Instance a new 2 dimensional float vector with both components set to {@literal <scalar>} 
	 * @param scalar : The initial value for both components
	 */
	public Vector2f(float scalar) { set(scalar); }
	/**
	 * Constructor - Instance a new 2 dimensional float vector with both components set to {@literal <scalar>}
	 * @param scalar : The initial value for both components
	 */
	public Vector2f(double scalar) { set(scalar); }

	/**
	 * Constructor - Instance a new 2 dimensional float vector with component x set to {@literal <x>} and component y set to {@literal <y>}
	 * @param x : The initial value for the x component
	 * @param y : The initial value for the y component
	 */
	public Vector2f(float x, float y) { set(x, y); }
	/**
	 * Constructor - Instance a new 2 dimensional float vector with component x set to {@literal <x>} and component y set to {@literal <y>}
	 * @param x : The initial value for the x component
	 * @param y : The initial value for the y component
	 */
	public Vector2f(double x, double y) { set(x, y); }

	
	
	
	/*
	 * =========
	 * GETTERS
	 * =========
	 */
	/** {@inheritDoc} */ @Override
	public float getX() { return this.x; }
	
	/** {@inheritDoc} */ @Override
	public float getY() { return this.y; }
	
	
	/** */
	public Vector2f add(Vec2fBase v) { return add(v.getX(), v.getY()); }
	/** */
	public Vector2f add(float scalar) { return add(scalar, scalar); }
	public Vector2f add(double scalar) { return add(scalar, scalar); }
	public Vector2f add(float x, float y) { return set(getX() + x, getY() + y); }
	public Vector2f add(double x, double y) { return set(getX() + x, getY() + y); }
	
	public Vector2f sub(Vec2fBase v) { return sub(v.getX(), v.getY()); }
	public Vector2f sub(float scalar) { return sub(scalar, scalar); }
	public Vector2f sub(double scalar) { return sub(scalar, scalar); }
	public Vector2f sub(float x, float y) { return set(getX() - x, getY() - y); }
	public Vector2f sub(double x, double y) { return set(getX() - x, getY() - y); }

	public Vector2f mul(Vec2fBase v) { return mul(v.getX(), v.getY()); }
	public Vector2f mul(float scalar) { return mul(scalar, scalar); }
	public Vector2f mul(double scalar) { return mul(scalar, scalar); }
	public Vector2f mul(float x, float y) { return set(getX() * x, getY() * y); }
	public Vector2f mul(double x, double y) { return set(getX() * x, getY() * y); }

	public Vector2f div(Vec2fBase v) { return div(v.getX(), v.getY()); }
	public Vector2f div(float scalar) { return div(scalar, scalar); }
	public Vector2f div(double scalar) { return div(scalar, scalar); }
	public Vector2f div(float x, float y) { return set(getX() / x, getY() / y); }
	public Vector2f div(double x, double y) { return set(getX() / x, getY() / y); }
	
	
	public Vector2f normalize() { return div(length()); }
	
	public Vector2f invert() { return mul(-1.0f); }
	
	public Vector2f addN(Vec2fBase v) { return addN(v.getX(), v.getY()); }
	public Vector2f addN(float scalar) { return addN(scalar, scalar); }
	public Vector2f addN(double scalar) { return addN(scalar, scalar); }
	public Vector2f addN(float x, float y) { return clone().add(x, y); }
	public Vector2f addN(double x, double y) { return clone().add(x, y); }
	
	public Vector2f subN(Vec2fBase v) { return subN(v.getX(), v.getY()); }
	public Vector2f subN(float scalar) { return subN(scalar, scalar); }
	public Vector2f subN(double scalar) { return subN(scalar, scalar); }
	public Vector2f subN(float x, float y) { return clone().sub(x, y); }
	public Vector2f subN(double x, double y) { return clone().sub(x, y); }
	
	public Vector2f mulN(Vec2fBase v) { return mulN(v.getX(), v.getY()); }
	public Vector2f mulN(float scalar) { return mulN(scalar, scalar); }
	public Vector2f mulN(double scalar) { return mulN(scalar, scalar); }
	public Vector2f mulN(float x, float y) { return clone().mul(x, y); }
	public Vector2f mulN(double x, double y) { return clone().mul(x, y); }
	
	public Vector2f divN(Vec2fBase v) { return divN(v.getX(), v.getY()); }
	public Vector2f divN(float scalar) { return divN(scalar, scalar); }
	public Vector2f divN(double scalar) { return divN(scalar, scalar); }
	public Vector2f divN(float x, float y) { return clone().div(x, y); }
	public Vector2f divN(double x, double y) { return clone().div(x, y); }
	
	public Vector2f inverted() { return clone().invert(); }
	
	public Vector2f normalized() { return clone().normalize(); }
	
	
	/*
	 * =========
	 * SETTERS
	 * =========
	 */
	/**
	 * Sets all the components based on another 2 dimensional float vector {@literal <v>}
	 * @return
	 */
	public Vector2f set(Vec2fBase v) { return set(v.getX(), v.getY()); }
	/**
	 * Sets all components to zero
	 */
	public Vector2f setZero() { return set(0.0f); }
	/**
	 * Sets all the components to {@literal <scalar>}
	 */
	public Vector2f set(float scalar) { return set(scalar, scalar); }
	/**
	 * Sets all the components to {@literal <scalar>}
	 */
	public Vector2f set(double scalar) { return set(scalar, scalar); }
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 */
	public Vector2f set(float x, float y) { return setX(x).setY(y); }
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 */
	public Vector2f set(double x, double y) { return setX(x).setY(y); }
	
	/** {@inheritDoc} */ @Override
	public Vector2f setX(float x) { this.x = x; return this; }
	/** {@inheritDoc} */ @Override
	public Vector2f setX(double x) { this.x = (float)x; return this; }

	
	/** {@inheritDoc} */ @Override
	public Vector2f setY(float y) { this.y = y; return this; }
	/** {@inheritDoc} */ @Override
	public Vector2f setY(double y) { this.y = (float)y; return this; }	

	
	/*
	 * ==================
	 * OBJECT-OVERRIDES
	 * ==================
	 */
	/** {@inheritDoc} */ @Override
	public Vector2f clone() { return new Vector2f(this); }
	
	/** {@inheritDoc} */ @Override
	public String toString() { return "Vec2f(" + this.x + "f, " + this.y + "f)"; }
	
	/** {@inheritDoc} */ @Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Vector2f)) return false;
		Vector2f v = (Vector2f) obj;

		if(v.x != this.x) return false;
		if(v.y != this.y) return false;
		
		return true;
	}
	
	
	

}
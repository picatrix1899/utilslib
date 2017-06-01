
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

	
	public Vector2d addN(Vec2dBase v) { return (Vector2d) super.addN(v); }
	public Vector2d addN(float scalar) { return (Vector2d) super.addN(scalar); }
	public Vector2d addN(double scalar) { return (Vector2d) super.addN(scalar); }
	public Vector2d addN(float x, float y) { return (Vector2d) super.addN(x, y); }
	public Vector2d addN(double x, double y) { return (Vector2d) super.addN(x, y); }
	
	public Vector2d subN(Vec2dBase v) { return (Vector2d) super.subN(v); }
	public Vector2d subN(float scalar) { return (Vector2d) super.subN(scalar); }
	public Vector2d subN(double scalar) { return (Vector2d) super.subN(scalar); }
	public Vector2d subN(float x, float y) { return (Vector2d)super.subN(x, y); }
	public Vector2d subN(double x, double y) { return (Vector2d) super.subN(x, y); }
	
	public Vector2d mulN(Vec2dBase v) { return (Vector2d) super.mulN(v); }
	public Vector2d mulN(float scalar) { return (Vector2d) super.mulN(scalar); }
	public Vector2d mulN(double scalar) { return (Vector2d) super.mulN(scalar); }
	public Vector2d mulN(float x, float y) { return (Vector2d) super.mulN(x, y); }
	public Vector2d mulN(double x, double y) { return (Vector2d) super.mulN(x, y); }
	
	public Vector2d divN(Vec2dBase v) { return (Vector2d) super.divN(v); }
	public Vector2d divN(float scalar) { return (Vector2d) super.divN(scalar); }
	public Vector2d divN(double scalar) { return (Vector2d) super.divN(scalar); }
	public Vector2d divN(float x, float y) { return (Vector2d) super.divN(x, y); }
	public Vector2d divN(double x, double y) { return (Vector2d) super.divN(x, y); }
	
	public Vector2d inverted() { return (Vector2d) super.inverted(); }
	
	public Vector2d normalized() { return (Vector2d) super.normalized(); }
	
	
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
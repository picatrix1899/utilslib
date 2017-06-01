package cmn.utilslib.vector.api;


public interface Vec2f extends Vec2fBase
{

	/** Sets the x component to {@literal <x>} */
	Vec2f setX(float x);
	/** Sets the x component to {@literal <x>} */
	Vec2f setX(double x);
	/** Sets the x component to {@literal <y>} */
	Vec2f setY(float y);
	/** Sets the x component to {@literal <y>} */
	Vec2f setY(double y);
	
	
	
	/**
	 * Sets all the components based on another 2 dimensional float vector {@literal <v>}
	 * @return
	 */
	default Vec2f set(Vec2fBase v) { return set(v.getX(), v.getY()); }
	/**
	 * Sets all components to zero
	 */
	default Vec2f setZero() { return set(0.0f); }
	/**
	 * Sets all the components to {@literal <scalar>}
	 */
	default Vec2f set(float scalar) { return set(scalar, scalar); }
	/**
	 * Sets all the components to {@literal <scalar>}
	 */
	default Vec2f set(double scalar) { return set(scalar, scalar); }
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 */
	default Vec2f set(float x, float y) { return setX(x).setY(y); }
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 */
	default Vec2f set(double x, double y) { return setX(x).setY(y); }

	 
	 
	/** */
	default Vec2f add(Vec2fBase v) { return add(v.getX(), v.getY()); }
	/** */
	default Vec2f add(float scalar) { return add(scalar, scalar); }
	default Vec2f add(double scalar) { return add(scalar, scalar); }
	default Vec2f add(float x, float y) { return set(getX() + x, getY() + y); }
	default Vec2f add(double x, double y) { return set(getX() + x, getY() + y); }
	
	default Vec2f sub(Vec2fBase v) { return sub(v.getX(), v.getY()); }
	default Vec2f sub(float scalar) { return sub(scalar, scalar); }
	default Vec2f sub(double scalar) { return sub(scalar, scalar); }
	default Vec2f sub(float x, float y) { return set(getX() - x, getY() - y); }
	default Vec2f sub(double x, double y) { return set(getX() - x, getY() - y); }

	default Vec2f mul(Vec2fBase v) { return mul(v.getX(), v.getY()); }
	default Vec2f mul(float scalar) { return mul(scalar, scalar); }
	default Vec2f mul(double scalar) { return mul(scalar, scalar); }
	default Vec2f mul(float x, float y) { return set(getX() * x, getY() * y); }
	default Vec2f mul(double x, double y) { return set(getX() * x, getY() * y); }

	default Vec2f div(Vec2fBase v) { return div(v.getX(), v.getY()); }
	default Vec2f div(float scalar) { return div(scalar, scalar); }
	default Vec2f div(double scalar) { return div(scalar, scalar); }
	default Vec2f div(float x, float y) { return set(getX() / x, getY() / y); }
	default Vec2f div(double x, double y) { return set(getX() / x, getY() / y); }

	 
	
	default Vec2f normalize() { return div(length()); }
	
	default Vec2f invert() { return mul(-1.0f); }
	
}

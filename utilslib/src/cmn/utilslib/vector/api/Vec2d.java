package cmn.utilslib.vector.api;

public interface Vec2d extends Vec2dBase
{
	
	/** Sets the x component to {@literal <x>} */
	Vec2d setX(float x);
	/** Sets the x component to {@literal <x>} */
	Vec2d setX(double x);
	/** Sets the x component to {@literal <y>} */
	Vec2d setY(float y);
	/** Sets the x component to {@literal <y>} */
	Vec2d setY(double y);
	
	
	
	/**
	 * Sets all the components based on another 2 dimensional float vector {@literal <v>}
	 * @return
	 */
	default Vec2d set(Vec2dBase v) { return set(v.getX(), v.getY()); }
	/**
	 * Sets all components to zero
	 */
	default Vec2d setZero() { return set(0.0f); }
	/**
	 * Sets all the components to {@literal <scalar>}
	 */
	default Vec2d set(float scalar) { return set(scalar, scalar); }
	/**
	 * Sets all the components to {@literal <scalar>}
	 */
	default Vec2d set(double scalar) { return set(scalar, scalar); }
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 */
	default Vec2d set(float x, float y) { return setX(x).setY(y); }
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 */
	default Vec2d set(double x, double y) { return setX(x).setY(y); }

	 
	 
	/** */
	default Vec2d add(Vec2dBase v) { return add(v.getX(), v.getY()); }
	/** */
	default Vec2d add(float scalar) { return add(scalar, scalar); }
	default Vec2d add(double scalar) { return add(scalar, scalar); }
	default Vec2d add(float x, float y) { return set(getX() + x, getY() + y); }
	default Vec2d add(double x, double y) { return set(getX() + x, getY() + y); }
	
	default Vec2d sub(Vec2dBase v) { return sub(v.getX(), v.getY()); }
	default Vec2d sub(float scalar) { return sub(scalar, scalar); }
	default Vec2d sub(double scalar) { return sub(scalar, scalar); }
	default Vec2d sub(float x, float y) { return set(getX() - x, getY() - y); }
	default Vec2d sub(double x, double y) { return set(getX() - x, getY() - y); }

	default Vec2d mul(Vec2dBase v) { return mul(v.getX(), v.getY()); }
	default Vec2d mul(float scalar) { return mul(scalar, scalar); }
	default Vec2d mul(double scalar) { return mul(scalar, scalar); }
	default Vec2d mul(float x, float y) { return set(getX() * x, getY() * y); }
	default Vec2d mul(double x, double y) { return set(getX() * x, getY() * y); }

	default Vec2d div(Vec2dBase v) { return div(v.getX(), v.getY()); }
	default Vec2d div(float scalar) { return div(scalar, scalar); }
	default Vec2d div(double scalar) { return div(scalar, scalar); }
	default Vec2d div(float x, float y) { return set(getX() / x, getY() / y); }
	default Vec2d div(double x, double y) { return set(getX() / x, getY() / y); }

	 
	
	default Vec2d normalize() { return div(length()); }
	
	default Vec2d invert() { return mul(-1.0f); }
	
}

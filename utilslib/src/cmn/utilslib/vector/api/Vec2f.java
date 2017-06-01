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
	Vec2f set(Vec2fBase v);
	/**
	 * Sets all components to zero
	 */
	Vec2f setZero();
	/**
	 * Sets all the components to {@literal <scalar>}
	 */
	Vec2f set(float scalar);
	/**
	 * Sets all the components to {@literal <scalar>}
	 */
	Vec2f set(double scalar);
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 */
	Vec2f set(float x, float y);
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 */
	Vec2f set(double x, double y);

	 
	 
	/** */
	Vec2f add(Vec2fBase v);
	/** */
	Vec2f add(float scalar);
	Vec2f add(double scalar);
	Vec2f add(float x, float y);
	Vec2f add(double x, double y);
	
	Vec2f sub(Vec2fBase v);
	Vec2f sub(float scalar);
	Vec2f sub(double scalar);
	Vec2f sub(float x, float y);
	Vec2f sub(double x, double y);

	Vec2f mul(Vec2fBase v);
	Vec2f mul(float scalar);
	Vec2f mul(double scalar);
	Vec2f mul(float x, float y);
	Vec2f mul(double x, double y);

	Vec2f div(Vec2fBase v);
	Vec2f div(float scalar);
	Vec2f div(double scalar);
	Vec2f div(float x, float y);
	Vec2f div(double x, double y);

	 
	
	Vec2f normalize();
	
	Vec2f invert();
	
}

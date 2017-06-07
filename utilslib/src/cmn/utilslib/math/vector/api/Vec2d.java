package cmn.utilslib.math.vector.api;

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
	Vec2d set(Vec2dBase v);
	/**
	 * Sets all components to zero
	 */
	Vec2d setZero();
	/**
	 * Sets all the components to {@literal <scalar>}
	 */
	Vec2d set(float scalar); 
	/**
	 * Sets all the components to {@literal <scalar>}
	 */
	Vec2d set(double scalar); 
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 */
	Vec2d set(float x, float y); 
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 */
	Vec2d set(double x, double y); 

	 
	 
	/** */
	Vec2d add(Vec2dBase v);
	/** */
	Vec2d add(float scalar);
	Vec2d add(double scalar);
	Vec2d add(float x, float y);
	Vec2d add(double x, double y);
	
	Vec2d sub(Vec2dBase v);
	Vec2d sub(float scalar);
	Vec2d sub(double scalar);
	Vec2d sub(float x, float y);
	Vec2d sub(double x, double y);

	Vec2d mul(Vec2dBase v);
	Vec2d mul(float scalar); 
	Vec2d mul(double scalar);
	Vec2d mul(float x, float y);
	Vec2d mul(double x, double y); 

	Vec2d div(Vec2dBase v); 
	Vec2d div(float scalar); 
	Vec2d div(double scalar);
	Vec2d div(float x, float y); 
	Vec2d div(double x, double y);

	 
	
	Vec2d normalize();
	
	Vec2d invert();
	
}

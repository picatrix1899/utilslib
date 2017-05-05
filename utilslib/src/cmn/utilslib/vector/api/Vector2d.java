package cmn.utilslib.vector.api;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import cmn.utilslib.interfaces.Streamable;

public interface Vector2d extends Vector2dBase, Streamable.Writeable
{
	/** Sets the x component to {@literal <x>} */
	Vector2d setX(float x);
	/** Sets the x component to {@literal <x>} */
	Vector2d setX(double x);
	/** Sets the x component to {@literal <y>} */
	Vector2d setY(float y);
	/** Sets the x component to {@literal <y>} */
	Vector2d setY(double y);
	
	
	
	/**
	 * Sets all the components based on another 2 dimensional float vector {@literal <v>}
	 * @return
	 */
	default Vector2d set(Vector2dBase v) { return set(v.getX(), v.getY()); }
	/**
	 * Sets all components to zero
	 */
	default Vector2d setZero() { return set(0.0f); }
	/**
	 * Sets all the components to {@literal <scalar>}
	 */
	default Vector2d set(float scalar) { return set(scalar, scalar); }
	/**
	 * Sets all the components to {@literal <scalar>}
	 */
	default Vector2d set(double scalar) { return set(scalar, scalar); }
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 */
	default Vector2d set(float x, float y) { return setX(x).setY(y); }
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 */
	default Vector2d set(double x, double y) { return setX(x).setY(y); }

	 
	 
	/** */
	default Vector2d add(Vector2dBase v) { return add(v.getX(), v.getY()); }
	/** */
	default Vector2d add(float scalar) { return add(scalar, scalar); }
	default Vector2d add(double scalar) { return add(scalar, scalar); }
	default Vector2d add(float x, float y) { return set(getX() + x, getY() + y); }
	default Vector2d add(double x, double y) { return set(getX() + x, getY() + y); }
	
	default Vector2d sub(Vector2dBase v) { return sub(v.getX(), v.getY()); }
	default Vector2d sub(float scalar) { return sub(scalar, scalar); }
	default Vector2d sub(double scalar) { return sub(scalar, scalar); }
	default Vector2d sub(float x, float y) { return set(getX() - x, getY() - y); }
	default Vector2d sub(double x, double y) { return set(getX() - x, getY() - y); }

	default Vector2d mul(Vector2dBase v) { return mul(v.getX(), v.getY()); }
	default Vector2d mul(float scalar) { return mul(scalar, scalar); }
	default Vector2d mul(double scalar) { return mul(scalar, scalar); }
	default Vector2d mul(float x, float y) { return set(getX() * x, getY() * y); }
	default Vector2d mul(double x, double y) { return set(getX() * x, getY() * y); }

	default Vector2d div(Vector2dBase v) { return div(v.getX(), v.getY()); }
	default Vector2d div(float scalar) { return div(scalar, scalar); }
	default Vector2d div(double scalar) { return div(scalar, scalar); }
	default Vector2d div(float x, float y) { return set(getX() / x, getY() / y); }
	default Vector2d div(double x, double y) { return set(getX() / x, getY() / y); }

	 
	default Vector2d normalize() { return div(length()); }
	
	default Vector2d invert() { return mul(-1.0f); }
	
	default Vector2d abs(boolean x, boolean y) { return set(x ? Math.abs(getX()) : getX(), y ? Math.abs(getY()) : getY()); }
	
	default Vector2d floor() { return set(Math.floor(getX()), Math.floor(getY())); }
	default Vector2d ceil() { return set(Math.ceil(getX()), Math.ceil(getY())); }
	default Vector2d round() { return set(Math.round(getX()), Math.round(getY())); }
	
	 
	
	/** {@inheritDoc} */ @Override
	default void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		setX(dis.readDouble());
		setY(dis.readDouble());
	}
}

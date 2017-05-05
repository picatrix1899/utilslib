package cmn.utilslib.vector.api;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import cmn.utilslib.interfaces.Streamable;

public interface Vector2f extends Vector2fBase, Streamable.Writeable
{

	/** Sets the x component to {@literal <x>} */
	Vector2f setX(float x);
	/** Sets the x component to {@literal <x>} */
	Vector2f setX(double x);
	/** Sets the x component to {@literal <y>} */
	Vector2f setY(float y);
	/** Sets the x component to {@literal <y>} */
	Vector2f setY(double y);
	
	
	
	/**
	 * Sets all the components based on another 2 dimensional float vector {@literal <v>}
	 * @return
	 */
	default Vector2f set(Vector2fBase v) { return set(v.getX(), v.getY()); }
	/**
	 * Sets all components to zero
	 */
	default Vector2f setZero() { return set(0.0f); }
	/**
	 * Sets all the components to {@literal <scalar>}
	 */
	default Vector2f set(float scalar) { return set(scalar, scalar); }
	/**
	 * Sets all the components to {@literal <scalar>}
	 */
	default Vector2f set(double scalar) { return set(scalar, scalar); }
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 */
	default Vector2f set(float x, float y) { return setX(x).setY(y); }
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 */
	default Vector2f set(double x, double y) { return setX(x).setY(y); }

	 
	 
	/** */
	default Vector2f add(Vector2fBase v) { return add(v.getX(), v.getY()); }
	/** */
	default Vector2f add(float scalar) { return add(scalar, scalar); }
	default Vector2f add(double scalar) { return add(scalar, scalar); }
	default Vector2f add(float x, float y) { return set(getX() + x, getY() + y); }
	default Vector2f add(double x, double y) { return set(getX() + x, getY() + y); }
	
	default Vector2f sub(Vector2fBase v) { return sub(v.getX(), v.getY()); }
	default Vector2f sub(float scalar) { return sub(scalar, scalar); }
	default Vector2f sub(double scalar) { return sub(scalar, scalar); }
	default Vector2f sub(float x, float y) { return set(getX() - x, getY() - y); }
	default Vector2f sub(double x, double y) { return set(getX() - x, getY() - y); }

	default Vector2f mul(Vector2fBase v) { return mul(v.getX(), v.getY()); }
	default Vector2f mul(float scalar) { return mul(scalar, scalar); }
	default Vector2f mul(double scalar) { return mul(scalar, scalar); }
	default Vector2f mul(float x, float y) { return set(getX() * x, getY() * y); }
	default Vector2f mul(double x, double y) { return set(getX() * x, getY() * y); }

	default Vector2f div(Vector2fBase v) { return div(v.getX(), v.getY()); }
	default Vector2f div(float scalar) { return div(scalar, scalar); }
	default Vector2f div(double scalar) { return div(scalar, scalar); }
	default Vector2f div(float x, float y) { return set(getX() / x, getY() / y); }
	default Vector2f div(double x, double y) { return set(getX() / x, getY() / y); }

	 
	default Vector2f normalize() { return div(length()); }
	
	default Vector2f invert() { return mul(-1.0f); }
	
	default Vector2f abs(boolean x, boolean y) { return set(x ? Math.abs(getX()) : getX(), y ? Math.abs(getY()) : getY()); }
	
	default Vector2f floor() { return set(Math.floor(getX()), Math.floor(getY())); }
	default Vector2f ceil() { return set(Math.ceil(getX()), Math.ceil(getY())); }
	default Vector2f round() { return set(Math.round(getX()), Math.round(getY())); }
	
	 
	
	/** {@inheritDoc} */ @Override
	default void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		setX(dis.readFloat());
		setY(dis.readFloat());
	}

}

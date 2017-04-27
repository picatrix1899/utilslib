package cmn.utilslib.vector.api;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import cmn.utilslib.interfaces.IStreamable;

public interface IVec2f extends IVec2fBase, IStreamable.Writeable
{

	/** Sets the x component to {@literal <x>} */
	IVec2f setX(float x);
	/** Sets the x component to {@literal <x>} */
	IVec2f setX(double x);
	/** Sets the x component to {@literal <y>} */
	IVec2f setY(float y);
	/** Sets the x component to {@literal <y>} */
	IVec2f setY(double y);
	
	
	
	/**
	 * Sets all the components based on another 2 dimensional float vector {@literal <v>}
	 * @return
	 */
	default IVec2f set(IVec2fBase v) { return set(v.getX(), v.getY()); }
	/**
	 * Sets all components to zero
	 */
	default IVec2f setZero() { return set(0.0f); }
	/**
	 * Sets all the components to {@literal <scalar>}
	 */
	default IVec2f set(float scalar) { return set(scalar, scalar); }
	/**
	 * Sets all the components to {@literal <scalar>}
	 */
	default IVec2f set(double scalar) { return set(scalar, scalar); }
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 */
	default IVec2f set(float x, float y) { return setX(x).setY(y); }
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 */
	default IVec2f set(double x, double y) { return setX(x).setY(y); }

	 
	 
	/** */
	default IVec2f add(IVec2fBase v) { return add(v.getX(), v.getY()); }
	/** */
	default IVec2f add(float scalar) { return add(scalar, scalar); }
	default IVec2f add(double scalar) { return add(scalar, scalar); }
	default IVec2f add(float x, float y) { return set(getX() + x, getY() + y); }
	default IVec2f add(double x, double y) { return set(getX() + x, getY() + y); }
	
	default IVec2f sub(IVec2fBase v) { return sub(v.getX(), v.getY()); }
	default IVec2f sub(float scalar) { return sub(scalar, scalar); }
	default IVec2f sub(double scalar) { return sub(scalar, scalar); }
	default IVec2f sub(float x, float y) { return set(getX() - x, getY() - y); }
	default IVec2f sub(double x, double y) { return set(getX() - x, getY() - y); }

	default IVec2f mul(IVec2fBase v) { return mul(v.getX(), v.getY()); }
	default IVec2f mul(float scalar) { return mul(scalar, scalar); }
	default IVec2f mul(double scalar) { return mul(scalar, scalar); }
	default IVec2f mul(float x, float y) { return set(getX() * x, getY() * y); }
	default IVec2f mul(double x, double y) { return set(getX() * x, getY() * y); }

	default IVec2f div(IVec2fBase v) { return div(v.getX(), v.getY()); }
	default IVec2f div(float scalar) { return div(scalar, scalar); }
	default IVec2f div(double scalar) { return div(scalar, scalar); }
	default IVec2f div(float x, float y) { return set(getX() / x, getY() / y); }
	default IVec2f div(double x, double y) { return set(getX() / x, getY() / y); }

	 
	default IVec2f normalize() { return div(length()); }
	
	default IVec2f invert() { return mul(-1.0f); }
	
	default IVec2f abs(boolean x, boolean y) { return set(x ? Math.abs(getX()) : getX(), y ? Math.abs(getY()) : getY()); }
	
	default IVec2f floor() { return set(Math.floor(getX()), Math.floor(getY())); }
	default IVec2f ceil() { return set(Math.ceil(getX()), Math.ceil(getY())); }
	default IVec2f round() { return set(Math.round(getX()), Math.round(getY())); }
	
	 
	
	/** {@inheritDoc} */ @Override
	default void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		setX(dis.readFloat());
		setY(dis.readFloat());
	}

}

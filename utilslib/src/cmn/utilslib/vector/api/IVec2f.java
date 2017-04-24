package cmn.utilslib.vector.api;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import cmn.utilslib.interfaces.IStreamable;

@SuppressWarnings("unchecked")
public interface IVec2f<T extends IVec2f<?>> extends IVec2fBase<T>, IStreamable.Writeable
{

	/*
	 * =========
	 * SETTERS
	 * =========
	 */
	/** Sets the x component to {@literal <x>} */
	T setX(float x);
	/** Sets the x component to {@literal <x>} */
	T setX(double x);

	/** Sets the x component to {@literal <y>} */
	T setY(float y);
	/** Sets the x component to {@literal <y>} */
	T setY(double y);
	
	/**
	 * Sets all the components based on another 2 dimensional float vector {@literal <v>}
	 * @return
	 */
	default T set(IVec2fBase<?> v) { return set(v.getX(), v.getY()); }
	
	/**
	 * Sets all components to zero
	 */
	default T setZero() { return set(0.0f); }
	
	/**
	 * Sets all the components to {@literal <scalar>}
	 */
	default T set(float scalar) { return set(scalar, scalar); }
	/**
	 * Sets all the components to {@literal <scalar>}
	 */
	default T set(double scalar) { return set(scalar, scalar); }

	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 */
	default T set(float x, float y) { return (T) setX(x).setY(y); }
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 */
	default T set(double x, double y) { return (T) setX(x).setY(y); }

	 
	 
	/*
	 * ==================
	 * BASIC-OPERATIONS
	 * ==================
	 */
	/** */
	default T add(IVec2fBase<?> v) { return add(v.getX(), v.getY()); }
	/** */
	default T add(float scalar) { return add(scalar, scalar); }
	default T add(double scalar) { return add(scalar, scalar); }
	default T add(float x, float y) { return set(getX() + x, getY() + y); }
	default T add(double x, double y) { return set(getX() + x, getY() + y); }
	
	default T sub(IVec2fBase<?> v) { return sub(v.getX(), v.getY()); }
	default T sub(float scalar) { return sub(scalar, scalar); }
	default T sub(double scalar) { return sub(scalar, scalar); }
	default T sub(float x, float y) { return set(getX() - x, getY() - y); }
	default T sub(double x, double y) { return set(getX() - x, getY() - y); }

	default T mul(IVec2fBase<?> v) { return mul(v.getX(), v.getY()); }
	default T mul(float scalar) { return mul(scalar, scalar); }
	default T mul(double scalar) { return mul(scalar, scalar); }
	default T mul(float x, float y) { return set(getX() * x, getY() * y); }
	default T mul(double x, double y) { return set(getX() * x, getY() * y); }

	default T div(IVec2fBase<?> v) { return div(v.getX(), v.getY()); }
	default T div(float scalar) { return div(scalar, scalar); }
	default T div(double scalar) { return div(scalar, scalar); }
	default T div(float x, float y) { return set(getX() / x, getY() / y); }
	default T div(double x, double y) { return set(getX() / x, getY() / y); }

	 
	T normalize();
	
	T invert();
	
	T abs(boolean x, boolean y);
	
	T floor();
	T ceil();
	T round();
	
	 
	/*
	 * ==========================
	 * STREAMABLE SERIALIZATION
	 * ==========================
	 */
	/** {@inheritDoc} */ @Override
	default void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		setX(dis.readFloat());
		setY(dis.readFloat());
	}

}

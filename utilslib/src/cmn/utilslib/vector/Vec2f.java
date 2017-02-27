
package cmn.utilslib.vector;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import java.util.Iterator;

import cmn.utilslib.essentials.Check;
import cmn.utilslib.essentials.Maths;

import cmn.utilslib.interfaces.IObjectable;
import cmn.utilslib.interfaces.IStreamable;



/**
 * A mathematical 2 dimensional float vector
 * @author picatrix1899
 * @category Vector
 */
public class Vec2f implements IStreamable, Serializable, IObjectable<Vec2f>, Iterable<Float>
{
	
	/*
	 * ==============
	 * AXIS-NORMALS
	 * ==============
	 */
	/** The x-axis as unit vector stored as a {@link PVec2f persistent 2 dimensional float vector} */
	public static final PVec2f aX = PVec2f.gen(1.0f, 0.0f);
	/** The y-axis as unit vector stored as a {@link PVec2f persistent 2 dimensional float vector} */
	public static final PVec2f aY = PVec2f.gen(0.0f, 1.0f);
	
	/** The inverted x-axis as unit vector stored as a {@link PVec2f persistent 2 dimensional float vector} */
	public static final PVec2f aNX = PVec2f.gen(-1.0f, 0.0f);
	/** The inverted y-axis as unit vector stored as a {@link PVec2f persistent 2 dimensional float vector} */
	public static final PVec2f aNY = PVec2f.gen(0.0f, -1.0f);
	
	/** The dimensions for a 2 dimensional float vector */
	public static final short DIMENSIONS = 2;	
	
	
	/** Kind of a version number. if the serialized data has a different UID it's not possible to deserialize it anymore because the interpretation has changed. */
	private static final long serialVersionUID = 1L;
	
	
	
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
	public Vec2f() { setZero(); }
	
	/**
	 * Clone constructor - Instance a new 2 dimensional float vector based on another 2 dimensional float vector {@literal <v>}}
	 * @param v : The 2 dimensional float vector to clone
	 */
	private Vec2f(Vec2f v) { set(v); }
	
	/**
	 * Constructor - Instance a new 2 dimensional float vector with both components set to {@literal <scalar>} 
	 * @param scalar : The initial value for both components
	 */
	public Vec2f(float scalar) { set(scalar); }
	/**
	 * Constructor - Instance a new 2 dimensional float vector with both components set to {@literal <scalar>}
	 * @param scalar : The initial value for both components
	 */
	public Vec2f(double scalar) { set(scalar); }
	/**
	 * Constructor - Instance a new 2 dimensional float vector with both components set to {@literal <scalar>}
	 * @param scalar : The initial value for both components
	 */
	public Vec2f(int scalar) { set(scalar); }
	
	/**
	 * Constructor - Instance a new 2 dimensional float vector with component x set to {@literal <x>} and component y set to {@literal <y>}
	 * @param x : The initial value for the x component
	 * @param y : The initial value for the y component
	 */
	public Vec2f(float x, float y) { set(x, y); }
	/**
	 * Constructor - Instance a new 2 dimensional float vector with component x set to {@literal <x>} and component y set to {@literal <y>}
	 * @param x : The initial value for the x component
	 * @param y : The initial value for the y component
	 */
	public Vec2f(double x, double y) { set(x, y); }
	/**
	 * Constructor - Instance a new 2 dimensional float vector with component x set to {@literal <x>} and component y set to {@literal <y>}
	 * @param x : The initial value for the x component
	 * @param y : The initial value for the y component
	 */
	public Vec2f(int x, int y) { set(x, y); }
	
	/**
	 * Constructor - Instance a new 2 dimensional float vector with component x set to {@literal <x>} and component y set to {@literal <y>}
	 * @param x : The initial value for the x component
	 * @param y : The initial value for the y component
	 */
	public Vec2f(float x, double y) { set(x, y); }
	/**
	 * constructor - Instance a new 2 dimensional float vector with component x set to {@literal <x>} and component y set to {@literal <y>}
	 * @param x : The initial value for the x component
	 * @param y : The initial value for the y component
	 */
	public Vec2f(float x, int y) { set(x, y); }
	
	/**
	 * Constructor - Instance a new 2 dimensional float vector with component x set to {@literal <x>} and component y set to {@literal <y>}
	 * @param x : The initial value for the x component
	 * @param y : The initial value for the y component
	 */
	public Vec2f(double x, float y) { set(x, y); }
	/**
	 * Constructor - Instance a new 2 dimensional float vector with component x set to {@literal <x>} and component y set to {@literal <y>}
	 * @param x : The initial value for the x component
	 * @param y : The initial value for the y component
	 */
	public Vec2f(double x, int y) { set(x, y); }
	
	/**
	 * Constructor - Instance a new 2 dimensional float vector with component x set to {@literal <x>} and component y set to {@literal <y>}
	 * @param x : The initial value for the x component
	 * @param y : The initial value for the y component
	 */
	public Vec2f(int x, float y) { set(x, y); }
	/**
	 * Constructor - Instance a new 2 dimensional float vector with component x set to {@literal <x>} and component y set to {@literal <y>}
	 * @param x : The initial value for the x component
	 * @param y : The initial value for the y component
	 */
	public Vec2f(int x, double y) { set(x, y); }
	
	
	
	/*
	 * =========
	 * SETTERS
	 * =========
	 */
	/**
	 * Sets all the components based on another 2 dimensional float vector {@literal <v>}
	 * @return
	 */
	public Vec2f set(Vec2f v) { return set(v.x, v.y); }
	
	
	
	/**
	 * Sets all components to zero
	 */
	public Vec2f setZero() { return set(0.0f); }	
	
	
	
	/**
	 * Sets all the components to {@literal <scalar>}
	 * */
	public Vec2f set(float scalar) { return set(scalar, scalar); }	
	/**
	 * Sets all the components to {@literal <scalar>}
	 * */
	public Vec2f set(double scalar) { return set(scalar, scalar); }	
	/**
	 * Sets all the components to {@literal <scalar>}
	 * */
	public Vec2f set(int scalar) { return set(scalar, scalar); }
	
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 * */
	public Vec2f set(float x, float y) { return setX(x).setY(y); }
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 * */
	public Vec2f set(double x, double y) { return setX(x).setY(y); }
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 * */
	public Vec2f set(int x, int y) { return setX(x).setY(y); }
	
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 * */
	public Vec2f set(float x, double y) { return setX(x).setY(y); }
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 * */
	public Vec2f set(float x, int y) { return setX(x).setY(y); }
	
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 * */
	public Vec2f set(double x, float y) { return setX(x).setY(y); }
	/** Sets the x and y value separated */
	public Vec2f set(double x, int y) { return setX(x).setY(y); }
	
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 * */
	public Vec2f set(int x, float y) { return setX(x).setY(y); }
	/**
	 * Sets the component x to {@literal <x>} and the component y to {@literal <y>}
	 * */
	public Vec2f set(int x, double y) { return setX(x).setY(y); }
	
	
	
	/** Sets the x component to {@literal <x>} */
	public Vec2f setX(float x) { this.x = x; return this; }
	/** Sets the x component to {@literal <x>} */
	public Vec2f setX(double x) { this.x = (float)x; return this; }
	/** Sets the x component to {@literal <x>} */
	public Vec2f setX(int x) { this.x = (float)x; return this; }
	
	/** Sets the x component to {@literal <y>} */
	public Vec2f setY(float y) { this.y = y; return this; }
	/** Sets the x component to {@literal <y>} */
	public Vec2f setY(double y) { this.y = (float)y; return this; }	
	/** Sets the x component to {@literal <y>} */
	public Vec2f setY(int y) { this.y = (float)y; return this; }
	
	
	
	/*
	 * ==================
	 * BASIC-OPERATIONS
	 * ==================
	 */
	/**
	 * add another 2 dimensional float vector {@literal <v>} to this one. the result is stored in the current instance
	 * @return The current instance
	 */
	public Vec2f add(Vec2f v) { return add(v.x, v.y); }
	
	/**
	 * add {@literal <scalar>} to both components. the result is stored in the current instance
	 * @return Tthe current instace
	 */
	public Vec2f add(float scalar) { return add(scalar, scalar); }
	public Vec2f add(double scalar) { return add(scalar, scalar); }
	
	public Vec2f add(float x, float y) { return set(this.x + x, this.y + y); }
	public Vec2f add(double x, double y) { return set(this.x + x, this.y + y); }
	
	public Vec2f add(float x, double y) { return set(this.x + x, this.y + y); }
	public Vec2f add(float x, int y) { return set(this.x + x, this.y + y); }
	
	public Vec2f add(double x, float y) { return set(this.x + x, this.y + y); }
	public Vec2f add(double x, int y) { return set(this.x + x, this.y + y); }
	
	public Vec2f add(int x, float y) { return set(this.x + x, this.y + y); }
	public Vec2f add(int x, double y) { return set(this.x + x, this.y + y); }
	
	
	
	public Vec2f sub(Vec2f v) { return sub(v.x, v.y); }
	
	public Vec2f sub(float scalar) { return sub(scalar, scalar); }
	public Vec2f sub(double scalar) { return sub(scalar, scalar); }	
	
	public Vec2f sub(float x, float y) { return set(this.x - x, this.y - y); }
	public Vec2f sub(double x, double y) { return set(this.x - x, this.y - y); }
	
	public Vec2f sub(float x, double y) { return set(this.x - x, this.y - y); }
	public Vec2f sub(float x, int y) { return set(this.x - x, this.y - y); }
	
	public Vec2f sub(double x, float y) { return set(this.x - x, this.y - y); }
	public Vec2f sub(double x, int y) { return set(this.x - x, this.y - y); }
	
	public Vec2f sub(int x, float y) { return set(this.x - x, this.y - y); }
	public Vec2f sub(int x, double y) { return set(this.x - x, this.y - y); }
	
	
	
	public Vec2f mul(Vec2f v) { return mul(v.x, v.y); }
	
	public Vec2f mul(float scalar) { return mul(scalar, scalar); }
	public Vec2f mul(double scalar) { return mul(scalar, scalar); }

	public Vec2f mul(float x, float y) { return set(this.x * x, this.y * y); }
	public Vec2f mul(double x, double y) { return set(this.x * x, this.y * y); }
	
	public Vec2f mul(float x, double y) { return set(this.x * x, this.y * y); }
	public Vec2f mul(float x, int y) { return set(this.x * x, this.y * y); }
	
	public Vec2f mul(double x, float y) { return set(this.x * x, this.y * y); }
	public Vec2f mul(double x, int y) { return set(this.x * x, this.y * y); }
	
	public Vec2f mul(int x, float y) { return set(this.x * x, this.y * y); }
	public Vec2f mul(int x, double y) { return set(this.x * x, this.y * y); }
	
	
	
	public Vec2f div(Vec2f v) { return div(v.x, v.y); }
	
	public Vec2f div(float scalar) { return div(scalar, scalar); }
	public Vec2f div(double scalar) { return div(scalar, scalar); }	
	
	public Vec2f div(float x, float y) { return set(this.x / x, this.y / y); }
	public Vec2f div(double x, double y) { return set(this.x / x, this.y / y); }
	
	public Vec2f div(float x, double y) { return set(this.x / x, this.y / y); }
	public Vec2f div(float x, int y) { return set(this.x / x, this.y / y); }
	
	public Vec2f div(double x, float y) { return set(this.x / x, this.y / y); }
	public Vec2f div(double x, int y) { return set(this.x / x, this.y / y); }
	
	public Vec2f div(int x, float y) { return set(this.x / x, this.y / y); }
	public Vec2f div(int x, double y) { return set(this.x / x, this.y / y); }
	
	
	
	public Vec2f addN(Vec2f v) { return addN(v.x, v.y); }
	
	public Vec2f addN(float scalar) { return addN(scalar, scalar); }
	public Vec2f addN(double scalar) { return addN(scalar, scalar); }	
	
	public Vec2f addN(float x, float y) { return clone().add(x, y); }
	public Vec2f addN(double x, double y) { return clone().add(x, y); }
	
	public Vec2f addN(float x, double y) { return clone().add(x, y); }
	public Vec2f addN(float x, int y) { return clone().add(x, y); }
	
	public Vec2f addN(double x, float y) { return clone().add(x, y); }
	public Vec2f addN(double x, int y) { return clone().add(x, y); }
	
	public Vec2f addN(int x, float y) { return clone().add(x, y); }
	public Vec2f addN(int x, double y) { return clone().add(x, y); }
	
	
	
	public Vec2f subN(Vec2f v) { return subN(v.x, v.y); }
	
	public Vec2f subN(float scalar) { return subN(scalar, scalar); }
	public Vec2f subN(double scalar) { return subN(scalar, scalar); }	
	
	public Vec2f subN(float x, float y) { return clone().sub(x, y); }
	public Vec2f subN(double x, double y) { return clone().sub(x, y); }
	
	public Vec2f subN(float x, double y) { return clone().sub(x, y); }
	public Vec2f subN(float x, int y) { return clone().sub(x, y); }
	
	public Vec2f subN(double x, float y) { return clone().sub(x, y); }
	public Vec2f subN(double x, int y) { return clone().sub(x, y); }
	
	public Vec2f subN(int x, float y) { return clone().sub(x, y); }
	public Vec2f subN(int x, double y) { return clone().sub(x, y); }
	
	
	
	public Vec2f mulN(Vec2f v) { return mulN(v.x, v.y); }
	
	public Vec2f mulN(float scalar) { return mulN(scalar, scalar); }
	public Vec2f mulN(double scalar) { return mulN(scalar, scalar); }	
	
	public Vec2f mulN(float x, float y) { return clone().mul(x, y); }
	public Vec2f mulN(double x, double y) { return clone().mul(x, y); }
	
	public Vec2f mulN(float x, double y) { return clone().mul(x, y); }
	public Vec2f mulN(float x, int y) { return clone().mul(x, y); }
	
	public Vec2f mulN(double x, float y) { return clone().mul(x, y); }
	public Vec2f mulN(double x, int y) { return clone().mul(x, y); }
	
	public Vec2f mulN(int x, float y) { return clone().mul(x, y); }
	public Vec2f mulN(int x, double y) { return clone().mul(x, y); }
	
	
	
	public Vec2f divN(Vec2f v) { return divN(v.x, v.y); }
	
	public Vec2f divN(float scalar) { return divN(scalar, scalar); }
	public Vec2f divN(double scalar) { return divN(scalar, scalar); }	
	
	public Vec2f divN(float x, float y) { return clone().div(x, y); }
	public Vec2f divN(double x, double y) { return clone().div(x, y); }
	
	public Vec2f divN(float x, double y) { return clone().div(x, y); }
	public Vec2f divN(float x, int y) { return clone().div(x, y); }
	
	public Vec2f divN(double x, float y) { return clone().div(x, y); }
	public Vec2f divN(double x, int y) { return clone().div(x, y); }
	
	public Vec2f divN(int x, float y) { return clone().div(x, y); }
	public Vec2f divN(int x, double y) { return clone().div(x, y); }
	
	
	
	/*
	 * ===================
	 * VECTOR-OPERATIONS
	 * ===================
	 */
	public float length() { return (float) Math.sqrt(squaredLength()); }
	
	public float squaredLength() { return this.x * this.x + this.y * this.y; }
	
	
	
	public Vec2f normalize() { return Check.notNull(this) ? div(length()) : this; }
	
	public Vec2f normalized() { return clone().normalize(); }
	
	
	
	public Vec2f invert() { return mul(-1.0f); }

	
	public Vec2f inverted() { return clone().invert(); }


	
	public float dot(Vec2f v) { return this.x * v.x + this.y * v.y; }
	
	
	
	public double angleRad(Vec2f v)
	{
		return Math.acos((dot(v)) / (length() * v.length()));
	}
	
	public double angleDeg(Vec2f v)
	{
		return angleRad(v) * Maths.RAD_TO_DEG;
	}
	
	
	
	public float max() { return Math.max(this.x, this.y); }
	public float min() { return Math.min(this.x, this.y); }
	
	
	public Vec2f abs(boolean x, boolean y) { return set(Math.abs(this.x), Math.abs(this.y)); }
	
	public Vec2f absN(boolean x, boolean y) { return clone().abs(x, y); }
	
	
	
	/*
	 * ==========
	 * ROUNDING
	 * ==========
	 */
	
	public Vec2f floor() { return set(Math.floor(this.x) , Math.floor(this.y)); }
	public Vec2f ceil() { return set(Math.ceil(this.x), Math.ceil(this.y)); }
	public Vec2f round() { return set(Math.round(this.x),Math.round(this.y)); }
	
	
	public Vec2f floorN() { return clone().floor(); }
	public Vec2f ceilN() { return clone().ceil(); }
	public Vec2f roundN() { return clone().round(); }
	
	
	
	/*
	 * ====================
	 * ORDINAL OPERATIONS
	 * ====================
	 */
	/** returns the dimensions of the vector */
	public int getDimensions() { return Vec2f.DIMENSIONS; }

	

	/*
	 * ==================
	 * OBJECT-OVERRIDES
	 * ==================
	 */
	/** {@inheritDoc} */
	@Override
	public Vec2f clone() { return new Vec2f(this); }
	
	/** {@inheritDoc} */
	@Override
	public String toString() { return "Vec2f(" + this.x + "f, " + this.y + "f)"; }
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Vec2f)) return false;
		Vec2f v = (Vec2f) obj;

		if(v.x != this.x) return false;
		if(v.y != this.y) return false;
		
		return true;
	}
	
	
	
	/*
	 * ==========================
	 * STREAMABLE SERIALIZATION
	 * ==========================
	 */
	/** {@inheritDoc} */
	@Override
	public void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		setX(dis.readFloat());
		setY(dis.readFloat());
	}
	
	/** {@inheritDoc} */
	@Override
	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeFloat(this.x);
		dos.writeFloat(this.y);
	}

	
	/*
	 * ============
	 * ITERATABLE
	 * ============
	 */
	/** */
	@Override
	public Iterator<Float> iterator()
	{
		return new Iterator<Float>()
		{

			private int index = 0;
			
			/**  */
			@Override
			public boolean hasNext() { return this.index < getDimensions(); }

			/** */
			@Override
			public Float next()
			{
				float out = 0;
				
				switch(this.index)
				{
					case 0: out = x;
					case 1: out = y;
					default: out = 0.0f;
				}
				
				index++;
				return out;
			}
			
		};
	}

}
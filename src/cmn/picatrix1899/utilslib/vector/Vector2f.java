
package cmn.picatrix1899.utilslib.vector;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import cmn.picatrix1899.utilslib.essentials.Maths;
import cmn.picatrix1899.utilslib.essentials.Validate.Check;
import cmn.picatrix1899.utilslib.interfaces.DataHolder;



/**
 * A mathematical 2-dimensional vector of type float
 * 
 * @author picatrix1899
 *
 */
public class Vector2f implements DataHolder, Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * ===============
	 * AXIS-NORMALS
	 * ===============
	 */
	public static final PersistentVector2f aX = PersistentVector2f.gen(1.0f, 0.0f);
	public static final PersistentVector2f aY = PersistentVector2f.gen(0.0f, 1.0f);
	
	public static final PersistentVector2f aNX = PersistentVector2f.gen(-1.0f, 0.0f);
	public static final PersistentVector2f aNY = PersistentVector2f.gen(0.0f, -1.0f);
	
	public static final short DIMENSIONS = 2;
	
	
	
	/*
	 * ====================
	 * COMPONENTS
	 * ====================
	 */
	public float x = 0.0f;
	public float y = 0.0f;
	
	
	/*
	 * ===================
	 * CONSTRUCTORS
	 * ===================
	 */
	public Vector2f() { setZero(); }
	
	private Vector2f(Vector2f v) { set(v); }
	
	public Vector2f(float scalar) { set(scalar); }
	
	public Vector2f(float x, float y) { set(x, y); }
	
	
	
	/*
	 * ======================
	 * SETTERS
	 * ======================
	 */
	public Vector2f set(Vector2f v) { return set(v.x, v.y); }
	
	public Vector2f setZero() { return set(0.0f); }	
	
	public Vector2f set(float scalar) { return set(scalar, scalar); }	
	public Vector2f set(double scalar) { return set(scalar, scalar); }		
	public Vector2f set(float x, float y) { return setX(x).setY(y); }
	public Vector2f set(double x, double y) { return setX(x).setY(y); }	
	public Vector2f setX(float x) { this.x = x; return this; }
	public Vector2f setX(double x) { this.x = (float)x; return this; }	
	public Vector2f setY(float y) { this.y = y; return this; }
	public Vector2f setY(double y) { this.y = (float)y; return this; }	

	/*
	 * ====================
	 * BASIC-OPERATIONS
	 * ====================
	 */
	public Vector2f add(Vector2f v) { return add(v.x, v.y); }
	public Vector2f add(float scalar) { return add(scalar, scalar); }
	public Vector2f add(double scalar) { return add(scalar, scalar); }
	public Vector2f add(float x, float y) { return set(this.x + x, this.y + y); }
	public Vector2f add(double x, double y) { return set(this.x + x, this.y + y); }
	
	public Vector2f sub(Vector2f v) { return sub(v.x, v.y); }
	public Vector2f sub(float scalar) { return sub(scalar, scalar); }
	public Vector2f sub(double scalar) { return sub(scalar, scalar); }	
	public Vector2f sub(float x, float y) { return set(this.x - x, this.y - y); }
	public Vector2f sub(double x, double y) { return set(this.x - x, this.y - y); }
	
	public Vector2f mul(Vector2f v) { return mul(v.x, v.y); }
	public Vector2f mul(float scalar) { return mul(scalar, scalar); }
	public Vector2f mul(double scalar) { return mul(scalar, scalar); }	
	public Vector2f mul(float x, float y) { return set(this.x * x, this.y * y); }
	public Vector2f mul(double x, double y) { return set(this.x * x, this.y * y); }
	
	public Vector2f div(Vector2f v) { return div(v.x, v.y); }
	public Vector2f div(float scalar) { return div(scalar, scalar); }
	public Vector2f div(double scalar) { return div(scalar, scalar); }	
	public Vector2f div(float x, float y) { return set(this.x / x, this.y / y); }
	public Vector2f div(double x, double y) { return set(this.x / x, this.y / y); }
	
	
	public Vector2f addN(Vector2f v) { return addN(v.x, v.y); }
	public Vector2f addN(float scalar) { return addN(scalar, scalar); }
	public Vector2f addN(double scalar) { return addN(scalar, scalar); }	
	public Vector2f addN(float x, float y) { return clone().add(x, y); }
	public Vector2f addN(double x, double y) { return clone().add(x, y); }
	
	public Vector2f subN(Vector2f v) { return subN(v.x, v.y); }
	public Vector2f subN(float scalar) { return subN(scalar, scalar); }
	public Vector2f subN(double scalar) { return subN(scalar, scalar); }	
	public Vector2f subN(float x, float y) { return clone().sub(x, y); }
	public Vector2f subN(double x, double y) { return clone().sub(x, y); }
	
	public Vector2f mulN(Vector2f v) { return mulN(v.x, v.y); }
	public Vector2f mulN(float scalar) { return mulN(scalar, scalar); }
	public Vector2f mulN(double scalar) { return mulN(scalar, scalar); }	
	public Vector2f mulN(float x, float y) { return clone().mul(x, y); }
	public Vector2f mulN(double x, double y) { return clone().mul(x, y); }
	
	public Vector2f divN(Vector2f v) { return divN(v.x, v.y); }
	public Vector2f divN(float scalar) { return divN(scalar, scalar); }
	public Vector2f divN(double scalar) { return divN(scalar, scalar); }	
	public Vector2f divN(float x, float y) { return clone().div(x, y); }
	public Vector2f divN(double x, double y) { return clone().div(x, y); }
	
	
	
	/*
	 * =====================
	 * VECTOR-OPERATIONS
	 * =====================
	 */
	public float length() { return (float) Math.sqrt(squaredLength()); }
	
	public float squaredLength() { return this.x * this.x + this.y * this.y; }
	
	
	
	public Vector2f normalize() { return Check.notNull(this) ? div(length()) : this; }
	
	public Vector2f normalized() { return clone().normalize(); }
	
	
	
	public Vector2f invert() { return mul(-1.0f); }

	
	public Vector2f inverted() { return clone().invert(); }


	
	public float dot(Vector2f v) { return this.x * v.x + this.y * v.y; }
	
	
	
	public double angleRad(Vector2f v)
	{
		return Math.acos((dot(v)) / (length() * v.length()));
	}
	
	public double angleDeg(Vector2f v)
	{
		return angleRad(v) * Maths.RAD_TO_DEG;
	}
	
	
	
	public float max() { return Math.max(this.x, this.y); }
	public float min() { return Math.min(this.x, this.y); }
	
	
	public Vector2f abs(boolean x, boolean y) { return set(Math.abs(this.x), Math.abs(this.y)); }
	
	public Vector2f absN(boolean x, boolean y) { return clone().abs(x, y); }
	
	
	/*
	 * =========================
	 * ROUNDING
	 * =========================
	 */
	
	public Vector2f floor() { return set(Math.floor(this.x) , Math.floor(this.y)); }
	public Vector2f ceil() { return set(Math.ceil(this.x), Math.ceil(this.y)); }
	public Vector2f round() { return set(Math.round(this.x),Math.round(this.y)); }
	
	
	public Vector2f floorN() { return clone().floor(); }
	public Vector2f ceilN() { return clone().ceil(); }
	public Vector2f roundN() { return clone().round(); }
	
	
	/*
	 * ==================
	 * ORDINAL OPERATIONS
	 * ==================
	 */
	public int getDimensions() { return Vector2f.DIMENSIONS; }

	

	/*
	 * ===========================
	 * OBJECT-OVERRIDES
	 * ===========================
	 */
	public Vector2f clone() { return new Vector2f(this); }
	
	public String toString() { return "vector2f(" + this.x + "f, " + this.y + "f)"; }
	
	public boolean equals(Object obj)
	{
		if(obj instanceof Vector2f)
		{
			Vector2f v = (Vector2f) obj;
			return this.x == v.x && this.y == v.y;
		}
		return false;
	}
	
	/*
	 * ===========================
	 * DATA-HOLDER SERIALIZATION
	 * ===========================
	 */
	public void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		this.x = dis.readFloat();
		this.y = dis.readFloat();
	}
	

	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeFloat(this.x);
		dos.writeFloat(this.y);
	}
	
}
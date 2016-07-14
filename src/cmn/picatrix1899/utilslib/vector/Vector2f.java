
package cmn.picatrix1899.utilslib.vector;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.sun.istack.internal.NotNull;

import cmn.picatrix1899.utilslib.essentials.Maths;
import cmn.picatrix1899.utilslib.essentials.Validate.Check;
import cmn.picatrix1899.utilslib.interfaces.DataHolder;



/**
 * A mathematical 2-dimensional vector of type float
 * 
 * @author picatrix1899
 *
 */
public class Vector2f implements DataHolder
{
	
	/*
	 * ===============
	 * AXIS-NORMALS
	 * ===============
	 */
	public static final Vector2f aX = new Vector2f(1.0f, 0.0f);
	public static final Vector2f aY = new Vector2f(0.0f, 1.0f);
	
	public static final Vector2f aNX = new Vector2f(-1.0f, 0.0f);
	public static final Vector2f aNY = new Vector2f(0.0f, -1.0f);
	
	
	
	/*
	 * ======================
	 * AXIS-INDEX/ORDINAL
	 * ======================
	 */
	public static final int X = 0;
	public static final int Y = 1;
	
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
	public Vector2f()
	{
		this(0.0f, 0.0f);
	}
	
	private Vector2f(Vector2f v)
	{
		this(v.getX(), v.getY());
	}
	
	public Vector2f(float x, float y)
	{
		set(x, y);
	}
	
	
	
	/*
	 * ======================
	 * SETTERS
	 * ======================
	 */
	public Vector2f set(Vector2f v) { return set(v.getX(), v.getY()); }
	
	public Vector2f set(float x, float y) { return setX(x).setY(y); }
	
	public Vector2f setZero() { return set(0.0f, 0.0f); }
	
	public Vector2f setX(float x) { this.x = x; return this; }
	
	public Vector2f setY(float y) { this.y = y; return this; }

	
	
	/*
	 * ================
	 * GETTERS
	 * ================
	 */
	public float getX() { return this.x; }
	
	public float getY() { return this.y; }
	
	
	
	/*
	 * =================
	 * STATIC BASIC-OPERATIONS
	 * =================
	 */
	public static Vector2f add(Vector2f v1, Vector2f v2) { return Vector2f.add(v1, v2.getX(), v2.getY()); }
	
	public static Vector2f add(Vector2f v1, float scalar) { return Vector2f.add(v1, scalar, scalar); }
	
	public static Vector2f add(Vector2f v1, float x, float y) { return v1.add(x, y); }
	
	public static Vector2f sub(Vector2f v1, Vector2f v2) { return Vector2f.sub(v1, v2.getX(), v2.getY()); }
	
	public static Vector2f sub(Vector2f v1, float scalar) { return Vector2f.sub(v1, scalar, scalar); }
	
	public static Vector2f sub(Vector2f v1, float x, float y) { return v1.sub(x, y); }
	
	public static Vector2f mul(Vector2f v1, Vector2f v2) { return Vector2f.mul(v1, v2.getX(), v2.getY()); }
	
	public static Vector2f mul(Vector2f v1, float scalar) { return Vector2f.mul(v1, scalar, scalar); }
	
	public static Vector2f mul(Vector2f v1, float x, float y) { return v1.mul(x, y); }
	
	public static Vector2f div(Vector2f v1, Vector2f v2) { return Vector2f.div(v1, v2.getX(), v2.getY()); }
	
	public static Vector2f div(Vector2f v1, float scalar) { return Vector2f.div(v1, scalar, scalar); }
	
	public static Vector2f div(Vector2f v1, float x, float y) { return v1.div(x, y); }
	
	public static Vector2f pow(Vector2f v1, Vector2f v2) { return Vector2f.pow(v1, v2.getX(), v2.getY()); }
	
	public static Vector2f pow(Vector2f v1, float scalar) { return Vector2f.pow(v1, scalar, scalar); }
	
	public static Vector2f pow(Vector2f v1, float x, float y) { return v1.pow(x, y); }
	
	
	
	public static Vector2f addN(Vector2f v1, Vector2f v2) { return Vector2f.addN(v1, v2.getX(), v2.getY()); }
	
	public static Vector2f addN(Vector2f v1, float scalar) { return Vector2f.addN(v1, scalar, scalar); }
	
	public static Vector2f addN(Vector2f v1, float x, float y) { return v1.addN(x, y); }
	
	public static Vector2f subN(Vector2f v1, Vector2f v2) { return Vector2f.subN(v1, v2.getX(), v2.getY()); }
	
	public static Vector2f subN(Vector2f v1, float scalar) { return Vector2f.subN(v1, scalar, scalar); }
	
	public static Vector2f subN(Vector2f v1, float x, float y) { return v1.subN(x, y); }
	
	public static Vector2f mulN(Vector2f v1, Vector2f v2) { return Vector2f.mulN(v1, v2.getX(), v2.getY()); }
	
	public static Vector2f mulN(Vector2f v1, float scalar) { return Vector2f.mulN(v1, scalar, scalar); }
	
	public static Vector2f mulN(Vector2f v1, float x, float y) { return v1.mulN(x, y); }
	
	public static Vector2f divN(Vector2f v1, Vector2f v2) { return Vector2f.divN(v1, v2.getX(), v2.getY()); }
	
	public static Vector2f divN(Vector2f v1, float scalar) { return Vector2f.divN(v1, scalar, scalar); }
	
	public static Vector2f divN(Vector2f v1, float x, float y) { return v1.divN(x, y); }
	
	public static Vector2f powN(Vector2f v1, Vector2f v2) { return Vector2f.powN(v1, v2.getX(), v2.getY()); }
	
	public static Vector2f powN(Vector2f v1, float scalar) { return Vector2f.powN(v1, scalar, scalar); }
	
	public static Vector2f powN(Vector2f v1, float x, float y) { return v1.powN(x, y); }
	
	
	
	public static Vector2f addR(Vector2f v1, Vector2f v2, Vector2f v3) { return Vector2f.add(v1, v2.getX(), v2.getY()); }
	
	public static Vector2f addR(Vector2f v1, float scalar, Vector2f v3) { return Vector2f.add(v1, scalar, scalar); }
	
	public static Vector2f addR(Vector2f v1, float x, float y, Vector2f v3) { return v1.add(x, y); }
	
	public static Vector2f subR(Vector2f v1, Vector2f v2, Vector2f v3) { return Vector2f.sub(v1, v2.getX(), v2.getY()); }
	
	public static Vector2f subR(Vector2f v1, float scalar, Vector2f v3) { return Vector2f.sub(v1, scalar, scalar); }
	
	public static Vector2f subR(Vector2f v1, float x, float y, Vector2f v3) { return v1.sub(x, y); }
	
	public static Vector2f mulR(Vector2f v1, Vector2f v2, Vector2f v3) { return Vector2f.mul(v1, v2.getX(), v2.getY()); }
	
	public static Vector2f mulR(Vector2f v1, float scalar, Vector2f v3) { return Vector2f.mul(v1, scalar, scalar); }
	
	public static Vector2f mulR(Vector2f v1, float x, float y, Vector2f v3) { return v1.mul(x, y); }
	
	public static Vector2f divR(Vector2f v1, Vector2f v2, Vector2f v3) { return Vector2f.div(v1, v2.getX(), v2.getY()); }
	
	public static Vector2f divR(Vector2f v1, float scalar, Vector2f v3) { return Vector2f.div(v1, scalar, scalar); }
	
	public static Vector2f divR(Vector2f v1, float x, float y, Vector2f v3) { return v1.div(x, y); }
	
	public static Vector2f powR(Vector2f v1, Vector2f v2, Vector2f v3) { return Vector2f.pow(v1, v2.getX(), v2.getY()); }
	
	public static Vector2f powR(Vector2f v1, float scalar, Vector2f v3) { return Vector2f.pow(v1, scalar, scalar); }
	
	public static Vector2f powR(Vector2f v1, float x, float y, Vector2f v3) { return v1.pow(x, y); }
	
	
	
	/*
	 * ====================
	 * BASIC-OPERATIONS
	 * ====================
	 */
	public Vector2f add(Vector2f v) { return add(v.getX(), v.getY()); }
	
	public Vector2f add(float scalar) { return add(scalar, scalar); }
	
	public Vector2f add(float x, float y) { return setX(getX() + x).setY(getY() + y); }
	
	public Vector2f sub(Vector2f v) { return sub(v.getX(), v.getY()); }
	
	public Vector2f sub(float scalar) { return sub(scalar, scalar); }
	
	public Vector2f sub(float x, float y) { return setX(getX() - x).setY(getY() - y); }
	
	public Vector2f mul(Vector2f v) { return mul(v.getX(), v.getY()); }
	
	public Vector2f mul(float scalar) { return mul(scalar, scalar); }
	
	public Vector2f mul(float x, float y) { return setX(getX() * x).setY(getY() * y); }
	
	public Vector2f div(Vector2f v) { return div(v.getX(), v.getY()); }
	
	public Vector2f div(float scalar) { return div(scalar, scalar); }
	
	public Vector2f div(float x, float y) { return setX(getX() / x).setY(getY() / y); }
	
	public Vector2f pow(Vector2f v) {return pow(v.getX(), v.getY()); }
	
	public Vector2f pow(float scalar) { return pow(scalar, scalar); }
	
	public Vector2f pow(float x, float y) { return setX((float) Math.pow(getX(), x)).setY((float) Math.pow(getY(), y)); }
	
	
	
	public Vector2f addN(Vector2f v) { return addN(v.getX(), v.getY()); }
	
	public Vector2f addN(float scalar) { return addN(scalar, scalar); }
	
	public Vector2f addN(float x, float y) { return clone().add(x, y); }
	
	public Vector2f subN(Vector2f v) { return subN(v.getX(), v.getY()); }
	
	public Vector2f subN(float scalar) { return subN(scalar, scalar); }
	
	public Vector2f subN(float x, float y) { return clone().sub(x, y); }
	
	public Vector2f mulN(Vector2f v) { return mulN(v.getX(), v.getY()); }
	
	public Vector2f mulN(float scalar) { return mulN(scalar, scalar); }
	
	public Vector2f mulN(float x, float y) { return clone().mul(x, y); }
	
	public Vector2f divN(Vector2f v) { return divN(v.getX(), v.getY()); }
	
	public Vector2f divN(float scalar) { return divN(scalar, scalar); }
	
	public Vector2f divN(float x, float y) { return clone().div(x, y); }
	
	public Vector2f powN(Vector2f v) { return powN(v.getX(), v.getY()); }
	
	public Vector2f powN(float scalar) { return powN(scalar, scalar); }
	
	public Vector2f powN(float x, float y) { return clone().pow(x, y); }
	
	
	
	public Vector2f addR(Vector2f v, Vector2f v2) { return addR(v.getX(), v.getY(), v2); }
	
	public Vector2f addR(float scalar, Vector2f v2) { return addR(scalar, scalar, v2); }
	
	public Vector2f addR(float x, float y, Vector2f v2) { return v2.set(this).add(x, y); }
	
	public Vector2f subR(Vector2f v, Vector2f v2) { return subR(v.getX(), v.getY(), v2); }
	
	public Vector2f subR(float scalar, Vector2f v2) { return subR(scalar, scalar, v2); }
	
	public Vector2f subR(float x, float y, Vector2f v2) { return v2.set(this).sub(x, y); }
	
	public Vector2f mulR(Vector2f v, Vector2f v2) { return mulR(v.getX(), v.getY(), v2); }
	
	public Vector2f mulR(float scalar, Vector2f v2) { return mulR(scalar, scalar, v2); }
	
	public Vector2f mulR(float x, float y, Vector2f v2) { return v2.set(this).mul(x, y); }
	
	public Vector2f divR(Vector2f v, Vector2f v2) { return divR(v.getX(), v.getY(), v2); }
	
	public Vector2f divR(float scalar, Vector2f v2) { return divR(scalar, scalar, v2); }
	
	public Vector2f divR(float x, float y, Vector2f v2) { return v2.set(this).div(x, y); }
	
	public Vector2f powR(Vector2f v, Vector2f v2) { return powR(v.getX(), v.getY(), v2); }
	
	public Vector2f powR(float scalar, Vector2f v2) { return powR(scalar, scalar, v2); }
	
	public Vector2f powR(float x, float y, Vector2f v2) { return v2.set(this).pow(x, y); }
	
	
	
	/*
	 * =====================
	 * VECTOR-OPERATIONS
	 * =====================
	 */
	public float length() { return (float) Math.sqrt(squaredLength()); }
	
	public float squaredLength() { return getX() * getX() + getY() * getY(); }
	
	
	
	public Vector2f normalize() { return Check.notNull(this) ? div(length()) : this; }
	
	public Vector2f normalized() { return clone().normalize(); }
	
	
	
	public Vector2f invert() { return mul(-1.0f); }
	
	public Vector2f invertX() { return invert(true, false); }
	
	public Vector2f invertY() { return invert(false, true); }
	
	public Vector2f invert(boolean x, boolean y) { return mul(x ? -1.0f : 1.0f, y ? -1.0f : 1.0f); }
	
	public Vector2f inverted() { return clone().invert(); }
	
	public Vector2f invertedX() { return clone().invertX(); }
	
	public Vector2f invertedY() { return clone().invertY(); }
	
	public Vector2f inverted(boolean x, boolean y) {return clone().invert(x, y); }
	

	
	public float dot(Vector2f v) { return getX() * v.getX() + getY() * v.getY(); }
	
	
	
	public double angleRad(Vector2f v)
	{
		return Math.acos((dot(v)) / (length() * v.length()));
	}
	
	public double angleDeg(Vector2f v)
	{
		return angleRad(v) * Maths.RAD_TO_DEG;
	}
	
	
	
	public Vector2f lerp(Vector2f dest, float factor) { return dest.subN(this).mul(factor).add(this); }
	
	public Vector2f interpolate(Vector2f v2, float polation)
	{
		return mulN((1.0f - polation)).add(v2.mulN(polation));
	}
	
	
	
	public float max() { return Math.max(getX(),getY()); }
	
	public float min() { return Math.min(getX(), getY()); }
	
	
	
	public Vector2f abs() { return abs(true, true); }
	
	public Vector2f absX() { return abs(true, false); }
	
	public Vector2f absY() { return abs(false, true); }
	
	public Vector2f abs(boolean x, boolean y)
	{
		setX(x ? Math.abs(getX()) : getX());
		setY(y ? Math.abs(getY()) : getY());
		
		return this;
	}

	public Vector2f absN() { return clone().abs(); }
	
	public Vector2f absN(boolean x, boolean y) { return clone().abs(x, y); }
	
	public Vector2f absXN() { return clone().absX(); }
	
	public Vector2f absYN() { return clone().absY(); }
	
	
	public Vector2f absR(Vector2f r) { return r.set(this).abs(); }
	
	public Vector2f absR(boolean x, boolean y, Vector2f r) { return r.set(this).abs(x, y); }
	
	public Vector2f absXR(Vector2f r) { return r.set(this).absX(); }
	
	public Vector2f absYR(Vector2f r) { return r.set(this).absY(); }
	
	
	
	/*
	 * =========================
	 * STATIC ROUNDING
	 * =========================
	 */
	public static Vector2f floor(Vector2f v) { return v.floor(true, true); }
	
	public static Vector2f floorX(Vector2f v) { return v.floor(true, false); }
	
	public static Vector2f floorY(Vector2f v) { return v.floor(false, true); }
	
	public static Vector2f floor(Vector2f v, boolean x, boolean y) { return v.floor(x, y); }
	
	public static Vector2f ceil(Vector2f v) { return v.ceil(true, true); }
	
	public static Vector2f ceilX(Vector2f v) { return v.ceil(true, false); }
	
	public static Vector2f ceilY(Vector2f v) { return v.ceil(false, true); }
	
	public static Vector2f ceil(Vector2f v, boolean x, boolean y) { return v.ceil(x, y); }

	public static Vector2f round(Vector2f v) { return v.round(true, true); }
	
	public static Vector2f roundX(Vector2f v) { return v.round(true, false); }
	
	public static Vector2f roundY(Vector2f v) { return v.round(false, true); }
	
	public static Vector2f round(Vector2f v, boolean x, boolean y){ return v.round(x, y); }
	

	
	public static Vector2f floorN(Vector2f v) { return v.floorN(); }
	
	public static Vector2f floorN(Vector2f v, boolean x, boolean y) { return v.floorN(x, y); }
	
	public static Vector2f floorXN(Vector2f v) { return v.floorXN(); }
	
	public static Vector2f floorYN(Vector2f v) { return v.floorYN(); }
	
	public static Vector2f ceilN(Vector2f v) { return v.ceilN(); }
	
	public static Vector2f ceilN(Vector2f v, boolean x, boolean y) { return v.ceilN(x, y); }
	
	public static Vector2f ceilXN(Vector2f v) { return v.ceilXN(); }
	
	public static Vector2f ceilYN(Vector2f v) { return v.ceilYN(); }

	public static Vector2f roundN(Vector2f v) { return v.roundN(); }
	
	public static Vector2f roundN(Vector2f v, boolean x, boolean y) { return v.roundN(x, y); }
	
	public static Vector2f roundXN(Vector2f v) { return v.roundXN(); }
	
	public static Vector2f roundYN(Vector2f v) { return v.roundYN(); }
	
	
	public static Vector2f floorR(Vector2f v, Vector2f r) { return r.set(v).floor(); }
	
	public static Vector2f floorR(Vector2f v, boolean x, boolean y, Vector2f r) { return r.set(v).floor(x, y); }
	
	public static Vector2f floorXR(Vector2f v, Vector2f r) { return r.set(v).floorX(); }
	
	public static Vector2f floorYR(Vector2f v, Vector2f r) { return r.set(v).floorY(); }
	
	public static Vector2f ceilR(Vector2f v, Vector2f r) { return r.set(v).ceil(); }
	
	public static Vector2f ceilR(Vector2f v, boolean x, boolean y, Vector2f r) { return r.set(v).ceil(x, y); }
	
	public static Vector2f ceilXR(Vector2f v, Vector2f r) { return r.set(v).ceilX(); }
	
	public static Vector2f ceilYR(Vector2f v, Vector2f r) { return r.set(v).ceilY(); }

	public static Vector2f roundR(Vector2f v, Vector2f r) { return r.set(v).round(); }
	
	public static Vector2f roundR(Vector2f v, boolean x, boolean y, Vector2f r) { return r.set(v).round(x, y); }
	
	public static Vector2f roundXR(Vector2f v, Vector2f r) { return r.set(v).roundX(); }
	
	public static Vector2f roundYR(Vector2f v, Vector2f r) { return r.set(v).roundY(); }
	
	
	
	/*
	 * =========================
	 * ROUNDING
	 * =========================
	 */
	public Vector2f floor() { return floor(true, true); }
	
	public Vector2f floorX() { return floor(true, false); }
	
	public Vector2f floorY() { return floor(false, true); }
	
	public Vector2f floor(boolean x, boolean y)
	{
		setX(x ? (float) Math.floor(getX()) : getX());
		setY(y ? (float) Math.floor(getY()) : getY());
		
		return this;
	}
	
	public Vector2f ceil() { return ceil(true, true); }
	
	public Vector2f ceilX() { return ceil(true, false); }
	
	public Vector2f ceilY() { return ceil(false, true); }
	
	public Vector2f ceil(boolean x, boolean y)
	{
		setX(x ? (float) Math.ceil(getX()) : getX());
		setY(y ? (float) Math.ceil(getY()) : getY());
		
		return this;
	}

	public Vector2f round() { return round(true, true); }
	
	public Vector2f roundX() { return round(true, false); }
	
	public Vector2f roundY() { return round(false, true); }
	
	public Vector2f round(boolean x, boolean y)
	{
		setX(x ? (float) Math.round(getX()) : getX());
		setY(y ? (float) Math.round(getY()) : getY());
		
		return this;
	}
	

	
	public Vector2f floorN() { return clone().floor(); }
	
	public Vector2f floorN(boolean x, boolean y) { return clone().floor(x, y); }
	
	public Vector2f floorXN() { return clone().floorX(); }
	
	public Vector2f floorYN() { return clone().floorY(); }
	
	public Vector2f ceilN() { return clone().ceil(); }
	
	public Vector2f ceilN(boolean x, boolean y) { return clone().ceil(x, y); }
	
	public Vector2f ceilXN() { return clone().ceilX(); }
	
	public Vector2f ceilYN() { return clone().ceilY(); }

	public Vector2f roundN() { return clone().round(); }
	
	public Vector2f roundN(boolean x, boolean y) { return clone().round(x, y); }
	
	public Vector2f roundXN() { return clone().roundX(); }
	
	public Vector2f roundYN() { return clone().roundY(); }
	
	
	public Vector2f floorR(Vector2f r) { return r.set(this).floor(); }
	
	public Vector2f floorR(boolean x, boolean y, Vector2f r) { return r.set(this).floor(x, y); }
	
	public Vector2f floorXR(Vector2f r) { return r.set(this).floorX(); }
	
	public Vector2f floorYR(Vector2f r) { return r.set(this).floorY(); }
	
	public Vector2f ceilR(Vector2f r) { return r.set(this).ceil(); }
	
	public Vector2f ceilR(boolean x, boolean y, Vector2f r) { return r.set(this).ceil(x, y); }
	
	public Vector2f ceilXR(Vector2f r) { return r.set(this).ceilX(); }
	
	public Vector2f ceilYR(Vector2f r) { return r.set(this).ceilY(); }

	public Vector2f roundR(Vector2f r) { return r.set(this).round(); }
	
	public Vector2f roundR(boolean x, boolean y, Vector2f r) { return r.set(this).round(x, y); }
	
	public Vector2f roundXR(Vector2f r) { return r.set(this).roundX(); }
	
	public Vector2f roundYR(Vector2f r) { return r.set(this).roundY(); }

	
	
	/*
	 * =================
	 * CLAMPING
	 * =================
	 */
	public Vector2f clamp(Vector2f min, Vector2f max) { return clampMin(min).clampMax(max); }
	
	public Vector2f clamp(float min, float max) { return clampMin(min).clampMax(max); }
	
	public Vector2f clampMin(Vector2f min) { return setX(Maths.clampMin(getX(), min.getX())).setY(Maths.clampMin(getY(), min.getY())); }
	
	public Vector2f clampMin(float min) { return setX(Maths.clampMin(getX(), min)).setY(Maths.clampMin(getY(), min)); }
	
	public Vector2f  clampMax(Vector2f max) { return setX(Maths.clampMax(getX(), max.getX())).setY(Maths.clampMax(getY(), max.getY())); }
	
	public Vector2f clampMax(float max) { return setX(Maths.clampMax(getX(), max)).setY(Maths.clampMax(getY(), max)); }
	
	
	
	public Vector2f clampN(Vector2f min, Vector2f max) { return clone().clamp(min, max); }
	
	public Vector2f clampN(float min, float max) { return clone().clamp(min, max); }
	
	public Vector2f clampMinN(Vector2f min) { return clone().clampMin(min); }
	
	public Vector2f clampMinN(float min) { return clone().clampMin(min); }
	
	public Vector2f clampMaxN(Vector2f max) { return clone().clampMax(max); }
	
	public Vector2f clampMaxN(float max) { return clone().clampMaxN(max); }
	
	
	
	public Vector2f clampR(Vector2f min, Vector2f max, Vector2f r) { return r.set(this).clamp(min, max); }
	
	public Vector2f clampR(float min ,float max, Vector2f r) { return r.set(this).clamp(min, max); }
	
	public Vector2f clampMinR(Vector2f min, Vector2f r) { return r.set(this).clampMin(min); }
	
	public Vector2f clampMinR(float min, Vector2f r) { return r.set(this).clampMin(min); }
	
	public Vector2f clampMaxR(Vector2f max, Vector2f r) { return r.set(this).clampMax(max); }
	
	public Vector2f clampMaxR(float max, Vector2f r) { return r.set(this).clampMax(max); }
	

	
	/*
	 * ==================
	 * ORDINAL OPERATIONS
	 * ==================
	 */
	public int getDimensions() { return Vector2f.DIMENSIONS; }
	
	public float getOrdinal(int index)
	{
		if(index < 0 || index >= getDimensions()) throw new IndexOutOfBoundsException();
		
		switch(index)
		{
			case 0: { return getX(); }
			case 1: { return getY(); }
			
			default: return Float.NaN;
		}
	}
	
	public float[] ordinal() { return new float[] { getX(), getY() }; }
	
	public Vector2f setOrdinal(int index, float val)
	{
		checkIndex(index);
		
		switch(index)
		{
			case 0: { return setX(val); }
			case 1: { return setY(val); }
			
			default: return this;
		}
	}
	
	private void checkIndex(int index)
	{
		if(index < 0 || index >= getDimensions()) throw new IndexOutOfBoundsException();
	}
	
	public Vector2f setOridinal(@NotNull float... val)
	{
		checkIndex(val.length - 1);
		
		for(int i = 0; i < val.length; i++)
		{
			setOrdinal(i, val[i]);
		}
		
		return this;
	}
	

	/*
	 * ===========================
	 * OBJECT-OVERRIDES
	 * ===========================
	 */
	public Vector2f clone() { return new Vector2f(this); }
	
	public String toString() { return "vec2f(" + getX() + "f, " + getY() + "f)"; }

	
	/*
	 * ===========================
	 * DATA-HOLDER SERIALIZATION
	 * ===========================
	 */
	public void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		setX(dis.readFloat());
		setY(dis.readFloat());
	}
	

	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeFloat(getX());
		dos.writeFloat(getY());
	}
	
}
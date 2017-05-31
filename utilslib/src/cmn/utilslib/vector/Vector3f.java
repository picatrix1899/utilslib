package cmn.utilslib.vector;


import cmn.utilslib.vector.api.Vec3f;
import cmn.utilslib.vector.api.Vec3fBase;


/**
 * A mathematical 3-dimensional vector of type float
 * 
 * @author picatrix1899
 *
 */
public class Vector3f implements Vec3f
{

	public float x = 0.0f;
	public float y = 0.0f;
	public float z = 0.0f;
	
	

	public Vector3f() { setZero(); }
	
	public Vector3f(float scalar) { set(scalar); }
	
	public Vector3f(float x, float y, float z) { set(x, y, z); }
	public Vector3f(Vec3fBase v) { set(v); }
	
	/*
	 * =========
	 * GETTERS
	 * =========
	 */
	public float getX() { return this.x; }
	public float getY() { return this.y; }
	public float getZ() { return this.z; }
	
	/*
	 * ======================
	 * SETTERS
	 * ======================
	 */

	public Vec3f setX(float x) { this.x = x; return this; }
	public Vec3f setX(double x) { this.x = (float)x; return this; }
	public Vec3f setY(float y) { this.y = y; return this; }
	public Vec3f setY(double y) { this.y = (float)y; return this; }
	public Vec3f setZ(float z) { this.z = z; return this; }
	public Vec3f setZ(double z) { this.z = (float)z; return this; }
	
	
	/*
	 * ===========================
	 * OBJECT-OVERRIDES
	 * ===========================
	 */
	/** {@inheritDoc} */
	@Override
	public Vec3f clone() { return new Vector3f(this); }
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Vector3f)) return false;
		Vector3f v = (Vector3f)obj;
		
		if(v.x != this.x) return false;
		if(v.y != this.y) return false;
		if(v.z != this.z) return false;
		
		return true;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() { return "Vec3f(" + this.x + "f, " + this.y + "f, " + this.z + "f)"; }
	


}
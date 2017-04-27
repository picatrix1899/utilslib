package cmn.utilslib.vector;


import cmn.utilslib.vector.api.IVec3f;
import cmn.utilslib.vector.api.IVec3fBase;


/**
 * A mathematical 3-dimensional vector of type float
 * 
 * @author picatrix1899
 *
 */
public class Vec3f implements IVec3f
{

	public float x = 0.0f;
	public float y = 0.0f;
	public float z = 0.0f;
	
	

	public Vec3f() { setZero(); }
	
	public Vec3f(float scalar) { set(scalar); }
	
	public Vec3f(float x, float y, float z) { set(x, y, z); }
	public Vec3f(IVec3fBase v) { set(v); }
	
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
	public IVec3f clone() { return new Vec3f(this); }
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Vec3f)) return false;
		Vec3f v = (Vec3f)obj;
		
		if(v.x != this.x) return false;
		if(v.y != this.y) return false;
		if(v.z != this.z) return false;
		
		return true;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() { return "Vec3f(" + this.x + "f, " + this.y + "f, " + this.z + "f)"; }
	


}
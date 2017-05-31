package cmn.utilslib.vector;


import cmn.utilslib.vector.api.Vec3d;
import cmn.utilslib.vector.api.Vec3dBase;



/**
 * A mathematical 3-dimensional vector of type float
 * 
 * @author picatrix1899
 *
 */
public class Vector3d implements Vec3d
{

	public double x = 0.0f;
	public double y = 0.0f;
	public double z = 0.0f;
	
	

	public Vector3d() { setZero(); }
	
	public Vector3d(double scalar) { set(scalar); }
	
	public Vector3d(double x, double y, double z) { set(x, y, z); }
	public Vector3d(Vec3dBase v) { set(v); }
	
	/*
	 * =========
	 * GETTERS
	 * =========
	 */
	public double getX() { return this.x; }
	public double getY() { return this.y; }
	public double getZ() { return this.z; }
	
	/*
	 * ======================
	 * SETTERS
	 * ======================
	 */

	public Vec3d setX(float x) { this.x = x; return this; }
	public Vec3d setX(double x) { this.x = (float)x; return this; }
	public Vec3d setY(float y) { this.y = y; return this; }
	public Vec3d setY(double y) { this.y = (float)y; return this; }
	public Vec3d setZ(float z) { this.z = z; return this; }
	public Vec3d setZ(double z) { this.z = (float)z; return this; }
	
	
	/*
	 * ===========================
	 * OBJECT-OVERRIDES
	 * ===========================
	 */
	/** {@inheritDoc} */
	@Override
	public Vector3d clone() { return new Vector3d(this); }
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Vector3d)) return false;
		Vector3d v = (Vector3d)obj;
		
		if(v.x != this.x) return false;
		if(v.y != this.y) return false;
		if(v.z != this.z) return false;
		
		
		
		return true;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() { return "Vec3d(" + this.x + "d, " + this.y + "d, " + this.z + "d)"; }
	


}
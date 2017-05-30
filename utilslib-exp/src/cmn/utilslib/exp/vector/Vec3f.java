package cmn.utilslib.exp.vector;


import cmn.utilslib.exp.vector.api.Vector3fE;

/**
 * A mathematical 3-dimensional vector of type float
 * 
 * @author picatrix1899
 *
 */
public class Vec3f implements Vector3fE<Vec3f>
{

	public float x = 0.0f;
	public float y = 0.0f;
	public float z = 0.0f;
	

	public float getX() { return this.x; }
	public float getY() { return this.y; }
	public float getZ() { return this.z; }


	public Vec3f setX(float x) { this.x = x; return this; }
	public Vec3f setY(float y) { this.y = y; return this; }
	public Vec3f setZ(float z) { this.z = z; return this; }
	
	

	/** {@inheritDoc} */
	@Override
	public Vec3f clone() { return new Vec3f().setX(getX()).setY(getY()).setZ(getZ()); }

}
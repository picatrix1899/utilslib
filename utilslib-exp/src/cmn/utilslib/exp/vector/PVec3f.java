
package cmn.utilslib.exp.vector;

import cmn.utilslib.exp.vector.api.Vector3fBaseE;

/** 
 * A persistent representation of a vector3f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVec3f implements Vector3fBaseE<Vec3f>
{

		public abstract Vec3f clone();
	
	/** generates a new persistent vector2f */
	public static PVec3f gen(final float x, final float y, final float z)
	{
		return new PVec3f()
		{
			public float getX() { return x; }
			public float getY() { return y; }
			public float getZ() { return z; }
			
			public Vec3f clone() { return new Vec3f().setX(getX()).setY(getY()).setZ(getZ()); }
		};
	}
	
}

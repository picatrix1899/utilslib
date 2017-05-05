
package cmn.utilslib.vector;

import cmn.utilslib.vector.api.Vector3f;
import cmn.utilslib.vector.api.Vector3fBase;

/** 
 * A persistent representation of a vector3f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVec3f implements Vector3fBase
{

	public abstract Vector3f clone();
	
	/** generates a new persistent vector2f */
	public static PVec3f gen(final float x, final float y, final float z)
	{
		return new PVec3f()
		{
			

			public float getX() { return x; }
			public float getY() { return y; }
			public float getZ() { return z; }
			

			@Override
			public Vector3f clone()
			{
				return new Vec3f(this);
			}
			
		};
	}
	
}

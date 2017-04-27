
package cmn.utilslib.vector;

import cmn.utilslib.vector.api.IVec3f;
import cmn.utilslib.vector.api.IVec3fBase;

/** 
 * A persistent representation of a vector3f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVec3f implements IVec3fBase
{

	public abstract IVec3f clone();
	
	/** generates a new persistent vector2f */
	public static PVec3f gen(final float x, final float y, final float z)
	{
		return new PVec3f()
		{
			

			public float getX() { return x; }
			public float getY() { return y; }
			public float getZ() { return z; }
			

			@Override
			public IVec3f clone()
			{
				return new Vec3f(this);
			}
			
		};
	}
	
}

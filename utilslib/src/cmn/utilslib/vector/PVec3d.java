
package cmn.utilslib.vector;

import cmn.utilslib.vector.api.IVec3d;
import cmn.utilslib.vector.api.IVec3dBase;

/** 
 * A persistent representation of a vector3f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVec3d implements IVec3dBase
{

	public abstract IVec3d clone();
	
	/** generates a new persistent vector2f */
	public static PVec3d gen(final float x, final float y, final float z)
	{
		return new PVec3d()
		{
			

			public double getX() { return x; }
			public double getY() { return y; }
			public double getZ() { return z; }
			

			@Override
			public IVec3d clone()
			{
				return new Vec3d(this);
			}
			
		};
	}
	
}

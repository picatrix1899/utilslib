
package cmn.utilslib.vector;

import cmn.utilslib.vector.api.Vec3dBase;

/** 
 * A persistent representation of a vector3f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVector3d implements Vec3dBase
{

	public abstract Vector3d clone();
	
	/** generates a new persistent vector2f */
	public static PVector3d gen(final float x, final float y, final float z)
	{
		return new PVector3d()
		{
			

			public double getX() { return x; }
			public double getY() { return y; }
			public double getZ() { return z; }
			

			@Override
			public Vector3d clone()
			{
				return new Vector3d(this);
			}
			
		};
	}
	
}

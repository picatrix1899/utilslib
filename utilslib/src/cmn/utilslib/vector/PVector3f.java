
package cmn.utilslib.vector;

import cmn.utilslib.vector.api.Vec3fBase;

/** 
 * A persistent representation of a vector3f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVector3f implements Vec3fBase
{

	public abstract Vector3f clone();
	
	/** generates a new persistent vector2f */
	public static PVector3f gen(final float x, final float y, final float z)
	{
		return new PVector3f()
		{
			

			public float getX() { return x; }
			public float getY() { return y; }
			public float getZ() { return z; }
			

			@Override
			public Vector3f clone()
			{
				return new Vector3f(this);
			}
			
		};
	}
	
}

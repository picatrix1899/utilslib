
package cmn.utilslib.vector;

import cmn.utilslib.vector.api.Vector4d;
import cmn.utilslib.vector.api.Vector4dBase;

/** 
 * A persistent representation of a vector3f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVec4d implements Vector4dBase
{

	public abstract Vector4d clone();
	
	/** generates a new persistent vector2f */
	public static PVec4d gen(final double x, final double y, final double z, final double a)
	{
		return new PVec4d()
		{
			

			public double getX() { return x; }
			public double getY() { return y; }
			public double getZ() { return z; }
			public double getA() { return a; }

			@Override
			public Vector4d clone()
			{
				return new Vec4d(this);
			}
			
		};
	}
	
}

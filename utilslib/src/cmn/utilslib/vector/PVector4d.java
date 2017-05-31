
package cmn.utilslib.vector;

import cmn.utilslib.vector.api.Vec4dBase;

/** 
 * A persistent representation of a vector3f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVector4d implements Vec4dBase
{

	public abstract Vector4d clone();
	
	/** generates a new persistent vector2f */
	public static PVector4d gen(final double x, final double y, final double z, final double a)
	{
		return new PVector4d()
		{
			

			public double getX() { return x; }
			public double getY() { return y; }
			public double getZ() { return z; }
			public double getA() { return a; }

			@Override
			public Vector4d clone()
			{
				return new Vector4d(this);
			}
			
		};
	}
	
}

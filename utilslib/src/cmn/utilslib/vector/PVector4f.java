
package cmn.utilslib.vector;

import cmn.utilslib.vector.api.Vec4fBase;

/** 
 * A persistent representation of a vector3f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVector4f implements Vec4fBase
{

	public abstract Vector4f clone();
	
	/** generates a new persistent vector2f */
	public static PVector4f gen(final float x, final float y, final float z, final float a)
	{
		return new PVector4f()
		{
			

			public float getX() { return x; }
			public float getY() { return y; }
			public float getZ() { return z; }
			public float getA() { return a; }

			@Override
			public Vector4f clone()
			{
				return new Vector4f(this);
			}
			
		};
	}
	
}

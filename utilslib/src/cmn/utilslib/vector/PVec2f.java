
package cmn.utilslib.vector;

import cmn.utilslib.vector.api.IVec2fBase;

/** 
 * A persistent representation of a vector2f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVec2f implements IVec2fBase
{

	/** {@inheritDoc} */ @Override
	public Vec2f clone() { return new Vec2f(this); }


	/** generates a new persistent vector2f */
	public static PVec2f gen(final float x, final float y)
	{
		return new PVec2f()
		{

			/** {@inheritDoc} */ @Override
			public float getX() { return x; }
			
			/** {@inheritDoc} */ @Override
			public float getY() { return y; }

		};
	}
	
}

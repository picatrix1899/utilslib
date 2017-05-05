
package cmn.utilslib.vector;

import cmn.utilslib.vector.api.Vector2dBase;

/** 
 * A persistent representation of a vector2f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVec2d implements Vector2dBase
{

	/** {@inheritDoc} */ @Override
	public Vec2d clone() { return new Vec2d(this); }


	/** generates a new persistent vector2f */
	public static PVec2d gen(final float x, final float y)
	{
		return new PVec2d()
		{

			/** {@inheritDoc} */ @Override
			public double getX() { return x; }
			
			/** {@inheritDoc} */ @Override
			public double getY() { return y; }

		};
	}
	
}

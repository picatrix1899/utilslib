
package cmn.utilslib.vector;

import cmn.utilslib.vector.api.Vec2dBase;

/** 
 * A persistent representation of a vector2f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVector2d implements Vec2dBase
{

	/** {@inheritDoc} */ @Override
	public Vector2d clone() { return new Vector2d(this); }


	/** generates a new persistent vector2f */
	public static PVector2d gen(final double x, final double y)
	{
		return new PVector2d()
		{

			/** {@inheritDoc} */ @Override
			public double getX() { return x; }
			
			/** {@inheritDoc} */ @Override
			public double getY() { return y; }

		};
	}
	
}

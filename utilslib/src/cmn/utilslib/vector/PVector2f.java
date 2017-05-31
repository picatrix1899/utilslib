
package cmn.utilslib.vector;

import cmn.utilslib.vector.api.Vec2fBase;

/** 
 * A persistent representation of a vector2f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVector2f implements Vec2fBase
{

	/** {@inheritDoc} */ @Override
	public Vector2f clone() { return new Vector2f(this); }


	/** generates a new persistent vector2f */
	public static PVector2f gen(final float x, final float y)
	{
		return new PVector2f()
		{

			/** {@inheritDoc} */ @Override
			public float getX() { return x; }
			
			/** {@inheritDoc} */ @Override
			public float getY() { return y; }

		};
	}
	
}

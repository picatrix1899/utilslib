
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

			public Vector2f addN(Vec2fBase v) { return addN(v.getX(), v.getY()); }
			public Vector2f addN(float scalar) { return addN(scalar, scalar); }
			public Vector2f addN(double scalar) { return addN(scalar, scalar); }
			public Vector2f addN(float x, float y) { return clone().add(x, y); }
			public Vector2f addN(double x, double y) { return clone().add(x, y); }
			
			public Vector2f subN(Vec2fBase v) { return subN(v.getX(), v.getY()); }
			public Vector2f subN(float scalar) { return subN(scalar, scalar); }
			public Vector2f subN(double scalar) { return subN(scalar, scalar); }
			public Vector2f subN(float x, float y) { return clone().sub(x, y); }
			public Vector2f subN(double x, double y) { return clone().sub(x, y); }
			
			public Vector2f mulN(Vec2fBase v) { return mulN(v.getX(), v.getY()); }
			public Vector2f mulN(float scalar) { return mulN(scalar, scalar); }
			public Vector2f mulN(double scalar) { return mulN(scalar, scalar); }
			public Vector2f mulN(float x, float y) { return clone().mul(x, y); }
			public Vector2f mulN(double x, double y) { return clone().mul(x, y); }
			
			public Vector2f divN(Vec2fBase v) { return divN(v.getX(), v.getY()); }
			public Vector2f divN(float scalar) { return divN(scalar, scalar); }
			public Vector2f divN(double scalar) { return divN(scalar, scalar); }
			public Vector2f divN(float x, float y) { return clone().div(x, y); }
			public Vector2f divN(double x, double y) { return clone().div(x, y); }
			
			public Vector2f inverted() { return clone().invert(); }
			
			public Vector2f normalized() { return clone().normalize(); }
			
		};
	}
	
}

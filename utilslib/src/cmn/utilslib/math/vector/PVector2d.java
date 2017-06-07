
package cmn.utilslib.math.vector;


import cmn.utilslib.math.vector.api.Vec2dBase;

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

			
			public Vector2d addN(Vec2dBase v) { return addN(v.getX(), v.getY()); }
			public Vector2d addN(float scalar) { return addN(scalar, scalar); }
			public Vector2d addN(double scalar) { return addN(scalar, scalar); }
			public Vector2d addN(float x, float y) { return clone().add(x, y); }
			public Vector2d addN(double x, double y) { return clone().add(x, y); }
			
			public Vector2d subN(Vec2dBase v) { return subN(v.getX(), v.getY()); }
			public Vector2d subN(float scalar) { return subN(scalar, scalar); }
			public Vector2d subN(double scalar) { return subN(scalar, scalar); }
			public Vector2d subN(float x, float y) { return clone().sub(x, y); }
			public Vector2d subN(double x, double y) { return clone().sub(x, y); }
			
			public Vector2d mulN(Vec2dBase v) { return mulN(v.getX(), v.getY()); }
			public Vector2d mulN(float scalar) { return mulN(scalar, scalar); }
			public Vector2d mulN(double scalar) { return mulN(scalar, scalar); }
			public Vector2d mulN(float x, float y) { return clone().mul(x, y); }
			public Vector2d mulN(double x, double y) { return clone().mul(x, y); }
			
			public Vector2d divN(Vec2dBase v) { return divN(v.getX(), v.getY()); }
			public Vector2d divN(float scalar) { return divN(scalar, scalar); }
			public Vector2d divN(double scalar) { return divN(scalar, scalar); }
			public Vector2d divN(float x, float y) { return clone().div(x, y); }
			public Vector2d divN(double x, double y) { return clone().div(x, y); }
			
			public Vector2d inverted() { return clone().invert(); }
			
			public Vector2d normalized() { return clone().normalize(); }
			
		};
	}
	
}

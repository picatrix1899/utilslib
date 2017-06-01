
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

			
			public Vector2d addN(Vec2dBase v) { return (Vector2d) super.addN(v); }
			public Vector2d addN(float scalar) { return (Vector2d) super.addN(scalar); }
			public Vector2d addN(double scalar) { return (Vector2d) super.addN(scalar); }
			public Vector2d addN(float x, float y) { return (Vector2d) super.addN(x, y); }
			public Vector2d addN(double x, double y) { return (Vector2d) super.addN(x, y); }
			
			public Vector2d subN(Vec2dBase v) { return (Vector2d) super.subN(v); }
			public Vector2d subN(float scalar) { return (Vector2d) super.subN(scalar); }
			public Vector2d subN(double scalar) { return (Vector2d) super.subN(scalar); }
			public Vector2d subN(float x, float y) { return (Vector2d)super.subN(x, y); }
			public Vector2d subN(double x, double y) { return (Vector2d) super.subN(x, y); }
			
			public Vector2d mulN(Vec2dBase v) { return (Vector2d) super.mulN(v); }
			public Vector2d mulN(float scalar) { return (Vector2d) super.mulN(scalar); }
			public Vector2d mulN(double scalar) { return (Vector2d) super.mulN(scalar); }
			public Vector2d mulN(float x, float y) { return (Vector2d) super.mulN(x, y); }
			public Vector2d mulN(double x, double y) { return (Vector2d) super.mulN(x, y); }
			
			public Vector2d divN(Vec2dBase v) { return (Vector2d) super.divN(v); }
			public Vector2d divN(float scalar) { return (Vector2d) super.divN(scalar); }
			public Vector2d divN(double scalar) { return (Vector2d) super.divN(scalar); }
			public Vector2d divN(float x, float y) { return (Vector2d) super.divN(x, y); }
			public Vector2d divN(double x, double y) { return (Vector2d) super.divN(x, y); }
			
			public Vector2d inverted() { return (Vector2d) super.inverted(); }
			
			public Vector2d normalized() { return (Vector2d) super.normalized(); }
		};
	}
	
}

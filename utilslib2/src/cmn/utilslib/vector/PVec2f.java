
package cmn.utilslib.vector;



/** 
 * A persistent representation of a vector2f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVec2f
{
	
	protected abstract float getX();
	protected abstract float getY();

	
	
	/** similar to {@link PVec2f#getNewVector} but generates only a new copy, when the old has been changed */
	public abstract Vec2f getVector();
	
	/** return always a new instance of the vector */
	public abstract Vec2f getNewVector();
	
	
	
	/** generates a new persistent vector2f */
	public static PVec2f gen(final float x, final float y)
	{
		return new PVec2f()
		{
			
			private Vec2f v;
			
			
			
			protected float getX() { return x; }
			protected float getY() { return y; }
			
			
			
			/** {@inheritDoc} */
			public Vec2f getNewVector() { return new Vec2f(x, y); }
			
			/** {@inheritDoc} */
			public Vec2f getVector()
			{
				if(v == null)
					return v = new Vec2f(x, y);
				else if(v.x != x || v.y != y)
					return v = new Vec2f(x, y);
				
				return v;
			}
			
		};
	}
	
}


package cmn.utilslib.vector;



/** 
 * A persistent representation of a vector3f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVec4f
{
	
	protected abstract float getX();
	protected abstract float getY();
	protected abstract float getZ();
	protected abstract float getA();

	
	
	/** similar to {@link PVec4f#getNewVector} but generates only a new copy, when the old has been changed */
	public abstract Vec4f getVector();
	
	/** return always a new instance of the vector */
	public abstract Vec4f getNewVector();
	
	
	
	/** generates a new persistent vector2f */
	public static PVec4f gen(final float x, final float y, final float z, final float a)
	{
		return new PVec4f()
		{
			
			private Vec4f v;
			
			
			
			protected float getX() { return x; }
			protected float getY() { return y; }
			protected float getZ() { return z; }
			protected float getA() { return a; }
			
			
			
			/** {@inheritDoc} */
			public Vec4f getNewVector() { return new Vec4f(x, y, z, a); }
			
			/** {@inheritDoc} */
			public Vec4f getVector()
			{
				if(v == null)
					return v = new Vec4f(x, y, z, a);
				else if(v.x != x || v.y != y || v.z != z || v.a != a)
					return v = new Vec4f(x, y, z, a);
				
				return v;
			}
			
		};
	}
	
}

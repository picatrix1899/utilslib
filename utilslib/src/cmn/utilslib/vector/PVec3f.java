
package cmn.utilslib.vector;



/** 
 * A persistent representation of a vector3f
 * @category Vector
 * @author picatrix1899
 */
public abstract class PVec3f
{
	
	protected abstract float getX();
	protected abstract float getY();
	protected abstract float getZ();

	
	
	/** similar to {@link PVec3f#getNewVector} but generates only a new copy, when the old has been changed */
	public abstract Vec3f getVector();
	
	/** return always a new instance of the vector */
	public abstract Vec3f getNewVector();
	
	
	
	/** generates a new persistent vector2f */
	public static PVec3f gen(final float x, final float y, final float z)
	{
		return new PVec3f()
		{
			
			private Vec3f v;
			
			protected float getX() { return x; }
			protected float getY() { return y; }
			protected float getZ() { return z; }
			
			
			
			/** {@inheritDoc} */
			public Vec3f getNewVector() { return new Vec3f(x, y, z); }
			
			/** {@inheritDoc} */
			public Vec3f getVector()
			{
				if(v == null)
					return v = new Vec3f(x, y, z);
				else if(v.x != x || v.y != y || v.z != z)
					return v = new Vec3f(x, y, z);
				
				return v;
			}
			
		};
	}
	
}

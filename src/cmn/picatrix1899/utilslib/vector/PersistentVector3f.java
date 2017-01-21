package cmn.picatrix1899.utilslib.vector;


public abstract class PersistentVector3f
{
	protected abstract float getX();
	protected abstract float getY();
	protected abstract float getZ();

	public abstract Vector3f getVector();
	public abstract Vector3f getNewVector();
	
	public static PersistentVector3f gen(final float x, final float y, final float z)
	{
		return new PersistentVector3f()
		{
			private Vector3f v;
			
			protected float getX() { return x; }
			protected float getY() { return y; }
			protected float getZ() { return z; }
			
			public Vector3f getNewVector() { return new Vector3f(x, y, z); }
			
			public Vector3f getVector()
			{
				if(v == null)
					return v = new Vector3f(x, y, z);
				else if(v.x != x || v.y != y || v.z != z)
					return v = new Vector3f(x, y, z);
				
				return v;
			}
		};
	}
}

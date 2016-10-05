package cmn.picatrix1899.utilslib.vector;


public abstract class PersistentVector3f
{
	protected abstract float getX();
	protected abstract float getY();
	protected abstract float getZ();
	
	
	
	public Vector3f asVector()
	{
		return new Vector3f(getX(),getY(),getZ());
	}
	
	public static PersistentVector3f gen(final float x, final float y, final float z)
	{
		return new PersistentVector3f()
		{
			protected float getX() { return x; }
			protected float getY() { return y; }
			protected float getZ() { return z; }
		};
	}
}

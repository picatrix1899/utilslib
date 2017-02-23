package cmn.picatrix1899.utilslib.vector;

/** 
 * 
 * @author picatrix1899
 *
 */
public abstract class PersistentVector2f
{
	protected abstract float getX();
	protected abstract float getY();
	
	
	
	public Vector2f asVector()
	{
		return new Vector2f(getX(),getY());
	}
	
	public static PersistentVector2f gen(final float x, final float y)
	{
		return new PersistentVector2f()
		{
			protected float getX() { return x; }
			protected float getY() { return y; }
		};
	}
}

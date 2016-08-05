package cmn.picatrix1899.utilslib.vector;


public class PersistentVector3f
{
	public final float x;
	public final float y;
	public final float z;

	public PersistentVector3f(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public PersistentVector3f(Vector3f v)
	{
		this.x = v.x;
		this.y = v.y;
		this.z = v.z;
	}
	
	public Vector3f asVector()
	{
		return new Vector3f(this.x, this.y, this.z);
	}
}

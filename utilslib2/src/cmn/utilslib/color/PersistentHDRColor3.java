package cmn.utilslib.color;


/**
 * 
 * A immutable HDR*-Color3.
 * <br>
 * <br>
 * *HDR = Hight Dynamic Range(-n to +n)
 * 
 * @author picatrix1899
 * 
 * @category color
 */
public abstract class PersistentHDRColor3 implements IColor3
{
	/** {@inheritDoc} */
	public float getUnityR() { return getR() / 255.0f; }
	
	/** {@inheritDoc} */
	public float getUnityG() { return getG() / 255.0f; }

	/** {@inheritDoc} */
	public float getUnityB() { return getB() / 255.0f; }

	
	
	public static PersistentHDRColor3 genUnity(final float r, final float g, final float b)
	{
		return gen(Math.round(r * 255.0f), Math.round(g * 255.0f), Math.round(b * 255.0f));
	}
	
	public static PersistentHDRColor3 gen(final int r, final int g, final int b)
	{
		return new PersistentHDRColor3()
		{
			/** {@inheritDoc} */
			public int getR() { return r; }	
			
			/** {@inheritDoc} */
			public int getG() { return g; }			
			
			/** {@inheritDoc} */
			public int getB() { return b; }
		};
	}
	
}

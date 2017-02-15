package cmn.picatrix1899.utilslib.color;

import cmn.picatrix1899.utilslib.interfaces.IColor4;

/**
 * 
 * A immutable HDR*-Color4.
 * <br>
 * <br>
 * *HDR = Hight Dynamic Range(-n to +n)
 * 
 * @author picatrix1899
 * 
 * @category color
 */
public abstract class PersistentHDRColor4 implements IColor4
{
	

	public float getUnityR() { return getR() / 255.0f; }
	
	/** {@inheritDoc} */
	public float getUnityG() { return getG() / 255.0f; }
	
	/** {@inheritDoc} */
	public float getUnityB() { return getB() / 255.0f; }
	
	/** {@inheritDoc} */
	public float getUnityA() { return getA() / 255.0f; }
	
	public static PersistentHDRColor4 genUnity(final float r, final float g, final float b, final float a)
	{
		return gen(Math.round(r * 255.0f), Math.round(g * 255.0f), Math.round(b * 255.0f), Math.round(a * 255.0f));
	}
	
	public static PersistentHDRColor4 gen(final int r, final int g, final int b, final int a)
	{
		return new PersistentHDRColor4()
		{
			/** {@inheritDoc} */
			public int getR() { return r; }			
			
			/** {@inheritDoc} */
			public int getG() { return g; }
			
			/** {@inheritDoc} */
			public int getB() { return b; }
			
			/** {@inheritDoc} */
			public int getA() { return a; }
		};
	}
}

package cmn.picatrix1899.utilslib.color;

import cmn.picatrix1899.utilslib.essentials.Maths;
import cmn.picatrix1899.utilslib.interfaces.IColor3;

/**
 * 
 * A immutable LDR*-Color3.
 * <br>
 * <br>
 * *LDR = Low Dynamic Range(fixed to 0-255)
 * 
 * @author picatrix1899
 * 
 * @category color
 */
public abstract class PersistentLDRColor3 implements IColor3
{
	
	/** {@inheritDoc} */
	public float getUnityR() { return Maths.clamp(getR() / 255.0f, 0.0f, 1.0f); }
	
	/** {@inheritDoc} */
	public float getUnityG() { return Maths.clamp(getG() / 255.0f, 0.0f, 1.0f); }

	/** {@inheritDoc} */
	public float getUnityB() { return Maths.clamp(getB() / 255.0f, 0.0f, 1.0f); }

	
	
	public static PersistentLDRColor3 genUnity(final float r, final float g, final float b)
	{
		return gen(Math.round(r * 255.0f), Math.round(g * 255.0f), Math.round(b * 255.0f));
	}
	
	public static PersistentLDRColor3 gen(final int r, final int g, final int b)
	{
		return new PersistentLDRColor3()
		{
			
			/** {@inheritDoc} */
			public int getR()
			{
				return Maths.clamp(r, 0, 255);
			}	
			
			/** {@inheritDoc} */
			public int getG()
			{
				return Maths.clamp(g, 0, 255);
			}			
			
			/** {@inheritDoc} */
			public int getB()
			{
				return Maths.clamp(b, 0, 255);
			}

		};
	}
	
}

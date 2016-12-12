package cmn.picatrix1899.utilslib.color;

import cmn.picatrix1899.utilslib.essentials.Maths;

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
	
	public float getUnityR() { return (int)Math.round(getR() / 255.0f); }
	
	public float getUnityG() { return (int)Math.round(getG() / 255.0f); }

	public float getUnityB() { return (int)Math.round(getB() / 255.0f); }

	
	
	public static PersistentLDRColor3 genUnity(final float r, final float g, final float b)
	{
		return gen(Math.round(r * 255.0f), Math.round(g * 255.0f), Math.round(b * 255.0f));
	}
	
	public static PersistentLDRColor3 gen(final int r, final int g, final int b)
	{
		return new PersistentLDRColor3()
		{
			
			public int getR()
			{
				return Maths.clamp(r, 0, 255);
			}	
			
			public int getG()
			{
				return Maths.clamp(g, 0, 255);
			}			
			
			public int getB()
			{
				return Maths.clamp(b, 0, 255);
			}

		};
	}
	
}

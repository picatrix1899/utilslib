package cmn.picatrix1899.utilslib.color;

import cmn.picatrix1899.utilslib.essentials.Maths;

public abstract class PersistentLDRColor3 implements Color3
{
	
	/**
	 * Gets the red component as interger component(range from 0 to 255) 
	 * 
	 * @return The red component as interger component value(range from 0 to 255)
	 */
	public int getR() { return (int)Math.round(getR() * 255); }
	/**
	 * Gets the green component as interger component(range from 0 to 255)
	 * 
	 * @return The green component as interger component value(range from 0 to 255)
	 */
	public int getG() { return (int)Math.round(getG() * 255); }
	/**
	 * Gets the blue component as interger component(range from 0 to 255)
	 * 
	 * @return The blue component as interger component value(range from 0 to 255)
	 */
	public int getB() { return (int)Math.round(getB() * 255); }
	
	public static PersistentLDRColor3 gen(final int r, final int g, final int b)
	{
		return genUnity(r / 255.0f, g / 255.0f, b / 255.0f);
	}
	
	public static PersistentLDRColor3 genUnity(final float r, final float g, final float b)
	{
		return new PersistentLDRColor3()
		{
			
			public float getUnityB()
			{
				return Maths.clamp(b, 0.0f, 1.0f);
			}
			public float getUnityG()
			{
				return Maths.clamp(g, 0.0f, 1.0f);
			}
			public float getUnityR()
			{
				return Maths.clamp(r, 0.0f, 1.0f);
			}
			
		};
	}
}

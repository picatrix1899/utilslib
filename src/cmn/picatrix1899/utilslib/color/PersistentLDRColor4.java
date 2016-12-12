package cmn.picatrix1899.utilslib.color;

import cmn.picatrix1899.utilslib.essentials.Maths;

public abstract class PersistentLDRColor4 implements Color3, Color4
{
	
	/**
	 * Gets the red component as interger component(range from 0 to 255) 
	 * 
	 * @return The red component as interger component value(range from 0 to 255)
	 */
	public float getUnityR() { return (int)Math.round(getR() / 255.0f); }
	
	/**
	 * Gets the green component as interger component(range from 0 to 255)
	 * 
	 * @return The green component as interger component value(range from 0 to 255)
	 */
	public float getUnityG() { return (int)Math.round(getG() / 255.0f); }
	
	/**
	 * Gets the blue component as interger component(range from 0 to 255)
	 * 
	 * @return The blue component as interger component value(range from 0 to 255)
	 */
	public float getUnityB() { return (int)Math.round(getB() / 255.0f); }
	
	/**
	 * Gets the blue component as interger component(range from 0 to 255)
	 * 
	 * @return The blue component as interger component value(range from 0 to 255)
	 */
	public float getUnityA() { return (int)Math.round(getA() / 255.0f); }
	
	public static PersistentLDRColor4 genUnity(final float r, final float g, final float b, final float a)
	{
		return gen(Math.round(r * 255.0f), Math.round(g * 255.0f), Math.round(b * 255.0f), Math.round(a * 255.0f));
	}
	
	public static PersistentLDRColor4 gen(final int r, final int g, final int b, final int a)
	{
		return new PersistentLDRColor4()
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
			
			public int getA()
			{
				return Maths.clamp(a, 0, 255);
			}
			
		};
	}
}

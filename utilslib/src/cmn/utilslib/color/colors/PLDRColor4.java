
package cmn.utilslib.color.colors;



import cmn.utilslib.color.colors.api.ILDRColor4Base;

import cmn.utilslib.essentials.Maths;



/**
 * An immutable LDR*-Color4.
 * <br>
 * <br>
 * *LDR = Low Dynamic Range(fixed to 0-255)
 * @author picatrix1899
 * @category Color
 */
public abstract class PLDRColor4 implements ILDRColor4Base
{
	
	public abstract LDRColor4 clone();
	
	
	
	/**
	 * Generates a new persistent Color3 based on 3 unity-range values.
	 * @param r : The red component as a unity-range value.
	 * @param g : The green component as a unity-range value.
	 * @param b : The blue component as a unity-range value.
	 * @param a : The alpha component as a unity-range value.
	 * @return A persistent Color3.
	 */
	public static PLDRColor4 genUnity(final float r, final float g, final float b, final float a)
	{
		return gen(Math.round(r * 255.0f), Math.round(g * 255.0f), Math.round(b * 255.0f), Math.round(a * 255.0f));
	}
	
	
	
	/**
	 * Generates a new persistent Color3 based on 3 color-range values.
	 * @param r : The red component as a color-range value.
	 * @param g : The green component as a color-range value.
	 * @param b : The blue component as a color-range value.
	 * @param a : The alpha component as a color-range value.
	 * @return A persistent Color3.
	 */
	public static PLDRColor4 gen(final int r, final int g, final int b, final int a)
	{
		return new PLDRColor4()
		{
			
			/** {@inheritDoc} */
			public int getR() { return Maths.clamp(r, 0, 255); }			
			/** {@inheritDoc} */
			public int getG() { return Maths.clamp(g, 0, 255); }
			/** {@inheritDoc} */
			public int getB() { return Maths.clamp(b, 0, 255); }
			/** {@inheritDoc} */
			public int getA() { return Maths.clamp(a, 0, 255); }

		
			
			public String toString()
			{
				return "ldr-persistent-color4(" + getR() + ", " + getG() + ", " + getB() + ", " + getA() + ")";
 			}
			
			
			
			@Override
			public LDRColor4 clone()
			{
				return null;
			}
			
		};
	}
	
}

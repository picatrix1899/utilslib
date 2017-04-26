
package cmn.utilslib.color.colors;



import cmn.utilslib.color.colors.api.ILDRColor3Base;
import cmn.utilslib.essentials.Maths;



/**
 * An immutable LDR*-Color3.
 * <br>
 * <br>
 * *LDR = Low Dynamic Range(fixed to 0-255)
 * @author picatrix1899
 * @category Color
 */
public abstract class PLDRColor3 implements ILDRColor3Base
{

	public abstract LDRColor3 clone();
	
	/**
	 * Generates a new persistent Color3 based on 3 unity-range values.
	 * @param r : The red component as a unity-range value.
	 * @param g : The green component as a unity-range value.
	 * @param b : The blue component as a unity-range value.
	 * @return A persistent Color3.
	 */
	public static PLDRColor3 genUnity(final float r, final float g, final float b)
	{
		return gen(Math.round(r * 255.0f), Math.round(g * 255.0f), Math.round(b * 255.0f));
	}
	
	
	/**
	 * Generates a new persistent Color3 based on 3 color-range values.
	 * @param r : The red component as a color-range value.
	 * @param g : The green component as a color-range value.
	 * @param b : The blue component as a color-range value.
	 * @return A persistent Color3.
	 */
	public static PLDRColor3 gen(final int r, final int g, final int b)
	{
		
		return new PLDRColor3()
		{
			/** {@inheritDoc} */ @Override
			public int getR() { return Maths.clamp(r, 0, 255); }	
			/** {@inheritDoc} */ @Override
			public int getG() { return Maths.clamp(g, 0, 255); }			
			/** {@inheritDoc} */ @Override
			public int getB() { return Maths.clamp(b, 0, 255); }

			@Override
			public String toString() { return "ldr-persistent-color3(" + getR() + ", " + getG() + ", " + getB() + ")"; }
			
			@Override
			public LDRColor3 clone() { return new LDRColor3(getR(), getG(), getB()); }
		};
		
	}
	
}

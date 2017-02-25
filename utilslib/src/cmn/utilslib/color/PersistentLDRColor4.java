
package cmn.utilslib.color;



import cmn.utilslib.essentials.Maths;



/**
 * An immutable LDR*-Color4.
 * <br>
 * <br>
 * *LDR = Low Dynamic Range(fixed to 0-255)
 * @author picatrix1899
 * @category Color
 */
public abstract class PersistentLDRColor4 implements IColor4Base
{
	
	/** {@inheritDoc} */
	public float getUnityR() { return Maths.clamp(getR() / 255.0f, 0.0f, 1.0f); }
	
	/** {@inheritDoc} */
	public float getUnityG() { return Maths.clamp(getG() / 255.0f, 0.0f, 1.0f); }
	
	/** {@inheritDoc} */
	public float getUnityB() { return Maths.clamp(getB() / 255.0f, 0.0f, 1.0f); }
	
	/** {@inheritDoc} */
	public float getUnityA() { return (int)Math.round(getA() / 255.0f); }
	
	
	
	/**
	 * Generates a new persistent Color3 based on 3 unity-range values.
	 * @param r : The red component as a unity-range value.
	 * @param g : The green component as a unity-range value.
	 * @param b : The blue component as a unity-range value.
	 * @param a : The alpha component as a unity-range value.
	 * @return A persistent Color3.
	 */
	public static PersistentLDRColor4 genUnity(final float r, final float g, final float b, final float a)
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
	public static PersistentLDRColor4 gen(final int r, final int g, final int b, final int a)
	{
		
		return new PersistentLDRColor4()
		{
			/** {@inheritDoc} */
			public int getR() { return Maths.clamp(r, 0, 255); }			
			
			/** {@inheritDoc} */
			public int getG() { return Maths.clamp(g, 0, 255); }
			
			/** {@inheritDoc} */
			public int getB() { return Maths.clamp(b, 0, 255); }
			
			/** {@inheritDoc} */
			public int getA() { return Maths.clamp(a, 0, 255); }
		};
		
	}
	
}


package cmn.utilslib.color.colors;



import cmn.utilslib.color.colors.api.IHDRColor4Base;



/**
 * An immutable HDR*-Color4.
 * <br>
 * <br>
 * *HDR = Hight Dynamic Range(-n to +n)
 * @author picatrix1899
 * @category Color
 */
public abstract class PHDRColor4 implements IHDRColor4Base
{

	public abstract HDRColor4 clone();
	
	
	
	/**
	 * Generates a new persistent Color3 based on 3 unity-range values.
	 * @param r : The red component as a unity-range value.
	 * @param g : The green component as a unity-range value.
	 * @param b : The blue component as a unity-range value.
	 * @param a : The alpha component as a unity-range value.
	 * @return A persistent Color3.
	 */
	public static IHDRColor4Base genUnity(final float r, final float g, final float b, final float a)
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
	public static IHDRColor4Base gen(final int r, final int g, final int b, final int a)
	{
		return new PHDRColor4()
		{
			
			/** {@inheritDoc} */ @Override
			public int getR() { return r; }			
			/** {@inheritDoc} */ @Override
			public int getG() { return g; }
			/** {@inheritDoc} */ @Override
			public int getB() { return b; }
			/** {@inheritDoc} */ @Override
			public int getA() { return a; }

			
			
			public String toString()
			{
				return "hdr-persistent-color4(" + getR() + ", " + getG() + ", " + getB() + ", " + getA() + ")";
 			}
			
			
			
			@Override
			public HDRColor4 clone()
			{
				return new HDRColor4(getR(), getG(), getB(), getA());
			}
			
		};
	}
	
}

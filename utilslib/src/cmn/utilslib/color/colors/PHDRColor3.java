
package cmn.utilslib.color.colors;



import cmn.utilslib.color.colors.api.IHDRColor3Base;



/**
 * An immutable HDR*-Color3.
 * <br>
 * <br>
 * *HDR = Hight Dynamic Range(-n to +n)
 * @author picatrix1899
 * @category Color
 */
public abstract class PHDRColor3 implements IHDRColor3Base
{

	public abstract HDRColor3 clone();
	
	
	
	/**
	 * Generates a new persistent Color3 based on 3 unity-range values.
	 * @param r : The red component as a unity-range value.
	 * @param g : The green component as a unity-range value.
	 * @param b : The blue component as a unity-range value.
	 * @return A persistent Color3.
	 */
	public static IHDRColor3Base genUnity(final float r, final float g, final float b)
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
	public static IHDRColor3Base gen(final int r, final int g, final int b)
	{
		return new PHDRColor3()
		{
			
			/** {@inheritDoc} */ @Override
			public int getR() { return r; }	
			/** {@inheritDoc} */ @Override
			public int getG() { return g; }			
			/** {@inheritDoc} */ @Override
			public int getB() { return b; }

			
			
			@Override
			public String toString() { return "hdr-persistent-color3(" + getR() + ", " + getG() + ", " + getB() + ")"; }
		
			
			
			@Override
			public HDRColor3 clone() { return new HDRColor3(getR(), getG(), getB()); }
			
		};
	}
	
}

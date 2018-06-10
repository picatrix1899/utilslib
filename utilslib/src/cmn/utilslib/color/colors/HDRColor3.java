
package cmn.utilslib.color.colors;



import java.io.Serializable;

import cmn.utilslib.color.colors.api.IColor3Base;
import cmn.utilslib.color.colors.api.IHDRColor3;
import cmn.utilslib.color.colors.api.IHDRColor3Base;



/**
 * Represents a color with 3 components.
 * @author picatrix1899
 * @category Color
 */
public class HDRColor3 implements IHDRColor3, Serializable
{

	/** the minimum value. */
	public static final int DEFAULT_MIN = 0;
	/** the maximum value. */
	public static final int DEFAULT_MAX = 255;	
	
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	private int r = 0;
	private int g = 0;
	private int b = 0;
	
	
	
	/**
	 * Plain Constructor with initial white color.
	 */
	public HDRColor3() { this(HDRColor3.DEFAULT_MAX, HDRColor3.DEFAULT_MAX, HDRColor3.DEFAULT_MAX); }
	/**
	 * Constructor with 3 initial color-range components.
	 * @param r : The red component as a color-range value.
	 * @param g : The green component as a color-range value.
	 * @param b : The blue component as a color-range value.
	 */
	public HDRColor3(int r, int g, int b) { setR(r).setG(g).setB(b); }
	/**
	 * Constructor with 3 initial unity-range components.
	 * @param r : The red component as an unity-range value.
	 * @param g : The green component as an unity-range value.
	 * @param b : The blue component as an unity-range value.
	 */
	public HDRColor3(float r, float g, float b) { setUnityR(r).setUnityG(g).setUnityB(b); }
	/**
	 * Clone Constructor.
	 * @param color : The color to clone.
	 */
	public HDRColor3(IColor3Base color) { set(color); }
	
	
	
	/** {@inheritDoc} */ @Override
	public int getR() { return this.r; }
	/** {@inheritDoc} */ @Override
	public int getG() { return this.g; }
	/** {@inheritDoc} */ @Override
	public int getB() { return this.b; }

	
		
	/** {@inheritDoc}} */ @Override
	public HDRColor3 setR(int r) { this.r = r; return this; }
	/** {@inheritDoc}} */ @Override
	public HDRColor3 setG(int g) { this.g = g; return this; }
	/** {@inheritDoc}} */ @Override
	public HDRColor3 setB(int b) { this.b = b; return this; }

	/** {@inheritDoc}} */ @Override
	public HDRColor3 setUnityR(float r) { return setR(Math.round(r * 255.0f)); }
	/** {@inheritDoc}} */ @Override
	public HDRColor3 setUnityG(float g) { return setG(Math.round(g * 255.0f)); }
	/** {@inheritDoc}} */ @Override
	public HDRColor3 setUnityB(float b) { return setB(Math.round(b * 255.0f)); }
	
	
	/** {@inheritDoc}} */ @Override
	public HDRColor3 set(int brightness) { return setR(brightness).setG(brightness).setB(brightness); }
	/** {@inheritDoc}} */ @Override
	public HDRColor3 set(IColor3Base color) { return setR(color.getR()).setG(color.getG()).setB(color.getB()); }
	/** {@inheritDoc}} */ @Override
	public HDRColor3 set(int r, int g, int b) { return setR(r).setG(g).setB(b); }
	
	
	/** {@inheritDoc}} */ @Override
	public HDRColor3 setUnity(float brightness) { return setUnityR(brightness).setUnityG(brightness).setUnityB(brightness); }
	/** {@inheritDoc}} */ @Override
	public HDRColor3 setUnity(float r, float g, float b) { return setUnityR(r).setUnityG(g).setUnityB(b); }
	
	
	/** {@inheritDoc} */ @Override
	public HDRColor3 clone() { return new HDRColor3(this); }
	
	
	
	/** {@inheritDoc} */ @Override
	public String toString() { return "hdr-color3(" + getR() + ", " + getG() + ", " + getB() + ")"; }
	
	
	
	/** {@inheritDoc} */ @Override
	public boolean equals(Object o)
	{
		if(o instanceof HDRColor3)
		{
			IHDRColor3Base c = (IHDRColor3Base)o;
			if(c.getR() != this.getR()) return false;
			if(c.getG() != this.getG()) return false;
			if(c.getB() != this.getB()) return false;			
			
			return true;
		}
	
		return false;
	}
	
}

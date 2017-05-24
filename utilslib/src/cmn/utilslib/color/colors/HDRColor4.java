
package cmn.utilslib.color.colors;



import java.io.Serializable;

import cmn.utilslib.color.colors.api.IColor4Base;
import cmn.utilslib.color.colors.api.IHDRColor4;
import cmn.utilslib.color.colors.api.IHDRColor4Base;



/**
 * Represents a color with 4 components.
 * @author picatrix1899
 * @category Color
 */
public class HDRColor4 implements  IHDRColor4, Serializable
{
	
	/** the minimum value. */
	public static final int DEFAULT_MIN = 0;
	/** the maximum value. */
	public static final int DEFAULT_MAX = 255;
	
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	private int r = 0;
	private int g = 0;
	private int b = 0;
	private int a = 0;
	
	
	
	/**
	 * Plain Constructor with initial white color
	 */
	public HDRColor4() { this(HDRColor4.DEFAULT_MAX, HDRColor4.DEFAULT_MAX, HDRColor4.DEFAULT_MAX, HDRColor4.DEFAULT_MAX); }
	/**
	 * Constructor with 4 initial components
	 * @param r : The red component
	 * @param g : The green component
	 * @param b : The blue component
	 * @param a : THe alpha component
	 */
	public HDRColor4(int r, int g, int b, int a) { set(r, g, b, a); }
	/**
	 * Constructor with 4 initial components
	 * @param r : The red component
	 * @param g : The green component
	 * @param b : The blue component
	 * @param a : The alpha component
	 */
	public HDRColor4(float r, float g, float b, float a) { setUnity(r, g, b, a); }
	/**
	 * Clone Constructor
	 * @param color : The color to clone
	 */
	public HDRColor4(IColor4Base color) { set(color); }
	
	
	
	/** {@inheritDoc}} */ @Override
	public IHDRColor4 setR(int r) { this.r = r; return this; }
	/** {@inheritDoc}} */ @Override
	public IHDRColor4 setG(int g) { this.g = g; return this; }
	/** {@inheritDoc}} */ @Override
	public IHDRColor4 setB(int b) { this.b = b; return this; }
	/** {@inheritDoc}} */ @Override
	public IHDRColor4 setA(int a) { this.a = a; return this; }
	
	

	/** {@inheritDoc} */ @Override
	public int getR() { return this.r; }
	/** {@inheritDoc} */ @Override
	public int getG() { return this.g; }
	/** {@inheritDoc} */ @Override
	public int getB() { return this.b; }
	/** {@inheritDoc} */ @Override
	public int getA() { return this.a; }
	


	/** {@inheritDoc} */ @Override
	public IHDRColor4 clone() { return new HDRColor4(this); }
	
	
	
	/** {@inheritDoc} */ @Override
	public String toString() { return "hdr-color4(" + getR() + ", " + getG() + ", " + getB() + ", " + getA() + ")"; }
	
	
	
	/** {@inheritDoc} */ @Override
	public boolean equals(Object o)
	{
		if(o instanceof HDRColor4)
		{
			IHDRColor4Base c = (IHDRColor4Base)o;
			if(c.getR() != this.getR()) return false;
			if(c.getG() != this.getG()) return false;
			if(c.getB() != this.getB()) return false;
			if(c.getA() != this.getA()) return false;
			
			return true;
		}
		
		return false;
	}

}

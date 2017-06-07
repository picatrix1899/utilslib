
package cmn.utilslib.color.colors;



import java.io.Serializable;

import cmn.utilslib.color.colors.api.IColor3Base;
import cmn.utilslib.color.colors.api.ILDRColor3;
import cmn.utilslib.math.Maths;



/**
 * Represents a color with 3 components.
 * @author picatrix1899
 * @category Color
 */
public class LDRColor3 implements ILDRColor3, Serializable
{

	/** the minimum value */
	public static final int MIN = 0;
	/** the maximum value */
	public static final int MAX = 255;
	
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	private int r = 0;
	private int g = 0;
	private int b = 0;
	
	
	
	/**
	 * Plain Constructor with initial white color.
	 */
	public LDRColor3() { this(LDRColor3.MAX, LDRColor3.MAX, LDRColor3.MAX); }
	/**
	 * Constructor with 3 initial color-range components.
	 * @param r : The red component as a color-range value.
	 * @param g : The green component as a color-range value.
	 * @param b : The blue component as a color-range value.
	 */
	public LDRColor3(int r, int g, int b) { setR(r).setG(g).setB(b); }
	/**
	 * Constructor with 3 initial unity-range components.
	 * @param r : The red component as an unity-range value.
	 * @param g : The green component as an unity-range value.
	 * @param b : The blue component as an unity-range value.
	 */
	public LDRColor3(float r, float g, float b) { setUnityR(r).setUnityG(g).setUnityB(b); }
	/**
	 * Clone Constructor.
	 * @param color : The color to clone.
	 */
	public LDRColor3(IColor3Base color) { set(color); }
	
	

	/** {@inheritDoc} */ @Override
	public ILDRColor3 setR(int r) { this.r = Maths.clamp(r, LDRColor3.MIN, LDRColor3.MAX); return this; }
	/** {@inheritDoc} */ @Override
	public ILDRColor3 setG(int g) { this.g = Maths.clamp(g, LDRColor3.MIN, LDRColor3.MAX); return this; }
	/** {@inheritDoc} */ @Override
	public ILDRColor3 setB(int b) { this.b = Maths.clamp(b, LDRColor3.MIN, LDRColor3.MAX); return this; }
	

	
	/** {@inheritDoc} */ @Override
	public int getR() { return this.r; }
	/** {@inheritDoc} */ @Override
	public int getG() { return this.g; }
	/** {@inheritDoc} */ @Override
	public int getB() { return this.b; }
	
	

	@Override
	public ILDRColor3 clone() { return new LDRColor3(this); }
	
	
	
	/** {@inheritDoc} */ @Override
	public String toString()
	{
		return "ldr-color3(" + getR() + ", " + getG() + ", " + getB() + ")";
	}
	
	
	
	/** {@inheritDoc} */ @Override
	public boolean equals(Object o)
	{
		if(o instanceof LDRColor3)
		{
			IColor3Base c = (IColor3Base)o;
			if(c.getR() != this.getR()) return false;
			if(c.getG() != this.getG()) return false;
			if(c.getB() != this.getB()) return false;
			
			return true;
		}
		
		return false;
	}

}

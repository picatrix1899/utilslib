
package cmn.utilslib.color.colors;


import java.io.Serializable;

import cmn.utilslib.color.colors.api.IColor4Base;
import cmn.utilslib.color.colors.api.ILDRColor4;
import cmn.utilslib.essentials.Maths;
import cmn.utilslib.interfaces.IStreamable;



/**
 * Represents a color with 4 components.
 * @author picatrix1899
 * @category Color
 */

public class LDRColor4 implements ILDRColor4, IStreamable, Serializable

{

	private static final long serialVersionUID = 1L;

	/**
	 * the minimum value
	 */
	public static final int MIN = 0;
	/**
	 * the maximum value
	 */
	public static final int MAX = 255;
	
	
	
	private int r = 0;
	private int g = 0;
	private int b = 0;
	private int a = 0;
	
	
	
	/**
	 * Plain Constructor with initial white color
	 */
	public LDRColor4() { this(LDRColor4.MAX, LDRColor4.MAX, LDRColor4.MAX, LDRColor4.MAX); }
	
	/**
	 * Constructor with 4 initial components
	 * @param r : The red component
	 * @param g : The green component
	 * @param b : The blue component
	 * @param a : THe alpha component
	 */
	public LDRColor4(int r, int g, int b, int a) { set(r, g, b, a); }
	
	/**
	 * Constructor with 4 initial components
	 * @param r : The red component
	 * @param g : The green component
	 * @param b : The blue component
	 * @param a : The alpha component
	 */
	public LDRColor4(float r, float g, float b, float a) { setUnity(r, g, b, a); }
	
	
	
	/**
	 * Clone Constructor
	 * @param color : The color to clone
	 */
	public LDRColor4(IColor4Base color) { set(color); }
	
	
	/** {@inheritDoc} */ @Override
	public LDRColor4 setR(int r) { this.r = Maths.clamp(r, LDRColor4.MIN, LDRColor4.MAX); return this; }
	/** {@inheritDoc} */ @Override
	public LDRColor4 setG(int g) { this.g = Maths.clamp(g, LDRColor4.MIN, LDRColor4.MAX); return this; }
	/** {@inheritDoc} */ @Override
	public LDRColor4 setB(int b) { this.b = Maths.clamp(b, LDRColor4.MIN, LDRColor4.MAX); return this; }
	/** {@inheritDoc} */ @Override
	public LDRColor4 setA(int a) { this.a = Maths.clamp(a, LDRColor4.MIN, LDRColor4.MAX); return this; }
	

	/** {@inheritDoc} */ @Override
	public int getR() { return this.r; }
	/** {@inheritDoc} */ @Override
	public int getG() { return this.g; }
	/** {@inheritDoc} */ @Override
	public int getB() { return this.b; }
	/** {@inheritDoc} */ @Override
	public int getA() { return this.a; }

	
	/** {@inheritDoc} */ @Override
	public LDRColor4 clone() { return new LDRColor4(this); }
	
	/** {@inheritDoc} */ @Override
	public String toString() { return "ldr-color4(" + getR() + ", " + getG() + ", " + getB() + ", " + getA() + ")"; }
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof LDRColor4)
		{
			IColor4Base c = (IColor4Base)o;
			if(c.getR() != this.getR()) return false;
			if(c.getG() != this.getG()) return false;
			if(c.getB() != this.getB()) return false;
			if(c.getA() != this.getA()) return false;
			
			return true;			
		}
		
		return false;
	}


}

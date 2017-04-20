
package cmn.utilslib.color.colors;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.Serializable;

import cmn.utilslib.color.colors.api.IColor3Base;
import cmn.utilslib.color.colors.api.IHDRColor3;
import cmn.utilslib.interfaces.IObjectable;
import cmn.utilslib.interfaces.IStreamable;



/**
 * Represents a color with 3 components.
 * @author picatrix1899
 * @category Color
 */
public class HDRColor3 implements IHDRColor3, IStreamable, Serializable, IObjectable<HDRColor3>
{
	
	/** Default white color. */
	public static final PHDRColor3 WHITE	=		PHDRColor3.gen(255, 255, 255);
	/** Default black color. */
	public static final PHDRColor3 BLACK	=		PHDRColor3.gen(000, 000, 000);
	/** Default red color. */
	public static final PHDRColor3 RED		=		PHDRColor3.gen(255, 000, 000);
	/** Default green color. */
	public static final PHDRColor3 GREEN	=		PHDRColor3.gen(000, 255, 000);
	/** Default blue color. */
	public static final PHDRColor3 BLUE	=			PHDRColor3.gen(000, 000, 255);
	/** Default yellow color. */
	public static final PHDRColor3 YELLOW	=		PHDRColor3.gen(255, 255, 000);
	
	
	
	/** Number of components. */
	public static final int DIMENSIONS = 3;
	
	
	
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
	
	
	
	/** {@inheritDoc}} */
	@Override
	public HDRColor3 set(IColor3Base color) { return setR(color.getR()).setG(color.getG()).setB(color.getB()); }
	
	
	
	/** {@inheritDoc}} */
	@Override
	public HDRColor3 setUnity(float r, float g, float b) { return setUnityR(r).setUnityG(g).setUnityB(b); }
	
	/** {@inheritDoc}} */
	@Override
	public HDRColor3 set(int r, int g, int b) { return setR(r).setG(g).setB(b); }
	
	
	
	/** {@inheritDoc}} */
	@Override
	public HDRColor3 setR(int r) { this.r = r; return this; }
	
	/** {@inheritDoc}} */
	@Override
	public HDRColor3 setG(int g) { this.g = g; return this; }
	
	/** {@inheritDoc}} */
	@Override
	public HDRColor3 setB(int b) { this.b = b; return this; }
	
	
	
	/** {@inheritDoc}} */
	@Override
	public HDRColor3 setUnityR(float r) { setR(Math.round(r * 255.0f)); return this; }
	
	/** {@inheritDoc}} */
	@Override
	public HDRColor3 setUnityG(float g) { setG(Math.round(g / 255.0f)); return this; }
	
	/** {@inheritDoc}} */
	@Override
	public HDRColor3 setUnityB(float b) { setB(Math.round(b / 255.0f)); return this; }
	
	
	
	/** {@inheritDoc} */
	@Override
	public int getR() { return this.r; }
	
	/** {@inheritDoc} */
	@Override
	public int getG() { return this.g; }
	
	/** {@inheritDoc} */
	@Override
	public int getB() { return this.b; }
	
	
	
	/** {@inheritDoc} */
	@Override
	public float getUnityR() { return getR() / 255.0f; }
	
	/** {@inheritDoc} */
	@Override
	public float getUnityG() { return getG() / 255.0f; }
	
	/** {@inheritDoc} */
	@Override
	public float getUnityB() { return getB() / 255.0f; }
	
	
	
	/** {@inheritDoc} */
	@Override
	public HDRColor3 clone() { return new HDRColor3(this); }
	
	/** {@inheritDoc} */
	@Override
	public String toString() { return "color3(" + getR() + ", " + getG() + ", " + getB() + ")"; }
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object o)
	{
		if(!(o instanceof IColor3Base)) return false;
		if(!(o instanceof HDRColor3) || !(o instanceof PHDRColor3)) return false;
		
		IColor3Base c = (IColor3Base)o;
		if(c.getR() != this.getR()) return false;
		if(c.getG() != this.getG()) return false;
		if(c.getB() != this.getB()) return false;
		
		return true;
	}
	
	
	
	/** {@inheritDoc} */
	@Override
	public void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		setR(dis.readInt());
		setG(dis.readInt());
		setB(dis.readInt());
	}

	/** {@inheritDoc} */
	@Override
	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeInt(getR());
		dos.writeInt(getG());
		dos.writeInt(getB());
	}
	
}

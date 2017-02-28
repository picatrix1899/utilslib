
package cmn.utilslib.color;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.Serializable;

import cmn.utilslib.interfaces.IObjectable;
import cmn.utilslib.interfaces.IStreamable;



/**
 * Represents a color with 4 components.
 * @author picatrix1899
 * @category Color
 */
public class HDRColor4 implements  IColor4<HDRColor4>, IStreamable, Serializable, IObjectable<HDRColor4>
{
	/**  */
	public static final PersistentHDRColor4 WHITE =		PersistentHDRColor4.gen(255, 255, 255, 255);
	/**  */
	public static final PersistentHDRColor4 BLACK =		PersistentHDRColor4.gen(000, 000, 000, 255);
	/**  */
	public static final PersistentHDRColor4 RED =		PersistentHDRColor4.gen(255, 000, 000, 255);
	/**  */
	public static final PersistentHDRColor4 GREEN =		PersistentHDRColor4.gen(000, 255, 000, 255);
	/**  */
	public static final PersistentHDRColor4 BLUE =		PersistentHDRColor4.gen(000, 000, 255, 255);
	/**  */
	public static final PersistentHDRColor4 YELLOW =	PersistentHDRColor4.gen(255, 255, 000, 255);
	
	
	
	/** Number of components. */
	public static final int DIMENSIONS = 4;
	
	
	
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
	
	
	
	/** {@inheritDoc}} */
	@Override
	public HDRColor4 set(IColor4Base color) { return setR(color.getR()).setG(color.getG()).setB(color.getB()).setA(color.getA()); }
	
	
	
	/** {@inheritDoc}} */
	@Override
	public HDRColor4 setUnity(float r, float g, float b, float a) { return setUnityR(r).setUnityG(g).setUnityB(b).setUnityA(a); }
	
	/** {@inheritDoc}} */
	@Override
	public HDRColor4 set(int r, int g, int b, int a) { return setR(r).setG(g).setB(b).setA(a); }
	

	
	/** {@inheritDoc}} */
	@Override
	public HDRColor4 setR(int r) { this.r = r; return this; }

	/** {@inheritDoc}} */
	@Override
	public HDRColor4 setG(int g) { this.g = g; return this; }
	
	/** {@inheritDoc}} */
	@Override
	public HDRColor4 setB(int b) { this.b = b; return this; }
	
	/** {@inheritDoc}} */
	@Override
	public HDRColor4 setA(int a) { this.a = a; return this; }
	
	
	
	/** {@inheritDoc}} */
	@Override
	public HDRColor4 setUnityR(float r) { setR(Math.round(r * 255.0f)); return this; }

	/** {@inheritDoc}} */
	@Override
	public HDRColor4 setUnityG(float g) { setG(Math.round(g / 255.0f)); return this; }

	/** {@inheritDoc}} */
	@Override
	public HDRColor4 setUnityB(float b) { setB(Math.round(b / 255.0f)); return this; }
	
	/** {@inheritDoc}} */
	@Override
	public HDRColor4 setUnityA(float a) { setB(Math.round(a / 255.0f)); return this; }
	
	
	
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
	public int getA() { return this.a; }
	
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
	public float getUnityA() { return getA() / 255.0f; }
	

	
	/** {@inheritDoc} */
	@Override
	public HDRColor4 clone() { return new HDRColor4(this); }
	
	/** {@inheritDoc} */
	@Override
	public String toString()
	{
		return "color3(" + getR() + ", " + getG() + ", " + getB() + ", " + getA() + ")";
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object o)
	{
		if(!(o instanceof IColor4Base)) return false;
		if(!(o instanceof HDRColor4) || !(o instanceof PersistentLDRColor3)) return false;
		
		IColor4Base c = (IColor4Base)o;
		if(c.getR() != this.getR()) return false;
		if(c.getG() != this.getG()) return false;
		if(c.getB() != this.getB()) return false;
		if(c.getA() != this.getA()) return false;
		
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
		setA(dis.readInt());
	}

	/** {@inheritDoc} */
	@Override
	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeInt(getR());
		dos.writeInt(getG());
		dos.writeInt(getB());
		dos.writeInt(getA());
	}

}
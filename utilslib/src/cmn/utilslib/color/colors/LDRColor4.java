
package cmn.utilslib.color.colors;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.Serializable;

import cmn.utilslib.color.colors.api.IColor4Base;
import cmn.utilslib.color.colors.api.ILDRColor4;
import cmn.utilslib.essentials.Maths;
import cmn.utilslib.interfaces.IStreamable;
import cmn.utilslib.interfaces.IObjectable;



/**
 * Represents a color with 4 components.
 * @author picatrix1899
 * @category Color
 */
public class LDRColor4 implements ILDRColor4<LDRColor4>, IStreamable, Serializable, IObjectable<LDRColor4>
{

	private static final long serialVersionUID = 1L;
	/**  */
	public static final PLDRColor4 WHITE =		PLDRColor4.gen(255, 255, 255, 255);
	/**  */
	public static final PLDRColor4 BLACK =		PLDRColor4.gen(000, 000, 000, 255);
	/**  */
	public static final PLDRColor4 RED =		PLDRColor4.gen(255, 000, 000, 255);
	/**  */
	public static final PLDRColor4 GREEN =		PLDRColor4.gen(000, 255, 000, 255);
	/**  */
	public static final PLDRColor4 BLUE =		PLDRColor4.gen(000, 000, 255, 255);
	/**  */
	public static final PLDRColor4 YELLOW =		PLDRColor4.gen(255, 255, 000, 255);
	
	
	
	/**
	 * Number of components
	 */
	public static final int DIMENSIONS = 3;
	
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
	
	
	
	/** {@inheritDoc} */
	@Override
	public LDRColor4 set(IColor4Base color) { return setR(color.getR()).setG(color.getG()).setB(color.getB()).setA(color.getA()); }
	
	
	
	/** {@inheritDoc} */
	@Override
	public LDRColor4 setUnity(float r, float g, float b, float a) { return setUnityR(r).setUnityG(g).setUnityB(b).setUnityA(a); }
	
	/** {@inheritDoc} */
	@Override
	public LDRColor4 set(int r, int g, int b, int a) { return setR(r).setG(g).setB(b).setA(a); }
	

	
	/** {@inheritDoc} */
	@Override
	public LDRColor4 setR(int r) { this.r = Maths.clamp(r, LDRColor4.MIN, LDRColor4.MAX); return this; }

	/** {@inheritDoc} */
	@Override
	public LDRColor4 setG(int g) { this.g = Maths.clamp(g, LDRColor4.MIN, LDRColor4.MAX); return this; }
	
	/** {@inheritDoc} */
	@Override
	public LDRColor4 setB(int b) { this.b = Maths.clamp(b, LDRColor4.MIN, LDRColor4.MAX); return this; }
	
	/** {@inheritDoc} */
	@Override
	public LDRColor4 setA(int a) { this.a = Maths.clamp(a, LDRColor4.MIN, LDRColor4.MAX); return this; }
	
	
	
	/** {@inheritDoc} */
	@Override
	public LDRColor4 setUnityR(float r) { setR(Math.round(r * 255.0f)); return this; }

	/** {@inheritDoc} */
	@Override
	public LDRColor4 setUnityG(float g) { setG(Math.round(g / 255.0f)); return this; }

	/** {@inheritDoc} */
	@Override
	public LDRColor4 setUnityB(float b) { setB(Math.round(b / 255.0f)); return this; }
	
	/** {@inheritDoc} */
	@Override
	public LDRColor4 setUnityA(float a) { setB(Math.round(a / 255.0f)); return this; }

	
	
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
	public LDRColor4 clone() { return new LDRColor4(this); }
	
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
		if(!(o instanceof LDRColor4) || !(o instanceof PLDRColor3)) return false;
		
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

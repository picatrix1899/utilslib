
package cmn.utilslib.color.colors;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.Serializable;

import cmn.utilslib.color.colors.api.IColor3Base;
import cmn.utilslib.color.colors.api.ILDRColor3;
import cmn.utilslib.essentials.Maths;
import cmn.utilslib.interfaces.IStreamable;
import cmn.utilslib.interfaces.IObjectable;



/**
 * Represents a color with 3 components.
 * @author picatrix1899
 * @category Color
 */
public class LDRColor3 implements ILDRColor3<LDRColor3>, IStreamable, Serializable, IObjectable<LDRColor3>
{

	/**  */
	public static final PLDRColor3 WHITE =		PLDRColor3.gen(255, 255, 255);
	/**  */
	public static final PLDRColor3 BLACK =		PLDRColor3.gen(000, 000, 000);
	/**  */
	public static final PLDRColor3 RED =		PLDRColor3.gen(255, 000, 000);
	/**  */
	public static final PLDRColor3 GREEN =		PLDRColor3.gen(000, 255, 000);
	/**  */
	public static final PLDRColor3 BLUE =		PLDRColor3.gen(000, 000, 255);
	/**  */
	public static final PLDRColor3 YELLOW =		PLDRColor3.gen(255, 255, 000);
	
	
	
	/** Number of components */
	public static final int DIMENSIONS = 3;
	
	
	
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
	
	
	
	/** {@inheritDoc} */
	@Override
	public LDRColor3 set(IColor3Base color) { return setR(color.getR()).setG(color.getG()).setB(color.getB()); }
	
	
	
	/** {@inheritDoc} */
	@Override
	public LDRColor3 setUnity(float r, float g, float b) { return setUnityR(r).setUnityG(g).setUnityB(b); }
	
	/** {@inheritDoc} */
	@Override
	public LDRColor3 set(int r, int g, int b) { return setR(r).setG(g).setB(b); }
	

	
	/** {@inheritDoc} */
	@Override
	public LDRColor3 setR(int r) { this.r = Maths.clamp(r, LDRColor3.MIN, LDRColor3.MAX); return this; }

	/** {@inheritDoc} */
	@Override
	public LDRColor3 setG(int g) { this.g = Maths.clamp(g, LDRColor3.MIN, LDRColor3.MAX); return this; }
	
	/** {@inheritDoc} */
	@Override
	public LDRColor3 setB(int b) { this.b = Maths.clamp(b, LDRColor3.MIN, LDRColor3.MAX); return this; }
	

	
	/** {@inheritDoc} */
	@Override
	public LDRColor3 setUnityR(float r) { setR(Math.round(r * 255.0f)); return this; }

	/** {@inheritDoc} */
	@Override
	public LDRColor3 setUnityG(float g) { setG(Math.round(g / 255.0f)); return this; }
	
	/** {@inheritDoc} */
	@Override
	public LDRColor3 setUnityB(float b) { setB(Math.round(b / 255.0f)); return this; }
	
	
	
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
	public LDRColor3 clone() { return new LDRColor3(this); }
	
	/** {@inheritDoc} */
	@Override
	public String toString()
	{
		return "color3(" + getR() + ", " + getG() + ", " + getB() + ")";
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object o)
	{
		if(!(o instanceof IColor3Base)) return false;
		if(!(o instanceof LDRColor3) || !(o instanceof PLDRColor3)) return false;
		
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

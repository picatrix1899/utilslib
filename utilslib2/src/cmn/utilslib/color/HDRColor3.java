
package cmn.utilslib.color;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import cmn.utilslib.interfaces.IObjectable;
import cmn.utilslib.interfaces.IStreamable;
import cmn.utilslib.interfaces.IStringParser;



/**
 * Represents a color with 3 components.
 * @author picatrix1899
 * @category Color
 */
public class HDRColor3 implements IStreamable, Serializable, IColor3, IObjectable<HDRColor3>
{
	/** Default white color. */
	public static final PersistentHDRColor3 WHITE	=		PersistentHDRColor3.gen(255, 255, 255);
	/** Default black color. */
	public static final PersistentHDRColor3 BLACK	=		PersistentHDRColor3.gen(000, 000, 000);
	/** Default red color. */
	public static final PersistentHDRColor3 RED		=		PersistentHDRColor3.gen(255, 000, 000);
	/** Default green color. */
	public static final PersistentHDRColor3 GREEN	=		PersistentHDRColor3.gen(000, 255, 000);
	/** Default blue color. */
	public static final PersistentHDRColor3 BLUE	=		PersistentHDRColor3.gen(000, 000, 255);
	/** Default yellow color. */
	public static final PersistentHDRColor3 YELLOW	=		PersistentHDRColor3.gen(255, 255, 000);
	
	
	
	/** Number of components. */
	public static final int DIMENSIONS = 3;
	
	
	
	/** the minimum value. */
	public static final int DEFAULT_MIN = 0;
	
	/** the maximum value. */
	public static final int DEFAULT_MAX = 255;	
	
	
	
	private static final long serialVersionUID = 1L;
	


	private int r;
	private int g;
	private int b;
	
	
	
	/**
	 * Plain Constructor with initial white color.
	 */
	public HDRColor3() { this(HDRColor3.DEFAULT_MAX, HDRColor3.DEFAULT_MAX, HDRColor3.DEFAULT_MAX); }
	
	/**
	 * Constructor with 3 initial components.
	 * @param r : The red component.
	 * @param g : The green component.
	 * @param b : The blue component.
	 */
	public HDRColor3(int r, int g, int b) { setR(r).setG(g).setB(b); }
	
	/**
	 * Constructor with 3 initial components.
	 * @param r : The red component.
	 * @param g : The green component.
	 * @param b : The blue component.
	 */
	public HDRColor3(float r, float g, float b) { setUnityR(r).setUnityG(g).setUnityB(b); }
	
	/**
	 * Clone Constructor.
	 * @param color : The color to clone.
	 */
	public HDRColor3(IColor3 color) { set(color); }
	
	
	
	/**
	 * @param color
	 * @return
	 */
	public HDRColor3 set(IColor3 color) { return setR(color.getR()).setG(color.getG()).setB(color.getB()); }
	
	
	
	/**
	 * @param r
	 * @param g
	 * @param b
	 * @return
	 */
	public HDRColor3 setUnity(float r, float g, float b) { return setUnityR(r).setUnityG(g).setUnityB(b); }
	
	/**
	 * @param r
	 * @param g
	 * @param b
	 * @return
	 */
	public HDRColor3 set(int r, int g, int b) { return setR(r).setG(g).setB(b); }
	
	
	
	/**
	 * @param r
	 * @return
	 */
	public HDRColor3 setR(int r) { this.r = r; return this; }
	
	/**
	 * @param g
	 * @return
	 */
	public HDRColor3 setG(int g) { this.g = g; return this; }
	
	/**
	 * @param b
	 * @return
	 */
	public HDRColor3 setB(int b) { this.b = b; return this; }
	
	
	
	/**
	 * @param r
	 * @return
	 */
	public HDRColor3 setUnityR(float r) { setR(Math.round(r * 255.0f)); return this; }
	
	/**
	 * @param g
	 * @return
	 */
	public HDRColor3 setUnityG(float g) { setG(Math.round(g / 255.0f)); return this; }
	
	/**
	 * @param b
	 * @return
	 */
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
	public String toString(IStringParser<HDRColor3> parser) { return parser.parse(this); }
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object o)
	{
		if(!(o instanceof IColor3)) return false;
		if(!(o instanceof HDRColor3) || !(o instanceof PersistentHDRColor3)) return false;
		
		IColor3 c = (IColor3)o;
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

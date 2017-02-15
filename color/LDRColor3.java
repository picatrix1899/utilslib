
package cmn.picatrix1899.utilslib.color;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import cmn.picatrix1899.utilslib.dmap.DMap4;
import cmn.picatrix1899.utilslib.essentials.Maths;
import cmn.picatrix1899.utilslib.interfaces.IStreamable;
import cmn.picatrix1899.utilslib.interfaces.IStringParser;
import cmn.picatrix1899.utilslib.interfaces.IColor3;
import cmn.picatrix1899.utilslib.interfaces.IObjectable;



/**
 * Represents a color with 3 components without alpha component.
 * the components are represented as float values with a range of 0.0f to 1.0f
 *
 * @author picatrix1899
 */
public class LDRColor3 implements IStreamable, Serializable, IColor3, IObjectable<LDRColor3>
{

	private static final long serialVersionUID = 1L;
	
	public static final PersistentLDRColor3 WHITE =		PersistentLDRColor3.gen(255, 255, 255);
	public static final PersistentLDRColor3 BLACK =		PersistentLDRColor3.gen(000, 000, 000);
	public static final PersistentLDRColor3 RED =		PersistentLDRColor3.gen(255, 000, 000);
	public static final PersistentLDRColor3 GREEN =		PersistentLDRColor3.gen(000, 255, 000);
	public static final PersistentLDRColor3 BLUE =		PersistentLDRColor3.gen(000, 000, 255);
	public static final PersistentLDRColor3 YELLOW =	PersistentLDRColor3.gen(255, 255, 000);
	
	
	
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
	
	
	
	private int r;
	private int g;
	private int b;
	
	
	
	/**
	 * Plain Constructor with initial white color
	 */
	public LDRColor3() { this(LDRColor3.MAX, LDRColor3.MAX, LDRColor3.MAX); }
	
	/**
	 * Constructor with 3 initial components
	 * 
	 * @param r : The red component
	 * @param g : The green component
	 * @param b : The blue component
	 */
	public LDRColor3(int r, int g, int b) { setR(r).setG(g).setB(b); }
	
	/**
	 * Constructor with 3 initial components
	 * 
	 * @param r : The red component
	 * @param g : The green component
	 * @param b : The blue component
	 */
	public LDRColor3(float r, float g, float b) { setUnityR(r).setUnityG(g).setUnityB(b); }
	
	/**
	 * Clone Constructor
	 * 
	 * @param color : The color to clone
	 */
	public LDRColor3(IColor3 color) { set(color); }
	
	
	
	public LDRColor3 set(IColor3 color) { return setR(color.getR()).setG(color.getG()).setB(color.getB()); }
	
	public LDRColor3 setUnity(float r, float g, float b) { return setUnityR(r).setUnityG(g).setUnityB(b); }
	
	public LDRColor3 set(int r, int g, int b) { return setR(r).setG(g).setB(b); }
	

	public LDRColor3 setR(int r) { this.r = Maths.clamp(r, LDRColor3.MIN, LDRColor3.MAX); return this; }

	public LDRColor3 setG(int g) { this.g = Maths.clamp(g, LDRColor3.MIN, LDRColor3.MAX); return this; }
	
	public LDRColor3 setB(int b) { this.b = Maths.clamp(b, LDRColor3.MIN, LDRColor3.MAX); return this; }
	

	public LDRColor3 setUnityR(float r) { setR(Math.round(r * 255.0f)); return this; }

	public LDRColor3 setUnityG(float g) { setG(Math.round(g / 255.0f)); return this; }

	public LDRColor3 setUnityB(float b) { setB(Math.round(b / 255.0f)); return this; }
	
	
	
	/**
	 * Decompress a color code to 3 components
	 * 
	 * @see ColorFormat
	 * 
	 * @param code : The color code
	 * @param format : The format used to decompress
	 * @return The decompressed color
	 */
	public LDRColor3 initColorCode(int code, ColorFormat format)
	{
		DMap4<Byte,Byte,Byte,Byte> map = format.read(code);
		
		setR((int)map.getA() & 0xFF);
		setG((int)map.getB() & 0xFF);
		setB((int)map.getC() & 0xFF);
		
		return this;
	}
	
	
	
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
	
	
	
	/**
	 * Compress the components into one single integer value known as color code
	 * 
	 * @param format : The format used to compress
	 * @return The compressed color code
	 */
	public int getColorCode(ColorFormat format)
	{
		return format.write((byte)getR(), (byte)getG(), (byte)getB(), (byte)255);
	}	
	
	
	
	public static LDRColor3 get(float r, float g, float b)
	{
		return new LDRColor3(r, g, b);
	}
	
	public static LDRColor3 get(int r, int g, int b)
	{
		LDRColor3 out = new LDRColor3();

		return out.setR(r).setG(g).setB(b);
	}
	
	
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
		if(!(o instanceof IColor3)) return false;
		if(!(o instanceof LDRColor3) || !(o instanceof PersistentLDRColor3)) return false;
		
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
		DataInputStream in = new DataInputStream(stream);
		
		int format = in.readInt();
		int colorcode = in.readInt();
		
		initColorCode(colorcode, ColorFormat.values()[format]);
	}

	/** {@inheritDoc} */
	@Override
	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream out = new DataOutputStream(stream);
		
		int format = ColorFormat.RGBA_32.ordinal();
		int colorcode = getColorCode(ColorFormat.RGBA_32);
		
		out.writeInt(format);
		out.writeInt(colorcode);
	}

	/** {@inheritDoc} */
	@Override
	public String toString(IStringParser<LDRColor3> parser) { return parser.parse(this); }

}

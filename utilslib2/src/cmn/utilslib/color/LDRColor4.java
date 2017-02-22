
package cmn.utilslib.color;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import cmn.utilslib.dmap.DMap4;
import cmn.utilslib.essentials.Maths;
import cmn.utilslib.interfaces.IStreamable;
import cmn.utilslib.interfaces.IStringParser;
import cmn.utilslib.interfaces.IObjectable;



/**
 * Represents a color with 4 components without alpha component.
 * the components are represented as float values with a range of 0.0f to 1.0f
 *
 * @author picatrix1899
 */
public class LDRColor4 implements IStreamable, Serializable, IColor4, IObjectable<LDRColor4>
{

	private static final long serialVersionUID = 1L;
	
	public static final PersistentLDRColor4 WHITE =		PersistentLDRColor4.gen(255, 255, 255, 255);
	public static final PersistentLDRColor4 BLACK =		PersistentLDRColor4.gen(000, 000, 000, 255);
	public static final PersistentLDRColor4 RED =		PersistentLDRColor4.gen(255, 000, 000, 255);
	public static final PersistentLDRColor4 GREEN =		PersistentLDRColor4.gen(000, 255, 000, 255);
	public static final PersistentLDRColor4 BLUE =		PersistentLDRColor4.gen(000, 000, 255, 255);
	public static final PersistentLDRColor4 YELLOW =	PersistentLDRColor4.gen(255, 255, 000, 255);
	
	
	
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
	private int a;
	
	
	
	/**
	 * Plain Constructor with initial white color
	 */
	public LDRColor4() { this(LDRColor4.MAX, LDRColor4.MAX, LDRColor4.MAX, LDRColor4.MAX); }
	
	/**
	 * Constructor with 3 initial components
	 * 
	 * @param r : The red component
	 * @param g : The green component
	 * @param b : The blue component
	 */
	public LDRColor4(int r, int g, int b, int a) { set(r, g, b, a); }
	
	/**
	 * Constructor with 3 initial components
	 * 
	 * @param r : The red component
	 * @param g : The green component
	 * @param b : The blue component
	 */
	public LDRColor4(float r, float g, float b, float a) { setUnity(r, g, b, a); }
	
	/**
	 * Clone Constructor
	 * 
	 * @param color : The color to clone
	 */
	public LDRColor4(IColor4 color) { set(color); }
	
	
	
	public LDRColor4 set(IColor4 color) { return setR(color.getR()).setG(color.getG()).setB(color.getB()).setA(color.getA()); }
	
	public LDRColor4 setUnity(float r, float g, float b, float a) { return setUnityR(r).setUnityG(g).setUnityB(b).setUnityA(a); }
	
	public LDRColor4 set(int r, int g, int b, int a) { return setR(r).setG(g).setB(b).setA(a); }
	

	public LDRColor4 setR(int r) { this.r = Maths.clamp(r, LDRColor4.MIN, LDRColor4.MAX); return this; }

	public LDRColor4 setG(int g) { this.g = Maths.clamp(g, LDRColor4.MIN, LDRColor4.MAX); return this; }
	
	public LDRColor4 setB(int b) { this.b = Maths.clamp(b, LDRColor4.MIN, LDRColor4.MAX); return this; }
	
	public LDRColor4 setA(int a) { this.a = Maths.clamp(a, LDRColor4.MIN, LDRColor4.MAX); return this; }
	
	
	public LDRColor4 setUnityR(float r) { setR(Math.round(r * 255.0f)); return this; }

	public LDRColor4 setUnityG(float g) { setG(Math.round(g / 255.0f)); return this; }

	public LDRColor4 setUnityB(float b) { setB(Math.round(b / 255.0f)); return this; }
	
	public LDRColor4 setUnityA(float a) { setB(Math.round(a / 255.0f)); return this; }
	
	
	/**
	 * Decompress a color code to 3 components
	 * 
	 * @see ColorFormat
	 * 
	 * @param code : The color code
	 * @param format : The format used to decompress
	 * @return The decompressed color
	 */
	public LDRColor4 initColorCode(int code, ColorFormat format)
	{
		DMap4<Byte,Byte,Byte,Byte> map = format.read(code);
		
		setR((int)map.getA() & 0xFF);
		setG((int)map.getB() & 0xFF);
		setB((int)map.getC() & 0xFF);
		setA((int)map.getD() & 0xFF);
		
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
	
	
	/**
	 * Compress the components into one single integer value known as color code
	 * 
	 * @param format : The format used to compress
	 * @return The compressed color code
	 */
	public int getColorCode(ColorFormat format)
	{
		return format.write((byte)getR(), (byte)getG(), (byte)getB(), (byte)getA());
	}	
	
	
	
	public static LDRColor4 get(float r, float g, float b, float a)
	{
		return new LDRColor4(r, g, b, a);
	}
	
	public static LDRColor4 get(int r, int g, int b, int a)
	{
		return new LDRColor4(r, g, b, a);
	}
	
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
		if(!(o instanceof IColor4)) return false;
		if(!(o instanceof LDRColor4) || !(o instanceof PersistentLDRColor3)) return false;
		
		IColor4 c = (IColor4)o;
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

	@Override
	public String toString(IStringParser<LDRColor4> parser) { return parser.parse(this); }

}

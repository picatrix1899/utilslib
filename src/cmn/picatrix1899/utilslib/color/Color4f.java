 
package cmn.picatrix1899.utilslib.color;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cmn.picatrix1899.utilslib.dmap.DMap4;
import cmn.picatrix1899.utilslib.essentials.Maths;
import cmn.picatrix1899.utilslib.interfaces.DataHolder;



/**
 * Represents a color with 4 components with alpha component.
 * the components are represented as float values with a range of 0.0f to 1.0f
 *
 * @author picatrix1899
 */
public class Color4f implements DataHolder
{

	public static final PersistentColor4f WHITE =		new PersistentColor4f(1.0f, 1.0f, 1.0f, 1.0f);
	public static final PersistentColor4f BLACK =		new PersistentColor4f(0.0f, 0.0f, 0.0f, 1.0f);
	public static final PersistentColor4f RED =			new PersistentColor4f(1.0f, 0.0f, 0.0f, 1.0f);
	public static final PersistentColor4f GREEN =		new PersistentColor4f(0.0f, 1.0f, 0.0f, 1.0f);
	public static final PersistentColor4f BLUE =		new PersistentColor4f(0.0f, 0.0f, 1.0f, 1.0f);
	
	
	
	/**
	 * Number of components
	 */
	public static final int DIMENSIONS = 4;
	
	/**
	 * the minimum value
	 */
	public static final float MIN = 0.0f;
	/**
	 * the maximum value
	 */
	public static final float MAX = 1.0f;
	
	
	
	private float r;
	private float g;
	private float b;
	private float a;
	
	
	
	/**
	 * Constructor with initial white color
	 */
	public Color4f() { this(Color4f.MAX, Color4f.MAX, Color4f.MAX, Color4f.MAX); }
	/**
	 * Constructor with 3 initial components
	 * 
	 * @param r : The red component
	 * @param g : The green component
	 * @param b : The blue component
	 * @param a : The alpha component
	 */
	public Color4f(float r, float g, float b, float a) { setR(r).setG(g).setB(b).setA(a); }
	/**
	 * Constructor for cloning
	 * 
	 * @param color : The color to clone
	 */
	public Color4f(Color4f color) { this.r = color.getR(); this.g = color.getG(); this.b = color.getB(); this.a = color.getA(); }
	
	public Color4f(PersistentColor4f color) { this.r = color.r; this.g = color.g; this.b = color.b; this.a = color.a; }
	
	
	
	public Color4f set(Color4f color) { this.r = color.r; this.g = color.g; this.b = color.b; return this; }
	
	public Color4f set(PersistentColor4f color) { this.r = color.r; this.g= color.g; this.b = color.b; this.a = color.a; return this; }
	
	public Color4f set(float r, float g, float b, float a) { return setR(r).setG(g).setB(b).setA(a); }
	/**
	 * Sets the red component
	 * 
	 * @param r : The new red component
	 * @return The current color
	 */
	public Color4f setR(float r) { this.r = Maths.clamp(r, Color4f.MIN, Color4f.MAX); return this; }
	/**
	 * Sets the green component
	 * 
	 * @param g : The new green component
	 * @return The current color
	 */
	public Color4f setG(float g) { this.g = Maths.clamp(g, Color4f.MIN, Color4f.MAX); return this; }
	/**
	 * Sets the blue component
	 * 
	 * @param b : The new blue component
	 * @return The current color
	 */
	public Color4f setB(float b) { this.b = Maths.clamp(b, Color4f.MIN, Color4f.MAX); return this; }
	/**
	 * Sets the alpha component
	 * 
	 * @param a : The new alpha component
	 * @return The current color
	 */
	public Color4f setA(float a) { this.a = Maths.clamp(a, Color4f.MIN, Color4f.MAX); return this; }
	
	/**
	 * Sets the red component based on a integer component value(range from 0 to 255)
	 * 
	 * @param r : The new red component as integer component value(range from 0 to 255)
	 * @return The current color
	 */
	public Color4f setIntR(int r) { setR(r / 255.0f); return this; }
	/**
	 * Sets the green component based on a integer component value(range from 0 to 255)
	 * 
	 * @param g : The new green component as integer component value(range from 0 to 255)
	 * @return The current color
	 */
	public Color4f setIntG(int g) { setG(g / 255.0f); return this; }
	/**
	 * Sets the blue component based on a integer component value(range from 0 to 255)
	 * 
	 * @param b : The new blue component as integer component value(range from 0 to 255)
	 * @return The current color
	 */
	public Color4f setIntB(int b) { setB(b / 255.0f); return this; }
	/**
	 * Sets the alpha component based on a integer component value(range from 0 to 255)
	 * 
	 * @param a : The new alpha component as integer component value(range from 0 to 255)
	 * @return The current color
	 */
	public Color4f setIntA(int a) { setA(a / 255.0f); return this; }
	
	/**
	 * Decompress a color code to 4 components
	 * 
	 * @param code : The color code
	 * @param format : The format used to decompress
	 * @return The decompressed color
	 */
	public Color4f initColorCode(int code, ColorFormat format)
	{
		DMap4<Byte,Byte,Byte,Byte> map = format.read(code);
		
		setIntR((int)map.getA() & 0xFF);
		setIntG((int)map.getB() & 0xFF);
		setIntB((int)map.getC() & 0xFF);
		setIntA((int)map.getA() & 0xFF);
		
		return this;
	}
	
	
	/**
	 * Gets the red component
	 * 
	 * @return The red component
	 */
	public float getR() { return this.r; }
	/**
	 * Gets the green component
	 * 
	 * @return The green component
	 */
	public float getG() { return this.g; }
	/**
	 * Gets the blue component
	 * 
	 * @return The blue component
	 */
	public float getB() { return this.b; }
	/**
	 * Gets the alpha component
	 * 
	 * @return The alpha component
	 */
	public float getA() { return this.a; }
	
	/**
	 * Gets the red component as interger component(range from 0 to 255) 
	 * 
	 * @return The red component as interger component value(range from 0 to 255)
	 */
	public int getIntR() { return (int)Math.round(getR() * 255); }
	/**
	 * Gets the green component as interger component(range from 0 to 255)
	 * 
	 * @return The green component as interger component value(range from 0 to 255)
	 */
	public int getIntG() { return (int)Math.round(getG() * 255); }
	/**
	 * Gets the blue component as interger component(range from 0 to 255)
	 * 
	 * @return The blue component as interger component value(range from 0 to 255)
	 */
	public int getIntB() { return (int)Math.round(getB() * 255); }
	/**
	 * Gets the alpha component as interger component(range from 0 to 255)
	 * 
	 * @return The alpha component as interger component value(range from 0 to 255)
	 */
	public int getIntA() { return (int)Math.round(getA() * 255); }
	
	/**
	 * Compress the components into one single integer value known as color code
	 * 
	 * @param format : The format used to compress
	 * @return The compressed color code
	 */
	public int getColorCode(ColorFormat format)
	{
		return format.write((byte)getIntR(), (byte)getIntG(), (byte)getIntB(), (byte)getIntA());
	}
	
	
	@Override
	public Color4f clone()
	{
		return new Color4f(this);
	}
	
	
	@Override
	public String toString()
	{
		return "color4f(" + getR() + ", " + getG() + ", " + getB() + ", " + ")";
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(!(o instanceof Color4f)) return false;
		Color4f c = (Color4f)o;
		if(c.getR() != this.getR()) return false;
		if(c.getG() != this.getG()) return false;
		if(c.getB() != this.getB()) return false;
		if(c.getA() != this.getA()) return false;
		
		return true;
	}


	

	/**
	 * Initialize the color from a InputStream
	 * 
	 * @param stream : The InputStream
	 */
	@Override
	public void readData(InputStream stream) throws IOException
	{
		DataInputStream in = new DataInputStream(stream);
		
		int format = in.readInt();
		int colorcode = in.readInt();
		
		initColorCode(colorcode, ColorFormat.values()[format]);
	}

	/**
	 * Writes the color to a OutputStream
	 * 
	 * @param stream : The OutputStream
	 */
	@Override
	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream out = new DataOutputStream(stream);
		
		int format = ColorFormat.RGBA_32.ordinal();
		int colorcode = getColorCode(ColorFormat.RGBA_32);
		
		out.writeInt(format);
		out.writeInt(colorcode);
	}
	
}

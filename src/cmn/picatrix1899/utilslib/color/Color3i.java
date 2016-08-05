
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
 * 
 * Represents a color with 3 components without alpha component.
 * the components are represented as integer values with a range of 0 to 255
 *
 * @author picatrix1899
 */
public class Color3i implements DataHolder
{
	
	public static final PersistentColor3i WHITE =		new PersistentColor3i(255, 255, 255);
	public static final PersistentColor3i BLACK =		new PersistentColor3i(000, 000, 000);
	public static final PersistentColor3i RED =			new PersistentColor3i(255, 000, 000);
	public static final PersistentColor3i GREEN = 		new PersistentColor3i(000, 255, 000);
	public static final PersistentColor3i BLUE =		new PersistentColor3i(000, 000, 255);
	
	
	
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
	 * Constructor with initial white color
	 */
	public Color3i() { this(Color3i.MAX, Color3i.MAX, Color3i.MAX); }
	/**
	 * Constructor with 3 initial components
	 * 
	 * @param r : The red component
	 * @param g : The green component
	 * @param b : The blue component
	 */
	public Color3i(int r, int g, int b) { setR(r).setG(g).setB(b); }
	/**
	 * Constructor for cloning
	 * 
	 * @param color : The color to clone
	 */
	public Color3i(Color3i color) { this.r = color.getR(); this.g = color.getG(); this.b = color.getB(); }
	
	public Color3i(PersistentColor3i color) { this.r = color.getR(); this.g = color.getG(); this.b = color.getB(); }
	
	public Color3i set(Color3i color) { this.r = color.r; this.g = color.g; this.b = color.b; return this; }
	
	public Color3i set(PersistentColor3i color) { this.r = color.r; this.g = color.g; this.b = color.b; return this; }
	
	public Color3i set(int r, int g, int b) { return setR(r).setG(g).setB(b); }
	/**
	 * Sets the red component
	 * 
	 * @param r : The new red component
	 * @return The current color
	 */
	public Color3i setR(int r) { this.r = Maths.clamp(r, Color3i.MIN, Color3i.MAX); return this; }
	/**
	 * Sets the green component
	 * 
	 * @param g : The new green component
	 * @return The current color
	 */
	public Color3i setG(int g) { this.g = Maths.clamp(g, Color3i.MIN, Color3i.MAX); return this; }
	/**
	 * Sets the blue component
	 * 
	 * @param b : The new blue component
	 * @return The current color
	 */
	public Color3i setB(int b) { this.b = Maths.clamp(b, Color3i.MIN, Color3i.MAX); return this; }
	
	/**
	 * Sets the red component based on a float component value(range from 0.0f to 1.0f)
	 * 
	 * @param r : The new red component as float component value(range from 0.0f to 1.0f)
	 * @return The current color
	 */
	public Color3i setFloatR(float r) { setR(Math.round(r * 255));  return this; }
	/**
	 * Sets the green component based on a float component value(range from 0.0f to 1.0f)
	 * 
	 * @param g : The new green component as float component value(range from 0.0f to 1.0f)
	 * @return The current color
	 */
	public Color3i setFloatG(float g) { setG(Math.round(g * 255));  return this; }
	/**
	 * Sets the blue component based on a float component value(range from 0.0f to 1.0f)
	 * 
	 * @param b : The new blue component as float component value(range from 0.0f to 1.0f)
	 * @return The current color
	 */
	public Color3i setFloatB(float b) { setB(Math.round(b * 255));  return this; }	
	
	/**
	 * Decompress a color code to 3 components
	 * 
	 * @param code : The color code
	 * @param format : The format used to decompress
	 * @return The decompressed color
	 */
	public Color3i initColorCode(int code, ColorFormat format)
	{
		DMap4<Byte,Byte,Byte,Byte> map = format.read(code);
		
		setR((int)map.getA() & 0xFF);
		setG((int)map.getB() & 0xFF);
		setB((int)map.getC() & 0xFF);
		
		return this;
	}	
	
	
	
	/**
	 * Gets the red component
	 * 
	 * @return The red component
	 */
	public int getR() { return r; }
	/**
	 * Gets the green component
	 * 
	 * @return The green component
	 */
	public int getG() { return g; }
	/**
	 * Gets the blue component
	 * 
	 * @return The blue component
	 */
	public int getB() { return b; }
	
	/**
	 * Gets the red component as float component(range from 0 to 1.0f) 
	 * 
	 * @return The red component as float component value(range from 0.0f to 1.0f)
	 */
	public float getFloatR() { return getR() / 255.0f; }
	/**
	 * Gets the green component as float component(range from 0.0f to 1.0f)
	 * 
	 * @return The green component as float component value(range from 0.0f to 1.0f)
	 */
	public float getFloatG() { return getG() / 255.0f; }
	/**
	 * Gets the blue component as float component(range from 0.0f to 1.0f)
	 * 
	 * @return The blue component as float component value(range from 0.0f to 1.0f)
	 */
	public float getFloatB() { return getB() / 255.0f; }
	
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
	
	

	@Override
	public Color3i clone()
	{
		return new Color3i(this);
	}
	
	@Override
	public String toString()
	{
		return "color3i(" + getR() + ", " + getG() + ", " + getB() + ")";
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(!(o instanceof Color3i)) return false;
		
		Color3i c = (Color3i)o;
		if(c.getR() != this.getR()) return false;
		if(c.getG() != this.getG()) return false;
		if(c.getB() != this.getB()) return false;
		
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

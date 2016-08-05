
package cmn.picatrix1899.utilslib.color;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Iterator;

import cmn.picatrix1899.utilslib.dmap.DMap4;
import cmn.picatrix1899.utilslib.essentials.Maths;
import cmn.picatrix1899.utilslib.interfaces.DataHolder;



/**
 * Represents a color with 3 components without alpha component.
 * the components are represented as float values with a range of 0.0f to 1.0f
 *
 * @author picatrix1899
 */
public class Color3f implements DataHolder, Serializable, Iterable<Float>
{

	private static final long serialVersionUID = 1L;
	
	public static final PersistentColor3f WHITE =		new PersistentColor3f(1.0f, 1.0f, 1.0f);
	public static final PersistentColor3f BLACK =		new PersistentColor3f(0.0f, 0.0f, 0.0f);
	public static final PersistentColor3f RED =			new PersistentColor3f(1.0f, 0.0f, 0.0f);
	public static final PersistentColor3f GREEN =		new PersistentColor3f(0.0f, 1.0f, 0.0f);
	public static final PersistentColor3f BLUE =		new PersistentColor3f(0.0f, 0.0f, 1.0f);
	
	
	
	/**
	 * Number of components
	 */
	public static final int DIMENSIONS = 3;
	
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
	
	
	
	/**
	 * Constructor with initial white color
	 */
	public Color3f() { this(Color3f.MAX, Color3f.MAX, Color3f.MAX); }
	/**
	 * Constructor with 3 initial components
	 * 
	 * @param r : The red component
	 * @param g : The green component
	 * @param b : The blue component
	 */
	public Color3f(float r, float g, float b) { setR(r).setG(g).setB(b); }
	/**
	 * Constructor for cloning
	 * 
	 * @param color : The color to clone
	 */
	public Color3f(Color3f color) { this.r = color.getR(); this.g = color.getG(); this.b = color.getB(); }
	
	public Color3f(PersistentColor3f color) { this.r = color.r; this.g = color.g; this.b = color.b; }
	
	public Color3f set(Color3f color) { this.r = color.r; this.g = color.g; this.b = color.b; return this; }
	
	public Color3f set(PersistentColor3f color) { this.r = color.r; this.g = color.g; this.b = color.b; return this; }
	
	public Color3f set(float r, float g, float b) { return setR(r).setG(g).setB(b); }
	
	/**
	 * Sets the red component
	 * 
	 * @param r : The new red component
	 * @return The current color
	 */
	public Color3f setR(float r) { this.r = Maths.clamp(r, Color3f.MIN, Color3f.MAX); return this; }
	/**
	 * Sets the green component
	 * 
	 * @param g : The new green component
	 * @return The current color
	 */
	public Color3f setG(float g) { this.g = Maths.clamp(g, Color3f.MIN, Color3f.MAX); return this; }
	/**
	 * Sets the blue component
	 * 
	 * @param b : The new blue component
	 * @return The current color
	 */
	public Color3f setB(float b) { this.b = Maths.clamp(b, Color3f.MIN, Color3f.MAX); return this; }
	
	/**
	 * Sets the red component based on a integer component value(range from 0 to 255)
	 * 
	 * @param r : The new red component as integer component value(range from 0 to 255)
	 * @return The current color
	 */
	public Color3f setIntR(int r) { setR(r / 255.0f); return this; }
	/**
	 * Sets the green component based on a integer component value(range from 0 to 255)
	 * 
	 * @param g : The new green component as integer component value(range from 0 to 255)
	 * @return The current color
	 */
	public Color3f setIntG(int g) { setG(g / 255.0f); return this; }
	/**
	 * Sets the blue component based on a integer component value(range from 0 to 255)
	 * 
	 * @param b : The new blue component as integer component value(range from 0 to 255)
	 * @return The current color
	 */
	public Color3f setIntB(int b) { setB(b / 255.0f); return this; }
	
	/**
	 * Decompress a color code to 3 components
	 * 
	 * @param code : The color code
	 * @param format : The format used to decompress
	 * @return The decompressed color
	 */
	public Color3f initColorCode(int code, ColorFormat format)
	{
		DMap4<Byte,Byte,Byte,Byte> map = format.read(code);
		
		setIntR((int)map.getA() & 0xFF);
		setIntG((int)map.getB() & 0xFF);
		setIntB((int)map.getC() & 0xFF);
		
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
	 * Compress the components into one single integer value known as color code
	 * 
	 * @param format : The format used to compress
	 * @return The compressed color code
	 */
	public int getColorCode(ColorFormat format)
	{
		return format.write((byte)getIntR(), (byte)getIntG(), (byte)getIntB(), (byte)255);
	}	
	
	
	
	@Override
	public Color3f clone() { return new Color3f(this); }
	
	@Override
	public String toString()
	{
		return "color3f(" + getR() + ", " + getG() + ", " + getB() + ")";
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(!(o instanceof Color3f)) return false;
		
		Color3f c = (Color3f)o;
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
	
	public Iterator<Float> iterator()
	{
		
		final float fr = this.r;
		final float fg = this.g;
		final float fb = this.b;
		
		return new Iterator<Float>()
		{

			private int i = 0;
			
			private int max = Color3f.DIMENSIONS;
			
			public boolean hasNext()
			{
				return i < max - 1;
			}

			public Float next()
			{
				
				Float f = null;
				
				if(i == 0)
					f = fr;
				else if(i == 1)
					f = fg;
				else if(i == 2)
					f = fb;
				
				if(f != null && i < max) i++;
				
				return f;
				
			}
			
		};
	}
}

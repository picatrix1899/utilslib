package cmn.picatrix1899.utilslib.color;

import cmn.picatrix1899.utilslib.essentials.Maths;

public class PersistentColor3i
{
	public final int r;
	public final int g;
	public final int b;
	
	public PersistentColor3i(int r, int g, int b)
	{
		this.r = Maths.clamp(r, Color3i.MIN, Color3i.MAX);
		this.g = Maths.clamp(g, Color3i.MIN, Color3i.MAX);
		this.b = Maths.clamp(b, Color3i.MIN, Color3i.MAX);
	}
	
	public PersistentColor3i(Color3i c)
	{
		this.r = c.getR();
		this.g = c.getG();
		this.b = c.getB();
	}
	
	public int getR() { return this.r; }
	/**
	 * Gets the green component
	 * 
	 * @return The green component
	 */
	public int getG() { return this.g; }
	/**
	 * Gets the blue component
	 * 
	 * @return The blue component
	 */
	public int getB() { return this.b; }
	
	/**
	 * Gets the red component as interger component(range from 0 to 255) 
	 * 
	 * @return The red component as interger component value(range from 0 to 255)
	 */
	public float getFloatR() { return getR() / 255.0f; }
	/**
	 * Gets the green component as interger component(range from 0 to 255)
	 * 
	 * @return The green component as interger component value(range from 0 to 255)
	 */
	public float getFloatG() { return getG() / 255.0f; }
	/**
	 * Gets the blue component as interger component(range from 0 to 255)
	 * 
	 * @return The blue component as interger component value(range from 0 to 255)
	 */
	public float getFloatB() { return getB() / 255.0f; }
	
	public Color3f asColor3f() { return new Color3f(getFloatR(), getFloatG(), getFloatB()); }
	
	public Color3i asColor3i() { return new Color3i(getR(), getG(), getB()); }
	
	public int getColorCode(ColorFormat format) { return format.write((byte)getR(), (byte)getG(), (byte)getB(), (byte)255); }
}

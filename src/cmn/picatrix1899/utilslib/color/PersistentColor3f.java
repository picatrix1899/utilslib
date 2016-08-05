package cmn.picatrix1899.utilslib.color;

import cmn.picatrix1899.utilslib.essentials.Maths;

public class PersistentColor3f
{
	public final float r;
	public final float g;
	public final float b;
	
	public PersistentColor3f(float r, float g, float b)
	{
		this.r = Maths.clamp(r, Color3f.MIN, Color3f.MAX);
		this.g = Maths.clamp(g, Color3f.MIN, Color3f.MAX);
		this.b = Maths.clamp(b, Color3f.MIN, Color3f.MAX);
	}
	
	public PersistentColor3f(Color3f c)
	{
		this.r = c.getR();
		this.g = c.getG();
		this.b = c.getB();
	}
	
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
	
	public Color3f asColor3f() { return new Color3f(getR(), getG(), getB()); }
	
	public Color3i asColor3i() { return new Color3i(getIntR(), getIntG(), getIntB()); }
	
	public int getColorCode(ColorFormat format) { return format.write((byte)getIntR(), (byte)getIntG(), (byte)getIntB(), (byte)255); }
}

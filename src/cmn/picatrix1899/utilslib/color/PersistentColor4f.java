package cmn.picatrix1899.utilslib.color;

import cmn.picatrix1899.utilslib.essentials.Maths;

public class PersistentColor4f
{
	public final float r;
	public final float g;
	public final float b;
	public final float a;
	
	public PersistentColor4f(float r, float g, float b, float a)
	{
		this.r = Maths.clamp(r, Color4f.MIN, Color4f.MAX);
		this.g = Maths.clamp(g, Color4f.MIN, Color4f.MAX);
		this.b = Maths.clamp(b, Color4f.MIN, Color4f.MAX);
		this.a = Maths.clamp(a, Color4f.MIN, Color4f.MAX);
	}
	
	public PersistentColor4f(Color4f c)
	{
		this.r = c.getR();
		this.g = c.getG();
		this.b = c.getB();
		this.a = c.getA();
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
	
	public Color4f asColor4f() { return new Color4f(getR(), getG(), getB(),getA()); }
	
	public Color4i asColor4i() { return new Color4i(getIntR(), getIntG(), getIntB(), getIntA()); }
	
	public int getColorCode(ColorFormat format) { return format.write((byte)getIntR(), (byte)getIntG(), (byte)getIntB(), (byte)getIntA()); }
	
}

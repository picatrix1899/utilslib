package cmn.picatrix1899.utilslib.color;

import cmn.picatrix1899.utilslib.essentials.Maths;

public class PersistentColor4i
{
	public final int r;
	public final int g;
	public final int b;
	public final int a;
	
	public PersistentColor4i(int r, int g, int b, int a)
	{
		this.r = Maths.clamp(r, Color4i.MIN, Color4i.MAX);
		this.g = Maths.clamp(g, Color4i.MIN, Color4i.MAX);
		this.b = Maths.clamp(b, Color4i.MIN, Color4i.MAX);
		this.a = Maths.clamp(a, Color4i.MIN, Color4i.MAX);
	}
	
	public PersistentColor4i(Color4i c)
	{
		this.r = c.getR();
		this.g = c.getG();
		this.b = c.getB();
		this.a = c.getA();
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
	 * Gets the alpha component
	 * 
	 * @return The alpha component
	 */
	public int getA() { return this.a; }	
	
	
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
	/**
	 * Gets the alpha component as interger component(range from 0 to 255)
	 * 
	 * @return The alpha component as interger component value(range from 0 to 255)
	 */
	public float getFloatA() { return getA() / 255.0f; }
	
	public Color4f asColor4f() { return new Color4f(getFloatR(), getFloatG(), getFloatB(),getFloatA()); }
	
	public Color4i asColor4i() { return new Color4i(getR(), getG(), getB(), getA()); }
	
	public int getColorCode(ColorFormat format) { return format.write((byte)getR(), (byte)getG(), (byte)getB(), (byte)getA()); }
	
}

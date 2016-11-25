package cmn.picatrix1899.utilslib.color;

import cmn.picatrix1899.utilslib.essentials.Maths;

public abstract class PersistentColor3f
{
	
	public abstract float getR();
	public abstract float getG();
	public abstract float getB();
	
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
	
	public abstract Color3f getNewColor3f();
	
	public abstract Color3f getColor3f();
	
	public abstract Color3i getNewColor3i();
	
	public abstract Color3i getColor3i();
	
	public static PersistentColor3f gen(final float r, final float g, final float b)
	{
		return new PersistentColor3f()
		{
			private Color3f cf;
			private Color3i ci;
			
			public float getB()
			{
				return Maths.clamp(b, 0.0f, 1.0f);
			}
			public float getG()
			{
				return Maths.clamp(g, 0.0f, 1.0f);
			}
			public float getR()
			{
				return Maths.clamp(r, 0.0f, 1.0f);
			}
			public Color3f getNewColor3f()
			{
				return new Color3f(r, g, b); 
			}
			public Color3i getNewColor3i()
			{
				return new Color3i(getIntR(), getIntG(), getIntB());
			}
			public Color3f getColor3f()
			{
				if(cf == null)
					return cf = new Color3f(r, g ,b);
				else if(cf.getR() != r || cf.getG() != g || cf.getB() != b)
					return cf = new Color3f(r, g, b);
				
				return cf;
			}
			public Color3i getColor3i()
			{
				if(ci == null)
					return ci = new Color3i(getIntR(), getIntG() ,getIntB());
				else if(ci.getR() != getIntR() || ci.getG() != getIntG() || ci.getB() != getIntB())
					return ci = new Color3i(getIntR(), getIntG(), getIntB());
				
				return ci;
			}
			
			
		};
	}
}

package cmn.picatrix1899.utilslib.color;


public interface Color3
{
	
	/**
	 * Gets the red component as interger component(range from 0 to 255) 
	 * 
	 * @return The red component as interger component value(range from 0 to 255)
	 */
	public abstract int getR();
	
	/**
	 * Gets the green component as interger component(range from 0 to 255) 
	 * 
	 * @return The green component as interger component value(range from 0 to 255)
	 */
	public abstract int getG();
	
	/**
	 * Gets the blue component as interger component(range from 0 to 255) 
	 * 
	 * @return The blue component as interger component value(range from 0 to 255)
	 */
	public abstract int getB();
	
	
	/**
	 * Gets the blue component as unity component(range from 0 to 1) 
	 * 
	 * @return The blue component as unity component value(range from 0 to 1)
	 */
	public abstract float getUnityR();
	
	/**
	 * Gets the blue component as unity component(range from 0 to 1) 
	 * 
	 * @return The blue component as unity component value(range from 0 to 1)
	 */
	public abstract float getUnityG();
	
	/**
	 * Gets the blue component as unity component(range from 0 to 1) 
	 * 
	 * @return The blue component as unity component value(range from 0 to 1)
	 */
	public abstract float getUnityB();
}

package cmn.utilslib.color;

public interface IColor4 extends IColor3
{
	
	/**
	 * Gets the alpha component as interger component(range from 0 to 255) 
	 * 
	 * @return The alpha component as interger component value(range from 0 to 255)
	 */
	public abstract int getA();
	
	/**
	 * Gets the alpha component as unity component(range from 0 to 1) 
	 * 
	 * @return The alpha component as unity component value(range from 0 to 1)
	 */
	public abstract float getUnityA();
}


package cmn.utilslib.color.colors.api;

/**
 * Interface for ReadOnly Color representation with 4 components.
 * @author picatrix1899
 * @category Color
 */
public interface IColor4Base extends IColor3Base
{
	
	/**
	 * Gets the alpha component as a color-range value. 
	 * @return The alpha component as a color-range value.
	 */
	public abstract int getA();
	
	/**
	 * Gets the alpha component as a unity-range value.
	 * @return The alpha component as a unity-range value.
	 */
	public abstract float getUnityA();
	
}

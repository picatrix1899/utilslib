
package cmn.utilslib.color.colors.api;





/**
 * Interface for ReadOnly Color representation with 4 components.
 * @author picatrix1899
 * @category Color
 */
public interface IColor4Base extends IColor3Base
{
	
	static int DIMENSIONS = 4;
	
	
	
	/**
	 * Gets the alpha component as a color-range value. 
	 * @return The alpha component as a color-range value.
	 */
	int getA();
	
	
	
	/**
	 * Gets the alpha component as a unity-range value.
	 * @return The alpha component as a unity-range value.
	 */
	default float getUnityA() { return getA() / 255.0f; }

	
	
	@Override
	IColor4Base clone();
	
}

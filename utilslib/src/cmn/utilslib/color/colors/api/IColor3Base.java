
package cmn.utilslib.color.colors.api;



/**
 * Interface for ReadOnly Color representation with 3 components.
 * @author picatrix1899
 * @category Color
 */
public interface IColor3Base
{
	
	/**
	 * Gets the red component as a color-range value.
	 * @return The red component as a color-range value.
	 */

	int getR();
	
	/**
	 * Gets the green component as a color-range value.
	 * @return The green component as a color-range value.
	 */
	int getG();
	
	/**
	 * Gets the blue component as a color-range value.
	 * @return The blue component as a color-range value.
	 */
	int getB();
	
	
	
	/**
	 * Gets the red component as an unity-range value.
	 * @return The red component as an unity-range value.
	 */
	float getUnityR();
	
	/**
	 * Gets the green component as an unity-range value.
	 * @return The green component as an unity-range value.
	 */
	float getUnityG();
	
	/**
	 * Gets the blue component as an unity-range value.
	 * @return The blue component as an unity-range value.
	 */
	float getUnityB();

}

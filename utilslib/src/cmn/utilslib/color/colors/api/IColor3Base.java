
package cmn.utilslib.color.colors.api;


/**
 * Interface for ReadOnly Color representation with 3 components.
 * @author picatrix1899
 * @category Color
 */
public interface IColor3Base
{
	
	static int DIMENSIONS = 3;
	
	
	
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
	default float  getUnityR() { return getR() / 255.0f; }
	/**
	 * Gets the green component as an unity-range value.
	 * @return The green component as an unity-range value.
	 */
	default float getUnityG() { return getG() / 255.0f; }
	/**
	 * Gets the blue component as an unity-range value.
	 * @return The blue component as an unity-range value.
	 */
	default float getUnityB() { return getB() / 255.0f; }

	
	
	IColor3Base clone();
	
	@SuppressWarnings("unchecked")
	default <T extends IColor3> T copy(T dest) { return (T) dest.set(this); }
	
	
	@Override
	String toString();
	
}


package cmn.utilslib.color.colors.api;



/**
 * Interface for Color representation with 3 components.
 * @author picatrix1899
 * @category Color
 */
public interface IColor3 extends IColor3Base
{
	
	/**
	 * Sets a black-white based on brightness where 0 is black and 255 is white;
	 * @param brightness: the brightness from 0(black) to 255(white)
	 * @return The current instance.
	 */
	IColor3 set(int brightness);
	
	/**
	 * Sets the color based on another color.
	 * @param color : another color as base.
	 * @return The current instance.
	 */
	IColor3 set(IColor3Base color);
	/**
	 * Sets the color based on 3 color-range values.
	 * @param r : The red component as a color-range value.
	 * @param g : The green component as a color-range value.
	 * @param b : The blue component as a color-range value.
	 * @return The current instance.
	 */
	IColor3 set(int r, int g, int b);
	
	
	/**
	 * Sets a black-white based on brightness where 0 is black and 1 is white;
	 * @param brightness: the brightness from 0(black) to 1(white)
	 * @return The current instance.
	 */
	IColor3 setUnity(float brightness);
	
	/**
	 * Sets the color based on 3 unity-range values.
	 * @param r : The red component as an unity-range value.
	 * @param g : The green component as an unity-range value.
	 * @param b : The blue component as an unity-range value.
	 * @return The current instance.
	 */
	IColor3 setUnity(float r, float g, float b);
	
	
	
	/**
	 * Sets the red component based on a color-range value.
	 * @param r : The red component as a color-range value.
	 * @return The current instance.
	 */
	IColor3 setR(int r);
	/**
	 * Sets the green component based on a color-range value.
	 * @param g : The green component as a color-range value.
	 * @return The current instance.
	 */
	IColor3 setG(int g);
	/**
	 * Sets the blue component based on a color-range value.
	 * @param b : The blue component as a color-range value.
	 * @return The current instance.
	 */
	IColor3 setB(int b);
	
	
	
	/**
	 * Sets the red component based on an unity-range value.
	 * @param r : The red component as an unity-range value.
	 * @return The current instance.
	 */
	IColor3 setUnityR(float r);
	/** 
	 * Sets the green component based on an unity-range value.
	 * @param g : The green component as an unity-range value.
	 * @return The current instance.
	 */
	IColor3 setUnityG(float g);
	/**
	 * Sets the blue component based on an unity-range value.
	 * @param b : The blue component as an unity-range value.
	 * @return The current instance.
	 */
	IColor3 setUnityB(float b);

	
	
	/**
	 * Clones the current color-object to an object of equal or higher accessibility grade.
	 */
	@Override
	IColor3 clone();
	
	
	
	/** {@inheritDoc} */
	@Override
	String toString();
	
}

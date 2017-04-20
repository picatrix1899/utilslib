
package cmn.utilslib.color.colors.api;

public interface IColor4<T extends IColor4<?>> extends IColor4Base
{
	
	/**
	 * Sets the color based on another color.
	 * @param color : another color as base.
	 * @return The current instance.
	 */
	public abstract T set(IColor4Base color);
	
	
	
	/**
	 * Sets the color based on 3 color-range values.
	 * @param r : The red component as a color-range value.
	 * @param g : The green component as a color-range value.
	 * @param b : The blue component as a color-range value.
	 * @param a : The alpha component as a color-range value.
	 * @return The current instance.
	 */
	public abstract T set(int r, int g, int b, int a);
	
	/**
	 * Sets the color based on 3 unity-range values.
	 * @param r : The red component as an unity-range value.
	 * @param g : The green component as an unity-range value.
	 * @param b : The blue component as an unity-range value.
	 * @param a : The alpha component as a unity-range value.
	 * @return The current instance.
	 */
	public abstract T setUnity(float r, float g, float b, float a);
	
	
	
	/**
	 * Sets the red component based on a color-range value.
	 * @param r : The red component as a color-range value.
	 * @return The current instance.
	 */
	public abstract T setR(int r);
	
	/**
	 * Sets the green component based on a color-range value.
	 * @param g : The green component as a color-range value.
	 * @return The current instance.
	 */
	public abstract T setG(int g);
	
	/**
	 * Sets the blue component based on a color-range value.
	 * @param b : The blue component as a color-range value.
	 * @return The current instance.
	 */
	public abstract T setB(int b);
	
	/**
	 * Sets the alpha component based on a color-range value.
	 * @param a : The alpha component as a color-range value.
	 * @return The current instance.
	 */
	public abstract T setA(int a);
	
	
	
	/**
	 * Sets the red component based on an unity-range value.
	 * @param r : The red component as an unity-range value.
	 * @return The current instance.
	 */
	public abstract T setUnityR(float r);
	
	/** 
	 * Sets the green component based on an unity-range value.
	 * @param g : The green component as an unity-range value.
	 * @return The current instance.
	 */
	public abstract T setUnityG(float g);
	
	/**
	 * Sets the blue component based on an unity-range value.
	 * @param b : The blue component as an unity-range value.
	 * @return The current instance.
	 */
	public abstract T setUnityB(float b);
	
	/**
	 * Sets the alpha component based on an unity-range value.
	 * @param a : The alpha component as an unity-range value.
	 * @return The current instance.
	 */
	public abstract T setUnityA(float a);
	
}

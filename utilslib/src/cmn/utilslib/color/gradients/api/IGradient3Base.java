package cmn.utilslib.color.gradients.api;

import cmn.utilslib.color.colors.api.IColor3Base;

public interface IGradient3Base
{
	/**
	 * Gets the red component as a color-range value.
	 * @return The red component as a color-range value.
	 */
	int getR(double index);
	
	/**
	 * Gets the green component as a color-range value.
	 * @return The green component as a color-range value.
	 */
	int getG(double index);
	
	/**
	 * Gets the blue component as a color-range value.
	 * @return The blue component as a color-range value.
	 */
	int getB(double index);
	
	
	
	/**
	 * Gets the red component as an unity-range value.
	 * @return The red component as an unity-range value.
	 */
	float getUnityR(double index);
	
	/**
	 * Gets the green component as an unity-range value.
	 * @return The green component as an unity-range value.
	 */
	float getUnityG(double index);
	
	/**
	 * Gets the blue component as an unity-range value.
	 * @return The blue component as an unity-range value.
	 */
	float getUnityB(double index);
	
	
	int nodes();
	
	double minIndex();
	double maxIndex();
	
	IColor3Base get(double index);
}

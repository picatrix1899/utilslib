package cmn.utilslib.color.gradients.api;

public interface IGradient4Base extends IGradient3Base
{
	/**
	 * Gets the alpha component as a color-range value.
	 * @return The alpha component as a color-range value.
	 */
	int getA(double index);

	/**
	 * Gets the alpha component as an unity-range value.
	 * @return The alpha component as an unity-range value.
	 */
	float getUnityA(double index);
}


package cmn.utilslib.color.colors.api;



import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import cmn.utilslib.interfaces.IStreamable;



/**
 * Interface for Color representation with 3 components.
 * @author picatrix1899
 * @category Color
 */

public interface IColor3 extends IColor3Base, IStreamable.Writeable
{
	
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
	default IColor3 setUnityR(float r) { return setR(Math.round(r * 255.0f)); }
	
	/** 
	 * Sets the green component based on an unity-range value.
	 * @param g : The green component as an unity-range value.
	 * @return The current instance.
	 */
	default IColor3 setUnityG(float g) { return setG(Math.round(g * 255.0f)); }
	
	/**
	 * Sets the blue component based on an unity-range value.
	 * @param b : The blue component as an unity-range value.
	 * @return The current instance.
	 */
	default IColor3 setUnityB(float b) { return setB(Math.round(b * 255.0f)); }

	
	/**  */
	@Override
	IColor3 clone();
	
	
	
	/**  */
	@Override
	String toString();
	
	
	
	/** {@inheritDoc} */ @Override
	default void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		setR(dis.readInt());
		setG(dis.readInt());
		setB(dis.readInt());
	}
	
}

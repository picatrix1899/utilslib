
package cmn.utilslib.color.colors.api;



import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import cmn.utilslib.interfaces.IStreamable;



public interface IColor4 extends IColor4Base, IStreamable.Writeable
{
	
	/**
	 * Sets the color based on another color.
	 * @param color : another color as base.
	 * @return The current instance.
	 */
	IColor4 set(IColor4Base color);
	/**
	 * Sets the color based on 3 color-range values.
	 * @param r : The red component as a color-range value.
	 * @param g : The green component as a color-range value.
	 * @param b : The blue component as a color-range value.
	 * @param a : The alpha component as a color-range value.
	 * @return The current instance.
	 */
	IColor4 set(int r, int g, int b, int a);
	
	
	
	/**
	 * Sets the color based on 3 unity-range values.
	 * @param r : The red component as an unity-range value.
	 * @param g : The green component as an unity-range value.
	 * @param b : The blue component as an unity-range value.
	 * @param a : The alpha component as a unity-range value.
	 * @return The current instance.
	 */
	IColor4 setUnity(float r, float g, float b, float a);
	
	
	
	/**
	 * Sets the red component based on a color-range value.
	 * @param r : The red component as a color-range value.
	 * @return The current instance.
	 */
	IColor4 setR(int r);
	/**
	 * Sets the green component based on a color-range value.
	 * @param g : The green component as a color-range value.
	 * @return The current instance.
	 */
	IColor4 setG(int g);
	/**
	 * Sets the blue component based on a color-range value.
	 * @param b : The blue component as a color-range value.
	 * @return The current instance.
	 */
	IColor4 setB(int b);
	/**
	 * Sets the alpha component based on a color-range value.
	 * @param a : The alpha component as a color-range value.
	 * @return The current instance.
	 */
	IColor4 setA(int a);
	
	
	
	/**
	 * Sets the red component based on an unity-range value.
	 * @param r : The red component as an unity-range value.
	 * @return The current instance.
	 */
	default IColor4 setUnityR(float r) { return (ILDRColor4) setR(Math.round(r * 255.0f)); }
	/** 
	 * Sets the green component based on an unity-range value.
	 * @param g : The green component as an unity-range value.
	 * @return The current instance.
	 */
	default IColor4 setUnityG(float g) { return (ILDRColor4) setG(Math.round(g * 255.0f)); }
	/**
	 * Sets the blue component based on an unity-range value.
	 * @param b : The blue component as an unity-range value.
	 * @return The current instance.
	 */
	default IColor4 setUnityB(float b) { return (ILDRColor4) setB(Math.round(b * 255.0f)); }
	/**
	 * Sets the alpha component based on an unity-range value.
	 * @param a : The alpha component as an unity-range value.
	 * @return The current instance.
	 */
	default IColor4 setUnityA(float a) { return (ILDRColor4) setA(Math.round(a * 255.0f)); }


	
	@Override
	IColor4 clone();
	
	
	
	/** {@inheritDoc} */ @Override
	default void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		setR(dis.readInt());
		setG(dis.readInt());
		setB(dis.readInt());
		setA(dis.readInt());
	}
	
}

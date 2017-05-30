
package cmn.utilslib.color.colors.api;



import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import cmn.utilslib.interfaces.Streamable;



/**
 * Interface for ReadOnly Color representation with 3 components.
 * @author picatrix1899
 * @category Color
 */
public interface IColor3Base extends Streamable.Readable
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
	
	
	
	@Override
	String toString();
	
	
	
	/** {@inheritDoc} */ @Override
	default void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeInt(getR());
		dos.writeInt(getG());
		dos.writeInt(getB());
	}
	
}
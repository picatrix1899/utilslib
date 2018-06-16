
package cmn.utilslib.color.colors.api;



import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import cmn.utilslib.interfaces.Streamable;



/**
 * Interface for ReadOnly Color representation with 4 components.
 * @author picatrix1899
 * @category Color
 */
public interface IColor4Base extends IColor3Base, Streamable.Readable
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
	
	
	/** {@inheritDoc} */ @Override
	default void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeInt(getR());
		dos.writeInt(getG());
		dos.writeInt(getB());
		dos.writeInt(getA());
	}
	
}

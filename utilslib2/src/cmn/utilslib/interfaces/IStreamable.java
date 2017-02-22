package cmn.utilslib.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 

 * @author picatrix1899
 *
 */
public interface IStreamable
{
	public abstract void readData(InputStream stream) throws IOException;
	public abstract void writeData(OutputStream stream) throws IOException;
}

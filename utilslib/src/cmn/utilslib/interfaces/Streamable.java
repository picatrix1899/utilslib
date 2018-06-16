package cmn.utilslib.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @author picatrix1899
 *
 */
public interface Streamable
{
	
	public interface Writeable { public abstract void readData(InputStream stream) throws IOException; }
	
	public interface Readable { public abstract void writeData(OutputStream stream) throws IOException; }
	
}

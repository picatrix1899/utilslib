package cmn.utilslib.net.common;

import java.io.IOException;
import java.io.InputStream;

public interface IngoingPacket extends Packet
{
	
	void read(InputStream stream) throws IOException;
	
}

package cmn.utilslib.net.common;

import java.io.InputStream;

public interface IngoingPacket extends Packet
{
	
	public void read(InputStream stream);
	
}

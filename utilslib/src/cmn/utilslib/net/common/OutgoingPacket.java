package cmn.utilslib.net.common;

import java.io.IOException;
import java.io.OutputStream;

public interface OutgoingPacket extends Packet
{
	void write(OutputStream stream) throws IOException;
}

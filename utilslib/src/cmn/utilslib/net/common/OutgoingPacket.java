package cmn.utilslib.net.common;

import java.io.OutputStream;

public interface OutgoingPacket extends Packet
{
	public void write(OutputStream stream);
}

package cmn.utilslib.net.common;

public interface PacketHandler
{	
	public void handleIngoing(IngoingPacket packet);
	public void handleOutgoing(OutgoingPacket packet);
}

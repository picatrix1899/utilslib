package cmn.utilslib.net.common;

public interface Packet
{
	public default PacketPriority getPriority()
	{
		return PacketPriority.PRIOR_4;
	}
}

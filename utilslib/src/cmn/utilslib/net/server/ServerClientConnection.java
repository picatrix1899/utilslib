package cmn.utilslib.net.server;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import cmn.utilslib.net.common.Packet;

public class ServerClientConnection
{
	private volatile Queue<Packet> packetQueue = new ConcurrentLinkedQueue<Packet>();
	
	public ServerClientConnection()
	{
		
	}
	
}

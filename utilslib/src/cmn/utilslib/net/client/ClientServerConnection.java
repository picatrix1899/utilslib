package cmn.utilslib.net.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import cmn.utilslib.essentials.SimpleThread;
import cmn.utilslib.net.common.IngoingPacket;
import cmn.utilslib.net.common.OutgoingPacket;
import cmn.utilslib.net.common.PacketHandler;

public class ClientServerConnection
{
	private volatile Queue<IngoingPacket> packetQueue_in = new ConcurrentLinkedQueue<IngoingPacket>();
	
	private volatile Queue<OutgoingPacket> packetQueue_out = new ConcurrentLinkedQueue<OutgoingPacket>();
	
	private Socket socket;
	
	private volatile boolean isRunning;
	
	private ClientCore client;

	public PacketHandler handler = (i) -> { return; };
	
	public ClientServerConnection(ClientCore client, Socket socket)
	{
		this.client = client;
		this.socket = socket;
		this.isRunning = true;
	}

	public ClientCore getServer() { return this.client; }
	
	public void start()
	{
		new SimpleThread(() -> runConnectionLoop(), "CC_Connection" + socket.getInetAddress().getCanonicalHostName(), true).start();
		new SimpleThread(() -> runUpdate(), "CC_Update" + socket.getInetAddress().getCanonicalHostName(), true).start();
	}
	
	public void sendPacket(OutgoingPacket p) { this.packetQueue_out.add(p); }
	
	private void runUpdate()
	{
		while(isRunning && !socket.isClosed())
			if(!this.packetQueue_in.isEmpty())
				handler.handleIngoing(this.packetQueue_in.poll());
	}
	
	private void runConnectionLoop()
	{
		try
		{
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			while(isRunning && !this.socket.isClosed())
			{
				if(in.available() > 0)
				{
					IngoingPacket packet_in = this.client.getPacketFactory().resolveIngoingPacket(in);
					
					if(packet_in != null)
						this.packetQueue_in.add(packet_in);
				}
				
				if(!this.packetQueue_out.isEmpty())
				{
					OutgoingPacket packet_out = this.packetQueue_out.poll();
					
					this.client.getPacketFactory().resolveOutgoingPacket(packet_out, out);
					
					out.flush();
				}
			}
			
			this.socket.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}

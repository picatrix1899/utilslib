package cmn.utilslib.net.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import cmn.utilslib.net.common.IngoingPacket;
import cmn.utilslib.net.common.OutgoingPacket;
import cmn.utilslib.net.common.PacketFactory;

public class ServerClientConnection
{
	private volatile Queue<IngoingPacket> packetQueue_in = new ConcurrentLinkedQueue<IngoingPacket>();
	
	private volatile Queue<OutgoingPacket> packetQueue_out = new ConcurrentLinkedQueue<OutgoingPacket>();
	
	private Socket socket;
	
	private volatile boolean isRunning;
	
	private ServerCore core;
	
	private Thread th_in;
	private Thread th_out;
	
	private PacketFactory factory;
	
	public ServerClientConnection(ServerCore core, PacketFactory factory, Socket socket)
	{
		this.factory = factory;
		this.core = core;
		this.socket = socket;
		this.isRunning = true;
		this.th_in = new Thread(() -> runInputThread());
		this.th_in.setName("SC_Connection_In_" + socket.getInetAddress().getCanonicalHostName());
		this.th_in.setDaemon(true);
		this.th_in.start();
		this.th_out = new Thread(() -> runOutputThread());
		this.th_out.setName("SC_Connection_Out_" + socket.getInetAddress().getCanonicalHostName());
		this.th_out.setDaemon(true);
		this.th_out.start();
	}


	private void runInputThread()
	{
		try
		{
			InputStream stream = socket.getInputStream();
			
			while(isRunning)
			{
				if(stream.available() > 0)
				{
					IngoingPacket p = this.factory.resolveIngoingPacketImpl(stream);
					
					if(p != null)
					{
						this.packetQueue_in.add(p);
					}
				}
				else
				{
					wait(100);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void runOutputThread()
	{
		try
		{
			OutputStream stream = socket.getOutputStream();
			
			while(isRunning)
			{
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}

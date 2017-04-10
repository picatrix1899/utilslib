package cmn.utilslib.net.server;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.net.common.PacketFactory;
import cmn.utilslib.net.common.PacketHandler;

public class ServerCore implements Runnable
{

	private ServerSocket socket;
	
	private volatile boolean isRunning;
	
	private ArrayList<ServerClientConnection> connections = Auto.ArrayList();
	
	private Thread th;
	
	
	public ServerCore(String address, int port, int maxConnections, PacketFactory factory, PacketHandler handler)
	{
		try
		{
			socket = new ServerSocket(port, maxConnections, InetAddress.getByName(address));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void start()
	{
		this.isRunning = true;
		this.th = new Thread(this);
		this.th.setDaemon(false);
		this.th.start();
	}
	
	public void stop()
	{
		this.isRunning = false;
	}
	
	public void run()
	{
		try
		{
			while(isRunning)
			{
				Socket s = socket.accept();
				
				s.setKeepAlive(true);
				
				connections.add(new ServerClientConnection(this, s));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}

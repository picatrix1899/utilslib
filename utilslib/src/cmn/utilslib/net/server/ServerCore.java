package cmn.utilslib.net.server;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCore implements Runnable
{

	private ServerSocket socket;
	
	private volatile boolean isRunning;
	
	public ServerCore(String address, int port, int maxConnections)
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
				
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}

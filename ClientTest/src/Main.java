import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import cmn.utilslib.essentials.SimpleThread;

public class Main
{
	
	public static void main(String[] args)
	{
		new Main();
	}

	
	
	private String name;
	
	public Main()
	{
		BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
		
		try
		{
			name = sin.readLine();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		new SimpleThread(() -> run()).start();

	}
	
	public void run()
	{
		try
		{
			Socket s = new Socket("localhost", 25566);
			if(!s.isConnected())
			{
				System.out.println("Failed to Connect!");
				s.close();
				return;
			}
			
			s.setKeepAlive(true);
			
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			
			dos.writeLong(0);
			dos.writeUTF(name);
			dos.flush();
			
			while(!s.isClosed())
			{
				if(System.in.available() > 0)
				{
					BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
					
					String st = sin.readLine();
					
					dos.writeLong(1);
					dos.writeUTF(st);
					dos.flush();
				}
				
				
				if(dis.available() > 0) 
				{
					dis.readLong();
					System.out.println(dis.readUTF());
				}
			}
			
			s.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}

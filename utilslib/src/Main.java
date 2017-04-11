

import cmn.utilslib.net.server.ServerCore;


public class Main
{

	public static void main(String[] args)
	{
		ServerCore core = new ServerCore("127.0.0.1", 25560, 2);
		
		core.addPacket(0, TestPacket.class);
	}

	
	
}

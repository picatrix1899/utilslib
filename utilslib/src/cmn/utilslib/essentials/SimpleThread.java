package cmn.utilslib.essentials;

public class SimpleThread
{
	
	Thread th;
	
	public SimpleThread()
	{
		this.th = new Thread(() -> run());
	}
	
	public SimpleThread(String name)
	{
		this();
		this.th.setName(name);
	}
	
	public SimpleThread(String name, boolean daemon)
	{
		this(name);
		this.th.setDaemon(daemon);
	}
	
	public SimpleThread(boolean daemon)
	{
		this();
		this.th.setDaemon(daemon);
	}
	
	public SimpleThread(Runnable r)
	{
		this.th = new Thread(r);
	}
	
	public SimpleThread(Runnable r, String name)
	{
		this(r);
		this.th.setName(name);
	}
	
	public SimpleThread(Runnable r, String name, boolean daemon)
	{
		this(r,name);
		this.th.setDaemon(daemon);
	}
	
	public SimpleThread(Runnable r, boolean daemon)
	{
		this(r);
		this.th.setDaemon(daemon);
	}
	
	public SimpleThread start()
	{
		th.start();
		
		return this;
	}
	
	public void run() { }
	
}

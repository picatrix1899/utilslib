package cmn.picatrix1899.utilslib.logging;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import cmn.picatrix1899.utilslib.essentials.ThreadWatcher;

public class Logger extends Thread
{
	
	private static final long INTERVAL = 100;
	
	private static HashMap<String,Logger> loggers = new HashMap<String,Logger>();
	
	public static Logger get(String name)
	{
		Thread t = ThreadWatcher.getByName("Logger " + name);
		
		if(t == null)
		{
			return null;
		}
		
		return (Logger)t;
	}
	
	private File f;
	
	public PrintStream stream;
	
	public Logger(String name, File file)
	{
		this.f = file;
		
		setDaemon(true);
		setName("Logger " + name);
		loggers.put(name, this);
	}
	
	public void startLogging()throws Exception
	{
		if(!f.exists())
		{
			f.mkdirs();
		}
		
		if(!f.isFile())
		{
			throw new Exception("Logger: expected a file as parameter!");
		}
		
		start();
	}
	
	public void run()
	{
		try
		{
			stream = new PrintStream(new FileOutputStream(f));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		while(!isInterrupted())
		{
			try
			{
				sleep(INTERVAL);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void stopLogging()
	{
		interrupt();
	}
}

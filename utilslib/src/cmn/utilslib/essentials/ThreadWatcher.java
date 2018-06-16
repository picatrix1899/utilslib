package cmn.utilslib.essentials;

public class ThreadWatcher
{
	public static Thread getByName(String name)
	{
		Thread[] threads = new Thread[Thread.activeCount()];
		Thread.enumerate(threads);
		
		for(Thread t : threads)
		{
			if(t.getName().equals(name))
			{
				return t;
			}
		}
		
		return null;
	}
}

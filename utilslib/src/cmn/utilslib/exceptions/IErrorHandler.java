package cmn.utilslib.exceptions;

public interface IErrorHandler
{
	public abstract void handle(Exception e);
	
	public default void watch(Watchable w)
	{
		try
		{
			w.watch();
		}
		catch(Exception e)
		{
			handle(e);
		}
	}
	
	public interface Watchable
	{
		public void watch() throws Exception;
	}
	
}

package cmn.utilslib.exceptions;

/**
 * 

 * @author picatrix1899
 *
 */
public class FastException
{
	public static void print(String msg)
	{
		try
		{
			throw new Exception(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void print(String msg, Class<? extends Exception> c)
	{
		try
		{
			
			Exception ex = c.getConstructor(String.class).newInstance(msg);
			
			throw ex;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void fatal(String msg)
	{
		try
		{
			throw new Exception(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static void fatal(String msg, Class<? extends Exception> c)
	{
		try
		{
			
			Exception ex = c.getConstructor(String.class).newInstance(msg);
			
			throw ex;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
}

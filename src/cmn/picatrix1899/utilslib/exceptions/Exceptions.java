package cmn.picatrix1899.utilslib.exceptions;

/**
 * 

 * @author picatrix1899
 *
 */
public enum Exceptions
{
	IndexOutOfBounds(IndexOutOfBoundsException.class),
	IndexOverflow(IndexOverflowException.class),
	IndexUnderflow(IndexUnderflowException.class),	
	IllegalArgument(IllegalArgumentException.class),
	NullPointer(NullPointerException.class)
	;
	
	private Class<? extends RuntimeException> c;
	
	private Exceptions(Class<? extends RuntimeException> c)
	{
		this.c = c;
	}
	
	public static void handle(Exceptions e, String msg)
	{
		Exceptions.handle(e.c, msg);	
	}
	
	public static void handle(Class<? extends RuntimeException> c, String msg)
	{
			try
			{
				throw (RuntimeException)c.getConstructor(String.class).newInstance(msg);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}			
	}
	
	public static void handle(Exceptions e)
	{
		Exceptions.handle(e.c);
	}
	
	public static void handle(Class<? extends RuntimeException> c)
	{
		
		try
		{
			throw (RuntimeException)c.getConstructor().newInstance();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}

}

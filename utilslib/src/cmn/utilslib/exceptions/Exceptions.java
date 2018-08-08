package cmn.utilslib.exceptions;

import java.util.Arrays;

import cmn.utilslib.validation.ValidationException;

/**
 * 

 * @author picatrix1899
 *
 */
public class Exceptions
{
	
	public static Class<? extends RuntimeException> IllegalArgument = IllegalArgumentException.class;
	
	public static void handle(RuntimeException e,  int stackreduction)
	{

				try
				{

					trimStack(e, stackreduction);
					
					throw e;
				}
				catch (Exception ex)
				{
					e.printStackTrace();
				}				
	}
	
	public static void handle(Class<? extends RuntimeException> c, String msg, int stackreduction)
	{

			try
			{
				RuntimeException ex = (RuntimeException)c.getConstructor(String.class).newInstance(msg);
				
				trimStack(ex, 5 + stackreduction);
				
				try
				{
					throw ex;
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}				
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
		
	}
	
	public static void trimStack(Exception e, int reduction)
	{
		StackTraceElement[] element = e.getStackTrace();
		
		element = Arrays.copyOfRange(element, reduction, element.length);
		
		e.setStackTrace(element);
	}
	
	public static void handle(Class<? extends RuntimeException> c, String msg)
	{

			try
			{
				RuntimeException ex = (RuntimeException)c.getConstructor(String.class).newInstance(msg);
				
				trimStack(ex, 5);
					
				try
				{
					throw ex;
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}	
				
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
		
	}
	
	public static void handle(Class<? extends RuntimeException> c)
	{
		

		try
		{
			RuntimeException ex = (RuntimeException)c.getConstructor().newInstance();
			
			trimStack(ex, 5);
				
			try
			{
				throw ex;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}	
			
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
		
	}

}

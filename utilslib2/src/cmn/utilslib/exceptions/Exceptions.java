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
	public static Class<? extends RuntimeException> Validation = ValidationException.class; 
	
	public static void handle(RuntimeException e,  int stackreduction)
	{

				try
				{
					StackTraceElement[] element = e.getStackTrace();
					
					element = Arrays.copyOfRange(element, 0 + stackreduction, element.length);
					
					e.setStackTrace(element);
					
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
				
				StackTraceElement[] element = ex.getStackTrace();
				
				element = Arrays.copyOfRange(element, 5 + stackreduction, element.length);
				
				ex.setStackTrace(element);
				
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
	
	public static void handle(Class<? extends RuntimeException> c, String msg)
	{

			try
			{
				RuntimeException ex = (RuntimeException)c.getConstructor(String.class).newInstance(msg);
				
				StackTraceElement[] element = ex.getStackTrace();
				
				element = Arrays.copyOfRange(element, 5, element.length);
				
				ex.setStackTrace(element);
					
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
			
			StackTraceElement[] element = ex.getStackTrace();
			
			element = Arrays.copyOfRange(element, 5, element.length);
			
			ex.setStackTrace(element);
				
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

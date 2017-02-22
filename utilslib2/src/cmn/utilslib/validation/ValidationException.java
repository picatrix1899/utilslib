package cmn.utilslib.validation;

import java.util.Arrays;
import java.util.List;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.exceptions.IErrorHandler;
import cmn.utilslib.exceptions.SimpleErrorHandler;

public class ValidationException extends RuntimeException
{
	
	private static final long serialVersionUID = 1L;
	private static IErrorHandler handler = new SimpleErrorHandler();
	
	
	
	protected List<String> details = Auto.newArrayList();
	private String type = "";
	
	
	
	public static void setErrorHandler(IErrorHandler handler)
	{
		ValidationException.handler = handler;
	}
	
	
	
	public ValidationException(String msg)
	{
		super(msg);
	}
	
	public ValidationException(String type, String msg)
	{
		super(msg);
		this.type = type;
	}
	
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("ValidationException ").append(this.type).append(": ").append(getLocalizedMessage()).append("\n");
		
		if(details.size() > 0)
		{
			builder.append("    Details:\n");
			for(String detail : details)
			{
				builder.append("\t").append(detail).append("\n");	
			}
		}
		
		builder.append("    StackTrace:");
		
		return builder.toString();
	}
	
	public void handle(int stackreduction)
	{
				try
				{
					StackTraceElement[] element = this.getStackTrace();
					
					element = Arrays.copyOfRange(element, 0 + stackreduction, element.length);
					
					this.setStackTrace(element);
					
					throw this;
				}
				catch (Exception ex)
				{
					handler.handle(ex);
				}				
	}
}

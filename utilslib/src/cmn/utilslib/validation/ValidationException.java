package cmn.utilslib.validation;

import java.util.Arrays;
import java.util.List;

import cmn.utilslib.essentials.Auto;

public class ValidationException extends Error
{
	private static final long serialVersionUID = 1L;
	
	protected List<String> details = Auto.ArrayList();
	private String type = "";
	
	
	
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
			StackTraceElement[] element = this.getStackTrace();
			
			element = Arrays.copyOfRange(element, 0 + stackreduction, element.length);
			
			this.setStackTrace(element);
			
			throw this;				
	}
}

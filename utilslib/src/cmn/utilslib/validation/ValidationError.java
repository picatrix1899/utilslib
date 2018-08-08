package cmn.utilslib.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cmn.utilslib.Utilslib;

public class ValidationError extends Error
{

	private static final long serialVersionUID = 1L;

	protected List<String> details = new ArrayList<String>();
	private String type = "";
	
	
	public ValidationError(String msg)
	{
		super(msg);
	}
	
	public ValidationError(String type, String msg)
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
	
	public void throwError(int stackreduction)
	{
		if(Utilslib.FLAG__USE_VALIDATION_STACKREDUCTION)
		{
			StackTraceElement[] element = this.getStackTrace();
			
			element = Arrays.copyOfRange(element, 0 + stackreduction, element.length);
			
			this.setStackTrace(element);
		}

		throw this;				
	}
	
}

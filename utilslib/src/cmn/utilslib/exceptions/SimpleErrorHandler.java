package cmn.utilslib.exceptions;

public class SimpleErrorHandler implements ErrorHandler
{

	public void handle(Exception e)
	{
		e.printStackTrace();
	}


}

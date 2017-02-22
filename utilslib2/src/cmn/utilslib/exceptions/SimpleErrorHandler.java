package cmn.utilslib.exceptions;

public class SimpleErrorHandler implements IErrorHandler
{

	public void handle(Exception e)
	{
		e.printStackTrace();
	}

}

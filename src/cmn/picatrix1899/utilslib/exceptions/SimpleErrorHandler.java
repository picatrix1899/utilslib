package cmn.picatrix1899.utilslib.exceptions;

import cmn.picatrix1899.utilslib.interfaces.ErrorHandler;

public class SimpleErrorHandler implements ErrorHandler
{

	public void handle(Exception e)
	{
		e.printStackTrace();
	}

}

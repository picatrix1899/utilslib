package cmn.picatrix1899.utilslib.exceptions;

/**
 * 

 * @author picatrix1899
 *
 */
public class IndexUnderflowException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	public IndexUnderflowException()
	{
		super();
	}
	
	public IndexUnderflowException(String msg)
	{
		super(msg);
	}
	
	public IndexUnderflowException(String msg, Throwable thrw)
	{
		super(msg, thrw);
	}
	
	public IndexUnderflowException(Throwable thrw)
	{
		super(thrw);
	}

}

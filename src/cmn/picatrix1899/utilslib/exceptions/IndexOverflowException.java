package cmn.picatrix1899.utilslib.exceptions;

/**
 * 

 * @author picatrix1899
 *
 */
public class IndexOverflowException extends RuntimeException
{
	
	private static final long serialVersionUID = 1L;
	
	public IndexOverflowException()
	{
		super();
	}
	
	public IndexOverflowException(String msg)
	{
		super(msg);
	}
	
	public IndexOverflowException(String msg, Throwable thrw)
	{
		super(msg, thrw);
	}
	
	public IndexOverflowException(Throwable thrw)
	{
		super(thrw);
	}

}

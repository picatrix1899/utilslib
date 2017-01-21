package cmn.picatrix1899.utilslib.exceptions;


public class Validation_IsNullException extends RuntimeException
{
	
	private static final long serialVersionUID = 1L;

	public Validation_IsNullException()
	{
		super("Objective is null");
	}
	
	public Validation_IsNullException(Class<?> c)
	{
		super("<" + c.getSimpleName() + "> Objective is Null");
	}
}

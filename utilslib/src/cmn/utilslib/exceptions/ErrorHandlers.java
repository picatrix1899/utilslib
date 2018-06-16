package cmn.utilslib.exceptions;

public class ErrorHandlers
{
	public static final CaptureErrorHandler CAPTURE = new CaptureErrorHandler();
	public static final EmptyErrorHandler VOID = new EmptyErrorHandler();
	public static final SimpleErrorHandler SIMPLE = new SimpleErrorHandler();
}

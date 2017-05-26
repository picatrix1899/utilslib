package cmn.utilslib.events;

public class EmptyArgs implements EventArgs
{
	
	private static final EmptyArgs instance = new EmptyArgs();
	
	public static EmptyArgs getInstance()
	{
		return instance;
	}
	
	private EmptyArgs() {  }

	@Override
	public EmptyArgs cloneArgs()
	{
		return getInstance();
	}
}

package cmn.utilslib.events;


public abstract class Event
{
	public abstract EventHandle getHandle();
	
	public void raise()
	{
		getHandle().raise(this);
	}
}

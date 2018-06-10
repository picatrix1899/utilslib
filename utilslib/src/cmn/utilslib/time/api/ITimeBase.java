package cmn.utilslib.time.api;

public interface ITimeBase
{
	byte hour();
	byte minute();
	byte second();
	
	default ITime copy(ITime time) { return time.set(this); }
	
	boolean isValid();
}

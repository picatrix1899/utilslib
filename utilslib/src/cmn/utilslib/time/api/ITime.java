package cmn.utilslib.time.api;

public interface ITime extends ITimeBase
{
	ITime hour(int hour);
	ITime hour(byte hour);
	ITime minute(int minute);
	ITime minute(byte minute);
	ITime second(int second);
	ITime second(byte second);
	
	ITime set(int hour, int minute);
	ITime set(byte hour, byte minute);
	ITime set(int hour, int minute, int second);
	ITime set(byte hour, byte minute, byte second);
	ITime set(ITimeBase time);
}

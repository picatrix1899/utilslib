package cmn.utilslib.time;

public class TimeSpan
{
	public long hours;
	public long minutes;
	public long seconds;
	
	public TimeSpan()
	{
		
	}
	
	public TimeSpan(long hours, long minutes, long seconds)
	{
		
	}
	
	public static TimeSpan fromTime(Time time)
	{
		TimeSpan span = new TimeSpan();
		span.hours = time.hour;
		span.minutes = time.minute;
		span.seconds = time.second;
		return null;
	}
	
	public static TimeSpan fromTimes(Time start, Time end)
	{
		return null;
	}
}

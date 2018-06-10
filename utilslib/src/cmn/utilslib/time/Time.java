package cmn.utilslib.time;

import cmn.utilslib.time.api.ITime;
import cmn.utilslib.time.api.ITimeBase;

public class Time implements ITime
{ 
	public byte hour = 0;
	public byte minute = 0;
	public byte second = 0;
	
	public Time()
	{
		this.hour = 0;
		this.second = 0;
		this.minute = 0;
	}
	
	public Time(int hour, int minute)
	{
		this.hour = (byte)hour;
		this.minute = (byte)minute;
		this.second = 0;
	}
	
	public Time(byte hour, byte minute)
	{
		this.hour = hour;
		this.minute = minute;
		this.second = 0;
	}
	
	public Time(int hour, int minute, int second)
	{
		this.hour = (byte)hour;
		this.minute = (byte)minute;
		this.second = (byte)second;
	}
	
	public Time(byte hour, byte minute, byte second)
	{
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public Time(ITimeBase time)
	{
		this.hour = time.hour();
		this.minute = time.minute();
		this.second = time.second();
	}
	
	public Time hour(int hour) { this.hour = (byte)hour; return this;  }
	public Time hour(byte hour) { this.hour = hour; return this; }
	
	public Time minute(int minute) { this.minute = (byte)minute; return this; }
	public Time minute(byte minute) { this.minute = minute; return this; }
	
	public Time second(int second) { this.second = (byte)second; return this; }
	public Time second(byte second) { this.second = second; return this; }
	
	public Time set(int hour, int minute, int second)
	{
		this.hour = (byte)hour;
		this.minute = (byte)minute;
		this.second = (byte)second;
		return this;
	}
	
	public Time set(byte hour, byte minute, byte second)
	{
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		return this;
	}
	
	public Time set(int hour, int minute)
	{
		this.hour = (byte)hour;
		this.minute = (byte)minute;
		this.second = 0;
		return this;
	}
	
	public Time set(byte hour, byte minute)
	{
		this.hour = hour;
		this.minute = minute;
		this.second = 0;
		return this;
	}
	
	
	public Time set(ITimeBase time)
	{
		this.hour = time.hour();
		this.minute = time.minute();
		this.second = time.second();
		
		return this;
	}
	
	public byte hour() { return this.hour; }
	
	public byte minute() { return this.minute; }
	
	public byte second() { return this.second; }

	@Override
	public boolean isValid()
	{
		if(hour < 0 || hour > 23) return false;
		if(minute < 0 || minute > 59) return false;
		if(second < 0 || second > 59) return false;
		
		return true;
	}
}

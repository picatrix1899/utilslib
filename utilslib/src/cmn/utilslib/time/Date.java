package cmn.utilslib.time;

import cmn.utilslib.time.api.IDate;
import cmn.utilslib.time.api.IDateBase;

public class Date implements IDate
{
	
	public static final Date INVALID = new Date() {public boolean isValid() { return false; } };
	
	public int year;
	public byte month;
	public byte day;
	public boolean bc;

	
	public Date()
	{
		this.year = 0001;
		this.month = 01;
		this.day = 01;
		this.bc = false;
	}
	
	public Date(int year, byte month, byte day)
	{
		this.year = year;
		this.month = month;
		this.day = day;
		this.bc = false;
	}
	
	public Date(int year, int month, int day)
	{
		this.year = year;
		this.month = (byte)month;
		this.day = (byte)day;
		this.bc = false;
	}
	
	public Date(int year, byte month, byte day, boolean bc)
	{
		this.year = year;
		this.month = month;
		this.day = day;
		this.bc = bc;
	}
	
	public Date(int year, int month, int day, boolean bc)
	{
		this.year = year;
		this.month = (byte)month;
		this.day = (byte)day;
		this.bc = bc;
	}
	
	public Date(Date date)
	{
		this.year = date.year;
		this.month = date.month;
		this.day = date.day;
		this.bc = date.bc;
	}
	
	@Override
	public Date set(int year, byte month, byte day)
	{
		this.year = year;
		this.month = month;
		this.day = day;
		return this;
	}
	
	@Override
	public Date set(int year, int month, int day)
	{
		this.year = year;
		this.month = (byte)month;
		this.day = (byte)day;
		return this;
	}
	
	@Override
	public Date set(int year, byte month, byte day, boolean bc)
	{
		this.year = year;
		this.month = month;
		this.day = day;
		this.bc = bc;
		return this;
	}
	
	@Override
	public Date set(int year, int month, int day, boolean bc)
	{
		this.year = year;
		this.month = (byte)month;
		this.day = (byte)day;
		this.bc = bc;
		return this;
	}
	
	@Override
	public Date set(IDateBase date)
	{
		this.year = date.year();
		this.month = date.month();
		this.day = date.day();
		this.bc = date.beforeChrist();
		return this;
	}
	
	public Date set(Date date)
	{
		this.year = date.year;
		this.month = date.month;
		this.day = date.day;
		return this;
	}
	
	@Override
	public boolean isValid()
	{
		if(this.year < 0)  return false;
		if(this.month < 1 || this.month > 12) return false;
		if(this.day < 1 || this.day > 31) return false;
		
		return true;
	}
	
	@Override
	public int year() { return this.year; }
	
	@Override
	public byte month() { return this.month; }
	
	@Override
	public byte day() { return this.day; }
	
	@Override
	public boolean beforeChrist() { return this.bc; }

	@Override
	public Date year(int year) { this.year = year; return this; }

	@Override
	public Date month(byte month) { this.month = month; return this; }

	@Override
	public Date month(int month) { this.month = (byte)month; return this; }
		
	@Override
	public Date day(byte day) { this.day = day; return this; }

	@Override
	public Date day(int day) { this.day = (byte)day; return this; }

	@Override
	public Date beforeChrist(boolean bc) {  this.bc = bc; return this; }
	
	public boolean equals(Object obj)
	{
		if(obj instanceof IDateBase)
		{
			IDateBase d = (IDateBase)obj;
			
			if(this.isValid() != d.isValid()) return false;
			if(this.year != d.year()) return false;
			if(this.month != d.month()) return false;
			if(this.day != d.day()) return false;
			if(this.bc != d.beforeChrist()) return false;
			
			return true;
		}
		
		return false;
	}

}

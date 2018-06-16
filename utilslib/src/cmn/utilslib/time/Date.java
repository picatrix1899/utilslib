package cmn.utilslib.time;

import cmn.utilslib.time.api.IDate;
import cmn.utilslib.time.api.IDateBase;

public class Date implements IDate
{
	public int year;
	public byte month;
	public byte day;
	
	public Date()
	{
		this.year = 0001;
		this.month = 01;
		this.day = 01;
	}
	
	public Date(int year, byte month, byte day)
	{
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public Date(int year, int month, int day)
	{
		this.year = year;
		this.month = (byte)month;
		this.day = (byte)day;
	}
	
	public Date(Date date)
	{
		this.year = date.year;
		this.month = date.month;
		this.day = date.day;
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
	public Date set(IDateBase date)
	{
		this.year = date.year();
		this.month = date.month();
		this.day = date.day();
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
	public Date year(int year) { this.year = year; return this; }

	@Override
	public Date month(byte month) { this.month = month; return this; }

	@Override
	public Date month(int month) { this.month = (byte)month; return this; }
		
	@Override
	public Date day(byte day) { this.day = day; return this; }

	@Override
	public Date day(int day) { this.day = (byte)day; return this; }

	public boolean equals(Object o)
	{
		if(o instanceof Date)
		{
			Date d = (Date)o;
			
			if(this.year != d.year) return false;
			if(this.month != d.month) return false;
			if(this.day != d.day) return false;
		
			return true;
		}
		
		return false;
	}
}

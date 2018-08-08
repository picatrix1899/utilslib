package cmn.utilslib.time;

import cmn.utilslib.time.api.IDateBase;

public abstract class PDate implements IDateBase
{
	public static PDate gen(int year, int month, int day)
	{
		return gen(year, month, day, false);
	}
	
	public static PDate gen(int year, int month, int day, boolean bc)
	{
		return new PDate() {

			@Override
			public int year() { return year; }

			@Override
			public byte month() { return (byte)month; }

			@Override
			public byte day() { return (byte)day; }

			@Override
			public boolean isValid() { return true; }

			@Override
			public boolean beforeChrist() { return bc; }
			
		};
	}
}

package cmn.utilslib.time;

public enum Month
{
	JANUARY,
	FEBRUARY,
	MARCH,
	APRIL,
	MAI,
	JUNE,
	JULY,
	AUGUST,
	SEMPTEMBER,
	OCTOBER,
	NOVEMBER,
	DECEMBER;
	
	public int getNumericMonth()
	{
		return ordinal() + 1;
	}
	
	public static Month getFromIndex(int index)
	{
		Month[] months = values();
		
		if(index < 0 || index >= months.length) return null;
		
		return months[index];
	}
	
	public static Month get(int month)
	{
		return getFromIndex(month - 1);
	}
}

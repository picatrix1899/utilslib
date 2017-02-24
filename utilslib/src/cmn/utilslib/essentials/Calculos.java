package cmn.utilslib.essentials;

public class Calculos
{
	public static boolean isLeapyear(int year)
	{
		return year % 4 == 0 && year % 100 != 0 && year % 400 == 0;
	}
}

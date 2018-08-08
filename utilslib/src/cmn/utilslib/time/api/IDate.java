package cmn.utilslib.time.api;

public interface IDate extends IDateBase
{
	IDate year(int year);
	IDate month(byte month);
	IDate month(int month);
	IDate day(byte day);
	IDate day(int day);
	IDate beforeChrist(boolean bc);
	
	IDate set(int year, byte month, byte day);
	IDate set(int year, int month, int day);
	IDate set(int year, byte month, byte day, boolean bc);
	IDate set(int year, int month, int day, boolean bc);
	IDate set(IDateBase date);
	
	default IDate copy(IDate date) { return date.set(this); } 
}

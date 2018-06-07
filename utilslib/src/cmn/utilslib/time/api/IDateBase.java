package cmn.utilslib.time.api;

import cmn.utilslib.time.PDate;

public interface IDateBase
{
	public static final PDate MIN = PDate.gen(0001, 01, 01);
	public static final PDate MAX = PDate.gen(9999, 12, 31);
	
	int year();
	byte month();
	byte day();
	
	boolean isValidDate();
}

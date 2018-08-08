package cmn.utilslib.time.api;

import cmn.utilslib.time.PDate;

public interface IDateBase
{
	public static final PDate MIN_BC = PDate.gen(0001, 01, 01, true);
	public static final PDate MAX_BC = PDate.gen(9999, 12, 31, true);
	public static final PDate MIN_AC = PDate.gen(0001, 01, 01, false);
	public static final PDate MAX_AC = PDate.gen(9999, 12, 31, false);
	
	int year();
	byte month();
	byte day();
	boolean beforeChrist();
	
	boolean isValid();
}

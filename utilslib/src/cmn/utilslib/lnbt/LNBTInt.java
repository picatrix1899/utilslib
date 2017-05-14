package cmn.utilslib.lnbt;

import java.io.Serializable;

public class LNBTInt implements LNBTValue, Serializable
{
	private static final long serialVersionUID = 1L;

	private int value;
	
	public LNBTInt() { }
	
	public LNBTInt(int value) { this.value = value; }
	
	public int getValue()
	{
		return this.value;
	}
}

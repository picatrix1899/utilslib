package cmn.utilslib.lnbt;

import java.io.Serializable;

public class LNBTShort implements LNBTValue, Serializable
{
	private static final long serialVersionUID = 1L;

	private short value;
	
	public LNBTShort() { }
	
	public LNBTShort(short value) { this.value = value; }
	
	public short getValue()
	{
		return this.value;
	}
}

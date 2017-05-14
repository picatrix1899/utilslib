package cmn.utilslib.lnbt;

import java.io.Serializable;

public class LNBTBoolean implements LNBTValue, Serializable
{
	private static final long serialVersionUID = 1L;

	private boolean value;
	
	public LNBTBoolean() { }
	
	public LNBTBoolean(boolean value) { this.value = value; }
	
	public boolean getValue()
	{
		return this.value;
	}
}

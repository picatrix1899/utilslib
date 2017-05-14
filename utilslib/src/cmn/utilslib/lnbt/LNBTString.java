package cmn.utilslib.lnbt;

import java.io.Serializable;

public class LNBTString implements LNBTValue, Serializable
{
	private static final long serialVersionUID = 1L;

	private String value;
	
	public LNBTString() { }
	
	public LNBTString(String value) { this.value = value; }
	
	public String getValue()
	{
		return this.value;
	}
}

package cmn.utilslib.lnbt;

import java.io.Serializable;

public class LNBTChar implements LNBTValue, Serializable
{
	private static final long serialVersionUID = 1L;

	private char value;
	
	public LNBTChar() { }
	
	public LNBTChar(char value) { this.value = value; }
	
	public char getValue()
	{
		return this.value;
	}
}

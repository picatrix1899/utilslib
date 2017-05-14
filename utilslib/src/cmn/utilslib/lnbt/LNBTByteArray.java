package cmn.utilslib.lnbt;

import java.io.Serializable;

public class LNBTByteArray implements LNBTValue, Serializable
{
	private static final long serialVersionUID = 1L;

	private byte[] value;
	
	public LNBTByteArray() { }
	
	public LNBTByteArray(byte... value) { this.value = value; }
	
	public byte[] getValue()
	{
		return this.value;
	}
}

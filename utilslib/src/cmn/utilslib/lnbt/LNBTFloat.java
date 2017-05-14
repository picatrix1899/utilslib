package cmn.utilslib.lnbt;

import java.io.Serializable;

public class LNBTFloat implements LNBTValue, Serializable
{
	private static final long serialVersionUID = 1L;

	private float value;
	
	public LNBTFloat() { }
	
	public LNBTFloat(float value) { this.value = value; }
	
	public float getValue()
	{
		return this.value;
	}
}

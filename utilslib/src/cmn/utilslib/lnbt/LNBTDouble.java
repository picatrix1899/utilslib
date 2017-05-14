package cmn.utilslib.lnbt;

import java.io.Serializable;

public class LNBTDouble implements LNBTValue, Serializable
{
	private static final long serialVersionUID = 1L;

	private double value;
	
	public LNBTDouble() { }
	
	public LNBTDouble(double value) { this.value = value; }
	
	public double getValue()
	{
		return this.value;
	}
}

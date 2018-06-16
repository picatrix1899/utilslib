package cmn.utilslib.lnbt;

public class LNBTDouble implements LNBTValue
{
	private static final long serialVersionUID = 1L;

	private double value;
	
	public LNBTDouble() { }
	
	public LNBTDouble(double value) { this.value = value; }
	
	public double getValue() { return this.value; }
}

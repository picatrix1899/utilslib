package cmn.utilslib.lnbt;

public class LNBTBoolean implements LNBTValue
{
	private static final long serialVersionUID = 1L;

	private boolean value;
	
	public LNBTBoolean() { }
	
	public LNBTBoolean(boolean value) { this.value = value; }
	
	public boolean getValue() { return this.value; }
}

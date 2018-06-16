package cmn.utilslib.lnbt;

public class LNBTShort implements LNBTValue
{
	private static final long serialVersionUID = 1L;

	private short value;
	
	public LNBTShort() { }
	
	public LNBTShort(short value) { this.value = value; }
	
	public short getValue() { return this.value; }
}

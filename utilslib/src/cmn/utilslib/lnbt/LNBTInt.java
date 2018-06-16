package cmn.utilslib.lnbt;


public class LNBTInt implements LNBTValue
{
	private static final long serialVersionUID = 1L;

	private int value;
	
	public LNBTInt() { }
	
	public LNBTInt(int value) { this.value = value; }
	
	public int getValue() { return this.value; }
}

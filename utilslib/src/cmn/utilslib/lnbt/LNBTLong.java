package cmn.utilslib.lnbt;



public class LNBTLong implements LNBTValue
{
	private static final long serialVersionUID = 1L;

	private long value;
	
	public LNBTLong() { }
	
	public LNBTLong(long value) { this.value = value; }
	
	public long getValue() { return this.value; }
}

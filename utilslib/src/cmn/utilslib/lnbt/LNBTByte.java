package cmn.utilslib.lnbt;

public class LNBTByte implements LNBTValue
{
	private static final long serialVersionUID = 1L;

	private byte value;
	
	public LNBTByte() { }
	
	public LNBTByte(byte value) { this.value = value; }
	
	public byte getValue() { return this.value; }
}

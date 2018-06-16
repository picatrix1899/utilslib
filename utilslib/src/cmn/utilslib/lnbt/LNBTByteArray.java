package cmn.utilslib.lnbt;

public class LNBTByteArray implements LNBTValue
{
	private static final long serialVersionUID = 1L;

	private byte[] value;
	
	public LNBTByteArray() { }
	
	public LNBTByteArray(byte... value) { this.value = value; }
	
	public byte[] getValue() { return this.value; }
}

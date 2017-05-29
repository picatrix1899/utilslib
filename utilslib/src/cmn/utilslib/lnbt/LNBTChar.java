package cmn.utilslib.lnbt;


public class LNBTChar implements LNBTValue
{
	private static final long serialVersionUID = 1L;

	private char value;
	
	public LNBTChar() { }
	
	public LNBTChar(char value) { this.value = value; }
	
	public char getValue() { return this.value; }
}

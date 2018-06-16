package cmn.utilslib.lnbt;

public class LNBTString implements LNBTValue
{
	private static final long serialVersionUID = 1L;

	private String value;
	
	public LNBTString() { }
	
	public LNBTString(String value) { this.value = value; }
	
	public String getValue() { return this.value; }
}

package cmn.utilslib.lnbt;

public class LNBTFloat implements LNBTValue
{
	private static final long serialVersionUID = 1L;

	private float value;
	
	public LNBTFloat() { }
	
	public LNBTFloat(float value) { this.value = value; }
	
	public float getValue() { return this.value; }
}

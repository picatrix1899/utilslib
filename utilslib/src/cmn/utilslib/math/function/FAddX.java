package cmn.utilslib.math.function;

public class FAddX implements FunctionX
{
	public FunctionX a;
	public FunctionX b;
	
	@Override
	public double get(double x)
	{
		return this.a.get(x) + this.b.get(x);
	}
}

package cmn.utilslib.math.function;

public class FLinearX implements FunctionX
{
	public FunctionX a;
	public FunctionX b;
	
	@Override
	public double get(double x)
	{
		return this.a.get(x) * x + this.b.get(x);
	}
}

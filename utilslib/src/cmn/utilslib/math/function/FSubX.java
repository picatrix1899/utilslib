package cmn.utilslib.math.function;

public class FSubX implements FunctionX
{
	
	public FunctionX a;
	public FunctionX b;
	
	public double get(double x)
	{
		return this.a.get(x) - this.b.get(x);
	}
}

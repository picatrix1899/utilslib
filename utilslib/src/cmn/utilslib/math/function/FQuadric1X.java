package cmn.utilslib.math.function;

public class FQuadric1X implements FunctionX
{
	public FunctionX a;
	public FunctionX b;
	public FunctionX c;
	
	public double get(double x)
	{
		return this.a.get(x) * (x * x) + this.b.get(x) * x + this.c.get(x);
	}

}

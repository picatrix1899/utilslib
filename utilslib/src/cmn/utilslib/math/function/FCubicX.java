package cmn.utilslib.math.function;

public class FCubicX implements FunctionX
{
	
	public FunctionX a;
	public FunctionX b;
	public FunctionX c;
	public FunctionX d;
	
	
	/*
	 * 
	 * a : wide
	 * b : x-shifting
	 * c : bending
	 * d : y-Offset
	 * 
	 */
	
	@Override
	public double get(double x)
	{
		return this.a.get(x) * (x * x * x) + this.b.get(x) * (x * x) + this.c.get(x) * x + this.get(x);
	}
}

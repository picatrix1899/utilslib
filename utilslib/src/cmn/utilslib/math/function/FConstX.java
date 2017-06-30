package cmn.utilslib.math.function;

public class FConstX implements FunctionX
{
	public double value;
	
	@Override
	public double get(double x)
	{
		return this.value;
	}
}

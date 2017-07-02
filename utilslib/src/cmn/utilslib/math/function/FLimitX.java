package cmn.utilslib.math.function;

public class FLimitX implements FunctionX
{
	public FunctionX a;
	public FunctionX min;
	public FunctionX max;
	
	@Override
	public double get(double x)
	{
		double _a = this.a.get(x);
		double _min = this.min.get(x);
		double _max = this.max.get(x);
		
		return _a <= _min ? _min : _a >= _max ? _max : _a;
	}
}

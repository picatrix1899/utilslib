package cmn.utilslib.math;

public class SigmaSum
{
	public int start;
	public int end;
	public SigmaSumAlgorythm algorythm;
	
	public SigmaSum(int start, int end, SigmaSumAlgorythm algorythm)
	{
		this.start = start;
		this.end = end;
		this.algorythm = algorythm;
	}
	
	public double start()
	{
		double out = 0;
		
		for(int i = this.start; i <= this.end; i++)
		{
			out += this.algorythm.step(i);
		}
		
		return out;
	}
	
	public interface SigmaSumAlgorythm
	{
		double step(int index);
	}
}

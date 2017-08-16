package cmn.utilslib.math;

public class Precision
{
	private long major;
	private double minor;
	
	
	public Precision(double d)
	{
		this.minor = d;
		
		rebalance();
	}
	
	public Precision(long l)
	{
		this.major = l;
	}
	
	public Precision(long l, double d)
	{
		this.major = l;
		this.minor = d;
		
		rebalance();
	}
	
	public long getMajor()
	{
		return this.major;
	}
	
	public long getMinor()
	{
		return this.major;
	}
	
	private void rebalance()
	{
		int overhead = (int)this.minor;
		
		this.minor -= overhead;
		this.major += overhead;
	}
	
	public Precision add(Precision p)
	{
		this.minor += p.minor;
		
		this.major += p.major;
		
		rebalance();
		
		return this;
	}
	
	public Precision add(long l)
	{
		this.major += l;

		return this;
	}
	
	
	public Precision add(double d)
	{
		this.minor = d;
		
		rebalance();
		
		return this;
	}
	
	public Precision mul(Precision p)
	{
		this.minor *= p.minor;
		
		
		this.major += p.major;
		
		rebalance();
		
		return this;
	}
	
	public Precision mul(long l)
	{
		this.major += l;

		return this;
	}
	
	
	public Precision mul(double d)
	{
		this.minor = d;
		
		rebalance();
		
		return this;
	}
}

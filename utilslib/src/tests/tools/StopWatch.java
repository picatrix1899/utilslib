package tests.tools;


public class StopWatch
{
	
	private long startTime;
	private long stopTime;
	private long time;
	
	public void start()
	{
		this.startTime = System.nanoTime();
	}
	
	public void stop()
	{
		this.stopTime = System.nanoTime();
		this.time = this.stopTime - this.startTime;
	}
	
	public void reset()
	{
		this.startTime = 0;
		this.stopTime = 0;
		this.time = 0;
	}
	
	public long nano()
	{
		return this.time;
	}
	
	public long micro()
	{
		return Math.round(this.time / 1000.0D);
	}
	
	public long milli()
	{
		return Math.round(this.time / 1000.0D / 1000.0D);
	}
	
}

package cmn.utilslib.essentials;

import java.util.HashMap;

public class Profiler
{
	private HashMap<String, Long> startTimes = Auto.HashMap();
	private HashMap<String, Long> stopTimes = Auto.HashMap();
	private HashMap<String, Long> times = Auto.HashMap();
	private HashMap<String, Boolean> running = Auto.HashMap();
	
	public void start(String profile)
	{
		this.startTimes.put(profile, System.nanoTime());
		this.running.put(profile, true);
	}
	
	public void stop(String profile)
	{
		if(this.running.containsKey(profile))
		{
			if(this.running.get(profile))
			{
				this.stopTimes.put(profile, System.nanoTime());
				this.times.put(profile, this.stopTimes.get(profile) - this.startTimes.get(profile));
				this.running.put(profile, false);
			}
		}

	}
	
	public void reset(String profile)
	{
		this.startTimes.remove(profile);
		this.stopTimes.remove(profile);
		this.times.remove(profile);
		this.running.remove(profile);
	}
	
	public void resetAll()
	{
		this.startTimes.clear();
		this.stopTimes.clear();
		this.times.clear();
		this.running.clear();
	}
	
	public long nano(String profile)
	{
		if(this.times.containsKey(profile))
		{
			return this.times.get(profile);
		}
		
		return 0;
	}
	
	public long micro(String profile)
	{
		return Math.round(nano(profile) / 1000.0D);
	}
	
	public long milli(String profile)
	{
		return Math.round(nano(profile) / 1000.0D / 1000.0D);
	} 
	
}

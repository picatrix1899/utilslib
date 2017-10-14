package cmn.utilslib.essentials;

import cmn.utilslib.dmap.dmappings.DMapping2;

public class DistributedMapping<T>
{

	private DMapping2<Long,T> map = Auto.DMapping2();
	
	private long total = 0;
	
	public void add(long fraction, T obj)
	{
		
		total += fraction;
		
		map.add(fraction, obj);
		
	}
	
}

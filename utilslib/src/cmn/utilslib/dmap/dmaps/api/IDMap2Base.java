package cmn.utilslib.dmap.dmaps.api;

import cmn.utilslib.essentials.Check;

public interface IDMap2Base<A,B>
{
	/**
	 * Gets entry A
	 * @return The value
	**/
	A getA();
	
	/**
	 * Gets entry B
	 * @return The value
	 */
	B getB();
	
	default boolean equals(IDMap2Base<?,?> d)
	{
		if(!(Check.isSaveEqual(this.getA(), d.getA()))) return false;
		if(!(Check.isSaveEqual(this.getB(), d.getB()))) return false;
			
		return true;
	}
	
}

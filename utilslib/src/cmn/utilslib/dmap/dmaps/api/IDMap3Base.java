package cmn.utilslib.dmap.dmaps.api;

import cmn.utilslib.essentials.Check;

public interface IDMap3Base<A,B,C>
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
	
	/**
	 * Gets entry C
	 * @return The value
	 */
	C getC();
	
	
	
	default boolean equals(IDMap3Base<?,?,?> d)
	{
		if(!(Check.isSaveEqual(this.getA(), d.getA()))) return false;
		if(!(Check.isSaveEqual(this.getB(), d.getB()))) return false;
		if(!(Check.isSaveEqual(this.getC(), d.getC()))) return false;
			
		return true;
	}
}

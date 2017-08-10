package cmn.utilslib.dmap.dmaps.api;

import cmn.utilslib.essentials.Check;

public interface IDMap4Base<A,B,C,D>
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
	
	/**
	 * Gets entry D
	 * @return The value
	 */
	D getD();
	
	default boolean equals(IDMap4Base<?,?,?,?> d)
	{
		if(!(Check.isSaveEqual(this.getA(), d.getA()))) return false;
		if(!(Check.isSaveEqual(this.getB(), d.getB()))) return false;
		if(!(Check.isSaveEqual(this.getC(), d.getC()))) return false;
		if(!(Check.isSaveEqual(this.getD(), d.getD()))) return false;
		
		return true;
	}
}

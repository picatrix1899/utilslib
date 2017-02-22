package cmn.utilslib.interfaces;

public interface IObjectable<T>
{
	/**
	 * compare two instances
	 * @param obj : the instance to compare with
	 * @return 
	 */
	@Override
	public boolean equals(Object obj);
	
	/**
	 * print the instance to String
	 * @return the instance as String
	 */
	@Override
	public String toString();
	
	/**
	 * print the instance to String based on a parser
	 * @return the instance as String
	 */
	public String toString(IStringParser<T> parser);
	
	/**
	 * clones the current instance to a new instance
	 * @return a new instance of the current instance
	 */
	public T clone();
}

package cmn.utilslib.math.tuple.api;

public interface Tup5fBase
{
	/** Returns the count of Dimensions of the Vector. */
	default int getDimensions() { return 5; }
	
	float get(int index);
	
	Tup5f clone();
}

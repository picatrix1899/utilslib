package cmn.utilslib.math.tuple.api;

public interface Tup2fBase
{
	
	/** Returns the count of Dimensions of the Vector. */
	default int getDimensions() { return 2; }
	
	float get(int index);
	
	Tup2f clone();
	
}

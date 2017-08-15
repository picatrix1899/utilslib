package cmn.utilslib.math.tuple.api;

public interface Tup6fBase
{
	/** Returns the count of Dimensions of the Vector. */
	default int getDimensions() { return 6; }
	
	float get(int index);
	
	Tup6f clone();
}

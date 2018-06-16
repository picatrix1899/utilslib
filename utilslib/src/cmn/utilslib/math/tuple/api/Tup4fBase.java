package cmn.utilslib.math.tuple.api;

public interface Tup4fBase
{
	/** Returns the count of Dimensions of the Vector. */
	default int getDimensions() { return 4; }
	
	float get(int index);
	
	Tup4f clone();
}

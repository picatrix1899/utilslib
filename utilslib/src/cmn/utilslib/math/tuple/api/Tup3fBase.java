package cmn.utilslib.math.tuple.api;

public interface Tup3fBase
{
	/** Returns the count of Dimensions of the Vector. */
	default int getDimensions() { return 3; }
	
	float get(int index);
	
	Tup3f clone();
}

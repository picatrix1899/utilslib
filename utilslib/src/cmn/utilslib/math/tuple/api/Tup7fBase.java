package cmn.utilslib.math.tuple.api;

public interface Tup7fBase
{
	/** Returns the count of Dimensions of the Vector. */
	default int getDimensions() { return 7; }
	
	float get(int index);
	
	Tup7f clone();
}

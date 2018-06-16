package cmn.utilslib.math.tuple.api;

public interface Tup4dBase
{
	/** Returns the count of Dimensions of the Vector. */
	default int getDimensions() { return 4; }
	
	double get(int index);
	
	Tup4d clone();
}

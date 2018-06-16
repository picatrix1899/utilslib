package cmn.utilslib.math.tuple.api;

public interface Tup2dBase
{
	/** Returns the count of Dimensions of the Vector. */
	default int getDimensions() { return 2; }
	
	double get(int index);
	
	Tup2d clone();
}

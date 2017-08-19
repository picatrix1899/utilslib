package cmn.utilslib.math.tuple.api;

public interface Tup6dBase
{
	/** Returns the count of Dimensions of the Vector. */
	default int getDimensions() { return 6; }
	
	double get(int index);
	
	Tup6d clone();
}

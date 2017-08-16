package cmn.utilslib.math.tuple.api;

public interface Tup5dBase
{
	/** Returns the count of Dimensions of the Vector. */
	default int getDimensions() { return 5; }
	
	double get(int index);
	
	Tup5d clone();
}

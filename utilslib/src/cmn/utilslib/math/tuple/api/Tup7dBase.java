package cmn.utilslib.math.tuple.api;

public interface Tup7dBase
{
	/** Returns the count of Dimensions of the Vector. */
	default int getDimensions() { return 7; }
	
	double get(int index);
	
	Tup7d clone();
}

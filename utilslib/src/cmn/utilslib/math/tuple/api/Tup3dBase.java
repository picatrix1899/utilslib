package cmn.utilslib.math.tuple.api;

public interface Tup3dBase
{
	/** Returns the count of Dimensions of the Vector. */
	default int getDimensions() { return 3; }
	
	double get(int index);
	
	Tup3d clone();
}

package cmn.utilslib.math.vector.api;

import java.util.Iterator;

import cmn.utilslib.math.vector.VectorfIterator;

public interface Vecf extends Iterable<Float>
{
	
	int getDimensions();
	
	float get(int index);
	
	default Iterator<Float> iterator() { return new VectorfIterator(this); }
}

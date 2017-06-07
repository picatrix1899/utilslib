package cmn.utilslib.math.vector.api;

import java.util.Iterator;

import cmn.utilslib.math.vector.VectordIterator;

public interface Vecd extends Iterable<Double>
{
	
	int getDimensions();
	
	double get(int index);
	
	default Iterator<Double> iterator() { return new VectordIterator(this); }
}
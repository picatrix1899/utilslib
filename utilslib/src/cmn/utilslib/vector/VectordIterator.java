package cmn.utilslib.vector;

import java.util.Iterator;

import cmn.utilslib.vector.api.Vecd;

public class VectordIterator implements Iterator<Double>
{

	Vecd v;
	
	int index = 0;
	
	public VectordIterator(Vecd v)
	{
		this.v = v;
	}
	
	@Override
	public boolean hasNext()
	{
		return index + 1 < v.getDimensions();
	}

	@Override
	public Double next()
	{
			double d = v.get(index);
			if(hasNext()) index++;
			return d;
	}

}

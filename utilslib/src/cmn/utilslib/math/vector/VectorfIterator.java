package cmn.utilslib.math.vector;

import java.util.Iterator;

import cmn.utilslib.math.vector.api.Vecf;

public class VectorfIterator implements Iterator<Float>
{

	Vecf v;
	
	int index = 0;
	
	public VectorfIterator(Vecf v)
	{
		this.v = v;
	}
	
	@Override
	public boolean hasNext()
	{
		return index + 1 < v.getDimensions();
	}

	@Override
	public Float next()
	{
			float f = v.get(index);
			if(hasNext()) index++;
			return f;
	}

}

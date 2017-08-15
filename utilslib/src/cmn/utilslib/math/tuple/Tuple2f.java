package cmn.utilslib.math.tuple;

import cmn.utilslib.math.tuple.api.Tup2dBase;
import cmn.utilslib.math.tuple.api.Tup2f;
import cmn.utilslib.math.tuple.api.Tup2fBase;

public class Tuple2f implements Tup2f
{

	public float[] values = new float[2];
	
	public Tuple2f() { this.values[0] = 0; this.values[1] = 0; }
	
	public Tuple2f(Tup2fBase t)
	{ this.values[0] = t.get(0); this.values[1] = t.get(1); }
	
	public Tuple2f(Tup2dBase t)
	{ this.values[0] = (float)t.get(0); this.values[1] = (float)t.get(1); }
	
	public Tuple2f(float scalar)
	{ this.values[0] = scalar; this.values[1] = scalar; }
	
	public Tuple2f(double scalar)
	{  this.values[0] = (float)scalar; this.values[1] = (float)scalar; }
	
	public Tuple2f(float a, float b)
	{ this.values[0] = a; this.values[1] = b; }
	
	public Tuple2f(double a, double b)
	{ this.values[0] = (float)a; this.values[1] = (float)b; }
	
	@Override
	public float get(int index) { return this.values[index]; }

	@Override
	public Tuple2f clone() { return new Tuple2f(this); }

	@Override
	public Tuple2f setZero()
	{ this.values[0] = 0; this.values[1] = 0; return this; }

	@Override
	public Tuple2f set(Tup2fBase t)
	{ this.values[0] = t.get(0); this.values[1] = t.get(1); return this; }

	@Override
	public Tuple2f set(Tup2dBase t)
	{ this.values[0] = (float)t.get(0); this.values[1] = (float)t.get(1); return this; }

	@Override
	public Tuple2f set(float scalar)
	{ this.values[0] = scalar; this.values[1] = scalar; return this; }

	@Override
	public Tuple2f set(double scalar)
	{ this.values[0] = (float)scalar; this.values[1] = (float)scalar; return this; }

	@Override
	public Tuple2f set(float... values)
	{ this.values[0] = values[0]; this.values[1] = values[1]; return this; }

	@Override
	public Tuple2f set(double... values)
	{ this.values[0] = (float)values[0]; this.values[1] = (float)values[1]; return this; }

	@Override
	public Tuple2f set(int index, float value) { this.values[index] = value; return this; }

	@Override
	public Tuple2f set(int index, double value) { this.values[index] = (float)value; return this; }




}

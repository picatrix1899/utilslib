package cmn.utilslib.math.tuple;

import cmn.utilslib.math.tuple.api.Tup3dBase;
import cmn.utilslib.math.tuple.api.Tup3f;
import cmn.utilslib.math.tuple.api.Tup3fBase;

public class Tuple3f implements Tup3f
{

	public float[] values = new float[3];
	
	public Tuple3f() { this.values[0] = 0; this.values[1] = 0; this.values[2] = 0; }
	
	public Tuple3f(Tup3fBase t) { this.values[0] = t.get(0); this.values[1] = t.get(1); this.values[2] = t.get(2); }
	
	public Tuple3f(Tup3dBase t) { this.values[0] = (float)t.get(0); this.values[1] = (float)t.get(1); this.values[2] = (float)t.get(2); }
	
	public Tuple3f(float scalar) { this.values[0] = scalar; this.values[1] = scalar; this.values[2] = scalar; }
	
	public Tuple3f(double scalar) {  this.values[0] = (float)scalar; this.values[1] = (float)scalar; this.values[2] = (float)scalar; }
	
	public Tuple3f(float a, float b, float c) { this.values[0] = a; this.values[1] = b; this.values[2] = c; }
	
	public Tuple3f(double a, double b, double c) { this.values[0] = (float)a; this.values[1] = (float)b; this.values[2] = (float)c; }
	
	@Override
	public float get(int index)
	{
		return this.values[index];
	}

	@Override
	public Tuple3f clone() { return new Tuple3f(this); }


	@Override
	public Tuple3f setZero() { this.values[0] = 0; this.values[1] = 0; this.values[2] = 0; return this; }

	@Override
	public Tuple3f set(Tup3fBase t) { this.values[0] = t.get(0); this.values[1] = t.get(1); this.values[2] = t.get(2); return this; }

	@Override
	public Tuple3f set(Tup3dBase t) { this.values[0] = (float)t.get(0); this.values[1] = (float)t.get(1); this.values[2] = (float)t.get(2); return this; }

	@Override
	public Tuple3f set(float scalar) { this.values[0] = scalar; this.values[1] = scalar; this.values[2] = scalar; return this; }

	@Override
	public Tuple3f set(double scalar) { this.values[0] = (float)scalar; this.values[1] = (float)scalar; this.values[2] = (float) scalar; return this; }

	@Override
	public Tuple3f set(float... values) { this.values[0] = values[0]; this.values[1] = values[1]; this.values[2] = values[2]; return this; }

	@Override
	public Tuple3f set(double... values) { this.values[0] = (float)values[0]; this.values[1] = (float)values[1]; this.values[2] = (float)values[2]; return this; }

	@Override
	public Tuple3f set(int index, float value) { this.values[index] = value; return this; }

	@Override
	public Tuple3f set(int index, double value) { this.values[index] = (float)value; return this; }

}

package cmn.utilslib.math.tuple;

import cmn.utilslib.Allocator;
import cmn.utilslib.math.tuple.api.Tup2d;
import cmn.utilslib.math.tuple.api.Tup2dBase;
import cmn.utilslib.math.tuple.api.Tup2fBase;

public class Tuple2d implements Tup2d
{

	public double[] v = new double[2];
	
	/*
	#########################
	##                     ##
	##  TEMPORARY VECTORS  ##
	##                     ##
	#########################
	 */
	
	public static final Tuple2d TEMP = new Tuple2d();
	public static final Tuple2d TEMP0 = new Tuple2d();
	public static final Tuple2d TEMP1 = new Tuple2d();
	public static final Tuple2d TEMP2 = new Tuple2d();
	public static final Tuple2d TEMP3 = new Tuple2d();
	public static final Tuple2d TEMP4 = new Tuple2d();
	public static final Tuple2d TEMP5 = new Tuple2d();
	public static final Tuple2d TEMP6 = new Tuple2d();
	public static final Tuple2d TEMP7 = new Tuple2d();
	public static final Tuple2d TEMP8 = new Tuple2d();
	public static final Tuple2d TEMP9 = new Tuple2d();
	
	/*
	##################
	##              ##
	##  ALLOCATION  ##
	##              ##
	##################
	 */
	
	private static Allocator<Tuple2d> allocator = new Allocator<Tuple2d>(Tuple2d.class);
	
	public static Tuple2d alloc()
	{
		return allocator.alloc();
	}
	
	public static Tuple2d alloc(Tuple2f t)
	{
		Tuple2d t0 = allocator.alloc();
		
		t0.v[0] = t.v[0];
		t0.v[1] = t.v[1];
		
		return t0;
	}
	
	public static Tuple2d alloc(Tuple2d t)
	{
		Tuple2d t0 = allocator.alloc();
		
		t0.v[0] = t.v[0];
		t0.v[1] = t.v[1];
		
		return t0;
	}
	
	public static Tuple2d alloc(Tup2fBase t)
	{
		Tuple2d t0 = allocator.alloc();
		
		t0.v[0] = t.get(0);
		t0.v[1] = t.get(1);
		
		return t0;
	}
	
	public static Tuple2d alloc(Tup2dBase t)
	{
		Tuple2d t0 = allocator.alloc();
		
		t0.v[0] = t.get(0);
		t0.v[1] = t.get(1);
		
		return t0;
	}
	
	public static Tuple2d alloc(float scalar)
	{
		Tuple2d t = allocator.alloc();
		
		t.v[0] = scalar;
		t.v[1] = scalar;
		
		return t;
	}
	
	public static Tuple2d alloc(double scalar)
	{
		Tuple2d t = allocator.alloc();
		
		t.v[0] = scalar;
		t.v[1] = scalar;
		
		return t;
	}
	
	public static Tuple2d alloc(float v0, float v1)
	{
		Tuple2d t = allocator.alloc();
		
		t.v[0] = v0;
		t.v[1] = v1;
		
		return t;
	}
	
	public static Tuple2d alloc(double v0, double v1)
	{
		Tuple2d t = allocator.alloc();
		
		t.v[0] = v0;
		t.v[1] = v1;
		
		return t;
	}
	
	public static void dealloc(Tuple2d t) { allocator.dealloc(t); }
	
	public Tuple2d()
	{
		this.v[0] = 0;
		this.v[1] = 0;
	}
	
	public Tuple2d(Tuple2f t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
	}
	
	public Tuple2d(Tuple2d t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
	}
	
	public Tuple2d(Tup2fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		}
	
	public Tuple2d(Tup2dBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		}
	
	public Tuple2d(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
	}
	
	public Tuple2d(double scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		}
	
	public Tuple2d(float v0, float v1)
	{
		this.v[0] = v0;
		this.v[1] = v1;
	}
	
	public Tuple2d(double v0, double v1)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		}
	
	@Override
	public double get(int index)
	{
		return this.v[index];
	}

	@Override
	public Tuple2d clone() { return new Tuple2d(this); }

	@Override
	public Tuple2d setZero()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		return this;
	}

	public Tuple2d set(Tuple2f t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		return this;
	}
	
	public Tuple2d set(Tuple2d t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		return this;
	}
	
	@Override
	public Tuple2d set(Tup2fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		return this;
	}

	@Override
	public Tuple2d set(Tup2dBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		return this;
		}

	@Override
	public Tuple2d set(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		return this;
		}

	@Override
	public Tuple2d set(double scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		return this;
	}

	@Override
	public Tuple2d set(float v0, float v1)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		return this;
	}

	@Override
	public Tuple2d set(double v0, double v1)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		return this;
	}

	@Override
	public Tuple2d set(int index, float value) { this.v[index] = value; return this; }

	@Override
	public Tuple2d set(int index, double value) { this.v[index] = value; return this; }




}

package cmn.utilslib.math.tuple;

import cmn.utilslib.Allocator;
import cmn.utilslib.math.tuple.api.Tup7d;
import cmn.utilslib.math.tuple.api.Tup7dBase;
import cmn.utilslib.math.tuple.api.Tup7fBase;

public class Tuple7d implements Tup7d
{
	public double[] v = new double[7];
	
	/*
	#########################
	##                     ##
	##  TEMPORARY VECTORS  ##
	##                     ##
	#########################
	 */
	
	public static final Tuple7d TEMP = new Tuple7d();
	public static final Tuple7d TEMP0 = new Tuple7d();
	public static final Tuple7d TEMP1 = new Tuple7d();
	public static final Tuple7d TEMP2 = new Tuple7d();
	public static final Tuple7d TEMP3 = new Tuple7d();
	public static final Tuple7d TEMP4 = new Tuple7d();
	public static final Tuple7d TEMP5 = new Tuple7d();
	public static final Tuple7d TEMP6 = new Tuple7d();
	public static final Tuple7d TEMP7 = new Tuple7d();
	public static final Tuple7d TEMP8 = new Tuple7d();
	public static final Tuple7d TEMP9 = new Tuple7d();
	
	/*
	##################
	##              ##
	##  ALLOCATION  ##
	##              ##
	##################
	 */
	
	private static Allocator<Tuple7d> allocator = new Allocator<Tuple7d>(Tuple7d.class);
	
	public static Tuple7d alloc()
	{
		return allocator.alloc();
	}
	
	public static Tuple7d alloc(Tuple7f t)
	{
		Tuple7d t0 = allocator.alloc();
		
		t0.v[0] = t.v[0];
		t0.v[1] = t.v[1];
		t0.v[2] = t.v[2];
		t0.v[3] = t.v[3];
		t0.v[4] = t.v[4];
		t0.v[5] = t.v[5];
		t0.v[6] = t.v[6];
		
		return t0;
	}
	
	public static Tuple7d alloc(Tuple7d t)
	{
		Tuple7d t0 = allocator.alloc();
		
		t0.v[0] = t.v[0];
		t0.v[1] = t.v[1];
		t0.v[2] = t.v[2];
		t0.v[3] = t.v[3];
		t0.v[4] = t.v[4];
		t0.v[5] = t.v[5];
		t0.v[6] = t.v[6];
		
		return t0;
	}
	
	public static Tuple7d alloc(Tup7fBase t)
	{
		Tuple7d t0 = allocator.alloc();
		
		t0.v[0] = t.get(0);
		t0.v[1] = t.get(1);
		t0.v[2] = t.get(2);
		t0.v[3] = t.get(3);
		t0.v[4] = t.get(4);
		t0.v[5] = t.get(5);
		t0.v[6] = t.get(6);
		
		return t0;
	}
	
	public static Tuple7d alloc(Tup7dBase t)
	{
		Tuple7d t0 = allocator.alloc();
		
		t0.v[0] = t.get(0);
		t0.v[1] = t.get(1);
		t0.v[2] = t.get(2);
		t0.v[3] = t.get(3);
		t0.v[4] = t.get(4);
		t0.v[5] = t.get(5);
		t0.v[6] = t.get(6);
		
		return t0;
	}
	
	public static Tuple7d alloc(float scalar)
	{
		Tuple7d t = allocator.alloc();
		
		t.v[0] = scalar;
		t.v[1] = scalar;
		t.v[2] = scalar;
		t.v[3] = scalar;
		t.v[4] = scalar;
		t.v[5] = scalar;
		t.v[6] = scalar;
		
		return t;
	}
	
	public static Tuple7d alloc(double scalar)
	{
		Tuple7d t = allocator.alloc();
		
		t.v[0] = scalar;
		t.v[1] = scalar;
		t.v[2] = scalar;
		t.v[3] = scalar;
		t.v[4] = scalar;
		t.v[5] = scalar;
		t.v[6] = scalar;
		
		return t;
	}
	
	public static Tuple7d alloc(float v0, float v1, float v2, float v3, float v4, float v5, float v6)
	{
		Tuple7d t = allocator.alloc();
		
		t.v[0] = v0;
		t.v[1] = v1;
		t.v[2] = v2;
		t.v[3] = v3;
		t.v[4] = v4;
		t.v[5] = v5;
		t.v[6] = v6;
		
		return t;
	}
	
	public static Tuple7d alloc(double v0, double v1, double v2, double v3 ,double v4, double v5, double v6)
	{
		Tuple7d t = allocator.alloc();
		
		t.v[0] = v0;
		t.v[1] = v1;
		t.v[2] = v2;
		t.v[3] = v3;
		t.v[4] = v4;
		t.v[5] = v5;
		t.v[6] = v6;
		
		return t;
	}
	
	public static void dealloc(Tuple7d t) { allocator.dealloc(t); }
	
	
	
	public Tuple7d()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		this.v[2] = 0;
		this.v[3] = 0;
		this.v[4] = 0;
		this.v[5] = 0;
		this.v[6] = 0;
	}
	
	public Tuple7d(Tuple7f t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		this.v[3] = t.v[3];
		this.v[4] = t.v[4];
		this.v[5] = t.v[5];
		this.v[6] = t.v[6];
	}
	
	public Tuple7d(Tuple7d t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		this.v[3] = t.v[3];
		this.v[4] = t.v[4];
		this.v[5] = t.v[5];
		this.v[6] = t.v[6];
	}
	
	public Tuple7d(Tup7fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
		this.v[4] = t.get(4);
		this.v[5] = t.get(5);
		this.v[6] = t.get(6);
	}
	
	public Tuple7d(Tup7dBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
		this.v[4] = t.get(4);
		this.v[5] = t.get(5);
		this.v[6] = t.get(6);
	}
	
	public Tuple7d(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		this.v[3] = scalar;
		this.v[4] = scalar;
		this.v[5] = scalar;
		this.v[6] = scalar;
	}
	
	public Tuple7d(double scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		this.v[3] = scalar;
		this.v[4] = scalar;
		this.v[5] = scalar;
		this.v[6] = scalar;
	}
	
	public Tuple7d(float v0, float v1, float v2, float v3, float v4, float v5, float v6)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		this.v[3] = v3;
		this.v[4] = v4;
		this.v[5] = v5;
		this.v[6] = v6;
	}
	
	public Tuple7d(double v0, double v1, double v2, double v3, double v4, double v5, double v6)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		this.v[3] = v3;
		this.v[4] = v4;
		this.v[5] = v5;
		this.v[6] = v6;
	}
	
	public double get(int index) { return this.v[index]; }

	public Tuple7d clone() { return new Tuple7d(this); }

	public Tuple7d setZero()
	{
		this.v[0] = 0;
		this.v[1] = 0;
		this.v[2] = 0;
		this.v[3] = 0;
		this.v[4] = 0;
		this.v[5] = 0;
		this.v[6] = 0;
		return this;
	}

	public Tuple7d set(Tuple7f t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		this.v[3] = t.v[3];
		this.v[4] = t.v[4];
		this.v[5] = t.v[5];
		this.v[6] = t.v[6];
		return this;
	}
	
	public Tuple7d set(Tuple7d t)
	{
		this.v[0] = t.v[0];
		this.v[1] = t.v[1];
		this.v[2] = t.v[2];
		this.v[3] = t.v[3];
		this.v[4] = t.v[4];
		this.v[5] = t.v[5];
		this.v[6] = t.v[6];
		return this;
	}
	
	public Tuple7d set(Tup7fBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
		this.v[4] = t.get(4);
		this.v[5] = t.get(5);
		this.v[6] = t.get(6);
		return this;
	}
	
	public Tuple7d set(Tup7dBase t)
	{
		this.v[0] = t.get(0);
		this.v[1] = t.get(1);
		this.v[2] = t.get(2);
		this.v[3] = t.get(3);
		this.v[4] = t.get(4);
		this.v[5] = t.get(5);
		this.v[6] = t.get(6);
		return this;
	}

	public Tuple7d set(float scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		this.v[3] = scalar;
		this.v[4] = scalar;
		this.v[5] = scalar;
		this.v[6] = scalar;
		return this;
	}

	public Tuple7d set(double scalar)
	{
		this.v[0] = scalar;
		this.v[1] = scalar;
		this.v[2] = scalar;
		this.v[3] = scalar;
		this.v[4] = scalar;
		this.v[5] = scalar;
		this.v[6] = scalar;
		return this;
	}

	public Tuple7d set(float v0, float v1, float v2, float v3, float v4, float v5, float v6)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		this.v[3] = v3;
		this.v[4] = v4;
		this.v[5] = v5;
		this.v[6] = v6;
		return this;
	}

	public Tuple7d set(double v0, double v1, double v2, double v3, double v4, double v5, double v6)
	{
		this.v[0] = v0;
		this.v[1] = v1;
		this.v[2] = v2;
		this.v[3] = v3;
		this.v[4] = v4;
		this.v[5] = v5;
		this.v[6] = v6;
		return this;
	}

	public Tuple7d set(int index, float value) { this.v[index] = value; return this; }

	public Tuple7d set(int index, double value) { this.v[index] = value; return this; }
}

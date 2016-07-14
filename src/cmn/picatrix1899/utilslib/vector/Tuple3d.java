
package cmn.picatrix1899.utilslib.vector;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cmn.picatrix1899.utilslib.interfaces.DataHolder;



public class Tuple3d implements DataHolder
{
	
	public static final int DIMENSIONS = 3;
	public static final String NAME = "tuple3d";
	
	
	public double a = 0.0d;
	public double b = 0.0d;
	public double c = 0.0d;
	
	
	
	public Tuple3d() { this(0.0d, 0.0d, 0.0d); }
	
	public Tuple3d(double a, double b, double c) { set(a, b, c); }
	
	public Tuple3d(Tuple3d t) { set(t); }
	
	
	
	public Tuple3d set(Tuple3d t) { return set(t.a, t.b, t.c); }
	
	public Tuple3d set(double a, double b, double c) { return setA(a).setB(b).setC(c); }
	
	public Tuple3d setA(double a) { this. a = a; return this; }
	
	public Tuple3d setB(double b) { this.b = b; return this; }
	
	public Tuple3d setC(double c) { this.c = c; return this; }
	
	
	
	public double getA() { return this.a; }
	
	public double getB() { return this.b; }
	
	public double getC() { return this.c; }
	
	
	
	public int getDimensions() { return Tuple3d.DIMENSIONS; }
	
	public double getOrdinal(int index)
	{
		if(index < 0 || index >= getDimensions()) throw new IndexOutOfBoundsException();
		
		switch(index)
		{
			case 0: { return this.a; }
			case 1: { return this.b; }
			case 2: { return this.c; }
			
			default: return Double.NaN;
		}
	}
	
	public double[] ordinal() { return new double[] { this.a, this.b, this.c }; }
	
	public Tuple3d setOrdinal(int index, double val)
	{
		if(index < 0 || index >= getDimensions()) throw new IndexOutOfBoundsException();
		
		switch(index)
		{
			case 0: { return setA(val); }
			case 1: { return setB(val); }
			case 2: { return setC(val); }
			
			default: return this;
		}
	}
	
	
	
	public Tuple3d clone() { return new Tuple3d(this); }
	
	public String toString() { return "tup3d(" + this.a + "d, " + this.b + "d, " + this.c + "d)"; }

	
	
	public void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		this.a = dis.readDouble();
		this.b = dis.readDouble();
		this.c = dis.readDouble();
	}

	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeDouble(this.a);
		dos.writeDouble(this.b);
		dos.writeDouble(this.c);
	}
	
}

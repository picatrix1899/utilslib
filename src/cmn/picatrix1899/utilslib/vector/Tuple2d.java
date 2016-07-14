
package cmn.picatrix1899.utilslib.vector;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cmn.picatrix1899.utilslib.interfaces.DataHolder;



public class Tuple2d implements DataHolder
{
	
	public static final int DIMENSIONS = 2;
	public static final String NAME = "tuple2d";
	
	
	
	public double a = 0.0d;
	public double b = 0.0d;
	
	
	
	public Tuple2d() { this(0.0d, 0.0d); }
	
	public Tuple2d(double a, double b) { set(a, b); }
	
	public Tuple2d(Tuple2d t) { set(t); }
	
	
	
	public Tuple2d set(Tuple2d t) { return set(t.a, t.b); }
	
	public Tuple2d set(double a, double b) { return setA(a).setB(b); }
	
	public Tuple2d setA(double a) { this.a = a; return this; }
	
	public Tuple2d setB(double b) { this.b = b; return this; }
	
	
	
	public double getA() { return this.a; }
	
	public double getB() { return this.b; }
	
	
	
	public int getDimensions() { return Tuple2d.DIMENSIONS; }
	
	public double getOrdinal(int index)
	{
		if(index < 0 || index >= getDimensions()) throw new IndexOutOfBoundsException();
		
		switch(index)
		{
			case 0: { return this.a; }
			case 1: { return this.b; }
			
			default: return Double.NaN;
		}
	}
	
	public double[] ordinal() { return new double[] { this.a, this.b }; }
	
	public Tuple2d setOrdinal(int index, double val)
	{
		if(index < 0 || index >= getDimensions()) throw new IndexOutOfBoundsException();
		
		switch(index)
		{
			case 0: { return setA(val); }
			case 1: { return setB(val); }
			
			default: return this;
		}
	}
	
	
	public Tuple2d clone() { return new Tuple2d(this); }
	
	public String toString() { return "tup2d(" + this.a + "d, " + this.b + "d)"; }

	
	
	public void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		this.a = dis.readDouble();
		this.b = dis.readDouble();
	}

	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeDouble(this.a);
		dos.writeDouble(this.b);
	}
	
}


package cmn.picatrix1899.utilslib.vector;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cmn.picatrix1899.utilslib.interfaces.DataHolder;



public class Tuple3f implements DataHolder
{
	
	public static final int DIMENSIONS = 3;
	public static final String NAME = "Tuple3f";
	
	
	
	public float a;
	public float b;
	public float c;
	
	
	public Tuple3f() { this(0.0f, 0.0f, 0.0f); }
	
	public Tuple3f(float a, float b, float c) { set(a, b, c); }
	
	public Tuple3f(Tuple3f t) { set(t); }
	
	
	
	public Tuple3f set(Tuple3f t) { return set(t.a, t.b, t.c); }
	
	public Tuple3f set(float a, float b, float c) { return setA(a).setB(b).setC(c); }
	
	public Tuple3f setA(float a) { this.a = a; return this; }
	
	public Tuple3f setB(float b) { this.b = b; return this; }
	
	public Tuple3f setC(float c) { this.c = c; return this; }
	
	
	
	public float getA() { return this.a; }
	
	public float getB() { return this.b; }
	
	public float getC() { return this.c; }
	
	
	
	public int getDimensions() { return Tuple3f.DIMENSIONS; }
	
	public float getOrdinal(int index)
	{
		if(index < 0 || index >= getDimensions()) throw new IndexOutOfBoundsException();
		
		switch(index)
		{
			case 0: { return this.a; }
			case 1: { return this.b; }
			case 2: { return this.c; }
			
			default: return Float.NaN;
		}
	}
	
	public float[] ordinal() { return new float[] { this.a, this.b, this.c }; }
	
	public Tuple3f setOrdinal(int index, float val)
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
	
	
	
	public Tuple3f clone() { return new Tuple3f(this); }
	
	public String toString() { return "tup3f(" + this.a + "f, " + this.b + "f, " + this.c + "f)"; }

	
	
	public void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		this.a = dis.readFloat();
		this.b = dis.readFloat();
		this.c = dis.readFloat();
	}

	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeFloat(this.a);
		dos.writeFloat(this.b);
		dos.writeFloat(this.c);
	}
	
}

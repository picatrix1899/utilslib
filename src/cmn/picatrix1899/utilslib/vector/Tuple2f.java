
package cmn.picatrix1899.utilslib.vector;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cmn.picatrix1899.utilslib.interfaces.DataHolder;



public class Tuple2f implements DataHolder
{
	
	public static final int DIMENSIONS = 2;
	public static final String NAME = "tuple2f";
	

	
	public float a = 0.0f;
	public float b = 0.0f;
	
	
	
	public Tuple2f() { this(0.0f, 0.0f); }
	
	public Tuple2f(float a, float b) { set(a, b); }
	
	public Tuple2f(Tuple2f t) { set(t); }
	
	
	
	public Tuple2f set(Tuple2f t) { return set(t.a, t.b); }
	
	public Tuple2f set(float a, float b) { return setA(a).setB(b); }
	
	public Tuple2f setA(float a) { this.a = a; return this; }
	
	public Tuple2f setB(float b) { this.b = b; return this; }
	
	
	
	public float getA() { return this.a; }
	
	public float getB() { return this.b; }
	
	
	
	public int getDimensions() { return Tuple2f.DIMENSIONS; }
	
	public float getOrdinal(int index)
	{
		if(index < 0 || index >= getDimensions()) throw new IndexOutOfBoundsException();
		
		switch(index)
		{
			case 0: { return this.a; }
			case 1: { return this.b; }
			
			default: return Float.NaN;
		}
	}
	
	public float[] ordinal() { return new float[] { this.a, this.b }; }
	
	public Tuple2f setOrdinal(int index, float val)
	{
		if(index < 0 || index >= getDimensions()) throw new IndexOutOfBoundsException();
		
		switch(index)
		{
			case 0: { return setA(val); }
			case 1: { return setB(val); }
			
			default: return this;
		}
	}
	
	
	
	public Tuple2f clone() { return new Tuple2f(this); }
	
	public String toString() { return "tup2f(" + this.a + "f, " + this.b + "f)"; }

	
	
	public void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		this.a = dis.readFloat();
		this.b = dis.readFloat();
	}

	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeFloat(this.a);
		dos.writeFloat(this.b);
	}
	
}

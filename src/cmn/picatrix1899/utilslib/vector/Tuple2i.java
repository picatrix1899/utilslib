
package cmn.picatrix1899.utilslib.vector;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cmn.picatrix1899.utilslib.interfaces.DataHolder;



public class Tuple2i implements DataHolder
{
	
	public static final int DIMENSIONS = 2;
	public static final String NAME = "tuple2i";
	
	
	
	public int a = 0;
	public int b = 0;
	
	
	
	public Tuple2i() { this(0, 0); }
	
	public Tuple2i(int a, int b) { set(a, b); }
	
	public Tuple2i(Tuple2i t) { set(t); }
	
	
	
	public Tuple2i set(Tuple2i t) { return set(t.a, t.b); }
	
	public Tuple2i set(int a, int b) { return setA(a).setB(b); }
	
	public Tuple2i setA(int a) { this.a = a; return this; }
	
	public Tuple2i setB(int b) { this.b = b; return this; }
	
	
	
	public int getA() { return this.a; }
	
	public int getB() { return this.b; }
	
	
	
	public int getDimensions() { return Tuple2i.DIMENSIONS; }
	
	public int getOrdinal(int index)
	{
		if(index < 0 || index >= getDimensions()) throw new IndexOutOfBoundsException();
		
		switch(index)
		{
			case 0: { return this.a; }
			case 1: { return this.b; }
			
			default: return 0;
		}
	}
	
	public int[] ordinal() { return new int[] { this.a, this.b }; }
	
	public Tuple2i setOrdinal(int index, int val)
	{
		if(index < 0 || index >= getDimensions()) throw new IndexOutOfBoundsException();
		
		switch(index)
		{
			case 0: { return setA(val); }
			case 1: { return setB(val); }
			
			default: return this;
		}
	}
	
	
	
	public Tuple2i clone() { return new Tuple2i(this); }
	
	public String toString() { return "tup2i(" + this.a + "i, " + this.b + "i)"; }

	
	
	public void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		this.a = dis.readInt();
		this.b = dis.readInt();
	}

	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeInt(this.a);
		dos.writeInt(this.b);
	}
	
}

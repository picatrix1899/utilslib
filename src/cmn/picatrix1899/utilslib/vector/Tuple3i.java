package cmn.picatrix1899.utilslib.vector;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cmn.picatrix1899.utilslib.interfaces.DataHolder;

public class Tuple3i implements DataHolder
{
	
	public static final int DIMENSIONS = 3;
	public static final String NAME = "Tuple3i";
	
	
	public int a;
	public int b;
	public int c;
	
	
	
	public Tuple3i() { this(0, 0, 0); }
	
	public Tuple3i(int a, int b, int c) { set(a, b, c); }
	
	public Tuple3i(Tuple3i t) { set(t); }
	
	
	
	public Tuple3i set(Tuple3i t) { return set(t.a, t.b, t.c); }
	
	public Tuple3i set(int a, int b, int c) { return setA(a).setB(b).setC(c); }
	
	public Tuple3i setA(int a) { this.a = a; return this; }
	
	public Tuple3i setB(int b) { this.b = b; return this; }
	
	public Tuple3i setC(int c) { this.c = c; return this; }
	
	
	
	public int getA() { return this.a; }
	
	public int getB() { return this.b; }
	
	public int getC() { return this.c; }
	
	
	
	public int getDimensions() { return Tuple3i.DIMENSIONS; }
	
	public int getOrdinal(int index)
	{
		if(index < 0 || index >= getDimensions()) throw new IndexOutOfBoundsException();
		
		switch(index)
		{
			case 0: { return this.a; }
			case 1: { return this.b; }
			case 2: { return this.c; }
			
			default: return 0;
		}
	}
	
	public int[] ordinal() { return new int[] { this.a, this.b, this.c }; }
	
	public Tuple3i setOrdinal(int index, int val)
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
	
	
	
	public Tuple3i clone() { return new Tuple3i(this); }
	
	public String toString() { return "tup3i(" + this.a + "i, " + this.b + "i, " + this.c + "i)"; }

	
	
	public void readData(InputStream stream) throws IOException
	{
		DataInputStream dis = new DataInputStream(stream);
		this.a = dis.readInt();
		this.b = dis.readInt();
		this.c = dis.readInt();
	}

	public void writeData(OutputStream stream) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(stream);
		dos.writeInt(this.a);
		dos.writeInt(this.b);
		dos.writeInt(this.c);
	}
	
}

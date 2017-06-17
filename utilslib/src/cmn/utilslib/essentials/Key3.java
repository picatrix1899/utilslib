package cmn.utilslib.essentials;

import java.util.Objects;

public class Key3<A,B,C>
{
	private A a = null;
	private B b = null;
	private C c = null;
	
	public Key3(A a, B b, C c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public int hashCode()
	{
		return Objects.hash(a,b,c);
	}
	
	public boolean equals(Object o)
	{
		if(!(o instanceof Key3)) return false;
		Key3<?,?,?> key = (Key3<?,?,?>)o;
		
		if(!this.a.equals(key.a)) return false;
		if(!this.b.equals(key.b)) return false;
		if(!this.c.equals(key.c)) return false;
		return true;
	}
	
}

package cmn.utilslib.essentials;

import java.util.Objects;

public class Key2<A,B>
{
	private A a = null;
	private B b = null;
	
	public Key2(A a, B b)
	{
		this.a = a;
		this.b = b;
	}
	
	public int hashCode()
	{
		return Objects.hash(a,b);
	}
	
	public boolean equals(Object o)
	{
		if(!(o instanceof Key2)) return false;
		Key2<?,?> key = (Key2<?,?>)o;
		
		if(!this.a.equals(key.a)) return false;
		if(!this.b.equals(key.b)) return false;
		return true;
	}
	
}

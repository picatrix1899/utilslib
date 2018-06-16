package cmn.utilslib.essentials;

import java.io.Serializable;
import java.util.Objects;

public class Key2<A,B> implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	protected A a = null;
	protected B b = null;
	
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

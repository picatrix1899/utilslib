package cmn.utilslib.dmap;

public class LinkedEntry<Type,Parent>
{
	private Type v;
	
	private Parent dm;
	
	public LinkedEntry(Parent dm)
	{
		this.dm = dm;
	}
	
	public Type value() { return this.v; }
	
	public void value(Type t)
	{
		this.v = t;
	}
	
	public Parent dmap()
	{
		return this.dm;
	}
}

package cmn.utilslib.dmap;

public class LinkedValue<Type,Parent>
{
	private Type value;
	
	private Parent parent;
	
	public LinkedValue(Parent parent) { this.parent = parent; }
	
	public LinkedValue(Parent parent, Type value) { this.parent = parent; this.value = value; }
	
	public Type value() { return this.value; }
	
	public void value(Type value) { this.value = value; }
	
	public Parent parent() { return this.parent; }
	
}

package cmn.utilslib.math.trees;

public class BTreeLeaf<T> extends BTreeContent<T>
{
	public T value;
	
	public BTreeLeaf() { }
	
	public BTreeLeaf(T value)
	{
		this.value = value;
	}
}

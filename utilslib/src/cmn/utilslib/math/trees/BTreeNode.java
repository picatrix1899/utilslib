package cmn.utilslib.math.trees;

public class BTreeNode<T> extends BTreeContent<T>
{
	public BTreeContent<T> a;
	public BTreeContent<T> b;
	

	
	public void set(int index, BTreeContent<T> a)
	{
		if(index == 0)
		{
			this.a = a;
			this.a.index = 0;
			this.a.last = this;
		}
		else
		{
			this.b = a;
			this.b.index = 1;
			this.b.last = this;
		}
	}
}

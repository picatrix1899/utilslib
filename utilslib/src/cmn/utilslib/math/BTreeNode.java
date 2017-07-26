package cmn.utilslib.math;


public class BTreeNode<D>
{
	public BTreeNode<D> before;
	public BTreeNode<D> after;
	public float position;
	public D data;
	public long index;
	public BTree<D> tree;
	
	public void add(D d)
	{
		int way = this.tree.selector.choose(d, this);
		
		if(way == 0)
		{
			if(this.before == null)
			{
				this.before = new BTreeNode<D>();
				this.before.tree = this.tree;
				this.before.data = d;
				return;
			}
			
			if(this.after == null)
			{
				this.after = new BTreeNode<D>();
				this.after.tree = this.tree;
				this.after.data = d;
				return;
			}
			
			this.before.add(d);
		}
		
		if(way == -1)
		{
			if(this.before == null)
			{
				this.before = new BTreeNode<D>();
				this.before.tree = this.tree;
				this.before.data = d;
				return;
			}
			
			this.before.add(d);
		}
		
		if(way == 1)
		{
			if(this.after == null)
			{
				this.after = new BTreeNode<D>();
				this.after.tree = this.tree;
				this.after.data = d;
				return;
			}
			
			this.after.add(d);
		}
	}
	
	public void get()
	{
		
	}
}

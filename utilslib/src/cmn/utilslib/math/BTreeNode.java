package cmn.utilslib.math;


public class BTreeNode<D>
{
	public BTreeNode<D> before;
	public BTreeNode<D> after;
	public BTreeNode<D> previous;
	public D data;
	public BTree<D> tree;
	
	public void add(D d)
	{
		int way = this.tree.selector.choose(d, this);
		
		if(way == 0)
		{
			
		}
		
		if(way == -1)
		{
			if(this.before == null)
			{
				
			}
			else
			{
				
			}
		}
		
		if(way == 1)
		{

		}
	}
	
	public void get()
	{
		
	}
}

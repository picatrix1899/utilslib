package cmn.utilslib.math.trees;

public class BTreeSteadyBuilder<T>
{
	public BTree<T> tree;
	
	public void add(T value)
	{
		
		BTreeNode<T> c = tree.root;
		
		if(c.a == null)
		{
			c.set(0, new BTreeLeaf<T>(value));
		}
		else
		{
			if(c.b == null)
			{
				c.set(1, new BTreeLeaf<T>(value));
			}
			else
			{
					if(c.a instanceof BTreeLeaf<?>)
					{
						
					}
					else
					{
						
					}
					if(c.b instanceof BTreeLeaf<?>)
					{
						BTreeNode<T> node = new BTreeNode<T>();
						
						node.a = c.b;
						node.b = new BTreeLeaf<T>(value);
						c.set(1, node);
					}
					else
					{
						
					}
			}
		}
	}
}

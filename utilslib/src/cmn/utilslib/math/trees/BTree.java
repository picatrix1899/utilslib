package cmn.utilslib.math.trees;

public class BTree<T>
{
	public BTreeNode<T> root = new BTreeNode<T>();
	
	public static <T> BTreeNode<T> joinToA(BTreeContent<T> a, BTreeContent<T> b)
	{
		BTreeNode<T> last = a.last;
		int index = a.index;
		
		a.last.set(a.index, null);
		b.last.set(b.index, null);
		
		BTreeNode<T> node = new BTreeNode<T>();
		
		node.set(0, a);
		node.set(1, b);
		
		last.set(index, node);
		
		return node;
	}
	
	public static <T> BTreeNode<T> joinToB(BTreeContent<T> a, BTreeContent<T> b)
	{
		BTreeNode<T> last = b.last;
		int index = b.index;
		
		a.last.set(a.index, null);
		b.last.set(b.index, null);
		
		BTreeNode<T> node = new BTreeNode<T>();
		
		node.set(0, a);
		node.set(1, b);
		
		last.set(index, node);
		
		return node;
	}
	
	public static <T> BTreeLeaf<T> createLeaf(T value)
	{
		BTreeLeaf<T> leaf = new BTreeLeaf<T>();
		
		leaf.value = value;
		
		return leaf;
	}
}

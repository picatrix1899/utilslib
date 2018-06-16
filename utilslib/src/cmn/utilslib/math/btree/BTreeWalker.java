package cmn.utilslib.math.btree;

import java.util.ArrayDeque;
import java.util.Deque;

public class BTreeWalker<T,E>
{
	public BTree<T,E> tree;
	
	public BTreeWalker(BTree<T,E> tree)
	{
		this.tree = tree;
	}
	
	public T walk(BTreeEvaluation<E> evaluation)
	{
		BTreeLeaf<T,E> leaf = walkToLeaf(evaluation);
		
		return leaf == null ? null: leaf.data;
	}
	
	public BTreeLeaf<T,E> walkToLeaf(BTreeEvaluation<E> evaluation)
	{
		Deque<BTreeContent<T,E>> queue = new ArrayDeque<BTreeContent<T,E>>();
		
		BTreeContent<T,E> current;
		BTreeNode<T,E> currentNode;
		BTreeLeaf<T,E> currentLeaf;
		
		queue.add(this.tree);
		
		while(!queue.isEmpty())
		{
			current = queue.poll();
			
			if(current instanceof BTreeNode)
			{
				currentNode = (BTreeNode<T,E>)current;
				
				if(evaluation.eval(currentNode.b.evalData))
				{
					queue.addFirst(currentNode.b);
				}
				
				if(evaluation.eval(currentNode.a.evalData))
				{
					queue.addFirst(currentNode.a);
				}
			}
			else
			{
				currentLeaf = (BTreeLeaf<T,E>)current;
				return currentLeaf;
			}
		}
		
		return null;
	}
}

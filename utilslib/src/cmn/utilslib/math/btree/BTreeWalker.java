package cmn.utilslib.math.btree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class BTreeWalker<T,E>
{
	private BTree<T,E> tree;
	private ArrayList<BTreeLeaf<T,E>> leafes;
	private ArrayList<T> values;
	
	public BTreeWalker(BTree<T,E> tree)
	{
		this.tree = tree;
		this.leafes = new ArrayList<BTreeLeaf<T,E>>();
		this.values = new ArrayList<T>();
	}
	
	public T walk(BTreeEvaluation<E> evaluation)
	{
		BTreeLeaf<T,E> leaf = walkToLeaf(evaluation);
		
		return leaf == null ? null: leaf.data;
	}
	
	public List<T> getValueList()
	{
		return this.values;
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
	
	public void refreshLeafList()
	{
		this.leafes = new ArrayList<BTreeLeaf<T,E>>();
		
		if(this.tree.a != null)
			iterativeWalk(leafes, this.tree);
	}
	
	public Iterator<BTreeLeaf<T,E>> leafIterator()
	{
		return this.leafes.iterator();
	}

	public Iterator<T> valueIterator()
	{
		return this.values.iterator();
	}
	
	private void iterativeWalk(ArrayList<BTreeLeaf<T,E>> leafes, BTreeNode<T,E> currentNode)
	{
		if(currentNode.a instanceof BTreeNode)
		{
			iterativeWalk(leafes, (BTreeNode<T,E>)currentNode.a);
		}
		else
		{
			leafes.add((BTreeLeaf<T,E>)currentNode.a);
			values.add(((BTreeLeaf<T,E>)currentNode.a).data);
		}
		if(currentNode.b != null)
		{
			if(currentNode.b instanceof BTreeNode)
			{
				iterativeWalk(leafes, (BTreeNode<T,E>)currentNode.b);
			}
			else
			{
				leafes.add((BTreeLeaf<T,E>)currentNode.b);
				values.add(((BTreeLeaf<T,E>)currentNode.b).data);
			}
		}
	}
}

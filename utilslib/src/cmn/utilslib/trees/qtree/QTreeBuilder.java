package cmn.utilslib.trees.qtree;

public abstract class QTreeBuilder<T,E>
{
	protected QTree<T,E> tree;
	
	public QTreeBuilder(QTree<T,E> tree)
	{
		this.tree = tree;
	}

	public void add(T data, E evalData)
	{
		QTreeNode<T,E> currentNode = this.tree;
		
		QTreeLeaf<T,E> leaf = generateLeafFromData(data, evalData);
		
		if(currentNode.a == null)
		{
			addLeafToNode(currentNode, leaf, 0);
			recalculateEvalData(currentNode);
		}
		else
		{
			addDeep(leaf, currentNode);
		}
	}
	
	public void optimize()
	{
		
	}
	
	public void remove()
	{
		
	}
	
	protected abstract void recalculateEvalData(QTreeNode<T,E> node);
	
	protected abstract boolean isInRange(E oldEvalData, E newEvalData);
	
	@SuppressWarnings("unchecked")
	protected abstract int getClosest(E newEvalData, QTreeContent<T,E>... contents);
	
	public void recalculateEvalDataForBranch(QTreeNode<T,E> node)
	{
		recalculateEvalData(node);
		
		if(node.parent != null)
		{
			recalculateEvalDataForBranch(node.parent);
		}
	}
	
	private void addLeafToNode(QTreeNode<T,E> node, QTreeLeaf<T,E> leaf, int contentIndex)
	{
		leaf.parent = node;
		
		switch(contentIndex)
		{
			case 0: node.a = leaf; break;
			case 1: node.b = leaf; break;
			case 2: node.c = leaf; break;
			case 3: node.d = leaf; break;
		}
	}
	
	private void addDeep(QTreeLeaf<T,E> newLeaf, QTreeNode<T,E> currentNode)
	{
		if(currentNode.b == null)
		{
			addLeafToNode(currentNode, newLeaf, 1);
			recalculateEvalDataForBranch(currentNode);
			return;
		}
		
		if(currentNode.c == null)
		{
			addLeafToNode(currentNode, newLeaf, 2);
			recalculateEvalDataForBranch(currentNode);
			return;
		}
		
		if(currentNode.d == null)
		{
			addLeafToNode(currentNode, newLeaf, 3);
			recalculateEvalDataForBranch(currentNode);
			return;
		}
		
		if(isInRange(currentNode.a.evalData, newLeaf.evalData))
		{
			if(currentNode.a instanceof QTreeNode)
			{
				addDeep(newLeaf, (QTreeNode<T,E>)currentNode.a);
			}
			else
			{
				extendToNode(currentNode, newLeaf, 0);
				recalculateEvalDataForBranch(currentNode);
			}
		}
		else if(isInRange(currentNode.b.evalData, newLeaf.evalData))
		{
			if(currentNode.b instanceof QTreeNode)
			{
				addDeep(newLeaf, (QTreeNode<T,E>)currentNode.b);
			}
			else
			{
				extendToNode(currentNode, newLeaf, 1);
				recalculateEvalDataForBranch(currentNode);
			}
		}
		else if(isInRange(currentNode.c.evalData, newLeaf.evalData))
		{
			if(currentNode.c instanceof QTreeNode)
			{
				addDeep(newLeaf, (QTreeNode<T,E>)currentNode.c);
			}
			else
			{
				extendToNode(currentNode, newLeaf, 2);
				recalculateEvalDataForBranch(currentNode);
			}
		}
		else if(isInRange(currentNode.d.evalData, newLeaf.evalData))
		{
			if(currentNode.d instanceof QTreeNode)
			{
				addDeep(newLeaf, (QTreeNode<T,E>)currentNode.d);
			}
			else
			{
				extendToNode(currentNode, newLeaf, 3);
				recalculateEvalDataForBranch(currentNode);
			}
		}
		else
		{
			@SuppressWarnings("unchecked")
			int closest = getClosest(newLeaf.evalData, currentNode.a, currentNode.b, currentNode.c, currentNode.d);
			
			QTreeContent<T,E> closestContent = null;
			
			switch(closest)
			{
				case 0: closestContent = currentNode.a; break;
				case 1: closestContent = currentNode.b; break;
				case 2: closestContent = currentNode.c; break;
				case 3: closestContent = currentNode.d; break;
			}
			
			if(closestContent instanceof QTreeNode)
			{
				addDeep(newLeaf, (QTreeNode<T,E>)closestContent);
			}
			else
			{
				extendToNode(currentNode, newLeaf, closest);
				recalculateEvalDataForBranch(currentNode);
			}
		}
	
	}
	
	private QTreeLeaf<T,E> generateLeafFromData(T data, E evalData)
	{
		QTreeLeaf<T,E> leaf = new QTreeLeaf<T,E>();
		leaf.data = data;
		leaf.evalData = evalData;
		
		return leaf;
	}
	
	private void extendToNode(QTreeNode<T,E> previousNode, QTreeLeaf<T,E> newLeaf, int contentIndex)
	{
		QTreeLeaf<T,E> currentLeaf = null;
		
		switch(contentIndex)
		{
			case 0: currentLeaf = (QTreeLeaf<T,E>)previousNode.a;
			case 1: currentLeaf = (QTreeLeaf<T,E>)previousNode.b;
			case 2: currentLeaf = (QTreeLeaf<T,E>)previousNode.c;
			case 3: currentLeaf = (QTreeLeaf<T,E>)previousNode.d;
		}
		
		QTreeNode<T,E> newNode = new QTreeNode<T,E>();
		
		newNode.a = currentLeaf;
		newNode.b = newLeaf;
		recalculateEvalData(newNode);
		
		currentLeaf.parent = newNode;
		newNode.parent = previousNode;
		
		switch(contentIndex)
		{
			case 0: previousNode.a = newNode; break;
			case 1: previousNode.b = newNode; break;
			case 2: previousNode.c = newNode; break;
			case 3: previousNode.d = newNode; break;
		}
	}
}

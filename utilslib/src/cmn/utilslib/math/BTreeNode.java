package cmn.utilslib.math;

import java.util.Comparator;

public class BTreeNode<D>
{
	public BTreeNode<D> before;
	public BTreeNode<D> after;
	public float position;
	public D data;
	public long index;
	public Comparator<D> comparator;
}

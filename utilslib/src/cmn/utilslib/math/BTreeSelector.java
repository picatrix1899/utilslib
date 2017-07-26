package cmn.utilslib.math;

public interface BTreeSelector<T>
{
	abstract int choose(T t, BTreeNode<T> node);
}

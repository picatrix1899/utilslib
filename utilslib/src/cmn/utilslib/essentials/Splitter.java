package cmn.utilslib.essentials;

public interface Splitter<T>
{
	public abstract boolean shouldGroup(T t);
}

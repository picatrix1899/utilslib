package cmn.utilslib.essentials;

public interface MemoryIterable<T> extends Iterable<T>
{
	public MemoryIterator<T> iterator();
}

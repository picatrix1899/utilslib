package cmn.utilslib.events;

public interface EventHandler<T extends EventArgs>
{
	abstract void raise(T argsorg, T argsref);
}

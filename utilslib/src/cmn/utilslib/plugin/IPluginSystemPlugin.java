package cmn.utilslib.plugin;

public interface IPluginSystemPlugin<A>
{
	
	public abstract boolean onHook(IPluginSystem<A> core);
	public abstract boolean onConstrain(A master);
	
}

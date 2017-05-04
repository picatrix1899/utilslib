package cmn.utilslib.plugin;

public interface PluginSystemPlugin<A extends PluginSystemApplicant<A>>
{
	
	public abstract void hook(PluginSystem<A> core);
	public abstract void load(A master);
	
}

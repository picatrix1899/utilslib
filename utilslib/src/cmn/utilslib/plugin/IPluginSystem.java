package cmn.utilslib.plugin;

public interface IPluginSystem<A extends PluginSystemApplicant<A>>
{
	void registerPlugin(PluginSystemPlugin<A> plugin, A master);
	
	boolean existsPlugin(Class<? extends PluginSystemPlugin<A>> clazz);
	
	public <T extends PluginSystemPlugin<A>> T getPlugin(Class<T> clazz);
}

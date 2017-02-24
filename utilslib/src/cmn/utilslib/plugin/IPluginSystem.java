package cmn.utilslib.plugin;

public interface IPluginSystem<A>
{
	public boolean hookPlugin(IPluginSystemPlugin<A> t);
	
	public boolean constrainPlugins();
	
	public boolean existsPlugin(Class<? extends IPluginSystemPlugin<A>> clazz);
	
	public <T extends IPluginSystemPlugin<A>> T getPlugin(Class<T> clazz);
}

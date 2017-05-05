package cmn.utilslib.plugin;

public interface PluginSystemApplicant<T extends PluginSystemApplicant<T>>
{
	void setPluginSystem(IPluginSystem<T> system);
	
	IPluginSystem<T> getPluginSystem();
	
	<A extends PluginSystemPlugin<T>> A getPlugin(Class<A> clazz);
}

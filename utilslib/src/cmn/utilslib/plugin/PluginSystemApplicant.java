package cmn.utilslib.plugin;

public interface PluginSystemApplicant<T extends PluginSystemApplicant<T>>
{
	void setPluginSystem(PluginSystem<T> system);
	
	PluginSystem<T> getPluginSystem();
	
	<A extends PluginSystemPlugin<T>> A getPlugin(Class<A> clazz);
}

package cmn.utilslib.plugin.api;

public interface PluginSystemFactory<T extends PluginSystemApplicant<T>>
{
	void instance(T master);
	
	boolean addPluginPreset(Class<? extends PluginSystemPlugin<T>> plugin);
	
	void forceUpdate();
}

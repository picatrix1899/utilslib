package cmn.utilslib.plugin;

public interface IPluginSystemFactory<T extends PluginSystemApplicant<T>>
{
	void instance(T master);
	
	void addPluginPreset(Class<? extends PluginSystemPlugin<T>> plugin);
}

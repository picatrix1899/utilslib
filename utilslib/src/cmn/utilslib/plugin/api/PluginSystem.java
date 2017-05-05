package cmn.utilslib.plugin.api;

public interface PluginSystem<Applicant extends PluginSystemApplicant<Applicant>>
{
	void registerPlugin(PluginSystemPlugin<Applicant> plugin, Applicant master);
	
	boolean existsPlugin(Class<? extends PluginSystemPlugin<Applicant>> clazz);
	
	public <Plugin extends PluginSystemPlugin<Applicant>> Plugin getPlugin(Class<Plugin> clazz);
}

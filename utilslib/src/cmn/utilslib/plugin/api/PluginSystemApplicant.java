package cmn.utilslib.plugin.api;

public interface PluginSystemApplicant<Applicant extends PluginSystemApplicant<Applicant>>
{
	void setPluginSystem(PluginSystem<Applicant> system);
	
	PluginSystem<Applicant> getPluginSystem();
	
	<Plugin extends PluginSystemPlugin<Applicant>> Plugin getPlugin(Class<Plugin> clazz);
}

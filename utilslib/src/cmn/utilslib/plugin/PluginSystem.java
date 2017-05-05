package cmn.utilslib.plugin;

import cmn.utilslib.plugin.api.PluginSystemApplicant;
import cmn.utilslib.plugin.api.PluginSystemPlugin;

public interface PluginSystem<Applicant extends PluginSystemApplicant<Applicant>>
{
	void registerPlugin(PluginSystemPlugin<Applicant> plugin, Applicant master);
	
	boolean existsPlugin(Class<? extends PluginSystemPlugin<Applicant>> clazz);
	
	public <Plugin extends PluginSystemPlugin<Applicant>> Plugin getPlugin(Class<Plugin> clazz);
}

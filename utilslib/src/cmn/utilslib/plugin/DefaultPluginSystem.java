package cmn.utilslib.plugin;
import java.util.HashMap;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.plugin.api.PluginSystem;
import cmn.utilslib.plugin.api.PluginSystemApplicant;
import cmn.utilslib.plugin.api.PluginSystemPlugin;

public class DefaultPluginSystem<Applicant extends PluginSystemApplicant<Applicant>> implements PluginSystem<Applicant>
{
	private HashMap<Class<? extends PluginSystemPlugin<Applicant>>, PluginSystemPlugin<Applicant>> plugins = Auto.HashMap();
	
	@SuppressWarnings("unchecked")
	public void registerPlugin(PluginSystemPlugin<Applicant> plugin, Applicant master)
	{
		if(!plugins.containsKey(plugin.getClass()))
		{
			plugin.hook(this);
			plugin.load(master);
			plugins.put((Class<? extends PluginSystemPlugin<Applicant>>)plugin.getClass(), plugin);
		}
	}
	
	public boolean existsPlugin(Class<? extends PluginSystemPlugin<Applicant>> clazz)
	{
		return plugins.containsKey(clazz);
	} 
	
	@SuppressWarnings("unchecked")
	public <Plugin extends PluginSystemPlugin<Applicant>> Plugin getPlugin(Class<Plugin> clazz)
	{
		return (Plugin) this.plugins.get(clazz);
	}

}

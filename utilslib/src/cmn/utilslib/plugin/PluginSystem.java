package cmn.utilslib.plugin;
import java.util.HashMap;

import cmn.utilslib.essentials.Auto;

public class PluginSystem<A extends PluginSystemApplicant<A>> implements IPluginSystem<A>
{
	private HashMap<Class<? extends PluginSystemPlugin<A>>, PluginSystemPlugin<A>> plugins = Auto.HashMap();
	
	@SuppressWarnings("unchecked")
	public void registerPlugin(PluginSystemPlugin<A> plugin, A a)
	{
		if(!plugins.containsKey(plugin.getClass()))
		{
			plugin.hook(this);
			plugin.load(a);
			plugins.put((Class<? extends PluginSystemPlugin<A>>)plugin.getClass(), plugin);
		}
	}
	
	public boolean existsPlugin(Class<? extends PluginSystemPlugin<A>> clazz)
	{
		return plugins.containsKey(clazz);
	} 
	
	@SuppressWarnings("unchecked")
	public <T extends PluginSystemPlugin<A>> T getPlugin(Class<T> clazz)
	{
		return (T) this.plugins.get(clazz);
	}

}

package cmn.utilslib.plugin;
import java.util.HashMap;

import cmn.utilslib.essentials.Auto;

public class PluginSystem<A> implements IPluginSystem<A>
{
	private HashMap<Class<? extends IPluginSystemPlugin<A>>, IPluginSystemPlugin<A>> plugins = Auto.newHashMap();
	
	private A a;
	
	public PluginSystem(A a)
	{
		this.a = a;
	}
	
	@SuppressWarnings("unchecked")
	public boolean hookPlugin(IPluginSystemPlugin<A> plugin)
	{
		if(!plugins.containsKey(plugin.getClass()))
		{
			plugins.put((Class<? extends IPluginSystemPlugin<A>>)plugin.getClass(), plugin);
			plugin.onHook(this);
		}
		
		return false;
	}
	
	public boolean existsPlugin(Class<? extends IPluginSystemPlugin<A>> clazz)
	{
		return plugins.containsKey(clazz);
	} 
	
	@SuppressWarnings("unchecked")
	public <T extends IPluginSystemPlugin<A>> T getPlugin(Class<T> clazz)
	{
		return (T) this.plugins.get(clazz);
	}

	@Override
	public boolean constrainPlugins()
	{
		for(IPluginSystemPlugin<A> plugin : plugins.values())
		{
			plugin.onConstrain(a);
		}
		
		return false;
	}

}

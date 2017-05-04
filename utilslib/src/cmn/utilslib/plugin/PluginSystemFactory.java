package cmn.utilslib.plugin;

import java.util.ArrayList;
import java.util.List;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.essentials.WeakList;

public class PluginSystemFactory<T extends PluginSystemApplicant<T>>
{

	private WeakList<T> list = new WeakList<T>();
	
	private ArrayList<Class<? extends PluginSystemPlugin<T>>> plugins = Auto.ArrayList();
	
	
	
	public void instance(T t)
	{
		
		PluginSystem<T> system = new PluginSystem<T>();
		
		t.setPluginSystem(system);
		
		for(Class<? extends PluginSystemPlugin<T>> c : this.plugins)
		{
			try
			{
				system.registerPlugin(c.newInstance(), t);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		
		}
		
		list.add(t);
	}

	
	public void addPluginPreset(Class<? extends PluginSystemPlugin<T>> plugin)
	{
		if(!this.plugins.contains(plugin))
		{
			this.plugins.add(plugin);
		
			for(T t : this.list)
			{
				try
				{
					t.getPluginSystem().registerPlugin(plugin.newInstance(), t);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
			}
			
		}

	}
	
	
	public List<Class<? extends PluginSystemPlugin<T>>> getPlugins()
	{
		return this.plugins;
	}
}

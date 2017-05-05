package cmn.utilslib.plugin;

import java.util.ArrayList;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.essentials.WeakList;

public class PluginSystemFactory<T extends PluginSystemApplicant<T>> implements IPluginSystemFactory<T>
{

	private WeakList<T> list = new WeakList<T>();
	
	private ArrayList<Class<? extends PluginSystemPlugin<T>>> plugins = Auto.ArrayList();
	
	
	
	public void instance(T master)
	{
		
		IPluginSystem<T> system = new PluginSystem<T>();
		
		master.setPluginSystem(system);
		
		for(Class<? extends PluginSystemPlugin<T>> c : this.plugins)
		{
			try
			{
				system.registerPlugin(c.newInstance(), master);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		
		}
		
		list.add(master);
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
}

package cmn.utilslib.plugin;

import java.util.ArrayList;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.essentials.WeakList;
import cmn.utilslib.plugin.api.PluginSystem;
import cmn.utilslib.plugin.api.PluginSystemApplicant;
import cmn.utilslib.plugin.api.PluginSystemFactory;
import cmn.utilslib.plugin.api.PluginSystemPlugin;

public class DefaultPluginSystemFactory<Applicant extends PluginSystemApplicant<Applicant>> implements PluginSystemFactory<Applicant>
{

	private WeakList<Applicant> list = new WeakList<Applicant>();
	
	private ArrayList<Class<? extends PluginSystemPlugin<Applicant>>> plugins = Auto.ArrayList();
	
	
	
	public void instance(Applicant master)
	{
		
		PluginSystem<Applicant> system = new DefaultPluginSystem<Applicant>();
		
		master.setPluginSystem(system);
		
		for(Class<? extends PluginSystemPlugin<Applicant>> c : this.plugins)
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

	
	public void addPluginPreset(Class<? extends PluginSystemPlugin<Applicant>> plugin)
	{
		if(!this.plugins.contains(plugin))
		{
			this.plugins.add(plugin);
		
			for(Applicant t : this.list)
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

package cmn.utilslib.plugin;

import java.util.ArrayList;
import java.util.Iterator;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.essentials.WeakList;
import cmn.utilslib.plugin.api.DependsOn;
import cmn.utilslib.plugin.api.PluginSystem;
import cmn.utilslib.plugin.api.PluginSystemApplicant;
import cmn.utilslib.plugin.api.PluginSystemFactory;
import cmn.utilslib.plugin.api.PluginSystemPlugin;

public class DefaultPluginSystemFactory<Applicant extends PluginSystemApplicant<Applicant>> implements PluginSystemFactory<Applicant>
{

	private WeakList<Applicant> list = new WeakList<Applicant>();
	
	private ArrayList<Class<? extends PluginSystemPlugin<Applicant>>> plugins = Auto.ArrayList();
	
	private ArrayList<Class<? extends PluginSystemPlugin<Applicant>>> lateInsert = Auto.ArrayList();
	
	public void instance(Applicant master)
	{
		
		PluginSystem<Applicant> system = new DefaultPluginSystem<Applicant>();
		
		master.setPluginSystem(system);
		
		ArrayList<Class<? extends PluginSystemPlugin<Applicant>>> wait = Auto.ArrayList(this.plugins);
		
		ArrayList<Class<? extends PluginSystemPlugin<Applicant>>> waitDel = Auto.ArrayList();
		
		while(!wait.isEmpty())
		{
			for(Class<? extends PluginSystemPlugin<Applicant>> plugin : wait)
			{
				int state = checkLoadedDependencies(system, plugin);
				
				if(state == 1)
				{
					waitDel.add(plugin);
					
					try
					{
						system.registerPlugin(plugin.newInstance(), master);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
				else if(state == -1)
				{
					waitDel.add(plugin);
				}
				
			}
			
			wait.removeAll(waitDel);
			waitDel.clear();			
		}

		
		list.add(master);
	}

	
	private boolean checkFactoryDependencies(Class<? extends PluginSystemPlugin<Applicant>> plugin)
	{
		DependsOn dependsOn = plugin.getAnnotation(DependsOn.class);
		if(dependsOn != null)
		{
			@SuppressWarnings("unchecked")
			Class<? extends PluginSystemPlugin<Applicant>>[] dependencies = (Class<? extends PluginSystemPlugin<Applicant>>[]) dependsOn.value();
		
			for(Class<? extends PluginSystemPlugin<Applicant>> dependency : dependencies)
			{
				if(!this.plugins.contains(dependency))
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	private int checkLoadedDependencies(PluginSystem<Applicant> system, Class<? extends PluginSystemPlugin<Applicant>> plugin)
	{
		
		if(!checkFactoryDependencies(plugin)) return -1;
		
		DependsOn dependsOn = plugin.getAnnotation(DependsOn.class);
		if(dependsOn != null)
		{
			@SuppressWarnings("unchecked")
			Class<? extends PluginSystemPlugin<Applicant>>[] dependencies = (Class<? extends PluginSystemPlugin<Applicant>>[]) dependsOn.value();
		
			for(Class<? extends PluginSystemPlugin<Applicant>> dependency : dependencies)
			{
				if(!system.existsPlugin(dependency))
				{
					return 0;
				}
			}
		}
		
		return 1;
	}
	
	public boolean addPluginPreset(Class<? extends PluginSystemPlugin<Applicant>> plugin)
	{
		if(!this.plugins.contains(plugin))
		{
			
			if(!checkFactoryDependencies(plugin))
			{
				if(!this.lateInsert.contains(plugin))
					this.lateInsert.add(plugin);
				return false;
			}
			
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
			
			for(Iterator<Class<? extends PluginSystemPlugin<Applicant>>> it = this.lateInsert.iterator(); it.hasNext(); )
			{
				if(addLatePluginPreset(it.next()))
				{
					it = this.lateInsert.iterator();
				}
			}
			
			return true;
		}
		
		return false;

	}
	
	
	private boolean addLatePluginPreset(Class<? extends PluginSystemPlugin<Applicant>> plugin)
	{
		if(!this.plugins.contains(plugin))
		{
			
			if(!checkFactoryDependencies(plugin)) return false;
			
			this.plugins.add(plugin);
			this.lateInsert.remove(plugin);
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
			
			for(Iterator<Class<? extends PluginSystemPlugin<Applicant>>> it = this.lateInsert.iterator(); it.hasNext(); )
			{
				if(addLatePluginPreset(it.next()))
				{
					it = this.lateInsert.iterator();
				}
			}
			
			return true;
			
		}
		
		return false;

	}
	
}

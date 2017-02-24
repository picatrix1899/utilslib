package cmn.utilslib.plugin;

import cmn.utilslib.essentials.Auto;

public class PluginSystemFactory<T>
{
	
	private IPluginSystemTemplate<T> template = new PluginSystemTemplate<T>();
	
	
	
	public IPluginSystem<T> instance(T t)
	{
		IPluginSystem<T> system = Auto.PluginSystem(null);
		
		for(Class<? extends IPluginSystemPlugin<T>> c : template.getPlugins())
		{
			try
			{
				system.hookPlugin(c.newInstance());
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		
		}
		
		system.constrainPlugins();
		
		return system;
	}
	
	public IPluginSystem<T> instance()
	{
		return instance(null);
	}
	
	public void setTemplate(IPluginSystemTemplate<T> template)
	{
		this.template = template;
	}
	
	public IPluginSystemTemplate<T> getTemplate()
	{
		return this.template;
	}
	
}

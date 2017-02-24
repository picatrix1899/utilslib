package cmn.utilslib.plugin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cmn.utilslib.essentials.Auto;

public class PluginSystemTemplate<T> implements IPluginSystemTemplate<T>
{
	private ArrayList<Class<? extends IPluginSystemPlugin<T>>> plugins = Auto.ArrayList();
	
	@Override
	public void addPluginPreset(Class<? extends IPluginSystemPlugin<T>> plugin)
	{
		this.plugins.add(plugin);
	}
	
	@Override
	public List<Class<? extends IPluginSystemPlugin<T>>> getPlugins()
	{
		return this.plugins;
	}

	@Override
	public Iterator<Class<? extends IPluginSystemPlugin<T>>> iterator()
	{
		return this.plugins.iterator();
	}
}

package cmn.utilslib.plugin;

import java.util.List;

public interface IPluginSystemTemplate<T> extends Iterable<Class<? extends IPluginSystemPlugin<T>>>
{
	
	public abstract void addPluginPreset(Class<? extends IPluginSystemPlugin<T>> plugin);

	public abstract List<Class<? extends IPluginSystemPlugin<T>>> getPlugins();

}

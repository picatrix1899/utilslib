import java.util.HashMap;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.plugin.IPluginSystem;
import cmn.utilslib.plugin.IPluginSystemPlugin;
import cmn.utilslib.plugin.PluginSystemFactory;
import cmn.utilslib.plugin.PluginSystemTemplate;

public class PluginSystemExample
{

	private static PlayerList list = new PlayerList();
	
	private static PluginSystemTemplate<Player> template = Auto.PluginSystemTemplate();
	
	public static void main()
	{
		
		Player player1 = new Player("Florian");
		Player player2 = new Player("Manfred");
		
		template.addPluginPreset(PlayerProperties.class);
		
		list.setTemplate(template);
		
		list.playerJoin(player1);
		System.out.println(player1.getPlugin(PlayerProperties.class).getMessage());
		
		list.playerJoin(player2);
		System.out.println(player2.getPlugin(PlayerProperties.class).getMessage());
		
	}
	
	
	public static class PlayerList
	{
		private static HashMap<String,Player> players = Auto.HashMap();
		
		private static PluginSystemFactory<Player> factory = Auto.PluginSystemFactory();
		
		public void setTemplate(PluginSystemTemplate<Player> template)
		{
			factory.setTemplate(template);
		}
		
		public void playerJoin(Player p)
		{
			p.setPluginSystem(factory.instance(p));
			players.put(p.getName(), p);
		}
		
		public void playerLeave(Player p)
		{
			
		}
		
		public Player get(String name)
		{
			return players.get(name);
		}
		
	}
	
	public static class Player
	{
		
		private String name = "";
		
		private IPluginSystem<Player> plugins;
		
		public Player(String name)
		{
			this.name = name;
		}
		
		public <T extends IPluginSystemPlugin<Player>> T getPlugin(Class<T> clazz)
		{
			return this.plugins.getPlugin(clazz);
		}
		
		public void setPluginSystem(IPluginSystem<Player> p)
		{
			this.plugins = p;
		}
		
		public String getName()
		{
			return this.name;
		}
	}
	
	public static class PlayerProperties implements IPluginSystemPlugin<Player>
	{

		private Player p;
		
		@Override
		public boolean onHook(IPluginSystem<Player> core)
		{
			return false;
		}

		@Override
		public boolean onConstrain(Player master)
		{
			this.p = master;
			
			return false;
		}
		
		
		public String getMessage()
		{
			return "Hello " + this.p.getName() + "! Welcome to the Game!";
		}
		
		
	}
	
}

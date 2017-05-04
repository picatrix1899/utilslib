import java.util.HashMap;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.plugin.PluginSystem;
import cmn.utilslib.plugin.PluginSystemApplicant;
import cmn.utilslib.plugin.PluginSystemFactory;
import cmn.utilslib.plugin.PluginSystemPlugin;

public class PluginSystemExample
{

	private static PlayerList list = new PlayerList();
	
	public static void main()
	{
		
		Player player1 = new Player("Florian");
		Player player2 = new Player("Manfred");

		
		
		list.playerJoin(player1);

		list.playerJoin(player2);
		
		list.addPlugin(PlayerProperties.class);
		
		System.out.println(player1.getPlugin(PlayerProperties.class).getMessage());
		System.out.println(player2.getPlugin(PlayerProperties.class).getMessage());
		
		list.playerLeave(player2);
		
		player2 = null;
		
		list.addPlugin(Test.class);
		
		System.out.println(player1.getPlugin(Test.class).test());
		
	}
	
	
	
	
	
	
	public static class PlayerList
	{
		private HashMap<String,Player> players = Auto.HashMap();
		
		private PluginSystemFactory<Player> factory = new PluginSystemFactory<Player>();
		
		public void addPlugin(Class<? extends PluginSystemPlugin<Player>> clazz)
		{
			factory.addPluginPreset(clazz);
		}
		
		public void playerJoin(Player p)
		{
			factory.instance(p);
			players.put(p.getName(), p);
		}
		
		public void playerLeave(Player p)
		{
			players.remove(p.getName());
		}
		
		public Player get(String name)
		{
			return players.get(name);
		}
		
	}
	
	public static class Player implements PluginSystemApplicant<Player>
	{
		
		private String name = "";
		
		private PluginSystem<Player> plugins;
		
		public Player(String name)
		{
			this.name = name;
		}
		
		public <T extends PluginSystemPlugin<Player>> T getPlugin(Class<T> clazz)
		{
			return this.plugins.getPlugin(clazz);
		}
		
		public void setPluginSystem(PluginSystem<Player> p)
		{
			this.plugins = p;
		}
		
		public PluginSystem<Player> getPluginSystem()
		{
			return this.plugins;
		}		
		
		public String getName()
		{
			return this.name;
		}

	}
	
	public static class PlayerProperties implements PluginSystemPlugin<Player>
	{

		private Player p;
		
		@Override
		public void hook(PluginSystem<Player> core) { }

		@Override
		public void load(Player master)
		{
			this.p = master;
		}
		
		
		public String getMessage()
		{
			return "Hello " + this.p.getName() + "! Welcome to the Game!";
		}
		
		
	}
	
	public static class Test implements PluginSystemPlugin<Player>
	{

		public boolean test()
		{
			return true;
		}
		
		public void hook(PluginSystem<Player> core)
		{
		}

		public void load(Player master)
		{
		}
		
	}
	
}

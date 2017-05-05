import java.util.HashMap;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.plugin.IPluginSystem;
import cmn.utilslib.plugin.PluginSystem;
import cmn.utilslib.plugin.PluginSystemApplicant;
import cmn.utilslib.plugin.PluginSystemFactory;
import cmn.utilslib.plugin.PluginSystemPlugin;

public class PluginSystemExample
{

	private static PlayerList list = new PlayerList();
	
	public static void main()
	{
		


		
		
		list.playerJoin("Florian");

		list.playerJoin("Manfred");
		
		System.out.println("Welcome " + list.get("Florian").getName() + "! Welcome to the Game");
		System.out.println("Welcome " + list.get("Manfred").getName() + "! Welcome to the Game");
		
		list.playerLeave("Manfred");

		list.addPlugin(PlayerProperties.class);
		
		list.get("Florian").getPlugin(PlayerProperties.class).setAge(20);
		
		System.out.println("Florian is " + list.get("Florian").getPlugin(PlayerProperties.class).getAge() + " years old!");
		
	}
	
	
	
	
	
	
	public static class PlayerList
	{
		private HashMap<String,Player> players = Auto.HashMap();
		
		private PluginSystemFactory<Player> factory = new PluginSystemFactory<Player>();
		
		public void addPlugin(Class<? extends PluginSystemPlugin<Player>> clazz)
		{
			factory.addPluginPreset(clazz);
		}
		
		public void playerJoin(String name)
		{
			Player p = new Player(name);
			
			factory.instance(p);
			players.put(p.getName(), p);
		}
		
		public void playerLeave(String name)
		{
			players.remove(name);
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
		
		public void setPluginSystem(IPluginSystem<Player> p)
		{
			this.plugins = (PluginSystem<Player>) p;
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

		private Player player;
		
		private int age;
		private double height;
		private double weight;
		
		
		
		@Override
		public void hook(PluginSystem<Player> core) { }

		@Override
		public void load(Player master)
		{
			this.player = master;
		}
		
		public int getAge()
		{
			return this.age;
		}
		
		public void setAge(int age)
		{
			this.age = age;
		}
		
		public double getHeight()
		{
			return this.height;
		}
		
		public void setHeight(double height)
		{
			this.height = height;
		}
		
		
		public double getWeight()
		{
			return this.weight;
		}
		
		public void setWeight(double weight)
		{
			this.weight = weight;
		}
		
		public Player getPlayer()
		{
			return this.player;
		}
		
		
	}
	
}

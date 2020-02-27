package fr.elshock.ce;

import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.elshock.ce.commands.FlyCommand;
import fr.elshock.ce.commands.HelloCommand;
import fr.elshock.ce.commands.NickCommand;
import fr.elshock.ce.commands.SetSpawnCommand;
import fr.elshock.ce.commands.SpawnCommand;
import fr.elshock.ce.commands.VanishCommand;
import fr.elshock.ce.events.AntiSpamEvent;
import fr.elshock.ce.events.ChatPrefixEvent;
import fr.elshock.ce.events.LuckBlockEvent;
import fr.elshock.ce.events.PlayerEventVanish;
import fr.elshock.ce.manager.LocationManager;

public class Main extends JavaPlugin{
	
	public static Main main;
	public static LocationManager lm;

	@Override
	public void onEnable() {
		lm = new LocationManager();
		System.out.print("Bienvenue");
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(new PlayerEventVanish(), this);
		pm.registerEvents(new ChatPrefixEvent(), this);
		pm.registerEvents(new LuckBlockEvent(), this);
		pm.registerEvents(new AntiSpamEvent(), this);
		
		getCommand("hello").setExecutor(new HelloCommand());
		getCommand("vanish").setExecutor(new VanishCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("nick").setExecutor(new NickCommand());
		getCommand("setspawn").setExecutor(new SetSpawnCommand());
		getCommand("spawn").setExecutor(new SpawnCommand());
	}

	@Override
	public void onDisable() {
		System.out.print("Aurevoir");	
	}
	
	public static void nick(Player player, String args) {
		player.setDisplayName(args);
	}
	
	public static void reset(Player p) {
		p.setDisplayName(p.getName());
	}

}
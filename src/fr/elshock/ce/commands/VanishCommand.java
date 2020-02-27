package fr.elshock.ce.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand implements CommandExecutor {
	
	public static ArrayList<Player> vanished = new ArrayList<Player>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cCette commande est exectuable que dans le serveur");
			return true;
		}
		if(sender.hasPermission("ce.vanish")) {
			Player p = (Player) sender;
			if(vanished.contains(p)) {
				for(Player player : Bukkit.getOnlinePlayers()) {
					player.showPlayer(p);
				}
				vanished.remove(p);
				p.sendMessage("§7[§6CE§7] §7Vanish §cdésactivé");
			} else {
				for(Player player : Bukkit.getOnlinePlayers()) {
					player.hidePlayer(p);
				}
				vanished.add(p);
				p.sendMessage("§7[§6CE§7] §7Vanish §aActivé");
			}
		} else {
			sender.sendMessage("§7[§6CE§7] §cTu n'as pas les permissions!");
			return true;
		}
		return false;			
	}
}
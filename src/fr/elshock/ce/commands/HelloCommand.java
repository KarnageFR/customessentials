package fr.elshock.ce.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelloCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cCette commande est exectuable que dans le serveur");
			return true;
		}		
		if(sender.hasPermission("ce.hello")) {
			Player player = (Player)sender;
			player.sendMessage(ChatColor.GREEN + "Salut!");				
		} else {
			sender.sendMessage("§7[§6CE§7] §cTu n'as pas les permissions!");
			return true;
		}
		return false;
	}
}

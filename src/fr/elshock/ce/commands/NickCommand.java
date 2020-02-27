package fr.elshock.ce.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.elshock.ce.Main;

public class NickCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("nick")) {
			Player p = (Player)sender;
			if(args.length ==0) {
				p.sendMessage("§cEssayez: /nick set <player>");
			} else {
				if(args[0].equalsIgnoreCase("set")) {
					if(args.length == 1 ) {
						p.sendMessage("§cUsage: /nick set <name>");
					} else {
						if(args.length == 2) {
							if(p.hasPermission("ec.nick") || p.isOp()) {
								Main.nick(p, args[1]);
								p.sendMessage("§7Vous avez changé en §6" + args[1]);
							}
						} else if(args.length ==3) {
							if(p.hasPermission("ec.nickother") || p.isOp()) {
								Player p2 = Bukkit.getPlayer(args[2]);
								if(p2 != null) {
									Main.nick(p2, args[1]);
									p.sendMessage("§7Vous avez changez le nom de " + p2.getName() + " en §7" +args[1]);
								} else {
									p.sendMessage("§cImpossible de trouver " + args[2]);
								}
							}
						}
					}
				} else if(args[0].equalsIgnoreCase("reset")) {
					if(args.length ==1) {
						if(p.hasPermission("ec.nickreset")) {
							Main.reset(p);
							p.sendMessage("§aVotre nicka a été reset");
						}
					}else if(args.length ==2) {
						if(p.hasPermission("ec.nick.resetother")) {
							Player p2 = Bukkit.getPlayer(args[1]);
							if(p2 != null) {
								Main.reset(p2);
								p.sendMessage("§7Nick de" + p2.getName() + " §areset");
							} else {
								p.sendMessage("§cImpossible de trouver" + args[1]);
							}
						}
					}
				}
			}
		}
		return true;
	}
}

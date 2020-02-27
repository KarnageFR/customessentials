package fr.elshock.ce.commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<String> toggle = new ArrayList();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cCette commande est exectuable que dans le serveur");
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("fly")) {
			if(sender.hasPermission("ce.fly")) {
				Player p = (Player)sender;
				if(!this.toggle.contains(p.getName())){
					this.toggle.add(p.getName());
					p.setAllowFlight(true);
					p.sendMessage("§7[§6CE§7] §7Fly §aActivé!");
				} else {
					this.toggle.remove(p.getName());
					p.setAllowFlight(false);
					p.sendMessage("§7[§6CE§7] §7Fly §4déasctivé");
				}
			} else {
				sender.sendMessage("§7[§6CE§7] §cTu n'as pas les permissions!");
				return true;
			}
		}
		return false;
	}
}

package fr.elshock.ce.events;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AntiSpamEvent implements Listener {
	
	private Map<String, Long> cooldown = new HashMap<>();
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player player = e.getPlayer();
		if(!player.isOp()) {
			if(cooldown.containsKey(player.getName())){
				int s = 2;
				long tl = ((cooldown.get(player.getName())) / 1000 + s) - (System.currentTimeMillis() / 1000);
				if(tl > 0) {
					e.getPlayer().sendMessage("§7[§6CE§7] §cNe spam pas.");
					e.setCancelled(true);
					return;				
				}
			}
			cooldown.put(player.getName(), System.currentTimeMillis());
		}
	}
}

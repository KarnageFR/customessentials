package fr.elshock.ce.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatPrefixEvent implements Listener {
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		if(e.getPlayer().getName().equals("PyroFromTF2_")) {
			e.setFormat("[Fondateur] " + e.getFormat());
		}
	}

}

package fr.elshock.ce.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import fr.elshock.ce.commands.VanishCommand;

public class PlayerEventVanish implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		createScoreboard(event.getPlayer());
		updateScoreboard();
		Player p = event.getPlayer();
		for(Player player : VanishCommand.vanished) {
			p.hidePlayer(player);
		}
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		updateScoreboard();
	}

	private void updateScoreboard() {
		for(Player online : Bukkit.getOnlinePlayers()) {
			Score score = online.getScoreboard().getObjective(DisplaySlot.SIDEBAR).getScore("players:");
			score.setScore(Bukkit.getOnlinePlayers().size());
		}
	}

	private void createScoreboard(Player player) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Objective obj = board.registerNewObjective("§3Stats", "dummy");
		obj.setDisplayName("§3Stats");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		Score score = obj.getScore("players:");
		score.setScore(Bukkit.getOnlinePlayers().size());
		player.setScoreboard(board);
	}
}
package fr.elshock.ce.events;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import fr.elshock.ce.Main;

public class LuckBlockEvent implements Listener {
	
	private Main plugin;
	
	 public LuckBlockEvent() {
		this.plugin = plugin;
	}
	 
	 @SuppressWarnings("deprecation")
	@EventHandler
	 public void onBreak(BlockBreakEvent e) {
		 if(e.getBlock().getType() != Material.SPONGE)return;
		 Location location = e.getBlock().getLocation().add(0.5,0,0.5);
		 Player p = e.getPlayer();
		 e.setCancelled(true);
		 e.getBlock().setType(Material.AIR);
		 int random = ThreadLocalRandom.current().nextInt(9);
		 switch(random) {
		 	case 0:{
		 		Witch w = location.getWorld().spawn(location, Witch.class);
		 		Bat bat = location.getWorld().spawn(location,  Bat.class);
		 		location.getWorld().spawn(location, Bat.class);
		 		location.getWorld().spawn(location, Bat.class);
		 		location.getWorld().spawn(location, Bat.class);
		 		bat.setPassenger(w);
		 		break;
		 	}
		 	case 1:{
		 		location.getWorld().spawn(location, Wolf.class);
		 		location.getWorld().dropItemNaturally(location, new ItemStack(Material.BONE, 7));
		 		e.getPlayer().playSound(location, Sound.valueOf("WOLF_GROWL"),5,1);
		 		break;
		 	}
		 	case 2:{
		 		location.getWorld().createExplosion(location, 2,true);
		 		break;
		 	}
		 	case 3:{
		 		p.sendMessage("Tu as reçu de l'eau!");
		 		p.getInventory().addItem(new ItemStack(Material.WATER_BUCKET));
		 		p.setVelocity(new Vector(0,5,0));
		 		break;
		 	}
		 	case 4:{
		 		ItemStack stack = new ItemStack(Material.DIAMOND_SWORD);
		 		ItemMeta meta = stack.getItemMeta();
		 		meta.setDisplayName("§6Epée de DIEU");
		 		meta.setLore(Arrays.asList("§7Epée forgé par §6DIEU","§7Trouvé par §6" + p.getName()));
		 		meta.addEnchant(Enchantment.DAMAGE_ALL,2,true);
		 		meta.addEnchant(Enchantment.FIRE_ASPECT,1,true);
		 		stack.setItemMeta(meta);
		 		location.getWorld().dropItem(location, stack);
		 		break;
		 	}
		 	case 5:{
		 		Pig pig = location.getWorld().spawn(location, Pig.class);
		 		pig.setSaddle(true);
		 		pig.setCustomNameVisible(true);
		 		pig.setCustomName("§5Le cochon de " + p.getName());
		 		location.getWorld().dropItemNaturally(location,  new ItemStack(Material.CARROT_STICK));
		 		break;
		 	}
		 	case 6:{
		 		location.getWorld().spawnFallingBlock(location, Material.IRON_BLOCK, (byte)0);
		 		Bukkit.getScheduler().runTaskLater(plugin,()->{
		 			location.getWorld().strikeLightning(location);
		 		},15);
		 	}
		 	case 7:{
		 		location.getWorld().spawn(location.add(0,1,0), Chicken.class);
		 		location.getWorld().spawn(location.add(-1,0,0), Chicken.class);
		 		location.getWorld().spawn(location.add(0,0,-1), Chicken.class);
		 		location.getWorld().spawn(location.add(1,0,0), Chicken.class);
		 		location.getWorld().spawn(location.add(1,0,0), Chicken.class);
		 		location.getWorld().spawn(location.add(0,0,1), Chicken.class);
		 		location.getWorld().spawn(location.add(0,0,1), Chicken.class);
		 		location.getWorld().spawn(location.add(-1,0,0), Chicken.class);
		 		location.getWorld().spawn(location.add(-1,0,0), Chicken.class);
		 		p.playSound(location, Sound.valueOf("CHICKEN_IDLE"), 1,1);
		 	}
		 	case 8:{
		 		ItemStack stack = new ItemStack(Material.DIAMOND_PICKAXE);
		 		ItemMeta meta = stack.getItemMeta();
		 		meta.setDisplayName("§6Pioche de DIEU");
		 		meta.setLore(Arrays.asList("§7Pioche forgé par §6DIEU","§7Trouvé par §6" + p.getName()));
		 		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS,3,true);
		 		meta.addEnchant(Enchantment.DURABILITY,3,true);
		 		stack.setItemMeta(meta);
		 		location.getWorld().dropItem(location, stack);
		 		break;
		 	}
		 }
	 }
}

package de.j_f_a_b.YouTube;

import net.risingworld.api.Plugin;
import net.risingworld.api.events.EventMethod;
import net.risingworld.api.events.Listener;
import net.risingworld.api.events.player.PlayerCommandEvent;
import net.risingworld.api.objects.Item;
import net.risingworld.api.objects.Player;

public class Main extends Plugin implements Listener{

	@Override
	public void onDisable() {
		System.out.println("[YouTube] Plugin has been unloaded!");
	}

	@Override
	public void onEnable() {
		System.out.println("[YouTube] Plugin has been loaded!");
		
		registerEventListener(this);
	}
	
	@EventMethod
	public void onCommand(PlayerCommandEvent e) {
		Player p = e.getPlayer();
		
		String command = e.getCommand();
		String[] cmd = command.split(" ");
		
		if(cmd[0].equalsIgnoreCase("/fly")) {
			if(p.isAdmin()) {
				if(p.isFlying()) {
					p.setFlying(false);
					
					p.sendTextMessage("[YouTube] Du kannst nun nicht mehr fliegen!");
				} else {
					p.setFlying(true);
					
					p.sendTextMessage("[YouTube] Du kannst nun fliegen!");
				}
			} else {
				p.sendTextMessage("Du darfst das nicht!");
			}
		} else if(cmd[0].equalsIgnoreCase("/more")) {
			if(p.isAdmin()) {
				if(cmd.length == 2) {
					Item item = p.getEquippedItem();
					int amount = Integer.parseInt(cmd[1]);
					
					p.getInventory().insertNewItem(item.getTypeID(), item.getVariation(), amount);
					p.sendTextMessage("[YouTube] Du hast " + amount + " von deinem ausgewähltem Item erhalten!");
				} else {
					p.sendTextMessage("[YouTube] Usage: /more <amount>");
				}
			} else {
				p.sendTextMessage("Du darfst das nicht!");
			}
		}
	}
}

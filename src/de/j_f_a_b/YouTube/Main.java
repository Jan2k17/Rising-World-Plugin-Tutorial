package de.j_f_a_b.YouTube;

import net.risingworld.api.Plugin;
import net.risingworld.api.events.EventMethod;
import net.risingworld.api.events.Listener;
import net.risingworld.api.events.player.PlayerCommandEvent;
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
	public void onCommand(PlayerCommandEvent e){
		Player p = e.getPlayer();
		String command = e.getCommand();
		String[] cmd = command.split(" ");
		
		if(cmd[0].equalsIgnoreCase("/fly")) {
			if(p.isAdmin()) {
				if(p.isFlying()) {
					p.setFlying(false);
					p.sendTextMessage("Du kannst nun nicht mehr fliegen!");
				} else {
					p.setFlying(true);
					p.sendTextMessage("Du kannst nun fliegen!");
				}
			}
		}
	}
}

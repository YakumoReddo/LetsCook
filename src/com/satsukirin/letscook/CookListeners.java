package com.satsukirin.letscook;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;


public class CookListeners implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR)||e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(e.getHand().equals(EquipmentSlot.HAND)) {
				if(!e.hasItem())return;
				ItemStack item = e.getItem();
				if(item.equals(LCItems.Washer())) {
					e.getPlayer().openInventory(CookMenu.washFood());
					e.setCancelled(true);
					return;
				}
				
				
				
			}
		}
	}

}

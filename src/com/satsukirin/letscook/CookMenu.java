package com.satsukirin.letscook;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class CookMenu {
	public static Inventory washFood() {
		CookHolder<String> holder = new CookHolder<String>("wash");
		Inventory inv = holder.setInventory(54, "洗菜");
		inv.setItem(0,getZWF(Material.LIME_STAINED_GLASS_PANE,ChatColor.GREEN+"返回"));
		
		ItemStack zwf=getZWF(Material.BLACK_STAINED_GLASS_PANE, " ");
		inv.setItem(1,zwf);
		inv.setItem(2,zwf);
		inv.setItem(6,zwf);
		inv.setItem(7,zwf);
		inv.setItem(8,zwf);
		
		zwf = getZWF(Material.IRON_BARS, " ");
		inv.setItem(3,zwf);
		inv.setItem(4,zwf);
		inv.setItem(5,zwf);
		
		zwf = getZWF(Material.GRAY_STAINED_GLASS_PANE," ");
		inv.setItem(9,zwf);
		inv.setItem(10,zwf);
		inv.setItem(18,zwf);
		inv.setItem(19,zwf);
		inv.setItem(27,zwf);
		inv.setItem(28,zwf);
		inv.setItem(36,zwf);
		inv.setItem(37,zwf);
		inv.setItem(45,zwf);
		inv.setItem(46,zwf);
		
		zwf = getZWF(Material.WHITE_STAINED_GLASS_PANE," ");
		inv.setItem(11,zwf);
		inv.setItem(12,zwf);
		inv.setItem(14,zwf);
		inv.setItem(15,zwf);
		inv.setItem(20,zwf);
		inv.setItem(24,zwf);
		inv.setItem(29,zwf);
		inv.setItem(33,zwf);
		inv.setItem(38,zwf);
		inv.setItem(42,zwf);
		inv.setItem(47,zwf);
		inv.setItem(48,zwf);
		inv.setItem(50,zwf);
		inv.setItem(51,zwf);
		
		zwf = getZWF(Material.BLUE_STAINED_GLASS_PANE, " ");
		inv.setItem(21,zwf);
		inv.setItem(22,zwf);
		inv.setItem(23,zwf);
		inv.setItem(30,zwf);
		inv.setItem(32,zwf);
		inv.setItem(39,zwf);
		inv.setItem(40,zwf);
		inv.setItem(41,zwf);
		
		inv.setItem(31,getZWF(Material.TUBE_CORAL, "水"));
		
		inv.setItem(49, getZWF(Material.HOPPER, " "));
		
		
		
		
		
		
		
		
		
		
		
		return inv;
	}
	
	
	public static Inventory Ruwei() {
		CookHolder<String> holder = new CookHolder<String>("ruwei");
		Inventory inv = holder.setInventory(54, "入味");

		inv.setItem(0,getZWF(Material.LIME_STAINED_GLASS_PANE,ChatColor.GREEN+"返回"));
		
		inv = setZWF(inv, getZWF(Material.BLACK_STAINED_GLASS_PANE, " "), 1, 8);
		
		inv = setZWF(inv, getZWF(Material.BLACK_STAINED_GLASS_PANE, " "), 45, 53);
		
		inv = setRZWF(inv, getZWF(Material.BLACK_STAINED_GLASS_PANE," "), 9, 4);
		
		inv = setRZWF(inv, getZWF(Material.BLACK_STAINED_GLASS_PANE," "), 17, 4);
		
		inv = setRZWF(inv, getZWF(Material.GRAY_STAINED_GLASS_PANE, " "), 10, 4);

		inv = setRZWF(inv, getZWF(Material.GRAY_STAINED_GLASS_PANE, " "), 16, 4);
		
		inv = setZWF(inv,getZWF(Material.GRAY_STAINED_GLASS_PANE, " "), 38, 42);
		
		inv = setRZWF(inv,getZWF(Material.BLUE_STAINED_GLASS_PANE,"主料"), 11, 3);
		
		inv = setRZWF(inv, getZWF(Material.YELLOW_STAINED_GLASS_PANE, "辅料"), 15, 3);
		
		inv.setItem(12, getZWF(Material.BLUE_STAINED_GLASS_PANE,"主料"));
		inv.setItem(30, getZWF(Material.BLUE_STAINED_GLASS_PANE,"主料"));
		inv.setItem(13, getZWF(Material.BLACK_STAINED_GLASS_PANE," "));
		inv.setItem(22, getZWF(Material.WHITE_STAINED_GLASS_PANE, "混合"));
		inv.setItem(31, getZWF(Material.BOWL, "混合"));
		inv.setItem(14, getZWF(Material.YELLOW_STAINED_GLASS_PANE, "辅料"));
		inv.setItem(32, getZWF(Material.YELLOW_STAINED_GLASS_PANE, "辅料"));
		
		return inv;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	private static Inventory setRZWF(Inventory inv,ItemStack item,int spos,int amount) {
		Inventory tinv = inv;
		for(int i=0;i<amount;i++) {
			tinv.setItem(spos+i*9, item);
		}
		return tinv;
	}
	private static Inventory setZWF(Inventory inv,ItemStack item,int spos,int epos) {
		Inventory tinv=inv;
		for(int i=spos;i<=epos;i++) {
			tinv.setItem(i, item);
		}
		return tinv;
	}
	private static ItemStack getZWF(Material ma,String name) {
		ItemStack item = new ItemStack(ma, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return item;
	}
}

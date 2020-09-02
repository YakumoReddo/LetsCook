package com.satsukirin.letscook;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class LCItems {

	private static String LCSUFFIX = ChatColor.DARK_GRAY+""+ChatColor.ITALIC+"Let's Cook!";
	
	public static class Plants{
		
		public static ItemStack hop() {
			ItemStack item = new ItemStack(Material.BLUE_ORCHID);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(ChatColor.GREEN+"啤酒花");
			List<String> lore = new LinkedList<String>();
			lore.add(LCSUFFIX);
			meta.setLore(lore);
			item.setItemMeta(meta);
			setLCSign(item,"hop");
			item.setAmount(1);
			return item;
		}
		public static ItemStack hop(int amount) {
			ItemStack item = hop();
			item.setAmount(amount);
			return item;
		}
		
		
		
		
		
		
	}
	
	
	public static class Tools{
		
		public static ItemStack mixer() {
			ItemStack item = new ItemStack(Material.FLOWER_POT);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(ChatColor.GOLD+"搅拌机");
			List<String> lore = new LinkedList<String>();
			lore.add("搅拌、混合、打粉");
			lore.add(LCSUFFIX);
			meta.setLore(lore);
			item.setItemMeta(meta);
			setLCSign(item,"mixer");
			item.setAmount(1);
			
			return item;
			
		}
		
		
		
		
		
	}
	
	public static class ToolsBlock{
		
		public static ItemStack mixerBlock() {
			ItemStack item = new ItemStack(Material.DISPENSER);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(ChatColor.YELLOW+"搅拌机");
			List<String> lore = new LinkedList<String>();
			lore.add("将搅拌机放在地上");
			lore.add("放入原料，开启机器");
			lore.add("等待成果");
			lore.add(LCSUFFIX);
			meta.setLore(lore);
			item.setItemMeta(meta);
			setLCSign(item,"mixerBlock");
			item.setAmount(1);
			return item;
		}
		
	}
	
	
	public static class Mat{
		
		public static ItemStack defaultItem() {
			ItemStack item = new ItemStack(Material.GRASS_BLOCK);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(ChatColor.RED+"未知的Let's Cook!物品");
			List<String> lore = new LinkedList<String>();
			lore.add(ChatColor.RED+"如果你看到了这个物品，说明");
			lore.add(ChatColor.AQUA+"Let's Cook!"+ChatColor.RED+" 发生了一些预料之外");
			lore.add(ChatColor.RED+"的错误，请确认错误来源后将");
			lore.add(ChatColor.RED+"错误报告提交到Issue中并附上");
			lore.add(ChatColor.RED+"该错误是如何触发的，感谢!");
			lore.add(LCSUFFIX);
			meta.setLore(lore);
			item.setItemMeta(meta);
			setLCSign(item,"default");
			item.setAmount(1);
			return item;
		}
		public static ItemStack defaultItem(int amount) {
			ItemStack item = defaultItem();
			item.setAmount(amount);
			return item;
		}
		
		public static ItemStack wheatGrain() {
			ItemStack item = new ItemStack(Material.WHEAT_SEEDS);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(ChatColor.AQUA+"麦粒");
			List<String> lore = new LinkedList<String>();
			lore.add("研磨脱粒后的小麦");
			lore.add(LCSUFFIX);
			meta.setLore(lore);
			item.setItemMeta(meta);
			setLCSign(item,"wheatGrain");
			item.setAmount(1);
			return item;
		}
		public static ItemStack wheatGrain(int amount) {
			ItemStack item = wheatGrain();
			item.setAmount(amount);
			return item;
		}
		
		
	}
	
	public static class Drinks{
		
		public static ItemStack unfermentedBeer() {
			ItemStack item = new ItemStack(Material.POTION);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(ChatColor.AQUA+"未发酵的啤酒");
			List<String> lore = new LinkedList<String>();
			lore.add("未经发酵过的啤酒");
			lore.add(LCSUFFIX);
			meta.setLore(lore);
			item.setItemMeta(meta);
			PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
			PotionEffect pe = new PotionEffect(PotionEffectType.CONFUSION, 300, 0, false,true,true);
			potionMeta.addCustomEffect(pe, true);
			item.setItemMeta(potionMeta);
			setLCSign(item,"unfermentedBeer");
			item.setAmount(1);
			return item;
		}
		
		public static ItemStack beer() {
			ItemStack item = new ItemStack(Material.POTION);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(ChatColor.GREEN+"啤酒");
			List<String> lore = new LinkedList<String>();
			lore.add("小麦酿造的啤酒");
			lore.add(LCSUFFIX);
			meta.setLore(lore);
			item.setItemMeta(meta);
			PotionMeta pm = (PotionMeta)item.getItemMeta();
			PotionEffect pe0 = new PotionEffect(PotionEffectType.ABSORPTION, 600, 1);
			PotionEffect pe1 = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 600, 0);
			PotionEffect pe2 = new PotionEffect(PotionEffectType.SLOW,1200,0);
			PotionEffect pe3 = new PotionEffect(PotionEffectType.CONFUSION,1200,0);
			pm.addCustomEffect(pe0, true);
			pm.addCustomEffect(pe1, true);
			pm.addCustomEffect(pe2, true);
			pm.addCustomEffect(pe3, true);
			item.setItemMeta(pm);
			setLCSign(item,"beer");
			item.setAmount(1);
			return item;
			
		}
		
	}
	
	
	public static class MenuItems{
		public static ItemStack mixerOpening() {
			ItemStack item = new ItemStack(Material.REDSTONE_TORCH);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(ChatColor.YELLOW+"机器正在运行...");
			List<String> lore = new LinkedList<String>();
			lore.add(LCSUFFIX);
			meta.setLore(lore);
			item.setItemMeta(meta);
			setLCSign(item, "mixerOn");
			item.setAmount(1);
			return item;
		}
		public static ItemStack mixerClosing() {
			ItemStack item = new ItemStack(Material.LEVER);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(ChatColor.AQUA+"开关");
			List<String> zwf4lore = new LinkedList<String>();
			zwf4lore.add(LCSUFFIX);
			meta.setLore(zwf4lore);
			item.setItemMeta(meta);
			setLCSign(item, "mixerClose");
			item.setAmount(1);
			return item;
		}
		
	}
	
	public static void setLCSign(ItemStack item,String tag) {
		ItemMeta meta = item.getItemMeta();
		meta.getPersistentDataContainer().set(LetsCook.getItemKey(), PersistentDataType.STRING, tag);
		item.setItemMeta(meta);
	}
	
	public static boolean hasLCSign(ItemStack item) {
		if(item==null)return false;
		if(item.getType().equals(Material.AIR))return false;
		return item.getItemMeta().getPersistentDataContainer().has(LetsCook.getItemKey(), PersistentDataType.STRING);
	}
	
	public static String getLCSign(ItemStack item) {
		return item.getItemMeta().getPersistentDataContainer().get(LetsCook.getItemKey(), PersistentDataType.STRING);
	}
	
	public static ItemStack getItem(String name) {
		ItemStack item = null;
		String str= name.toLowerCase();
		switch (str) {
		case "unfermentedbeer":
			item=Drinks.unfermentedBeer();
			break;
		case "hop":
			item=Plants.hop();
			break;
		case "mixer":
			item=Tools.mixer();
			break;
		case "wheatgrain":
			item=Mat.wheatGrain();
			break;
		case "beer":
			item=Drinks.beer();
			break;
		case "mixerblock":
			item=ToolsBlock.mixerBlock();
			break;
		default:
			item=Mat.defaultItem();
			break;
		}
		
		return item;
		
	}
	public static ItemStack getItem(String name,int amount) {
		ItemStack item = getItem(name);
		if(item!=null) {
			item.setAmount(amount);
		}
		return item;
	}
	

	
}

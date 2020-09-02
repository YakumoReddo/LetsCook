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
			meta.setDisplayName(ChatColor.GREEN+"ơ�ƻ�");
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
			meta.setDisplayName(ChatColor.GOLD+"�����");
			List<String> lore = new LinkedList<String>();
			lore.add("���衢��ϡ����");
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
			meta.setDisplayName(ChatColor.YELLOW+"�����");
			List<String> lore = new LinkedList<String>();
			lore.add("����������ڵ���");
			lore.add("����ԭ�ϣ���������");
			lore.add("�ȴ��ɹ�");
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
			meta.setDisplayName(ChatColor.RED+"δ֪��Let's Cook!��Ʒ");
			List<String> lore = new LinkedList<String>();
			lore.add(ChatColor.RED+"����㿴���������Ʒ��˵��");
			lore.add(ChatColor.AQUA+"Let's Cook!"+ChatColor.RED+" ������һЩԤ��֮��");
			lore.add(ChatColor.RED+"�Ĵ�����ȷ�ϴ�����Դ��");
			lore.add(ChatColor.RED+"���󱨸��ύ��Issue�в�����");
			lore.add(ChatColor.RED+"�ô�������δ����ģ���л!");
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
			meta.setDisplayName(ChatColor.AQUA+"����");
			List<String> lore = new LinkedList<String>();
			lore.add("��ĥ�������С��");
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
			meta.setDisplayName(ChatColor.AQUA+"δ���͵�ơ��");
			List<String> lore = new LinkedList<String>();
			lore.add("δ�����͹���ơ��");
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
			meta.setDisplayName(ChatColor.GREEN+"ơ��");
			List<String> lore = new LinkedList<String>();
			lore.add("С�������ơ��");
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
			meta.setDisplayName(ChatColor.YELLOW+"������������...");
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
			meta.setDisplayName(ChatColor.AQUA+"����");
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

package com.satsukirin.letscook;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.satsukirin.letscook.NBT.CNBTBase;
import com.satsukirin.letscook.NBT.NBT115r1;


public class LCItems {
	public static ItemStack Washer() {
		ItemStack item = new ItemStack(Material.BUCKET, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.YELLOW+"洗菜池");
		item.setItemMeta(meta);
		CNBTBase nbt = getnbtBase(item);
		nbt.setString("LetsCook", "tools");
		nbt.setString("tools", "washer");
		
		item=nbt.getItem();
		
		return item;
	}
	
	public static ItemStack Pan() {
		ItemStack item = new ItemStack(Material.BOWL,1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.YELLOW+"平底锅");
		meta.setCustomModelData(1);
		item.setItemMeta(meta);
		CNBTBase nbt = getnbtBase(item);
		nbt.setString("LetsCook", "tools");
		nbt.setString("lctools", "pan");
		item=nbt.getItem();
		return item;
	}
	
	
	
	
	
	
	
	public static ItemStack Spice() {
		ItemStack item = new ItemStack(Material.SUGAR,1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA+"香辛料");
		List<String> lore = new LinkedList<String>();
		lore.add(ChatColor.RESET+"材料");
		lore.add(ChatColor.RESET+"磨制好的香辛料");
		meta.setLore(lore);
		item.setItemMeta(meta);
		CNBTBase nbt = getnbtBase(item);
		nbt.setString("LetsCook", "msic");
		nbt.setString("lcmsic", "spice");
		nbt.setInt("hq", 0);
		item=nbt.getItem();
		return item;
	}
	public static ItemStack Spice(int amount) {
		ItemStack item = Spice();
		item.setAmount(amount);
		return item;
	}
	public static ItemStack SpiceHQ() {
		ItemStack item = Spice();
		CNBTBase nbt = getnbtBase(item);
		nbt.setInt("hq", 1);
		item=nbt.getItem();
		return item;
	}
	public static ItemStack SpiceHQ(int amount) {
		ItemStack item = SpiceHQ();
		item.setAmount(amount);
		return item;
	}
	
	public static ItemStack Oil() {
		ItemStack item = new ItemStack(Material.GLASS_BOTTLE,1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA+"食用油");
		List<String> lore = new LinkedList<String>();
		lore.add(ChatColor.RESET+"从植物中提取的食用油");
		meta.setLore(lore);
		item.setItemMeta(meta);
		CNBTBase nbt = getnbtBase(item);
		nbt.setString("LetsCook","msic");
		nbt.setString("lcmsic", "oil");
		item = nbt.getItem();
		return item;
	}
	public static ItemStack Oil(int amount) {
		ItemStack item = Oil();
		item.setAmount(amount);
		return item;
	}
	
	
	public static ItemStack Zhaxia1() {
		ItemStack item = new ItemStack(Material.COD, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.GREEN+"炸虾(1/2)");
		List<String> lore = new LinkedList<String>();
		lore.add(ChatColor.RESET+"一道普通的炸虾");
		lore.add(" ");
		lore.add(ChatColor.RESET+"工序: ");
		lore.add(ChatColor.RESET+"  入味: "+ChatColor.GREEN+"完成");
		lore.add(ChatColor.RESET+"  油炸: "+ChatColor.RED+"未完成");
		meta.setLore(lore);
		meta.setCustomModelData(2);
		item.setItemMeta(meta);
		CNBTBase nbt = getnbtBase(item);
		nbt.setString("LetsCook", "cook");
		nbt.setString("lccook", "zhaxia1");
		nbt.setInt("lcprocess", 1);
		item=nbt.getItem();
		return item;
	}
	
	public static ItemStack Zhaxia() {
		ItemStack item = new ItemStack(Material.COD, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.BLUE+"炸虾");
		List<String> lore = new LinkedList<String>();
		lore.add(ChatColor.RESET+"一道普通的炸虾");
		lore.add(ChatColor.RESET+"食用效果: ");
		lore.add(ChatColor.AQUA+"  智力+5");
		lore.add(ChatColor.AQUA+"  三观+5");
		lore.add(ChatColor.AQUA+"  理智+5");
		lore.add(ChatColor.AQUA+"  反胃I");
		meta.setLore(lore);
		meta.setCustomModelData(1);
		item.setItemMeta(meta);
		CNBTBase nbt = getnbtBase(item);
		nbt.setString("LetsCook", "cook");
		nbt.setString("lccook", "zhaxia");
		nbt.setInt("hq", 0);
		item=nbt.getItem();
		return item;
	}
	public static ItemStack Zhaxia(int amount) {
		ItemStack item = Zhaxia();
		item.setAmount(amount);
		return item;
	}
	public static ItemStack ZhaxiaHQ() {
		ItemStack item = Zhaxia();
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.BLUE+"炸虾※");
		List<String> lore = new LinkedList<String>();
		lore.add(ChatColor.RESET+"一道普通的炸虾");
		lore.add(ChatColor.RESET+"食用效果: ");
		lore.add(ChatColor.AQUA+"  智力+8");
		lore.add(ChatColor.AQUA+"  三观+8");
		lore.add(ChatColor.AQUA+"  理智+8");
		lore.add(ChatColor.AQUA+"  反胃I");
		meta.setLore(lore);
		meta.setCustomModelData(1);
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		CNBTBase nbt = getnbtBase(item);
		nbt.setInt("hq", 1);
		item=nbt.getItem();
		return item;
	}
	public static ItemStack ZhaxiaHQ(int amount) {
		ItemStack item = ZhaxiaHQ();
		item.setAmount(amount);
		return item;
	}
	
	
	
	private static CNBTBase getnbtBase(ItemStack item) {
		String raw = Bukkit.getServer().getClass().getPackage().getName();
		String nms = raw.substring(raw.lastIndexOf(".")+1);
		switch (nms) {
		case "v1_15_R1":
			return new NBT115r1(item);

		default:
			break;
		}
		
		
		
		
		return null;
	}
	
}

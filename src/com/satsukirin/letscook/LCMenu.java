package com.satsukirin.letscook;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.satsukirin.letscook.utils.LCInventoryHolder;

public class LCMenu {

	private static String LCSUFFIX = ChatColor.DARK_GRAY+""+ChatColor.ITALIC+"Let's Cook!";
	
	public static Inventory mixerMenu() {
		LCInventoryHolder holder = new LCInventoryHolder("mixer", 54, "搅拌机");
		Inventory inv = holder.getInventory();
		
		ItemStack zwf1 = new ItemStack(Material.GLASS_PANE);
		ItemMeta zwf1meta = zwf1.getItemMeta();
		zwf1meta.setDisplayName(" ");
		zwf1.setItemMeta(zwf1meta);
		inv.setItem(9, zwf1);
		inv.setItem(10, zwf1);
		inv.setItem(11, zwf1);
		inv.setItem(12, zwf1);
		inv.setItem(13, zwf1);
		inv.setItem(14, zwf1);
		inv.setItem(15, zwf1);
		inv.setItem(18, zwf1);
		inv.setItem(24, zwf1);
		inv.setItem(27, zwf1);
		inv.setItem(28, zwf1);
		inv.setItem(30, zwf1);
		inv.setItem(31, zwf1);
		inv.setItem(33, zwf1);
		inv.setItem(34, zwf1);
		inv.setItem(35, zwf1);
		inv.setItem(39, zwf1);
		inv.setItem(48, zwf1);
		
		ItemStack zwf2 = new ItemStack(Material.FLINT);
		ItemMeta zwf2meta = zwf2.getItemMeta();
		zwf2meta.setDisplayName(ChatColor.AQUA+"刀片");
		List<String> zwf2lore = new LinkedList<String>();
		zwf2lore.add(LCSUFFIX);
		zwf2meta.setLore(zwf2lore);
		zwf2.setItemMeta(zwf2meta);
		inv.setItem(29, zwf2);
		
		ItemStack zwf3 = new ItemStack(Material.PISTON);
		ItemMeta zwf3meta = zwf3.getItemMeta();
		zwf3meta.setDisplayName(ChatColor.AQUA+"电机");
		List<String> zwf3lore = new LinkedList<String>();
		zwf3lore.add(LCSUFFIX);
		zwf3meta.setLore(zwf3lore);
		zwf3.setItemMeta(zwf3meta);
		inv.setItem(38, zwf3);
		

		inv.setItem(47, LCItems.MenuItems.mixerClosing());
		
		ItemStack zwf5 = new ItemStack(Material.HOPPER);
		ItemMeta zwf5meta= zwf5.getItemMeta();
		zwf5meta.setDisplayName(ChatColor.GREEN+"出料口");
		List<String> zwf5lore = new LinkedList<String>();
		zwf5lore.add(LCSUFFIX);
		zwf5meta.setLore(zwf5lore);
		zwf5.setItemMeta(zwf5meta);
		inv.setItem(32, zwf5);
		
		return inv;
	}
	
	public static Inventory brewBasic() {
		LCInventoryHolder holder = new LCInventoryHolder("brew", 54, "多功能酿造台");
		Inventory inv = holder.getInventory();
		
		ItemStack zwf1 = new ItemStack(Material.GLASS_PANE);
		ItemMeta zwf1meta = zwf1.getItemMeta();
		zwf1meta.setDisplayName(" ");
		List<String> zwf1lore = new LinkedList<String>();
		zwf1lore.add(LCSUFFIX);
		zwf1meta.setLore(zwf1lore);
		zwf1.setItemMeta(zwf1meta);
		inv.setItem(1, zwf1);
		inv.setItem(10, zwf1);
		inv.setItem(19, zwf1);
		inv.setItem(28, zwf1);
		inv.setItem(37, zwf1);
		inv.setItem(46, zwf1);
		
		ItemStack zwf2 = new ItemStack(Material.IRON_BARS);
		ItemMeta zwf2meta = zwf2.getItemMeta();
		zwf2meta.setDisplayName(" ");
		List<String> zwf2lore = new LinkedList<String>();
		zwf2lore.add(LCSUFFIX);
		zwf2meta.setLore(zwf2lore);
		zwf2.setItemMeta(zwf2meta);
		inv.setItem(14, zwf2);
		inv.setItem(21, zwf2);
		inv.setItem(22, zwf2);
		inv.setItem(24, zwf2);
		inv.setItem(25, zwf2);
		inv.setItem(30, zwf2);
		inv.setItem(32, zwf2);
		inv.setItem(34, zwf2);
		
		ItemStack zwf3 = new ItemStack(Material.OBSIDIAN);
		ItemMeta zwf3meta = zwf3.getItemMeta();
		zwf3meta.setDisplayName(" ");
		List<String> zwf3lore = new LinkedList<String>();
		zwf3lore.add(LCSUFFIX);
		zwf3meta.setLore(zwf3lore);
		zwf3.setItemMeta(zwf3meta);
		inv.setItem(47, zwf3);
		inv.setItem(48, zwf3);
		inv.setItem(49, zwf3);
		inv.setItem(50, zwf3);
		inv.setItem(51, zwf3);
		inv.setItem(52, zwf3);
		inv.setItem(53, zwf3);
		
		inv = brewSideBar(inv);
		
		return inv;
	}
	
	public static Inventory brewSideBar(Inventory inv) {
		ItemStack blaze = new ItemStack(Material.BLAZE_POWDER);
		ItemMeta blazeMeta = blaze.getItemMeta();
		blazeMeta.setDisplayName(ChatColor.GOLD+"烈焰酿造");
		List<String> blazelore=new LinkedList<String>();
		blazelore.add("最为原始的高温酿造");
		blazelore.add(LCSUFFIX);
		blazeMeta.setLore(blazelore);
		blaze.setItemMeta(blazeMeta);
		inv.setItem(0, blaze);
		
		ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
		ItemMeta lavaMeta = lava.getItemMeta();
		lavaMeta.setDisplayName(ChatColor.RED+"岩浆酿造");
		List<String> lavalore = new LinkedList<String>();
		lavalore.add("稍微高级点的岩浆酿造");
		lavalore.add(LCSUFFIX);
		lavaMeta.setLore(lavalore);
		lava.setItemMeta(lavaMeta);
		inv.setItem(9,lava);
		
		ItemStack water = new ItemStack(Material.WATER_BUCKET);
		ItemMeta waterMeta = water.getItemMeta();
		waterMeta.setDisplayName(ChatColor.BLUE+"泉水酿造");
		List<String> waterlore=new LinkedList<String>();
		waterlore.add("普通的泉水酿造");
		waterlore.add(LCSUFFIX);
		waterMeta.setLore(waterlore);
		water.setItemMeta(waterMeta);
		inv.setItem(18, water);
		
		ItemStack ice = new ItemStack(Material.ICE);
		ItemMeta iceMeta = ice.getItemMeta();
		iceMeta.setDisplayName(ChatColor.AQUA+"凛冰酿造");
		List<String> icelore = new LinkedList<String>();
		icelore.add("稍微高级点的寒冰酿造");
		icelore.add(LCSUFFIX);
		iceMeta.setLore(icelore);
		ice.setItemMeta(iceMeta);
		inv.setItem(27, ice);
		
		ItemStack ender = new ItemStack(Material.END_STONE);
		ItemMeta enderMeta = ender.getItemMeta();
		enderMeta.setDisplayName(ChatColor.YELLOW+"末影酿造");
		List<String> enderlore = new LinkedList<String>();
		enderlore.add("高级的异域酿造");
		enderlore.add(LCSUFFIX);
		enderMeta.setLore(enderlore);
		ender.setItemMeta(enderMeta);
		inv.setItem(36, ender);
		
		ItemStack soul = new ItemStack(Material.SOUL_SAND);
		ItemMeta soulMeta = soul.getItemMeta();
		soulMeta.setDisplayName(ChatColor.GRAY+"灵魂酿造");
		List<String> soullore = new LinkedList<String>();
		soullore.add("高级的灵魂酿造");
		soullore.add(LCSUFFIX);
		soul.setItemMeta(soulMeta);
		inv.setItem(45,soul);
		
		return inv;
	}
	
	public static Inventory blazeBrew() {
		Inventory inv = brewBasic();
		LCInventoryHolder holder = (LCInventoryHolder)inv.getHolder();
		holder.setData("blazebrew");
		setBrewShape(inv, buildZWF(Material.NETHERRACK));
		

		ItemStack blaze = new ItemStack(Material.BLAZE_POWDER);
		ItemMeta blazeMeta = blaze.getItemMeta();
		blazeMeta.setDisplayName(ChatColor.GOLD+"烈焰酿造");
		List<String> blazelore=new LinkedList<String>();
		blazelore.add("最为原始的高温酿造");
		blazelore.add(LCSUFFIX);
		blazeMeta.setLore(blazelore);
		blaze.setItemMeta(blazeMeta);
		inv.setItem(0, setGrow(blaze));
		
		return inv;
	}
	public static Inventory lavaBrew() {
		Inventory inv = brewBasic();
		LCInventoryHolder holder = (LCInventoryHolder)inv.getHolder();
		holder.setData("lavabrew");
		setBrewShape(inv, buildZWF(Material.BASALT));
		

		ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
		ItemMeta lavaMeta = lava.getItemMeta();
		lavaMeta.setDisplayName(ChatColor.RED+"岩浆酿造");
		List<String> lavalore = new LinkedList<String>();
		lavalore.add("稍微高级点的岩浆酿造");
		lavalore.add(LCSUFFIX);
		lavaMeta.setLore(lavalore);
		lava.setItemMeta(lavaMeta);
		inv.setItem(9,setGrow(lava));
		
		return inv;
	}
	public static Inventory waterBrew() {
		Inventory inv = brewBasic();
		LCInventoryHolder holder = (LCInventoryHolder)inv.getHolder();
		holder.setData("waterbrew");
		setBrewShape(inv, buildZWF(Material.GRASS));
		

		ItemStack lava = new ItemStack(Material.WATER_BUCKET);
		ItemMeta lavaMeta = lava.getItemMeta();
		lavaMeta.setDisplayName(ChatColor.BLUE+"泉水酿造");
		List<String> lavalore = new LinkedList<String>();
		lavalore.add("普通的泉水酿造");
		lavalore.add(LCSUFFIX);
		lavaMeta.setLore(lavalore);
		lava.setItemMeta(lavaMeta);
		inv.setItem(18,setGrow(lava));
		
		return inv;
	}	
	public static Inventory iceBrew() {
		Inventory inv = brewBasic();
		LCInventoryHolder holder = (LCInventoryHolder)inv.getHolder();
		holder.setData("icebrew");
		setBrewShape(inv, buildZWF(Material.SNOW_BLOCK));
		

		ItemStack lava = new ItemStack(Material.ICE);
		ItemMeta lavaMeta = lava.getItemMeta();
		lavaMeta.setDisplayName(ChatColor.AQUA+"凛冰酿造");
		List<String> lavalore = new LinkedList<String>();
		lavalore.add("稍微高级点的寒冰酿造");
		lavalore.add(LCSUFFIX);
		lavaMeta.setLore(lavalore);
		lava.setItemMeta(lavaMeta);
		inv.setItem(27,setGrow(lava));
		
		return inv;
	}
	public static Inventory enderBrew() {
		Inventory inv = brewBasic();
		LCInventoryHolder holder = (LCInventoryHolder)inv.getHolder();
		holder.setData("enderbrew");
		setBrewShape(inv, buildZWF(Material.END_STONE_BRICKS));
		

		ItemStack lava = new ItemStack(Material.END_STONE);
		ItemMeta lavaMeta = lava.getItemMeta();
		lavaMeta.setDisplayName(ChatColor.YELLOW+"末影酿造");
		List<String> lavalore = new LinkedList<String>();
		lavalore.add("高级的异域酿造");
		lavalore.add(LCSUFFIX);
		lavaMeta.setLore(lavalore);
		lava.setItemMeta(lavaMeta);
		inv.setItem(36,setGrow(lava));
		
		return inv;
	}
	public static Inventory soulBrew() {
		Inventory inv = brewBasic();
		LCInventoryHolder holder = (LCInventoryHolder)inv.getHolder();
		holder.setData("soulbrew");
		setBrewShape(inv, buildZWF(Material.WARPED_HYPHAE));
		

		ItemStack lava = new ItemStack(Material.SOUL_SAND);
		ItemMeta lavaMeta = lava.getItemMeta();
		lavaMeta.setDisplayName(ChatColor.GRAY+"灵魂酿造");
		List<String> lavalore = new LinkedList<String>();
		lavalore.add("高级的灵魂酿造");
		lavalore.add(LCSUFFIX);
		lavaMeta.setLore(lavalore);
		lava.setItemMeta(lavaMeta);
		inv.setItem(45,setGrow(lava));
		
		return inv;
	}
	
	private static Inventory setBrewShape(Inventory inv,ItemStack item) {
		inv.setItem(4, item);
		inv.setItem(6, item);
		inv.setItem(11, item);
		inv.setItem(12, item);
		inv.setItem(13, item);
		inv.setItem(15, item);
		inv.setItem(16, item);
		inv.setItem(17, item);
		inv.setItem(20, item);
		inv.setItem(26, item);
		inv.setItem(29, item);
		inv.setItem(31, item);
		inv.setItem(33, item);
		inv.setItem(35, item);
		inv.setItem(38, item);
		inv.setItem(40, item);
		inv.setItem(42, item);
		inv.setItem(44, item);
		return inv;
	}
	
	private static ItemStack buildZWF(Material material) {
		ItemStack item = new ItemStack(material);
		ItemMeta meta=item.getItemMeta();
		meta.setDisplayName(" ");
		List<String> lore = new LinkedList<String>();
		lore.add(LCSUFFIX);
		meta.setLore(lore);
		item.setItemMeta(meta);
		item.setAmount(1);
		return item;
	}
	
	private static ItemStack setGrow(ItemStack item) {
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 1, false);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
}

package com.satsukirin.letscook;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import com.satsukirin.letscook.utils.LCConfigurationSection;

public class LCItemLoader {
	private Map<String, ItemStack> lcitems;
	private LetsCook plugin;
	private YamlConfiguration itemConfig;
 	private File itemFile;
	
	
	public LCItemLoader(LetsCook p) throws IOException{
		plugin=p;
		itemFile = new File(plugin.getDataFolder(),"items.yml");
		if(itemFile.exists()) {
			itemConfig = YamlConfiguration.loadConfiguration(itemFile);
		}else {
			plugin.getLogger().info("[Let's Cook!] File items.yml unfounded, creating default file...");
			plugin.saveResource("items.yml", false);
			itemConfig = YamlConfiguration.loadConfiguration(itemFile);
			
//			ConfigurationSection section1 = itemConfig.createSection("hop");
//			section1.set("item", LCItems.Plants.hop());
//			ConfigurationSection section2 = itemConfig.createSection("beer");
//			section2.set("item", LCItems.Drinks.beer());
//			ConfigurationSection section3 = itemConfig.createSection("mixer");
//			section3.set("item", LCItems.Tools.mixer());
//			ConfigurationSection section4 = itemConfig.createSection("wheatgrain");
//			section4.set("item", LCItems.Mat.wheatGrain());
		}
		lcitems = new HashMap<String, ItemStack>();
		Set<String> keys = itemConfig.getKeys(false);
		plugin.getLogger().info("found "+keys.size()+" items");
		for (String string : keys) {
			if(!itemConfig.isConfigurationSection(string))continue;
			ConfigurationSection section = itemConfig.getConfigurationSection(string);
			ItemStack item = LCConfigurationSection.getItemStack(section.getConfigurationSection("item"));
			lcitems.put(section.getName(), item);
		}
		
		itemConfig.save(itemFile);
		
		
	}
	
	public void reload() {
		plugin.getLogger().info("Reloading LetsCook");
		try {
			itemConfig.save(itemFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		itemFile = new File(plugin.getDataFolder(),"items.yml");
		if(itemFile.exists()) {
			itemConfig = YamlConfiguration.loadConfiguration(itemFile);
		}else {
			plugin.getLogger().info("[Let's Cook!] File items.yml unfounded, creating default file...");
			plugin.saveResource("items.yml", false);
			itemConfig = YamlConfiguration.loadConfiguration(itemFile);
			
//			ConfigurationSection section1 = itemConfig.createSection("hop");
//			section1.set("item", LCItems.Plants.hop());
//			ConfigurationSection section2 = itemConfig.createSection("beer");
//			section2.set("item", LCItems.Drinks.beer());
//			ConfigurationSection section3 = itemConfig.createSection("mixer");
//			section3.set("item", LCItems.Tools.mixer());
//			ConfigurationSection section4 = itemConfig.createSection("wheatgrain");
//			section4.set("item", LCItems.Mat.wheatGrain());
		}
		lcitems.clear();
		Set<String> keys = itemConfig.getKeys(false);
		plugin.getLogger().info("found "+keys.size()+" items");
		for (String string : keys) {
			if(!itemConfig.isConfigurationSection(string))continue;
			ConfigurationSection section = itemConfig.getConfigurationSection(string);
			ItemStack item = LCConfigurationSection.getItemStack(section.getConfigurationSection("item"));
			lcitems.put(section.getName(), item);
		}
		
		try {
			itemConfig.save(itemFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void saveItem(ItemStack item,String name) {
		ConfigurationSection section = itemConfig.createSection(name);
		LCConfigurationSection.setItemStack(section, item);
		lcitems.put(name, item);
		try {
			itemConfig.save(itemFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	public void deleteItem(String name) {
		if(lcitems.containsKey(name)) {
			lcitems.remove(name);
		}
		itemConfig.set(name, null);
	}
	
	public ItemStack getItem(String name) {
		if(lcitems.containsKey(name)) {
			return lcitems.get(name);
		}else {
			return LCItems.Mat.defaultItem();
		}
	}
	public ItemStack getItem(String name, int amount) {
		ItemStack item = this.getItem(name);
		item.setAmount(amount);
		return item;
	}
	public boolean hasItem(String name) {
		return lcitems.containsKey(name);
	}
}

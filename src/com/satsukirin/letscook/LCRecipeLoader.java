package com.satsukirin.letscook;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;


public class LCRecipeLoader {
	LetsCook plugin;
	
	YamlConfiguration brewConfig;
	
	public class BrewRecipe{
		public String type;
		public String resource;
		public String result;
		
		public ItemStack getResource() {
			return LCItems.getItem(resource);
		}
		public ItemStack getResult() {
			return LCItems.getItem(result);
		}
	}
	
	public LCRecipeLoader(LetsCook p) throws IOException{
		plugin = p;
		
		LCItemLoader itemLoader = new LCItemLoader(plugin);
		
		File brewFile = new File(plugin.getDataFolder(),"BrewRecipe.yml");
		
		if(brewFile.exists()) {
			brewConfig = YamlConfiguration.loadConfiguration(brewFile);
		}else {
			plugin.getLogger().info("[Let's Cook!] File BrewRecipe.yml unfounded, creating default file...");
			plugin.saveResource("BrewRecipe.yml", false);
			brewConfig = YamlConfiguration.loadConfiguration(brewFile);
		}
		
		brewRecipe = new HashMap<ItemStack, LCRecipeLoader.BrewRecipe>();
		
		Set<String> keys = brewConfig.getKeys(false);
		for (String string : keys) {
			ConfigurationSection section = brewConfig.getConfigurationSection(string);
			BrewRecipe recipe = new BrewRecipe();
			
			recipe.type = section.getString("type");
			recipe.resource = section.getString("resource");
			recipe.result = section.getString("result");
			if(itemLoader.hasItem(recipe.resource)||itemLoader.hasItem(recipe.result)) {
				brewRecipe.put(itemLoader.getItem(recipe.resource),recipe);
			}
		}
		plugin.getLogger().info("[Let's Cook!] Loaded "+brewRecipe.size()+" brewing recipes!");
		
			
			
	}
	public Map<ItemStack, BrewRecipe> brewRecipe;
	
	public Map<ItemStack, BrewRecipe> getBrewRecipe(){
		return brewRecipe;
	}
}

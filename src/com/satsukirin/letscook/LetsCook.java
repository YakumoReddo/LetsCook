package com.satsukirin.letscook;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;


public class LetsCook extends JavaPlugin {
	
	
	private static LetsCook instance;
	private LCItemLoader itemLoader;
	
	@Override
	public void onEnable() {
		
		instance = this;
		
		LCRecipes lcr = new LCRecipes(this);
		
		try {
			itemLoader = new LCItemLoader(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.getCommand("lc").setExecutor(new LCCmds(this));
		
		Bukkit.getPluginManager().registerEvents(new LCListeners(this), this);
		
		
		getLogger().info("[Let's Cook!] Has been loaded!");
		
	}
	
	@Override
	public void onDisable() {
		
		
		getLogger().info("[Let's Cook!] Unloaded.");
	}
	
	public LCItemLoader getItemLoader() {
		return this.itemLoader;
	}
	public static LetsCook getInstance() {
		return instance;
	}
	public static NamespacedKey getItemKey() {
		return new NamespacedKey(instance, "letscookitem");
	}
	public static NamespacedKey getBlockKey() {
		return new NamespacedKey(instance, "letscookblock");
	}
}

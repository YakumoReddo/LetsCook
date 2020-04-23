package com.satsukirin.letscook;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class LetsCook extends JavaPlugin {

	@Override
	public void onEnable() {
		
		Bukkit.getPluginManager().registerEvents(new CookListeners(), this);
		this.getCommand("lc").setExecutor(new CookCmd(this));
		getLogger().info("[Let's Cook!] Has been loaded!");
	}
	
	@Override
	public void onDisable() {
		
		
		getLogger().info("[Let's Cook!] Unloaded.");
	}
}

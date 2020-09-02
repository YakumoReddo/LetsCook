package com.satsukirin.letscook.utils;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;


public class LCInventoryHolder implements InventoryHolder {
	
	protected Inventory inventory;
	protected String data;
	
	public LCInventoryHolder(String str) {
		this.data=str;
		inventory = Bukkit.createInventory(this, 54);	
	}
	public LCInventoryHolder(String str,int size) {
		this.data = str;
		inventory = Bukkit.createInventory(this, size);
	}
	public LCInventoryHolder(String str,int size,String title) {
		this.data = str;
		inventory = Bukkit.createInventory(this, size,title);
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String str) {
		data = str;
		return;
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	public void setInventory(Inventory inv) {
		inventory = inv;
		return;
	}
}

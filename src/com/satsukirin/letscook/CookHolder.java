package com.satsukirin.letscook;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;


public class CookHolder<T> implements InventoryHolder {
	protected Inventory inventory;
	protected T Data;
	
	public CookHolder(T data) {
		this.Data=data;
		
	}

	@Override
	public Inventory getInventory() {
		
		return this.inventory;
	}
	public void setInventory(Inventory inv) {
		this.inventory=inv;
		return;
	}
	public Inventory setInventory(int size,String title) {
		this.inventory = Bukkit.createInventory(this, size, title);
		return this.inventory;
	}
	
	public void setData(T dat) {
		this.Data=dat;
	}
	
	public T getData() {
		return this.Data;
	}

}

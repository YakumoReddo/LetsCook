package com.satsukirin.letscook.NBT;

import org.bukkit.inventory.ItemStack;

public interface CNBTBase {
	
	public ItemStack getItem();
	public void setItem(ItemStack item);
	
	public String getString(String key);
	public int getInt(String key);
	public double getdouble(String key);
	public int[] getIntArray(String key);
	
	public void setString(String key,String value);
	public void setInt(String key,int value);
	public void setdouble(String key,double value);
	public void setIntArray(String key,int[] value);
}

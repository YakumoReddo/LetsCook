package com.satsukirin.letscook.NBT;

import org.bukkit.craftbukkit.v1_15_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

import net.minecraft.server.v1_15_R1.NBTTagCompound;

public class NBT115r1 implements CNBTBase{
	
	private ItemStack item;
	private NBTTagCompound nbttc;
	
	public NBT115r1(ItemStack it) {
		this.item=it;
		net.minecraft.server.v1_15_R1.ItemStack nmsitem = CraftItemStack.asNMSCopy(this.item);
		nbttc = nmsitem.hasTag()?nmsitem.getTag():(new NBTTagCompound());
	}
	
	@Override
	public String getString(String key) {
		return nbttc.getString(key);
	}

	@Override
	public int getInt(String key) {
		return nbttc.getInt(key);
	}

	@Override
	public double getdouble(String key) {
		return nbttc.getDouble(key);
	}

	@Override
	public int[] getIntArray(String key) {
		return getIntArray(key);
	}

	@Override
	public ItemStack getItem() {
		net.minecraft.server.v1_15_R1.ItemStack nmsitem = CraftItemStack.asNMSCopy(this.item);
		nmsitem.setTag(nbttc);
		item=CraftItemStack.asBukkitCopy(nmsitem);
		return item;
	}

	@Override
	public void setItem(ItemStack it) {
		this.item=it;
		net.minecraft.server.v1_15_R1.ItemStack nmsitem = CraftItemStack.asNMSCopy(this.item);
		nbttc = nmsitem.hasTag()?nmsitem.getTag():(new NBTTagCompound());
		
	}

	@Override
	public void setString(String key, String value) {
		nbttc.setString(key, value);
	}

	@Override
	public void setInt(String key, int value) {
		nbttc.setInt(key, value);
		
	}

	@Override
	public void setdouble(String key, double value) {
		nbttc.setDouble(key, value);
		
	}

	@Override
	public void setIntArray(String key, int[] value) {
		nbttc.setIntArray(key, value);
		
	}

}

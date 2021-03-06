package com.satsukirin.letscook.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.Color;

import com.satsukirin.letscook.LetsCook;

public class LCConfigurationSection {
	public static ConfigurationSection setItemStack(ConfigurationSection section, ItemStack item) {
		ConfigurationSection itemSection = section.createSection("item");
		itemSection.set("type", item.getType().name());
		itemSection.set("amount", item.getAmount());
		ConfigurationSection metaSection = itemSection.createSection("meta");
		ItemMeta meta = item.getItemMeta();
		if(meta.getPersistentDataContainer().has(LetsCook.getItemKey(), PersistentDataType.STRING)) {
			metaSection.set("letscookItemKey", meta.getPersistentDataContainer().get(LetsCook.getItemKey(), PersistentDataType.STRING));
		}
		if(meta.hasDisplayName()) {
			metaSection.set("displayName", meta.getDisplayName());
		}
		if(meta.hasCustomModelData()) {
			metaSection.set("customModelData", meta.getCustomModelData());
		}
		if(meta.hasEnchants()) {
			Map<Enchantment, Integer> enchants = meta.getEnchants();
			List<String> strench = new ArrayList<String>();
			for (Enchantment ench : enchants.keySet()) {
				strench.add(ench.getKey().getKey()+","+enchants.get(ench));
			}
			metaSection.set("enchants", strench);
		}
		if(hasItemFlags(meta)) {
			metaSection.set("itemFlags", getItemFlags(meta));
		}
		if(meta.hasLore()) {
			metaSection.set("lore",meta.getLore());
		}
		if(item.getType().equals(Material.POTION)) {
			PotionMeta potionMeta = (PotionMeta)item.getItemMeta();
			ConfigurationSection potionSection = metaSection.createSection("potion");
			List<PotionEffect> effects = potionMeta.getCustomEffects();
			List<String> listEffect = new ArrayList<String>();
			for (PotionEffect potionEffect : effects) {
				listEffect.add(potionEffect.getType().getName()+","+potionEffect.getDuration()+","+potionEffect.getAmplifier()+","+(potionEffect.isAmbient()?"1":"0")+","+(potionEffect.hasParticles()?"1":"0")+","+(potionEffect.hasIcon()?"1":"0"));
			}
			potionSection.set("effects", listEffect);
			if(potionMeta.hasColor()) {
				potionSection.set("color", potionMeta.getColor().asRGB());
			}
			
		}
		return itemSection;
	}
	public static ItemStack getItemStack(ConfigurationSection section) {
		ItemStack item = new ItemStack(Material.matchMaterial(section.getString("type")));
		item.setAmount(section.getInt("amount"));
		ItemMeta meta = item.getItemMeta();
		ConfigurationSection metaSection = section.getConfigurationSection("meta");
		if(metaSection.isString("letscookItemKey")) {
			meta.getPersistentDataContainer().set(LetsCook.getItemKey(), PersistentDataType.STRING, metaSection.getString("letscookItemKey"));
		}
		if(metaSection.isString("displayName")) {
			meta.setDisplayName(metaSection.getString("displayName"));
		}
		if(metaSection.isInt("customModelData")) {
			meta.setCustomModelData(metaSection.getInt("customModelData"));
		}
		if(metaSection.isList("itemFlags")) {
			List<String> itemflags = metaSection.getStringList("itemFlags");
			for (String string : itemflags) {
				meta.addItemFlags(ItemFlag.valueOf(string));
			}
		}
		if(metaSection.isList("lore")) {
			List<String> lore = metaSection.getStringList("lore");
			meta.setLore(lore);
		}
		if(metaSection.isList("enchants")) {
			List<String> enchants = metaSection.getStringList("enchants");
			for (String string : enchants) {
				String[] strs = string.split(",");
				meta.addEnchant(Enchantment.getByKey(NamespacedKey.minecraft(strs[0])), Integer.parseInt(strs[1]),true);
			}
		}
		item.setItemMeta(meta);

		if(metaSection.isConfigurationSection("potion")) {
			ConfigurationSection potionSection = metaSection.getConfigurationSection("potion");
			PotionMeta potionMeta = (PotionMeta)item.getItemMeta();
			List<String> effects = potionSection.getStringList("effects");
			for (String str : effects) {
				String[] args = str.split(",");
				potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.getByName(args[0]), Integer.parseInt(args[1]),Integer.parseInt(args[2]), getStringBool(args[3]), getStringBool(args[4]),getStringBool(args[5])), true);
			}
			if(potionSection.isInt("color")) {
				potionMeta.setColor(Color.fromRGB(potionSection.getInt("color")));
			}
		}
		
		return item;
	}
	
	private static boolean hasItemFlags(ItemMeta meta) {
		if(meta.hasItemFlag(ItemFlag.HIDE_ATTRIBUTES))return true;
		if(meta.hasItemFlag(ItemFlag.HIDE_DESTROYS))return true;
		if(meta.hasItemFlag(ItemFlag.HIDE_DYE))return true;
		if(meta.hasItemFlag(ItemFlag.HIDE_ENCHANTS))return true;
		if(meta.hasItemFlag(ItemFlag.HIDE_PLACED_ON))return true;
		if(meta.hasItemFlag(ItemFlag.HIDE_POTION_EFFECTS))return true;
		if(meta.hasItemFlag(ItemFlag.HIDE_UNBREAKABLE))return true;
		return false;
	}
	private static List<String> getItemFlags(ItemMeta meta) {
		List<String> itemflags = new ArrayList<String>();
		if(meta.hasItemFlag(ItemFlag.HIDE_ATTRIBUTES))itemflags.add(ItemFlag.HIDE_ATTRIBUTES.toString());
		if(meta.hasItemFlag(ItemFlag.HIDE_DESTROYS))itemflags.add(ItemFlag.HIDE_DESTROYS.toString());
		if(meta.hasItemFlag(ItemFlag.HIDE_DYE))itemflags.add(ItemFlag.HIDE_DYE.toString());
		if(meta.hasItemFlag(ItemFlag.HIDE_ENCHANTS))itemflags.add(ItemFlag.HIDE_ENCHANTS.toString());
		if(meta.hasItemFlag(ItemFlag.HIDE_PLACED_ON))itemflags.add(ItemFlag.HIDE_PLACED_ON.toString());
		if(meta.hasItemFlag(ItemFlag.HIDE_POTION_EFFECTS))itemflags.add(ItemFlag.HIDE_POTION_EFFECTS.toString());
		if(meta.hasItemFlag(ItemFlag.HIDE_UNBREAKABLE))itemflags.add(ItemFlag.HIDE_UNBREAKABLE.toString());
		return itemflags;
	}
	private static boolean getStringBool(String str) {
		if(str.equalsIgnoreCase("1")||str.equalsIgnoreCase("t")||str.equalsIgnoreCase("true")||str.equalsIgnoreCase("Y")) {
			return true;
		}
		return false;
	}
	
}

package com.satsukirin.letscook;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;


public class LCRecipes {
	
	private LetsCook plugin;

	
	public LCRecipes(LetsCook lc) {
		this.plugin=lc;
		
		
		
		//½Á°è»ú
		ShapedRecipe mixerRecipe = new ShapedRecipe(new NamespacedKey(plugin, "mixerRecipe"), LCItems.Tools.mixer());
		mixerRecipe.shape(" A ","BCB"," B ");
		mixerRecipe.setIngredient('A', Material.PISTON);
		mixerRecipe.setIngredient('B', Material.IRON_INGOT);
		mixerRecipe.setIngredient('C', Material.FLINT);
		plugin.getServer().addRecipe(mixerRecipe);
		
		//ÂóÁ£
		ShapelessRecipe wheatGrainRecipe = new ShapelessRecipe(new NamespacedKey(plugin, "wheatGrainRecipe"), LCItems.Mat.wheatGrain(2));
		wheatGrainRecipe.addIngredient(Material.FLOWER_POT);
		wheatGrainRecipe.addIngredient(Material.WHEAT);
		plugin.getServer().addRecipe(wheatGrainRecipe);
		
		//
		
		
		
		
	}
	
	public static Map<ItemStack, ItemStack> getMixerRecipes() {
		Map<ItemStack, ItemStack> map = new HashMap<ItemStack, ItemStack>();
		map.put(new ItemStack(Material.WHEAT), LCItems.Mat.wheatGrain(2));
		return map;
	}
	
	
}

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
		
		
		
		
		
		
	}
	
	
	public static Map<ItemStack, ItemStack> getMixerRecipes() {
		Map<ItemStack, ItemStack> map = new HashMap<ItemStack, ItemStack>();
		map.put(new ItemStack(Material.WHEAT), LCItems.Mat.wheatGrain(2));
		return map;
	}
	
	public static class TRT{
		public String type;
		public ItemStack resource;
		public ItemStack target;
		public TRT(String t,ItemStack r,ItemStack tar) {
			this.type = t;
			this.resource = r.clone();
			this.target = tar.clone();
		}
		@Override
		public int hashCode() {
		    StringBuilder sb = new StringBuilder();
		    sb.append(type);
		    sb.append(resource.hashCode());
		    sb.append(target.hashCode());
		    char[] charArr = sb.toString().toCharArray();
		    int hash = 0;
		    
		    for(char c : charArr) {
		        hash = hash * 131 + c;
		    }
		    return hash;
		}
		@Override
		public boolean equals(Object obj) {
		    if (this == obj) {
		        return true;
		    }

		    if (obj instanceof TRT) {
		        if (((TRT) obj).type.equals(this.type) 
		                && ((TRT) obj).resource.equals(this.resource)
		                &&((TRT) obj).target.equals(this.target)) {
		            return true;
		        }
		    }

		    return false;
		}
	}
	public static Map<TRT, ItemStack> getBrewRecipes(){
		Map<TRT, ItemStack> map = new HashMap<TRT, ItemStack>();
		map.put(new TRT("water", LCItems.Mat.wheatGrain(),LCItems.DefaultItems.waterBottle()), LCItems.Drinks.unfermentedBeer());
		map.put(new TRT("water", LCItems.Plants.hop(), LCItems.Drinks.unfermentedBeer()), LCItems.Drinks.beer());
		return map;
	}
	
	
}

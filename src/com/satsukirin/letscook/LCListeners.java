package com.satsukirin.letscook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

import com.satsukirin.letscook.utils.LCInventoryHolder;


public class LCListeners implements Listener {
	
	private LetsCook plugin;
	private List<Integer> mixerIgnoreSlots = new ArrayList<Integer>()  ;
	private Map<ItemStack, ItemStack> mixerRecipes = LCRecipes.getMixerRecipes();
	private LCRecipeLoader recipeLoader;
	public LCListeners(LetsCook lc) {
		this.plugin=lc;

		try {
			recipeLoader = new LCRecipeLoader(plugin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mixerIgnoreSlots.add(19);
		mixerIgnoreSlots.add(20);
		mixerIgnoreSlots.add(21);
		mixerIgnoreSlots.add(22);
		mixerIgnoreSlots.add(23);
		mixerIgnoreSlots.add(40);
		mixerIgnoreSlots.add(41);
		mixerIgnoreSlots.add(42);
		mixerIgnoreSlots.add(43);
		mixerIgnoreSlots.add(44);
		mixerIgnoreSlots.add(49);
		mixerIgnoreSlots.add(50);
		mixerIgnoreSlots.add(51);
		mixerIgnoreSlots.add(52);
		mixerIgnoreSlots.add(53);
		
		
		
	}
	
	
	@EventHandler
	public void prepareCraftEvent(PrepareItemCraftEvent e) {
		if(e.getRecipe()==null)return;
		if(e.getRecipe().getResult()==null)return;
		if(e.getRecipe().getResult().getType().equals(Material.AIR))return;
		if(!LCItems.hasLCSign(e.getRecipe().getResult())) {
			return;
		}
		ItemStack result = e.getRecipe().getResult();
		CraftingInventory cinv = e.getInventory();
		//麦粒合成检测
		if (result.getItemMeta().getPersistentDataContainer().get(LetsCook.getItemKey(), PersistentDataType.STRING).equalsIgnoreCase("wheatgrain")){
			if(!e.getInventory().contains(LCItems.Tools.mixer())) {
				cinv.setResult(null);
			}
			
			
		}
	
		
		
		
	}
	
	@EventHandler
	public void afterCraftEvent(CraftItemEvent e) {
		
		if(!LCItems.hasLCSign(e.getRecipe().getResult())) {
			return;
		}
		
		ItemStack result = e.getRecipe().getResult();
		CraftingInventory cinv = e.getInventory();
		ItemStack resultItem = cinv.getResult();
		
		//麦粒合成事件
		if(result.getItemMeta().getPersistentDataContainer().get(LetsCook.getItemKey(), PersistentDataType.STRING).equalsIgnoreCase("wheatgrain")) {
			
			ItemStack items[] = cinv.getMatrix();
			for(int i=0;i<items.length;i++) {
				if(items[i]==null)continue;
				if(items[i].getType().equals(Material.AIR))continue;
				if(items[i].getItemMeta().getPersistentDataContainer().get(LetsCook.getItemKey(), PersistentDataType.STRING).equalsIgnoreCase("mixer")){
					e.getWhoClicked().getInventory().addItem(LCItems.Tools.mixer());
					return;
				}
			}
			
			
		}
		
		
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		
		if(!e.canBuild())return;
		if(e.getItemInHand()==null)return;
		if(e.getItemInHand().getType().equals(Material.AIR))return;
		if(!LCItems.hasLCSign(e.getItemInHand()))return;
		
		Block block = e.getBlockPlaced();
		ItemStack item = e.getItemInHand();
		
		if(item.getItemMeta().getPersistentDataContainer().get(LetsCook.getItemKey(), PersistentDataType.STRING).equalsIgnoreCase("mixerblock")) {
			
			Dispenser dispenser = (Dispenser)block.getState();
			dispenser.getPersistentDataContainer().set(LetsCook.getBlockKey(), PersistentDataType.STRING, "mixerBlock");
			dispenser.update();
			return;
			
		}
		
		
		
		
		
		
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(e.getClickedBlock().getType().equals(Material.DISPENSER)) {
				Dispenser dispenser = (Dispenser)e.getClickedBlock().getState();
				if(dispenser.getPersistentDataContainer().has(LetsCook.getBlockKey(), PersistentDataType.STRING)) {
					if(dispenser.getPersistentDataContainer().get(LetsCook.getBlockKey(), PersistentDataType.STRING).equalsIgnoreCase("mixerblock")) {
						e.setCancelled(true);
						e.getPlayer().openInventory(LCMenu.mixerMenu());
						return;
					}
				}
			}
			if(e.getClickedBlock().getType().equals(Material.BREWING_STAND)) {
				Block brewstand = e.getClickedBlock();
				if(brewstand.getRelative(0, -1, 0).getType().equals(Material.OBSIDIAN)&&
						brewstand.getRelative(-1, -1, -1).getType().equals(Material.OBSIDIAN)&&
						brewstand.getRelative(-1, -1, 1).getType().equals(Material.OBSIDIAN)&&
						brewstand.getRelative(1, -1, -1).getType().equals(Material.OBSIDIAN)&&
						brewstand.getRelative(1, -1, 1).getType().equals(Material.OBSIDIAN)) {
					Material mat = brewstand.getRelative(1,-1,0).getType();
					if(brewstand.getRelative(1, -1, 0).getType().equals(mat)&&
						brewstand.getRelative(-1, -1, 0).getType().equals(mat)&&
						brewstand.getRelative(0, -1, 1).getType().equals(mat)&&
						brewstand.getRelative(0, -1, -1).getType().equals(mat)) {
						Player player = e.getPlayer();
						e.setCancelled(true);
						switch (mat) {
						case NETHERRACK:
							player.openInventory(LCMenu.blazeBrew());
							break;
						case BASALT:
							player.openInventory(LCMenu.lavaBrew());
							break;
						case GRASS_BLOCK:
							player.openInventory(LCMenu.waterBrew());
							break;
						case SNOW_BLOCK:
							player.openInventory(LCMenu.iceBrew());
							break;
						case END_STONE:
							player.openInventory(LCMenu.enderBrew());
							break;
						case WARPED_HYPHAE:
							player.openInventory(LCMenu.soulBrew());
							break;
						default:
							break;
						}
						return;
					}
					
					
				}
				
			}
		}
		
	}
	
	@EventHandler
	public void onPlayerClickInv(InventoryClickEvent e) {
		if(e.getClickedInventory()==null)return;
		Inventory inv = e.getClickedInventory();
		if(inv.getHolder() instanceof LCInventoryHolder) {
			LCInventoryHolder holder = (LCInventoryHolder)inv.getHolder();
			String data = holder.getData();
			if(data.equalsIgnoreCase("mixer")) {
				ItemStack item47 = inv.getItem(47);
				if(LCItems.getLCSign(item47).equalsIgnoreCase("mixeron")) {
					e.setCancelled(true);
					return;
				}
				
				if(mixerIgnoreSlots.contains(e.getSlot())) {
					return;
				}
				e.setCancelled(true);
				if(e.getSlot()==47) {
					ItemStack item = inv.getItem(47);
					if(LCItems.hasLCSign(item)) {
						if(LCItems.getLCSign(item).equalsIgnoreCase("mixerclose")) {
							inv.setItem(47,LCItems.MenuItems.mixerOpening());
							
							new BukkitRunnable() {
								int slot = 0;
								@Override
								public void run() {
									if(slot==5) {
										cancel();
										inv.setItem(47, LCItems.MenuItems.mixerClosing());
										
									}
									ItemStack item = inv.getItem(19+slot);
									if(item!=null) {
										ItemStack clone = item.clone();
										clone.setAmount(1);
										if(mixerRecipes.containsKey(clone)) {
											int rcount=item.getAmount()*mixerRecipes.get(clone).getAmount();
											ItemStack result = mixerRecipes.get(clone).clone();
											if(rcount>64) {
												result.setAmount(64);
												inv.setItem(40+slot, result);
												ItemStack result2 = result.clone();
												result2.setAmount(Integer.min(64, rcount-64));
												inv.setItem(49+slot, result2);
											}else {
												result.setAmount(rcount);
												inv.setItem(40+slot, result);
												
											}
											inv.clear(19+slot);
										}
									}
									slot++;
									
								}
							}.runTaskTimer(plugin, 5, 20);
							
							
							
						}
						
					}
					return;
				}
			}
			
			if(data.equalsIgnoreCase("blazebrew")) {
				e.getWhoClicked().sendMessage("blazeBrew");
			}
			
			
		}else if(e.getClickedInventory().getType().equals(InventoryType.PLAYER)&&(e.getInventory().getHolder() instanceof LCInventoryHolder)&&e.getAction().equals(InventoryAction.MOVE_TO_OTHER_INVENTORY)) {
			e.setCancelled(true);
			return;
		}
		
	}
	
	
}

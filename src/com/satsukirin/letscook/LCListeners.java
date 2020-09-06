package com.satsukirin.letscook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
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
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

import com.satsukirin.letscook.LCRecipes.TRT;
import com.satsukirin.letscook.utils.LCInventoryHolder;



public class LCListeners implements Listener {
	
	private LetsCook plugin;
	private List<Integer> mixerIgnoreSlots = new ArrayList<Integer>();
	private List<Integer> brewIngoreSlots = new ArrayList<Integer>();
	private Map<ItemStack, ItemStack> mixerRecipes = LCRecipes.getMixerRecipes();
	private Map<TRT, ItemStack> brewRecipes = LCRecipes.getBrewRecipes();
//	private LCRecipeLoader recipeLoader;
	public LCListeners(LetsCook lc) {
		this.plugin=lc;

//		try {
//			recipeLoader = new LCRecipeLoader(plugin);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
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

		brewIngoreSlots.add(5);
		brewIngoreSlots.add(23);
		brewIngoreSlots.add(39);
		brewIngoreSlots.add(41);
		brewIngoreSlots.add(43);
		
		
		
		
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

			}
			if(data.equalsIgnoreCase("lavabrew")) {
				
			}
			if(data.equalsIgnoreCase("waterbrew")) {
				if(inv.contains(Material.BARRIER)) {
					e.setCancelled(true);
					return;
				}
				if(e.getSlot()==23) {
					e.setCancelled(true);
					if(inv.getItem(5)==null) {
						return;
					}
					if(inv.getItem(5).getType().equals(Material.AIR)) {
						return;
					}
					if(inv.getItem(41)==null) {
						return;
					}
					if(inv.getItem(41).getType().equals(Material.AIR)) {
						return;
					}

					ItemStack resource = inv.getItem(5).clone();
					resource.setAmount(1);
					TRT trt = new TRT("water", resource, inv.getItem(41));
					if(brewRecipes.containsKey(trt)) {
						inv.setItem(23, LCItems.MenuItems.cantClick());
						ItemStack result = brewRecipes.get(trt);
						new BrewAction(inv, result, trt.target).runTaskTimer(plugin, 1, 10);
					}
					
					
					
				}
				if(!brewIngoreSlots.contains(e.getSlot()))e.setCancelled(true);
			}
			if(data.equalsIgnoreCase("icebrew")) {
				
			}
			if(data.equalsIgnoreCase("enderbrew")) {
				
			}
			if(data.equalsIgnoreCase("soulbrew")) {
				
			}
			
			
		}else if(e.getClickedInventory().getType().equals(InventoryType.PLAYER)&&(e.getInventory().getHolder() instanceof LCInventoryHolder)&&e.getAction().equals(InventoryAction.MOVE_TO_OTHER_INVENTORY)) {
			e.setCancelled(true);
			return;
		}
		
	}
	
	private class BrewAction extends BukkitRunnable{
		private Inventory inv;
		private ItemStack result;
		private int action;
		private ItemStack target;
		public BrewAction(Inventory inventory,ItemStack item,ItemStack tar) {
			this.inv = inventory;
			this.result = item.clone();
			this.target = tar.clone();
			action = 0;
		}
		@Override
		public void run() {
			if(action == 0) {
				ItemStack item = inv.getItem(5);
				if(item.getAmount()==1) {
					inv.clear(5);
				}else {
					item.setAmount(item.getAmount()-1);
					inv.setItem(5,item);
				}
			}
			if(action == 1) {
				inv.setItem(14, LCItems.MenuItems.brewBrewing());
			}
			if(action == 3) {
				inv.setItem(24, LCItems.MenuItems.brewBrewing());
				inv.setItem(22, LCItems.MenuItems.brewBrewing());
			}
			if(action == 4) {
				inv.setItem(21, LCItems.MenuItems.brewBrewing());
				inv.setItem(25, LCItems.MenuItems.brewBrewing());
			}
			if(action == 5) {
				inv.setItem(30, LCItems.MenuItems.brewBrewing());
				inv.setItem(32, LCItems.MenuItems.brewBrewing());
				inv.setItem(34, LCItems.MenuItems.brewBrewing());
			}
			if(action == 6) {
				if(inv.getItem(39)==null) {}
				else if(inv.getItem(39).equals(target)) {
					inv.setItem(39,result);
				}
				if(inv.getItem(41)==null) {}
				else if(inv.getItem(41).equals(target)) {
					inv.setItem(41, result);
				}
				if(inv.getItem(43)==null) {}
				else if(inv.getItem(43).equals(target)) {
					inv.setItem(43,result);
				}

				ItemStack zwf2 = new ItemStack(Material.IRON_BARS);
				ItemMeta zwf2meta = zwf2.getItemMeta();
				zwf2meta.setDisplayName(" ");
				List<String> zwf2lore = new LinkedList<String>();
				zwf2lore.add(ChatColor.DARK_GRAY+""+ChatColor.ITALIC+"Let's Cook!");
				zwf2meta.setLore(zwf2lore);
				zwf2.setItemMeta(zwf2meta);
				inv.setItem(14, zwf2);
				inv.setItem(21, zwf2);
				inv.setItem(22, zwf2);
				inv.setItem(24, zwf2);
				inv.setItem(25, zwf2);
				inv.setItem(30, zwf2);
				inv.setItem(32, zwf2);
				inv.setItem(34, zwf2);
				ItemStack zwf4 = new ItemStack(Material.REDSTONE_TORCH);
				ItemMeta zwf4meta = zwf4.getItemMeta();
				zwf4meta.setDisplayName(ChatColor.RED+"开始酿造!");
				List<String> zwf4lore = new LinkedList<String>();
				zwf4lore.add(ChatColor.DARK_GRAY+""+ChatColor.ITALIC+"Let's Cook!");
				zwf4meta.setLore(zwf4lore);
				zwf4.setItemMeta(zwf4meta);
				inv.setItem(23, zwf4);
				cancel();
			}
			action++;
		}
	}
	
	@EventHandler
	public void blockBreak(BlockBreakEvent e) {
		if(e.getBlock()==null)return;
		if(e.getBlock().getType().equals(Material.GRASS)) {
			if(Math.random()<=0.2d) {
				e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), LCItems.Plants.hop());
			}
		}
	}
	
	
}

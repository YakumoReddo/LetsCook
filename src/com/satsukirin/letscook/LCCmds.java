package com.satsukirin.letscook;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class LCCmds implements CommandExecutor{
	
	private LetsCook plugin;
	private LCItemLoader itemLoader;
	
	public LCCmds(LetsCook lc) {
		this.plugin=lc;
		itemLoader = plugin.getItemLoader();
		return;
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
		
		if(label.equalsIgnoreCase("lc")) {
			String prefix = ChatColor.AQUA+"[Let's Cook!] ";
			if (sender instanceof Player) {
				Player player = (Player)sender;
				if(args.length==1) {

					if(args[0].equalsIgnoreCase("reload")) {
						itemLoader.reload();
						return true;
					}
				}
				if(args.length==2) {
					
					if(args[0].equalsIgnoreCase("read")) {
						player.getInventory().addItem(itemLoader.getItem(args[1]));
						return true;
					}
					if(args[0].equalsIgnoreCase("save")) {
						itemLoader.saveItem(player.getEquipment().getItemInMainHand(), args[1]);
						return true;
					}
					
					if(args[0].equalsIgnoreCase("get")) {
						
						player.getInventory().addItem(LCItems.getItem(args[1]));
						
						
					}
					if(args[0].equalsIgnoreCase("open")) {
						switch (args[1]) {
						case "mixer":
							player.openInventory(LCMenu.mixerMenu());
							break;

						default:
							break;
						}
						return true;
					}
					
					if(args[0].equalsIgnoreCase("debug")) {
						if(args[1].equalsIgnoreCase("islcitem")) {
							ItemStack item = player.getEquipment().getItemInMainHand();
							if(item==null) {
								player.sendMessage(prefix+"你的手上没有物品");
								return true;
							}
							if(item.getType().equals(Material.AIR)) {
								player.sendMessage(prefix+"你的手上没有物品");
								return true;
							}
							if(LCItems.hasLCSign(item)) {
								player.sendMessage(prefix+"该物品是Let's Cook!的物品!");
								return true;
							}else {
								player.sendMessage(prefix+ChatColor.RED+"这不是Let's Cook!的物品!");
								return true;
								
							}
							
							
							
						}
					}
				}
				
			}
			
			
			
			
			
		}
		
		return true;
	}
	
	
	
}

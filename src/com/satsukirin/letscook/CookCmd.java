package com.satsukirin.letscook;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CookCmd implements CommandExecutor{
	private LetsCook plugin;
	
	public CookCmd(LetsCook p) {
		plugin =p;
	}
	

	@Override
	public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
		
		
		
		if(label.equalsIgnoreCase("lc")) {
			
			if(sender instanceof Player) {
				Player player = (Player)sender;
				
				if(args[0].equalsIgnoreCase("get")) {
					
					switch (args[1]) {
					case "washer":
						player.getInventory().addItem(LCItems.Washer());
						
						
						
						break;

					default:
						break;
					}
					
					
					
				}else if(args[0].equalsIgnoreCase("open")) {
					switch (args[1]) {
					case "rw":
						player.openInventory(CookMenu.Ruwei());
						
						break;

					default:
						break;
					}
				}
				
				
				
				
			}
			
			
		}
		
		
		
		return true;
	}
	
	
	

}

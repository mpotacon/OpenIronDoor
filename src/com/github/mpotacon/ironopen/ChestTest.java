package com.github.mpotacon.ironopen;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.java.JavaPlugin;

public class ChestTest extends JavaPlugin implements InventoryHolder{

	private Inventory i;
	
	@Override
	public void onEnable(){
		i = this.getServer().createInventory(this, InventoryType.CHEST);
	}
	
	@Override
	public boolean onCommand(CommandSender cs,Command smd,String commandLabel,String[] args){
		if(commandLabel.equalsIgnoreCase("chest")){
		((Player)cs).openInventory(i);
		return true;
		}
		return false;
	}
	
	@Override
	public Inventory getInventory() {
		return i;
	}
}
package com.github.mpotacon.ironopen;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class irondoorCommands implements CommandExecutor {
	public boolean onCommand(CommandSender sender,Command smd,String commandLabel,String[] args){
		if(commandLabel.equalsIgnoreCase("open")){
			sender.sendMessage("Right Click Irondoor");
			return true;
		}
		return false;
	}
}

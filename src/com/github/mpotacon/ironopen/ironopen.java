package com.github.mpotacon.ironopen;

import org.bukkit.plugin.java.JavaPlugin;

public final class ironopen extends JavaPlugin {

	public void onEnable(){
		getServer().getPluginManager().registerEvents(new irondoorListener(), this);
		getCommand("open").setExecutor(new irondoorCommands());
		getCommand("chest").setExecutor(new ChestTest());
	}
}

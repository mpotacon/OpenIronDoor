package com.github.mpotacon.ironopen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ironopen extends JavaPlugin {
	public static ironopen plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	public final irondoorListener il = new irondoorListener();
	File configFile;
	FileConfiguration config;
	
	@Override
	public void onEnable(){
		configFile = new File(getDataFolder(), "config.yml");
        try {
            firstRun();
        } catch (Exception e) {
            e.printStackTrace();
        }
        config = new YamlConfiguration();
        loadYamls();
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this.il, this);
	
		getCommand("open").setExecutor(new irondoorCommands());
	}
	
	private void firstRun() throws Exception {
		 PluginDescriptionFile pdfFile = this.getDescription();
		 	if(!configFile.exists()){
	        	this.logger.info("[" + pdfFile.getName() + "]" +" Creating config.yml");
	            configFile.getParentFile().mkdirs();         
	            copy(getResource("config.yml"), configFile);
	            this.logger.info("[" + pdfFile.getName() + "]" + " Finished creating config.yml");
	        }
	    }
	private void copy(InputStream in, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while((len=in.read(buf))>0){
                out.write(buf,0,len);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public void loadYamls() {
		PluginDescriptionFile pdfFile = this.getDescription();
	 		try {
	 			config.load(configFile);
	 			this.logger.info("[" + pdfFile.getName() + "]" + " Loaded config.yml");
	 		} catch (Exception e) {
	 			e.printStackTrace();
	 		}
    }
	
	public void saveYamls() {
		try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	@Override
	public void onDisable(){
	
	}
}

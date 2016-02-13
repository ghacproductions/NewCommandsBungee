package de.ghac.NewCommandsBungee.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.ghac.NewCommandsBungee.configlib.Config;

public class MainConfig {

    public static String configpath;
    public static Config config;
    public static List<String> commands;
	
	public MainConfig(){
		reloadConfig();
	}
    
    public static void reloadConfig() {
        config = null;
        config = new Config( configpath );
        
		configpath = File.separator + "plugins" + File.separator + "NewCommandsBungee" + File.separator + "config.yml";
		config = new Config( configpath );
		
		config.setString("commands.examplecommand", "&4Awesome plugin by ghac.");
		commands = config.getSubNodes("commands");
    }
}

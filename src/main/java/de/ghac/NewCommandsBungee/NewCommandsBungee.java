package de.ghac.NewCommandsBungee;

import java.util.List;

import de.ghac.NewCommandsBungee.config.MainConfig;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class NewCommandsBungee extends Plugin{
	
	public static Plugin pl;
	
	@Override
	public void onEnable(){
		MainConfig.reloadConfig();
		pl = this;
		getProxy().getPluginManager().registerCommand(pl, new NewCommand("newcommands"));
		
		registerCommands();

		
	}

	
	public static void registerCommands(){
		List<String> commands = MainConfig.commands;
		
		for(int i = 0; i < commands.size(); i++){
			ProxyServer.getInstance().getPluginManager().registerCommand(NewCommandsBungee.pl, new MyCommand(commands.get(i)));
		}
	}
}

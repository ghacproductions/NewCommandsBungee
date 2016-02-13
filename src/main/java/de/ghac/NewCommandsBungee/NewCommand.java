package de.ghac.NewCommandsBungee;

import de.ghac.NewCommandsBungee.config.MainConfig;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class NewCommand extends Command{

	public NewCommand(String name) {
		super(name);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		
	    if(args.length == 1){
	        if(args[0].equalsIgnoreCase("reload")){
	            if(sender.hasPermission("newcommands.reload")){
			        MainConfig.reloadConfig();
		            NewCommandsBungee.registerCommands();
		            sender.sendMessage(ChatColor.GOLD + "[" + this.getName()+"]" + ChatColor.DARK_GREEN + " Reloaded.");
		            return;
	            }else{
	            	sender.sendMessage(ChatColor.DARK_RED + "You don't have permission");
	                return;
	            }
	        }else if(args[0].equalsIgnoreCase("list")){
	            if(sender.hasPermission("newcommands.list")){
	                sendList(sender);
	                return;
	            }
	        }
	    }
	    sender.sendMessage(ChatColor.GOLD + "[" + this.getName()+"]" + ChatColor.DARK_GREEN + " NewCommands Plugin by ghac. 2014.");
	    return;
	}
	
	@SuppressWarnings("deprecation")
	public void sendList(CommandSender sender){
		sender.sendMessage(ChatColor.GOLD + "[" + this.getName()+"]" +  ChatColor.DARK_GREEN + " List of all NewCommands:");
	    for (String command : MainConfig.commands) {
	    	sender.sendMessage(ChatColor.GOLD + "/" + command + ": " + ChatColor.AQUA+ MainConfig.config.getString("commands."+command, command));
	    }
	}

}

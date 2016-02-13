package de.ghac.NewCommandsBungee;

import java.net.ProxySelector;

import de.ghac.NewCommandsBungee.config.MainConfig;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Command;

public class MyCommand extends Command{
	
public String command = "";
	
public MyCommand(String name) {
	super(name);
	command = name;
}

@SuppressWarnings("deprecation")
@Override
public void execute(CommandSender sender, String[] args) {
	
	
    command = command.split(" ")[0];
    command = command.toLowerCase();
    command = command.replace("/", "");
        if(MainConfig.config.getString("commands." + command, command) != null){ 
           
           if(!sender.hasPermission("*")){
               if(sender.hasPermission("newcommands.command." + command + ".deny")){
            	   sender.sendMessage(ChatColor.DARK_RED + "You don't have permission");
                   return;
               }
           }
           
           String cmdanswer = MainConfig.config.getString("commands." + command, command);
           cmdanswer = cmdanswer.replace("&", "§");
           // cmdanswer = cmdanswer.replace("%MOTD%", ProxyServer.getInstance().getConfig().getMotd()); // Variable for MOTD
           cmdanswer = cmdanswer.replace("%OP%", ProxyServer.getInstance().getPlayers().size()+""); // Variable for OnlinePlayers
           cmdanswer = cmdanswer.replace("%MAXP%", ProxyServer.getInstance().getConfig().getPlayerLimit()+""); // Variable for MaxPlayers
           // cmdanswer = cmdanswer.replace("%IP%", ProxyServer.getInstance().getConfig().getIp()); // Variable for ServerIP
           cmdanswer = cmdanswer.replace("%VER%",  ProxyServer.getInstance().getGameVersion()); // Variable for Version
           cmdanswer = cmdanswer.replace("%SERN%", ProxyServer.getInstance().getName()); // Variable for Servername
           cmdanswer = cmdanswer.replace("%PLAN%", sender.getName()); // Variable for Playername


           String[] answer = cmdanswer.split("%NL%", -1); // Split in lines

           for(int i = 0; i < answer.length; i++){
        	   sender.sendMessage(answer[i]);
           }
           
        }
    return;
}


}

package at.asna.asnabuild.prefix;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import javax.swing.plaf.basic.BasicButtonUI;

public class TeamChat implements Listener {

    @EventHandler
    public void OnChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();

        if (e.getMessage().startsWith("@team") && p.hasPermission("system.teamchat")){
            String msg = e.getMessage().replace("&", "§");
            for (Player team : Bukkit.getOnlinePlayers()){
                if (team.hasPermission("system.teamchat")){
                    e.setCancelled(true);
                    //«»
                    team.sendMessage("§aTEAM§fCHAT §8» §a" + p.getDisplayName() + " §8» §7" + msg.replaceAll("@team", "§7"));
                }
            }
        }
    }

}

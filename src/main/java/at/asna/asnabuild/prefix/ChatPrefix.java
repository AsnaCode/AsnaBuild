package at.asna.asnabuild.prefix;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatPrefix implements Listener {

    @EventHandler
    public void OnChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        String m = e.getMessage().replaceAll("&", "§").replaceAll("%", "%%");

        //«»
        if (p.hasPermission("system.admin")){
            e.setFormat("§4Admin §8• §4" + p.getDisplayName() + " §8» §7" + m);
        } else if (p.hasPermission("system.developer")) {
            e.setFormat("§bDeveloper §8• §b" + p.getDisplayName() + " §8» §7" + m);
        } else if (p.hasPermission("system.moderator")) {
            e.setFormat("§cModerator §8• §c" + p.getDisplayName() + " §8» §7" + m);
        } else if (p.hasPermission("system.builder")) {
            e.setFormat("§2Builder §8• §2" + p.getDisplayName() + " §8» §7" + m);
        } else if (p.hasPermission("system.supporter")) {
            e.setFormat("§9Supporter §8• §9" + p.getDisplayName() + " §8» §7" + m);
        } else if (p.hasPermission("system.creator")) {
            e.setFormat("§5Social §8• §9" + p.getDisplayName() + " §8» §7" + m);
        }else if (p.hasPermission("system.asna")) {
            e.setFormat("§fAsna §8• §f" + p.getDisplayName() + " §8» §7" + m);
        } else if (p.hasPermission("system.premium")) {
            e.setFormat("§6Premium §8• §6" + p.getDisplayName() + " §8» §7" + m);
        } else {
            e.setFormat("§e" + p.getDisplayName() + " §8» §7" + m);
        }
    }

}

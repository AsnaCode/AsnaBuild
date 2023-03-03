package at.asna.asnabuild.listener;

import at.asna.asnabuild.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class MuteChatListener implements Listener {

    @EventHandler
    public void OnChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();

        if (Main.getInstance().getConfig().getBoolean("MuteChat") == true){
            if (p.hasPermission("system.mutechat.bypass")){
                e.setCancelled(false);
            } else {
                e.setCancelled(true);
            }
        }
    }

}

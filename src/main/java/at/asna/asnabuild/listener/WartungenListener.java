package at.asna.asnabuild.listener;

import at.asna.asnabuild.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.server.ServerListPingEvent;

public class WartungenListener implements Listener {

    @EventHandler
    public void OnLogin(PlayerLoginEvent e) {
        Player p = e.getPlayer();
        if (Main.getInstance().getConfig().getBoolean("Wartungen") == true &&
                !p.hasPermission("system.wartungen.bypass")){
            e.disallow(null, "§cWARTUNGEN"
                    + "\n§7Wir sind in §eWartungen§7!"
                    + "\n§7Discord: §ehttps://discord.gg/XakZ4nUkpQ");
        }
    }

    @EventHandler
    public void OnMotd(ServerListPingEvent e) {
        if (Main.getInstance().getConfig().getBoolean("Wartungen") == true) {
            e.setMotd("§6AsnaCode§7.§6de §8» §71.19 §8- §71.19.3 \n§cWartungen");
        } else {
            e.setMotd("§6AsnaCode§7.§6de §8» §71.19 §8- §71.19.3 \n§aRelease -> HEUTE");
        }
    }
}




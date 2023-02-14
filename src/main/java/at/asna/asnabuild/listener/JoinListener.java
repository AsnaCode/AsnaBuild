package at.asna.asnabuild.listener;

import at.asna.asnabuild.Main;
import at.asna.asnabuild.manager.LocationManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        //Message
        p.sendMessage("§8»§7----------§8[§eWillkommen§8]§7----------§8«");
        p.sendMessage("§7Willkommen auf §6AsnaCode§7.§6de§7!");
        p.sendMessage("§7Viel Spaß!");
        p.sendMessage("§8»§7----------§8[§eWillkommen§8]§7----------§8«");


        //JoinMessage + Teleport
        if (p.hasPlayedBefore()){
            e.setJoinMessage("§8[§e+§8] §e" + p.getDisplayName());
            p.teleport(LocationManager.getLocation("Spawn"));
        } else {
            e.setJoinMessage("§8[§e+§8] §e" + p.getDisplayName());
            new BukkitRunnable() {
                @Override
                public void run() {
                    p.teleport(LocationManager.getLocation("Spawn"));
                }
            }.runTaskLater(Main.getInstance(), 3L);
        }

    }

}

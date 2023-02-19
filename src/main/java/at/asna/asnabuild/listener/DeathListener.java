package at.asna.asnabuild.listener;

import at.asna.asnabuild.manager.LocationManager;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class DeathListener implements Listener {


    @EventHandler
    public void onDeath(PlayerDeathEvent e){

        Player p = e.getPlayer();

        e.setDeathMessage(null);
    }

    @EventHandler
    public void OnRespawn(PlayerRespawnEvent e){
        Player p = e.getPlayer();
        e.setRespawnLocation(LocationManager.getLocation("Spawn"));
    }

}

package at.asna.asnabuild.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class INteractListener implements Listener {

    @EventHandler
    public void onINteract(InventoryClickEvent e){
        if (e.getView().getTitle() == "§8» §6Warps §8«"){
            e.setCancelled(true);
        }
    }

}

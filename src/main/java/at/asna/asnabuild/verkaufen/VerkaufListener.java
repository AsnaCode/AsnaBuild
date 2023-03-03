package at.asna.asnabuild.verkaufen;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class VerkaufListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getClickedInventory() == null) return;
        if (event.getClickedInventory().getHolder() instanceof ItemsV) {
            event.setCancelled(true);
            ((ItemsV) event.getClickedInventory().getHolder()).onClick(event.getCurrentItem(), event.getSlot());
        } else if (event.getClickedInventory().getHolder() instanceof RüstungV) {
            event.setCancelled(true);
            ((RüstungV) event.getClickedInventory().getHolder()).onClick(event.getCurrentItem(), event.getSlot());
        }else if (event.getClickedInventory().getHolder() instanceof EssenV) {
            event.setCancelled(true);
            ((EssenV) event.getClickedInventory().getHolder()).onClick(event.getCurrentItem(), event.getSlot());
        }else if (event.getClickedInventory().getHolder() instanceof BlöckeV) {
            event.setCancelled(true);
            ((BlöckeV) event.getClickedInventory().getHolder()).onClick(event.getCurrentItem(), event.getSlot());
        }

    }

}

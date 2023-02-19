package at.asna.asnabuild.shop;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ShopListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getClickedInventory() == null) return;
        if (event.getClickedInventory().getHolder() instanceof Blöcke) {
            event.setCancelled(true);
            ((Blöcke) event.getClickedInventory().getHolder()).onClick(event.getCurrentItem(), event.getSlot());
        } else if (event.getClickedInventory().getHolder() instanceof Rüstung) {
            event.setCancelled(true);
            ((Rüstung) event.getClickedInventory().getHolder()).onClick(event.getCurrentItem(), event.getSlot());
        }else if (event.getClickedInventory().getHolder() instanceof Essen) {
            event.setCancelled(true);
            ((Essen) event.getClickedInventory().getHolder()).onClick(event.getCurrentItem(), event.getSlot());
        }else if (event.getClickedInventory().getHolder() instanceof Ränge) {
            event.setCancelled(true);
            ((Ränge) event.getClickedInventory().getHolder()).onClick(event.getCurrentItem(), event.getSlot());
        }

    }

}




package at.asna.asnabuild.warps;

import at.asna.asnabuild.manager.LocationManager;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class WarpGuiInteract implements Listener {

    @EventHandler
    public void OnClick01(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();

        try {
            if (e.getView().getTitle() == "§8| §aWarps §7✗ §aTeleport §8|")
                try {
                    if (e.getCurrentItem().getType() == Material.GRASS_BLOCK  &&
                            e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aFarmwelt")) {
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 2.0F, 1.0F);
                        p.teleport(LocationManager.getLocation("Farmwelt"));
                        p.sendTitle("§a§lFARMWELT", "");
                        p.closeInventory();
                    }
                } catch (Exception exception) {}
        } catch (Exception exception) {}
    }

    @EventHandler
    public void OnClick02(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();

        try {
            if (e.getView().getTitle() == "§8| §aWarps §7✗ §aTeleport §8|"){
                try {
                    if (e.getCurrentItem().getType() == Material.END_STONE  &&
                            e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §eEnd")){
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 2F, 1F);
                        p.teleport(LocationManager.getLocation("End"));
                        p.sendTitle("§e§lEND", "");
                        p.closeInventory();
                    }
                } catch (Exception e1){

                }
            }
        }catch (Exception e2){

        }

    }

    @EventHandler
    public void OnClick03(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();

        try {
            if (e.getView().getTitle() == "§8| §aWarps §7✗ §aTeleport §8|"){
                try {
                    if (e.getCurrentItem().getType() == Material.NETHERRACK  &&
                            e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cNether")){
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 2F, 1F);
                        p.teleport(LocationManager.getLocation("Nether"));
                        p.sendTitle("§c§lNETHER", "");
                        p.closeInventory();
                    }
                } catch (Exception e1){

                }
            }
        }catch (Exception e2){

        }

    }

}

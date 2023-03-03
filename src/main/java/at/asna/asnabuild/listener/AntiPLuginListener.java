package at.asna.asnabuild.listener;

import at.asna.asnabuild.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class AntiPLuginListener implements Listener {

    @EventHandler
    public void OnPlugin(PlayerCommandPreprocessEvent e){
        Player p = e.getPlayer();
        String m = e.getMessage();

        if (m.equalsIgnoreCase("/pl")){
            p.sendMessage(Main.prefix + "§7All unsere System sind selbst gecoded außer FAWE, PlotSquared, ZNPCS, MV, LuckPerms und WorldGuard!");
            e.setCancelled(true);
            if (p.hasPermission("system.plugins")){
                e.setCancelled(false);
            }
        }

        if (m.equalsIgnoreCase("/bukkit:pl")){
            p.sendMessage(Main.prefix + "§7All unsere System sind selbst gecoded außer FAWE, PlotSquared, ZNPCS, MV, LuckPerms und WorldGuard!");
            e.setCancelled(true);
            if (p.hasPermission("system.plugins")){
                e.setCancelled(false);
            }
        }

        if (m.equalsIgnoreCase("/bukkit:plugins")){
            p.sendMessage(Main.prefix + "§7All unsere System sind selbst gecoded außer FAWE, PlotSquared, ZNPCS, MV, LuckPerms und WorldGuard!");
            e.setCancelled(true);
            if (p.hasPermission("system.plugins")){
                e.setCancelled(false);
            }
        }
        if (m.equalsIgnoreCase("/plugins")){
            p.sendMessage(Main.prefix + "§7All unsere System sind selbst gecoded außer FAWE, PlotSquared, ZNPCS, MV, LuckPerms und WorldGuard!");
            e.setCancelled(true);
            if (p.hasPermission("system.plugins")){
                e.setCancelled(false);
            }
        }

        if (m.equalsIgnoreCase("/help")){
            p.sendMessage("§7§m----------§8[§aHilfe§8]§7§m----------");
            p.sendMessage("§7 ");
            p.sendMessage("§a/plot auto §8» §aGeneriert dir ein Zufälliges Plot!");
            p.sendMessage("§a/plot claim §8» §aHole dir ein Plot wo du drauf stehst!");
            p.sendMessage("§a/plot trust §8» §aFüge einen Spieler zu deinem Plot hinzu!");
            p.sendMessage("§a/plot remove §8» §aEntferne einen Spieler von deinem Plot!");
            p.sendMessage("§a/plot delete §8» §aLösche dein Plot!");
            p.sendMessage("§a ");
            p.sendMessage("§7§m----------§8[§aHilfe§8]§7§m----------");
            e.setCancelled(true);
            if (p.hasPermission("system.plugins")){
                e.setCancelled(false);
            }
        }

        if (m.equalsIgnoreCase("bukkit:help")) {
            p.sendMessage("§7§m----------§8[§aHilfe§8]§7§m----------");
            p.sendMessage("§7 ");
            p.sendMessage("§a/plot auto §8» §aGeneriert dir ein Zufälliges Plot!");
            p.sendMessage("§a/plot claim §8» §aHole dir ein Plot wo du drauf stehst!");
            p.sendMessage("§a/plot trust §8» §aFüge einen Spieler zu deinem Plot hinzu!");
            p.sendMessage("§a/plot remove §8» §aEntferne einen Spieler von deinem Plot!");
            p.sendMessage("§a/plot delete §8» §aLösche dein Plot!");
            p.sendMessage("§a ");
            p.sendMessage("§7§m----------§8[§aHilfe§8]§7§m----------");
            e.setCancelled(true);
            if (p.hasPermission("system.plugins")){
                e.setCancelled(false);
            }
        }

        if (m.equalsIgnoreCase("bukkit:?")) {
            p.sendMessage("§7§m----------§8[§aHilfe§8]§7§m----------");
            p.sendMessage("§7 ");
            p.sendMessage("§a/plot auto §8» §aGeneriert dir ein Zufälliges Plot!");
            p.sendMessage("§a/plot claim §8» §aHole dir ein Plot wo du drauf stehst!");
            p.sendMessage("§a/plot trust §8» §aFüge einen Spieler zu deinem Plot hinzu!");
            p.sendMessage("§a/plot remove §8» §aEntferne einen Spieler von deinem Plot!");
            p.sendMessage("§a/plot delete §8» §aLösche dein Plot!");
            p.sendMessage("§a ");
            p.sendMessage("§7§m----------§8[§aHilfe§8]§7§m----------");
            e.setCancelled(true);
            if (p.hasPermission("system.plugins")){
                e.setCancelled(false);
            }
        }

        if (m.equalsIgnoreCase("?")) {
            p.sendMessage("§7§m----------§8[§aHilfe§8]§7§m----------");
            p.sendMessage("§7 ");
            p.sendMessage("§a/plot auto §8» §aGeneriert dir ein Zufälliges Plot!");
            p.sendMessage("§a/plot claim §8» §aHole dir ein Plot wo du drauf stehst!");
            p.sendMessage("§a/plot trust §8» §aFüge einen Spieler zu deinem Plot hinzu!");
            p.sendMessage("§a/plot remove §8» §aEntferne einen Spieler von deinem Plot!");
            p.sendMessage("§a/plot delete §8» §aLösche dein Plot!");
            p.sendMessage("§a ");
            p.sendMessage("§7§m----------§8[§aHilfe§8]§7§m----------");
            e.setCancelled(true);
            if (p.hasPermission("system.plugins")){
                e.setCancelled(false);
            }
        }

    }

}

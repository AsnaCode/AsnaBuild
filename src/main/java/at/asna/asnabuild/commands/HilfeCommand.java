package at.asna.asnabuild.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HilfeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;
        //«»
        p.sendMessage("§7§m----------§8[§aHilfe§8]§7§m----------");
        p.sendMessage("§7 ");
        p.sendMessage("§a/plot auto §8» §aGeneriert dir ein Zufälliges Plot!");
        p.sendMessage("§a/plot claim §8» §aHole dir ein Plot wo du drauf stehst!");
        p.sendMessage("§a/plot trust §8» §aFüge einen Spieler zu deinem Plot hinzu!");
        p.sendMessage("§a/plot remove §8» §aEntferne einen Spieler von deinem Plot!");
        p.sendMessage("§a/plot delete §8» §aLösche dein Plot!");
        p.sendMessage("§a ");
        p.sendMessage("§7§m----------§8[§aHilfe§8]§7§m----------");
        
        return false;
    }
}

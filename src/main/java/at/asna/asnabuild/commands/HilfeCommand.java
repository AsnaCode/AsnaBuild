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
        p.sendMessage("§7§m----------§8[§eHilfe§8]§7§m----------");
        p.sendMessage("§7 ");
        p.sendMessage("§e/plot auto §8» §eGeneriert dir ein Zufälliges Plot!");
        p.sendMessage("§e/plot claim §8» §eHole dir ein Plot wo du drauf stehst!");
        p.sendMessage("§e/plot trust §8» §eFüge einen Spieler zu deinem Plot hinzu!");
        p.sendMessage("§e/plot remove §8» §eEntferne einen Spieler von deinem Plot!");
        p.sendMessage("§e/plot delete §8» §eLösche dein Plot!");
        p.sendMessage("§e ");
        p.sendMessage("§7§m----------§8[§eHilfe§8]§7§m----------");
        
        return false;
    }
}

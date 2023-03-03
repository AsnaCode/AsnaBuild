package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.jetbrains.annotations.NotNull;

public class EntchantCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("system.entchant")){
            p.openInventory(Bukkit.getServer().createInventory(null, InventoryType.ENCHANTING));
            p.sendMessage(Main.prefix + "§7Du hast den §aVerzauberungstisch §7geöffnet!");
        } else {
            p.sendMessage(Main.noperm);
        }

        return false;
    }
}

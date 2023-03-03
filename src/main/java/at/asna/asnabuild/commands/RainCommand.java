package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;
        if (p.hasPermission("system.wetter")){
            p.getWorld().setStorm(true);
            p.sendMessage(Main.prefix + "§7Es ist nun der §aRegen §7erschienen!");
        } else {
            p.sendMessage(Main.noperm);
        }

        return false;
    }
}

package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class IpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("system.ip")){
            if (args.length == 0){
                p.sendMessage(Main.prefix + "§7Deine IP-Adresse lautet: §a" + p.getAddress());
            } else if (args.length == 1) {
                Player opfer = Bukkit.getPlayer(args[0]);
                p.sendMessage(Main.prefix + "§7Die IP-Adresse des Spielers §a" + opfer.getDisplayName() + " §7lautet §a" + opfer.getAddress());

            } else {
                p.sendMessage(Main.prefix + "§7Verwendung: §a/Ip <name>");
            }
        }

        return false;
    }
}

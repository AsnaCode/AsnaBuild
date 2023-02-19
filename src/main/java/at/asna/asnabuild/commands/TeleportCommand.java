package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TeleportCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;

        if (!(p instanceof Player)) {
            p.sendMessage(Main.console);
        } else {
            if (p.hasPermission("system.teleport")) {
                if (args.length == 1) {
                    Player opfer = Bukkit.getPlayer(args[0]);
                    if (opfer != null) {
                        p.teleport(opfer.getLocation());
                        p.sendMessage(Main.prefix + "§7Du hast dich zu dem Spieler §e" + opfer.getDisplayName() + " §7teleportiert!");
                    } else {
                        p.sendMessage(Main.notonline);
                    }
                } else if (args.length == 3) {
                    double x = Double.parseDouble(args[0]);
                    double y = Double.parseDouble(args[1]);
                    double z = Double.parseDouble(args[2]);
                    if (x < 3.0E7D || y < 3.0E7D || z < 3.0E7D || x > -3.0E7D || y > -3.0E7D || z > -3.0E7D) {
                        Location location = new Location(p.getWorld(), x, y, z);
                        p.teleport(location);
                        p.sendMessage(Main.prefix + "§7Du wurdest zu §e" + location.toString() + " §7teleportiert!");
                    } else {
                        p.sendMessage(Main.prefix + "§cFalsche Daten!");
                    }
                } else {
                    p.sendMessage(Main.prefix + "§7Verwendung: §e/tp <name>");
                }
            }
        }
        return false;
    }
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 1) {
            List<String> online = new ArrayList<>();
            for (Player all : Bukkit.getOnlinePlayers())
                online.add(all.getName());
            return online;
        }
        return null;
    }
}


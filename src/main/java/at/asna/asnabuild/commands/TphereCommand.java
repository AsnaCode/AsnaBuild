package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TphereCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;
        if (!(p instanceof Player)){
            p.sendMessage(Main.console);
        } else {
            if (p.hasPermission("system.tphere")){
                if (args.length == 1){
                    Player opfer = Bukkit.getPlayer(args[0]);
                    if (opfer != null){
                        opfer.teleport(p.getLocation());
                        p.sendMessage(Main.prefix + "§7Du hast den Spieler §e" + opfer.getDisplayName() + " §7zu dir teleportiert!");
                    } else {
                        p.sendMessage(Main.notonline);
                    }
                } else {
                    p.sendMessage(Main.prefix + "§7Verwendung: §e/tphere <name>");
                }

            } else {
                p.sendMessage(Main.noperm);
            }
        }

        return false;
    }
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 1) {
            List<String> p = new ArrayList<>();
            for (Player all : Bukkit.getOnlinePlayers())
                p.add(all.getName());
            return p;
        }
        return null;
    }
}

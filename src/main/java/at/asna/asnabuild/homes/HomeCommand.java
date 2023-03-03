package at.asna.asnabuild.homes;

import at.asna.asnabuild.Main;
import at.asna.asnabuild.api.HomesAPI;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HomeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;


        if (p.hasPermission("system.home")){
            if (args.length == 0){
                p.sendMessage(Main.prefix + "§7Verwendung: §a/Home <name>");
            } else if (args.length == 1) {
                if (HomesAPI.ifHomeExist(p, args[0])){
                    p.sendMessage(Main.prefix + "§7Du bist nun an deinem Home §a" + args[0] + "§7!");
                    Location loc = HomesAPI.getHome(p, args[0]);
                    p.teleport(loc);
                } else {
                    p.sendMessage(Main.prefix + "§7Das Home §a" + args[0] + " §7existiert nicht!");
                }
            } else {
                p.sendMessage(Main.prefix + "§7Verwendung: §a/Home <name>");
            }

        } else {
            p.sendMessage(Main.noperm);
        }

        return false;
    }
}

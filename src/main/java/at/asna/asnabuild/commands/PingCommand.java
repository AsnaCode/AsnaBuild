package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("system.ping")){
            if (args.length == 0){
                p.sendMessage(Main.prefix + "§7Dein Ping beträgt §a" + p.getPing() + " §ams");
            } else if (args.length == 1) {
                if (p.hasPermission("system.ping.other")){
                    Player opfer = Bukkit.getPlayer(args[0]);
                    p.sendMessage(Main.prefix + "§7Der Ping von §a" + opfer.getDisplayName() + " §7beträgt §a" + opfer.getPing() + " §ams");

                } else {
                    p.sendMessage(Main.noperm);
                }
                } else {
                p.sendMessage(Main.prefix + "§7Verwendung: §a/Ping <name>");
            }
        } else {
            p.sendMessage(Main.noperm);
        }

        return false;
    }
}

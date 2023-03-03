package at.asna.asnabuild.moderation;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class KickCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("system.kick")){
            if (args.length == 0){
                p.sendMessage(Main.prefix + "§7Verwendung: §a/Kick <name> <reason>");
            } else if (args.length == 1) {
                p.sendMessage(Main.prefix + "§7Verwendung: §a/Kick <name> <reason>");
            } else if (args.length >= 2) {
                Player opfer = Bukkit.getPlayer(args[0]);
                if (opfer.hasPermission("system.kick.bypass")){
                    p.sendMessage(Main.prefix + "§7Du kannst keine §aTeamler §7kicken!");
                } else {
                    String msg = "";
                    for (int i = 1; i < args.length; i++)
                        msg = msg + args[i] + " ";
                    //«»
                    opfer.kickPlayer(msg + " §8» §7Von §a" + p.getDisplayName());
                    p.sendMessage(Main.prefix + "§7Du hast den Spieler §a" + opfer.getDisplayName() + " §7erfolgreich gekickt!");
                }


            } else {
                p.sendMessage(Main.prefix + "§7Verwendung: §a/Kick <name> <reason>");
            }
        }

        return false;
    }
}

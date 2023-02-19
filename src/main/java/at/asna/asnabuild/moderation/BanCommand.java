package at.asna.asnabuild.moderation;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

public class BanCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("system.ban")){
            if (args.length == 0){
                p.sendMessage(Main.prefix + "§7Verwendung: §e/Ban <name> <grund>");
            } else if (args.length == 1) {
                p.sendMessage(Main.prefix + "§7Verwendung: §e/Ban <name> <grund>");
            } else if (args.length == 2) {
                Player opfer = Bukkit.getPlayer(args[0]);
                if (opfer.hasPermission("system.ban.bypass")){
                    p.sendMessage(Main.prefix + "§7Du kannst keine §eTeamler §7bannen!");
                } else {
                    String msg = "";
                    for (int i = 1; i < args.length; i++)
                        msg = msg + args[i] + " ";

                    opfer.banPlayer(msg + " §8» §7Von §e" + p.getDisplayName());
                    p.sendMessage(Main.prefix + "§7Du hast den Spieler §e" + opfer.getDisplayName() + " §7erfolgreich gebannt!");
                }
            }
        }

        return false;
    }
}

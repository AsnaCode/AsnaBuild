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
                p.sendMessage(Main.prefix + "§7Verwendung: §a/Ban <name> <grund>");
            } else if (args.length == 1) {
                p.sendMessage(Main.prefix + "§7Verwendung: §a/Ban <name> <grund>");
            } else if (args.length == 2) {
                Player opfer = Bukkit.getPlayer(args[0]);
                if (opfer.hasPermission("system.ban.bypass")){
                    p.sendMessage(Main.prefix + "§7Du kannst keine §aTeamler §7bannen!");
                } else {
                    String msg = "";
                    for (int i = 1; i < args.length; i++)
                        msg = msg + args[i] + " ";

                    opfer.banPlayer(msg + " §8» §7Von §a" + p.getDisplayName());
                    for (Player teamler : Bukkit.getOnlinePlayers())
                        if (teamler.hasPermission("system.team")){
                            teamler.sendMessage("§7§m----------§8[§aBAN§8]§7§m----------");
                            teamler.sendMessage("§7Spieler: §a" + opfer.getDisplayName());
                            teamler.sendMessage("§7Von: §a" + p.getDisplayName());
                            teamler.sendMessage("§7Grund: §a" + msg);
                            teamler.sendMessage("§7Dauer: §aPerma");
                            teamler.sendMessage("§7§m----------§8[§aBAN§8]§7§m----------");
                        }


                }
            }
        }

        return false;
    }
}

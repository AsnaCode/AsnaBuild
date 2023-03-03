package at.asna.asnabuild.homes;

import at.asna.asnabuild.Main;
import at.asna.asnabuild.api.HomesAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetHomeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("system.sethomes")){
            if (args.length == 0){
                p.sendMessage(Main.prefix + "§7Verwendung: §a/SetHome <name>");
            } else if (args.length == 1) {
                if (!HomesAPI.ifHomeExist(p, args[0])){
                    HomesAPI.newHome(p, args[0]);
                    p.sendMessage(Main.prefix + "§7Du hast erfolgreich das Home §a" + args[0] + " §7gesetzt!");
                } else {
                    p.sendMessage(Main.prefix + "§7Der Home §a" + args[0] + " §7existiert bereits!");
                }
            } else {
                p.sendMessage(Main.prefix + "§7Verwendung: §a/SetHome <name>");
            }

        } else {
            p.sendMessage(Main.noperm);
        }


        return false;
    }
}

package at.asna.asnabuild.homes;

import at.asna.asnabuild.Main;
import at.asna.asnabuild.api.HomesAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DelHomeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("system.delhome")){
            if (args.length == 0){
                p.sendMessage(Main.prefix + "§7Verwendung: §e/DelHome <name>");
            } else if (args.length == 1) {
                if (HomesAPI.ifHomeExist(p, args[0])){
                    HomesAPI.removeHome(p, args[0]);
                    p.sendMessage(Main.prefix + "§7Du hast erfolgreich dein Home §e" + args[0] + " §7gelöscht!");
                } else {
                    p.sendMessage(Main.prefix + "§7Der Home §e" + args[0] + " §7existiert nicht!");
                }
            } else {
                p.sendMessage(Main.prefix + "§7Verwendung: §e/DelHome <name>");
            }
        } else {
            p.sendMessage(Main.noperm);
        }


        return false;
    }
}

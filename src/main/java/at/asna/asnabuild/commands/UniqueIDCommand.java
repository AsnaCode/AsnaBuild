package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class UniqueIDCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;
        if (p.hasPermission("system.uuid")){
            if (args.length == 0){
                p.sendMessage(Main.prefix + "§7Deine UUID ist §a" + p.getUniqueId());
            } else if (args.length == 1) {
                Player opfer = Bukkit.getPlayer(args[0]);
                p.sendMessage(Main.prefix + "§7Die UUID von §a" + opfer.getDisplayName() + " §7lautet §a" + opfer.getUniqueId());
            } else {
                p.sendMessage(Main.prefix + "§7Verwendung: §a/UUID <name>");
            }
        } else {
            p.sendMessage(Main.noperm);
        }


        return false;
    }
}

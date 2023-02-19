package at.asna.asnabuild.moderation;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class UnBanCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("system.unban")){
            if (args.length == 0){
                p.sendMessage(Main.prefix + "§7Verwendung: §e/Unban <name>");
            } else if (args.length == 1) {
                OfflinePlayer opfer = Bukkit.getOfflinePlayer(args[0]);
                if (opfer.isBanned()){
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pardon " + opfer.getName());
                    p.sendMessage(Main.prefix + "§7Du hast den Spieler §e" + opfer.getName() + " §7entbannt!");
                } else {
                    p.sendMessage(Main.prefix + "§7Dieser Spieler ist nicht gebannt!");
                }

            } else {
                p.sendMessage(Main.prefix + "§7Verwendung: §e/Unban <name>");
            }
        } else {
            p.sendMessage(Main.noperm);
        }

        return false;
    }
}

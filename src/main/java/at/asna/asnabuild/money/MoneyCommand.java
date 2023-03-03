package at.asna.asnabuild.money;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MoneyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;
        if (args.length == 0){
            p.sendMessage(Main.prefix + "§7Du hast zurzeit §a" + Main.getCoinsAPI().getCoins(p.getUniqueId()) + "§a€");
        } else if (args.length == 1){
            if (p.hasPermission("system.money.other")){
                Player opfer = Bukkit.getPlayer(args[0]);
                p.sendMessage(Main.prefix + "§7Der Spieler §a" + opfer.getDisplayName() + " §7hat §a" + Main.getCoinsAPI().getCoins(opfer.getUniqueId()) + "§a€");
            } else {
                p.sendMessage(Main.noperm);
            }

        } else {
            p.sendMessage(Main.prefix + "§7Verwendung: §a/Money <name>");
        }


        return false;
    }
}

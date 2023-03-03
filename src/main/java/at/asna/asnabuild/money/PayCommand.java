package at.asna.asnabuild.money;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PayCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;

        if (args.length == 2) {
            Player opfer = Bukkit.getPlayer(args[0]);
            if (opfer != null) {
                int amount = Integer.parseInt(args[1]);

                if (Main.getCoinsAPI().getCoins(p.getUniqueId()) > 0) {
                    if (Main.getCoinsAPI().getCoins(p.getUniqueId()) > amount) {
                        Main.getCoinsAPI().sendMoney(p, opfer, amount);
                        p.sendMessage(Main.prefix + "§7Du hast dem Spieler §a" + opfer.getDisplayName() + " §7erfolgreich §a" + args[1] + "§a€ §7gegeben!");
                        opfer.sendMessage(Main.prefix + "§7Du hast §a" + args[1] + "§a€ §7von §a" + p.getDisplayName() + " §7bekommen!");
                    }else {
                        p.sendMessage(Main.prefix + "§7Du hast nicht genug Geld!");}
                } else {
                    p.sendMessage(Main.prefix + "§7Du hast bereits §a0€§7!");

                }

            }

        }


        return false;
    }
}

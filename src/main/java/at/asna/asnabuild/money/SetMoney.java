package at.asna.asnabuild.money;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetMoney implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("system.setmoney")){
            if (args.length == 2) {
                Player opfer = Bukkit.getPlayer(args[0]);
                if (opfer != null) {
                    int amount = Integer.parseInt(args[1]);

                    Main.getCoinsAPI().setMoney(opfer, amount);
                    p.sendMessage(Main.prefix + "§7Du hast dem Spieler §e" + opfer.getDisplayName() + " §7erfolgreich §e" + args[1] + "§e€ §7gesetzt!");
                    opfer.sendMessage(Main.prefix + "§7Du hast §e" + args[1] + "§e€§7!");
                }

            }
        }

        return false;
    }

}

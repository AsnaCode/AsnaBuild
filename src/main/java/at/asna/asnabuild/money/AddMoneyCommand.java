package at.asna.asnabuild.money;

import at.asna.asnabuild.Main;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

public class AddMoneyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("system.addmoney")){
            if (args.length == 2) {
                Player opfer = Bukkit.getPlayer(args[0]);
                if (opfer != null) {
                    int amount = Integer.parseInt(args[1]);

                    Main.getCoinsAPI().addMoney(opfer, amount);
                    p.sendMessage(Main.prefix + "§7Du hast dem Spieler §e" + opfer.getDisplayName() + " §7erfolgreich §e" + args[1] + "§e€ §7gegeben!");
                    opfer.sendMessage(Main.prefix + "§7Du hast §e" + args[1] + "§e€ §7bekommen!");
                }

            }
        }

        return false;
    }
}

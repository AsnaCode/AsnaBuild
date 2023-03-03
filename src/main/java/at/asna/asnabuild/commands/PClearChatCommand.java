package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PClearChatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("system.pclearchat")){
            for (int i = 0; i < 500; i++){
                p.sendMessage("  ");

            }
            p.sendMessage(Main.prefix + "§7Du hast deinen §aChat §7geleert!");
        } else {
            p.sendMessage(Main.noperm);
        }

        return false;
    }
}

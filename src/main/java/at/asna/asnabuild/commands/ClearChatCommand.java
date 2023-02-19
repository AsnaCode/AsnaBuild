package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ClearChatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("system.clearchat")){
            if (args.length == 0){
                for (int i = 0; i < 500; i++){
                    for (Player online : Bukkit.getOnlinePlayers())
                        online.sendMessage("   ");

                }
                Bukkit.broadcastMessage(Main.prefix + "§7Der Chat wurde von §e" + p.getDisplayName() + " §7geleert!");
            } else {
                p.sendMessage(Main.prefix + "§7Verwendung: §e/ClearChat");
            }
        } else {
            p.sendMessage(Main.noperm);
        }



        return false;
    }
}

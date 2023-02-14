package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class WartungenCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;

        if (args.length == 1){

            if (p.hasPermission("system.wartungen")){
                if (args[0].equals("aus")){
                    if (Main.getInstance().getConfig().getBoolean("Wartungen") == false){
                        p.sendMessage(Main.prefix + "§7Die §eWartungen §7sind bereits ausgeschalten!");
                    } else if (Main.getInstance().getConfig().getBoolean("Wartungen") == true){
                        Main.getInstance().getConfig().set("Wartungen", false);
                        Main.getInstance().saveConfig();
                        p.sendMessage(Main.prefix + "§7Die §eWartungen §7wurden ausgeschalten!");
                    }
                } else if (args[0].equals("an")) {
                    if (Main.getInstance().getConfig().getBoolean("Wartungen") == true){
                        p.sendMessage(Main.prefix + "§7Die §eWartungen §7sind bereits eingeschalten!");
                    } else if (Main.getInstance().getConfig().getBoolean("Wartungen") == false){
                        Main.getInstance().getConfig().set("Wartungen", true);
                        Main.getInstance().saveConfig();
                        p.sendMessage(Main.prefix + "§7Die §eWartungen §7wurden eingeschalten!");
                    }
                }
            } else {
                p.sendMessage(Main.noperm);
            }

        }

        return false;
    }
}

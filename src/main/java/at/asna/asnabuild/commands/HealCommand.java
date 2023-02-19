package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player p = (Player) sender;

            if (p.hasPermission("system.heal")){
                if (args.length == 0){
                    p.setHealth(20);
                    p.setFoodLevel(20);
                    p.sendMessage(Main.prefix + "§7Du wurdest §egeheilt§7!");
                } else if (args.length == 1) {
                    if (p.hasPermission("system.heal.other")){
                        Player opfer = Bukkit.getPlayer(args[0]);

                        if (opfer != null){
                            opfer.setHealth(20);
                            opfer.setFoodLevel(20);
                            opfer.sendMessage(Main.prefix + "§7Du wurdest §egeheilt§7!");
                            p.sendMessage(Main.prefix + "§7Du hast den Spieler §e" + opfer.getDisplayName() + " §7geheilt!");
                        } else {
                            p.sendMessage(Main.notonline);
                        }

                    } else {
                        p.sendMessage(Main.noperm);
                    }
                } else {
                    p.sendMessage(Main.prefix + "§7Verwendung: §e/Heal <name>");
                }
            } else {
                p.sendMessage(Main.noperm);
            }
        return false;
        }



    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 1) {
            List<String> p = new ArrayList<>();
            for (Player all : Bukkit.getOnlinePlayers())
                p.add(all.getName());
            return p;
        }
        return null;
    }

}

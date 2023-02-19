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

public class InvseeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player p = (Player) sender;

        if (!(p instanceof Player)){
            p.sendMessage(Main.console);
        } else if (args.length == 1){
            if (p.hasPermission("system.invsee")){
                Player opfer = Bukkit.getPlayer(args[0]);
                if (opfer != null){
                    p.openInventory(opfer.getInventory());

                } else {
                    p.sendMessage(Main.notonline);
                }
            } else {
                p.sendMessage(Main.noperm);
            }
        } else {
            p.sendMessage(Main.prefix + "§7Verwendung: §e/Invsee <name>");
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

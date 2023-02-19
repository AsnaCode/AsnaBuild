package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class BroadCastCommand implements CommandExecutor {

    //«»
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender.hasPermission("system.broadcast")) {
            if (args.length >= 1) {
                String msg = " ";
                for (int i = 0; i < args.length; i++)
                    msg = msg + args[i] + " ";
                Bukkit.broadcastMessage("§7»§7§m-----------§8[§eBROADCAST§8]§7§m----------§7«");
                Bukkit.broadcastMessage("§8 ");
                Bukkit.broadcastMessage("§7» " + msg.replace("&", "§"));
                Bukkit.broadcastMessage("§7 ");
                Bukkit.broadcastMessage("§7»§7§m-----------§8[§eBROADCAST§8]§7§m----------§7«");
            }
        } else {
            commandSender.sendMessage(Main.noperm);
        }
        return false;
    }
}

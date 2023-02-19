package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MSGCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player p = (Player) sender;

        if (args.length >= 2){
            Player opfer = Bukkit.getPlayer(args[0]);
            String msg = "";
            for (int i = 1; i < args.length; i++)
                msg = msg + args[i] + " ";
            if (opfer !=null){
                //«»
                p.sendMessage("§6MSG §8| §eDu §7-> §e" + opfer.getDisplayName() + " §8» §7" + msg.replace("&", "§"));
                opfer.sendMessage("§6MSG §8| §e" + p.getDisplayName() + " §7-> §eDir §8» §7" + msg.replace("&", "§"));
            } else {
                p.sendMessage(Main.notonline);
            }
        } else {
            p.sendMessage(Main.prefix + "§7Verwendung: §e/MSG <name> <nachricht>");
        }




        return false;
    }
}

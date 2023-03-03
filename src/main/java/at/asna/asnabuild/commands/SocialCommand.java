package at.asna.asnabuild.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SocialCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;
        //«»
        p.sendMessage("§7§m----------§8[§aSocial§8]§7§m----------");
        p.sendMessage("§7 ");
        p.sendMessage("§aTikTok §8» §aAsnaCode");
        p.sendMessage("§aYouTube §8» §aAsnaCode");
        p.sendMessage("§aDiscord §8» §agn5BU3xZAc");
        p.sendMessage("§aTwitch §8» §aAsnaCode");
        p.sendMessage("§a ");
        p.sendMessage("§7§m----------§8[§aSocial§8]§7§m----------");


        return false;
    }
}

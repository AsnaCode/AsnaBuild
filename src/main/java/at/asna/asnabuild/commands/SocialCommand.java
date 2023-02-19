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
        p.sendMessage("§7§m----------§8[§eSocial§8]§7§m----------");
        p.sendMessage("§7 ");
        p.sendMessage("§eTikTok §8» §eAsnaCode");
        p.sendMessage("§eYouTube §8» §eAsnaCode");
        p.sendMessage("§eDiscord §8» §egn5BU3xZAc");
        p.sendMessage("§eTwitch §8» §eAsnaCode");
        p.sendMessage("§e ");
        p.sendMessage("§7§m----------§8[§eSocial§8]§7§m----------");


        return false;
    }
}

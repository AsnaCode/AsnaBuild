package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class NickCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("system.nick")){
            if (args.length == 0){
                p.setDisplayName(p.getName());
                p.sendMessage(Main.prefix + "§7Du hast nun einen ursprünglichen §aNamen §7wieder!");
            } else if (args.length == 1) {
                p.setDisplayName(args[0]);
                p.sendMessage(Main.prefix + "§7Dein Name lautet nun §a" + args[0] + " §7im Chat!");
            } else {
                p.sendMessage(Main.prefix + "§7Verwendung: §a/Nick <name>");
            }
        } else {
            p.sendMessage(Main.noperm);
        }

        return false;
    }
}

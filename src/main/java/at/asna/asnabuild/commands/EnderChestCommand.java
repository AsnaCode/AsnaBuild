package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class EnderChestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission("system.enderchest")){
            if (args.length == 0){
                p.openInventory(p.getEnderChest());
                p.sendMessage(Main.prefix + "§7Du siehst nun deine §eEnderChest§7!");
            } else if (p.hasPermission("system.enderchest.other")) {
                if (args.length == 1){
                    Player opfer = Bukkit.getPlayer(args[0]);
                        p.openInventory(opfer.getEnderChest());
                        p.sendMessage(Main.prefix + "§7Du siehst nun die §eEnderChest §7von §e" + opfer.getDisplayName());

                } else {
                    p.sendMessage(Main.prefix + "§7Verwendung: §e/EnderChest <name>");
                }
            }
        }

        return false;
    }
}

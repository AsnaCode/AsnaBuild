package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class RenameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;
        if (p.hasPermission("system.rename")) {
            if (args.length >= 1) {
                if (p.getInventory().getItemInMainHand() != null && p.getInventory().getItemInMainHand().getType() != Material.AIR) {
                    ItemStack itemnew = p.getInventory().getItemInMainHand();
                    ItemMeta itemnewmeta = itemnew.getItemMeta();
                    try {
                        String Message= "";
                        for (int i = 0; i < args.length; i++)
                            Message = String.valueOf(Message) + args[i] + " ";
                        p.sendMessage(Main.prefix + "§7Das §aItem §7wurde §a" + Message.replaceAll("&", "§") + " §7genannt!");
                        itemnewmeta.setDisplayName(Message.replaceAll("&", "§"));
                        itemnew.setItemMeta(itemnewmeta);
                    } catch (Exception e1){

                    }


                }
            } else {
                p.sendMessage(Main.prefix + "§7Verwendung: §a/Rename <text>");
            }
        } else {
            p.sendMessage(Main.noperm);
        }

        return true;
    }
}

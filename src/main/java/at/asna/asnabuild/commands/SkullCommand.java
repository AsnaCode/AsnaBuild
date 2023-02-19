package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

public class SkullCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player p = (Player) sender;

        if (!(p instanceof Player)){
            p.sendMessage(Main.console);
        } else {
            if (args.length == 1){
                if (p.hasPermission("system.skull")){

                    ItemStack j7 = new ItemStack(Material.PLAYER_HEAD);
                    SkullMeta j7meta = (SkullMeta) j7.getItemMeta();
                    j7meta.setDisplayName("§7Kopf von §e" + args[0]);
                    j7meta.setOwner(args[0]);
                    j7.setItemMeta(j7meta);

                    p.getInventory().addItem(j7);
                    p.sendMessage(Main.prefix + "§7Du hast den Kopf von §e" + args[0] + " §7bekommen!");

                }
            }
        }


        return false;
    }
}

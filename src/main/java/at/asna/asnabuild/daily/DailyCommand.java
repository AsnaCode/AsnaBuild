package at.asna.asnabuild.daily;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class DailyCommand implements CommandExecutor {

        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (!(sender instanceof Player))
                return false;
            Player p = (Player) sender;
            ItemStack i1 = new ItemStack(Material.PRISMARINE_SHARD);
            ItemMeta i1meta = i1.getItemMeta();
            i1meta.setDisplayName("§8» §6Hol es dir ab");
            i1.setItemMeta(i1meta);

            ItemStack i4 = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
            ItemMeta i4meta = i4.getItemMeta();
            i4meta.setDisplayName(" ");
            i4.setItemMeta(i4meta);
            Inventory inventory = Bukkit.createInventory(null, InventoryType.CHEST, "§8» §6Daily §8«");
            inventory.setItem(13, i1);
            inventory.setItem(0, i4);
            inventory.setItem(1, i4);
            inventory.setItem(2, i4);
            inventory.setItem(3, i4);
            inventory.setItem(4, i4);
            inventory.setItem(5, i4);
            inventory.setItem(6, i4);
            inventory.setItem(7, i4);
            inventory.setItem(8, i4);
            inventory.setItem(9, i4);
            inventory.setItem(10, i4);
            inventory.setItem(11, i4);
            inventory.setItem(12, i4);
            inventory.setItem(14, i4);
            inventory.setItem(15, i4);
            inventory.setItem(16, i4);
            inventory.setItem(17, i4);
            inventory.setItem(18, i4);
            inventory.setItem(19, i4);
            inventory.setItem(20, i4);
            inventory.setItem(21, i4);
            inventory.setItem(22, i4);
            inventory.setItem(23, i4);
            inventory.setItem(24, i4);
            inventory.setItem(25, i4);
            inventory.setItem(26, i4);
            p.openInventory(inventory);
            return false;
        }
    }


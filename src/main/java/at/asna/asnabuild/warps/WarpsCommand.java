package at.asna.asnabuild.warps;

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

import java.util.Collections;

public class WarpsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;

        Inventory inventory = Bukkit.createInventory(null, InventoryType.CHEST, "§8| §aWarps §7✗ §aTeleport §8|");

        ItemStack i1 = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta i1meta = i1.getItemMeta();
        i1meta.setDisplayName("§8» §aFarmwelt");
        i1meta.setLore(Collections.singletonList("§7Hier kannst du in der §aFarmwelt §7deine Items zusammen Farmen!"));
        i1.setItemMeta(i1meta);

        ItemStack i2 = new ItemStack(Material.NETHERRACK);
        ItemMeta i2meta = i2.getItemMeta();
        i2meta.setDisplayName("§8» §cNether");
        i2meta.setLore(Collections.singletonList("§7Hier kannst du im §cNether §7deine Items zusammen Farmen!"));
        i2.setItemMeta(i2meta);

        ItemStack i3 = new ItemStack(Material.END_STONE);
        ItemMeta i3meta = i3.getItemMeta();
        i3meta.setDisplayName("§8» §eEnd");
        i3meta.setLore(Collections.singletonList("§7Hier kannst du in dem §eEnd §7deine Items zusammen Farmen!"));
        i3.setItemMeta(i3meta);

        int i = 3 * 9;
        ItemStack i6 = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta i6meta = i6.getItemMeta();
        i6meta.setDisplayName("§9 ");
        i6.setItemMeta(i6meta);
        for (int j = 0; j < i; j++)
            inventory.setItem(j, i6);

        inventory.setItem(10, i2);
        inventory.setItem(13, i1);
        inventory.setItem(16, i3);

        p.openInventory(inventory);

        return false;
    }
}

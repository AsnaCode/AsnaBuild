package at.asna.asnabuild.api;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryAPI {



    public static void drawOutline(Inventory inventory, int rows) {
        int i;
        ItemStack i4 = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta i4meta = i4.getItemMeta();
        i4meta.setDisplayName(" ");
        i4.setItemMeta(i4meta);
        for (i = 1; i < 10; i++) {
            inventory.setItem(i - 1, (i4));
            inventory.setItem(rows * 9 - i, (i4));
        }
        for (i = 1; i < rows; i++) {
            inventory.setItem(i * 9, (i4));
            inventory.setItem(i * 9 - 1, (i4));
        }
    }

    public static void fillInventory(Inventory inventory, int rows) {
        ItemStack i4 = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta i4meta = i4.getItemMeta();
        i4meta.setDisplayName(" ");
        i4.setItemMeta(i4meta);
        int i = rows * 9;
        for (int j = 0; j < i; j++) {
            inventory.setItem(j, (i4));
        }

    }


}

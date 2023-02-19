package at.asna.asnabuild.shop;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;

public class Ränge implements InventoryHolder {


    private final Inventory inventory;
    private final Player player;

    public Ränge(Player player) {
        this.inventory = Bukkit.createInventory(this, 6 * 9, "§8| §cShop §7✗ §eRänge §8|");
        this.player = player;

        ItemStack i1 = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta i1meta = i1.getItemMeta();
        i1meta.setDisplayName("§8§l« §7§lItems §8§l»");
        i1.setItemMeta(i1meta);


        ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta i2meta = i2.getItemMeta();
        i2meta.setDisplayName("§8§l« §7§lRüstung §8§l»");
        i2.setItemMeta(i2meta);

        ItemStack i3 = new ItemStack(Material.APPLE);
        ItemMeta i3meta = i3.getItemMeta();
        i3meta.setDisplayName("§8§l« §7§lEssen §8§l»");
        i3.setItemMeta(i3meta);

        ItemStack i4 = new ItemStack(Material.RED_DYE);
        ItemMeta i4meta = i4.getItemMeta();
        i4meta.setDisplayName("§8§l« §7§lRänge §8§l»");
        i4.setItemMeta(i4meta);


        int i = 6 * 9;
        ItemStack i6 = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta i6meta = i6.getItemMeta();
        i6meta.setDisplayName("§8");
        i6.setItemMeta(i6meta);
        for (int j = 0; j < i; j++) {
            inventory.setItem(j, i6);
        }

        ItemStack i7 = new ItemStack(Material.IRON_BARS);
        ItemMeta i7meta = i7.getItemMeta();
        i7meta.setDisplayName("§7");
        i7.setItemMeta(i7meta);

        //Jacken-1

        ItemStack j1 = new ItemStack(Material.GOLD_INGOT);
        ItemMeta j1meta = j1.getItemMeta();
        j1meta.setDisplayName("§8§l« §7§lPremium §8§l»");
        j1meta.setLore(Collections.singletonList("§ePreis§7: §7100.000€"));
        j1.setItemMeta(j1meta);

        ItemStack j2 = new ItemStack(Material.IRON_INGOT);
        ItemMeta j2meta = j2.getItemMeta();
        j2meta.setDisplayName("§8§l« §7§lAsna §8§l»");
        j2meta.setLore(Collections.singletonList("§ePreis§7: §7500.000€"));
        j2.setItemMeta(j2meta);







        //SOON
        ItemStack j11 = new ItemStack(Material.GRAY_DYE);
        ItemMeta j11meta = j11.getItemMeta();
        j11meta.setDisplayName("§8§l« §7§lSoon §8§l»");
        j11.setItemMeta(j11meta);


        player.openInventory(inventory);

        //UNNÖTIG


        inventory.setItem(9, i2);
        inventory.setItem(11, i7);
        inventory.setItem(12, j11);
        inventory.setItem(13, j11);
        inventory.setItem(14, j11);
        inventory.setItem(15, j11);
        inventory.setItem(16, j11);
        inventory.setItem(17, i7);
        inventory.setItem(18, i3);
        inventory.setItem(20, i7);
        inventory.setItem(21, j11);
        inventory.setItem(22, j11);
        inventory.setItem(23, j1);
        inventory.setItem(24, j11);
        inventory.setItem(25, j11);
        inventory.setItem(26, i7);
        inventory.setItem(27, i1);
        inventory.setItem(29, i7);
        inventory.setItem(30, j11);
        inventory.setItem(31, j11);
        inventory.setItem(32, j2);
        inventory.setItem(33, j11);
        inventory.setItem(34, j11);
        inventory.setItem(35, i7);
        inventory.setItem(36, i4);
        inventory.setItem(38, i7);
        inventory.setItem(39, j11);
        inventory.setItem(40, j11);
        inventory.setItem(41, j11);
        inventory.setItem(42, j11);
        inventory.setItem(43, j11);
        inventory.setItem(44, i7);


        player.openInventory(getInventory());
    }


    //KOSMETIKS
    public void onClick(ItemStack stack, int slot) {
        switch (slot) {
            case 27: {
                new Blöcke(player);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2F, 1F);
                break;
            }
            case 9: {
                new Rüstung(player);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2F, 1F);
                break;
            }
            case 18: {
                new Essen(player);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2F, 1F);
                break;
            }

            case 23: {
                if (Main.getCoinsAPI().getCoins(player.getUniqueId()) >= 100000){

                    if (player.hasPermission("system.asna")){
                        player.sendMessage(Main.prefix + "§7Du hast bereits den Rang inklusive!");
                    } else {
                        int amount = 100000;

                        //TUEN
                        Main.getCoinsAPI().removeMoney(player, amount);
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getDisplayName() + " parent set premium");
                        player.kickPlayer("§6§LRANG UPGRADE");
                    }


                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug Geld!");
                }
                break;
            }
            case 32: {
                if (Main.getCoinsAPI().getCoins(player.getUniqueId()) >= 500000){

                    if (player.hasPermission("system.asna")){
                        player.sendMessage(Main.prefix + "§7Du hast bereits den Rang inklusive!");
                    } else{
                        int amount = 500000;

                        //TUEN
                        Main.getCoinsAPI().removeMoney(player, amount);
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getDisplayName() + " parent set asna");
                        player.kickPlayer("§6§LRANG UPGRADE");

                    }
                    } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug Geld!");
                }

                break;
            }


        }
    }


    @Override
    public @NotNull Inventory getInventory() {


        return this.inventory;
    }


}

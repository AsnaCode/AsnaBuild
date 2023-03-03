package at.asna.asnabuild.verkaufen;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;

public class ItemsV implements InventoryHolder {

    private final Inventory inventory;
    private final Player player;

    public ItemsV(Player player) {
        this.inventory = Bukkit.createInventory(this, 6 * 9, "§8| §aVerkaufen §7✗ §aItems §8|");
        this.player = player;

        ItemStack i1 = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta i1meta = i1.getItemMeta();
        i1meta.setDisplayName("§8§l« §7§lBlöcke §8§l»");
        i1.setItemMeta(i1meta);


        ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta i2meta = i2.getItemMeta();
        i2meta.setDisplayName("§8§l« §7§lRüstung §8§l»");
        i2.setItemMeta(i2meta);

        ItemStack i3 = new ItemStack(Material.APPLE);
        ItemMeta i3meta = i3.getItemMeta();
        i3meta.setDisplayName("§8§l« §7§lEssen §8§l»");
        i3.setItemMeta(i3meta);

        ItemStack i4 = new ItemStack(Material.SUGAR);
        ItemMeta i4meta = i4.getItemMeta();
        i4meta.setDisplayName("§8§l« §7§lItems §8§l»");
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

        ItemStack j1 = new ItemStack(Material.SUGAR_CANE);
        ItemMeta j1meta = j1.getItemMeta();
        j1.setAmount(32);
        j1meta.setDisplayName("§8§l« §7§lZuckerrohr §8§l»");
        j1meta.setLore(Collections.singletonList("§ePreis§7: §750€"));
        j1.setItemMeta(j1meta);

        ItemStack j2 = new ItemStack(Material.DIAMOND);
        ItemMeta j2meta = j2.getItemMeta();
        j2.setAmount(16);
        j2meta.setDisplayName("§8§l« §7§lDiamanten §8§l»");
        j2meta.setLore(Collections.singletonList("§ePreis§7: §71000€"));
        j2.setItemMeta(j2meta);

        ItemStack j3 = new ItemStack(Material.IRON_INGOT);
        ItemMeta j3meta = j3.getItemMeta();
        j3.setAmount(16);
        j3meta.setDisplayName("§8§l« §7§lEisen §8§l»");
        j3meta.setLore(Collections.singletonList("§ePreis§7: §7500€"));
        j3.setItemMeta(j3meta);

        ItemStack j4 = new ItemStack(Material.LAPIS_LAZULI);
        ItemMeta j4meta = j4.getItemMeta();
        j4.setAmount(32);
        j4meta.setDisplayName("§8§l« §7§lLapiz §8§l»");
        j4meta.setLore(Collections.singletonList("§ePreis§7: §7500€"));
        j4.setItemMeta(j4meta);

        ItemStack j5 = new ItemStack(Material.GOLD_INGOT);
        ItemMeta j5meta = j5.getItemMeta();
        j5.setAmount(32);
        j5meta.setDisplayName("§8§l« §7§lGold §8§l»");
        j5meta.setLore(Collections.singletonList("§ePreis§7: §7250€"));
        j5.setItemMeta(j5meta);

        ItemStack j6 = new ItemStack(Material.NETHERITE_INGOT);
        ItemMeta j6meta = j6.getItemMeta();
        j6.setAmount(1);
        j6meta.setDisplayName("§8§l« §7§lNetherite §8§l»");
        j6meta.setLore(Collections.singletonList("§ePreis§7: §71.100€"));
        j6.setItemMeta(j6meta);

        ItemStack j7 = new ItemStack(Material.COAL);
        ItemMeta j7meta = j7.getItemMeta();
        j7.setAmount(32);
        j7meta.setDisplayName("§8§l« §7§lKohle §8§l»");
        j7meta.setLore(Collections.singletonList("§ePreis§7: §7250€"));
        j7.setItemMeta(j7meta);

        ItemStack j8 = new ItemStack(Material.EMERALD);
        ItemMeta j8meta = j8.getItemMeta();
        j8.setAmount(16);
        j8meta.setDisplayName("§8§l« §7§lEmerald §8§l»");
        j8meta.setLore(Collections.singletonList("§ePreis§7: §7750€"));
        j8.setItemMeta(j8meta);

        ItemStack j9 = new ItemStack(Material.REDSTONE);
        ItemMeta j9meta = j9.getItemMeta();
        j9.setAmount(32);
        j9meta.setDisplayName("§8§l« §7§lRedstone §8§l»");
        j9meta.setLore(Collections.singletonList("§ePreis§7: §7250€"));
        j9.setItemMeta(j9meta);

        ItemStack j10 = new ItemStack(Material.COPPER_INGOT);
        ItemMeta j10meta = j10.getItemMeta();
        j10.setAmount(32);
        j10meta.setDisplayName("§8§l« §7§lKupfer §8§l»");
        j10meta.setLore(Collections.singletonList("§ePreis§7: §7250€"));
        j10.setItemMeta(j10meta);




        //SOON
        ItemStack j22 = new ItemStack(Material.GRAY_DYE);
        ItemMeta j22meta = j22.getItemMeta();
        j22meta.setDisplayName("§8§l« §7§lSoon §8§l»");
        j22.setItemMeta(j22meta);


        player.openInventory(inventory);

        //UNNÖTIG


        inventory.setItem(9, i2);
        inventory.setItem(11, i7);
        inventory.setItem(12, j1);
        inventory.setItem(13, j2);
        inventory.setItem(14, j3);
        inventory.setItem(15, j4);
        inventory.setItem(16, j5);
        inventory.setItem(17, i7);
        inventory.setItem(18, i3);
        inventory.setItem(20, i7);
        inventory.setItem(21, j6);
        inventory.setItem(22, j7);
        inventory.setItem(23, j8);
        inventory.setItem(24, j9);
        inventory.setItem(25, j10);
        inventory.setItem(26, i7);
        inventory.setItem(27, i1);
        inventory.setItem(29, i7);
        inventory.setItem(30, j22);
        inventory.setItem(31, j22);
        inventory.setItem(32, j22);
        inventory.setItem(33, j22);
        inventory.setItem(34, j22);
        inventory.setItem(35, i7);
        inventory.setItem(36, i4);
        inventory.setItem(38, i7);
        inventory.setItem(39, j22);
        inventory.setItem(40, j22);
        inventory.setItem(41, j22);
        inventory.setItem(42, j22);
        inventory.setItem(43, j22);
        inventory.setItem(44, i7);


        player.openInventory(getInventory());
    }


    //KOSMETIKS
    public void onClick(ItemStack stack, int slot) {
        switch (slot) {


            //ITEMS
            case 9: {
                new RüstungV(player);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2F, 1F);

                break;
            }
            case 18: {
                new EssenV(player);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2F, 1F);
                break;
            }
            case 27: {
                new BlöckeV(player);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2F, 1F);
                break;
            }
            case 12:{
                ItemStack j6 = new ItemStack(Material.SUGAR_CANE);
                ItemMeta j6meta = j6.getItemMeta();
                j6.setAmount(32);
                j6.setItemMeta(j6meta);

                if (player.getInventory().containsAtLeast(j6, j6.getAmount())){
                    int amount = 50;

                    //TUEN
                    Main.getCoinsAPI().addMoney(player, amount);
                    player.getOpenInventory().getBottomInventory().removeItemAnySlot(j6);
                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug §aItems §7dafür!");
                }

                break;
            }

            case 13:{
                ItemStack j6 = new ItemStack(Material.DIAMOND);
                ItemMeta j6meta = j6.getItemMeta();
                j6.setAmount(16);
                j6.setItemMeta(j6meta);

                if (player.getInventory().containsAtLeast(j6, j6.getAmount())){
                    int amount = 500;

                    //TUEN
                    Main.getCoinsAPI().addMoney(player, amount);
                    player.getOpenInventory().getBottomInventory().removeItemAnySlot(j6);
                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug §aItems §7dafür!");
                }

                break;
            }

            case 14:{
                ItemStack j6 = new ItemStack(Material.IRON_INGOT);
                ItemMeta j6meta = j6.getItemMeta();
                j6.setAmount(16);
                j6.setItemMeta(j6meta);

                if (player.getInventory().containsAtLeast(j6, j6.getAmount())){
                    int amount = 250;

                    //TUEN
                    Main.getCoinsAPI().addMoney(player, amount);
                    player.getOpenInventory().getBottomInventory().removeItemAnySlot(j6);
                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug §aItems §7dafür!");
                }
                break;
            }

            case 15:{
                ItemStack j6 = new ItemStack(Material.LAPIS_LAZULI);
                ItemMeta j6meta = j6.getItemMeta();
                j6.setAmount(32);
                j6.setItemMeta(j6meta);

                if (player.getInventory().containsAtLeast(j6, j6.getAmount())){
                    int amount = 500;

                    //TUEN
                    Main.getCoinsAPI().addMoney(player, amount);
                    player.getOpenInventory().getBottomInventory().removeItemAnySlot(j6);
                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug §aItems §7dafür!");
                }
                break;
            }

            case 16:{
                ItemStack j6 = new ItemStack(Material.GOLD_INGOT);
                ItemMeta j6meta = j6.getItemMeta();
                j6.setAmount(16);
                j6.setItemMeta(j6meta);

                if (player.getInventory().containsAtLeast(j6, j6.getAmount())){
                    int amount = 250;

                    //TUEN
                    Main.getCoinsAPI().addMoney(player, amount);
                    player.getOpenInventory().getBottomInventory().removeItemAnySlot(j6);
                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug §aItems §7dafür!");
                }
                break;
            }

            case 21:{

                    ItemStack j6 = new ItemStack(Material.NETHERITE_INGOT);
                    ItemMeta j6meta = j6.getItemMeta();
                    j6.setAmount(1);
                    j6.setItemMeta(j6meta);

                if (player.getInventory().containsAtLeast(j6, j6.getAmount())){
                    int amount = 1100;

                    //TUEN
                    Main.getCoinsAPI().addMoney(player, amount);
                    player.getOpenInventory().getBottomInventory().removeItemAnySlot(j6);
                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug §aItems §7dafür!");
                }



                break;
            }

            case 22:{
                ItemStack j6 = new ItemStack(Material.COAL);
                ItemMeta j6meta = j6.getItemMeta();
                j6.setAmount(32);
                j6.setItemMeta(j6meta);

                if (player.getInventory().containsAtLeast(j6, j6.getAmount())){
                    int amount = 250;

                    //TUEN
                    Main.getCoinsAPI().addMoney(player, amount);
                    player.getOpenInventory().getBottomInventory().removeItemAnySlot(j6);
                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug §aItems §7dafür!");
                }
                break;
            }

            case 23:{
                ItemStack j6 = new ItemStack(Material.EMERALD);
                ItemMeta j6meta = j6.getItemMeta();
                j6.setAmount(16);
                j6.setItemMeta(j6meta);

                if (player.getInventory().containsAtLeast(j6, j6.getAmount())){
                    int amount = 750;

                    //TUEN
                    Main.getCoinsAPI().addMoney(player, amount);
                    player.getOpenInventory().getBottomInventory().removeItemAnySlot(j6);
                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug §aItems §7dafür!");
                }
                break;
            }

            case 24:{
                ItemStack j6 = new ItemStack(Material.REDSTONE);
                ItemMeta j6meta = j6.getItemMeta();
                j6.setAmount(32);
                j6.setItemMeta(j6meta);

                if (player.getInventory().containsAtLeast(j6, j6.getAmount())){
                    int amount = 250;

                    //TUEN
                    Main.getCoinsAPI().addMoney(player, amount);
                    player.getOpenInventory().getBottomInventory().removeItemAnySlot(j6);
                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug §aItems §7dafür!");
                }
                break;
            }

            case 25:{
                ItemStack j6 = new ItemStack(Material.COPPER_INGOT);
                ItemMeta j6meta = j6.getItemMeta();
                j6.setAmount(32);
                j6.setItemMeta(j6meta);

                if (player.getInventory().containsAtLeast(j6, j6.getAmount())){
                    int amount = 250;

                    //TUEN
                    Main.getCoinsAPI().addMoney(player, amount);
                    player.getOpenInventory().getBottomInventory().removeItemAnySlot(j6);
                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug §aItems §7dafür!");
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



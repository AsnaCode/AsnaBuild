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

public class RüstungV implements InventoryHolder {

    private final Inventory inventory;
    private final Player player;

    public RüstungV(Player player) {
        this.inventory = Bukkit.createInventory(this, 6 * 9, "§8| §aVerkaufen §7✗ §aRüstung §8|");
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

        ItemStack j1 = new ItemStack(Material.IRON_HELMET);
        ItemMeta j1meta = j1.getItemMeta();
        j1meta.setDisplayName("§8§l« §7§lEisen Helm §8§l»");
        j1meta.setLore(Collections.singletonList("§ePreis§7: §7250€"));
        j1.setItemMeta(j1meta);

        ItemStack j2 = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta j2meta = j2.getItemMeta();
        j2meta.setDisplayName("§8§l« §7§lEisen Brustplatte §8§l»");
        j2meta.setLore(Collections.singletonList("§ePreis§7: §7250€"));
        j2.setItemMeta(j2meta);

        ItemStack j3 = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta j3meta = j3.getItemMeta();
        j3meta.setDisplayName("§8§l« §7§lEisen Hose §8§l»");
        j3meta.setLore(Collections.singletonList("§ePreis§7: §7250€"));
        j3.setItemMeta(j3meta);

        ItemStack j4 = new ItemStack(Material.IRON_BOOTS);
        ItemMeta j4meta = j4.getItemMeta();
        j4meta.setDisplayName("§8§l« §7§lEisen Schuhe §8§l»");
        j4meta.setLore(Collections.singletonList("§ePreis§7: §7250€"));
        j4.setItemMeta(j4meta);

        ItemStack j5 = new ItemStack(Material.IRON_SWORD);
        ItemMeta j5meta = j5.getItemMeta();
        j5meta.setDisplayName("§8§l« §7§lEisen Schwert §8§l»");
        j5meta.setLore(Collections.singletonList("§ePreis§7: §7200€"));
        j5.setItemMeta(j5meta);

        ItemStack j6 = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta j6meta = j6.getItemMeta();
        j6meta.setDisplayName("§8§l« §7§lDiamanten Helm §8§l»");
        j6meta.setLore(Collections.singletonList("§ePreis§7: §7500€"));
        j6.setItemMeta(j6meta);

        ItemStack j7 = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta j7meta = j7.getItemMeta();
        j7meta.setDisplayName("§8§l« §7§lDiamanten Brustplatte §8§l»");
        j7meta.setLore(Collections.singletonList("§ePreis§7: §7500€"));
        j7.setItemMeta(j7meta);

        ItemStack j8 = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta j8meta = j8.getItemMeta();
        j8meta.setDisplayName("§8§l« §7§lDiamanten Hose §8§l»");
        j8meta.setLore(Collections.singletonList("§ePreis§7: §7500€"));
        j8.setItemMeta(j8meta);

        ItemStack j9 = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta j9meta = j9.getItemMeta();
        j9meta.setDisplayName("§8§l« §7§lDiamanten Schuhe §8§l»");
        j9meta.setLore(Collections.singletonList("§ePreis§7: §7500€"));
        j9.setItemMeta(j9meta);

        ItemStack j10 = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta j10meta = j10.getItemMeta();
        j10meta.setDisplayName("§8§l« §7§lDiamanten Schwert §8§l»");
        j10meta.setLore(Collections.singletonList("§ePreis§7: §7400€"));
        j10.setItemMeta(j10meta);





        //SOON
        ItemStack j11 = new ItemStack(Material.GRAY_DYE);
        ItemMeta j11meta = j11.getItemMeta();
        j11meta.setDisplayName("§8§l« §7§lSoon §8§l»");
        j11.setItemMeta(j11meta);


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
        inventory.setItem(30, j11);
        inventory.setItem(31, j11);
        inventory.setItem(32, j11);
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
            case 36: {
                new ItemsV(player);
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
            //ITEMS
            case 12:{

                    ItemStack j1 = new ItemStack(Material.IRON_HELMET);
                    ItemMeta j1meta = j1.getItemMeta();
                    j1.setItemMeta(j1meta);
                if (player.getInventory().contains(j1)){
                    int amount = 250;

                    //TUEN
                    Main.getCoinsAPI().addMoney(player, amount);
                    player.getOpenInventory().getBottomInventory().removeItemAnySlot(j1);
                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug §aItems §7dafür!");
                }


                break;
            }

            case 13:{
                    ItemStack j2 = new ItemStack(Material.IRON_CHESTPLATE);
                    ItemMeta j2meta = j2.getItemMeta();
                    j2.setItemMeta(j2meta);

                    if (player.getInventory().contains(j2)){
                        int amount = 250;

                        //TUEN
                        Main.getCoinsAPI().addMoney(player, amount);
                        player.getOpenInventory().getBottomInventory().removeItemAnySlot(j2);
                    } else {
                        player.sendMessage(Main.prefix + "§7Du hast nicht genug §aItems §7dafür!");
                    }
                break;
            }

            case 14:{
                    ItemStack j3 = new ItemStack(Material.IRON_LEGGINGS);
                    ItemMeta j3meta = j3.getItemMeta();
                    j3.setItemMeta(j3meta);

                if (player.getInventory().contains(j3)){
                    int amount = 250;

                    //TUEN
                    Main.getCoinsAPI().addMoney(player, amount);
                    player.getOpenInventory().getBottomInventory().removeItemAnySlot(j3);
                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug §aItems §7dafür!");
                }
                break;
            }

            case 15:{
                    ItemStack j4 = new ItemStack(Material.IRON_BOOTS);
                    ItemMeta j4meta = j4.getItemMeta();
                    j4.setItemMeta(j4meta);

                if (player.getInventory().contains(j4)){
                    int amount = 250;

                    //TUEN
                    Main.getCoinsAPI().addMoney(player, amount);
                    player.getOpenInventory().getBottomInventory().removeItemAnySlot(j4);
                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug §aItems §7dafür!");
                }
                break;
            }

            case 16:{
                    ItemStack j5 = new ItemStack(Material.IRON_SWORD);
                    ItemMeta j5meta = j5.getItemMeta();
                    j5.setItemMeta(j5meta);

                if (player.getInventory().contains(j5)){
                    int amount = 200;

                    //TUEN
                    Main.getCoinsAPI().addMoney(player, amount);
                    player.getOpenInventory().getBottomInventory().removeItemAnySlot(j5);
                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug §aItems §7dafür!");
                }
                break;

            }

            case 21:{
                    ItemStack j6 = new ItemStack(Material.DIAMOND_HELMET);
                    ItemMeta j6meta = j6.getItemMeta();
                    j6.setItemMeta(j6meta);

                if (player.getInventory().contains(j6)){
                    int amount = 500;

                    //TUEN
                    Main.getCoinsAPI().addMoney(player, amount);
                    player.getOpenInventory().getBottomInventory().removeItemAnySlot(j6);
                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug §aItems §7dafür!");
                }
                break;
            }

            case 22:{
                    ItemStack j7 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                    ItemMeta j7meta = j7.getItemMeta();
                    j7.setItemMeta(j7meta);

                if (player.getInventory().contains(j7)){
                    int amount = 500;

                    //TUEN
                    Main.getCoinsAPI().addMoney(player, amount);
                    player.getOpenInventory().getBottomInventory().removeItemAnySlot(j7);
                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug §aItems §7dafür!");
                }
                break;
            }

            case 23:{
                    ItemStack j8 = new ItemStack(Material.DIAMOND_LEGGINGS);
                    ItemMeta j8meta = j8.getItemMeta();
                    j8.setItemMeta(j8meta);

                if (player.getInventory().contains(j8)){
                    int amount = 500;

                    //TUEN
                    Main.getCoinsAPI().addMoney(player, amount);
                    player.getOpenInventory().getBottomInventory().removeItemAnySlot(j8);
                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug §aItems §7dafür!");
                }
                break;
            }

            case 24:{
                    ItemStack j9 = new ItemStack(Material.DIAMOND_BOOTS);
                    ItemMeta j9meta = j9.getItemMeta();
                    j9.setItemMeta(j9meta);

                if (player.getInventory().contains(j9)){
                    int amount = 500;

                    //TUEN
                    Main.getCoinsAPI().addMoney(player, amount);
                    player.getOpenInventory().getBottomInventory().removeItemAnySlot(j9);
                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug §aItems §7dafür!");
                }
                break;
            }

            case 25:{
                    ItemStack j10 = new ItemStack(Material.DIAMOND_SWORD);
                    ItemMeta j10meta = j10.getItemMeta();
                    j10meta.setLore(Collections.singletonList("§ePreis§7: §7400€"));
                    j10.setItemMeta(j10meta);

                if (player.getInventory().contains(j10)){
                    int amount = 400;

                    //TUEN
                    Main.getCoinsAPI().addMoney(player, amount);
                    player.getOpenInventory().getBottomInventory().removeItemAnySlot(j10);
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






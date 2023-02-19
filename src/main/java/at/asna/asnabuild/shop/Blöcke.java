package at.asna.asnabuild.shop;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;

public class Blöcke implements InventoryHolder {

    private final Inventory inventory;
    private final Player player;

    public Blöcke(Player player) {
        this.inventory = Bukkit.createInventory(this, 6 * 9, "§8| §cShop §7✗ §eItems §8|");
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

        ItemStack j1 = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta j1meta = j1.getItemMeta();
        j1.setAmount(32);
        j1meta.setDisplayName("§8§l« §7§lGrass Block §8§l»");
        j1meta.setLore(Collections.singletonList("§ePreis§7: §7100€"));
        j1.setItemMeta(j1meta);

        ItemStack j2 = new ItemStack(Material.OAK_WOOD);
        ItemMeta j2meta = j2.getItemMeta();
        j2.setAmount(32);
        j2meta.setDisplayName("§8§l« §7§lEichen Holz §8§l»");
        j2meta.setLore(Collections.singletonList("§ePreis§7: §7100€"));
        j2.setItemMeta(j2meta);

        ItemStack j3 = new ItemStack(Material.SPRUCE_WOOD);
        ItemMeta j3meta = j3.getItemMeta();
        j3.setAmount(32);
        j3meta.setDisplayName("§8§l« §7§lFichten Holz §8§l»");
        j3meta.setLore(Collections.singletonList("§ePreis§7: §7100€"));
        j3.setItemMeta(j3meta);

        ItemStack j4 = new ItemStack(Material.OAK_LEAVES);
        ItemMeta j4meta = j4.getItemMeta();
        j4.setAmount(32);
        j4meta.setDisplayName("§8§l« §7§lEichen Blätter §8§l»");
        j4meta.setLore(Collections.singletonList("§ePreis§7: §750€"));
        j4.setItemMeta(j4meta);

        ItemStack j5 = new ItemStack(Material.COBBLESTONE);
        ItemMeta j5meta = j5.getItemMeta();
        j5.setAmount(32);
        j5meta.setDisplayName("§8§l« §7§lBruchstein §8§l»");
        j5meta.setLore(Collections.singletonList("§ePreis§7: §7100€"));
        j5.setItemMeta(j5meta);

        ItemStack j6 = new ItemStack(Material.DIAMOND);
        ItemMeta j6meta = j6.getItemMeta();
        j6.setAmount(16);
        j6meta.setDisplayName("§8§l« §7§lDiamanten §8§l»");
        j6meta.setLore(Collections.singletonList("§ePreis§7: §71000€"));
        j6.setItemMeta(j6meta);

        ItemStack j7 = new ItemStack(Material.IRON_INGOT);
        ItemMeta j7meta = j7.getItemMeta();
        j7.setAmount(16);
        j7meta.setDisplayName("§8§l« §7§lEisen §8§l»");
        j7meta.setLore(Collections.singletonList("§ePreis§7: §7500€"));
        j7.setItemMeta(j7meta);

        ItemStack j8 = new ItemStack(Material.DRAGON_EGG);
        ItemMeta j8meta = j8.getItemMeta();
        j8.setAmount(1);
        j8meta.setDisplayName("§8§l« §7§lDrachen Ei §8§l»");
        j8meta.setLore(Collections.singletonList("§ePreis§7: §750.000€"));
        j8.setItemMeta(j8meta);

        ItemStack j9 = new ItemStack(Material.BEACON);
        ItemMeta j9meta = j9.getItemMeta();
        j9.setAmount(1);
        j9meta.setDisplayName("§8§l« §7§lBeacon §8§l»");
        j9meta.setLore(Collections.singletonList("§ePreis§7: §725.000€"));
        j9.setItemMeta(j9meta);

        ItemStack j10 = new ItemStack(Material.SPAWNER);
        ItemMeta j10meta = j10.getItemMeta();
        j10.setAmount(1);
        j10meta.setDisplayName("§8§l« §7§lSpawner §8§l»");
        j10meta.setLore(Collections.singletonList("§ePreis§7: §7100.000€"));
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
            case 36: {
                new Ränge(player);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2F, 1F);
                break;
            }

            //ITEMS
            case 12:{
                if (Main.getCoinsAPI().getCoins(player.getUniqueId()) >= 100){
                    ItemStack j1 = new ItemStack(Material.GRASS_BLOCK);
                    ItemMeta j1meta = j1.getItemMeta();
                    j1.setAmount(32);
                    j1meta.setDisplayName("§8§l« §7§lGrass Block §8§l»");
                    j1.setItemMeta(j1meta);

                    int amount = 100;

                    //TUEN
                    Main.getCoinsAPI().removeMoney(player, amount);
                    player.getInventory().addItem(j1);


                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug Geld!");
                }
                break;
            }

            case 13:{
                if (Main.getCoinsAPI().getCoins(player.getUniqueId()) >= 100){
                    ItemStack j2 = new ItemStack(Material.OAK_WOOD);
                    ItemMeta j2meta = j2.getItemMeta();
                    j2.setAmount(32);
                    j2meta.setDisplayName("§8§l« §7§lEichen Holz §8§l»");
                    j2.setItemMeta(j2meta);

                    int amount = 100;

                    //TUEN
                    Main.getCoinsAPI().removeMoney(player, amount);
                    player.getInventory().addItem(j2);


                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug Geld!");
                }
                break;
            }

            case 14:{
                if (Main.getCoinsAPI().getCoins(player.getUniqueId()) >= 100){
                    ItemStack j3 = new ItemStack(Material.SPRUCE_WOOD);
                    ItemMeta j3meta = j3.getItemMeta();
                    j3.setAmount(32);
                    j3meta.setDisplayName("§8§l« §7§lFichten Holz §8§l»");
                    j3.setItemMeta(j3meta);

                    int amount = 100;

                    //TUEN
                    Main.getCoinsAPI().removeMoney(player, amount);
                    player.getInventory().addItem(j3);


                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug Geld!");
                }
                break;
            }

            case 15:{
                if (Main.getCoinsAPI().getCoins(player.getUniqueId()) >= 50){
                    ItemStack j4 = new ItemStack(Material.OAK_LEAVES);
                    ItemMeta j4meta = j4.getItemMeta();
                    j4.setAmount(32);
                    j4meta.setDisplayName("§8§l« §7§lEichen Blätter §8§l»");
                    j4.setItemMeta(j4meta);

                    int amount = 50;

                    //TUEN
                    Main.getCoinsAPI().removeMoney(player, amount);
                    player.getInventory().addItem(j4);


                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug Geld!");
                }
                break;
            }

            case 16:{
                if (Main.getCoinsAPI().getCoins(player.getUniqueId()) >= 100){
                    ItemStack j5 = new ItemStack(Material.COBBLESTONE);
                    ItemMeta j5meta = j5.getItemMeta();
                    j5.setAmount(32);
                    j5meta.setDisplayName("§8§l« §7§lBruchstein §8§l»");
                    j5.setItemMeta(j5meta);

                    int amount = 100;

                    //TUEN
                    Main.getCoinsAPI().removeMoney(player, amount);
                    player.getInventory().addItem(j5);


                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug Geld!");
                }
                break;
            }

            case 21:{
                if (Main.getCoinsAPI().getCoins(player.getUniqueId()) >= 1000){
                    ItemStack j6 = new ItemStack(Material.DIAMOND);
                    ItemMeta j6meta = j6.getItemMeta();
                    j6.setAmount(16);
                    j6meta.setDisplayName("§8§l« §7§lDiamanten §8§l»");
                    j6.setItemMeta(j6meta);

                    int amount = 1000;

                    //TUEN
                    Main.getCoinsAPI().removeMoney(player, amount);
                    player.getInventory().addItem(j6);


                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug Geld!");
                }
                break;
            }

            case 22:{
                if (Main.getCoinsAPI().getCoins(player.getUniqueId()) >= 500){
                    ItemStack j7 = new ItemStack(Material.IRON_INGOT);
                    ItemMeta j7meta = j7.getItemMeta();
                    j7.setAmount(16);
                    j7meta.setDisplayName("§8§l« §7§lEisen §8§l»");
                    j7.setItemMeta(j7meta);

                    int amount = 500;

                    //TUEN
                    Main.getCoinsAPI().removeMoney(player, amount);
                    player.getInventory().addItem(j7);


                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug Geld!");
                }
                break;
            }

            case 23:{
                if (Main.getCoinsAPI().getCoins(player.getUniqueId()) >= 50000){
                    ItemStack j8 = new ItemStack(Material.DRAGON_EGG);
                    ItemMeta j8meta = j8.getItemMeta();
                    j8.setAmount(1);
                    j8meta.setDisplayName("§8§l« §7§lDrachen Ei §8§l»");
                    j8.setItemMeta(j8meta);

                    int amount = 50000;

                    //TUEN
                    Main.getCoinsAPI().removeMoney(player, amount);
                    player.getInventory().addItem(j8);


                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug Geld!");
                }
                break;
            }

            case 24:{
                if (Main.getCoinsAPI().getCoins(player.getUniqueId()) >= 25000){
                    ItemStack j9 = new ItemStack(Material.BEACON);
                    ItemMeta j9meta = j9.getItemMeta();
                    j9.setAmount(1);
                    j9meta.setDisplayName("§8§l« §7§lBeacon §8§l»");
                    j9.setItemMeta(j9meta);

                    int amount = 25000;

                    //TUEN
                    Main.getCoinsAPI().removeMoney(player, amount);
                    player.getInventory().addItem(j9);


                } else {
                    player.sendMessage(Main.prefix + "§7Du hast nicht genug Geld!");
                }
                break;
            }

            case 25:{
                if (Main.getCoinsAPI().getCoins(player.getUniqueId()) >= 100000){
                    ItemStack j10 = new ItemStack(Material.SPAWNER);
                    ItemMeta j10meta = j10.getItemMeta();
                    j10.setAmount(1);
                    j10meta.setDisplayName("§8§l« §7§lSpawner §8§l»");
                    j10.setItemMeta(j10meta);

                    int amount = 100000;

                    //TUEN
                    Main.getCoinsAPI().removeMoney(player, amount);
                    player.getInventory().addItem(j10);


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



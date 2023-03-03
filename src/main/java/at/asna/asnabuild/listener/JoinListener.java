package at.asna.asnabuild.listener;

import at.asna.asnabuild.Main;
import at.asna.asnabuild.api.HomesAPI;
import at.asna.asnabuild.jobs.JobCompletion;
import at.asna.asnabuild.manager.LocationManager;
import at.asna.asnabuild.scoreboard.Scoreboard;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.awt.*;
import java.util.Collections;

import static at.asna.asnabuild.Main.jda;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        Main.getCoinsAPI().insertPlayer(p);
        JobCompletion.insertPlayer(p);
        //Message
        p.sendMessage("§8»§7----------§8[§aWillkommen§8]§7----------§8«");
        p.sendMessage("§7Willkommen auf §aAsna§fCode§7!");
        p.sendMessage("§7Viel Spaß!");
        p.sendMessage("§8»§7----------§8[§aWillkommen§8]§7----------§8«");

        if (Main.getInstance().getConfig().getBoolean("MuteChat") == true){
            p.sendMessage(Main.prefix + "§7Der §aMuteChat §7ist aktiviert!");
        }


        if (p.hasPermission("system.team")){
            e.setJoinMessage("§8[§a+§8] §7" + p.getDisplayName() + " §8» §aTeamler");
        } else {
            e.setJoinMessage("§8[§a+§8] §7" + p.getDisplayName());
        }



        //JoinMessage + Teleport
        if (p.hasPlayedBefore()){
            if (p.hasPermission("system.team")){
                e.setJoinMessage("§8[§a+§8] §7" + p.getDisplayName() + " §8» §aTeamler");
            } else {
                e.setJoinMessage("§8[§a+§8] §7" + p.getDisplayName());
            }
            p.teleport(LocationManager.getLocation("Spawn"));





            new BukkitRunnable() {

                @Override
                public void run() {
                    p.removePotionEffect(PotionEffectType.BLINDNESS);
                    p.removePotionEffect(PotionEffectType.SLOW);
                    p.sendMessage(Main.prefix + "§7Daten wurden §ageladen!");
                }
            }.runTaskLater(Main.getInstance(), 40L);

            new BukkitRunnable() {
                @Override
                public void run() {
                    Main.getInstance().getTabListManager().setPlayerList(p);
                    Main.getInstance().getTabListManager().setAllPlayerTeam();
                    HomesAPI.getListOfHomes(p);
                    p.sendMessage(Main.prefix + "§7Daten werden §ageladen§7...");
                    p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 5000, 2));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5000, 5));
                    for (Player online : Bukkit.getOnlinePlayers()){
                        Main.getInstance().getTabListManager().setPlayerList(online);
                    }
                }
            }.runTaskLater(Main.getInstance(), 3L);


            new Scoreboard(p);

        } else {
            if (p.hasPermission("system.team")){
                e.setJoinMessage("§8[§a+§8] §7" + p.getDisplayName() + " §8» §aTeamler");
            } else {
                e.setJoinMessage("§8[§a+§8] §7" + p.getDisplayName());
            }

            new Scoreboard(p);



            new BukkitRunnable() {

                @Override
                public void run() {
                    p.removePotionEffect(PotionEffectType.BLINDNESS);
                    p.removePotionEffect(PotionEffectType.SLOW);
                    p.sendMessage(Main.prefix + "§7Daten wurden §ageladen!");
                }
            }.runTaskLater(Main.getInstance(), 40L);

            new BukkitRunnable() {
                @Override
                public void run() {
                    ItemStack i1 = new ItemStack(Material.STONE_SWORD);
                    ItemMeta i1meta = i1.getItemMeta();
                    i1meta.setDisplayName("§8» §aSTARTER");
                    i1meta.setLore(Collections.singletonList("§7Dein Starter Kit"));
                    i1.setItemMeta(i1meta);

                    ItemStack i2 = new ItemStack(Material.STONE_AXE);
                    ItemMeta i2meta = i2.getItemMeta();
                    i2meta.setDisplayName("§8» §aSTARTER");
                    i2meta.setLore(Collections.singletonList("§7Dein Starter Kit"));
                    i2.setItemMeta(i2meta);

                    ItemStack i3 = new ItemStack(Material.STONE_PICKAXE);
                    ItemMeta i3meta = i3.getItemMeta();
                    i3meta.setDisplayName("§8» §aSTARTER");
                    i3meta.setLore(Collections.singletonList("§7Dein Starter Kit"));
                    i3.setItemMeta(i3meta);

                    ItemStack i4 = new ItemStack(Material.STONE_SHOVEL);
                    ItemMeta i4meta = i4.getItemMeta();
                    i4meta.setDisplayName("§8» §aSTARTER");
                    i4meta.setLore(Collections.singletonList("§7Dein Starter Kit"));
                    i4.setItemMeta(i4meta);

                    ItemStack i5 = new ItemStack(Material.COOKED_BEEF);
                    ItemMeta i5meta = i5.getItemMeta();
                    i5meta.setDisplayName("§8» §aSTARTER");
                    i5.setAmount(32);
                    i5meta.setLore(Collections.singletonList("§7Dein Starter Kit"));
                    i5.setItemMeta(i5meta);

                    p.getInventory().addItem(i1);
                    p.getInventory().addItem(i2);
                    p.getInventory().addItem(i3);
                    p.getInventory().addItem(i4);
                    p.getInventory().addItem(i5);

                    HomesAPI.getListOfHomes(p);
                    p.teleport(LocationManager.getLocation("Spawn"));
                    Main.getInstance().getTabListManager().setPlayerList(p);
                    Main.getInstance().getTabListManager().setAllPlayerTeam();
                    p.sendMessage(Main.prefix + "§7Daten werden §ageladen§7...");
                    p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 5000, 2));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5000, 5));
                    for (Player online : Bukkit.getOnlinePlayers()){
                        Main.getInstance().getTabListManager().setPlayerList(online);
                    }
                    int amount = 1000;

                    Main.getCoinsAPI().addMoney(p, amount);
                }
            }.runTaskLater(Main.getInstance(), 3L);
        }

    }

    @EventHandler
    public void OnQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();
        if (p.hasPermission("system.team")){
            e.setQuitMessage("§8[§c-§8] §7" + p.getDisplayName() + " §8» §aTeamler");
        } else {
            e.setQuitMessage("§8[§c-§8] §7" + p.getDisplayName());
        }
        //«»


        new BukkitRunnable() {
            @Override
            public void run() {
                Main.getInstance().getTabListManager().setPlayerList(p);
                Main.getInstance().getTabListManager().setAllPlayerTeam();
                for (Player online : Bukkit.getOnlinePlayers()){
                    Main.getInstance().getTabListManager().setPlayerList(online);
                }
            }
        }.runTaskLater(Main.getInstance(), 3L);

    }



}

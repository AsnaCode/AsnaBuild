package at.asna.asnabuild.listener;

import at.asna.asnabuild.Main;
import at.asna.asnabuild.api.HomesAPI;
import at.asna.asnabuild.manager.LocationManager;
import at.asna.asnabuild.scoreboard.Scoreboard;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collections;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        Main.getCoinsAPI().insertPlayer(p);
        //Message
        p.sendMessage("§8»§7----------§8[§eWillkommen§8]§7----------§8«");
        p.sendMessage("§7Willkommen auf §6AsnaCode§7.§6de§7!");
        p.sendMessage("§7Viel Spaß!");
        p.sendMessage("§8»§7----------§8[§eWillkommen§8]§7----------§8«");


        e.setJoinMessage("§8[§e+§8] §e" + p.getDisplayName());


        //JoinMessage + Teleport
        if (p.hasPlayedBefore()){
            e.setJoinMessage("§8[§e+§8] §e" + p.getDisplayName());
            p.teleport(LocationManager.getLocation("Spawn"));

            new BukkitRunnable() {
                @Override
                public void run() {
                    Main.getInstance().getTabListManager().setPlayerList(p);
                    Main.getInstance().getTabListManager().setAllPlayerTeam();
                    HomesAPI.getListOfHomes(p);
                }
            }.runTaskLater(Main.getInstance(), 3L);


            new Scoreboard(p);

        } else {
            e.setJoinMessage("§8[§e+§8] §e" + p.getDisplayName());

            new Scoreboard(p);

            new BukkitRunnable() {
                @Override
                public void run() {
                    HomesAPI.getListOfHomes(p);
                    p.teleport(LocationManager.getLocation("Spawn"));
                    Main.getInstance().getTabListManager().setPlayerList(p);
                    Main.getInstance().getTabListManager().setAllPlayerTeam();
                    int amount = 1000;

                    Main.getCoinsAPI().addMoney(p, amount);
                }
            }.runTaskLater(Main.getInstance(), 3L);
        }

    }

    @EventHandler
    public void OnQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();
        e.setQuitMessage("§8[§e-§8] §e" + p.getDisplayName());
        //«»
        ItemStack i1 = new ItemStack(Material.STONE_SWORD);
        ItemMeta i1meta = i1.getItemMeta();
        i1meta.setDisplayName("§8» §eSTARTER");
        i1meta.setLore(Collections.singletonList("§7Dein Starter Kit"));
        i1.setItemMeta(i1meta);

        ItemStack i2 = new ItemStack(Material.STONE_AXE);
        ItemMeta i2meta = i2.getItemMeta();
        i2meta.setDisplayName("§8» §eSTARTER");
        i2meta.setLore(Collections.singletonList("§7Dein Starter Kit"));
        i2.setItemMeta(i2meta);

        ItemStack i3 = new ItemStack(Material.STONE_PICKAXE);
        ItemMeta i3meta = i3.getItemMeta();
        i3meta.setDisplayName("§8» §eSTARTER");
        i3meta.setLore(Collections.singletonList("§7Dein Starter Kit"));
        i3.setItemMeta(i3meta);

        ItemStack i4 = new ItemStack(Material.STONE_SHOVEL);
        ItemMeta i4meta = i4.getItemMeta();
        i4meta.setDisplayName("§8» §eSTARTER");
        i4meta.setLore(Collections.singletonList("§7Dein Starter Kit"));
        i4.setItemMeta(i4meta);

        ItemStack i5 = new ItemStack(Material.COOKED_BEEF);
        ItemMeta i5meta = i5.getItemMeta();
        i5meta.setDisplayName("§8» §eSTARTER");
        i5.setAmount(32);
        i5meta.setLore(Collections.singletonList("§7Dein Starter Kit"));
        i5.setItemMeta(i5meta);

        new BukkitRunnable() {
            @Override
            public void run() {
                Main.getInstance().getTabListManager().setPlayerList(p);
                Main.getInstance().getTabListManager().setAllPlayerTeam();
            }
        }.runTaskLater(Main.getInstance(), 3L);

    }

}

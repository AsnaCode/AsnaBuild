package at.asna.asnabuild.jobs;

import at.asna.asnabuild.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class JobCompletion implements Listener {

    public static Map<UUID, String> jobMap = new HashMap<>();
    private static YamlConfiguration configuration;

    public enum Job {
        MINER,
        LUMBERJACK,
        NONE
    }

    public static Job getJob(UUID uuid) {
        return Job.valueOf(jobMap.get(uuid).toUpperCase());
    }

    public static void setJob(UUID uuid, Job job) {
        jobMap.put(uuid, job.toString());
    }

    public static void setJobCompletion(JavaPlugin plugin) {
        if (!new File(plugin.getDataFolder() + "/" + "jobs.yml").exists()) {
            plugin.saveResource("jobs.yml", false);
        }
        jobMap = getJobData(plugin);
    }

    protected static Map<UUID, String> getJobData(JavaPlugin plugin) {
        Map<UUID, String> data = new HashMap<>();
        configuration = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder() + "/" + "jobs.yml"));

        ConfigurationSection section = configuration.getConfigurationSection("jobs");

        for (String uuid : section.getKeys(false)) {
            data.put(UUID.fromString(uuid), configuration.getString("jobs." + uuid + ".job"));
        }
        return data;
    }


    public static void saveConfiguration(JavaPlugin plugin) throws IOException {

        for (UUID uuid : jobMap.keySet()) {
            configuration.set("jobs." + uuid.toString() + ".job", jobMap.get(uuid));
        }
        configuration.save(new File(plugin.getDataFolder() + "/" + "jobs.yml"));
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getClickedInventory() == null) return;
        if (event.getView().getTopInventory().getHolder() instanceof JobUI) {
            event.setCancelled(true);
            ((JobUI) event.getClickedInventory().getHolder()).onClick(event.getCurrentItem(), event.getSlot(), event.getClick());
        }
    }

    @EventHandler
    public void onBlockDestroy(BlockBreakEvent event) {
        //Lumberjack stuff
        List<Material> lumberJack = new ArrayList<>();
        lumberJack.add(Material.OAK_LOG);
        lumberJack.add(Material.BIRCH_LOG);
        lumberJack.add(Material.ACACIA_LOG);
        lumberJack.add(Material.DARK_OAK_LOG);
        lumberJack.add(Material.JUNGLE_LOG);
        lumberJack.add(Material.MANGROVE_LOG);

        //Minerstuff
        List<Material> miner = new ArrayList<>();
        miner.add(Material.COAL_ORE);
        miner.add(Material.IRON_ORE);
        miner.add(Material.GOLD_ORE);
        miner.add(Material.DIAMOND_ORE);
        miner.add(Material.REDSTONE_ORE);
        miner.add(Material.COPPER_ORE);
        miner.add(Material.LAPIS_ORE);
        miner.add(Material.DEEPSLATE_COAL_ORE);
        miner.add(Material.DEEPSLATE_IRON_ORE);
        miner.add(Material.DEEPSLATE_GOLD_ORE);
        miner.add(Material.DEEPSLATE_DIAMOND_ORE);
        miner.add(Material.DEEPSLATE_REDSTONE_ORE);
        miner.add(Material.DEEPSLATE_COPPER_ORE);
        miner.add(Material.DEEPSLATE_LAPIS_ORE);

        if (event.getBlock().getLocation().getWorld().getName().equals("world")) {
            Sound sound = Sound.ENTITY_EXPERIENCE_ORB_PICKUP;
            switch (getJob(event.getPlayer().getUniqueId())) {
                case LUMBERJACK: {
                    if (lumberJack.contains(event.getBlock().getType())) {
                        event.getPlayer().playSound(event.getPlayer().getLocation(), sound, 20, 0);
                        Main.getCoinsAPI().addMoney(event.getPlayer(), 2);
                        event.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§7+§a2€"));
                    }
                }
                case MINER: {
                    if (miner.contains(event.getBlock().getType())) {
                        event.getPlayer().playSound(event.getPlayer().getLocation(), sound, 20, 0);
                        Main.getCoinsAPI().addMoney(event.getPlayer(), 3);
                        event.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§7+§a3€"));
                    }
                }
            }
        }



    }

    public static void insertPlayer(Player player) {
        if (!jobMap.containsKey(player.getUniqueId())) {
            jobMap.put(player.getUniqueId(), Job.NONE.toString());
        }
    }




}
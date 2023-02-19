package at.asna.asnabuild.daily;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.TimeUnit;

public class DailyListener implements Listener {
    private final DailyCooldown cooldownManager = new DailyCooldown();

    private final Plugin plugin;

    public DailyListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnClick01(InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        try {
            if (e.getView().getTitle() == "§8» §6Daily §8«")
                try {
                    if (e.getCurrentItem().getType() == Material.PRISMARINE_SHARD &&
                            e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Hol es dir ab")) {
                        int timeLeft = this.cooldownManager.getCooldown(p.getUniqueId());
                        if (timeLeft == 0) {
                            ItemStack i1 = new ItemStack(Material.DIAMOND);
                            ItemMeta i1meta = i1.getItemMeta();
                            i1.setAmount(5);
                            i1.setItemMeta(i1meta);
                            p.playSound(p.getLocation(), Sound.ENTITY_AXOLOTL_ATTACK, 2.0F, 1.0F);
                            p.getInventory().addItem(i1);
                            int amount = 500;

                            Main.getCoinsAPI().addMoney(p, amount);
                            p.sendMessage(Main.prefix + "§7Du hast deine §eTäglichen Belohungen §7abgeholt!");
                            this.cooldownManager.setCooldown(p.getUniqueId(), 86400);
                            (new BukkitRunnable() {
                                public void run() {
                                    int timeLeft = DailyListener.this.cooldownManager.getCooldown(p.getUniqueId());
                                    DailyListener.this.cooldownManager.setCooldown(p.getUniqueId(), --timeLeft);
                                    if (timeLeft == 0)
                                        cancel();
                                }
                            }).runTaskTimer(this.plugin, 20L, 20L);
                        } else {
                            p.sendMessage(Main.prefix + "§7Du musst noch §e" + TimeUnit.SECONDS.toHours(timeLeft) + " §eStunden §7warten!");
                        }
                    }
                    p.closeInventory();
                } catch (Exception exception) {}
        } catch (Exception exception) {}
    }
}


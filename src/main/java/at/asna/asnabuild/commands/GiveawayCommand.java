package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class GiveawayCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player p = (Player) sender;
            if (p.hasPermission("system.giveaway")) {
                ItemStack item = p.getInventory().getItemInMainHand();
                Player randomPlayer = Bukkit.getOnlinePlayers().stream().toList().get(new Random().nextInt(Bukkit.getOnlinePlayers().size()));

                AtomicInteger timer = new AtomicInteger(30);

                Bukkit.getScheduler().runTaskTimer(Main.getInstance(), (angelinaaaaasssTask) -> {
                    if (timer.get() == 30) {
                        //Send Title
                        for (Player online : Bukkit.getOnlinePlayers()) {
                            online.sendTitle("§8§l»§a§lGiveaway§8§l«", "§e30 Sekunden!");
                            online.playSound(online.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2F, 1F);
                        }
                    } else if (timer.get() == 15) {
                        for (Player online : Bukkit.getOnlinePlayers()) {
                            online.sendTitle("§8§l»§a§lGiveaway§8§l«", "§e15 Sekunden");
                            //«»
                        }
                    } else if (timer.get() == 10) {
                        for (Player online : Bukkit.getOnlinePlayers()) {
                            online.sendTitle("§8§l»§a§lGiveaway§8§l«", "§e10 Sekunden");
                        }
                    } else if (timer.get() == 5) {
                        for (Player online : Bukkit.getOnlinePlayers()) {
                            online.sendTitle("§8§l»§a§lGiveaway§8§l«", "§e5 Sekunden");
                        }
                    } else if (timer.get() == 4) {
                        for (Player online : Bukkit.getOnlinePlayers()) {
                            online.sendTitle("§8§l»§a§lGiveaway§8§l«", "§e4 Sekunden");
                        }
                    } else if (timer.get() == 3) {
                        for (Player online : Bukkit.getOnlinePlayers()) {
                            online.sendTitle("§8§l»§a§lGiveaway§8§l«", "§e3 Sekunden");
                        }
                    } else if (timer.get() == 2) {
                        for (Player online : Bukkit.getOnlinePlayers()) {
                            online.sendTitle("§8§l»§a§lGiveaway§8§l«", "§e2 Sekunden");
                        }
                    } else if (timer.get() == 1) {
                        for (Player online : Bukkit.getOnlinePlayers()) {
                            online.sendTitle("§8§l»§a§lGiveaway§8§l«", "§e1 Sekunden");
                        }
                    }
                    if (timer.get() == 0) {
                        angelinaaaaasssTask.cancel();
                            randomPlayer.getInventory().addItem(item);


                        for (Player online : Bukkit.getOnlinePlayers()) {
                            online.sendTitle("§8§l»§a§lGewinner§8§l«", "§e" + randomPlayer.getDisplayName());
                            online.playSound(online.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2F, 1F);
                        }
                        Bukkit.broadcastMessage("§7§m----------§8[§eGiveaway§8]§7§m----------");
                        Bukkit.broadcastMessage("§7 ");
                        Bukkit.broadcastMessage("§7Gewinner: §e" + randomPlayer.getDisplayName());
                        Bukkit.broadcastMessage("§7Preis: §e" + item.getAmount() + "x " + item.getType().toString().toLowerCase().replace("_", " ").replace(".", " "));
                        Bukkit.broadcastMessage("§7Ersteller: §e" + ((Player) sender).getDisplayName());
                        Bukkit.broadcastMessage("§e ");
                        Bukkit.broadcastMessage("§7§m----------§8[§eGiveaway§8]§7§m----------");
                    }
                    timer.getAndDecrement();
                }, 0, 20);
            }
        return true;
        }


    }


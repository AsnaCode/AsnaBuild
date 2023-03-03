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
                            online.sendTitle("§8§l»§a§lGiveaway§8§l«", "§a30 Sekunden!");
                            online.playSound(online.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2F, 1F);
                        }
                    } else if (timer.get() == 15) {
                        for (Player online : Bukkit.getOnlinePlayers()) {
                            online.sendTitle("§8§l»§a§lGiveaway§8§l«", "§715 Sekunden");
                            //«»
                        }
                    } else if (timer.get() == 10) {
                        for (Player online : Bukkit.getOnlinePlayers()) {
                            online.sendTitle("§8§l»§a§lGiveaway§8§l«", "§710 Sekunden");
                        }
                    } else if (timer.get() == 5) {
                        for (Player online : Bukkit.getOnlinePlayers()) {
                            online.sendTitle("§8§l»§a§lGiveaway§8§l«", "§75 Sekunden");
                        }
                    } else if (timer.get() == 4) {
                        for (Player online : Bukkit.getOnlinePlayers()) {
                            online.sendTitle("§8§l»§a§lGiveaway§8§l«", "§74 Sekunden");
                        }
                    } else if (timer.get() == 3) {
                        for (Player online : Bukkit.getOnlinePlayers()) {
                            online.sendTitle("§8§l»§a§lGiveaway§8§l«", "§73 Sekunden");
                        }
                    } else if (timer.get() == 2) {
                        for (Player online : Bukkit.getOnlinePlayers()) {
                            online.sendTitle("§8§l»§a§lGiveaway§8§l«", "§72 Sekunden");
                        }
                    } else if (timer.get() == 1) {
                        for (Player online : Bukkit.getOnlinePlayers()) {
                            online.sendTitle("§8§l»§a§lGiveaway§8§l«", "§71 Sekunden");
                        }
                    }
                    if (timer.get() == 0) {
                        angelinaaaaasssTask.cancel();
                            randomPlayer.getInventory().addItem(item);


                        for (Player online : Bukkit.getOnlinePlayers()) {
                            online.sendTitle("§8§l»§a§lGewinner§8§l«", "§a" + randomPlayer.getDisplayName());
                            online.playSound(online.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2F, 1F);
                        }
                        Bukkit.broadcastMessage("§7§m----------§8[§aGive§faway§8]§7§m----------");
                        Bukkit.broadcastMessage("§7 ");
                        Bukkit.broadcastMessage("§7Gewinner: §a" + randomPlayer.getDisplayName());
                        Bukkit.broadcastMessage("§7Preis: §a" + item.getAmount() + "x " + item.getType().toString().toLowerCase().replace("_", " ").replace(".", " "));
                        Bukkit.broadcastMessage("§7Ersteller: §a" + ((Player) sender).getDisplayName());
                        Bukkit.broadcastMessage("§a ");
                        Bukkit.broadcastMessage("§7§m----------§8[§aGive§faway§8]§7§m----------");
                    }
                    timer.getAndDecrement();
                }, 0, 20);
            }
        return true;
        }


    }


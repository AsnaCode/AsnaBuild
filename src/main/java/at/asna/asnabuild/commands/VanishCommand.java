package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class VanishCommand implements CommandExecutor {
    public static ArrayList<Player> hide = new ArrayList<>();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("system.vanish")) {
            if (args.length == 0) {
                if (!hide.contains(p)) {
                    hide.add(p);
                    for (Player all : Bukkit.getOnlinePlayers())
                        if (!all.hasPermission("system.vanish.see")) {
                            all.hidePlayer(p);
                        } else {
                            all.showPlayer(p);
                            all.canSee(p);
                        }
                    if (p.hasPermission("system.team")) {
                        Bukkit.broadcastMessage("§8[§c-§8] §7" + p.getDisplayName() + " §8» §aTeamler");
                    } else {
                        Bukkit.broadcastMessage("§8[§c-§8] §7" + p.getDisplayName());
                    }
                        p.sendMessage(Main.prefix + "§7Du bist nun unsichtbar!");
                        p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 100000, 2));


                    } else{
                        hide.remove(p);
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            all.showPlayer(p);
                            all.canSee(p);

                        }
                        p.sendMessage(Main.prefix + "§7Du bist nun sichtbar!");
                        p.removePotionEffect(PotionEffectType.INVISIBILITY);
                        if (p.hasPermission("system.team")) {
                            Bukkit.broadcastMessage("§8[§a+§8] §7" + p.getDisplayName() + " §8» §aTeamler");
                        } else {
                            Bukkit.broadcastMessage("§8[§a+§8] §7" + p.getDisplayName());
                        }
                    }
                } else if (args.length == 1) {
                    Player opfer = Bukkit.getPlayer(args[0]);
                    try {
                        if (!hide.contains(opfer)) {
                            for (Player all : Bukkit.getOnlinePlayers())
                                all.hidePlayer(opfer);
                            opfer.sendMessage(Main.prefix + "§7Du bist nun unsichtbar!");
                            p.sendMessage(Main.prefix + "§7Du hast den Spieler §a" + opfer.getDisplayName() + " §7unsichtbar gemacht!");
                        } else {
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                all.showPlayer(opfer);
                                all.canSee(opfer);
                            }
                            opfer.sendMessage(Main.prefix + "§7Du bist nun sichtbar!");
                            p.sendMessage(Main.prefix + "§7Du hast den Spieler §a" + opfer.getDisplayName() + " §7sichtbar gemacht!");
                        }
                    } catch (Exception e1) {
                        p.sendMessage(Main.notonline);
                    }
                } else {
                    p.sendMessage(Main.prefix + "§7Verwendung: §a/Vanish <name>");
                }
            } else {
                p.sendMessage(Main.noperm);
            }

            return false;
        }
    }


package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;


            if (p.hasPermission("system.fly")){
                if (args.length == 0){
                    if (p.getAllowFlight()){
                        p.setAllowFlight(false);
                        p.sendMessage(Main.prefix + "§7Du kannst nun nicht mehr §aFliegen§7!");
                    } else {
                        p.setAllowFlight(true);
                        p.sendMessage(Main.prefix + "§7Du kannst nun §aFliegen§7!");
                    }
                } else if (args.length == 1) {
                    if (p.hasPermission("system.fly.other")){
                        Player opfer = Bukkit.getPlayer(args[0]);
                        if (opfer != null){
                            if (opfer.getAllowFlight()){
                                opfer.setAllowFlight(false);
                                opfer.sendMessage(Main.prefix + "§7Du kannst nun nicht mehr §aFliegen§7!");
                                p.sendMessage(Main.prefix + "§7Der Spieler §a" + opfer.getDisplayName() + " §7kann nun nicht mehr §aFliegen§7!");
                            } else {
                                opfer.setAllowFlight(true);
                                opfer.sendMessage(Main.prefix + "§7Du kannst nun §aFliegen§7!");
                                p.sendMessage(Main.prefix + "§7Der Spieler §a" + opfer.getDisplayName() + " §7kann nun §aFliegen§7!");
                            }
                        } else {
                            p.sendMessage(Main.notonline);
                        }
                    } else {
                        p.sendMessage(Main.noperm);
                    }
                } else if (args.length > 1) {
                    p.sendMessage(Main.prefix + "§7Verwendung: §a/Fly <name>");
                }
            } else {
                p.sendMessage(Main.noperm);
            }
        return false;
        }



    }


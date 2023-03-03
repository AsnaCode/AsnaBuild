package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TpaCommand implements CommandExecutor {

    Map<Player, Player> requests = new ConcurrentHashMap<>();


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            switch (label) {
                case "tpa": {
                    if (args.length == 1) {
                        if (!player.getDisplayName().equalsIgnoreCase(args[0])) {
                            if (Bukkit.getPlayer(args[0]) != null) {
                                Player target = Bukkit.getPlayer(args[0]);

                                player.sendMessage(Main.prefix + String.format("Du hast §a%s §7eine Teleportanfrage geschickt!", target.getDisplayName()));
                                target.sendMessage(Main.prefix + String.format("§a%s §7hat dir eine Teleportanfrage geschickt!", player.getDisplayName()));
                                target.sendMessage(Main.prefix + "§7Nehme sie mit §a/tpaaccept §7an!");

                                requests.put(player, target);
                            } else {
                                player.sendMessage(Main.prefix + String.format("%s ist nicht online oder wurde nicht gefunden", args[0]));
                            }
                        } else {
                            player.sendMessage(Main.prefix + "Du kannst dir nicht selber eine Anfrage schicken!");
                        }
                    } else {
                        player.sendMessage(Main.prefix + "Bitte benutze /tpa <Spielername>");
                    }
                    break;
                }
                case "tpaaccept":{
                    if (requests.containsValue(player)) {
                        player.sendMessage(Main.prefix + "Du hast die Anfrage akzeptiert");
                        for (Map.Entry<Player, Player> entry : requests.entrySet()) {
                            if (entry.getValue().equals(player)) {
                                entry.getKey().teleportAsync(entry.getValue().getLocation());
                                requests.remove(entry.getKey());
                                break;
                            }
                        }
                    }
                    break;
                }
            }



        }
        return true;
    }
}
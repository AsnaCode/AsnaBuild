package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player p = (Player) sender;

        if (p.hasPermission("system.gamemode")){
            if (args.length == 1){
                if (args[0].equals("0")){
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(Main.prefix + "§7Du bist nun im §aSurvival §7Modus!");
                } else if (args[0].equals("1")) {
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(Main.prefix + "§7Du bist nun im §aKreativ §7Modus!");
                } else if (args[0].equals("2")) {
                    p.setGameMode(GameMode.ADVENTURE);
                    p.sendMessage(Main.prefix + "§7Du bist nun im §aAbenteuer §7Modus");
                } else if (args[0].equals("3")){
                    p.setGameMode(GameMode.SPECTATOR);
                    p.sendMessage(Main.prefix + "§7Du bist nun im §aZuschauer §7Modus!");
                }
            } else if (args.length < 1) {
                p.sendMessage(Main.prefix + "§7Verwendung: §a/Gamemode <name> <0;1;2;3>");
            } else if (args.length == 2) {
                if (p.hasPermission("system.gamemode.other")){
                    Player opfer = Bukkit.getPlayer(args[1]);
                    if (opfer != null){
                        if (args[0].equals("0")){
                            opfer.setGameMode(GameMode.SURVIVAL);
                            opfer.sendMessage(Main.prefix + "§7Du bist nun im §aSurvival §7Modus!");
                            p.sendMessage(Main.prefix + "§7Du hast den Spieler §a" + opfer.getDisplayName() + " §7in den §aSurvival §7Modus gesteckt!");
                        } else if (args[0].equals("1")) {
                            opfer.setGameMode(GameMode.CREATIVE);
                            opfer.sendMessage(Main.prefix + "§7Du bist nun im §aKreativ §7Modus!");
                            p.sendMessage(Main.prefix + "§7Du hast den Spieler §a" + opfer.getDisplayName() + " §7in den §aKreativ §7Modus gesteckt!");
                        } else if (args[0].equals("2")) {
                            opfer.setGameMode(GameMode.ADVENTURE);
                            opfer.sendMessage(Main.prefix + "§7Du bist nun im §aAbenteuer §7Modus!");
                            p.sendMessage(Main.prefix + "§7Du hast den Spieler §a" + opfer.getDisplayName() + " §7in den §aAbenteuer §7Modus gesteckt!");
                        } else if (args[0].equals("3")) {
                            opfer.setGameMode(GameMode.SPECTATOR);
                            opfer.sendMessage(Main.prefix + "§7Du bist nun im §aZuschauer §7Modus!");
                            p.sendMessage(Main.prefix + "§7Du hast den Spieler §a" + opfer.getDisplayName() + " §7in den §aZuschauer §7Modus gesteckt!");
                        }
                    } else {
                        p.sendMessage(Main.notonline);
                    }
                    } else {
                        p.sendMessage(Main.noperm);
                    }

                }

        } else {
            p.sendMessage(Main.noperm);
        }


        return false;
    }
}

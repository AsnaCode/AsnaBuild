package at.asna.asnabuild.moderation;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class TempBanCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;

        if (sender.hasPermission("system.tempban")){
            long t;
            if (args.length < 2) {
                sender.sendMessage(Main.prefix + "§7Verwendung: §a/Tempban <name> <dauer: §2d/h/m§a> <grund>");
                return false;
            }

            String d = args[1];
            String tp = d.substring(0, d.length() - 1);
            char suf = d.charAt(d.length() - 1);
            try {
                t = Integer.parseInt(tp);
            } catch (NumberFormatException ignored){
                sender.sendMessage(Main.prefix + "§cUngültige Dauer!");
                return true;
            }
            if (t <= 0){
                sender.sendMessage(Main.prefix + "§cUngültige Dauer!");
                return true;
            }
            switch (Character.toLowerCase(suf)){
                case 'd':
                    t *= 24L;
                case 'h':
                    t *= 60L;
                case 'm':
                    t *= 60L;
                    break;
                default:
                    sender.sendMessage(Main.prefix + "§cUngültige Dauer!");
                    return true;
            }
            Date date = Date.from(Instant.now().plus(t, ChronoUnit.SECONDS));
            OfflinePlayer player = Bukkit.getOfflinePlayerIfCached(args[0]);
            if (player == null){
                sender.sendMessage(Main.notonline);
                return true;
            }
            String reason = (args.length == 2) ? null : String.join(" ", Arrays.<CharSequence>copyOfRange((CharSequence[])args, 2, args.length));
            player.banPlayer(reason, date, sender.getName(), true);
            if (reason == null){
                for (Player teamler : Bukkit.getOnlinePlayers())
                    if (teamler.hasPermission("system.team")){
                        teamler.sendMessage("§7§m----------§8[§aBAN§8]§7§m----------");
                        teamler.sendMessage("§7Spieler: §a" + player.getName());
                        teamler.sendMessage("§7Von: §a" + p.getDisplayName());
                        teamler.sendMessage("§7Grund: §a/");
                        teamler.sendMessage("§7Dauer: §a%s".formatted(new Object[] {date}));
                        teamler.sendMessage("§7§m----------§8[§aBAN§8]§7§m----------");

                    }
            } else {
                for (Player teamler : Bukkit.getOnlinePlayers())
                    if (teamler.hasPermission("system.team")){
                        teamler.sendMessage("§7§m----------§8[§aBAN§8]§7§m----------");
                        teamler.sendMessage("§7Spieler: §a" + player.getName());
                        teamler.sendMessage("§7Von: §a" + p.getDisplayName());
                        teamler.sendMessage("§7Grund: §a%s".formatted(new Object[] {reason}));
                        teamler.sendMessage("§7Dauer: §a%s".formatted(new Object[] {date}));
                        teamler.sendMessage("§7§m----------§8[§aBAN§8]§7§m----------");

                    }
            }


        } else {
            sender.sendMessage(Main.noperm);
        }



        return true;
    }

    @Nullable
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length != 1)
            return null;
        return Arrays.<OfflinePlayer>stream(Bukkit.getOfflinePlayers())
                .filter(p -> p.getName().toLowerCase().startsWith(args[0].toLowerCase()))
                .sorted(Comparator.comparingLong(OfflinePlayer::getLastSeen).reversed()).map(OfflinePlayer::getName)
                .toList();
    }
}

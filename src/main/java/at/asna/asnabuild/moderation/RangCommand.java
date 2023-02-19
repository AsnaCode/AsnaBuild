package at.asna.asnabuild.moderation;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RangCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("system.admin")){
            if (args.length == 0){
                p.sendMessage(Main.prefix + "§7Verwendung: §e/Rang <name> <rang>");
            } else if (args.length == 1){
                p.sendMessage(Main.prefix + "§7Verwendung: §e/Rang <name> <rang>");
            } else if (args.length == 2){
                Player opfer = Bukkit.getPlayer(args[0]);

                if (args[1].equals("premium")){
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + opfer.getDisplayName() + " parent set premium");
                    opfer.kickPlayer("§6§LRANG UPGRADE");
                    p.sendMessage(Main.prefix + "§7Du hast erfolgreich den Spieler §e" + opfer.getDisplayName() + " §7den §e" + args[1] + " §7Rang gegeben!");
                } else if (args[1].equals("asna")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + opfer.getDisplayName() + " parent set asna");
                    opfer.kickPlayer("§6§LRANG UPGRADE");
                    p.sendMessage(Main.prefix + "§7Du hast erfolgreich den Spieler §e" + opfer.getDisplayName() + " §7den §e" + args[1] + " §7Rang gegeben!");
                } else if (args[1].equals("supporter")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + opfer.getDisplayName() + " parent set supporter");
                    opfer.kickPlayer("§6§LRANG UPGRADE");
                    p.sendMessage(Main.prefix + "§7Du hast erfolgreich den Spieler §e" + opfer.getDisplayName() + " §7den §e" + args[1] + " §7Rang gegeben!");
                } else if (args[1].equals("builder")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + opfer.getDisplayName() + " parent set builder");
                    opfer.kickPlayer("§6§LRANG UPGRADE");
                    p.sendMessage(Main.prefix + "§7Du hast erfolgreich den Spieler §e" + opfer.getDisplayName() + " §7den §e" + args[1] + " §7Rang gegeben!");
                } else if (args[1].equals("moderator")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + opfer.getDisplayName() + " parent set moderator");
                    opfer.kickPlayer("§6§LRANG UPGRADE");
                    p.sendMessage(Main.prefix + "§7Du hast erfolgreich den Spieler §e" + opfer.getDisplayName() + " §7den §e" + args[1] + " §7Rang gegeben!");
                } else if (args[1].equals("developer")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + opfer.getDisplayName() + " parent set developer");
                    opfer.kickPlayer("§6§LRANG UPGRADE");
                    p.sendMessage(Main.prefix + "§7Du hast erfolgreich den Spieler §e" + opfer.getDisplayName() + " §7den §e" + args[1] + " §7Rang gegeben!");
                } else if (args[1].equals("admin")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + opfer.getDisplayName() + " parent set admin");
                    opfer.kickPlayer("§6§LRANG UPGRADE");
                    p.sendMessage(Main.prefix + "§7Du hast erfolgreich den Spieler §e" + opfer.getDisplayName() + " §7den §e" + args[1] + " §7Rang gegeben!");
                }
            } else {
                p.sendMessage(Main.prefix + "§7Verwendung: §e/Rang <name> <rang>");
            }
        } else {
            p.sendMessage(Main.noperm);
        }

        return false;
    }
}

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

        if (p.hasPermission("system.rang")){
            if (args.length == 0){
                p.sendMessage(Main.prefix + "§7Verwendung: §a/Rang <name/list> <rang>");
            } else if (args.length == 1){
                if (args[0].equals("list")) {
                    p.sendMessage("§7§m----------§8[§aRänge§8]§7§m----------");
                    p.sendMessage("§7 ");
                    p.sendMessage("§4Admin §8» §aBesitzer/in des Servers!");
                    p.sendMessage("§eManager §8» §aManager des Servers!");
                    p.sendMessage("§bDeveloper §8» §aEinstellen/Coding vom Server!");
                    p.sendMessage("§cModerator §8» §aSupport & Strafe verteilung");
                    p.sendMessage("§2Builder §8» §aBaut Spawn etc...!");
                    p.sendMessage("§9Supporter §8» §aSupportet!");
                    p.sendMessage("§5Creator §8» §aIst im Social vertreten!");
                    p.sendMessage("§fAsna §8» §a500.000€");
                    p.sendMessage("§6Premium §8» §a100.000€");
                    p.sendMessage("§eSpieler §8» §aStandard Rang!");
                    p.sendMessage("§a ");
                    p.sendMessage("§7§m----------§8[§aRänge§8]§7§m----------");
                } else {
                    p.sendMessage(Main.prefix + "§7Verwendung: §a/Rang <name/list> <rang>");
                }

            } else if (args.length == 2){
                Player opfer = Bukkit.getPlayer(args[0]);

                if (args[1].equals("premium")){
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + opfer.getDisplayName() + " parent set premium");
                    opfer.kickPlayer("§6§LRANG UPGRADE\n§6Premium");
                    p.sendMessage(Main.prefix + "§7Du hast erfolgreich den Spieler §a" + opfer.getDisplayName() + " §7den §a" + args[1] + " §7Rang gegeben!");
                } else if (args[1].equals("asna")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + opfer.getDisplayName() + " parent set asna");
                    opfer.kickPlayer("§6§LRANG UPGRADE\n§fAsna");
                    p.sendMessage(Main.prefix + "§7Du hast erfolgreich den Spieler §a" + opfer.getDisplayName() + " §7den §a" + args[1] + " §7Rang gegeben!");
                } else if (args[1].equals("creator")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + opfer.getDisplayName() + " parent set creator");
                    opfer.kickPlayer("§6§LRANG UPGRADE\n§6Creator");
                    p.sendMessage(Main.prefix + "§7Du hast erfolgreich den Spieler §a" + opfer.getDisplayName() + " §7den §a" + args[1] + " §7Rang gegeben!");
                } else if (args[1].equals("supporter")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + opfer.getDisplayName() + " parent set supporter");
                    opfer.kickPlayer("§6§LRANG UPGRADE\n§9Supporter");
                    p.sendMessage(Main.prefix + "§7Du hast erfolgreich den Spieler §a" + opfer.getDisplayName() + " §7den §a" + args[1] + " §7Rang gegeben!");
                } else if (args[1].equals("builder")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + opfer.getDisplayName() + " parent set builder");
                    opfer.kickPlayer("§6§LRANG UPGRADE\n§2Builder");
                    p.sendMessage(Main.prefix + "§7Du hast erfolgreich den Spieler §a" + opfer.getDisplayName() + " §7den §a" + args[1] + " §7Rang gegeben!");
                } else if (args[1].equals("moderator")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + opfer.getDisplayName() + " parent set moderator");
                    opfer.kickPlayer("§6§LRANG UPGRADE\n§cModerator");
                    p.sendMessage(Main.prefix + "§7Du hast erfolgreich den Spieler §a" + opfer.getDisplayName() + " §7den §a" + args[1] + " §7Rang gegeben!");
                } else if (args[1].equals("developer")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + opfer.getDisplayName() + " parent set developer");
                    opfer.kickPlayer("§6§LRANG UPGRADE\n§bDeveloper");
                    p.sendMessage(Main.prefix + "§7Du hast erfolgreich den Spieler §a" + opfer.getDisplayName() + " §7den §a" + args[1] + " §7Rang gegeben!");
                } else if (args[1].equals("admin")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + opfer.getDisplayName() + " parent set admin");
                    opfer.kickPlayer("§6§LRANG UPGRADE\n§4Admin");
                    p.sendMessage(Main.prefix + "§7Du hast erfolgreich den Spieler §a" + opfer.getDisplayName() + " §7den §a" + args[1] + " §7Rang gegeben!");
                } else if (args[1].equals("manager")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + opfer.getDisplayName() + " parent set manager");
                    opfer.kickPlayer("§6§LRANG UPGRADE\n§eManager");
                    p.sendMessage(Main.prefix + "§7Du hast erfolgreich den Spieler §a" + opfer.getDisplayName() + " §7den §a" + args[1] + " §7Rang gegeben!");
                } else if (args[1].equals("spieler")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + opfer.getDisplayName() + " parent set default");
                    opfer.kickPlayer("§6§LRANG UPGRADE\n§aSpieler");
                    p.sendMessage(Main.prefix + "§7Du hast erfolgreich den Spieler §a" + opfer.getDisplayName() + " §7den §a" + args[1] + " §7Rang gegeben!");
                } else {
                    p.sendMessage(Main.prefix + "§7Verwendung: §a/Rang <name/list> <rang>");
                }
            }
        } else {
            p.sendMessage(Main.noperm);
        }

        return false;
    }
}

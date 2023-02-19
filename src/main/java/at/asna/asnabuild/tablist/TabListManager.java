package at.asna.asnabuild.tablist;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TabListManager {
    public void setPlayerList(Player player) {
        player.setPlayerListHeaderFooter("          §8» §6AsnaCode§7.§6de §8«           \n    §7", "  §7\n          §7Made with §cLove §7by §eAsna §7and §eRelease          ");
    }
    //«»

    public void setAllPlayerTeam() {
        Bukkit.getOnlinePlayers().forEach(this::setPlayerTeam);
    }

    public void setPlayerTeam(Player player) {
        Scoreboard scoreboard = player.getScoreboard();
        Team spieler = scoreboard.getTeam("009spieler");
        if (spieler == null)
            spieler = scoreboard.registerNewTeam("009spieler");
        Team premium = scoreboard.getTeam("008premium");
        if (premium == null)
            premium = scoreboard.registerNewTeam("008premium");
        Team asna = scoreboard.getTeam("007asna");
        if (asna == null)
            asna = scoreboard.registerNewTeam("007asna");
        Team creator = scoreboard.getTeam("006creator");
        if (creator == null)
            creator = scoreboard.registerNewTeam("006creator");
        Team supporter = scoreboard.getTeam("005supporter");
        if (supporter == null)
            supporter = scoreboard.registerNewTeam("005supporter");
        Team builder = scoreboard.getTeam("004builder");
        if (builder == null)
            builder = scoreboard.registerNewTeam("004builder");
        Team moderator = scoreboard.getTeam("003moderator");
        if (moderator == null)
            moderator = scoreboard.registerNewTeam("003moderator");
        Team developer = scoreboard.getTeam("002developer");
        if (developer == null)
            developer = scoreboard.registerNewTeam("002developer");
        Team admin = scoreboard.getTeam("001admin");
        if (admin == null)
            admin = scoreboard.registerNewTeam("001admin");
        spieler.setPrefix("§e");
                spieler.setColor(ChatColor.YELLOW);
        premium.setPrefix("§6Premium §8• §6");
                premium.setColor(ChatColor.GOLD);
        asna.setPrefix("§fAsna §8• §f");
                asna.setColor(ChatColor.WHITE);
        creator.setPrefix("§5Social §8• §5");
                creator.setColor(ChatColor.DARK_RED);
        supporter.setPrefix("§9Supporter §8• §9");
                supporter.setColor(ChatColor.BLUE);
        moderator.setPrefix("§cModerator §8• §c");
                moderator.setColor(ChatColor.RED);
        developer.setPrefix("§bDeveloper §8• §b");
                developer.setColor(ChatColor.AQUA);
        admin.setPrefix("§4Admin §8• §9");
                admin.setColor(ChatColor.DARK_RED);
        for (Player target : Bukkit.getOnlinePlayers()) {
            if (target.hasPermission("system.admin")) {
                admin.addEntry(target.getName());
                continue;
            }
            if (target.hasPermission("system.developer")) {
                developer.addEntry(target.getName());
                continue;
            }
            if (target.hasPermission("system.moderator")) {
                moderator.addEntry(target.getName());
                continue;
            }
            if (target.hasPermission("system.builder")) {
                builder.addEntry(target.getName());
                continue;
            }
            if (target.hasPermission("system.supporter")) {
                supporter.addEntry(target.getName());
                continue;
            }
            if (target.hasPermission("system.creator")) {
                creator.addEntry(target.getName());
                continue;
            }
            if (target.hasPermission("system.asna")) {
                asna.addEntry(target.getName());
                continue;
            }
            if (target.hasPermission("system.premium")) {
                premium.addEntry(target.getName());
                continue;
            }
            spieler.addEntry(target.getName());
        }
    }
}

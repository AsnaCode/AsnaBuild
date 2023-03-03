package at.asna.asnabuild.tablist;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TabListManager {
    public void setPlayerList(Player player) {
        player.setPlayerListHeaderFooter("          §8» §aAsna§fCode §8«           \n    §7", "  §7\n §7Online: §a" + Bukkit.getOnlinePlayers().size() + "\n          §7Made with §cLove §7by §aAsna §7and §aRelease          ");
    }
    //«»

    public void setAllPlayerTeam() {
        Bukkit.getOnlinePlayers().forEach(this::setPlayerTeam);
    }

    public void setPlayerTeam(Player player) {
        Scoreboard scoreboard = player.getScoreboard();
        Team spieler = scoreboard.getTeam("010spieler");
        if (spieler == null)
            spieler = scoreboard.registerNewTeam("010spieler");
        Team premium = scoreboard.getTeam("009premium");
        if (premium == null)
            premium = scoreboard.registerNewTeam("009premium");
        Team asna = scoreboard.getTeam("008asna");
        if (asna == null)
            asna = scoreboard.registerNewTeam("008asna");
        Team creator = scoreboard.getTeam("007creator");
        if (creator == null)
            creator = scoreboard.registerNewTeam("007creator");
        Team supporter = scoreboard.getTeam("006supporter");
        if (supporter == null)
            supporter = scoreboard.registerNewTeam("006supporter");
        Team builder = scoreboard.getTeam("005builder");
        if (builder == null)
            builder = scoreboard.registerNewTeam("005builder");
        Team moderator = scoreboard.getTeam("004moderator");
        if (moderator == null)
            moderator = scoreboard.registerNewTeam("004moderator");
        Team developer = scoreboard.getTeam("003developer");
        if (developer == null)
            developer = scoreboard.registerNewTeam("003developer");
        Team manager = scoreboard.getTeam("002manager");
        if (manager == null)
            manager = scoreboard.registerNewTeam("002manager");
        Team admin = scoreboard.getTeam("001admin");
        if (admin == null)
            admin = scoreboard.registerNewTeam("001admin");
        spieler.setPrefix("§aSpieler §8• §a");
                spieler.setColor(ChatColor.GREEN);
        premium.setPrefix("§6Premium §8• §6");
                premium.setColor(ChatColor.GOLD);
        asna.setPrefix("§fAsna §8• §f");
                asna.setColor(ChatColor.WHITE);
        creator.setPrefix("§5Social §8• §5");
                creator.setColor(ChatColor.DARK_RED);
        supporter.setPrefix("§9Supporter §8• §9");
                supporter.setColor(ChatColor.BLUE);
        builder.setPrefix("§2Builder §8• §9");
        builder.setColor(ChatColor.DARK_GREEN);
        moderator.setPrefix("§cModerator §8• §c");
                moderator.setColor(ChatColor.RED);
        developer.setPrefix("§bDeveloper §8• §b");
                developer.setColor(ChatColor.AQUA);
        manager.setPrefix("§eManager §8• §e");
        manager.setColor(ChatColor.YELLOW);
        admin.setPrefix("§4Admin §8• §4");
                admin.setColor(ChatColor.DARK_RED);
        for (Player target : Bukkit.getOnlinePlayers()) {
            if (target.hasPermission("system.admin")) {
                admin.addEntry(target.getName());
                continue;
            }
            if (target.hasPermission("system.manager")) {
                manager.addEntry(target.getName());
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

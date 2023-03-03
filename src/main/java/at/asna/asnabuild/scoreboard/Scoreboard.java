package at.asna.asnabuild.scoreboard;

import at.asna.asnabuild.Main;
import at.asna.asnabuild.jobs.JobCompletion;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Scoreboard extends ScoreboardBuilder {
    private int socialId;

    public Scoreboard(Player player) {
        super(player, "     §aAsna§fCode     ");
        run();

    }

    public Scoreboard(Player player, String displayName) {
        super(player, displayName);
    }

    public void createScoreboard() {
        this.setScore("§8", 12);
        this.setScore("§7✎ §8| §7Name§7:", 11);
        this.setScore("§7» §a" + this.player.getDisplayName(), 10);
        this.setScore("§e", 9);
        this.setScore("§7✣ §8| §7Rang§7:", 8);
        if (player.hasPermission("system.admin")){
            this.setScore("§7» §4Admin", 7);
        } else if (player.hasPermission("system.developer")) {
            this.setScore("§7» §bDeveloper", 7);
        } else if (player.hasPermission("system.moderator")) {
            this.setScore("§7» §cModerator", 7);
        } else if (player.hasPermission("system.builder")) {
            this.setScore("§7» §2Builder", 7);
        } else if (player.hasPermission("system.supporter")) {
            this.setScore("§7» §9Supporter", 7);
        } else if (player.hasPermission("system.creator")) {
            this.setScore("§7» §5Social", 7);
        } else if (player.hasPermission("system.asna")) {
            this.setScore("§7» §fAsna", 7);
        } else if (player.hasPermission("system.premium")) {
            this.setScore("§7» §6Premium", 7);
        } else {
            this.setScore("§7» §aSpieler", 7);
        }
        this.setScore("§m", 6);
        this.setScore("§7✉ §8| §7Guthaben§7:", 5);
        this.setScore("§7» §a" + Main.getCoinsAPI().getCoins(player.getUniqueId()) + "§a€", 4);
        this.setScore("§l", 3);
        this.setScore("§7✣ §8| §7Job§7:", 2);
        if (JobCompletion.getJob(player.getUniqueId()) == JobCompletion.Job.MINER){
            this.setScore("§7» §aMiner", 1);
        } else if (JobCompletion.getJob(player.getUniqueId()) == JobCompletion.Job.LUMBERJACK) {
            this.setScore("§7» §aHolzfäller", 1);
        } else {
            this.setScore("§7» §aArbeitslos", 1);
        }
        this.setScore("§b", 0);
    }

    @Override
    public void update() {



    }

    private void run(){
        new BukkitRunnable() {
            @Override
            public void run() {
                switch (Scoreboard.this.socialId){
                    case 0:
                    case 1:
                    case 2:
                        Scoreboard.this.setScore("§8", 12);
                        Scoreboard.this.setScore("§7✎ §8| §7Name§7:", 11);
                        Scoreboard.this.setScore("§e", 9);
                        Scoreboard.this.setScore("§7✣ §8| §7Rang§7:", 8);
                        if (player.hasPermission("system.admin")){
                            Scoreboard.this.setScore("§7» §4Admin", 7);
                        } else if (player.hasPermission("system.manager")) {
                            Scoreboard.this.setScore("§7» §eManager", 7);
                        } else if (player.hasPermission("system.developer")) {
                            Scoreboard.this.setScore("§7» §bDeveloper", 7);
                        } else if (player.hasPermission("system.moderator")) {
                            Scoreboard.this.setScore("§7» §cModerator", 7);
                        } else if (player.hasPermission("system.builder")) {
                            Scoreboard.this.setScore("§7» §2Builder", 7);
                        } else if (player.hasPermission("system.supporter")) {
                            Scoreboard.this.setScore("§7» §9Supporter", 7);
                        } else if (player.hasPermission("system.creator")) {
                            Scoreboard.this.setScore("§7» §5Social", 7);
                        } else if (player.hasPermission("system.asna")) {
                            Scoreboard.this.setScore("§7» §fAsna", 7);
                        } else if (player.hasPermission("system.premium")) {
                            Scoreboard.this.setScore("§7» §6Premium", 7);
                        } else {
                            Scoreboard.this.setScore("§7» §aSpieler", 7);
                        }
                        Scoreboard.this.setScore("§m", 6);
                        Scoreboard.this.setScore("§7✉ §8| §7Guthaben§7:", 5);
                        Scoreboard.this.setScore("§7» §a" + Main.getCoinsAPI().getCoins(player.getUniqueId()) + "§a€", 4);
                        Scoreboard.this.setScore("§l", 3);
                        Scoreboard.this.setScore("§7✣ §8| §7Job§7:", 2);
                        if (JobCompletion.getJob(player.getUniqueId()) == JobCompletion.Job.MINER){
                            Scoreboard.this.setScore("§7» §aMiner", 1);
                        } else if (JobCompletion.getJob(player.getUniqueId()) == JobCompletion.Job.LUMBERJACK) {
                            Scoreboard.this.setScore("§7» §aHolzfäller", 1);
                        } else {
                            Scoreboard.this.setScore("§7» §aArbeitslos", 1);
                        }
                        Scoreboard.this.setScore("§b", 0);
                        break;

                }
                Scoreboard.this.socialId++;
                if (Scoreboard.this.socialId >= 3){
                    Scoreboard.this.socialId = 0;
                }
            }
        }.runTaskTimer(Main.getInstance(), 20L, 20L);
    }



}

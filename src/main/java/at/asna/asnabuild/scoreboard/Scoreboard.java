package at.asna.asnabuild.scoreboard;

import at.asna.asnabuild.Main;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Scoreboard extends ScoreboardBuilder {
    private int socialId;

    public Scoreboard(Player player) {
        super(player, "     §6AsnaCode§7.§6de     ");
        run();

    }

    public Scoreboard(Player player, String displayName) {
        super(player, displayName);
    }

    public void createScoreboard() {
        this.setScore("§7§m------------------", 13);
        this.setScore("§8", 12);
        this.setScore("§7✣ §6Name§7:", 12);
        this.setScore("§7» §e" + this.player.getDisplayName(), 11);
        this.setScore("§e", 10);
        this.setScore("§7✣ §6Rang§7:", 9);
        if (player.hasPermission("system.admin")){
            this.setScore("§7» §4Admin", 8);
        } else if (player.hasPermission("system.developer")) {
            this.setScore("§7» §bDeveloper", 8);
        } else if (player.hasPermission("system.moderator")) {
            this.setScore("§7» §cModerator", 8);
        } else if (player.hasPermission("system.builder")) {
            this.setScore("§7» §2Builder", 8);
        } else if (player.hasPermission("system.supporter")) {
            this.setScore("§7» §9Supporter", 8);
        } else if (player.hasPermission("system.creator")) {
            this.setScore("§7» §5Social", 8);
        } else if (player.hasPermission("system.asna")) {
            this.setScore("§7» §fAsna", 8);
        } else if (player.hasPermission("system.premium")) {
            this.setScore("§7» §6Premium", 8);
        } else {
            this.setScore("§7» §eSpieler", 8);
        }
        this.setScore("§m", 7);
        this.setScore("§7✣ §6Geld§7:", 6);
        this.setScore("§7» §e" + Main.getCoinsAPI().getCoins(player.getUniqueId()), 5);
        this.setScore("§l", 4);
        this.setScore("§7✣ §6Discord§7:", 3);
        this.setScore("§7» §egn5BU3xZAc", 2);
        this.setScore("§b", 1);
        this.setScore("§7§m------------------", 0);
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
                        Scoreboard.this.setScore("§7§m------------------", 13);
                        Scoreboard.this.setScore("§8", 12);
                        Scoreboard.this.setScore("§7✣ §6Name§7:", 12);
                        Scoreboard.this.setScore("§e", 10);
                        Scoreboard.this.setScore("§7✣ §6Rang§7:", 9);
                        if (player.hasPermission("system.admin")){
                            Scoreboard.this.setScore("§7» §4Admin", 8);
                        } else if (player.hasPermission("system.developer")) {
                            Scoreboard.this.setScore("§7» §bDeveloper", 8);
                        } else if (player.hasPermission("system.moderator")) {
                            Scoreboard.this.setScore("§7» §cModerator", 8);
                        } else if (player.hasPermission("system.builder")) {
                            Scoreboard.this.setScore("§7» §2Builder", 8);
                        } else if (player.hasPermission("system.supporter")) {
                            Scoreboard.this.setScore("§7» §9Supporter", 8);
                        } else if (player.hasPermission("system.creator")) {
                            Scoreboard.this.setScore("§7» §5Social", 8);
                        } else if (player.hasPermission("system.asna")) {
                            Scoreboard.this.setScore("§7» §fAsna", 8);
                        } else if (player.hasPermission("system.premium")) {
                            Scoreboard.this.setScore("§7» §6Premium", 8);
                        } else {
                            Scoreboard.this.setScore("§7» §eSpieler", 8);
                        }
                        Scoreboard.this.setScore("§m", 7);
                        Scoreboard.this.setScore("§7✣ §6Geld§7:", 6);
                        Scoreboard.this.setScore("§7» §e" + Main.getCoinsAPI().getCoins(player.getUniqueId()) + "§e€", 5);
                        Scoreboard.this.setScore("§l", 4);
                        Scoreboard.this.setScore("§7✣ §6Discord§7:", 3);
                        Scoreboard.this.setScore("§7» §egn5BU3xZAc", 2);
                        Scoreboard.this.setScore("§b", 1);
                        Scoreboard.this.setScore("§7§m------------------", 0);
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

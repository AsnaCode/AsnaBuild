package at.asna.asnabuild.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public abstract class ScoreboardBuilder {
    protected final Scoreboard scoreboard;
    protected final Objective objective;
    protected final Player player;

    public ScoreboardBuilder(Player player, String displayName) {
        this.player = player;
        if (player.getScoreboard().equals(Bukkit.getScoreboardManager().getMainScoreboard())) {
            player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        }

        this.scoreboard = player.getScoreboard();
        if (this.scoreboard.getObjective("display") != null) {
            this.scoreboard.getObjective("display").unregister();
        }

        this.objective = this.scoreboard.registerNewObjective("display", "dummy", displayName);
        this.objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        this.createScoreboard();
    }

    public abstract void createScoreboard();

    public abstract void update();

    public void setDisplayName(String displayName) {
        this.objective.setDisplayName(displayName);
    }

    public void setScore(String content, int score) {
        Team team = this.getTeamByScore(score);
        if (team != null) {
            team.setPrefix(content);
            this.showScore(score);
        }
    }

    public void removeScore(int score) {
        this.hideScore(score);
    }

    private EntryName getEntryNameByScore(int score) {
        EntryName[] var2 = EntryName.values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            EntryName name = var2[var4];
            if (score == name.getEntry()) {
                return name;
            }
        }

        return null;
    }

    private Team getTeamByScore(int score) {
        EntryName name = this.getEntryNameByScore(score);
        if (name == null) {
            return null;
        } else {
            Team team = this.scoreboard.getEntryTeam(name.getEntryName());
            if (team != null) {
                return team;
            } else {
                team = this.scoreboard.registerNewTeam(name.name());
                team.addEntry(name.getEntryName());
                return team;
            }
        }
    }

    private void showScore(int score) {
        EntryName name = this.getEntryNameByScore(score);
        if (name != null) {
            if (!this.objective.getScore(name.getEntryName()).isScoreSet()) {
                this.objective.getScore(name.getEntryName()).setScore(score);
            }
        }
    }

    private void hideScore(int score) {
        EntryName name = this.getEntryNameByScore(score);
        if (name != null) {
            if (this.objective.getScore(name.getEntryName()).isScoreSet()) {
                this.scoreboard.resetScores(name.getEntryName());
            }
        }
    }
}